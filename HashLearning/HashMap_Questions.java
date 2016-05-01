package HashLearning;

import java.util.*;

public class HashMap_Questions {
          
	public static int[] PrintTimeOfNnumbers_HashMap(int[] a, int n){
		int[] result = new int[a.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : a){
			if(map.containsKey(i)){
				int temp = map.get(a);
				temp++;
				map.put(i, temp);
			}else {
				map.put(i, 1);
			}
		}
		int counter = 0;
		Set<Integer> set = map.keySet();
		for(Integer i : set){
			if(map.get(i) > n) {
				result[counter] = i;
				counter++;
			}
		}
	    return result;
	}
	
	/*
	 *  leetcode 336 Palindrome Pairs
	 *  
	 */
	public List<List<Integer>> Palindrome_Pair(String[] str){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(str == null) return result;
		
		Map<String, Integer> map= new HashMap<String, Integer>();
		//store all words into hashmap;
		for(int i = 0; i < str.length; i++){
			map.put(str[i], i);
		}
		return result;
		
		
	}
	
	public String reverse(String str){
		StringBuilder reverse = new StringBuilder(str);
		return reverse.reverse().toString();
	}
	
	public boolean isPalindrome(String str){
		int length = str.length();
		for(int i = 0; i < length/2; i++){
			if(str.charAt(i) != str.charAt(length -1 - i)) return false;
		}
		return true;
	}
	
	
}
