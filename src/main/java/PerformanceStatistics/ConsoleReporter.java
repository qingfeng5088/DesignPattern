package PerformanceStatistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 是否满足：
 * 1：单一职责原则
 * 2：开闭原则
 * 3：依赖注入
 * 4：KISS原则
 * 5：DRY原则
 * 6：迪米特法则
 * 7：基于接口耳鸣实现编程思想
 * 8：高内聚，低耦合
 * <p>
 * 负责以一定频率统计并发送统计数据到命令行
 */
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSecond) {
        executor.scheduleAtFixedRate(() -> {
            long durationInMillis = durationInSecond * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;

            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);

            Map<String,RequestStat> stats = new HashMap<>();
            requestInfos.keySet().forEach(x->{
                List<RequestInfo> subList = requestInfos.get(x);
                RequestStat  reqestStat = Aggregator.aggregate(subList,durationInMillis);
                stats.put(x,reqestStat);
            });

            System.out.println("统计的时间:[" + startTimeInMillis + " ~ " + endTimeInMillis + "]");
            System.out.println(stats);
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
