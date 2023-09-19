import java.util.*;
class BankAccount
{
String name,user_id,pin,accountno;
String transactionHistory = "";
float balance = 00;
int transaction = 0;

public void signup()
{
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter your Name:");
	name = scan.nextLine();
	System.out.println("Enter your User_ID:");
	user_id = scan.nextLine();
	System.out.println("Enter your Pin:");
	pin = scan.nextLine();
	System.out.println("Enter your Account Number:");
	accountno = scan.nextLine();
	System.out.println("Registration completed.Kindly login..");
	System.out.println("***************************************");
}
public boolean login()
{
	boolean isLogin = false;
	Scanner scan = new Scanner(System.in);
	while(!isLogin)
	{
		System.out.println("Enter your User_ID:");
		String Username = scan.nextLine();
		if(Username.equals(user_id))
		{
			while(!isLogin)
			{
				System.out.println("Enter your Pin:");
				String Pin = scan.nextLine();
				if(Pin.equals(pin))
				{
					System.out.println("Login Successfull...");
					isLogin = true;
				}
				else
				{
					System.out.println("Incorrect pin");
				}
			}
		}
		else
		{
			System.out.println("User_ID not found");
		}
	}
	return isLogin;
}

public void withdraw()
{
	System.out.println("Enter amount to withdraw: ");
	Scanner scan = new Scanner(System.in);
	float amount = scan.nextFloat();
	try
	{
		if(balance >= amount)
		{
			transaction++;
			balance =balance - amount;
			System.out.println("Withdraw Successfully");
			String str = amount + " Withdraw \n";
			transactionHistory = transactionHistory.concat(str);
		}
		else
		{
			System.out.println("Insufficient Balance");
		}
	}
	catch(Exception ex)
	{
	}
	System.out.println("*******************************************");
}
public void deposit()
{
	System.out.println("Enter amount to deposit: ");
	Scanner scan = new Scanner(System.in);
	float amount = scan.nextFloat();
	try
	{
		if(amount <= 10000)
		{
			transaction++;
			balance = balance+amount;
			System.out.println("Successfully Deposited");
			String str = amount + " Deposited \n";
			transactionHistory=transactionHistory.concat(str);
		}
		else 
		{
			System.out.println("Limit is 10000");
		}
	}
	catch(Exception e)
	{
    }
System.out.println("***********************************************");
}
public void transfer()
{
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter receipent's name:");
	String receipent=scan.nextLine();
	System.out.println("Enter amount to transfer:");
	float amount=scan.nextFloat();
	try
	{
		if(balance >=amount)
		{
			if(amount<=50000f)
			{
				transaction++;
				balance=balance-amount;
				System.out.println("Successfully transferred to "+receipent);
				String str=amount +" transferred to " +receipent;
				transactionHistory=transactionHistory.concat(str);
			}
			else
			{
				System.out.println("Sorry!Limit is 50000");
			}
		}
		else
		{
			System.out.println("Insufficient Balance");
		}
	}
		catch(Exception e)
		{
		}
		System.out.println("********************************************");
	}
	
	public void transactionHistory()
	{
		if(transaction == 0)
		{
			System.out.println("\nEmpty");
		}
		else
		{
			System.out.println("\n" + transactionHistory);
		}
		System.out.println("*********************************************");
	}
}

public class ATMInterface
{
	public static int takeIntegerInput(int limit)
	{
		int input=0;
		boolean flag=false;
		
		while(!flag)
		{
			try
			{
				Scanner scan=new Scanner(System.in);
				input=scan.nextInt();
				flag=true;
				
				if(flag && input >limit || input <1)
				{
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}
			catch(Exception e)
			{
				System.out.println("Enter only integer value:");
				flag=false;
			}
		};
		return input;
	}
	
	public static void main(String args[])
	{
		System.out.println("***********Welcome to ATM INTERFACE***********");
		System.out.println("1.Register \n2.Quit");
		System.out.println("Enter your choice:");
		int choice=takeIntegerInput(2);
		
		if(choice==1)
		{
			BankAccount b = new BankAccount();
			b.signup();
			while(true)
			{
				System.out.println("1.Login \n2.Quit");
		System.out.println("Enter your choice:");
		int ch=takeIntegerInput(2);
		
		if(ch==1)
		{
			if(b.login())
			{
				System.out.println("***********Welcome back "+b.name+ "**********");
				boolean isFinished=false;
				while(!isFinished)
				{
					System.out.println("\n1.Transactions History \n2.Withdraw \n3.Deposit \n4.Transfer \n5.Quit");
					System.out.println("Enter your choice: ");
					int c=takeIntegerInput(6);
					switch(c)
					{
						case 1:
						b.transactionHistory();
						break;
						case 2:
						b.withdraw();
						break;
						case 3:
						b.deposit();
						break;
						case 4:
						b.transfer();
						break;
						case 5:
						isFinished=true;
						break;
					}
				}
			}
		}
		else
		{
			System.exit(0);
		}
			}
		}
		else
		{
			System.exit(0);
		}
	}
}
