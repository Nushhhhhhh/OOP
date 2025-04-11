package week5;

	class Light {
    private boolean isOn; 
    
    public void turnOn() {
        isOn = true;
    }
    public void turnOff() {
        isOn = false;
    }

    public void showState() {
        if (isOn) {
            System.out.println("The bulb is ON.");
        } else {
            System.out.println("The bulb is OFF.");
        }
    }
}

	public class Bulb {
	    public static void main(String[] args) {
	        Light bulb1 = new Light(); 
	        Light bulb2 = new Light();
	        Light bulb3 = new Light();

	        bulb1.turnOn(); 
	        bulb2.turnOff(); 
	        bulb3.turnOn(); 
	        
	        bulb1.showState();
	        bulb2.showState();
	        bulb3.showState();
	    }
	}
