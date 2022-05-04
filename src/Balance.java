public class Balance {
    private int rightWeight;
    private int leftWeight;

    Balance() {
        rightWeight = 0;
        leftWeight = 0;
    }
    public void addRight(int weight) {
        rightWeight += weight;
    }

    public void addLeft(int weight) {
        leftWeight += weight;
    }

    public char getSituation() {
        if (rightWeight > leftWeight) {
            return 'R';
        } else if(rightWeight < leftWeight) {
            return 'L';
        }
        return '=';
    }
}
