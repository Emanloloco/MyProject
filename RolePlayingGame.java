package roleplayinggame;
import Classes.Enemy;


public class RolePlayingGame {
    public static void main(String[] args) {
       Enemy goblin = new Enemy("Goblin", 200, 50, 30);
       Enemy ogre = new Enemy("Ogre", 250, 40, 25);
       Enemy centaur = new Enemy("Centaur", 225, 45, 45);
       Enemy orc = new Enemy("Warlock", 240, 50, 40);
       Enemy dragon = new Enemy("Alduin", 500, 70, 50);
       
    }
}
