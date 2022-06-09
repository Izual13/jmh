package benchmarks;

import com.example.jmh.RandomUtils;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Fork(1)
@Warmup(iterations = 2, time = 5)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.All)
public class Md5HashBenchmark {

    private String text;
    private MessageDigest md;

    @Setup
    public void prepare() throws NoSuchAlgorithmException {
        text = RandomUtils.getString(50000000);
        md = MessageDigest.getInstance("MD5");
    }

    @Benchmark
    public void md5(Blackhole bh) {
        md.update(text.getBytes());
        bh.consume(md.digest());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include("benchmarks\\.Md5HashBenchmark")
                .build();
        new Runner(opt).run();
    }

//    Benchmark                           Mode  Cnt  Score   Error  Units
//    Md5HashBenchmark.md5               thrpt    5  8,231 � 0,398  ops/s
//    Md5HashBenchmark.md5                avgt    5  0,123 � 0,011   s/op
//    Md5HashBenchmark.md5              sample  412  0,122 � 0,002   s/op
//    Md5HashBenchmark.md5:md5�p0.00    sample       0,116           s/op
//    Md5HashBenchmark.md5:md5�p0.50    sample       0,120           s/op
//    Md5HashBenchmark.md5:md5�p0.90    sample       0,128           s/op
//    Md5HashBenchmark.md5:md5�p0.95    sample       0,133           s/op
//    Md5HashBenchmark.md5:md5�p0.99    sample       0,168           s/op
//    Md5HashBenchmark.md5:md5�p0.999   sample       0,321           s/op
//    Md5HashBenchmark.md5:md5�p0.9999  sample       0,321           s/op
//    Md5HashBenchmark.md5:md5�p1.00    sample       0,321           s/op
//    Md5HashBenchmark.md5                  ss       0,135           s/op
}

