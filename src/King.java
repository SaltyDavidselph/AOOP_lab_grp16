// Refactored into objects by David Selph
public class King extends ChessPiece {
    //an object that is a pawn in chess
    //includes an empty constructor, a constuctor that takes values, setters and getters for the data that needs them,
    // and a method that verifies if it can be moved to a given location


    // calls constructor from super
    public int x_cord;
    public int y_cord;

    public King( Color color, Column col, Row row) {
        super(PieceType.KING, color, col,row );
        this.x_cord = Main.letterToNumber(col);
        this.y_cord = row.getValue();
    }

    @Override
    public boolean verify_movement(int x, int y){
        if(Math.abs(this.x_cord - x) > 1 || Math.abs(this.y_cord - y) > 1){
            return false;
        }
        else{
            return true;

        }
    }
}
