package com.edu.chapter08;

import java.util.ArrayList;
import java.util.List;

public class SortingHandler<T> {

	private final SortingAlgorithm<T> algorithm;

	private SortingHandler(SortingAlgorithm<T> algo) {
		this.algorithm = algo;
	}

	public static <T> SortingHandler<T> createBubbleSorter() {
		return new SortingHandler<T>(new BubbleSort<T>());
	}

	public static <T> SortingHandler<T> createHeapSorter() {
		return new SortingHandler<T>(new HeapSortAlgorithm<T>());
	}

	public void sort(List<T> listOfdtos) {
		algorithm.sort(listOfdtos);
	}

	public static void main(String[] args) {
		SortingHandler<Long> bubbleLongSorter = SortingHandler.createBubbleSorter();
		bubbleLongSorter.sort(new ArrayList<Long>());
	}
}
