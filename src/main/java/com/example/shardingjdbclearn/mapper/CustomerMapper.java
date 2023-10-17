package com.example.shardingjdbclearn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingjdbclearn.domain.Customer;
import org.apache.ibatis.annotations.Update;

/**
 * @author jiancheng
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    @Update("create table customer_${cspId} like customer")
    void createTable(Long cspId);
}
