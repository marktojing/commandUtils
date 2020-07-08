package com.csnt.utils.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池操作，使用按需创建的方式来进行
 *
 * @Author: JACK-GU
 * @Date: 2019/2/19 1:55 PM
 * @E-Mail: 528489389@qq.com
 */
public class ThreadPoolUtil {
    private static final ExecutorService cachedThreadPool;

    static {
        cachedThreadPool = Executors.newCachedThreadPool();
    }

    /**
     * 线程池按需执行任务
     *
     * @Author: JACK-GU
     * @Date: 2019/2/19 2:00 PM
     * @E-Mail: 528489389@qq.com
     */
    public static void execute(Runnable runnable) {
        cachedThreadPool.execute(runnable);
    }

}
