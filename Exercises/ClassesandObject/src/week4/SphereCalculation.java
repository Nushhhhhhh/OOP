package week4;
import java.util.Scanner;

class Sphere {
    double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public void display() {
        System.out.println("Radius: " + radius);
        System.out.printf("Volume: %.4f%n", calculateVolume());
        System.out.printf("Surface Area: %.4f%n", calculateSurfaceArea());
    }
}

public class SphereCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the sphere: ");
        double radius = scanner.nextDouble();

        Sphere sphere = new Sphere(radius);
        sphere.display();

        scanner.close();
    }
}
