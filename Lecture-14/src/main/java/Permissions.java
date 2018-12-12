public class Permissions {
    private boolean admin;
    private boolean push;
    private boolean pull;

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setPush(boolean push) {
        this.push = push;
    }

    public void setPull(boolean pull) {
        this.pull = pull;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "admin=" + admin +
                ", push=" + push +
                ", pull=" + pull +
                '}';
    }
}