import com.week7i.share.service.UserService;
import com.week7i.share.util.SpringContextHolder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by boxiaotong on 2017/5/22.
 */
public class SpringContextTest {

    @Test
    public void SpringContextTestService(){
        UserService service= SpringContextHolder.getBean(UserService.class);
        System.out.print(service);
    }

    @Test
    public void SpringContextTestDao(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"spring-context.xml", "spring-mvc.xml"});
        SpringContextHolder holder= context.getBean(SpringContextHolder.class);
        UserService service= holder.getBean(UserService.class);
        String name=service.query("1");
        System.out.print(name);
    }
}
