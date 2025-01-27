package Classes;

import Classes.Character;

public class Enemy {

    String name;
    int health;
    int maxHealth;
    int damage;
    public int speed;
    public int exp;

    public Enemy(String name, int health, int damage, int speed, int exp) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.speed = speed;
        this.exp = exp;
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
        if (this.health < 0) {
            this.health = 0;
        }
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getMaxHealth(Enemy enemy) {
        return maxHealth;
    }
    
    public void resetEnemy() {
        this.health = this.maxHealth;
    }
}
