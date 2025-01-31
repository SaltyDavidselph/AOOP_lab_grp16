public class ChessPiece {
    public String type;
    public String color;
    public String x_cord_str;
    public String y_cord_str;
    public int x_cord;
    public int y_cord;

    ChessPiece(String type, String color, String x_cord_str, String y_cord_str) {
        this.type = type;
        this.color = color;
        this.x_cord_str = x_cord_str;
        this.y_cord_str = y_cord_str;
        this.x_cord = switch (x_cord_str){
            case "a" -> 1;
            case "b" -> 2;
            case "c" -> 3;
            case "d" -> 4;
            case "e" -> 5;
            case "f" -> 6;
            case "g" -> 7;
            case "h" -> 8;
            default -> throw new IllegalStateException("Value not on the x-asis of the chess board: "  );
        };
        this.y_cord = Integer.parseInt(y_cord_str);
    }

}
