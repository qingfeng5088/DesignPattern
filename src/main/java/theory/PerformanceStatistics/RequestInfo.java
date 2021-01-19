package theory.PerformanceStatistics;

import java.io.Serializable;

public class RequestInfo implements Serializable {
    private String apiName;
    private int responseTime;
    private long timestamp;

    public RequestInfo(String apiName, int responseTime, long timestamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }

    public String getApiName() {
        return apiName;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "apiName='" + apiName + '\'' +
                ", responseTime=" + responseTime +
                ", timestamp=" + timestamp +
                '}';
    }
}
