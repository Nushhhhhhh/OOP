package week6;

class PlayerStats {
 String playerName;
 int age;

 PlayerStats(String playerName, int age) {
     this.playerName = playerName;
     this.age = age;
 }

 void displayInfo() {
     System.out.println("Player: " + playerName + ", Age: " + age);
 }
}

class FootballStats extends PlayerStats {
 int goalsScored;

 FootballStats(String playerName, int age, int goalsScored) {
     super(playerName, age);
     this.goalsScored = goalsScored;
 }

 void displayFootballStats() {
     System.out.println(playerName + " has scored " + goalsScored + " goals.");
 }
}

class CricketStats extends PlayerStats {
 int runsScored;

 CricketStats(String playerName, int age, int runsScored) {
     super(playerName, age);
     this.runsScored = runsScored;
 }

 void displayCricketStats() {
     System.out.println(playerName + " has scored " + runsScored + " runs.");
 }
}

public class StaticDriverClass {
 public static void main(String[] args) {
     FootballStats footballPlayer = new FootballStats("Cristiano Ronaldo", 39, 800);
     CricketStats cricketPlayer = new CricketStats("Virat Kohli", 34, 12000);

     footballPlayer.displayInfo();
     footballPlayer.displayFootballStats();

     cricketPlayer.displayInfo();
     cricketPlayer.displayCricketStats();
 }
}
