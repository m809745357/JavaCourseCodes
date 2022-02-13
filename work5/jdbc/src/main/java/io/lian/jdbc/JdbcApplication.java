package io.lian.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class JdbcApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //SpringApplication.run(JdbcApplication.class, args);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/schools", "root", "root");

        // 查询
        PreparedStatement query = connection.prepareStatement("select * from students");
        query.executeQuery();

        // 增加
        PreparedStatement insert = connection.prepareStatement("insert into students values(?, ?, ?)");
        insert.setInt(1, 1);
        insert.setString(2, "沈益飞");
        insert.setInt(3, 28);
        insert.execute();

        // 删除
        PreparedStatement delete = connection.prepareStatement("delete from students where stuNo = ?");
        delete.setInt(1, 1);
        delete.execute();


        // 更新
        PreparedStatement update = connection.prepareStatement("update students set stuName = ?, stuAge = ? where stuNo = ?");
        update.setInt(3, 1);
        update.setString(1, "沈益飞");
        update.setInt(2, 28);
        update.execute();
    }

}
