import java.util.InputMismatchException;
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

public class Main {
    public static void main(String[] args){      //added IOexeption
        
        
        //Author: Rafeal C. and David Selph
        boolean term_inner = true;
        while(term_inner) {
            chess_type user_input_piece = getPiece(chess_type.NULL);
            String user_input_color = get_color();

            //promp user for start spots
            String user_input_x_start = get_user_input_x("starting");
            String user_input_y_start = get_user_input_y("starting");

           

            boolean term_inner_inner = true;
                while(term_inner_inner) {
                    //promp user for end spot
                    String user_input_x_end_str = get_user_input_x("target");
                    String user_input_y_end_str = get_user_input_y("target");

                    int[] int_inputs = {letterToNumber(user_input_x_end_str),Integer.parseInt(user_input_y_end_str)};

                    //create the object based on the give information 
                    switch (user_input_piece) {
                        case PAWN:
                            Pawn pawn = new Pawn(user_input_color,user_input_x_start,user_input_y_start);
                            if (pawn.verify_movement(int_inputs)){
                                move_succsess(chess_type.PAWN , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            else{
                                move_failure(chess_type.PAWN , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            break;
                        case ROOK:
                            Rook rook = new Rook(user_input_color,user_input_x_start,user_input_y_start);
                            if (rook.verify_movement(int_inputs)){
                                move_succsess(chess_type.ROOK , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }else{
                                move_failure(chess_type.ROOK , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            break;
                        case KNIGHT:
                            Knight knight = new Knight(user_input_color,user_input_x_start,user_input_y_start);
                            if (knight.verify_movement(int_inputs)){
                                move_succsess(chess_type.KNIGHT , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }else{
                                move_failure(chess_type.KNIGHT , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            break;
                        case BISHOP:
                            Bishop bishop = new Bishop(user_input_color,user_input_x_start,user_input_y_start);
                            if (bishop.verify_movement(int_inputs)){
                                move_succsess(chess_type.BISHOP , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }else{
                                move_failure(chess_type.BISHOP , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            break;
                        case QUEEN:Queen queen = new Queen(user_input_color,user_input_x_start,user_input_y_start);
                            if (queen.verify_movement(int_inputs)){
                                move_succsess(chess_type.QUEEN , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            else{
                                move_failure(chess_type.QUEEN , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            break;
                        case KING:King charlies = new King(user_input_color,user_input_x_start,user_input_y_start);
                            if (charlies.verify_movement(int_inputs)){
                                move_succsess(chess_type.KING , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            else{
                                move_failure(chess_type.KING , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            break;
                        case NULL:
                    }
                    //promp user to see if they want to use the same piece and adifferent target OR new piece 
                    //if new target rerun all of it 
                    String con = get_user_string("Would you like to test another set of target cords? Yes or No");
                    Boolean answer = true;
                    while(answer){
                        if (con.equals("no")){
                            term_inner_inner = false;
                            answer = false;
                        } else if (con.equals("yes")) {
                            answer = false;
                        } else {
                            con = get_user_string("Please Say: Yes or No");
                        }
                    }
                }
            String again = get_user_string("Do you want to pick a new chess piece and starting cord? Yes or No").toLowerCase();
                Boolean answer = true;
                while(answer){
                    if (again.equals("no")){
                      term_inner = false;
                        answer = false;
                    } else if (again.equals("yes")) {
                        answer = false;
                    } else {
                        again = get_user_string("Please only say Yes or No").toLowerCase();
                }
            }
        }
        System.out.println("Goodbye!");
    }

    //Author: David Selph
    enum chess_type{
        PAWN,ROOK,KNIGHT,BISHOP,QUEEN,KING,NULL,
    }

    //Author:Angel Torres
    public static String get_user_input_y(String cord_type){
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Please enter the y cord "+ cord_type +" position as a number 1-8: ");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("1") || input.equals("2") || input.equals("3")||input.equals("4")||input.equals("5")||
                    input.equals("6")||input.equals("7")||input.equals("8")) {
                return input;
            } else {
                System.out.println("Input not approved, try again.");
            }
        }
    }

    //Author: Angel Torres
    public static String get_user_input_x(String cord_type){

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Please enter the x cord " + cord_type + " position as a letter a-h:  ");
            input = scanner.nextLine().toLowerCase();

            if
            (input.equals("a") || input.equals("b") || input.equals("c")||input.equals("d")||input.equals("e")||
                    input.equals("f")||input.equals("g")||input.equals("h")) {
                return input;
            } else {
                System.out.println("Input not approved, try again.");
            }
        }
    }

    //Author:David Selph
    //Takes the input from the user that corresponds to the x coordinate as a parameter
    //Convert the letter corresponding to the x position into an integer value
    public static int letterToNumber(String letter) {
        return switch (letter){
            case "a" -> 1;
            case "b" -> 2;
            case "c" -> 3;
            case "d" -> 4;
            case "e" -> 5;
            case "f" -> 6;
            case "g" -> 7;
            case "h" -> 8;
            default -> throw new IllegalStateException("Value not on the x-asis of the chess board: " + letter);
        };
    }


/**
 * get the next string input from user
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
    public static chess_type getPiece( chess_type type){

        try{
        String user_input = get_user_string("what piece would you like to test?");

        if(user_input.equals("queen")){
            return chess_type.QUEEN;
        }else if(user_input.equals("king")){
            return chess_type.KING;
        }else if(user_input.equals("knight")){
            return chess_type.KNIGHT;
        }else if(user_input.equals("rook")){
            return chess_type.ROOK;
        }else if(user_input.equals("bishop")){
            return chess_type.BISHOP;
        }else if(user_input.contains("pawn")){
            return chess_type.PAWN;
        }else
            {
                System.out.println("please enter valid piece");
                getPiece(chess_type.NULL);
            }
            return chess_type.NULL;
        }
        catch(Exception e){
            throw new RuntimeException("Not valid input");
        }
    }
    public static String get_color(){    
        return get_user_string("What color would you like to be?");    
    }

    //helper methods to reduce bulk
    /**
     * Print a messge that the desired move is possible
     * Author: Angel Torres, David Selph
     */
    public static void move_succsess(chess_type type, String color, String x_start, String y_start, String x_end, String y_end){
        System.out.println("The "+ color + " "+ type+" can move from (" + x_start +"," + y_start +") to (" + x_end + "," + y_end + ")"  );
    }
    /**
     * Print a messge that the desired move is NOT possible
     * Author: Angel Torres, David Selph
     */
    public static void move_failure(chess_type type, String color, String x_start, String y_start, String x_end, String y_end){
        System.out.println("The " + color + " "+ type+" can NOT move from (" + x_start +"," + y_start +") to (" + x_end + "," + y_end + ")"    );
    }

}
