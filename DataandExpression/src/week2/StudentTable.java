package week2;

public class StudentTable {

	public static void main(String[] args) {
        System.out.println("//////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println("==\t\tStudent Points\t\t==");
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\////////////////////////");
        System.out.println();
        System.out.println("Name\t\tLab\tBonus\tTotal");
        System.out.println("----\t\t---\t-----\t-----");

        // Print student data
        String student1 = "Alice";
        int lab1 = 45;
        int bonus1 = 5;
        int total1 = lab1 + bonus1;
        System.out.println(student1 + "\t\t" + lab1 + "\t" + bonus1 + "\t" + total1);

        String student2 = "Bob";
        int lab2 = 50;
        int bonus2 = 10;
        int total2 = lab2 + bonus2;
        System.out.println(student2 + "\t\t" + lab2 + "\t" + bonus2 + "\t" + total2);

        String student3 = "Charlie";
        int lab3 = 40;
        int bonus3 = 7;
        int total3 = lab3 + bonus3;
        System.out.println(student3 + "\t" + lab3 + "\t" + bonus3 + "\t" + total3);

        String student4 = "Diana";
        int lab4 = 47;
        int bonus4 = 8;
        int total4 = lab4 + bonus4;
        System.out.println(student4 + "\t\t" + lab4 + "\t" + bonus4 + "\t" + total4);

        String student5 = "Ethan";
        int lab5 = 39;
        int bonus5 = 6;
        int total5 = lab5 + bonus5;
        System.out.println(student5 + "\t\t" + lab5 + "\t" + bonus5 + "\t" + total5);
    }
}