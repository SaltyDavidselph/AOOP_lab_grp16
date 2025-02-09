
public class King {
    public Main.chess_type name;
    public String color;
    public String x_cord_str;
    public String y_cord_str;
    public int x_cord;
    public int y_cord;

    public King(){
    }
    public King( String color, String x_cord_str, String y_cord_str) {
        this.name = Main.chess_type.king;
        this.color = color;
        this.x_cord_str = x_cord_str;
        this.y_cord_str = y_cord_str;
        this.x_cord = Main.letterToNumber(x_cord_str);
        this.y_cord = Integer.parseInt(y_cord_str);
    }
    public Main.chess_type getName(){
        return this.name;
    }
    public String getColor() {
        return this.color;
    }
    public String getX_cord_str() {
        return this.x_cord_str;
    }
    public String getY_cord_str() {
        return this.y_cord_str;
    }
    public int getx_cord(){
        return this.x_cord;
    }
    public int gety_cord(){
        return this.y_cord;
    }

    public void setX_cord_str( String x_cord_str){
        this.x_cord_str = x_cord_str;
        this.x_cord = Main.letterToNumber(x_cord_str);
    }
    public void setY_cord_str( String y_cord_str){
        this.y_cord_str = y_cord_str;
        this.y_cord = Integer.parseInt(y_cord_str);
    }

    public Boolean verify_movement(int[] inputs){
        if(Math.abs(this.x_cord - inputs[0]) > 1 || Math.abs(this.y_cord - inputs[1]) > 1){
            return false;
        }
        else{
            return true;

        }
    }
}
