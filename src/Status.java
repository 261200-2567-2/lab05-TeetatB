public interface Status {
    int GetActiveTurn();
    String GetName();
    void ReduceActiveTurn();
    void ActiveStatus();
    Status GetStatus();

    public class Bleeding implements Status {
        private String name = "Bleeding";
        private int ActiveTurn = 0;

        public Bleeding() {
            this.ActiveTurn = 10;
        }

        @Override
        public int GetActiveTurn() {
            return ActiveTurn;
        }
        public String GetName() {
            return name;
        }
        public void ReduceActiveTurn() {
            ActiveTurn--;
        }
        public void ActiveStatus() {
            System.out.println("Your Current HP will be decreased by 1% for " + ActiveTurn + " turn");
        }
        public Status GetStatus() {
            return this;
        }
    }

    public class Confused implements Status {
        private String name = "Confused";
        private int ActiveTurn = 0;

        public Confused() {
            this.ActiveTurn = 3;
        }

        @Override
        public int GetActiveTurn() {
            return ActiveTurn;
        }
        public String GetName() {
            return name;
        }
        public void ReduceActiveTurn() {
            ActiveTurn--;
        }
        public void ActiveStatus() {
            System.out.println("Your Magic Attack will be decreased by 10 % for " + ActiveTurn + " turn");
        }
        public Status GetStatus() {
            return this;
        }
    }

    public class Feared implements Status {
        private String name = "Feared";
        private int ActiveTurn = 0;

        public Feared() {
            this.ActiveTurn = 5;
        }

        @Override
        public int GetActiveTurn() {
            return ActiveTurn;
        }
        public String GetName() {
            return name;
        }
        public void ReduceActiveTurn() {
            ActiveTurn--;
        }
        public void ActiveStatus() {
            System.out.println("Your Spd will be decreased by 15 % for "+ ActiveTurn + " turn");
        }
        public Status GetStatus() {
            return this;
        }
    }

    public class Weakened implements Status {
        private String name = "Weakened";
        private int ActiveTurn = 0;

        public Weakened() {
            this.ActiveTurn = 5;
        }

        @Override
        public int GetActiveTurn() {
            return ActiveTurn;
        }
        public String GetName() {
            return name;
        }
        public void ReduceActiveTurn() {
            ActiveTurn--;
        }
        public void ActiveStatus() {
            System.out.println("Your attack will be decreased by 10 % for "+ ActiveTurn + " turn");
        }
        public Status GetStatus() {
            return this;
        }
    }

    public class Regenerating implements Status {
        private String name = "Regenerating";
        private int ActiveTurn = 0;

        public Regenerating() {
            this.ActiveTurn = 2;
        }

        @Override
        public int GetActiveTurn() {
            return ActiveTurn;
        }
        public String GetName() {
            return name;
        }
        public void ReduceActiveTurn() {
            ActiveTurn--;
        }
        public void ActiveStatus() {
            System.out.println("Your current HP will regenerate by 1% for " + ActiveTurn + " turn");
        }
        public Status GetStatus() {
            return this;
        }
    }

    public class Magical implements Status {
        private String name = "Magical";
        private int ActiveTurn = 0;

        public Magical() {
            this.ActiveTurn = 5;
        }

        @Override
        public int GetActiveTurn() {
            return ActiveTurn;
        }
        public String GetName() {
            return name;
        }
        public void ReduceActiveTurn() {
            ActiveTurn--;
        }
        public void ActiveStatus() {
            System.out.println("Your magic attack will be increased by 5% for " + ActiveTurn + " turn");
        }
        public Status GetStatus() {
            return this;
        }
    }

    public class Blessed implements Status {
        private String name = "Blessed";
        private int ActiveTurn = 0;

        public Blessed() {
            this.ActiveTurn = 3;
        }

        @Override
        public int GetActiveTurn() {
            return ActiveTurn;
        }
        public String GetName() {
            return name;
        }
        public void ReduceActiveTurn() {
            ActiveTurn--;
        }
        public void ActiveStatus() {
            System.out.println("Your defense will be increased" + ActiveTurn + " turn");
        }
        public Status GetStatus() {
            return this;
        }
    }

    public class Swiftness implements Status {
        private String name = "Swiftness";
        private int ActiveTurn = 0;

        public Swiftness() {
            this.ActiveTurn = 10000;
        }

        @Override
        public int GetActiveTurn() {
            return ActiveTurn;
        }
        public String GetName() {
            return name;
        }
        public void ReduceActiveTurn() {
            System.out.println("Swiftness is permanent !!!");
        }
        public void ActiveStatus() {
            System.out.println("Your speed is increased by 5%");
        }
        public Status GetStatus() {
            return this;
        }
    }

    public class Super_Strength implements Status {
        private String name = "Super Strength";
        private int ActiveTurn = 0;

        public Super_Strength() {
            this.ActiveTurn = 10000;
        }

        @Override
        public int GetActiveTurn() {
            return ActiveTurn;
        }
        public String GetName() {
            return name;
        }
        public void ReduceActiveTurn() {
            System.out.println("Super Strength is permanent !!!");
        }
        public void ActiveStatus() {
            System.out.println("Your Carry Capacity is now doubled" );
        }
        public Status GetStatus() {
            return this;
        }
    }

    public class Scholar implements Status {
        private String name = "Scholar";
        private int ActiveTurn = 0;

        public Scholar() {
            this.ActiveTurn = 10000;
        }

        @Override
        public int GetActiveTurn() {
            return ActiveTurn;
        }
        public String GetName() {
            return name;
        }
        public void ReduceActiveTurn() {
            System.out.println("Scholar is permanent !!!");
        }
        public void ActiveStatus() {
            System.out.println("Your EXP gain is now increase by 30% !!!" );
        }
        public Status GetStatus() {
            return this;
        }
    }

}
