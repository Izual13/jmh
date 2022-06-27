package com.example.jmh;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.rocksdb.*;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class DbService {

    private RocksDB db;
    private Options options;

    private Thread dbStats;


    @PostConstruct
    private void init() {
        log.info("init rocksDB");
        RocksDB.loadLibrary();

        options = new Options().setCreateIfMissing(true).setStatistics(new Statistics());

        try {
            db = TtlDB.open(options, "build/rocksDB", 10, false);
        } catch (RocksDBException e) {
            log.error("RocksDBException", e);
        }

        dbStats = new Thread(() -> {
            while (true) {
                try {
                    //todo: get something from stats
                    var stats = options.statistics();
                    log.info("rocks stats: " + db.getProperty("rocksdb.estimate-num-keys"));
                    Thread.sleep(60000L);
                } catch (Throwable th) {
                    log.error("db stats error: ", th);
                }
            }
        });

        dbStats.start();
    }

    public void put(String key, String value) {
        try {
            db.put(key.getBytes(StandardCharsets.UTF_8), value.getBytes(StandardCharsets.UTF_8));
        } catch (RocksDBException e) {
            log.error("RocksDBException", e);
        }
    }

    @PreDestroy
    private void destroy() {
        db.close();
        options.close();
    }
}
