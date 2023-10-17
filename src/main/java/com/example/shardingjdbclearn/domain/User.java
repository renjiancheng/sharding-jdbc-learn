package com.example.shardingjdbclearn.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author jiancheng
 */
@Data
@TableName("user")
public class User {
    private Long id;
    private Long cspId;
    private String name;
    private Integer age;
    private LocalDateTime createTime;
}
