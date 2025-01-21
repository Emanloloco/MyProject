package Classes;

public class Character {

    String name;
    String job;
    int health;
    int damage;
    int exp;

    public Character(String name, String job, int health, int damage, int exp) {
        this.name = name;
        this.job = job;
        this.health = health;
        this.damage = damage;
        this.exp = exp;
    }

    public void changeJob(String job) {
        boolean loopBreaker = true;
        while (loopBreaker) {
            switch (job) {
                case "Archer":
                    loopBreaker = false;
                case "Warrior":
                    loopBreaker = false;
                case "Mage":
                    loopBreaker = false;
                case "Assassin":
                    loopBreaker = false;
                default:
                    System.out.print("Please type the correct job!");
            }
        }
    }
    
    
}
