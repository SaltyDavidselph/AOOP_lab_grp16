// Refactored into objects by David Selph
public class Bishop {
    //an object that is a Bishop in chess
    //includes an empty constructor, a constuctor that takes values, setters and getters for the data that needs them,
    // and a method that verifies if it can be moved to a given location

    public Main.chess_type name;
    public String color;
    public String x_cord_str;
    public String y_cord_str;
    public int x_cord;
    public int y_cord;


    public Bishop(){
    }
    public Bishop( String color, String x_cord_str, String y_cord_str) {
        this.name = Main.chess_type.BISHOP;
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
        if (Math.abs(this.x_cord-inputs[0]) != Math.abs(this.y_cord-inputs[1])){
            // if the new cord are both changed the same amount on the x and y it is an invalid move
           return false;
        }else {
            //nothing caught it to say it can not do it so it can
            return true;
        }
    }
}
