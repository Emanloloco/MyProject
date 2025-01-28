package roleplayinggame;

import java.util.Scanner;
import Classes.Character;
import Classes.Enemy;

public class RolePlayingGame {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Dragon Slayer Survival");
        System.out.println("What is the name of your character?");
        String charName = myObj.nextLine();
        System.out.println();

        String charJob = "";
        boolean validJob = false;
        do {
            System.out.println("Choose your job: \nArcher \nWarrior \nMage \nAssassin");
            charJob = myObj.nextLine();
            System.out.println();

            switch (charJob.toUpperCase()) {
                case "ARCHER":
                case "WARRIOR":
                case "MAGE":
                case "ASSASSIN":
                    validJob = true;
                    break;
                default:
                    System.out.println("The job you chose is invalid!");
                    System.out.println();
            }
        } while (!validJob);

        Character heroChar = new Character(charName, charJob);

        Enemy goblin = new Enemy("Goblin", 200, 50, 30, 1000);
        Enemy ogre = new Enemy("Ogre", 250, 40, 40, 2000);
        Enemy centaur = new Enemy("Centaur", 225, 45, 60, 3000);
        Enemy orc = new Enemy("Warlock", 240, 50, 80, 5000);
        Enemy dragon = new Enemy("Dragon", 500, 70, 95, 10000);

        // Game loop
        boolean loopBreaker = true;
        Enemy[] enemies = {goblin, ogre, centaur, orc, dragon};
        while (loopBreaker) {
            for (int i = 0; i < enemies.length; i++) {

                Enemy enemy = enemies[i];

                System.out.println("A " + enemy.getName() + " challenges you to a battle!");
                System.out.println();

                double heroCharTurnGauge = 0;
                double enemyTurnGauge = 0;
                final int turnThreshold = 100;

                // Turn based loop (Based on the speed of character and enemy).
                while (enemy.getHealth() > 0 && heroChar.getHealth() > 0) {

                    // Increase turn gauges based on speed.
                    heroCharTurnGauge += heroChar.getSpeed();
                    enemyTurnGauge += enemy.getSpeed();

                    if (heroCharTurnGauge >= turnThreshold && enemyTurnGauge >= turnThreshold) {
                        // Simultaneous turns: Faster speed goes first.
                        if (heroChar.getSpeed() >= enemy.getSpeed()) {
                            heroCharTurnGauge -= turnThreshold; // Character acts
                            System.out.println("Your Health: " + heroChar.getHealth() + "\n" + enemy.getName() + "'s Health: " + enemy.getHealth());
                            System.out.println("Choose an attack: Normal Punch, Consecutive Normal Punch(CNP), Serious Series, Serious Punch");
                            String atkChoice = myObj.nextLine();
                            heroChar.attack(atkChoice, enemy, heroChar); // Character attacks
                            System.out.println();

                            if (enemy.getHealth() > 0) { // Enemy still alive, gets its turn
                                enemyTurnGauge -= turnThreshold;
                                System.out.println(enemy.getName() + " attacks you!");
                                heroChar.takeDamageChar(enemy.getDamage());
                                System.out.println();
                            }
                        } else {
                            enemyTurnGauge -= turnThreshold; // Enemy acts
                            System.out.println(enemy.getName() + " attacks you!");
                            heroChar.takeDamageChar(enemy.getDamage());
                            System.out.println();

                            if (heroChar.getHealth() > 0) { // Character still alive, gets its turn
                                heroCharTurnGauge -= turnThreshold;
                                System.out.println("Your Health: " + heroChar.getHealth() + "\n" + enemy.getName() + "'s Health: " + enemy.getHealth());
                                System.out.println("Choose an attack: Normal Punch, Consecutive Normal Punch(CNP), Serious Series, Serious Punch");
                                String atkChoice = myObj.nextLine();
                                heroChar.attack(atkChoice, enemy, heroChar);
                                System.out.println();
                            }
                        }
                    } else if (heroCharTurnGauge >= turnThreshold) { // Character acts first
                        heroCharTurnGauge -= turnThreshold;
                        System.out.println("Your Health: " + heroChar.getHealth() + "\n" + enemy.getName() + "'s Health: " + enemy.getHealth());
                        System.out.println("Choose an attack: Normal Punch, Consecutive Normal Punch(CNP), Serious Series, Serious Punch");
                        String atkChoice = myObj.nextLine();
                        heroChar.attack(atkChoice, enemy, heroChar);
                        System.out.println();
                    } else if (enemyTurnGauge >= turnThreshold) { // Enemy acts first
                        enemyTurnGauge -= turnThreshold;
                        System.out.println(enemy.getName() + " attacks you!");
                        heroChar.takeDamageChar(enemy.getDamage());
                        System.out.println();
                    }
                }
                if (enemy.getHealth() <= 0) { // Enemy defeat checker.
                    System.out.println("You have defeated the " + enemy.getName() + "!");
                    System.out.println("You gained " + enemy.exp + " exp for defeating the " + enemy.getName() + "!");
                    heroChar.gainExp(enemy.exp);
                }

                if (heroChar.getHealth() <= 0) { // Character defeat checker.
                    System.out.println("You have been defeated! Gave Over!");
                    break;
                }
            }

            // Game restart condition.
            boolean validInput = true;
            while (validInput) {
                System.out.println("Would you like to restart the game? Yes or No?");
                String choice = myObj.nextLine();

                if (choice.equalsIgnoreCase("No")) {
                    System.out.println("The program is now terminated!");
                    validInput = false;
                    loopBreaker = false;
                } else if (choice.equalsIgnoreCase("Yes")) {
                    validInput = false;
                    loopBreaker = true;

                    for (int i = 0; i < enemies.length; i++) {
                        Enemy enemy = enemies[i];
                        enemy.resetEnemy(); // Reset enemies health after finishing the game.
                    }

                    heroChar.resetCharacter(); // Reset character's health and stats after finishing the game.
                } else {
                    System.out.println("You entered an invalid input!");
                }
            }
        }
    }
}
