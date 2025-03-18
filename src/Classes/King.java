/*
* 9. Create class king which extends Queen
 */

package lab2.AOOP_lab_grp16.src.Classes;

public class King extends Queen{
    public King(PieceName pieceName, Color color ,Column corX, Row row){
        super(PieceName.KING, color, corX, row);
    }
}
