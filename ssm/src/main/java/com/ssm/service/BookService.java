package com.ssm.service;

import com.ssm.entity.PageResult;
import com.ssm.pojo.Book;

public interface BookService {
    //查询最新上架的图书
    PageResult selectNewBooks(Integer pageNum, Integer pageSize);

    Book findById(String id);


}
