package fr.abnegative.algorithms.number.search;

public class DichotomicSearch {

	public boolean search(int[] ints, int k) {

		int n = ints.length;

		if (ints.length > 0) {

			var from = 0;
			var position = 1;
			int to = n - 1;
			int half;


			if (k < ints[from] || k > ints[to]) return false;

			
			do {
				half = (from + to) / 2;

				if (k == ints[half])
					position = half;

				else if (k > ints[half])
					from = half + 1;

				else
					to = half - 1;

			} while ((k != ints[half]) && (from <= to));

			return ints[position] == k;

		} else
			return false;
	}
}
