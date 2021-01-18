package PerformanceStatistics;

import org.apache.commons.lang3.StringUtils;

/**
 * 负责提供API 来采集接口请求的原始数据
 */
public class MetricsCollector {
    private MetricsStorage metricsStorage; //基于接口而非实现编程

    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }

        metricsStorage.saveRequestInfo(requestInfo);
    }


}
