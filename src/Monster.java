public class Monster {
    private String name;
    private String AtkType;
    private double Atk = 0;
    private double MAtk = 0;
    private double Def = 0;
    private double Spd = 0;
    private double Max_HP = 0;
    private double Curr_HP = 0;
    private int exp;
    private Status[] Status = new Status[3];
    private Status InflictStatus;

    public Monster(String name,String AtkType, double Atk , double Def, double Spd, double Max_HP ,int exp, Status status) {
        this.name = name;
        this.AtkType = AtkType;
        if(AtkType.equals("Atk")){
            this.Atk = Atk;
        } else if (AtkType.equals("MAtk")) {
            this.MAtk = Atk;
        }
        this.Def = Def;
        this.Spd = Spd;
        this.Max_HP = Max_HP;
        this.Curr_HP = Max_HP;
        this.exp = exp;
        this.InflictStatus = status;
    }

    public String getName() {
        return name;
    }

    public double getAtk() {
        double dmg = 0;
        if(AtkType.equals("Atk")){
            dmg = Atk;
        }else if (AtkType.equals("MAtk")) {
            dmg = MAtk;
        }
        return dmg;
    }

    public double getDef() {
        return Def;
    }

    public double getSpd() {
        return Spd;
    }

    public double getCurrHP() {
        return Curr_HP;
    }

    public int getExp() {
        return exp;
    }

    public void AddStatus(Status s){
        if(Status[0] == null){
            Status[0] = s;
        } else if (Status[1] == null) {
            Status[1] = s;
        } else if (Status[2] == null) {
            Status[2] = s;
        }
    }

    public void RemoveStatus(Status s){
        if(Status[0] != null){
            Status[0] = null;
        } else if (Status[1] != null) {
            Status[1] = null;
        } else if (Status[2] == null) {
            Status[2] = null;
        }
    }

    public void CheckStatus(){
        for(int i = 0; i < Status.length; i++){
            if(Status[i] != null){
                if (Status[i].GetName().equals("Bleeding")){
                    if (Status[i].GetActiveTurn() != 0){
                        Curr_HP = Curr_HP*0.99;
                    } else {
                        RemoveStatus(Status[i]);
                    }
                }
                if (Status[i].GetName().equals("Confused")){
                    double OldMAtk = MAtk;
                    if (Status[i].GetActiveTurn() != 0){
                        MAtk = MAtk*0.9;
                    } else if (OldMAtk != MAtk) {
                        MAtk = OldMAtk;
                        RemoveStatus(Status[i]);
                    }
                }
                if (Status[i].GetName().equals("Feared")){
                    double OldSpd = Spd;
                    if (Status[i].GetActiveTurn() != 0){
                        Spd = Spd*0.85;
                    } else if (OldSpd != Spd) {
                        Spd = OldSpd;
                        RemoveStatus(Status[i]);
                    }
                }
                if (Status[i].GetName().equals("Weakened")){
                    double OldAtk = Atk;
                    if (Status[i].GetActiveTurn() != 0){
                        Atk = Atk*0.9;
                    } else {
                        Atk = OldAtk;
                        RemoveStatus(Status[i]);
                    }
                }
            }
        }
    }

    public double MonsterAttack(double AtkDmg, double EnemyDef){
        if(AtkType.equals("Atk")){
            AtkDmg = Atk - EnemyDef*0.06;
        } else if (AtkType.equals("MAtk")) {
            AtkDmg = MAtk - EnemyDef*0.04;
        }
        return AtkDmg;
    }

    public void DecreaseHP(double dmg){
        if(Curr_HP > 0){
            Curr_HP -= dmg;
            PrintMonster();
        }
    }

    public void PrintMonster(){
        System.out.println(name + " 's HP remain "+ Curr_HP);
    }


}
