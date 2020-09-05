public class Countdown{
	public static int target;

	public static void main(String[] args){
		int arr[] = new int[7];
		
		int i = 0;
		for(String s: args){
			arr[i++] = Integer.parseInt(s);
		}
		target = arr[0];

		int arr2[] = {arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]};

		printAllRecursive(6,arr2);

		System.out.println("No answer found");
	}

	static void printAllRecursive(
	  int n, int[] elements) {
	 
	    if(n == 1) {
	        runPerms(elements);
	    } else {
	        for(int i = 0; i < n-1; i++) {
	            printAllRecursive(n - 1, elements);
	            if(n % 2 == 0) {
	                swap(elements, i, n-1);
	            } else {
	                swap(elements, 0, n-1);
	            }
	        }
	        printAllRecursive(n - 1, elements);
	    }
	}

	static void swap(int[] input, int a, int b) {
	    int tmp = input[a];
	    input[a] = input[b];
	    input[b] = tmp;
	}
	static void printArray(int[] input) {
	    System.out.print('\n');
	    for(int i = 0; i < input.length; i++) {
	        System.out.print(input[i]);
	    }
	}

	static void runPerms(int[] numbers){
		for(int a = 0; a < 5; a++){
			for(int b = 0; b < 5; b++){
				for(int c = 0; c < 5; c++){
					for(int d = 0; d < 5; d++){
						for(int e = 0; e < 5; e++){
							int[] arr = {a,b,c,d,e};
							if(tryPerm(numbers,arr)){
								//fancyPrint(numbers, arr);
								fancyPrint2(numbers, arr);
								System.exit(0);
							}
						}
					}
				}
			}
		}
	}

	static boolean tryPerm(int[] numbers, int[] perm){
		int res = numbers[0];
		for(int i = 1; i < 6; i++){
			res = calcTwo(res, numbers[i], perm[i-1]);
		}
		return check(res);
	}

	static int calcTwo(int a, int b, int op){
		switch(op){
			case 1:
				return a + b;
			case 2:
				return a - b;
			case 3:
				return a * b;
			case 4:
				return a / b;
			default:
				return a;
		}
	}

	static boolean check(int a){
		return target == a;
	}

	static void fancyPrint(int[] num, int[] op){
		StringBuilder sb = new StringBuilder("" + num[0]);
		for(int i = 1; i < 6; i++){
			if(op[i-1] > 0)
				sb.append(getOp(op[i-1]) + num[i]);
		}
		System.out.println(sb.toString());
	}

	static void fancyPrint2(int[] num, int[] op){
		int res = num[0];
		int oldRes = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < 6; i++){
			if(op[i-1] > 0){
				oldRes = res;
				res = calcTwo(res, num[i], op[i-1]);
				sb.append(oldRes + getOp(op[i-1]) + num[i] + " = " + res + "\n");
			}
				
		}
		System.out.println(sb.toString());
	}

	static String getOp(int op){
		switch(op){
			case 1:
				return " + ";
			case 2:
				return " - ";
			case 3:
				return " * ";
			case 4:
				return " / ";
			default:
				return "   ";
		}
	}
}
