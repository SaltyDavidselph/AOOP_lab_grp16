// Refactored into objects by David Selph
public class Queen extends ChessPiece{
    //an object that is a Queen in chess
    //includes an empty constructor, a constuctor that takes values, setters and getters for the data that needs them,
    // and a method that verifies if it can be moved to a given location

    // calls constructor from super
    public int x_cord;
    public int y_cord;

    public Queen( Color color, Column col, Row row) {
        super(PieceType.BISHOP, color, col,row );
        this.x_cord = Main.letterToNumber(col);
        this.y_cord = row.getValue();
    }

    @Override
    public boolean verify_movement(int x, int y){
        if ((Math.abs((this.x_cord - x)) > 0 && Math.abs((this.y_cord - y )) > 0) && ((Math.abs(this.x_cord-x) != Math.abs(this.y_cord-y)))){
            //same logic as the rook
            return false;
        }
        else {
            //nothing caught it to say it can not do it so it can
            return true;
        }
    }
}
