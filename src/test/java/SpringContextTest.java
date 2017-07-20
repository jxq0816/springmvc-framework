import com.week7i.share.service.SystemService;
import com.week7i.share.util.SpringContextHolder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by boxiaotong on 2017/5/22.
 */
public class SpringContextTest {

    /**
     * 测试方法执行时，需要将spring-mvc.xml里面
     */

    @Test
    public void loginTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( new String[] {"spring-context.xml", "spring-mvc.xml","spring-context-shiro.xml"});
        SpringContextHolder holder= context.getBean(SpringContextHolder.class);
        SystemService service= holder.getBean(SystemService.class);
        String rs=service.login("jiangxingqi");
        System.out.println(rs);
    }

    @Test
    public void getRoleByUserNameTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring-context.xml", "spring-mvc.xml","spring-context-shiro.xml"});
        SpringContextHolder holder= context.getBean(SpringContextHolder.class);
        SystemService service= holder.getBean(SystemService.class);
        String rs=service.getRoleByUserName("jiangxingqi");
        System.out.println(rs);
    }
}
