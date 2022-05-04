public class Programmer {
    private String name;
    private String company;
    private String position;

    public String getPosition() {
        return this.position;
    }

    public void Work() {
        switch(getPosition()) {
            case "intern":
                this.position = "junior";
                break;
            case "junior":
                this.position = "middle";
                break;
            case "middle":
                this.position = "senior";
                break;
            case "senior":
                this.position = "lead";
                break;
        }
    }

    public Programmer(String name, String company) {
        this.name = name;
        this.company = company;
        this.position = "intern";
    }
}
