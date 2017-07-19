import com.week7i.share.service.SystemService;
import com.week7i.share.util.SpringContextHolder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by boxiaotong on 2017/5/22.
 */
public class SpringContextTest {

    @Test
    public void SpringContextTestService(){
        SystemService service= SpringContextHolder.getBean(SystemService.class);
        System.out.print(service);
    }

    @Test
    public void SpringContextTestDao(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"spring-context.xml", "spring-mvc.xml"});
        SpringContextHolder holder= context.getBean(SpringContextHolder.class);
        SystemService service= holder.getBean(SystemService.class);
        String rs=service.login("admin");
        System.out.println(rs);
    }
}
