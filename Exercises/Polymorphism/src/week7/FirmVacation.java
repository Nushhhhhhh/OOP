package week7;

interface Employee {
    void vacation();
}

class Manager implements Employee {
    private String name;
    private String address;

    public Manager(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void vacation() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Vacation Days: 30");
        System.out.println("------------------------");
    }
}

class Developer implements Employee {
    private String name;
    private String address;

    public Developer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void vacation() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Vacation Days: 20");
        System.out.println("------------------------");
    }
}

class Intern implements Employee {
    private String name;
    private String address;

    public Intern(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void vacation() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Vacation Days: 10");
        System.out.println("------------------------");
    }
}

public class FirmVacation {
    public static void main(String[] args) {
        Employee e;

        e = new Manager("Alice", "123 Main St");
        e.vacation();

        e = new Developer("Bob", "456 Elm St");
        e.vacation();

        e = new Intern("Charlie", "789 Oak St");
        e.vacation();
    }
}
