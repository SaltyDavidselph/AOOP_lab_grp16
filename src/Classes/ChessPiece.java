/*
* 4. Create an abstract class Figure that partially implements IntFigure (provides the fields and constructors to initialize its values,
* but does not implement method moveTo.
*/

package Classes;
import Interfaces.*;


public abstract class ChessPiece implements IntFigure{
     PieceName name;
     Color color;
     Column column;
     Row row;
     int xCord;
     int yCord;

    //Empty/Default constructor
    public ChessPiece(){
        this.name = null;
        this.color = null;
        this.column = null;
        this.row = null;
    }

    //Constructor with values
    public ChessPiece(PieceName name, Color color, Column corX, Row y){
        this.name = name;
        this.color = color;
        this.column = corX;
        this.row = y;
    }

    public static int letterToNumber(Column letter) {
        return switch (letter){
            case A-> 1;
            case B -> 2;
            case C -> 3;
            case D -> 4;
            case E -> 5;
            case F -> 6;
            case G -> 7;
            case H -> 8;
            default -> throw new IllegalStateException("Value not on the x-asis of the chess board: " + letter);
        };
    }

    //Setters
    public void setName(PieceName name){
        this.name = name;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void setColumn(Column corX){
        this.column  = corX;
    }

    public void setRow(Row row){
        this.row = row;
    }
//
//    //Getters
    public PieceName getName(){
        return name;
    }

    public Color getColor(){
        return color;
    }

    public Column getColumn(){
        return column;
    }

    public Row getRow(){
        return row;
    }
}