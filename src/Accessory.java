public interface Accessory {
    Status GetStatus();
    int GetWeight();

    public class Amulet implements Accessory {
        private String name = "Amulet";
        private Status status = new Status.Regenerating();
        int weight;
        @Override
        public Status GetStatus() {
            return status;
        }
        public int GetWeight() {
            return weight;
        }
    }

    public class Bracelet implements Accessory {
        private String name = "Bracelet";
        private Status status = new Status.Blessed();
        int weight;
        @Override
        public Status GetStatus() {
            return status;
        }
        public int GetWeight() {
            return weight;
        }
    }

    public class Boots implements Accessory {
        private String name = "Boots";
        private Status status = new Status.Swiftness();
        int weight;
        @Override
        public Status GetStatus() {
            return status;
        }
        public int GetWeight() {
            return weight;
        }
    }

    public class Ring implements Accessory {
        String name = "Ring";
        private Status status = new Status.Magical();
        private int weight;
        @Override
        public Status GetStatus() {
            return status;
        }
        public int GetWeight() {
            return weight;
        }
    }
}
