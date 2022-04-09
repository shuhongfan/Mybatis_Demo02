package com.itheima.mapper;
import com.github.pagehelper.Page;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.*;
/**
 * 图书接口
 */
public interface BookMapper {
    @Select("SELECT * FROM book where book_status !='3' order by book_uploadtime DESC")
    @Results(id = "bookMap",value = {
            //id字段默认为false，表示不是主键
            //column表示数据库表字段，property表示实体类属性名。
            @Result(id = true,column = "book_id",property = "id"),
            @Result(column = "book_name",property = "name"),
            @Result(column = "book_isbn",property = "isbn"),
            @Result(column = "book_press",property = "press"),
            @Result(column = "book_author",property = "author"),
            @Result(column = "book_pagination",property = "pagination"),
            @Result(column = "book_price",property = "price"),
            @Result(column = "book_uploadtime",property = "uploadTime"),
            @Result(column = "book_status",property = "status"),
            @Result(column = "book_borrower",property = "borrower"),
            @Result(column = "book_borrowtime",property = "borrowTime"),
            @Result(column = "book_returntime",property = "returnTime")
    })
    Page<Book> selectNewBooks();


@Select("SELECT * FROM book where book_id=#{id}")
@ResultMap("bookMap")
//根据id查询图书信息
Book findById(String id);

    @Select({"<script>" +
            "SELECT * FROM book " +
            "where book_status !='3'" +
            "<if test=\"name != null\"> AND  book_name  like  CONCAT('%',#{name},'%')</if>" +
            "<if test=\"press != null\"> AND book_press like  CONCAT('%', #{press},'%') </if>" +
            "<if test=\"author != null\"> AND book_author like  CONCAT('%', #{author},'%')</if>" +
            "order by book_borrowtime" +
            "</script>"
    })
    @ResultMap("bookMap")
    //分页查询图书
    Page<Book> searchBooks(Book book);
    //新增图书
    Integer addBook(Book book);
//编辑图书信息
    Integer editBook(Book book);


@Select(
        {"<script>" +
                "SELECT * FROM book " +
                "where book_borrower=#{borrower}" +
                "AND book_status ='1'"+
                "<if test=\"name != null\"> AND  book_name  like  CONCAT('%',#{name},'%')</if>" +
                "<if test=\"press != null\"> AND book_press like  CONCAT('%', #{press},'%') </if>" +
                "<if test=\"author != null\"> AND book_author like  CONCAT('%', #{author},'%')</if>" +
                "or book_status ='2'"+
                "<if test=\"name != null\"> AND  book_name  like  CONCAT('%',#{name},'%')</if>" +
                "<if test=\"press != null\"> AND book_press like  CONCAT('%', #{press},'%') </if>" +
                "<if test=\"author != null\"> AND book_author like  CONCAT('%', #{author},'%')</if>" +
                "order by book_borrowtime" +
                "</script>"})
@ResultMap("bookMap")
//查询借阅但未归还的图书和待归还确认的图书
Page<Book> selectBorrowed(Book book);

@Select({"<script>"  +
        "SELECT * FROM book " +
        "where book_borrower=#{borrower}" +
        "AND book_status in('1','2')"+
        "<if test=\"name != null\"> AND  book_name  like  CONCAT('%',#{name},'%')</if>" +
        "<if test=\"press != null\"> AND book_press like  CONCAT('%', #{press},'%') </if>" +
        "<if test=\"author != null\"> AND book_author like  CONCAT('%', #{author},'%')</if>" +
        "order by book_borrowtime" +
        "</script>"})
@ResultMap("bookMap")
//查询借阅但未归还的图书
Page<Book> selectMyBorrowed(Book book);

}
