package week6;

class Employee {
 String name;
 int id;

 Employee(String name, int id) {
     this.name = name;
     this.id = id;
 }

 void displayInfo() {
     System.out.println("Employee: " + name + ", ID: " + id);
 }
}

class Doctor extends Employee {
 Doctor(String name, int id) {
     super(name, id);
 }

 void treatPatient() {
     System.out.println("Doctor " + name + " is treating a patient.");
 }
}

class Nurse extends Employee {
 Nurse(String name, int id) {
     super(name, id);
 }

 void assistPatient() {
     System.out.println("Nurse " + name + " is assisting patients.");
 }
}

class Receptionist extends Employee {
 Receptionist(String name, int id) {
     super(name, id);
 }

 void manageReception() {
     System.out.println("Receptionist " + name + " is managing the reception.");
 }
}

class Cleaner extends Employee {
 Cleaner(String name, int id) {
     super(name, id);
 }

 void cleanHospital() {
     System.out.println("Cleaner " + name + " is cleaning the hospital.");
 }
}

public class DriverClass {
 public static void main(String[] args) {
     Doctor doctor = new Doctor("Dr. Ram Prasai", 101);
     Nurse nurse = new Nurse("Lalita Shahi", 102);
     Receptionist receptionist = new Receptionist("Ahruhi Shrestha ", 103);
     Cleaner cleaner = new Cleaner("Hari Rai", 104);

     doctor.displayInfo();
     doctor.treatPatient();

     nurse.displayInfo();
     nurse.assistPatient();

     receptionist.displayInfo();
     receptionist.manageReception();

     cleaner.displayInfo();
     cleaner.cleanHospital();
 }
}
