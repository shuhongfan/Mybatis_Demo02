import com.itheima.pojo.Student;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {
    /**
     * 根据学生姓名或职业查询学生信息列表
     */
    @Test
    public void findStudentByNameOrMajorTest() {
        // 通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // Student，封装需要组合查询的条件
        Student student = new Student();
//        student.setName("张三");
//        student.setMajor("英语");
        // 执行SqlSession的查询方法，返回结果集
        List<Student> students = session.selectList("com.itheima.mapper"
                + ".StudentMapper.findStudentByNameAndMajor", student);
        // 输出查询结果信息
        for (Student student2 : students) {
            // 打印输出结果
            System.out.println(student2);
        }
        // 关闭SqlSession
        session.close();
    }

    /**
     * 根据学生id批量查询学生信息
     */
    @Test
    public void findByListTest() {
        // 获取SqlSession
        SqlSession session = MyBatisUtils.getSession();
        // 创建List集合，封装查询id
        List<Integer> ids = new ArrayList<Integer>();
        // 将小于5的id值放入list中
        for (int i = 1; i < 5; i++) {
            ids.add(i);
        }
        // 执行SqlSession的查询方法，返回结果集
        List<Student> students = session.selectList("com.itheima.mapper"
                + ".StudentMapper.findByList", ids);
        // 输出查询结果信息
        for (Student student : students) {
            // 打印输出结果
            System.out.println(student);
        }
        // 关闭SqlSession
        session.close();
    }


}
