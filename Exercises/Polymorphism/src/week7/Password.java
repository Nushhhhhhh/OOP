package week7;

interface Encryptable {
    String encrypt(String text);
    String decrypt(String text);
}

class Secret implements Encryptable {
    public String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            encrypted.append((char) (text.charAt(i) + 3)); // Shift each char by 3
        }
        return encrypted.toString();
    }

    public String decrypt(String text) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            decrypted.append((char) (text.charAt(i) - 3)); // Shift back by 3
        }
        return decrypted.toString();
    }
}

class Passcode implements Encryptable {
    // XOR encryption method shifted by 2
    public String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        char key = 'J';  // XOR key 
        for (int i = 0; i < text.length(); i++) {
            encrypted.append((char) (text.charAt(i) ^ key)); // XOR each char with key
        }
        return encrypted.toString();
    }

     public String decrypt(String text) {
        StringBuilder decrypted = new StringBuilder();
        char key = 'J';  
        for (int i = 0; i < text.length(); i++) {
            decrypted.append((char) (text.charAt(i) ^ key)); // XOR again to decrypt
        }
        return decrypted.toString();
    }
}

public class Password {
    public static void main(String[] args) {
        Encryptable e;

        // Secret encryption
        e = new Secret();
        String encryptedSecret = e.encrypt("Hello");
        System.out.println("Encrypted Secret: " + encryptedSecret);
        System.out.println("Decrypted Secret: " + e.decrypt(encryptedSecret)+"\n");

        // Passcode encryption
        e = new Passcode();
        String encryptedPassword = e.encrypt("World");
        System.out.println("Encrypted Password: " + encryptedPassword);
        System.out.println("Decrypted Password: " + e.decrypt(encryptedPassword));
    }
}
