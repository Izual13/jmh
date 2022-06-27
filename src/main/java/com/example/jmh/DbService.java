package com.example.jmh;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.Statistics;
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
            db = RocksDB.open(options, "build/rocksDB");
        } catch (RocksDBException e) {
            log.error("RocksDBException", e);
        }

        dbStats = new Thread(() -> {
            while (true) {
                try {
                    var stats = options.statistics();
                    log.info("rocks stats: " + stats);
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
