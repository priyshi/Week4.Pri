package week5;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	
	public static void removeDuplicates(int a[]) {
		
		Set<Integer> re= new LinkedHashSet<Integer>();
		
		for(int i=0; i<a.length;i++) {
			re.add(a[i]);
		}
		
		System.out.println("Removed Duplicates:"+re);
	    Object[] arr=re.toArray();
	    System.out.println(arr[arr.length-2]);
	    
		
	}
	
	public static void main(String[] args) {
		int arr[]= {3,4,5,5,4,8,9,10,8};
		
		removeDuplicates(arr);
		

	}

}
