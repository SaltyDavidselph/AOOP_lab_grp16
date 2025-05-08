package Classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class moveToTesting {
    @Test
    void bishopMoveToTrue() {
        Bishop bishop = new Bishop(PieceName.BISHOP,Colors.WHITE,Column.A, Row.ONE);
        assertTrue(bishop.moveTo(4,4));
    }
    @Test
    void bishopMoveToFalse() {
        Bishop bishop = new Bishop(PieceName.BISHOP,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(bishop.moveTo(4,1));
    }
    @Test
    void bishopMoveToIllegal() {
        Bishop bishop = new Bishop(PieceName.BISHOP,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(bishop.moveTo(1,1));
    }

    @Test
    void rookMoveToTrue() {
        Rook rook = new Rook(PieceName.ROOK,Colors.WHITE,Column.A, Row.ONE);
        assertTrue(rook.moveTo(4,1));
    }
    @Test
    void rookMoveToFalse() {
        Rook rook = new Rook(PieceName.ROOK,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(rook.moveTo(4,4));
    }
    @Test
    void rookMoveToIllegal() {
        Rook rook = new Rook(PieceName.ROOK,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(rook.moveTo(1,1));
    }

    @Test
    void pawnMoveToTrue() {
        Pawn pawn = new Pawn(PieceName.PAWN,Colors.WHITE,Column.A, Row.ONE);
        assertTrue(pawn.moveTo(1,2));
    }
    @Test
    void pawnMoveToFalse() {
        Pawn pawn = new Pawn(PieceName.PAWN,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(pawn.moveTo(4,1));
    }
    @Test
    void pawnMoveToIllegal() {
        Pawn pawn = new Pawn(PieceName.PAWN,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(pawn.moveTo(1,1));
    }

    @Test
    void kingMoveToTrue() {
        King king = new King(PieceName.KING,Colors.WHITE,Column.A, Row.ONE);
        assertTrue(king.moveTo(2,2));
    }
    @Test
    void kingMoveToFalse() {
        King king = new King(PieceName.KING,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(king.moveTo(3,3));
    }
    @Test
    void kingMoveToIllegal() {
        King king = new King(PieceName.KING,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(king.moveTo(1,1));
    }

    @Test
    void queenMoveToTrue() {
        Queen queen = new Queen(PieceName.QUEEN,Colors.WHITE,Column.A, Row.ONE);
        assertTrue(queen.moveTo(4,4));
    }
    @Test
    void queenMoveToFalse() {
        Queen queen = new Queen(PieceName.QUEEN,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(queen.moveTo(4,5));
    }
    @Test
    void queenMoveToIllegal() {
        Queen queen = new Queen(PieceName.QUEEN,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(queen.moveTo(1,1));
    }

    @Test
    void knightMoveToTrue() {
        Knight knight = new Knight(PieceName.KNIGHT,Colors.WHITE,Column.A, Row.ONE);
        assertTrue(knight.moveTo(3,2));
    }
    @Test
    void knightMoveToFalse() {
        Knight knight = new Knight(PieceName.KNIGHT,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(knight.moveTo(4,1));
    }
    @Test
    void knightMoveToIllegal() {
        Knight knight = new Knight(PieceName.KNIGHT,Colors.WHITE,Column.A, Row.ONE);
        assertFalse(knight.moveTo(1,1));
    }
}
