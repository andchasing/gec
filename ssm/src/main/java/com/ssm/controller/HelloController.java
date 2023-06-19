package com.ssm.controller;

import com.ssm.pojo.Staff;
import com.ssm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    StaffService staffService;
    @RequestMapping("/hello")
    public void hello () {
        List<Staff> list = staffService.getStaffs();
        list.forEach(System.out::println);
    }
}
