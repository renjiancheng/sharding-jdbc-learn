package com.example.shardingjdbclearn;

import com.baomidou.mybatisplus.extension.toolkit.SqlRunner;
import com.example.shardingjdbclearn.domain.User;
import com.example.shardingjdbclearn.mapper.UserMapper;
import com.google.errorprone.annotations.Var;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
class ShardingJdbcLearnApplicationTests {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    void contextLoads() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(false)) {
            Connection connection = sqlSession.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("");
            sqlSession.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
