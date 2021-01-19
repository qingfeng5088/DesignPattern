package theory.OCP.AfterReconstruction;

public class ApiStatInfo {
    private String api;
    private long reqestCount;
    private long errorCount;
    private long durationOfSeconds;
    private long timeoutCount; // 改动：添加新字段


    public ApiStatInfo() {
    }


    public ApiStatInfo(String api, long reqestCount, long errorCount, long timeoutCount, long durationOfSeconds) {
        this.api = api;
        this.reqestCount = reqestCount;
        this.errorCount = errorCount;
        this.durationOfSeconds = durationOfSeconds;
        this.timeoutCount = timeoutCount;
    }

    public String getApi() {
        return api;
    }

    public long getReqestCount() {
        return reqestCount;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public long getDurationOfSeconds() {
        return durationOfSeconds;
    }

    public long getTimeoutCount() {
        return timeoutCount;
    }
}
