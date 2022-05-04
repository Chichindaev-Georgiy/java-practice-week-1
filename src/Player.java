public class Player {
    private String surname;
    private String name;
    private String address;
    private String cardName;

    Player(String aSurname, String aName, String aAddress, String aCardName) {
        this.surname = aSurname;
        this.name = aName;
        this.address = aAddress;
        this.cardName = aCardName;
    }

    public String toString() {
        return String.format("Player: %s %s, address: %s, card: %s", this.surname, this.name, this.address, this.cardName);
    }
}
