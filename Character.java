package Classes;

public class Character {

    String name;
    String job;
    int health;
    int damage;
    int speed;
    int level;
    int exp;

    // Constuctor to initialize character.
    public Character(String name, String job) {
        this.name = name;
        this.job = job;
        this.level = 1;
        this.exp = 0;

        // Set stats based on job
        switch (job.toUpperCase()) {
            case "ARCHER":
                this.health = 70;
                this.damage = 60;
                this.speed = 80;
                break;
            case "WARRIOR":
                this.health = 150;
                this.damage = 50;
                this.speed = 40;
                break;
            case "MAGE":
                this.health = 65;
                this.damage = 90;
                this.speed = 30;
                break;
            case "ASSASSIN":
                this.health = 60;
                this.damage = 70;
                this.speed = 70;
                break;
            default:
                System.out.println("The job you chose is invalid!");
        }
    }
    
    // Getter methods for character attributes.
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getExp() {
        return exp;
    }
    
    // Method for amplify character's stats.
    public void buffChar() {
        this.health = this.health * 2;
        this.damage = this.damage * 2;
        this.speed = this.speed * 3;
    }

    public void attack(String atkChoice, Enemy enemy, Character character) {
        if (atkChoice.equalsIgnoreCase("Normal Punch")) {
            System.out.println("You used Normal Punch!");
            enemy.takeDamage(damage);
        } else if (atkChoice.equalsIgnoreCase("Normal Consecutive Punch")) {
            System.out.println("You used Normal Consecutive Punch!");
            int randDamage = (int)(Math.random() * damage);
            enemy.takeDamage(randDamage);
        } else if (atkChoice.equalsIgnoreCase("Serious Series")) {
            System.out.println("You used Serious Series!");
            character.buffChar();
        } else if (atkChoice.equalsIgnoreCase("Serious Punch")) {
            System.out.println("You used Serious Punch");
            enemy.takeDamage(damage * 2);
        }
    }
    
    // Method to reduce character health after taking damage.
    public void takeDamageChar(int amount) {
        this.health -= amount;
        if (this.health <= 0) {
            System.out.println("You have been defeated!");
        }
    }
    
    // Method to add experience and level up
    public void gainExp(int gainedExp) {
        this.exp += gainedExp;
        if (exp >= 2563) {
            exp -= 2563;
            levelUp();
        }
    }
    
    // Method to level up after reaching or exceeding exp limit.
    public void levelUp() {
        health += 50;
        damage += 20;
        speed += 40;
        
        
        level += 1;
        System.out.println("You have leveled up to level " + level);
    }
}
