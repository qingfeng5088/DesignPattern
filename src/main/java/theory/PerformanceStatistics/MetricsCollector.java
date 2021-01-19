package theory.PerformanceStatistics;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Executors;

/**
 * 负责提供API 来采集接口请求的原始数据
 */
public class MetricsCollector {
    private MetricsStorage metricsStorage; //基于接口而非实现编程

    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;
    private EventBus eventBus;

    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this(metricsStorage,DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    public MetricsCollector(MetricsStorage metricsStorage,int threadNumtoSave) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumtoSave));
        this.eventBus.register(new EventListener());
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }

       eventBus.post(requestInfo);
    }

    private class EventListener {
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }
}
