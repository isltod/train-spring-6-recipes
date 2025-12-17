package com.apress.spring6recipes.shop;

import org.springframework.context.annotation.Bean;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Cashier {

    private final String filename;
    private final String path;
    private BufferedWriter writer;

    public Cashier(String filename, String path) {
        this.filename = filename;
        this.path = path;
    }

    // 이건 configure에서 init으로 지정 - 시작할 때 자동으로 실행된다...
    public void openFile() throws IOException {
        var checkoutPath = Path.of(path, filename + ".txt");
        if (Files.notExists(checkoutPath)) {
            Files.createDirectories(checkoutPath.getParent());
        }
        writer = Files.newBufferedWriter(
                checkoutPath, StandardCharsets.UTF_8,  StandardOpenOption.CREATE, StandardOpenOption.APPEND
        );
    }

    public void checkout(ShoppingCart cart) throws IOException {
        writer.write(LocalDateTime.now() + "\t" + cart.getItems() + "\r\n");
        writer.flush();
    }

    // 이건 configure에서 destroy 지정 - 끝날 때 자동으로 실행
    public void closeFile() throws IOException {
        writer.close();
    }
}
