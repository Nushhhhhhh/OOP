package week5;

class MultiSphere {
    
	private double diameter;

    public MultiSphere(double diameter) {
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double calculateVolume() {
        double radius = diameter / 2.0;
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public double calculateSurfaceArea() {
        double radius = diameter / 2.0;
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public String toString() {
        return "Sphere with diameter: " + diameter + "\n" +
        		
               " Volume: " + calculateVolume() + "\n" +
               
               " Surface Area: " + calculateSurfaceArea();
    }
}

public class Sphere {
    public static void main(String[] args) {
        // Create and instantiate several Sphere objects
    	MultiSphere sphere1 = new MultiSphere(10);  // Sphere with diameter 10
    	MultiSphere sphere2 = new MultiSphere(15);  // Sphere with diameter 15
    	MultiSphere sphere3 = new MultiSphere(20);  // Sphere with diameter 20

        // Display initial details of the spheres
    	 System.out.println(sphere1);
         System.out.println();
         System.out.println(sphere2);
         System.out.println();
         System.out.println(sphere3);
         
        // Update the diameter of sphere2 and sphere3 using the setter
        sphere2.setDiameter(12);
        sphere3.setDiameter(25);

        // Display updated details of the spheres
        System.out.println("\n\nAfter updating diameters:");
        System.out.println(sphere1);
        System.out.println();
        System.out.println(sphere2);
        System.out.println();
        System.out.println(sphere3);
    }
}
