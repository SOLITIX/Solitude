import java.util.*;
class data
{
	
String name;
int age;
int roll;
double cgpa;
String branch;
char sec;
String clg_name;



data(String s,int a,int r,double cg,String br,char ss,String cl)
{
	
	name = s;
	age = a;
	roll = r;
	cgpa = cg;
	branch = br;
	sec = ss;
	clg_name = cl;
	
}
public void display()
{
	System.out.println(name +" "+ age +" "+ roll +" "+ cgpa +" "+ branch +" "+ sec +" "+ clg_name);
	System.out.println();
}
}


class Student
{
	int n;
	data ar [];
	
	Student(int l)
	{
		n=l;
		ar = new data[n];
	}
	public void insert()
	{
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<n;i++)
		{
				System.out.println("Enter name");
				String n1 = sc.next();
				System.out.println("Enter age");
				int a = sc.nextInt();
				System.out.println("Enter roll no");
				int r = sc.nextInt();
				System.out.println("Enter cgpa");
				double d = sc.nextDouble();
				System.out.println("Enter Branch");
				String s = sc.next();
				System.out.println("Enter Sec");
				char c = sc.next().charAt(0);
				System.out.println("Enter Collage Name");
				String clg= sc.next();
				
				ar[i] = new data(n1,a,r,d,s,c,clg);
				
				
			
		}
		
		
		
	}
		
	public int find(data[] r,int R)
	{
	
		for(int i=0;i<r.length;i++)
		{
			
			if(r[i].roll == R)
				return i;
			
			
		}
		return -1;
		
	}
	
	public void sortRoll()
	{
		for(int i=0;i<ar.length;i++)
		{
			
			for(int j=i+1;j<ar.length;j++)
			{
				if(ar[j].roll < ar[i].roll)
				{
					int temp = ar[i].roll;
					ar[i].roll = ar[j].roll;
					ar[j].roll = temp;
				}
				
			}
		}
				
	}
	
	
	public void delete(int R)
	{
		
		int x = find(ar,R);
		if(x!=-1)
		{
		if(x != ar.length-1)
		{
		ar[x] = null;
		ar[x] = ar[x+1];
		}
		else
			ar[x] = null;
		}
		
		else {
			
			System.out.println("Roll no not Present in database");
		}
		
	}
	
	
	public void sort()
	{
		String temp = "";
		for(int i=0;i<ar.length;i++)
		{
			
			for(int j=i+1;j<ar.length;j++)
			{
				
				if(ar[i].name.compareTo(ar[j].name) > 0)
				{
					temp = ar[i].name;
					ar[i].name = ar[j].name;
					ar[j].name = temp;
				}
			}
		}
		
	}
	
}



 class StudentDatabase 
{
	
	public static void main(String[] args)
	 {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no of entries want to insert");
		int n = sc.nextInt();
		int ch;
		System.out.println("Enter choice");
		System.out.println();
		System.out.println("1: For Creating Record");
		System.out.println("2: For Display Record according to Roll no");
		System.out.println("3: For deleting a Record");
		System.out.println("4: Display Student record in Sorted Sequence");
		System.out.println("5: Quit");
		ch = sc.nextInt();
		Student b = new Student(n);
		
		
		while(ch!=0)
		{
			
			switch(ch)
			{
			case 5:
				System.exit(0);
				break;
			case 1:
				
				b.insert();
				
				break;
				
			case 3:
				if(b.ar[0]!=null) {
				System.out.println("Enter roll no to be deleted");
				int r = sc.nextInt();
				 b.delete(r);
				 n--;
				}
				else
					System.out.println("No Elements to delete");
				
				 
				 break;
				 
			case 4:
				if(b.ar[0]!=null) {
				b.sort();
				for(int j=0;j<n;j++)
				{
					b.ar[j].display();
				}
				}
				
				else
					System.out.println("No Elements to Sort");
				
				break;
				
			case 2:
				if(b.ar[0]!=null)
				 {
					b.sortRoll();
					for(int j=0;j<n;j++)
						b.ar[j].display();
				 }
				else
					System.out.println("No Elements to Display");
				
				break;
			
			}
		    System.out.println("Enter choice again");
		    ch = sc.nextInt();	
		}
	}
}
