
public class Main {

	public static void main(String[] args) 
	{
		priorityQueue<String> list = new priorityQueue<String>(10);
		System.out.println(list.pool());
		list.add("one", 3);
		list.add("two", 2);
		list.add("ten", 6);
		list.add("four", 1);
		list.add("five", 10);
		list.add("six", 0);
		list.add("seven", -5);
		System.out.println(list.pool());
		System.out.println(list.pool());
		System.out.println(list.contains("NULL"));
		list.add("zero", 7);
		list.add("you", 9);
		list.add("me", 5);

		System.out.println(list);
		System.out.println(list.remove());
		System.out.println(list);
		list.setIterator();
		String ite = list.iterator();
		System.out.println(ite);
		ite = list.iterator();
		System.out.println(ite);
		ite = list.iterator();
		System.out.println(ite);
		ite = list.iterator();
		System.out.println(ite);
		System.out.println("ite test");
		System.out.println(list);
		list.setIterator();
		while (ite != null)
		{
			ite = list.iterator();
			if(ite!=null)
				System.out.print(ite+ " ");
		}
		System.out.println(" ");

		CustomerService A = new CustomerService();

		A.test();




	}

}
