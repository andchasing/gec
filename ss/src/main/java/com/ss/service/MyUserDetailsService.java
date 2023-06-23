package com.ss.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ss.mapper.EmployeeMapper;
import com.ss.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<GrantedAuthority> auths =
//                AuthorityUtils.commaSeparatedStringToAuthorityList("role1");
//        //从查询数据库返回users对象，得到用户名和密码，返回
//        return new User("tom",
//                new BCryptPasswordEncoder().encode("123"),auths);


        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>();
        queryWrapper.eq("username", username);

        // 根据username 去数据库查询用户
        Employee employee = this.employeeMapper.selectOne(queryWrapper);

        // 用户没找到
        if (employee==null){
            throw new RuntimeException("用户不存在异常..");
        }

        // 用户授权
        // 注意这里必须要和  hasAuthority 方法中配置的保持一致,superadmin与下面superadmin1不一致是，即使登录成功也无权访问
        List<GrantedAuthority> roles =
                 // AuthorityUtils.commaSeparatedStringToAuthorityList("superadmin1");
                AuthorityUtils.commaSeparatedStringToAuthorityList("superadmin");
                // AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_boss");
          // single
        return new User(employee.getUsername(),
                new BCryptPasswordEncoder().encode(employee.getPassword()),roles);

//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//
//
//        // 将数据库的明文密码进行加密
//        String passwordWithbCry = bCryptPasswordEncoder.encode(employee.getPassword());
//
//        //  User(String username, String password, Collection<? extends GrantedAuthority> authorities)
//
//        List<GrantedAuthority> roles = AuthorityUtils.commaSeparatedStringToAuthorityList("roles");
//
//        // 注意这里的User是security.core.userdetails.User包下的User
//        User user = new User(employee.getUsername(), passwordWithbCry, roles);
//
//        return user;


    }
}
