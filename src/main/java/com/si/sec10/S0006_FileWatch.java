package com.si.sec10;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface S0006_FileWatch {
    static final  Logger log = LoggerFactory.getLogger(S0006_FileWatch.class);
    static void main(String[] args) throws IOException, InterruptedException {
        var watchService = FileSystems
                .getDefault()
                .newWatchService();
        var pathToWatch = Path.of("/Users/trung/Learn/2024/virtual-thread-playground/src/main/java/com/si/sec10/");

        // Đăng ký theo dõi thư mục con
        pathToWatch.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);

        while (true) {
            var key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                log.info("Sự kiện: " + event.kind() + " - File: " + event.context());
            }
            key.reset(); // Reset key để tiếp tục nhận sự kiện
        }
    }
}
