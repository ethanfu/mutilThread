package mutilThread;

import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: ethan
 * Date: 13-8-26
 * Time: 下午2:34
 * To change this template use File | Settings | File Templates.
 */
public class HandlerRunnable implements Runnable {

    private BlockingQueue<User> users;
    private BlockingQueue<User> afterUsers;


    public HandlerRunnable(BlockingQueue<User> users) {
        this.users = users;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public void run() {
        try {
            User user = users.take();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
