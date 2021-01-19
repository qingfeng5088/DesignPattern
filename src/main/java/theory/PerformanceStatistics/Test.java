package theory.PerformanceStatistics;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        MetricsStorage storage = new RedisMetricsStorage();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage);

        consoleReporter.startRepeatedReport(60,60);

        MetricsCollector collector = new MetricsCollector(storage);

        collector.recordRequest(new RequestInfo("getUserInfo",123,System.currentTimeMillis()));
        collector.recordRequest(new RequestInfo("getUserInfo",223,System.currentTimeMillis()));
        collector.recordRequest(new RequestInfo("getUserInfo",323,System.currentTimeMillis()));
        collector.recordRequest(new RequestInfo("login",23,System.currentTimeMillis()));
        collector.recordRequest(new RequestInfo("login",1233,System.currentTimeMillis()));


        Thread.sleep(100000);
    }
}
