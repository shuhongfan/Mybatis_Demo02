package Test;

import com.itheima.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyBatisTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init() {
        //定义读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try {
            //读取mybatis-config.xml文件到reader对象中
            reader = Resources.getResourceAsReader(resources);
            //初始化mybatis,创建SqlSessionFactory类的对象
            SqlSessionFactory sqlMapper = new
                    SqlSessionFactoryBuilder().build(reader);
            //创建session对象
            sqlSession = sqlMapper.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllStudentTest() {
        // SqlSession执行映射文件中定义的SQL，并返回映射结果
        List<Student> list =
                sqlSession.selectList("com.itheima.mapper.StudentMapper." +
                        "findAllStudent");
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @After
    public void destory() {
        //提交事务
        sqlSession.commit();
        //关闭事务
        sqlSession.close();
    }
}

