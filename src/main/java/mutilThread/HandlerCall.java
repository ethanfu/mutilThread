package mutilThread;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: ethan
 * Date: 13-8-26
 * Time: 下午2:34
 * To change this template use File | Settings | File Templates.
 */
public class HandlerCall implements Callable {

    private List<User> users;


    public HandlerCall(List<User> users) {
        this.users = users;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public List<User> call() throws Exception {
        return doSth();
    }

    private List<User> doSth() {
        System.out.println("Asynchronous task" + Thread.currentThread().getName());
        for (User user : users) {
            user.setAge(user.getAge() * 100);
        }
        return users;
    }
}
