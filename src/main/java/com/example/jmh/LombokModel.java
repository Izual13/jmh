package com.example.jmh;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class LombokModel {
    private final int i1;
    private final int i2;
    private final int i3;
    private final int i4;
    private final int i5;

    private final String s1;
    private final String s2;
    private final String s3;
    private final String s4;
    private final String s5;

    public LombokModel() {
        i1 = RandomUtils.getInt();
        i2 = RandomUtils.getInt();
        i3 = RandomUtils.getInt();
        i4 = RandomUtils.getInt();
        i5 = RandomUtils.getInt();
        s1 = RandomUtils.getString(200);
        s2 = RandomUtils.getString(200);
        s3 = RandomUtils.getString(200);
        s4 = RandomUtils.getString(200);
        s5 = RandomUtils.getString(200);
    }
}
