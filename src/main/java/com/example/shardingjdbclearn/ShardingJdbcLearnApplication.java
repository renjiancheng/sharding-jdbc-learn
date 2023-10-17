package com.example.shardingjdbclearn;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages = "com.example.shardingjdbclearn.mapper")
public class ShardingJdbcLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcLearnApplication.class, args);
    }


}
