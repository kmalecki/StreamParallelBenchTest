package com.malecki.parallelStreamsTesting.benchmarks;

import static java.time.LocalDate.now;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import com.malecki.parallelStreamsTesting.testdata.model.TestObject;
import com.malecki.parallelStreamsTesting.testdata.testoperation.TestBusinessOperations;

@State(Scope.Benchmark)
public class TheBenchmark {
	
	private TestBusinessOperations testFor10;
	private TestBusinessOperations testFor100;
	private TestBusinessOperations testFor1000;
	private TestBusinessOperations testFor5000;
	private TestBusinessOperations testFor10000;
	private TestBusinessOperations testFor50000;
	
	
	
	@Setup
	public void setUp() {
		this.testFor10 = new TestBusinessOperations(createTestObjects(10));
		this.testFor100 = new TestBusinessOperations(createTestObjects(100));
		this.testFor1000 = new TestBusinessOperations(createTestObjects(1000));
		this.testFor5000 = new TestBusinessOperations(createTestObjects(5000));
		this.testFor10000 = new TestBusinessOperations(createTestObjects(10000));
		this.testFor50000 = new TestBusinessOperations(createTestObjects(50000));
	}
	
	private List<TestObject> createTestObjects(int iTestObjects) {
        return new Random(0)
                .ints(iTestObjects, 1, 10000)
                .mapToObj(i -> new TestObject(i, now()))
                .collect(Collectors.toList());
    }
	
	@Benchmark
	public void benchSequentalFor10() {
		testFor10.getSortedListOfObjects();
	}
	@Benchmark
	public void benchSequentalFor100() {
		testFor100.getSortedListOfObjects();
	}
	@Benchmark
	public void benchSequentalFor1000() {
		testFor1000.getSortedListOfObjects();
	}
	@Benchmark
	public void benchSequentalFor5000() {
		testFor5000.getSortedListOfObjects();
	}
	@Benchmark
	public void benchSequentalFor10000() {
		testFor10000.getSortedListOfObjects();
	}
	@Benchmark
	public void benchSequentalFor50000() {
		testFor50000.getSortedListOfObjects();
	}
	
//	================ PARALLEL SECTION ===========================
	
	@Benchmark
	public void benchParallelFor10() {
		testFor10.getParallelSortedListOfObjects();
	}
	@Benchmark
	public void benchParallelFor100() {
		testFor100.getParallelSortedListOfObjects();
	}
	@Benchmark
	public void benchParallelFor1000() {
		testFor1000.getParallelSortedListOfObjects();
	}
	@Benchmark
	public void benchParallelFor5000() {
		testFor5000.getParallelSortedListOfObjects();
	}
	@Benchmark
	public void benchParallelFor10000() {
		testFor10000.getParallelSortedListOfObjects();
	}
	@Benchmark
	public void benchParallelFor50000() {
		testFor50000.getParallelSortedListOfObjects();
	}
	
	
	
}
