public class Mage {
    protected String name;
    protected int level;
    protected int damage;
    protected String type;

    public Mage(String name, int level, int damage, String type) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.type = type;
    }

    public String getInfo() {
        return String.format("{%s, %d, %d, %s}", this.name, this.level, this.damage, this.type);
    }

    private String evenCase(Mage mage) {
        if (mage.level > this.level)
            return mage.name;
        else if (mage.level < this.level)
            return this.name;
        else if (mage.damage > this.damage)
            return mage.name;
        else if (mage.damage < this.damage)
            return this.name;
        return "draw";
    }

    public String fight(Mage mage) {
        switch(this.type) {
            case "fire":
                switch(mage.type) {
                    case "ice":
                        return this.name;
                    case "earth":
                        return mage.name;
                    default:
                        return this.evenCase(mage);
                }
            case "ice":
                switch(mage.type) {
                    case "earth":
                        return this.name;
                    case "fire":
                        return mage.name;
                    default:
                        return this.evenCase(mage);
                }
            case "earth":
                switch(mage.type) {
                    case "fire":
                        return this.name;
                    case "ice":
                        return mage.name;
                    default:
                        return this.evenCase(mage);
                }
        }
        return "error";
    }
}
