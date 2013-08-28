package mutilThread;

import org.testng.annotations.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: ethan
 * Date: 13-8-27
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class ExecutorBlockingQueneTest {
    @Test
    public void testProcess() throws Exception {
        ExecutorBlockingQuene quenes = new ExecutorBlockingQuene();
        quenes.setUserQuenes(prepareData());
        quenes.process();
    }

    private BlockingQueue<User> prepareData() {
        BlockingQueue<User> users = new ArrayBlockingQueue<User>(100);
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i);
            user.setName(i + "name");
            user.setAge(i + 10);
            users.add(user);
        }
        return users;
    }
    
}
