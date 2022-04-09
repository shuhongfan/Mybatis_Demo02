package com.itheima.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.domain.Book;
import com.itheima.domain.Record;
import com.itheima.domain.User;
import com.itheima.mapper.BookMapper;
import com.itheima.service.BookService;
import com.itheima.service.RecordService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 根据当前页码和每页需要展示的数据条数，查询最新上架的图书信息
     * @param pageNum 当前页码
     * @param pageSize 每页显示数量
     */
    @Override
    public PageResult selectNewBooks(Integer pageNum, Integer pageSize) {
        // 设置分页查询的参数，开始分页
        PageHelper.startPage(pageNum, pageSize);
        Page<Book> page=bookMapper.selectNewBooks();
        return new PageResult(page.getTotal(),page.getResult());
    }
/**
 * 根据id查询图书信息
 * @param id 图书id
 */
public Book findById(String id) {
    return bookMapper.findById(id);
}

/**
 * 借阅图书
 * @param book
 * @return
 */
@Override
public Integer borrowBook(Book book) {
    //根据id查询出需要借阅的完整图书信息
    Book b = this.findById(book.getId()+"");
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //设置当天为借阅时间
    book.setBorrowTime(dateFormat.format(new Date()));
    //设置所借阅的图书状态为借阅中
    book.setStatus("1");
    //将图书的价格设置在book对象中
    book.setPrice(b.getPrice());
    //将图书的上架设置在book对象中
    book.setUploadTime(b.getUploadTime());
    return bookMapper.editBook(book);
}

/**
 * @param book 封装查询条件的对象
 * @param pageNum 当前页码
 * @param pageSize 每页显示数量
 */
@Override
public PageResult search(Book book, Integer pageNum, Integer pageSize) {
    // 设置分页查询的参数，开始分页
    PageHelper.startPage(pageNum, pageSize);
    Page<Book> page=bookMapper.searchBooks(book);
    return new PageResult(page.getTotal(),page.getResult());
}

/**
 * 新增图书
 * @param book 页面提交的新增图书信息
 */
public Integer addBook(Book book) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //设置新增图书的上架时间
    book.setUploadTime(dateFormat.format(new Date()));
    return  bookMapper.addBook(book);
}

/**
 * 编辑图书信息
 * @param book 图书信息
 */
public Integer editBook(Book book) {
    return bookMapper.editBook(book);
}

/**
 * 查询用户当前借阅的图书
 * @param book 封装查询条件的对象
 * @param user 当前登录用户
 * @param pageNum 当前页码
 * @param pageSize 每页显示数量
 */
@Override
public PageResult searchBorrowed(Book book, User user, Integer pageNum, Integer pageSize) {
    // 设置分页查询的参数，开始分页
    PageHelper.startPage(pageNum, pageSize);
    Page<Book> page;
    //将当前登录的用户放入查询条件中
    book.setBorrower(user.getName());
    //如果是管理员，查询自己借阅但未归还的图书和所有待确认归还的图书
    if("ADMIN".equals(user.getRole())){
        page= bookMapper.selectBorrowed(book);
    }else {
        //如果是普通用户，查询自己借阅但未归还的图书
        page= bookMapper.selectMyBorrowed(book);
    }
    return new PageResult(page.getTotal(),page.getResult());
}

/**
 * 归还图书
 * @param id 归还的图书的id
 * @param user 归还的人员，也就是当前图书的借阅者
 */
@Override
public boolean returnBook(String id,User user) {
    //根据图书id查询出图书的完整信息
    Book book = this.findById(id);
    //再次核验当前登录人员和图书借阅者是不是同一个人
    boolean rb=book.getBorrower().equals(user.getName());
    //如果是同一个人，允许归还
    if(rb){
        //将图书借阅状态修改为归还中
        book.setStatus("2");
        bookMapper.editBook(book);
    }
    return rb;
}
@Autowired
//注入RecordService对象
private RecordService recordService;
/**
 * 归还确认
 * @param id 待归还确认的图书id
 */
@Override
public Integer returnConfirm(String id) {
    //根据图书id查询图书的完整信息
    Book book = this.findById(id);
    //根据归还确认的图书信息，设置借阅记录
    Record record = this.setRecord(book);
    //将图书的借阅状态修改为可借阅
    book.setStatus("0");
    //清除当前图书的借阅人信息
    book.setBorrower("");
    //清除当前图书的借阅时间信息
    book.setBorrowTime("");
    //清除当亲图书的预计归还时间信息
    book.setReturnTime("");
    Integer count= bookMapper.editBook(book);
    //如果归还确认成功，则新增借阅记录
    if(count==1){
        return  recordService.addRecord(record);
    }
    return 0;
}
/**
 * 根据图书信息设置借阅记录的信息
 * @param book 借阅的图书信息
 */
private Record setRecord(Book book){
    Record record=new Record();
    //设置借阅记录的图书名称
    record.setBookname(book.getName());
    //设置借阅记录的图书isbn
    record.setBookisbn(book.getIsbn());
    //设置借阅记录的借阅人
    record.setBorrower(book.getBorrower());
    //设置借阅记录的借阅时间
    record.setBorrowTime(book.getBorrowTime());
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //设置图书归还确认的当天为图书归还时间
    record.setRemandTime(dateFormat.format(new Date()));
    return record;
}
}
