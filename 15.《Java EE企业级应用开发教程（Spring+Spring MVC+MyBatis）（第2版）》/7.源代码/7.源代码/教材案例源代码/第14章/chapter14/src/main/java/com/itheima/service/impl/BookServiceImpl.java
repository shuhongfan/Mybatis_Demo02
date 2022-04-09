package com.itheima.service.impl;

import com.itheima.dao.BookMapper;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public Book findBookById(Integer id) {
        return bookMapper.findBookById(id);
    }
}

