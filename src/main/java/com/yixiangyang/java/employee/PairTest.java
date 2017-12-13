package com.yixiangyang.java.employee;

public class PairTest {

	public static void main(String[] args) {
		//String[] words = {"Mary","had","a","little","lab"};
		String[] words = {"5","4","3","9","8"};
		Pair<String> mm = ArrayAlg.minmax(words);
		System.out.println("min="+mm.getFirst());
		System.out.println("max="+mm.getSecond());
		System.out.println("Mary".compareTo("a") >0);

	}
	 static class ArrayAlg{
		public static Pair<String> minmax(String[] a){
			if(a == null || a.length == 0){return null;}
			String min = a[0];
			String max = a[0];
			for(int i=0;i<a.length;i++){
				if(min.compareTo(a[i]) > 0){min = a[i];}
				if(max.compareTo(a[i]) < 0){max = a[i];}
			}
			return new Pair<String>(min, max);
		}
	}
}
