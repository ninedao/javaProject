package com.lzc.spring5.transaction.dao;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.mysql.cj.xdevapi.PreparableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private DataSource druidDataSource;
    @Override
    public void addMoney() {
        String sql = "update t_account set money = money - ? where username=? ";

        try(Connection c = druidDataSource.getConnection()) {

            PreparedStatement p = c.prepareStatement(sql);
            p.setObject(1,100);
            p.setObject(2,"Lucy");
            p.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void reduceMoney() {
        String sql = "update t_account set money = money + ? where username=? ";
        try (Connection c = druidDataSource.getConnection()){
            PreparedStatement p = c.prepareStatement(sql);
            p.setObject(1,100);
            p.setObject(2,"Mary");
            p.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
