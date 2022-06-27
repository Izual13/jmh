package com.example.jmh;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jdk.jfr.FlightRecorder;
import lombok.extern.slf4j.Slf4j;
import org.rocksdb.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Duration;
import java.time.Instant;

@Slf4j
@Service
//-XX:StartFlightRecording=maxsize=200M,duration=60s,filename=./build
public class JfrDumper {
    private Thread thread;


    @PostConstruct
    private void init() {
        thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    if (!FlightRecorder.isAvailable()) {
                        log.error("JFR is not available!!!");
                        return;
                    }
                    new File("build/dumps").mkdir();

                    var snapshot = FlightRecorder.getFlightRecorder().takeSnapshot();
                    snapshot.setMaxSize(10);
                    snapshot.setMaxAge(Duration.ofMinutes(1));

                    snapshot.dump(new File("build/dumps/" + Instant.now().toString() + ".jfr").toPath());
                    log.info("jfr snapshot was dumped");
                    Thread.sleep(10_000L);
                } catch (Throwable th) {
                    log.error("throwable from Jfr dumper", th);
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread.start();
    }


    @PreDestroy
    private void destroy() {
        thread.interrupt();
    }
}
