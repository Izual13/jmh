package benchmarks;

import com.example.jmh.B1.LombokMisc;
import com.example.jmh.B2.Java7Strings;
import com.example.jmh.StabModel;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
public class StringHashcodeBenchmark {

    Java7Strings java;
    LombokMisc lombok;
    StabModel stabModel;

    @Setup
    public void prepare() {
        java = new Java7Strings();
        lombok = new LombokMisc();
        stabModel = new StabModel();
    }


    @Benchmark
    public void java(Blackhole bh) {
        bh.consume(java.hashCode());
    }

    @Benchmark
    public void lombok(Blackhole bh) {
        bh.consume(lombok.hashCode());
    }

    @Benchmark
    public void stub(Blackhole bh) {
        bh.consume(stabModel.hashCode());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringHashcodeBenchmark.class.getSimpleName())
                .forks(1)
                .jvmArgs("-ea")
                .warmupIterations(3)
                .build();

        new Runner(opt).run();
    }
}

