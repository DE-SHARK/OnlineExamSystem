package me.xizhehong.Service;

import me.xizhehong.Dao.RegisterDao;
import me.xizhehong.Dao.RegisterDao_impl;

import java.util.regex.Pattern;

public class RegisterService_impl implements RegisterService {

    RegisterDao registerDao = new RegisterDao_impl();


    //将注册的用户写入数据库中
    public void Register(String username, String password, String if_login) {
        registerDao.Register(username, password, if_login);
    }

    //验证用户名是否重复
    public String Username_repeat(String username) {
        return registerDao.username_repeat(username);
    }

    //验证账户是否合法
    public String Count_Legality(String username, String password, String password1) {
        String answer = registerDao.username_repeat(username);
        if ("yes".equals(answer)) {
            String whitelistPattern = "^[a-zA-Z0-9_]+$";
            if (Pattern.matches(whitelistPattern, username) && Pattern.matches(whitelistPattern, password)) {
                if (!username.isEmpty() && !password.isEmpty() && !password1.isEmpty()) {
                    if (password.equals(password1)) {
                        answer = "注册成功";
                    } else {
                        answer = "两次密码不同";
                      }
                } else {
                    answer = "用户名或密码不能为空";
                  }
            }
            else {
                answer = "账号或密码格式错误,只允许字母（大小写）、数字和下划线";
            }
        }
        else {
            answer = "用户名重复";
        }
        return answer;
    }
}
