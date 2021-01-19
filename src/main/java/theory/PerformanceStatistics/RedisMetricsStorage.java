package theory.PerformanceStatistics;

import redis.clients.jedis.Jedis;
import utils.RedisHelper;
import utils.SerializeUtil;

import java.util.*;

public class RedisMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        Jedis jedis = RedisHelper.getRedis();
        byte[] requestInfoBytes = SerializeUtil.serialize(requestInfo);
        jedis.lpush(requestInfo.getApiName().getBytes(), requestInfoBytes);
        jedis.lpush("requestInfoList".getBytes(), requestInfoBytes);
        jedis.save();
    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimestamp, long endTimestamp) {
        List<RequestInfo> retList = new ArrayList<>();
        Jedis jedis = RedisHelper.getRedis();
        List<byte[]> list = jedis.lrange(apiName.getBytes(), 0, -1);
        for (byte[] bytes : list) {
            RequestInfo requestInfo = (RequestInfo) SerializeUtil.unserialize(bytes);
            if (requestInfo == null || requestInfo.getTimestamp() < startTimestamp || requestInfo.getTimestamp() > endTimestamp)
                continue;

            retList.add(requestInfo);
        }
        return retList;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp) {
        Jedis jedis = RedisHelper.getRedis();
        Map<String, List<RequestInfo>> retMap = new HashMap<>();
        List<byte[]> list = jedis.lrange("requestInfoList".getBytes(), 0, -1);
        for (byte[] bytes : list) {
            RequestInfo requestInfo = (RequestInfo) SerializeUtil.unserialize(bytes);
            if (requestInfo == null || requestInfo.getTimestamp() < startTimestamp || requestInfo.getTimestamp() > endTimestamp)
                continue;
            if (retMap.containsKey(requestInfo.getApiName())) {
                List<RequestInfo> infoList = retMap.get(requestInfo.getApiName());
                infoList = new ArrayList<>(infoList);
                infoList.add(requestInfo);

                retMap.put(requestInfo.getApiName(), infoList);
            } else {
                retMap.put(requestInfo.getApiName(), List.of(requestInfo));
            }
        }
        return retMap;
    }
}
