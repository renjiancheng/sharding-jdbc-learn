package com.example.shardingjdbclearn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author jiancheng
 */
@Data
public class Customer {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String customerId;
    private String name;
}
