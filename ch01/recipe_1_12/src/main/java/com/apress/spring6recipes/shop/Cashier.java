package com.apress.spring6recipes.shop;

import org.springframework.beans.factory.BeanNameAware;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

// BeanNameAware 인터페이스를 구현해서 빈 생성 이름을 가져올 수 있다...
public class Cashier implements BeanNameAware {

	private String fileName;
	private final String path;

	private BufferedWriter writer;

	public Cashier(String path) {
		this.path = path;
	}

	public void openFile() throws IOException {
		var options = new OpenOption[] {
						StandardOpenOption.CREATE,
						StandardOpenOption.APPEND };
		var file = Path.of(path, fileName + ".txt");
		Files.createDirectories(file.getParent());
		writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8, options);
	}

	public void checkout(ShoppingCart cart) throws IOException {
		writer.write(LocalDateTime.now() + "\t" + cart.getItems() + "\r\n");
		writer.flush();
	}

	public void closeFile() throws IOException {
		writer.close();
	}

    // 이걸로 자동으로 fileName이 빈 이름이 되는데...뭐에 쓸모가 있는지는 잘...
    @Override
    public void setBeanName(String name) {
        this.fileName = name;
    }
}
