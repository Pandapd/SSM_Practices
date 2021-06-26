package com.xuhao.demo01detect.client;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * 监听客户端，对应的是C/S中的C
 *
 * 用于监听Server节点的上线列表
 */
public class ZkListenerClient extends ZkClient{

    private String listenPath;

    public ZkListenerClient(String listenPath) {
        this.listenPath = listenPath;
    }

    /**
     * 注册监听Client的监听器
     */
    @Override
    public void register() {
        try {
            List<String> children = zooKeeper.getChildren(listenPath, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    // 如果节点被删除，则响应
                    if (event.getType() == Event.EventType.NodeChildrenChanged) {
                        System.out.println("服务器列表有变化!");
                        // 重新获取列表并注册监听器
                        register();
                    }

                }
            }, null);

            /* 把在线的服务器列表打印出来 */
            ArrayList<String> servers = new ArrayList<>();
            for (String child:
                 children) {
                byte[] serverInfo = zooKeeper.getData(listenPath +"/"+ child, false, null);
                servers.add(new String(serverInfo));
            }
            System.out.println(servers);

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听器Client的业务逻辑
     *
     * 这里是一直监听
     */
    @Override
    public void business() {
        try {
            Thread.sleep(40*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
