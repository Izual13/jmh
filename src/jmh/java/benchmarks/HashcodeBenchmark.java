package benchmarks;

import com.example.jmh.B1.Java7Misc;
import com.example.jmh.B1.LombokMisc;
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
public class HashcodeBenchmark {

    Java7Misc java;
    LombokMisc lombok;
    StabModel stub;

    @Setup
    public void prepare() {
        java = new Java7Misc();
        lombok = new LombokMisc();
        stub = new StabModel();
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
        bh.consume(stub.hashCode());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(HashcodeBenchmark.class.getSimpleName())
                .forks(1)
                .jvmArgs("-ea")
                .warmupIterations(3)
                .build();

        new Runner(opt).run();
    }

    //Benchmark                        Mode  Cnt           Score           Error  Units
    //HashcodeBenchmark.java          thrpt    5    22501184,553 �   2850261,060  ops/s
    //HashcodeBenchmark.lombok        thrpt    5   175572073,033 �  47153588,993  ops/s
    //HashcodeBenchmark.stub          thrpt    5  1355583211,729 � 849404346,690  ops/s
}

