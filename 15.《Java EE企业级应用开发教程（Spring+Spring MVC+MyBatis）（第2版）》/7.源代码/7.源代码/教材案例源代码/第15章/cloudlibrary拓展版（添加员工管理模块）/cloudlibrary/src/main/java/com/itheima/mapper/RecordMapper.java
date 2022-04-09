package com.itheima.mapper;
import com.github.pagehelper.Page;
import com.itheima.domain.Record;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface RecordMapper {
//新增借阅记录
Integer addRecord(Record record);
@Select({"<script>" +
        "SELECT * FROM record " +
        "where 1=1" +
        "<if test=\"borrower != null\">AND record_borrower like  CONCAT('%',#{borrower},'%')</if>" +
        "<if test=\"bookname != null\">AND record_bookname  like  CONCAT('%',#{bookname},'%') </if>" +
        "order by record_remandtime DESC" +
        "</script>"
})
@Results(id = "recordMap",value = {
        //id字段默认为false，表示不是主键
        //column表示数据库表字段，property表示实体类属性名。
        @Result(id = true,column = "record_id",property = "id"),
        @Result(column = "record_bookname",property = "bookname"),
        @Result(column = "record_bookisbn",property = "bookisbn"),
        @Result(column = "record_borrower",property = "borrower"),
        @Result(column = "record_borrowtime",property = "borrowTime"),
        @Result(column = "record_remandtime",property = "remandTime")
})
//查询借阅记录
Page<Record> searchRecords(Record record);
}
