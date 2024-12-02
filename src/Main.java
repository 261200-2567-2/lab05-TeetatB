import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Adventure World");
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your name : ");
        String name = input.nextLine();

        Weapon Sword = new Weapon.Sword();
        Weapon Shield = new Weapon.Shield();
        Weapon Bow = new Weapon.Bow();
        Weapon Staff = new Weapon.Staff();
        Weapon Wand = new Weapon.Wand();

        System.out.println("Now please organize your 27 points to 6 attributes: ");
        System.out.println("Strength: Increase your Attack and Carry capacity");
        System.out.println("Dexterity: Increase your Speed");
        System.out.println("Constitution: Increase your Health point");
        System.out.println("Intelligence: Increase your Magic Attack");
        System.out.println("Wisdom: Increase your Mana point");
        System.out.println("Charisma: Increase nothing for now");


        int Str = 0;
        int Dex = 0;
        int Int = 0;
        int Con = 0;
        int Wis = 0;
        int Cha = 0;
        int starter_point = 27;

        while(starter_point > 0){
            System.out.println("Please distribute your Str: ");
            Str = input.nextInt();
            while (Str > starter_point || Str < 0){
                System.out.println("Wrong number!");
                Str = input.nextInt();
            }
            starter_point -= Str;
            System.out.println("Your remaining point is "+starter_point);
            System.out.println("Please distribute your Dex: ");
            Dex = input.nextInt();
            while (Dex > starter_point || Dex < 0){
                System.out.println("Wrong number!");
                Dex = input.nextInt();
            }
            starter_point -= Dex;
            System.out.println("Your remaining point is "+starter_point);
            System.out.println("Please distribute your Con: ");
            Con = input.nextInt();
            while (Con > starter_point || Con < 0){
                System.out.println("Wrong number!");
                Con = input.nextInt();
            }
            starter_point -= Con;
            System.out.println("Your remaining point is "+starter_point);
            System.out.println("Please distribute your Int: ");
            Int = input.nextInt();
            while (Int > starter_point || Int < 0){
                System.out.println("Wrong number!");
                Int = input.nextInt();
            }
            starter_point -= Int;
            System.out.println("Your remaining point is "+starter_point);
            System.out.println("Please distribute your Wis: ");
            Wis = input.nextInt();
            while (Wis > starter_point || Wis < 0){
                System.out.println("Wrong number!");
                Wis = input.nextInt();
            }
            starter_point -= Wis;
            System.out.println("Your remaining point is "+starter_point);
            System.out.println("Please distribute your Cha: ");
            Cha = input.nextInt();
            while(Cha > starter_point || Cha < 0){
                System.out.println("Wrong number!");
                Cha = input.nextInt();
            }
            starter_point -= Cha;
            System.out.println("Your remaining point is "+starter_point);
        }

        Stat stat = new Stat(Str,Dex,Con,Int,Wis,Cha);
        Character player = new Character(name, stat);

        System.out.println("Please select your primary weapon by number: ");
        System.out.println("1. Sword");
        System.out.println("2. Bow");
        System.out.println("3. Magic Staff");
        System.out.println("4. Wand");
        input.nextLine();
        String priweapon = input.nextLine();
        while (priweapon == null || !priweapon.equals("1") && !priweapon.equals("2") && !priweapon.equals("3") && !priweapon.equals("4")){
            System.out.println("Wrong number!");
            System.out.println("Please select your primary weapon by number: ");
            priweapon = input.nextLine();
        }
        if (priweapon.equals("1")){
            System.out.println("Sword is selected");
            player.Equip(0,Sword);
        } else if (priweapon.equals("2")) {
            System.out.println("Bow is selected");
            player.Equip(0,Bow);
        }else if (priweapon.equals("3")) {
            System.out.println("Magic Staff is selected");
            player.Equip(0,Staff);
        } else if (priweapon.equals("4")) {
            System.out.println("Wand is selected");
            player.Equip(0,Wand);
        }
        if (player.CheckWeaponSlot(0).equals("Sword") || player.CheckWeaponSlot(0).equals("Wand")){
            System.out.println("Please select your secondary weapon by number: ");
            System.out.println("1. Shield");
            String secweapon = input.nextLine();
            while(!secweapon.equals("1")){
                System.out.println("Wrong number!");
                System.out.println("Please select your secondary weapon by number: ");
                secweapon = input.nextLine();
            }
            player.Equip(1,Shield);
        }

        player.PrintCharacterInfo();

        System.out.println("Now time to fight");
        Status Bld = new Status.Bleeding();
        Monster Goblin = new Monster("Goblin","Atk",5,1,1,15,2, Bld);
        Monster HobGoblin = new Monster("HobGoblin","Atk",5,7,3,30,10, Bld);
        System.out.println("You encounter 2 monsters !!!");
        System.out.println("1. Goblin");
        System.out.println("2. HobGoblin");
        System.out.println("Which one do you want to fight?");
        String fightNum = input.nextLine();
        while(fightNum == null || !fightNum.equals("1") && !fightNum.equals("2")){
            System.out.println("Wrong number!");
            System.out.println("Please select your fight: ");
            fightNum = input.nextLine();
        }
        if (fightNum.equals("1")){
            player.Combat(Goblin);
        } else if (fightNum.equals("2")){
            player.Combat(HobGoblin);
        }
    }
}