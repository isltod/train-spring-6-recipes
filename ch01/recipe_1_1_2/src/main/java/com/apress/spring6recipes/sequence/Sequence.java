package com.apress.spring6recipes.sequence;

// DB가 있고, 도메인 + DAO 패턴을 사용하하려면
// 도메인 객체에서 id 넣고, setter 대신 생성자로 prefix, suffix 넣고, getter만 제공한다?
public class Sequence {
    private final String id;
    private String prefix;
    private String suffix;

    public Sequence(String id, String prefix, String suffix) {
        this.id = id;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
