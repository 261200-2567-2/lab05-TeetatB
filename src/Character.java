public class Character {
    private String name;
    private Stat stat;
    private Weapon[] weapons = new Weapon[2];
    private Accessory[] accessories = new Accessory[2];
    private Status status;
    private Status InflictStatus;

    public Character(String name, Stat stats) {
        this.name = name;
        this.stat = stats;
    }

    public void Equip(int slot, Weapon weapon){
        if(weapons[slot] == null){
            weapons[slot] = weapon;
            stat.IncreaseAtk(weapons[slot].GetAtk());
            stat.IncreaseMAtk(weapons[slot].GetMAtk());
            stat.IncreaseDef(weapons[slot].GetDef());
            stat.ChangeCarry(weapons[slot].GetWeight());
        }else{
            System.out.println("This weapon slot is occupied !!!");
        }
    }

    public void UnEquip(int slot){
        if(weapons[slot] != null){
            stat.DecreaseAtk(weapons[slot].GetAtk());
            stat.DecreaseMAtk(weapons[slot].GetMAtk());
            stat.DecreaseDef(weapons[slot].GetDef());
            stat.ChangeCarry(weapons[slot].GetWeight());
            weapons[slot] = null;
        }else{
            System.out.println("There is no weapon in this slot !!!");
        }
    }

    public String CheckWeaponSlot(int slot){
        if(weapons[slot] != null){
            return weapons[slot].GetName();
        } else {
            System.out.println("There is no weapon in this slot !!!");
            return null;
        }
    }

    public void AddStatus(Status status){
        if (status == null){
            this.status = status;
        }
    }

    public void RemoveStatus(Status status){
        if (status.GetActiveTurn() == 0){
            this.status = null;
        }
    }

    public void AddInflictStatus(Status status){
        if (status == null){
            this.InflictStatus = status;
        }
    }

    public void RemoveInflictStatus(Status status){
        this.InflictStatus = null;
    }

    public void  CheckStatus(){
        if (status != null) {
            if (status.GetName().equals("Bleeding")){
                double BleedDmg = stat.GetCurrHP()*0.01;
                stat.DecreaseCurrHP(BleedDmg);
            }
            if (status.GetName().equals("Confused")){
                double OldMAtk = stat.GetMAtk();
                if (status.GetActiveTurn() != 0) {
                    stat.DecreaseMAtk(OldMAtk*0.1);
                } else if (OldMAtk != stat.GetMAtk()) {
                    stat.IncreaseMAtk(OldMAtk*0.1);
                    RemoveStatus(status);
                }
            }
            if (status.GetName().equals("Weakened")){
                double OldAtk = stat.GetAtk();
                if (status.GetActiveTurn() != 0) {
                    stat.DecreaseAtk(OldAtk*0.1);
                } else if (OldAtk != stat.GetAtk()) {
                    stat.IncreaseAtk(OldAtk*0.1);
                    RemoveStatus(status);
                }
            }
            if (status.GetName().equals("Feared")){
                double OldSpd = stat.GetSpd();
                if (status.GetActiveTurn() != 0) {
                    stat.DecreaseSpd(OldSpd*0.15);
                } else if (OldSpd != stat.GetSpd()) {
                    stat.IncreaseSpd(OldSpd*0.15);
                    RemoveStatus(status);
                }
            }
        }
    }

    public double Attack(double DmgDeal, double EnemyDef){
        if (weapons[0].GetAtkType().equals("Atk") || weapons[1].GetAtkType().equals("Atk")){
            DmgDeal = stat.GetAtk() - EnemyDef*0.05;
        } else if (weapons[0].GetAtkType().equals("MAtk") || weapons[1].GetAtkType().equals("MAtk")) {
            DmgDeal = stat.GetMAtk() - EnemyDef*0.03;
        }
        return DmgDeal;
    }

    public void Combat(Monster monster){
        while (stat.GetCurrHP() != 0 && monster.getCurrHP() != 0){
            if (stat.GetSpd() > monster.getSpd()){
                monster.DecreaseHP(Attack(stat.GetAtk(), monster.getDef()));
                if (monster.getCurrHP() > 0){
                    System.out.println(monster.getName() + " HP is " +monster.getCurrHP() + " now !" );
                } else {
                    System.out.println(monster.getName() + " is dead "  );
                    System.out.println(" You win !!! " );
                    System.out.println("Battle End !!!");
                    stat.GetExp(monster.getExp());
                    stat.LevelUp();
                    if (weapons[0] != null){
                        weapons[0].IncreaseExp(monster.getExp());
                        weapons[0].LevelUp();
                    }
                    if (weapons[1] != null) {
                        weapons[1].IncreaseExp(monster.getExp());
                        weapons[1].LevelUp();
                    }
                    break;
                }
                stat.DecreaseCurrHP(monster.MonsterAttack(monster.getAtk(), stat.GetDef()));
                if(stat.GetCurrHP() <= 0){
                    System.out.println("You lose");
                    break;
                } else {
                    System.out.println("Your HP is "+ stat.GetCurrHP()+" now !!");
                }
            } else {
                stat.DecreaseCurrHP(monster.MonsterAttack(monster.getAtk(), stat.GetDef()));
                if(stat.GetCurrHP() <= 0){
                    System.out.println("You lose");
                    break;
                } else {
                    System.out.println("Your HP is "+ stat.GetCurrHP()+" now !!");
                }
                monster.DecreaseHP(Attack(stat.GetAtk(), monster.getDef()));
                if (monster.getCurrHP() > 0){
                    System.out.println(monster.getName() + " HP is " +monster.getCurrHP() + " now !" );
                } else {
                    System.out.println(monster.getName() + " is dead "  );
                    System.out.println("You win !!! " );
                    System.out.println(" Battle End !!!");
                    stat.GetExp(monster.getExp());
                    stat.LevelUp();
                    if (weapons[0] != null){
                        weapons[0].IncreaseExp(monster.getExp());
                        weapons[0].LevelUp();
                    }
                    if (weapons[1] != null) {
                        weapons[1].IncreaseExp(monster.getExp());
                        weapons[1].LevelUp();
                    }
                    break;
                }
                stat.DecreaseCurrHP(monster.MonsterAttack(monster.getAtk(), stat.GetDef()));
                System.out.println("Your HP is "+ stat.GetCurrHP()+" now !!");
                if(stat.GetCurrHP() <= 0){
                    System.out.println("You lose");
                    break;
                }
            }
        }
    }

    public void PrintCharacterInfo(){
        System.out.println("Name: " + name);
        stat.PrintStat();
        stat.PrintAttribute();
        if (status != null) {
            System.out.println("Status: " + status);
        } else {
            System.out.println("Status: Nothing");
        }
    }
}
