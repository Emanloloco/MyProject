package Classes;

public class Enemy {

    String name;
    String job;
    int health;
    int damage;
    int speed;
    int exp;

    public Enemy(String name, String job, int health, int damage, int exp) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }
    
    // Getter for enemy attributes
    public String getName() {
        return name;
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

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health <= 0) {
            System.out.println("You have defeated the " + name + " !");
        }
    }
}