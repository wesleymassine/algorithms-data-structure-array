package com.array;

import java.util.Arrays;

public class Anagram implements Comparable {
	
	String str;
	
	public Anagram(String str) {
		this.str = str;
	}
	
	public String getSortedString() {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		
		return new String(arr);
	}
	
//	@Override
//	public int compareTo(Anagram o) {
//		return getSortedString().compareTo(o.getSortedString());
//	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return getSortedString().compareTo(((Anagram) o).getSortedString());
	}
	
	@Override
	public String toString() {
		return str.toString();
	}
	
}
