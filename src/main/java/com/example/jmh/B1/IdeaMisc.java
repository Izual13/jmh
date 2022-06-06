package com.example.jmh.B1;

import com.example.jmh.RandomUtils;

import java.util.Objects;


public class IdeaMisc {
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

    public IdeaMisc() {
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

        IdeaMisc ideaMisc = (IdeaMisc) o;

        if (i1 != ideaMisc.i1) return false;
        if (i2 != ideaMisc.i2) return false;
        if (i3 != ideaMisc.i3) return false;
        if (i4 != ideaMisc.i4) return false;
        if (i5 != ideaMisc.i5) return false;
        if (!Objects.equals(s1, ideaMisc.s1)) return false;
        if (!Objects.equals(s2, ideaMisc.s2)) return false;
        if (!Objects.equals(s3, ideaMisc.s3)) return false;
        if (!Objects.equals(s4, ideaMisc.s4)) return false;
        return Objects.equals(s5, ideaMisc.s5);
    }

    @Override
    public int hashCode() {
        int result = i1;
        result = 31 * result + i2;
        result = 31 * result + i3;
        result = 31 * result + i4;
        result = 31 * result + i5;
        result = 31 * result + (s1 != null ? s1.hashCode() : 0);
        result = 31 * result + (s2 != null ? s2.hashCode() : 0);
        result = 31 * result + (s3 != null ? s3.hashCode() : 0);
        result = 31 * result + (s4 != null ? s4.hashCode() : 0);
        result = 31 * result + (s5 != null ? s5.hashCode() : 0);
        return result;
    }
}
