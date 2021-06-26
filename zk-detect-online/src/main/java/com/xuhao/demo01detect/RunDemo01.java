package com.xuhao.demo01detect;

import com.xuhao.demo01detect.client.ZkListenerClient;
import com.xuhao.demo01detect.client.ZkServerClient;

import java.util.concurrent.*;

/**
 * 实现需求：监听器客户端实时监听服务器的上下线
 */

public class RunDemo01 {
    private static final int LISTENER_NUM = 2;
    private static final int SERVER_NUM = 3;

    public static void main(String[] args) {
        String listenPath = "/server";
        // 两个监听客户端
        ExecutorService listenerExecutorService = new ThreadPoolExecutor(LISTENER_NUM, LISTENER_NUM, 0,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
        for (int i = 0; i < LISTENER_NUM; i++) {
            listenerExecutorService.submit(new ZkListenerClient(listenPath));
        }

        // 三个服务客户端
        ExecutorService serverExecutorService = new ThreadPoolExecutor(SERVER_NUM, SERVER_NUM, 0,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
        for (int i = 0; i < SERVER_NUM; i++) {
            String nodePath = listenPath +"/server0"+ i;
            String info = "server0" + i;
            long mills = 15 * 1000 + i * 500;
            serverExecutorService.submit(new ZkServerClient(nodePath, info, mills));
        }
    }
}
