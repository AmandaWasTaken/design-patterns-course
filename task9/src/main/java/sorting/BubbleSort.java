package sorting;

public class BubbleSort implements SortingStrategy {

	@Override
	public void sort_data(int[] arr){
		
		int i, j, tmp;
		int n = arr.length;
		boolean swapped;
		
		for(i = 0; i < n - 1; i++){
			swapped = false;
			for(j = 0; j < n - i - 1; j++){
				if(arr[j] > arr[i]){
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					swapped = true;
				}
			}
			if(!swapped) break;
		}
	}
}
