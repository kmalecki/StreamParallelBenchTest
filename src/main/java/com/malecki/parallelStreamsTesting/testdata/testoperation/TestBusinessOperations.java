package com.malecki.parallelStreamsTesting.testdata.testoperation;

import java.util.List;
import java.util.stream.Collectors;

import com.malecki.parallelStreamsTesting.testdata.model.TestObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestBusinessOperations {

	private final List<TestObject> originTestObjectsList;

	public List<TestObject> getSortedListOfObjects(){
		return originTestObjectsList.stream().sorted((e1, e2) -> Integer.compare(e1.getNumberOfObject(),
                e2.getNumberOfObject())).collect(Collectors.toList());
	}
	
	public List<TestObject> getParallelSortedListOfObjects(){
		return originTestObjectsList.parallelStream().sorted((e1, e2) -> Integer.compare(e1.getNumberOfObject(),
                e2.getNumberOfObject())).collect(Collectors.toList());
	}

}
