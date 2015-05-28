import java.util.*;
public class  Fruit implements Comparable<Fruit>
{
	public static final String Fruit_name = null;
	String FruitName;
	int Price;
	public Fruit(String Name, int Price)
	{
		this.FruitName = Name;
		this.Price = Price;
	}
	
	public int compareTo(Fruit other)
	{
		int other_price = other.Price;
		return this.Price - other_price;
	}
	
	public String get_name()
	{
		return this.FruitName;
	}
	
	class Name_compare implements Comparator<Fruit>
	{


		@Override
		public int compare(Fruit fruit1, Fruit fruit2)
		{
			// TODO Auto-generated method stub
			String name1 = fruit1.FruitName;
			String name2 = fruit2.FruitName;
			return name1.compareToIgnoreCase(name2);
		}

		
	}
	public static Comparator<Fruit> name_comparator = new Comparator<Fruit>(){
		public int compare(Fruit fruit1, Fruit fruit2)
		{
			// TODO Auto-generated method stub
			String name1 = fruit1.FruitName;
			String name2 = fruit2.FruitName;
			return name1.compareToIgnoreCase(name2);
		}
	};
	
	//OK, let's test it out
	public static void main (String[] args)
	{
		Fruit[] tester = new Fruit[4];
		tester[0] = new Fruit("Apple", 10);
		tester[1] = new Fruit("Banana", 15);
		tester[2] = new Fruit("Peach", 20);
		tester[3] = new Fruit("Orange", 25);
		Arrays.sort(tester);
		System.out.println("Sorting according to the price: ");
		for (int i =0; i< tester.length; i++)
		{
			System.out.println(tester[i].FruitName+", and its price: "+tester[i].Price);
		}
		Arrays.sort(tester, Fruit.name_comparator);
		System.out.println("Sorting according to the name: ");
		for (int i =0; i< tester.length; i++)
		{
			System.out.println(tester[i].FruitName+", and its price: "+tester[i].Price);
		}
		
	}
	




}


