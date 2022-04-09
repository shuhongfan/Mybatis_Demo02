package com.itheima.dao;

import com.itheima.pojo.Worker;
import org.apache.ibatis.annotations.*;

public interface WorkerMapper {
    @Select("select * from tb_worker where id = #{id}")
    Worker selectWorker(int id);

    @Insert("insert into tb_worker(name,age,sex,worker_id)"
            +"values(#{name},#{age},#{sex},#{worker_id})")
    int insertWorker(Worker worker);

    @Update("update tb_worker set name = #{name},age = #{age} "
            +"where id = #{id}")
    int updateWorker(Worker worker);

    @Delete("delete from tb_worker where id = #{id}")
    int deleteWorker(int id);

    @Select("select * from tb_worker where id = #{param01} " +
            "and name = #{param02}")
            Worker selectWorkerByIdAndName(@Param("param01") int id,
            @Param("param02") String name);

}

