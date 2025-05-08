/*
* 1. Create a public enum type for the names of the Chess Pieces and save it in a separate file
*/

package Classes;

public enum PieceName{
    KING('K'),
    PAWN('P'),
    QUEEN('Q'),
    BISHOP('B'),
    ROOK('R'),
    KNIGHT('N');
    private char value;
    PieceName(char value) {
        this.value = value;
    }
    public char getValue() {
        return value;
    }
}
