package Singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 饿汉式单例
 * 缺点：不支持延迟加载
 */
public class Logger01 {
    private FileWriter writer;
    private static final Logger01 instance = new Logger01();

    private  Logger01(){
        File file = new File("/users/log.txt");
        try {
            writer = new FileWriter(file,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static  Logger01 getInstance() {
        return instance;
    }

    public  void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
