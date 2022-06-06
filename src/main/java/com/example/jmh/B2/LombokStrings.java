package com.example.jmh.B2;

import com.example.jmh.RandomUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class LombokStrings {
    private final String s1;
    private final String s2;
    private final String s3;
    private final String s4;
    private final String s5;
    private final String s6;
    private final String s7;
    private final String s8;
    private final String s9;
    private final String s10;

    public LombokStrings() {
        s1 = RandomUtils.getString(200);
        s2 = RandomUtils.getString(200);
        s3 = RandomUtils.getString(200);
        s4 = RandomUtils.getString(200);
        s5 = RandomUtils.getString(200);
        s6 = RandomUtils.getString(200);
        s7 = RandomUtils.getString(200);
        s8 = RandomUtils.getString(200);
        s9 = RandomUtils.getString(200);
        s10 = RandomUtils.getString(200);
    }
}
