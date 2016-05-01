package HashLearning;
import java.util.*;

public class HashCode_Research {
 
	/*
	 * this class is used for research the hashcode() is equal if multiple objects are same or not
	 * Because in the class, we already knows if two object.equal() is true, the hashcode() should be same
	 * but even hashcode() are same, we cant make sure those objects are same vaule
	 * in java JDK 1.8, it says hashcode is checking the address but after saw the source code of String.hashcode
	 * I realized it is just a algorithm. so I am going to wrote this for test the hashcode
	 */
	
	public static void main(String[] agrs){
		int counter = 0; //used for checking how many time that hashcode are equals
		ArrayList<Integer> Array = new ArrayList<Integer>();
		
		for(int i = 0; i < 10000; i++){
			Object obj = new Object();
			if(!Array.contains(obj.hashCode())){
				Array.add(obj.hashCode());
				System.out.println(obj + "it is the address");
			}
			else {
				counter++;
				System.out.println(obj.hashCode() + "is exist!");
			}
		}
		System.out.println(counter + " number of hashcode are same");
		Iterator<Integer> iter = Array.iterator();
		while(iter.hasNext()){
		System.out.println(iter.next());
		}
		/*
		 * nothing shows, we created 10000 different objects with different address but no hashcode are same, 
		 * so it means if address are different, the hashcode will be not same as all
		 */
	}
}
