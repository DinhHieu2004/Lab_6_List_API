package Task1;

import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		//add
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(2);
		//Add for index
		list.add(3,8);
		for (int i = 0; i < list.size(); i++) {
			System.out.print("[" + list.get(i) + "]" + "");
		}
		System.out.println();
		// indexOf
		
		System.out.println(list.indexOf(4));
		// lastIndexOf
		System.out.println("method lastIndexOf: " + list.lastIndexOf(2) + "\n");
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o1 - o2;
			}
		});
		for (int i = 0; i < list.size(); i++) {
			System.out.print("[" + list.get(i) + "]" + "");
		}
		System.out.println();
		
		//contains
		System.out.println("method contain: " + list.contains(2) + "\n");

		//remove
		list.remove(2);
		for (int i = 0; i < list.size(); i++) {
			System.out.print("[" + list.get(i) + "]" + "");
		}
		System.out.println();
		
		//test toArray method
		for (Integer i : list.toArray()) {
			System.out.print(i+" ");
		}
		//test clear method
		
		list.clear();
		System.out.println(list.size());
		
		
	}

}
