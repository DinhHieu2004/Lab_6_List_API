package Task2;

public class Test {
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		System.out.println(" ---original list---");
		list.display();
		// remove first
		
		//System.out.println("remove first Node: "+list.removeFirst());
		
		
		System.out.println("--List after remove lastNode--:"+list.removeLast());
		list.display();
		//list.removeForIndex(1);
    	//list.addForIndex(2, 5);
		System.out.println("----list after remove for index-----");
		list.display();
	}

}
