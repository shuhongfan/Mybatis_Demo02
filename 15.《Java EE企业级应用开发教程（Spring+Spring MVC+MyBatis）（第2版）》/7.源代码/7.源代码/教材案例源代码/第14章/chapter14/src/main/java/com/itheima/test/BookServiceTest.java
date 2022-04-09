package com.itheima.test;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-service.xml",
        "classpath:application-dao.xml"})
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    public void findBookById() {
        Book book = bookService.findBookById(1);
        System.out.println("图书id:" + book.getId());
        System.out.println("图书名称:" + book.getName());
        System.out.println("作者:" + book.getAuthor());
        System.out.println("出版社:" + book.getPress());
    }
}

