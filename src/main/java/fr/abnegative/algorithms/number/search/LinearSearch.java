package fr.abnegative.algorithms.number.search;

public class LinearSearch {

	public int search(int[] data, int value) {

		if (data.length > 0) {

			var lim = data.length - 1;

			if (value > data[lim] || value < data[0])
				return -1;

			for (var i = 0; i <= lim; i++) {

				if (data[i] == value) {
					return i;
				}
			}
		}

		return -1;
	}
}
