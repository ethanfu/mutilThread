package mutilThread;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ethan
 * Date: 13-8-27
 * Time: 下午6:14
 * To change this template use File | Settings | File Templates.
 */
public class ExecutorSplitListTest {
    @Test
    public void testProcess() throws Exception {
        ExecutorSplitList executorSplitList = new ExecutorSplitList();
        executorSplitList.setArrayList(prepareData());
        executorSplitList.process();
        assertEquals(executorSplitList.getAfterUsers().get(5).getAge(),1500);
    }

    private List<User> prepareData() {
        List<User> arrayList = new ArrayList<User>(100);

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i);
            user.setName(i + "name");
            user.setAge(i + 10);
            arrayList.add(user);
        }

        return arrayList;
    }
}
