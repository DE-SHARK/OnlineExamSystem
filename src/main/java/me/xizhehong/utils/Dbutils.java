package me.xizhehong.utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Dbutils {
    //1.定义变量
    private Connection connection;
    private PreparedStatement pps;
    protected ResultSet resultSet;
    private int count;//存储收影响的行数
    private static String userName;
    private static String userPass;
    private static String url;
    private static String dirverName;

    protected  Connection getConnection(){
        try {
            connection=new Connection_jb().getConnections();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    //4.得到预状态通道
    protected  PreparedStatement getPps(String sql){
        try {
            pps = getConnection().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pps;
    }
    //5.绑定参数  List保存的是给占位符所赋的值
    protected  void param(List list){
        if(list!=null&&list.size()>0){
            for (int i=0;i<list.size();i++) {
                try {
                    pps.setObject(i+1,list.get(i));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    //6.执行操作(增删改+查询)
    protected  int  update(String sql,List list){
        getPps(sql);
        param(list);
        try {
            count= pps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    //7.查询
    protected  ResultSet query(String sql,List list){
        getPps(sql);
        param(list);
        try {
            resultSet= pps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    //8.关闭资源
    protected  void closeAll(){
        try {
            if (connection != null) {
                connection.close();
            }
            if (pps != null) {
                pps.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




}
