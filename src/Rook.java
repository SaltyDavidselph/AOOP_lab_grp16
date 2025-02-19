// Refactored into objects by David Selph
public class Rook extends ChessPiece {
    //an object that is a Rook in chess
    //includes an empty constructor, a constuctor that takes values, setters and getters for the data that needs them,
    // and a method that verifies if it can be moved to a given location

    // calls constructor from super
    public int x_cord;
    public int y_cord;

    public Rook( Color color, Column col, Row row) {
        super(PieceType.BISHOP, color, col,row );
        this.x_cord = Main.letterToNumber(col);
        this.y_cord = row.getValue();
    }

    @Override
    public boolean verify_movement(int x, int y){
        if (Math.abs((this.x_cord - x)) > 0 && Math.abs((this.y_cord - y )) > 0){
            // if the new cords are not in both the x and y plane it is an invalid move
            return false;
        }else {
            //nothing caught it to say it can not do it so it can
            return true;
        }
    }
}
