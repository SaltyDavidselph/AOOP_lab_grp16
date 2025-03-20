/*
* 9. Create class king which extends Queen
 */

package Classes;

public class King extends Queen{
    public King(PieceName pieceName, Color color ,Column column, Row row){
        super(pieceName, color, column, row);
    }

    @Override
    public boolean moveTo(int inX, int inY){
        if(Math.abs(this.xCord - inX) > 1 || Math.abs(this.yCord - inY) > 1 || checkForSameness(inX, inY)){
            return false;
        }
        else{
            return true;
        }
    }
}