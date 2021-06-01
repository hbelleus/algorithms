package fr.abnegative.algorithms.number.sort;

public class BubbleSort implements Sorter {

	@Override
	public void sort(int[] A) {

		int n = A.length;
		var temp = 0;
		for (var i = 0; i < n; i++) {
			for (var j = 1; j < (n - i); j++) {
				if (A[j - 1] > A[j]) {
					// swap the elements!
					temp = A[j - 1];
					A[j - 1] = A[j];
					A[j] = temp;
				}
			}
		}
	}

}
