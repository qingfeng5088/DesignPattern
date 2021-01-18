package PerformanceStatistics;

import java.util.List;
import java.util.Map;

/**
 * 代码 易复用，易读，易扩展，易维护
 * <p>
 * 负责原始数据存储
 */
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    // 根据给定的时间区间，从数据库中拉取数据
    List<RequestInfo> getRequestInfos(String apiName, long startTimestamp, long endTimestamp);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp);

}