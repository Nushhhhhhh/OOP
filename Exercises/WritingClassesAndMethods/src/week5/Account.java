package week5;

	class Accounts {
    String name;
    int accountNumber;
    double balance;

    public Accounts(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Accounts(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;  // Default initial balance
    }

    public void show() {
        System.out.println("Name: " + name + ", Account Number: " + accountNumber + ", Balance: $" + balance+"\n");
    }
}
	
	public class Account {
	    public static void main(String[] args) {
	        Accounts account1 = new Accounts("Alice", 12345, 500);
	        Accounts account2 = new Accounts("Bob", 67890);
	        account1.show();
	        account2.show();
	    }
	}

