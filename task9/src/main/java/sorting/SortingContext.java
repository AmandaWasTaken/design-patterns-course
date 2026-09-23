package sorting;

public class SortingContext {

	private SortingStrategy strat;

	public SortingContext(SortingStrategy strat){
		this.strat = strat;
	}

	public void set_sorting_strategy(SortingStrategy strat){
		this.strat = strat;
	}

	public void sort_data(int[] arr){
		if(strat != null){
			strat.sort_data(arr);
		}
	}
}
