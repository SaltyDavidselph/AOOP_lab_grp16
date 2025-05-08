package Classes;

public enum Colors {
    WHITE('W'),
    BLACK('B');
    private char value;
    Colors(char value) {
        this.value = value;
    }
    public char getValue() {
        return value;
    }
}
