package com.springframework.learn.zk;

import lombok.SneakyThrows;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 21/3/2022 上午5:11
 */
public class DataTest {
    private ZooKeeper zooKeeper;

    @Before
    public void init() throws IOException {
        String conn = "192.168.125.100:2181";
        String conn1 = "127.0.0.1:12224";
        zooKeeper = new ZooKeeper(conn1, 4000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
    }

    @Test
    public void getData() throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData("/tuling", false, null);
        System.out.println(new String(data));
    }

    @Test
    public void getData2() throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData("/tuling", true, null);
        System.out.println(new String(data));
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void createData() throws KeeperException, InterruptedException {
        List<ACL> list = new ArrayList<>();
        //cdwra
        //数字位移
        int c = 1<<0;
        int d = 1<<1;
        int w = 1<<2;
        int perm = ZooDefs.Perms.ADMIN|ZooDefs.Perms.CREATE|ZooDefs.Perms.READ;
        ACL acl = new ACL(perm,new Id("world","anyone"));
        ACL acl2 = new ACL(perm,new Id("ip","192.168.0.149"));
        ACL acl3 = new ACL(perm,new Id("ip","127.0.0.1"));
        list.add(acl);
        list.add(acl2);//
        list.add(acl3);//
        zooKeeper.create("/tuling/sss", "hello zookeeper".getBytes(),list,CreateMode.PERSISTENT);

    }

    //持久的监听
    @Test
    public void getData3() throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        byte[] data = zooKeeper.getData("/tuling", new Watcher() {
            @SneakyThrows
            @Override
            public void process(WatchedEvent event) {
                zooKeeper.getData(event.getPath(),this,null);
                System.out.println(event.getPath());
            }
        }, stat);
        System.out.println(stat);
        Thread.sleep(100000000);
    }

    @Test
    public void getData4() throws InterruptedException {
        zooKeeper.getData("/tuling", false, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                //rc 代表 获取data 成功不成功
                //ctx 就把值传到下面的ctx里面
                //stat stat属性
                System.out.println(stat);
            }
        },"");
        Thread.sleep(10000000);
    }

    @Test
    public void getChild() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/tuling",false);
        children.stream().forEach(System.out::println);
    }

    @Test
    public void getChild2() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/tuling",event -> {
            //子节点变更的时候，获取父节点
            System.out.println(event.getPath());
            try {
                List<String> children2 = zooKeeper.getChildren(event.getPath(),false);
                children2.stream().forEach(System.out::println);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        children.stream().forEach(System.out::println);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
