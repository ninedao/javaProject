package com.lzc.thinkingInJava.annotaions.databases;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        args=new String[]{
                "com.lzc.thinkingInJava.annotaions.databases.Member"
        };
        for(String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annntations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            if(tableName.length() < 1){
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<String>();
            for(Field field : cl.getDeclaredFields()){
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if(anns.length < 1){
                    continue;
                }
                if(anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if(sInt.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else{
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }
                if(anns[0] instanceof SQLString){
                    SQLString sString = (SQLString) anns[0];
                    if(sString.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else{
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
                }
                if(anns[0] instanceof SQLCharacter){
                    SQLCharacter sqlCharacter = (SQLCharacter) anns[0];
                    if(sqlCharacter.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else{
                        columnName = sqlCharacter.name();
                    }
                    columnDefs.add(columnName + " CHARACTER(" + sqlCharacter.value() + ")" + getConstraints(sqlCharacter.constraints()));
                }
                if(anns[0] instanceof SQLBoolean){
                    SQLBoolean sqlBoolean = (SQLBoolean) anns[0];
                    if(sqlBoolean.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else{
                        columnName = sqlBoolean.name();
                    }
                    columnDefs.add(columnName + " BOOLEAN" + getConstraints(sqlBoolean.constraints()));
                }
            }
            StringBuilder sb = new StringBuilder("CREATE TABLE " + tableName + "(");
            for(String s : columnDefs) {
                sb.append("\n   " + s +",");
            }
            String string = sb.substring(0, sb.length() - 1) +");";

            String URL="jdbc:mysql://192.168.0.109:3306/test?useUnicode=true&characterEncoding=utf-8";
            String USER="liuzhichen";
            String PASSWORD="Lzc123456!";
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获得数据库链接
            Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            Statement st=conn.createStatement();
            st.execute(string);
            //4.处理数据库的返回结果(使用ResultSet类)

            st.close();
            conn.close();
            System.out.println("Table Creation SQL for" + tableName + " is :\n" + string);
        }
    }
    public static String getConstraints(Constraints constraints){
        StringBuilder str = new StringBuilder();
        if(!constraints.allowNull()){
            str.append(" NOT NULL");
        }
        if(constraints.primaryKey()){
            str.append(" PRIMARY KEY");
        }
        if(constraints.unique()){
            str.append(" UNIQUE");
        }
        return str.toString();
    }
}
