package org.example.learn.spring.util.boot.prop;

import java.util.StringJoiner;

public class AppSettings {

    private DatabaseConfig database;
    private int threadPoolSize;

    public DatabaseConfig getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfig database) {
        this.database = database;
    }

    public int getThreadPoolSize() {
        return threadPoolSize;
    }

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AppSettings.class.getSimpleName() + "[", "]")
                .add("database=" + database)
                .add("threadPoolSize=" + threadPoolSize)
                .toString();
    }
}
