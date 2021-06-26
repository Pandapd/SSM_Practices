package com.xuhao.demo01detect.client;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public abstract class ZkClient implements Runnable {
    protected static final String CONNECT_STRING = "zk01:2181,zk02:2181,zk03:2181";
    protected static final int SESSION_TIMEOUT = 3000; // 应该大于服务端心跳时间
    protected ZooKeeper zooKeeper;

    public ZkClient() {
    }

    public void run() {
        try {
            /* 启动线程后都要创建一个session */
            zooKeeper = getZooKeeper();
            register();
            // 休眠
            business();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            closeClient();
        }
    }


    /**
     * 获取Zookeeper客户端对象
     * @return 客户端连接对象
     * @throws IOException
     * @throws InterruptedException
     */
    public ZooKeeper getZooKeeper() throws IOException, InterruptedException {
        /* 启动线程后都要创建一个session */
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, watchEvent -> {
            if (watchEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
                countDownLatch.countDown();
            }

        });
        // 唤醒本线程
        countDownLatch.await();

        return zooKeeper;
    }

    /**
     * 关闭Zookeeper连接
     */
    public void closeClient() {
        if (zooKeeper != null) {
            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void register();    // 注册或监听
    public abstract void business();    // 业务逻辑

}
