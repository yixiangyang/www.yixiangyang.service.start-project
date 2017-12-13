package com.yixiangyang.java.employee;

/**
 * 通配符的测试使用
 * 2017-11-29
 * @author 伊向阳
 *
 */
public class PairTest3 {

	public static void main(String[] args) {
		Manager ceo = new Manager("王总", 80000, 2003, 12, 15);
		Manager cfo = new Manager("张三", 60000, 2003, 12, 15);
		Pair<Manager> buddies = new Pair<Manager>(ceo, cfo);
		printBuddies(buddies);
		ceo.setBonus(100000);
		cfo.setBonus(2000);
		Manager[] managers = {ceo,cfo};
		Pair<Employee> result = new Pair<Employee>();
		System.out.println("aaa");
		minmaxBonus(managers, result);
		System.out.println("first:"+result.getFirst().getName()+",second:" + result.getSecond().getName());
		maxminBonus(managers, result);
		System.out.println("first:"+result.getFirst().getName()+",second:"+result.getSecond().getName());

	}
	//输出两个哥们儿
	public static void printBuddies(Pair<? extends Employee> p){
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println(first.getName() + " AND :"+second.getName() +"是一个哥们");
	}
	//大的奖金和小的奖金
	public static void minmaxBonus(Manager[] a,Pair<? super Manager> result){
		if(a==null || a.length == 0){return ;}
		Manager min = a[0];
		Manager max = a[0];
		for(int i=1 ;i<a.length;i++){
			if(min.getBonus() > a[i].getBonus()){min=a[i];}
			if(min.getBonus() < a[i].getBonus()){max=a[i];}
		}
		result.setFirst(min);
		result.setSecond(max);
	}
	public static void maxminBonus(Manager[] a,Pair<? super Manager> result){
		minmaxBonus(a, result);
		PairAlg.swapHelper(result);
	}
}
class PairAlg{
	public static boolean hasNulls(Pair<?> p){
		return p.getFirst() ==null || p.getSecond() == null;
	}
	public static void swap(Pair<?> p){swapHelper(p);}
	public static <T> void swapHelper(Pair<T> p){
		T t = p.getFirst();
		p.setFirst(t);
		p.setSecond(t);
	}
}
