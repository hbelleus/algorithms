package fr.abnegative.algorithms.number.sort;

import java.util.concurrent.atomic.AtomicInteger;

public class HeapSort implements Sorter {

	private static AtomicInteger heapSize; // this will help us to stop sorting list numbers that are already sorted.

	/**
	 * Sorts the given list in place. Worst Case Performance O(nlogn) Best Case
	 * Performance O(nlogn) Average Case Performance O(nlogn)
	 * 
	 * @param A - list that needs to be sorted.
	 */
	public void sort(int[] A) {
		heapSize = new AtomicInteger(A.length); // we need to sort all the list so heapSize == A.length
		buildMaxHeap(A); // first we build max heap
		// now we have the biggest element in the heap on the top
		// we will exchange it with the last element in the list
		// reduce heapSize so this (biggest) element wont be sorted anymore
		// and we will call MaxHeapify once again to get new biggest element on the top
		// and once again we place it at the current end of the list, we do it all the
		// way
		// til we will have only one element left in the heap (which will be the lowest
		// number)
		// this way our array will get sorted, from smallest (at the start of the list)
		// to biggest (at the end of the list).
		for (int i = A.length - 1; i > 0; i--) {
			// exchange biggest number with the current last one
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			// reduce the heap size
			heapSize.decrementAndGet();
			// find new biggest
			maxHeapify(A, 0);
		}
	}

	/**
	 * Builds MaxHeap (runs in linear time so: O(n) ) if n = amount of numbers in
	 * the list, then n/2 = amount of leaves (nodes that have no children) We need
	 * to call MaxHeapify from bottom and up, but we can skip all leaves so we start
	 * at index = n/2 and go up.
	 * 
	 * @param A - list that we will build MaxHeap of.
	 */
	private void buildMaxHeap(int[] A) {
		for (int i = A.length / 2 - 1; i >= 0; i--) {
			maxHeapify(A, i);
		}
	}

	/**
	 * Takes O(logn) or we can also say that if subtree with root at index i has
	 * height of h then running time of algorithm is O(h) (note that a binary tree
	 * with n elements has height = logn) Sorts the array at the given index so that
	 * subtree meets heap requirements.
	 * 
	 * @param A array list
	 * @param i index of the root of subtree that might be smaller than its
	 *          children.
	 */
	private void maxHeapify(int[] A, int i) {

		int l = 2 * i; // lets find left child of the given index.
		int r = 2 * i + 1;// lets find right child of the given index.
		int max = i;

		if (l < heapSize.get() && A[l] > A[i]) {
			// lets check if left child is an existing child
			// if it is an existing child
			// if left child is bigger than parent
			max = l; // left child becomes maximum
		}

		if (r < heapSize.get() && A[r] > A[max]) {
			// lets check if the right child is an existing child
			// if it is existing child
			// if right child is bigger than our current maximum
			max = r; // right child becomes our new maximum
		}

		if (max != i) {
			// if our parent is not maximum
			// we need to swap max with parent
			int temp = A[i];
			A[i] = A[max];
			A[max] = temp;
			// at the end we need to run MaxHeapify on the child that was just swapped
			// and see if it is supposed to go even further down the list
			maxHeapify(A, max);
		}
	}
}
