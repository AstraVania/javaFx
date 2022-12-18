
public class CustomerService 
{
	private String name;
	private int id;
	private String complaint;
	public CustomerService()
	{

	}
	public CustomerService(String _name , int _id , String _complaint)
	{
		name = _name;
		id = _id;
		complaint = _complaint;
	}
	@Override
	public boolean equals(Object other) 
	{

		if (other == this) 
		{
			return true;
		}
		if (!(other instanceof CustomerService)) 
		{
			return false;
		}
		CustomerService cast = (CustomerService)other;
		return Integer.compare(id, cast.id) == 0;

	}
	public String toString()
	{ 
		return name+" "+id+" "+complaint;
	}


	public void test()//assignment gimel
	{
		CustomerService A = new CustomerService("YOSSI" , 2151116 , "fffffff");
		CustomerService B = new CustomerService("gerom" , 1616151 , "cccccc");
		CustomerService C = new CustomerService("boris" , 1662151 , "bbbbb");
		CustomerService D = new CustomerService("israel" , 1615616 , "aaasd");
		CustomerService G = new CustomerService("testboris" , 1662151 , "sdafafafaf");
		CustomerService F = new CustomerService("testboris" , 12 , "sdafafafaf");
		priorityQueue<CustomerService> CustomerList = new priorityQueue<CustomerService>(15);
		CustomerList.add(A, 8);
		CustomerList.add(B, 10);
		CustomerList.add(C, -1);
		CustomerList.add(D, 2);
		System.out.println(CustomerList);
		System.out.println(CustomerList.remove());
		System.out.println(CustomerList);
		System.out.println(CustomerList.pool());
		System.out.println(CustomerList.contains(G));
		System.out.println(CustomerList.contains(D));
		CustomerList.add(D, 5);
		System.out.println(CustomerList.contains(D));
		System.out.println(CustomerList.contains(F));
	}
}

