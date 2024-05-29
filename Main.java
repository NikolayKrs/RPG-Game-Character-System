public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Aragorn", 100, 30, 1, 15, 10);
        Mage mage = new Mage("Gandalf", 60, 100, 1, 20, 25);
        Rogue rogue = new Rogue("Legolas", 80, 50, 1, 18, 15);

        warrior.attack(mage);
        mage.castSpell(warrior);
        rogue.attack(warrior);

        warrior.powerStrike(rogue);
        mage.fireball(warrior);
        rogue.backstab(mage);

        warrior.levelUp();
        rogue.levelUp();
    }
}
class Character {
    protected String name;
    protected int health;
    protected int mana;
    protected int level;

    public Character(String name, int health, int mana, int level) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.level = level;
    }

    public void attack(Character c) {
        int damage = 10; 
        c.takeDamage(damage);
        System.out.println(this.name + " attacks " + c.name + " for " + damage + " damage. " + c.name + "'s health is now: " + c.health);
    }

    public void defend() {
        System.out.println(this.name + " defends");
    }

    public void castSpell(Character c) {
        int spellDamage = 15; 
        c.takeDamage(spellDamage);
        System.out.println(this.name + " casts a spell on " + c.name + " for " + spellDamage + " damage. " + c.name + "'s health is now: " + c.health);
    }

    public void levelUp() {
        this.level += 1;
        this.health += 10;
        this.mana += 5;
        System.out.println(this.name + " leveled up to " + this.level);
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }
}

class Warrior extends Character {
    private int strength;
    private int armor;

    public Warrior(String name, int health, int mana, int level, int strength, int armor) {
        super(name, health, mana, level);
        this.strength = strength;
        this.armor = armor;
    }

    public void powerStrike(Character c) {
        int damage = 20; 
        c.takeDamage(damage);
        System.out.println(this.name + " uses Power Strike on " + c.name + " for " + damage + " damage. " + c.name + "'s health is now : " + c.health);
    }
}

class Mage extends Character {
    private int intelligence;
    private int spellPower;

    public Mage(String name, int health, int mana, int level, int intelligence, int spellPower) {
        super(name, health, mana, level);
        this.intelligence = intelligence;
        this.spellPower = spellPower;
    }

    public void fireball(Character c) {
        int spellDamage = 25; 
        c.takeDamage(spellDamage);
        System.out.println(this.name + " casts Fireball on " + c.name + " for " + spellDamage + " damage. " + c.name + "'s health is now: " + c.health);
    }
}

class Rogue extends Character {
    private int agility;
    private int dexterity;

    public Rogue(String name, int health, int mana, int level, int agility, int dexterity) {
        super(name, health, mana, level);
        this.agility = agility;
        this.dexterity = dexterity;
    }

    public void backstab(Character c) {
        int damage = 15; 
        c.takeDamage(damage);
        System.out.println(this.name + " uses Backstab on " + c.name + " for " + damage + " damage. " + c.name + "'s health is now: " + c.health);
    }
}
