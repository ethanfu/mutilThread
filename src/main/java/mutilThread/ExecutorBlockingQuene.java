package mutilThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这个实现方式主要是事先把需要处理的数据主动分割，这样避免同步队列请求锁的开销。
 *
 * User: ethan
 * Date: 13-8-26
 * Time: 下午2:38
 * To change this template use File | Settings | File Templates.
 */
public class ExecutorBlockingQuene implements MyExecutorJob {

    private final static int THREAD_COUNT = 5;
    private BlockingQueue<User> userQuenes ;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    @Override
    public void process() {


    }

    public void setUserQuenes(BlockingQueue<User> userQuenes) {
        this.userQuenes = userQuenes;
    }
}
