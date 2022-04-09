package Test;

import com.itheima.pojo.*;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据客户姓名和职业组合条件查询客户信息列表
     */
    @Test
    public void findCustomerByNameAndJobsTest() {
        // 通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 创建Customer对象，封装需要组合查询的条件
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        // 执行SqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("com.itheima.mapper"
                + ".CustomerMapper.findCustomerByNameAndJobs", customer);
        // 输出查询结果信息
        for (Customer customer2 : customers) {
            // 打印输出结果
            System.out.println(customer2);
        }
        // 关闭SqlSession
        session.close();
    }

    /**
     * 根据客户姓名或职业查询客户信息列表
     */
    @Test
    public void findCustomerByNameOrJobsTest() {
        // 通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 创建Customer对象，封装需要组合查询的条件
        Customer customer = new Customer();
//        customer.setUsername("tom");
//        customer.setJobs("teacher");
        // 执行SqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("com.itheima.mapper"
                + ".CustomerMapper.findCustomerByNameOrJobs", customer);
        // 输出查询结果信息
        for (Customer customer2 : customers) {
            // 打印输出结果
            System.out.println(customer2);
        }
        // 关闭SqlSession
        session.close();
    }

    /**
     * 更新客户信息
     */
    @Test
    public void updateCustomerBySetTest() {
        // 获取SqlSession
        SqlSession sqlSession = MyBatisUtils.getSession();
        // 创建Customer对象，并向对象中添加数据
        Customer customer = new Customer();
        customer.setId(3);
        customer.setPhone("13311111234");
        // 执行SqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = sqlSession.update("com.itheima.mapper"
                + ".CustomerMapper.updateCustomerBySet", customer);
        // 通过返回结果判断更新操作是否执行成功
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！！！");
        }
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }

    /**
     * 更新客户信息
     */
    @Test
    public void updateCustomerByTrimTest() {
        // 获取SqlSession
        SqlSession sqlSession = MyBatisUtils.getSession();
        // 创建Customer对象，并向对象中添加数据
        Customer customer = new Customer();
        customer.setId(3);
        customer.setPhone("13311111111");
        // 执行SqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = sqlSession.update("com.itheima.mapper"
                + ".CustomerMapper.updateCustomerByTrim", customer);
        // 通过返回结果判断更新操作是否执行成功
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！！！");
        }
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }

    /**
     * 根据客户id批量查询客户信息
     */
    @Test
    public void findByArrayTest() {
        // 获取SqlSession
        SqlSession session = MyBatisUtils.getSession();
        // 创建数组，封装查询id
        Integer[] roleIds = {2, 3};
        // 执行SqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("com.itheima.mapper"
                + ".CustomerMapper.findByArray", roleIds);
        // 输出查询结果信息
        for (Customer customer : customers) {
            // 打印输出结果
            System.out.println(customer);
        }
        // 关闭SqlSession
        session.close();
    }

    /**
     * 根据客户id批量查询客户信息
     */
    @Test
    public void findByListTest() {
        // 获取SqlSession
        SqlSession session = MyBatisUtils.getSession();
        // 创建List集合，封装查询id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        // 执行SqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("com.itheima.mapper"
                + ".CustomerMapper.findByList", ids);
        // 输出查询结果信息
        for (Customer customer : customers) {
            // 打印输出结果
            System.out.println(customer);
        }
        // 关闭SqlSession
        session.close();
    }

    /**
     * 根据客户id批量查询客户信息
     */
    @Test
    public void findByMapTest() {
        // 获取SqlSession
        SqlSession session = MyBatisUtils.getSession();
        // 创建List集合，封装查询id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        Map<String, Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("id", ids);
        conditionMap.put("jobs", "teacher");
        // 执行SqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("com.itheima.mapper"
                + ".CustomerMapper.findByMap", conditionMap);
        // 输出查询结果信息
        for (Customer customer : customers) {
            // 打印输出结果
            System.out.println(customer);
        }
        // 关闭SqlSession
        session.close();
    }

    /**
     * 嵌套查询
     */
    @Test
    public void findPersonByIdTest() {
        // 1、通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 2.使用MyBatis嵌套查询的方式查询id为1的人的信息
        Person person = session.selectOne("com.itheima.mapper."
                + "PersonMapper.findPersonById", 1);
        // 3、输出查询结果信息
        System.out.println(person);
        // 4、关闭SqlSession
        session.close();
    }

    /**
     * 嵌套结果
     */
    @Test
    public void findPersonByIdTest2() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 2.使用MyBatis嵌套结果的方法查询id为1的人员信息
        Person person = session.selectOne("com.itheima.mapper."
                + "PersonMapper.findPersonById2", 1);
        // 3.输出查询结果信息
        System.out.println(person);
        // 4.关闭SqlSession
        session.close();
    }

    /**
     * 一对多
     */
    @Test
    public void findUserTest() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 2.查询id为1的用户信息
        Users users = session.selectOne("com.itheima.mapper."
                + "UsersMapper.findUserWithOrders", 1);
        // 3.输出查询结果信息
        System.out.println(users);
        // 4.关闭SqlSession
        session.close();
    }

    /**
     * 多对多
     */
    @Test
    public void findOrdersTest() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 2.查询id为1的订单中的商品信息
        Orders orders = session.selectOne("com.itheima.mapper."
                + "OrdersMapper.findOrdersWithPorduct", 1);
        // 3.输出查询结果信息
        System.out.println(orders);
        // 4.关闭SqlSession
        session.close();
    }

    /**
     * 根据id查询图书信息—-一级缓存
     */
    @Test
    public void findBookByIdTest1() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 2.使用session1查询id为1的图书的信息
        Book book1 = session.selectOne("com.itheima.mapper."
                + "BookMapper.findBookById", 1);
        // 3.输出查询结果信息
        System.out.println(book1.toString());
        // 4.使用session1查询id为1的图书的信息
        Book book2 = session.selectOne("com.itheima.mapper."
                + "BookMapper.findBookById", 1);
        // 5.输出查询结果信息
        System.out.println(book2.toString());
        // 6.关闭SqlSession
        session.close();
    }

    @Test
    public void findBookByIdTest2() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 2.使用session查询id为1的图书的信息
        Book book1 = session.selectOne("com.itheima.mapper."
                + "BookMapper.findBookById", 1);
        // 3.输出查询结果信息
        System.out.println(book1.toString());
        Book book2 = new Book();
        book2.setId(3);
        book2.setBookName("MySQL数据库入门");
        book2.setPrice(40.0);
        // 4.使用session更新id为3的图书的信息
        session.update("com.itheima.mapper."
                + "BookMapper.updateBook", book2);
        session.commit();
        Book book3 = session.selectOne("com.itheima.mapper."
                + "BookMapper.findBookById", 1);
        // 5.输出查询结果信息
        System.out.println(book1.toString());
        // 6.关闭SqlSession
        session.close();
    }

    /**
     * 根据id查询图书信息—-二级缓存
     */
    @Test
    public void findBookByIdTest3() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session1 = MyBatisUtils.getSession();
        SqlSession session2 = MyBatisUtils.getSession();
        // 2.使用session1查询id为1的图书的信息
        Book book1 = session1.selectOne("com.itheima.mapper."
                + "BookMapper.findBookById", 1);
        // 3.输出查询结果信息
        System.out.println(book1.toString());
        // 4.关闭SqlSession1
        session1.close();
        // 5.使用session2查询id为1的图书的信息
        Book book2 = session2.selectOne("com.itheima.mapper."
                + "BookMapper.findBookById", 1);
        // 6.输出查询结果信息
        System.out.println(book2.toString());
        // 7.关闭SqlSession2
        session2.close();
    }

    @Test
    public void findBookByIdTest4() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session1 = MyBatisUtils.getSession();
        SqlSession session2 = MyBatisUtils.getSession();
        SqlSession session3 = MyBatisUtils.getSession();
        // 2.使用session1查询id为1的图书的信息
        Book book1 = session1.selectOne("com.itheima.mapper."
                + "BookMapper.findBookById", 1);
        // 3.输出查询结果信息
        System.out.println(book1.toString());
        // 4.关闭SqlSession
        session1.close();
        Book book2 = new Book();
        book2.setId(2);
        book2.setBookName("Java Web程序开发进阶");
        book2.setPrice(45.0);
        // 5.使用session2更新id为2的图书的信息
        session2.update("com.itheima.mapper."
                + "BookMapper.updateBook", book2);
        session2.commit();
        session2.close();
        // 6.使用session3查询id为1的图书的信息
        Book book3 = session3.selectOne("com.itheima.mapper."
                + "BookMapper.findBookById", 1);
        // 7.输出查询结果信息
        System.out.println(book3.toString());
        // 8.关闭SqlSession
        session3.close();
    }


    @After
    public void destory() {
        //提交事务
        sqlSession.commit();
        //关闭事务
        sqlSession.close();
    }
}

