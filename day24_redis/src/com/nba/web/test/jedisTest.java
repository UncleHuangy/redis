package com.nba.web.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class jedisTest {
    @Test
    public void TestJedis(){
        //String
        Jedis jedis = new Jedis();
        /*jedis.set("robot","alphgo");
        String value = jedis.get("robot");
        System.out.println(value);
        jedis.close();
        */
        /*
        1.string     set / get / del
        2.hashmap    hset / hget / hdel
        3.set        sadd / smember / hremove
        4.list       lpush / lrange / lpop
        5.sortedList zadd / zrange / zremove
         */
        //hashmap
      /*  jedis.hset("star","huNan","yangmi");
        jedis.hset("star","sichuan","zhaoliyin");
        jedis.hset("star","beijing","liuyifei");
        jedis.hset("star","hongkong","liangchaowei");
        String female = jedis.hget("star", "hongkong");
        System.out.println(female);
        jedis.close();*/

        //set
        jedis.sadd("life","5000");
        jedis.sadd("speed","20");
        jedis.sadd("skill","仙女散花");
        jedis.sadd("equipment","无尽之刃");

        Set<String> equipment = jedis.smembers("equipment");
        System.out.println(equipment);
        jedis.close();

        // list
        /*jedis.lpush("company","tencent");
        jedis.lpush("company","huawei");
        jedis.lpush("company","jingdong");
        jedis.lpush("company","alibaba");

        List<String> companys = jedis.lrange("company", 0, -1);
        System.out.println(companys);
        jedis.close();
        */


        // sortedList
       /* jedis.zadd("robot1",1313,"alphgo");
        jedis.zadd("robot1",1315,"xioami");
        jedis.zadd("robot1",1316,"baidu");
        jedis.zadd("robot1",1317,"huawei");

        Set<String> robot = jedis.zrange("robot1", 0, -1);
        System.out.println(robot);
        jedis.close();*/
    }
}

