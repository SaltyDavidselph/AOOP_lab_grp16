import java.io.IOException;
import java.util.Scanner;

//import lab2.AOOP_lab_grp16.src.Pawn;

/*LAB2 Project. AUTHORS - David Selph, Angel Torres & Rafael Carmona
 * Description of program.
 *  - Validate user's input about the movement of a chess piece (in this case, official chess rules are not applicable) through the use
 * of methods, objects and javas functionality.
 */

public class Main {
    public static void main(String[] args) throws IOException{      //added IOexeption
        
        

    boolean terminate = false;
    while(terminate != true){
        //promp user inputs for piece and color
        chess_type user_input_piece = getPiece(chess_type.NULL);
        String user_input_color = get_color();
        boolean term_inner = false;
        while(term_inner) {
            //promp user for start spots
            String user_input_x_start = get_user_input_x();
            String user_input_y_start = get_user_input_y();

           

            boolean term_inner_inner = false;
                while(term_inner_inner) {
                    //promp user for end spot
                    String user_input_x_end_str = get_user_input_x();
                    String user_input_y_end_str = get_user_input_y();
                    
                    int user_input_y_end_int = Integer.parseInt(user_input_y_end_str);
                    int user_input_x_end_int = letterToNumber(user_input_y_end_str);
                    int[] int_inputs = {Integer.parseInt(user_input_y_end_str),letterToNumber(user_input_y_end_str)};

                    //create the object based on the give information 
                    switch (user_input_piece) {
                        case PAWN: {
                            Pawn pawn = new Pawn(user_input_color,user_input_x_start,user_input_y_start);
                            if (pawn.verify_movement(int_inputs)){
                                move_succsess(chess_type.PAWN , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            else{
                                move_failure(chess_type.PAWN , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                        }
                        case ROOK:{
                            Rook rook = new Rook(user_input_color,user_input_x_start,user_input_y_start);
                            if (rook.verify_movement(int_inputs)){
                                move_succsess(chess_type.ROOK , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }else{
                                move_failure(chess_type.ROOK , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                        }
                        case KNIGHT:
                            {Knight knight = new Knight(user_input_color,user_input_x_start,user_input_y_start);
                            if (knight.verify_movement(int_inputs)){
                                move_succsess(chess_type.KNIGHT , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }else{
                                move_failure(chess_type.KNIGHT , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                        }
                        case BISHOP:
                            {Bishop bishop = new Bishop(user_input_color,user_input_x_start,user_input_y_start);
                            if (bishop.verify_movement(int_inputs)){
                                move_succsess(chess_type.BISHOP , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }else{
                                move_failure(chess_type.BISHOP , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                        }
                        case QUEEN:{Queen queen = new Queen(user_input_color,user_input_x_start,user_input_y_start);
                            if (queen.verify_movement(int_inputs)){
                                move_succsess(chess_type.QUEEN , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            else{
                                move_failure(chess_type.QUEEN , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }}
                        case KING:{King charlies = new King(user_input_color,user_input_x_start,user_input_y_start);
                            if (charlies.verify_movement(int_inputs)){
                                move_succsess(chess_type.KING , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }
                            else{
                                move_failure(chess_type.KING , user_input_color,user_input_x_start,user_input_y_start,user_input_x_end_str,user_input_y_end_str);
                            }}  
                        case NULL:{}
                    }
                    //promp user to see if they want to use the same piece and adifferent target OR new piece 
                    //if new target rerun all of it 
                    String con = get_user_string("Would you like to test another");
                }
        }
        break;
    }
    }

    enum chess_type{
        PAWN,ROOK,KNIGHT,BISHOP,QUEEN,KING,NULL,
    }

    public static String get_user_input_x(){
        Exception input_err = new Exception("user input not within string length or board size");
        
        boolean invalid_input = true;
        Scanner user_input = new Scanner(System.in);
        String x_movement_str = "";
        while (invalid_input) {
            System.out.println("Enter the Letter for a column on the board: ");
            try {
                x_movement_str = user_input.nextLine().toLowerCase();
                if(x_movement_str.length() >1){         //checking for length is kind of redundant since i only use the first char later anyway
                    throw input_err;
                }else{
                    char []user_input_arr = x_movement_str.toCharArray();
                    if((user_input_arr[0]>'h')||(user_input_arr[0]<'a')){
                        throw input_err;
                    }
                }
                invalid_input = false;      //escape this mortal coil
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("please enter the valid letter for a space within the board");
            }
        }
        return x_movement_str;
    }

    public static String get_user_input_y(){
        Exception input_err = new Exception("user input not within string length or board size");
        
        boolean invalid_input = true;
        Scanner user_input = new Scanner(System.in);
        String y_movement_str = "";
        while (invalid_input) {
            System.out.println("Enter the number for a row on the board: ");
            try {
                y_movement_str = user_input.nextLine().toLowerCase();
                if(y_movement_str.length() >1){         //checking for length is kind of redundant since i only use the first char later anyway
                    throw input_err;
                }else{
                    char []user_input_arr = y_movement_str.toCharArray();
                    if((user_input_arr[0]>'1')||(user_input_arr[0]<'8')){
                        throw input_err;
                    }
                }
                invalid_input = false;      //escape this mortal coil
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("please enter the valid letter for a space within the board");
            }
        }
        return y_movement_str;
    }

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

    //Takes the "letter to number" conversion from previous method as a parameter and converts it back to its corresponding number
    //Convert back 
    public static char numberToLetter(int number) {
        return switch (number){
            case 1 -> 'a';
            case 2 -> 'b';
            case 3 -> 'c';
            case 4 -> 'd';
            case 5 -> 'e';
            case 6 -> 'f';
            case 7 -> 'g';
            case 8 -> 'h';
            default -> throw new IllegalStateException("Value not on the x-asis of the chess board: " + number);
        };
    }


/**
 * get the next string input from user
 * @return
 */
    public static String get_user_string(String query){
        System.out.println(query);
        boolean invalid_string = true;
        System.out.println("bol" + invalid_string);
        Scanner user_input = new Scanner(System.in);
        String user_string = "";
        System.out.println(" "+user_string);
        while(invalid_string){
            try {
                System.out.println("pre scanner next line: ");
                user_string = user_input.nextLine();
                invalid_string = false;
            } catch (Exception e) {

            }
            user_input.close();
        }
        user_input.close();
        return user_string.toLowerCase();
    }
    /**
     * prompts user to enter peice type
     * @return enum of correct peice 
     */
    public static chess_type getPiece( chess_type type){
        try{
        String user_input = get_user_string("what piece would you like to test");
        if(user_input.contains("qu")){
            return chess_type.QUEEN;
        }else if(user_input.contains("ki")){
            return chess_type.KING;
        }else if(user_input.contains("kn")){
            return chess_type.KNIGHT;
        }else if(user_input.contains("ro")){
            return chess_type.ROOK;
        }else if(user_input.contains("bi")){
            return chess_type.BISHOP;
        }else if(user_input.contains("pa")){
            return chess_type.PAWN;
        }else
            {
                System.out.println("please enter valid peice");
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
     * 
     * @param piece current chess piece
     * @param inputs the desired move
     */
    public static void move_succsess(chess_type type, String color, String x_start, String y_start, String x_end, String y_end){
        System.out.println("The "+ color + " "+ type+" can move from (" + x_start +"," + y_start +") to (" + x_end + "," + y_end + ")"  );
    }
    /**
     * Print a messge that the desired move is NOT possible
     * 
     * @param piece current chess piece
     * @param inputs the desired move
     */
    public static void move_failure(chess_type type, String color, String x_start, String y_start, String x_end, String y_end){
        System.out.println("The " + color + " "+ type+" can NOT move from (" + x_start +"," + y_start +") to (" + x_end + "," + y_end + ")"    );
    }

}
