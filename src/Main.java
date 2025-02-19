import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//import lab2.AOOP_lab_grp16.src.Pawn;

/*LAB2 Project. AUTHORS - David Selph, Angel Torres & Rafael Carmona
 * Description of program.
 *  - Validate user's input about the movement of a chess piece (in this case, official chess rules are not applicable) through the use
 * of methods, objects and javas functionality.
 */

 enum PieceType{
    QUEEN,
    KING, 
    BISHOP,
    ROOK, 
    PAWN,
    KNIGHT;
}

enum Color{
    BLACK, 
    WHITE;
}

enum Column{
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H;
}

enum Row{
     ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8);
     private int value;
     Row(int value){
         this.value = value;
     }
    public int getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args){
        //start by running a loop over getuserpieces with the control being check_piece
        //each piece given stored in an array until we have one of each piece

        //once that is done we need to get the target pos

        //loop over the array from the inputs and polymorph a chess piece

        System.out.println("Goodbye!");
    }

    //Author:David Selph
    //Takes the input from the user that corresponds to the x coordinate as a parameter
    //Convert the letter corresponding to the x position into an integer value
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

    private boolean check_pieces(List<ChessPiece> user_pieces){
        //this kinda sucks a lot a bit

        boolean queen = false;
        boolean king = false;
        boolean bishop = false;
        boolean rook = false;
        boolean pawn = false;
        boolean knight = false;

        for (ChessPiece piece : user_pieces ){
            switch (piece.name){
                case QUEEN: {
                    queen = true;
                }
                case KING: {
                    king = true;
                }
                case BISHOP: {
                    bishop = true;
                }
                case ROOK: {
                    rook = true;
                }
                case PAWN: {
                    pawn = true;
                }
                case KNIGHT: {
                    knight = true;
                }
            }
        }

        if(queen && king && bishop && rook && pawn && knight){
            return true;}
        else {
            return false;
        }
    }

    private ChessPiece get_user_chess_piece(){
        PieceType pt = getPiece();
        Color color = get_color();
        Column col = get_user_input_starting_col(color,pt);
        Row row = get_user_input_starting_row(color,pt);
        while (true) {
            switch (pt) {
                case QUEEN: {
                    return new Queen(color, col, row);
                }
                case KING: {
                    return new King(color, col, row);
                }
                case BISHOP: {
                    return new Bishop(color, col, row);
                }
                case ROOK: {
                    return new Rook(color, col, row);
                }
                case PAWN: {
                    return new Pawn(color, col, row);
                }
                case KNIGHT: {
                    return new Knight(color, col, row);
                }
            }
        }
    }


/**
 * get the next string input from user
 * sanitize it with lowercase
 * @return
 */
//Author:Angel Torres
    public static String get_user_string(String query){
        System.out.println(query);
        boolean invalid_string = true;
        Scanner user_input = new Scanner(System.in);
        String user_string = "";
        while(invalid_string){
            try {
                user_string = user_input.nextLine();
                invalid_string = false;
            } catch (Exception e) {
            }
        }
        return user_string.toLowerCase();
    }
    /**
     * prompts user to enter peice type
     * @return enum of correct peice
     * Author: Angel Torres
     */
    public static PieceType getPiece( ){
        String user_input = get_user_string("what piece would you like to test?");
        while (true) {
            try {
                if (user_input.equals("queen")) {
                    return PieceType.QUEEN;
                } else if (user_input.equals("king")) {
                    return PieceType.KING;
                } else if (user_input.equals("knight")) {
                    return PieceType.KNIGHT;
                } else if (user_input.equals("rook")) {
                    return PieceType.ROOK;
                } else if (user_input.equals("bishop")) {
                    return PieceType.BISHOP;
                } else if (user_input.contains("pawn")) {
                    return PieceType.PAWN;
                } else {
                    user_input = get_user_string("Please Try again with a real chess piece not " + user_input);
                }
            } catch (Exception e) {
                throw new RuntimeException("Not valid input");
            }
        }
    }
    public static Color get_color(){
        String input =  get_user_string("Would you like to be the White or Black Pieces?");
        while(true){
            switch(input){
                case "white" -> {
                    //if the user gave a string of white return the white enum
                    return Color.WHITE;
                }
                case "black" -> {
                    //if the user gave a string of black return the black enum
                    return Color.BLACK;
                }
                default -> {
                    //keep going and get another input
                    input = get_user_string("Please Sir I want a Color... White or Black");
                }
            }
        }
    }
    //Author:Angel Torres
    public static Row get_user_input_starting_row( Color color, PieceType pieceType){
        String input =  get_user_string("What is the starting Row of this "+ color + pieceType +"?");
        return strToRow(input);
    }

    public static Row get_user_input_target_row( ){
        String input =  get_user_string("What is the target Row of these chess pieces?");
        return strToRow(input);
    }

    private static Row strToRow(String input){
        while(true){
            switch(input){
                case "1" -> {
                    //if the user gave a string of one return the one enum
                    return Row.ONE;
                }
                case "2" -> {
                    //if the user gave a string of two return the two enum
                    return Row.TWO;
                }
                case "3" -> {
                    //if the user gave a string of three return the three enum
                    return Row.THREE;
                }
                case "4" -> {
                    //if the user gave a string of four return the four enum
                    return Row.FOUR;
                }
                case "5" -> {
                    //if the user gave a string of five return the five enum
                    return Row.FIVE;
                }
                case "6" -> {
                    //if the user gave a string of six return the six enum
                    return Row.SIX;
                }
                case "7" -> {
                    //if the user gave a string of seven return the seven enum
                    return Row.SEVEN;
                }
                case "8" -> {
                    //if the user gave a string of eight return the eight enum
                    return Row.EIGHT;
                }
                default -> {
                    //keep going and get another input
                    input = get_user_string("Please stop this silliness and input a single number 1-8");
                }
            }
        }
    }

    //Author: Angel Torres
    public static Column get_user_input_starting_col( Color color, PieceType pieceType){
        String input =  get_user_string("What is the starting Column of this "+ color + pieceType +"?");
        return strToCol(input);
    }
    public static Column get_user_input_target_col(){
        String input =  get_user_string("What is the Target Column of this montly crew of chess pieces?");
        return strToCol(input);
    }

    private static Column strToCol(String input){
        while(true){
            switch(input){
                case "a" -> {
                    //if the user gave a string of one return the one enum
                    return Column.A;
                }
                case "b" -> {
                    //if the user gave a string of two return the two enum
                    return Column.B;
                }
                case "c" -> {
                    //if the user gave a string of three return the three enum
                    return Column.C;
                }
                case "d" -> {
                    //if the user gave a string of four return the four enum
                    return Column.D;
                }
                case "e" -> {
                    //if the user gave a string of five return the five enum
                    return Column.E;
                }
                case "f" -> {
                    //if the user gave a string of six return the six enum
                    return Column.F;
                }
                case "g" -> {
                    //if the user gave a string of seven return the seven enum
                    return Column.G;
                }
                case "h" -> {
                    //if the user gave a string of eight return the eight enum
                    return Column.H;
                }
                default -> {
                    //keep going and get another input
                    input = get_user_string("Please stop this silliness and input a letter a-h");
                }
            }
        }
    }

    //helper methods to reduce bulk
    /**
     * Print a messge that the desired move is possible
     * Author: Angel Torres, David Selph
     */
    public static void move_succsess(PieceType type, String color, String x_start, String y_start, String x_end, String y_end){
        System.out.println("The "+ color + " "+ type+" can move from (" + x_start +"," + y_start +") to (" + x_end + "," + y_end + ")"  );
    }
    /**
     * Print a messge that the desired move is NOT possible
     * Author: Angel Torres, David Selph
     */
    public static void move_failure(PieceType type, String color, String x_start, String y_start, String x_end, String y_end){
        System.out.println("The " + color + " "+ type+" can NOT move from (" + x_start +"," + y_start +") to (" + x_end + "," + y_end + ")"    );
    }

}
