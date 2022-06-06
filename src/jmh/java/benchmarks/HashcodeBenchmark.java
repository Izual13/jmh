package benchmarks;

import com.example.jmh.Java8Model;
import com.example.jmh.LombokModel;
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

    Java8Model java8Model;
    LombokModel lombokModel;

    @Setup
    public void prepare() {
        java8Model = new Java8Model();
        lombokModel = new LombokModel();
    }


    @Benchmark
    public void java8ModelHashCode(Blackhole bh) {
        bh.consume(java8Model.hashCode());
    }

    @Benchmark
    public void lombokModelHashCode(Blackhole bh) {
        bh.consume(lombokModel.hashCode());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(HashcodeBenchmark.class.getSimpleName())
                .forks(1)
                .jvmArgs("-ea")
                .build();

        new Runner(opt).run();
    }
}

