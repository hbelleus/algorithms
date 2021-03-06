package fr.abnegative.algorithms.number.sort;

public class MergeSort implements Sorter {

	/**
	 * Sorts the given list. (Not in place) Worst Case Performance O(nlogn) Best
	 * Case Performance O(nlogn) Average Case Performance O(nlogn)
	 * 
	 * @param A list of int array.
	 */
	public void sort(int[] A) {
		sort(A, 0, A.length);
	}

	private void sort(int[] A, int lo, int hi) {

		if (hi - lo <= 1)
			return; // only one element in the array, return.
		int mid = lo + (hi - lo) / 2; // find middle
		sort(A, lo, mid); // sort first part
		sort(A, mid, hi); // sort second part
		merge(A, new int[A.length], lo, mid, hi); // merge both parts
	}

	/**
	 * Merges two arrays into one.
	 * 
	 * @param A    array that contains the two arrays.
	 * @param temp temporary array that we will work with
	 * @param lo   lowest index value in the array
	 * @param mid  middle index value in the array (represents break between low and
	 *             high values)
	 * @param hi   highest index value in the array
	 */
	private void merge(int[] A, int[] temp, int lo, int mid, int hi) {
		int i = lo;
		int j = mid;
		for (int k = lo; k < hi; k++) {
			if (i == mid)
				temp[k] = A[j++]; // if lo-mid array is empty
			else if (j == hi)
				temp[k] = A[i++]; // if mid-hi array is empty
			else if (A[j] > A[i])
				temp[k] = A[i++]; // i is lower so we put it in the array first
			else
				temp[k] = A[j++]; // j is lower or equal to i, so we put it in the array first.
		}
		// now we need to copy back temp array to its place in A array
		System.arraycopy(temp, lo, A, lo, hi - lo);// we are copying only the numbers we just merged.

	}
}