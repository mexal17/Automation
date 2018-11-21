package l6task1;

public enum PackType {
    CAN("can"), BAG("bag");

    private String type;

    PackType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
