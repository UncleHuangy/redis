package com.nba.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nba.dao.Impl.ProvinceDaoImpl;
import com.nba.dao.ProvinceDao;
import com.nba.domain.Province;
import com.nba.jedis.util.JedisPoolUtils;
import com.nba.service.ProvinceService;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
   private ProvinceDao dao = new ProvinceDaoImpl();

   /* @Override
    public String findProvince() {
        List<Province> list = dao.FindProvince();
        ObjectMapper objectMapper = new ObjectMapper();
        String province_json = null;
        try {
            province_json= objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return province_json;
    }*/

    @Override
    public String findJedisProvinve() {
        //1.在缓冲中查找资源
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        //2判断 province_json 数据是否为null
        if (province_json==null||province_json.length()==0){
            System.out.println("缓冲数据库中没有资源...");
            // 查询资源
            List<Province> list = dao.FindProvince();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
              province_json= objectMapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
        }else {
            System.out.println("redis中有数据，查询缓存...");
        }
        System.out.println(province_json);
        return province_json;
    }
}
