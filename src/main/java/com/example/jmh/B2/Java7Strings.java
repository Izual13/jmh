package com.example.jmh.B2;

import com.example.jmh.RandomUtils;

import java.util.Objects;


public class Java7Strings {
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

    public Java7Strings() {
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

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public String getS3() {
        return s3;
    }

    public String getS4() {
        return s4;
    }

    public String getS5() {
        return s5;
    }

    public String getS6() {
        return s6;
    }

    public String getS7() {
        return s7;
    }

    public String getS8() {
        return s8;
    }

    public String getS9() {
        return s9;
    }

    public String getS10() {
        return s10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Java7Strings that = (Java7Strings) o;
        return Objects.equals(s1, that.s1) && Objects.equals(s2, that.s2) && Objects.equals(s3, that.s3) && Objects.equals(s4, that.s4) && Objects.equals(s5, that.s5) && Objects.equals(s6, that.s6) && Objects.equals(s7, that.s7) && Objects.equals(s8, that.s8) && Objects.equals(s9, that.s9) && Objects.equals(s10, that.s10);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
    }
}
