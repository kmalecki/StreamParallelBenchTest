package com.malecki.parallelStreamsTesting.testdata.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class TestObject {
	@Getter
	private final int numberOfObject;
	@NonNull
	@Getter
	private final LocalDate date;
}
