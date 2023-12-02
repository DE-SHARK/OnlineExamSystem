package me.deshark;//package me.deshark;
//
//import me.deshark.bean.UserBean;
//import me.deshark.dao.UserDao;
//import me.deshark.dao.impl.UserDaoImpl;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Random;
//
//public class RandomUserGenerator {
//
//    private static final String[] SEXES = {"男", "女"};
//
//    public static UserBean generateRandomUser(int uidStart) {
//        UserBean user = new UserBean();
//
//        // 生成学号
//        user.setUid(Integer.toString(uidStart));
//
//
//        // Generate random values for each field
//        user.setUsername(generateRandomString(8));
//        user.setPassword(generateRandomString(6));
//        user.setEmail(generateRandomEmail());
//        user.setSex(getRandomSex());
//        user.setRegister_at(getCurrentDateTime());
//
//        return user;
//    }
//
//    private static String generateRandomString(int length) {
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        StringBuilder randomString = new StringBuilder();
//        Random random = new Random();
//
//        for (int i = 0; i < length; i++) {
//            randomString.append(characters.charAt(random.nextInt(characters.length())));
//        }
//
//        return randomString.toString();
//    }
//
//    private static String generateRandomEmail() {
//        return generateRandomString(8) + "@example.com";
//    }
//
//    private static String getRandomSex() {
//        Random random = new Random();
//        return SEXES[random.nextInt(SEXES.length)];
//    }
//
//    private static String generateRandomDateString() {
//        // You can implement a logic to generate a random date string here
//        // For simplicity, let's use a placeholder
//        return "2023-12-02";
//    }
//
//    private static String getCurrentDateTime() {
//        // 获取当前系统时间
//        LocalDateTime currentDateTime = LocalDateTime.now();
//
//        // 定义日期时间格式
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        // 输出格式化后的字符串
//        return currentDateTime.format(formatter);
//    }
//
//    public static void main(String[] args) {
//        int uidStart = 2100502100;
//        int amount = 68;
//
//        for (int i = 0; i < amount; i++) {
//            UserBean randomUser = generateRandomUser(uidStart);
//            UserDao userDao = new UserDaoImpl();
//            userDao.addUser(randomUser);
//            System.out.printf("学号 " + uidStart + " 已添加");
//            uidStart++;
//        }
////        UserBean user = generateRandomUser(uidStart);
////
////        System.out.println(user);
//    }
//}
