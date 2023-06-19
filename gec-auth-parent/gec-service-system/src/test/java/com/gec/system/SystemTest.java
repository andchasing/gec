package com.gec.system;

import com.gec.model.system.SysRole;
import com.gec.system.mapper.SysRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author:gec
 * @Date:2023/6/15
 * @Description:code4
 * @version:1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class SystemTest {

        @Autowired
        private SysRoleMapper sysRoleMapper;

        @Test
        public void query1(){
            List<SysRole> list = sysRoleMapper.selectList(null);
            //lambda表达式
            list.forEach(s->System.out.println(s));
            //lambda表达式中的方法的引用
            //list.forEach(System.out::println);

            //普通的迭代器，增强for循环
//            for(SysRole role:list){
//                System.out.println(role);
//            }
        }


    @Test
    public void vo(){
    }
}

