import com.week7i.share.util.JedisUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiangxingqi on 2017/7/27.
 */
public class JedisUtilsTest {

    /**
     * 测试方法执行时，需要将spring-mvc.xml里面
     */

    @Test
    public void loginTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( new String[] {"applicationContext.xml", "dispatcherServlet.xml","spring-context-shiro.xml","spring-context-jedis.xml"});
        String rs=JedisUtils.get("mygirl");
        System.out.println(rs);
    }
}
