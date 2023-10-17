package com.example.shardingjdbclearn.web;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.shardingjdbclearn.domain.Customer;
import com.example.shardingjdbclearn.domain.User;
import com.example.shardingjdbclearn.mapper.CustomerMapper;
import com.example.shardingjdbclearn.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author jiancheng
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping("register")
    @Transactional(rollbackFor = Exception.class)
    public boolean register(@RequestBody User user) {
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
        Long cspId = user.getCspId();
        log.info("csp{}注册成功，开始动态建表", cspId);
        customerMapper.createTable(cspId);
        return true;
    }


    @PostMapping("{cspId}/add")
    public Customer addUser(@PathVariable String cspId, @RequestBody Customer req) {
        Customer customer = new Customer();
        customer.setName(req.getName());
        //3+3六位
        customer.setCustomerId(cspId + RandomUtils.nextInt(100, 999));
        customerMapper.insert(customer);
        return customer;
    }

    @PostMapping("/customer/{customerId}")
    public Customer getUser(@PathVariable Long customerId) {
        return customerMapper.selectOne(Wrappers.lambdaQuery(Customer.class).eq(Customer::getCustomerId, customerId));
    }
}
