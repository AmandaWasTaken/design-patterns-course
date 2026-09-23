package sorting;

import java.util.Random;

class CreateData {

	private static Random r = new Random();

	public static int[] create_large_array(){
		
		final int limit = 100000;
		final int max_val = 512;

		int[] res = new int[limit];
		for(int i = 0; i < limit; i++){
			res[i] = r.nextInt(max_val) + 1;
		} 

		return res;
	}

	public static int[] create_small_array(){
		
		final int limit = 128;
		final int max_val = 512;

		int[] res = new int[limit];
		for(int i = 0; i < limit; i++){
			res[i] = r.nextInt(max_val) + 1;
		} 

		return res;
	}
}

class Tests {

	public static void warmup(int[] arr, SortingContext ctx){
		
		final int iters = 10;
		for(int i = 0; i < iters; i++){
			int[] cpy = arr.clone();
			ctx.sort_data(cpy);
		}
	}

	public static void test(int[] arr, SortingContext ctx){

		long start_time = System.nanoTime();
		final int iters = 20;
		for(int i = 0; i < iters; i++){
			int[] cpy = arr.clone();
			ctx.sort_data(cpy);
		}

		long end_time = System.nanoTime();
		double  avg = (end_time - start_time) / 1_000_000.0 / iters;
		System.out.printf("Average of %d sorts: %.6f ms%n", 
				iters, avg);
	}
}

public class Main {

	public static void main (String[] args) {
			
		SortingStrategy selection = new SelectionSort();
		SortingStrategy bubble = new BubbleSort();
		SortingStrategy quick = new QuickSort();

		int[] big_arr   = CreateData.create_large_array();
		int[] small_arr = CreateData.create_small_array();
		SortingContext ctx = new SortingContext(selection);

		Tests.warmup(big_arr, new SortingContext(quick));
		
		System.out.println("------ Large Array Tests ------\n");
		System.out.println("Selection Sort:");
		Tests.test(big_arr, ctx);
		ctx.set_sorting_strategy(bubble);
		System.out.println("Bubble Sort:");
		Tests.test(big_arr, ctx);
		ctx.set_sorting_strategy(quick);
		System.out.println("Quick Sort:");
		Tests.test(big_arr, ctx);

		System.out.println("\n------ Small Array Tests ------\n");
		ctx.set_sorting_strategy(selection);
		System.out.println("Selection Sort:");
		Tests.test(small_arr, ctx);
		ctx.set_sorting_strategy(bubble);
		System.out.println("Bubble Sort:");
		Tests.test(small_arr, ctx);
		ctx.set_sorting_strategy(quick);
		System.out.println("Quick Sort:");
		Tests.test(small_arr, ctx);
	}
}








