import com.itheima.pojo.Category;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class MyBatisTest {
    /**
     * 一对多
     */
    @Test
    public void findCategoryTest() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 2.查询id为2的商品类别信息
        Category category = session.selectOne("com.itheima.mapper."
                + "CategoryMapper.findCategoryWithProduct", 2);
        // 3.输出查询结果信息
        System.out.println(category);
        // 4.关闭SqlSession
        session.close();
    }

}
