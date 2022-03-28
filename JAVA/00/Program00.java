public class Program00 {
	
	public static double average(double[] array) {
		double sum = 0;
		for(double val : array){
			sum += val;
		}
		return (double)sum / array.length;
	}

	public static double maximum(double[] array) {	
		double tmp = array[0];
		for(double val : array){
			if(val > tmp) tmp = val;
		}
		return tmp;
	}


	public static double minimum(double[] array) {	
		double tmp = array[0];
		for(double val : array){
			if(val < tmp) tmp = val;
		}
		return tmp;
	}

	public static void draw(double[] array){
		double min_val = minimum(array);
		double max_val = maximum(array);
		double step = (max_val - min_val) / 5.0;
		int tmp;
		for(int i = 0 ; i < 5 ; i ++){
			tmp = 0;
			for(double val: array){
				if(val >= min_val+i*step && val <= min_val+(i+1)*step) tmp++;
			}
			for(int j = 0 ; j < tmp; j ++)
				System.out.print("*");
			System.out.print("\n");
		}
	}

	public static void main (String args[]) {

		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		
		double[] arr;
		arr = new double[n];

		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < k ; j ++)
				arr[i] += Math.random();
		}

		System.out.println("Average: " + average(arr));
		System.out.println("Maximum: " + maximum(arr));
		System.out.println("Minimum: " + minimum(arr));
		draw(arr);
	}
}
