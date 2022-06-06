package com.example.jmh;

import java.util.Objects;


public class Java7Model {
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

    public Java7Model() {
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

    public int getI1() {
        return i1;
    }

    public int getI2() {
        return i2;
    }

    public int getI3() {
        return i3;
    }

    public int getI4() {
        return i4;
    }

    public int getI5() {
        return i5;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Java7Model that = (Java7Model) o;
        return i1 == that.i1 && i2 == that.i2 && i3 == that.i3 && i4 == that.i4 && i5 == that.i5 && Objects.equals(s1, that.s1) && Objects.equals(s2, that.s2) && Objects.equals(s3, that.s3) && Objects.equals(s4, that.s4) && Objects.equals(s5, that.s5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i1, i2, i3, i4, i5, s1, s2, s3, s4, s5);
    }
}
