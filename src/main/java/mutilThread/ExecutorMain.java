package mutilThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 这个实现方式主要是事先把需要处理的数据主动分割，这样避免同步队列请求锁的开销。
 *
 * User: ethan
 * Date: 13-8-26
 * Time: 下午2:38
 * To change this template use File | Settings | File Templates.
 */
public class ExecutorMain {

    private final static int THREAD_COUNT = 5;
    private final static int SPLIT_COUNT = 10;

    private final static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    private static List<User> arrayList;

    public static void main(String[] args) {
        process();
    }

    public static void process() {

        prepareData();
        int splitCount = arrayList.size() / SPLIT_COUNT;
        List<Future<List<User>>> futures = new ArrayList<Future<List<User>>>(splitCount);
        for (int i = 0; i < SPLIT_COUNT; i++) {
            Future<List<User>> future = executorService.submit(new Handler(arrayList.subList(i == 0 ? i : i * SPLIT_COUNT , getSubListIndex(arrayList.size(), i))));
            futures.add(future);
        }

        List<User> afterUsers = new ArrayList<User>(arrayList.size());

        for (Future<List<User>> future : futures) {
            try {
                afterUsers.addAll(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ExecutionException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        executorService.shutdown();
        for (User user : afterUsers) {
            System.out.println(user.toString());
        }


    }

    private static void prepareData() {
        arrayList = new ArrayList<User>(100);

        for (int i = 0; i < 100;i++) {
            User user = new User();
            user.setId(i);
            user.setName(i + "name");
            user.setAge(i + 10);
            arrayList.add(user);
        }
    }

    /**
     * 根据给定的索引和总数获取需要分割的索引值
     * @param size
     * @param index
     * @return
     */
    private static int getSubListIndex(int size,int index){
        int subIndex = SPLIT_COUNT * (index + 1);
        if (((index + 1) * SPLIT_COUNT) > arrayList.size()) {
            subIndex = arrayList.size();
        }
        return subIndex;
    }


}
