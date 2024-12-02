public class Stat {
    private int level = 1;
    private int Max_exp = 300;
    private int exp = 0;
    private boolean LevelIsUP = false;
    private int stat_points = 0;
    private int Str = 0;
    private int Dex = 0;
    private int Int = 0;
    private int Con = 0;
    private int Wis = 0;
    private int Cha = 0;
    private double Max_HP = 60 + Con*0.5;
    private double Curr_HP = Max_HP;
    private double Max_MP = 30 + Wis*0.5;
    private double Curr_MP = Max_MP;
    private double Atk = 15 + Str*0.3;
    private double MAtk = 10 + Int*0.5;
    private double Def  = 0;
    private double Spd = 10 + Dex*0.2;
    private int Carry_capacity = 0;
    private int Curr_carry = 0;

    public Stat(int Str, int Dex, int Int, int Con, int Wis, int Cha) {
        this.Str = Str;
        this.Dex = Dex;
        this.Int = Int;
        this.Con = Con;
        this.Wis = Wis;
        this.Cha = Cha;
        this.Carry_capacity = Str*2;
    }

    public void GetExp(int exp){
        this.exp += exp;
    }

    public void LevelUp(){
        if (exp >= Max_exp){
            level++;
            exp = 0;
            Max_exp *= 3;
            LevelIsUP = true;
            stat_points += 3;
            System.out.println("Congratulation your level is up !!!");
        }
    }

    public boolean LevelIsUP(){
        return LevelIsUP;
    }

    public void UpgradeAttribute (int selected_att, int upgrade_point){
        while (stat_points != 0 && upgrade_point <= stat_points){
            if (selected_att == 1){
                Str += upgrade_point;
                stat_points -= upgrade_point;
            } else if (selected_att == 2){
                Dex += upgrade_point;
                stat_points -= upgrade_point;
            } else if (selected_att == 3){
                Int += upgrade_point;
                stat_points -= upgrade_point;
            } else if (selected_att == 4){
                Con += upgrade_point;
                stat_points -= upgrade_point;
            } else if (selected_att == 5){
                Wis += upgrade_point;
                stat_points -= upgrade_point;
            } else if (selected_att == 6){
                Cha += upgrade_point;
                stat_points -= upgrade_point;
            }
            CheckStatPoints();
        }
    }

    public void CheckStatPoints(){
        System.out.println("Now you have " + stat_points + "stat points");
    }

    public double GetAtk(){
        return Atk;
    }

    public double GetMAtk(){
        return MAtk;
    }

    public double GetDef(){
        return Def;
    }

    public double GetSpd(){
        return Spd;
    }

    public double GetCurrHP(){
        return Curr_HP;
    }

    public double GetCurrMP(){
        return Curr_MP;
    }

    public void IncreaseAtk(double atk){
        Atk += atk;
    }

    public void IncreaseMAtk(double Matk){
        MAtk += Matk;
    }

    public void IncreaseDef(double def){
        Def += def;
    }

    public void IncreaseSpd(double spd){
        Spd += spd;
    }

    public void IncreaseCurrHP(double HP){
        Curr_HP += HP;
    }

    public void DecreaseAtk(double atk){
        Atk -= atk;
    }

    public void DecreaseMAtk(double Matk){
        MAtk -= Matk;
    }

    public void DecreaseDef(double def){
        Def -= def;
    }

    public void DecreaseSpd(double spd){
        Spd -= spd;
    }

    public void DecreaseCurrHP(double HP){
        Curr_HP -= HP;
    }

    public void ChangeCarry(int weight){
        Curr_carry += weight;
        if(Curr_carry > Carry_capacity){
            DecreaseSpd((Curr_carry-Carry_capacity)*0.3);
        }
    }

    public void PrintStat(){
        System.out.println("Level: " + level);
        System.out.println("Exp: " + exp + " / " + Max_exp);
        System.out.println("Current HP: " + Curr_HP + " / " + Max_HP);
        System.out.println("Current MP: " + Curr_MP + " / " + Max_MP);
        System.out.println("Atk: " + Atk);
        System.out.println("MAtk: " + MAtk);
        System.out.println("Def: " + Def);
        System.out.println("Spd: " + Spd);
        System.out.println("Current Carry: " + Curr_carry + " / " + Carry_capacity);
    }

    public void PrintAttribute(){
        System.out.println("Strength: " + Str);
        System.out.println("Dexterity: " + Dex);
        System.out.println("Intelligence: " + Int);
        System.out.println("Constitution: " + Con);
        System.out.println("Wisdom: " + Wis);
        System.out.println("Charisma: " + Cha);
    }
}
