// Refactored into objects by David Selph
public class Bishop extends ChessPiece {
    //an object that is a Bishop in chess
    //includes an empty constructor, a constuctor that takes values, setters and getters for the data that needs them,
    // and a method that verifies if it can be moved to a given location


    public int x_cord;
    public int y_cord;

    public Bishop( Color color, Column col, Row row) {
        super(PieceType.BISHOP, color, col,row );
        this.x_cord = Main.letterToNumber(col);
        this.y_cord = row.getValue();
    }

    @Override
    public boolean verify_movement(int x, int y){
        if (Math.abs(this.x_cord - x) != Math.abs(this.y_cord - y)){
            // if the new cord are both changed the same amount on the x and y it is an invalid move
           return false;
        }else {
            //nothing caught it to say it can not do it so it can
            return true;
        }
    }
}
