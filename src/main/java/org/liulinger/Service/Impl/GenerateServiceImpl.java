package org.liulinger.Service.Impl;

import com.iteye.weimingtom.namegen.NameGen;
import jakarta.servlet.ServletContext;
import org.liulinger.Bean.UserBean;
import org.liulinger.Dao.UserDao;

public class GenerateServiceImpl implements org.liulinger.Service.GenerateService {

    private String successMessage;  // 成功消息字段

    private int permission;

    private static NameGen nameGen;

    private final UserDao userDao;

    public GenerateServiceImpl(UserDao user, ServletContext context) {
        this.userDao = user;
        nameGen = new NameGen(context);  // 传递 ServletContext 对象给 NameGen 构造函数
    }

    @Override
    public void doGenerate(String uidStart, int numbers, int permission) {

        this.permission = permission;

        for (int i = 0; i < numbers; i++) {
            UserBean randomUser = generateStudent(uidStart);
            // 调用 UserDao 添加用户
            userDao.addUser(randomUser);
            // 学号自增
            uidStart = String.valueOf(Integer.parseInt(uidStart) + 1);
            // 设置成功消息
            if (permission == 1) {
                successMessage = "成功添加 " + numbers + " 个学生！";
            } else {
                successMessage = "成功添加 " + numbers + " 个教师！";
            }
        }

    }

    @Override
    public String getSuccessMessage() {
        return successMessage;
    }

    public UserBean generateStudent(String uidStart) {
        UserBean user = new UserBean();

        // 获取最后六位数字
        String password = getLastSixDigits(uidStart);

        // 随机生成姓名和性别
        String name = nameGen.getName();
        String sex = nameGen.getSex(name);

        // 为每个字段生成随机值
        user.setUid(uidStart);
        user.setUsername(name);
        user.setPassword(password);
        user.setPermission(this.permission);
        user.setSex(sex);

        return user;
    }

    // 获取最后六位数字的方法
    private static String getLastSixDigits(String originalString) {
        if (originalString.length() >= 6) {
            return originalString.substring(originalString.length() - 6);
        } else {
            // 如果字符串长度不足六位，你可以根据需求决定如何处理
            return originalString;
        }
    }
}
