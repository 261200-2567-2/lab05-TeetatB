import java.io.Serializable;

public interface Weapon {
    Status GetInflictStatus();
    double GetAtk();
    double GetMAtk();
    double GetDef();
    int GetWeight();
    String GetAtkType();
    String GetName();
    void LevelUp();
    void IncreaseExp(int exp);
    void PrintDetail();

    public class Sword implements Weapon {
        private Status status = new Status.Bleeding();
        private String name = "Sword";
        private String AtkType;
        private double Atk = 0;
        private double MAtk = 0;
        private double Def = 0;
        private int Weight = 0;
        private int level = 1;
        private int exp = 0;
        private int Max_exp = 300;

        public Sword() {
            this.AtkType = "Atk";
            this.Atk = 7;
            this.Weight = 4;
        }

        @Override
        public Status GetInflictStatus(){
            return status;
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

        public int GetWeight(){
            return Weight;
        }

        public String GetAtkType(){
            return AtkType;
        }

        public String GetName(){
            return name;
        }

        public void LevelUp(){
            if (exp >= Max_exp) {
                level++;
                exp = 0;
                Max_exp *= 3;
                Atk += 2;
            }
        }
        public void IncreaseExp(int Exp){
            exp += Exp;
        }
        public void PrintDetail(){
            System.out.println(name);
            System.out.println("Level: " + level);
            System.out.println("Atk: " + Atk);
            System.out.println("MAtk: " + MAtk);
            System.out.println("Def: " + Def);
            System.out.println("Experience: " + exp + "/" + Max_exp);
        }
    }

    public class Shield implements Weapon {
        private String name = "Shield";
        private String AtkType;
        private double Atk = 0;
        private double MAtk = 0;
        private double Def = 0;
        private int Weight = 0;
        private int level = 1;
        private int exp = 0;
        private int Max_exp = 300;

        public Shield() {
            this.AtkType = "Def";
            this.Def = 5;
            this.Weight = 8;
        }

        @Override
        public Status GetInflictStatus(){
            return null;
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
        public int GetWeight(){
            return Weight;
        }
        public String GetAtkType(){
            return AtkType;
        }
        public String GetName(){
            return name;
        }
        public void IncreaseExp(int Exp){
            exp += Exp;
        }
        public void LevelUp(){
            if (exp >= Max_exp) {
                level++;
                exp = 0;
                Max_exp *= 3;
                Def++;
            }
        }
        public void PrintDetail(){
            System.out.println(name);
            System.out.println("Level: " + level);
            System.out.println("Atk: " + Atk);
            System.out.println("MAtk: " + MAtk);
            System.out.println("Def: " + Def);
            System.out.println("Experience: " + exp + "/" + Max_exp);
        }
    }

    public class Staff implements Weapon {
        private String name = "Staff";
        private String AtkType = "MAtk";
        private Status status = new Status.Confused();
        private double Atk = 0;
        private double MAtk = 0;
        private double Def = 0;
        private int Weight = 0;
        private int level = 1;
        private int exp = 0;
        private int Max_exp = 300;

        public Staff() {
            this.AtkType = "MAtk";
            this.Atk = 2;
            this.MAtk = 4;
            this.Weight = 5;
        }

        @Override
        public Status GetInflictStatus(){
            return status;
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
        public int GetWeight(){
            return Weight;
        }
        public String GetAtkType(){
            return AtkType;
        }
        public String GetName(){
            return name;
        }
        public void LevelUp(){
            if (exp >= Max_exp) {
                level++;
                exp = 0;
                Max_exp *= 3;
                Atk++;
                MAtk++;
            }
        }
        public void IncreaseExp(int Exp){
            exp += Exp;
        }
        public void PrintDetail(){
            System.out.println(name);
            System.out.println("Level: " + level);
            System.out.println("Atk: " + Atk);
            System.out.println("MAtk: " + MAtk);
            System.out.println("Def: " + Def);
            System.out.println("Experience: " + exp + "/" + Max_exp);
        }
    }

    public class Bow implements Weapon {
        private String name = "Bow";
        private String AtkType = "Atk";
        private Status status = new Status.Weakened();
        private double Atk = 0;
        private double MAtk = 0;
        private double Def = 0;
        private int Weight = 0;
        private int level = 1;
        private int exp = 0;
        private int Max_exp = 300;

        public Bow() {
            this.AtkType = "Atk";
            this.Atk = 10;
            this.Weight = 6;
        }

        @Override
        public Status GetInflictStatus(){
            return status;
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
        public int GetWeight(){
            return Weight;
        }
        public String GetAtkType(){
            return AtkType;
        }
        public String GetName(){
            return name;
        }
        public void LevelUp(){
            if (exp >= Max_exp) {
                level++;
                exp = 0;
                Max_exp *= 3;
                Atk++;
            }
        }
        public void IncreaseExp(int Exp){
            exp += Exp;
        }
        public void PrintDetail(){
            System.out.println(name);
            System.out.println("Level: " + level);
            System.out.println("Atk: " + Atk);
            System.out.println("MAtk: " + MAtk);
            System.out.println("Def: " + Def);
            System.out.println("Experience: " + exp + "/" + Max_exp);
        }
    }

    public class Wand implements Weapon {
        private String name = "Wand";
        private String AtkType = "MAtk";
        private Status status = new Status.Feared();
        private double Atk = 0;
        private double MAtk = 0;
        private double Def = 0;
        private int Weight = 0;
        private int level = 1;
        private int exp = 0;
        private int Max_exp = 300;

        public Wand() {
            this.AtkType = "MAtk";
            this.MAtk = 7;
            this.Weight = 3;
        }

        @Override
        public Status GetInflictStatus(){
            return status;
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
        public int GetWeight(){
            return Weight;
        }
        public String GetAtkType(){
            return AtkType;
        }
        public String GetName(){
            return name;
        }
        public void LevelUp(){
            if (exp >= Max_exp) {
                level++;
                exp = 0;
                Max_exp *= 3;
                MAtk += 2;
            }
        }
        public void IncreaseExp(int Exp){
            exp += Exp;
        }
        public void PrintDetail(){
            System.out.println(name);
            System.out.println("Level: " + level);
            System.out.println("Atk: " + Atk);
            System.out.println("MAtk: " + MAtk);
            System.out.println("Def: " + Def);
            System.out.println("Experience: " + exp + "/" + Max_exp);
        }
    }

}
