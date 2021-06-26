package com.xuhao.demo01detect.client;

import org.apache.zookeeper.*;

/**
 * 提供服务的客户端，对应的是C/S中的S
 *
 * 用于向ListenerClient提供服务
 */

public class ZkServerClient extends ZkClient{
    private String nodePath;
    private String info;
    private long millis;

    public ZkServerClient(String nodePath, String info, long millis) {
        this.nodePath = nodePath;
        this.info = info;
        this.millis = millis;
    }



    /**
     * 服务器Client注册
     */
    @Override
    public void register() {
        /* 连接Zookeeper后创建属于自己的节点 */
        try {
            zooKeeper.create(nodePath, info.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//            System.out.println(info + "上线");
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务器Client的业务逻辑
     */
    @Override
    public void business() {
        try {
            Thread.sleep(millis);
//            System.out.println(info +"下线");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
