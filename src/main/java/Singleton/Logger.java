package Singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 多例模式
 * 不同类型可以创建多个对象，同意类型使用同一个对象
 */
public class Logger {
    private static final ConcurrentHashMap<String, Logger> instances = new ConcurrentHashMap<>();
    private FileWriter writer;
    private static final Logger instance = new Logger();
    private Logger() {
        File file = new File("/users/log.txt");
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance(String loggerName) {
        instances.putIfAbsent(loggerName,new Logger());
        return instances.get(loggerName);
    }

    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
