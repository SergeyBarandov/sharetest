package logger;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Logger {
    private final Map<Status, TreeSet<Log>> mapLogByStatus;
    private final TreeSet<Log> setLog;

    public Logger() {
        this.mapLogByStatus = new HashMap<>();
        this.setLog = new TreeSet<>();
    }

    public boolean addLog(Status status, String description) {
        boolean result;
        if (result = status != null && description != null) {
            Log log = new Log(status, description);
            this.setLog.add(log);
            if (this.mapLogByStatus.isEmpty() || !this.mapLogByStatus.containsKey(status)) {
                this.mapLogByStatus.put(status, new TreeSet<>());
            }
        }
        return result;
    }
}
