package com.mp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.mapper.StaffMapper;
import com.mp.mapper.UserMapper;
import com.mp.pojo.Stu;
import com.mp.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MpApplication.class)
class MpApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    StaffMapper staffMapper;
    @Test
    void contextLoads() {
        (userMapper.selectList(null)).forEach(System.out::print);
//        (staffMapper.selectList(null)).forEach(System.out::print);
    }
    @Test
    public void getById () {
        System.out.println(userMapper.selectById(1));
    }

    @Test
    public void insert(){
        User user = new User();
        user.setName("lisi");
        user.setAge(20);
        user.setEmail("lisi@163.com");
        user.setId(6L);
        System.out.println(userMapper.insert(user));
    }

    @Test
    public void delete(){
        System.out.println(userMapper.deleteById(6));
    }

    @Test
    public void update(){}

    @Test
    public void queryWrapper(){
        Stu stu = new Stu(1L,"",1,"");
    }

    @Test
    public void pageTest(){
        Page<User> userPage = new Page<>(1, 2);
        IPage<User> page = userMapper.selectPage(userPage,null);
        List<User> users = page.getRecords();
        users.forEach(System.out::println);
    }


}
