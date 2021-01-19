package theory.PerformanceStatistics;

import java.util.*;

/**
 * 负责根据原始数据计算统计数据
 */
public class Aggregator {
    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        requestInfos.keySet().forEach(x -> {
            List<RequestInfo> sub = requestInfos.get(x);
            RequestStat requestStat = doAggregate(sub, durationInMillis);
            requestStats.put(x, requestStat);
        });

        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(Objects.requireNonNull(requestInfos.stream().max(Comparator.comparingInt(RequestInfo::getResponseTime)).orElse(null)).getResponseTime());
        requestStat.setMinResponseTime(Objects.requireNonNull(requestInfos.stream().min(Comparator.comparingInt(RequestInfo::getResponseTime)).orElse(null)).getResponseTime());

        //其他省略

        return requestStat;
    }

    public static RequestStat aggregateOld(List<RequestInfo> requestInfos, long durationInMillis) {
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;

        for (RequestInfo requestInfo : requestInfos) {
            count++;
            double respTime = requestInfo.getResponseTime();
            if ((maxRespTime < respTime)) {
                maxRespTime = respTime;
            }

            if ((minRespTime > respTime)) {
                minRespTime = respTime;
            }

            sumRespTime += respTime;
        }


        long tps = (long) (count / durationInMillis * 1000);

        requestInfos.sort((x, y) -> {
            double diff = x.getResponseTime() - y.getResponseTime();
            return (int) Math.ceil(diff);
        });

        int idx999 = (int) (count * 0.999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            avgRespTime = sumRespTime / count;

            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();

        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);

        return requestStat;
    }
}
