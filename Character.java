package Classes;

public class Character {

    String name;
    String job;
    int health;
    int originalHealth;
    int damage;
    int originalDamage;
    public int speed;
    int originalSpeed;
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
                this.health = 250;
                this.originalHealth = 250;
                this.damage = 60;
                this.originalDamage = 60;
                this.speed = 80;
                this.originalSpeed = 80;
                break;
            case "WARRIOR":
                this.health = 300;
                this.originalHealth = 300;
                this.damage = 50;
                this.originalDamage = 50;
                this.speed = 50;
                this.originalSpeed = 50;
                break;
            case "MAGE":
                this.health = 130;
                this.originalHealth = 130;
                this.damage = 90;
                this.originalDamage = 90;
                this.speed = 40;
                this.originalSpeed = 40;
                break;
            case "ASSASSIN":
                this.health = 120;
                this.originalHealth = 120;
                this.damage = 70;
                this.originalDamage = 70;
                this.speed = 95;
                this.originalSpeed = 95;
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

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getExp() {
        return exp;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }

    // Method to amplify character's stats.
    public void buffChar() {
        this.health = this.health * 10;
        this.damage = this.damage += 150;
        this.speed = this.speed * 10;
    }

    public void attack(String atkChoice, Enemy enemy, Character character) {
        if (atkChoice.equalsIgnoreCase("Normal Punch")) {
            System.out.println("You used Normal Punch!");
            enemy.takeDamage(damage);
        } else if (atkChoice.equalsIgnoreCase("CNP")) {
            System.out.println("You used Consecutive Normal Punch!");
            enemy.takeDamage(damage * 2);
        } else if (atkChoice.equalsIgnoreCase("Serious Series")) {
            System.out.println("You used Serious Series!");
            character.buffChar();
        } else if (atkChoice.equalsIgnoreCase("Serious Punch")) {
            System.out.println("You used Serious Punch");
            enemy.takeDamage(damage * 3);
        }
    }

    // Method to reduce character health after taking damage.
    public void takeDamageChar(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0;
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
    
    // Reset character stats to default values.
    public void resetCharacter() {
        this.health = this.originalHealth;
        this.damage = this.originalDamage;
        this.speed = this.originalSpeed;
        this.level = 1;
        this.exp = 0;
    }
}
