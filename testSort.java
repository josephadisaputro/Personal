package fun3;

public class testSort {
	
	public static void insertionSort(int[] arr){
		
		if(arr.length < 2){
			System.out.println("it is too short!");
			if(arr[0] > arr[1]){
				int tmp = arr[1];
				arr[1] = arr[0];
				arr[0] = tmp;
			}else{
				System.out.println("it is sorted already");
			}
		}else{
			int pointer;
			int current = 1;
			int past = 0;
			for (int i = 0; i < arr.length; i++){
				pointer = arr[current];
				while(past >= 0 && arr[past] > pointer){
					arr[current] = arr[past];
					arr[past] = pointer;
					past--;
					current--;
				}
				past = i;
				current = i+1;
				
			}
		}
	}
	
	/*public static void insertionSort(int[] data){
		
		int n = data.length;
		for(int k = 1; k <n; k++){
			int cur = data[k];
			int j = k;
			while(j>0 && data[j-1] >cur){
				data[j] = data[j-1];
				j--;
			}
			data[j] = cur;
		}
		
	}
	
	public static int[] appendINbetween(int[] arr, int index, int value){
		if(index < arr.length){
			int[] newARR = new int[arr.length+1];
			for(int i = 0; i<index+1; i ++){
				if(i != index){
					newARR[i] = arr[i];
				}else{
					newARR[i] = value;
				}
			}
			for(int i = index+1; i<newARR.length; i ++){
				newARR[i] = arr[index];
				index++;
			}
			return newARR;
		}
		return arr;
	}*/
	
	public static boolean BinarySearch(int[] arr, int target, int low, int high){
		if(low > high){
			System.out.println("something is really wrong!");
			return false;
		}
		int mid = (high+low)/2;
		if(target == arr[mid]){
			return true;
		}else if(target < arr[mid]){
			return BinarySearch(arr, target, low, mid-1);
		}else {
			return BinarySearch(arr, target, mid+1, high);

		}
	}
	
	public static void main(String[] args){
		int[] array = new int[10];
		array[0] = 9;
		array[1] = 0;
		array[2] = 3;
		array[3] = 4;
		array[4] = 6;
		array[5] = 5;
		array[6] = 7;
		array[7] = 8;
		array[8] = 1;
		array[9] = 2;
		
		//int index = 5;
		//int value = 99;
		//int[] arr = appendINbetween(array, index, value);
		insertionSort(array);
		System.out.println(BinarySearch(array, 1, 0, 9));
		
		for(int i =0; i < array.length; i++){
			System.out.println(array[i]);
		}
		//System.out.println(array);
		
		
		
		
	}
	

}
