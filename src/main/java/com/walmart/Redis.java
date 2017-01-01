package com.walmart;

import redis.clients.jedis.*;

        import java.util.Map;

/**
 * Created by rjaraja on 5/16/16.
 */
public class Redis {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost

        JedisCluster jedisCluster = new JedisCluster(new HostAndPort("redis.qaenv.cust-test.services.qa.walmart.com", 6379));
        System.out.println("Connection to server sucessfully");
        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
        for (Map.Entry<String, JedisPool> e : clusterNodes.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue());
        }
        System.out.println("Cluster size - " + clusterNodes.size());
        //check whether server is running or not
//        jedisCluster.set("tutorial-name", "Redis tutorial");
        // Get the stored data and print it
        System.out.println("Stored string in redis:: " + jedisCluster.get("tutorial-name"));

        jedisCluster.set("KEY1", "ABC");
        System.out.println(jedisCluster.bitcount("KEY1"));

        System.out.println(jedisCluster.get("KEY1"));
        System.out.println(jedisCluster.get("KEY2"));
        System.out.println("Stored string in redis:: " + jedisCluster.get("tutorial-name"));

    }
}
