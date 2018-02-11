package com.malecki.parallelStreamsTesting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.malecki.parallelStreamsTesting.benchmarks.TheBenchmark;

@SpringBootApplication
public class ParallelStreamsTestingApplication {

	public static void main(String[] args) throws RunnerException, IOException {
		Options opt = new OptionsBuilder()
                .include(TheBenchmark.class.getSimpleName())
                .warmupIterations(2)
                .measurementIterations(1)
                .forks(1)
                .shouldDoGC(true) 
                .timeUnit(TimeUnit.MILLISECONDS)
                .build();


        new Runner(opt).run(); 
	}
}
