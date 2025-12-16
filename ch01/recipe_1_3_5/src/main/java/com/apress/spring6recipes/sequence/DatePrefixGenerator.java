package com.apress.spring6recipes.sequence;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePrefixGenerator implements PrefixGenerator {

    private DateTimeFormatter formatter;

    public void setPatter(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public String getPrefix() {
        return formatter.format(LocalDateTime.now());
    }
}
