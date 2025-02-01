import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String input_path = "input_file.txt";

        //todo sanitize for out of bound numbers and letters
        List<String> piece_info = getTextFileInput(input_path);

        //todo sanitize inputs for out of range chars and numbers
        int[] inputs =  get_user_inputs();

        List<ChessPiece> pieces = pieceInfoToChessPiece(piece_info);

        for (ChessPiece piece : pieces) {
            switch (piece.type) {
                case "pawn" -> pawn_movement(piece, inputs);
                case "knight" -> knight_movement(piece, inputs);
                case "bishop" -> bishop_movement(piece, inputs);
                case "rook" -> rook_movement(piece, inputs);
                case "queen" -> queen_movement(piece, inputs);
                case "king" -> king_movement(piece, inputs);
                default -> {
                    //nothing to do if the type of piece is not a known chess piece
                }
            }

        }

    }

    public static ArrayList getTextFileInput(String fileName) {
        List<String> piece_info = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                piece_info.add(scanner.nextLine().trim().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList(piece_info);
    }

    public static int[] get_user_inputs(){
        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter the Letter for the space you would like the piece to move: ");
        String x_movement_str = user_input.nextLine().toLowerCase();
        System.out.println("Enter the number for the space you would like the piece to move: ");
        String y_movement_str = user_input.nextLine().toLowerCase();

        return new int[]{letter_to_number(x_movement_str), Integer.parseInt(y_movement_str)};
    }

    public static int letter_to_number(String letter) {
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

    public static List<ChessPiece> pieceInfoToChessPiece(List<String> piece_info){
        List<ChessPiece> pieces = new ArrayList<ChessPiece>();
        for(String info : piece_info){
           String[]  split_info = info.split(", ");
           pieces.add(new  ChessPiece(split_info[0], split_info[1],split_info[2],split_info[3]));
        }
        return pieces;
    }

    public static void pawn_movement(ChessPiece piece, int[] inputs){
        if(piece.x_cord != inputs[0] ||  (inputs[1] - piece.y_cord) > 1 || (inputs[1] - piece.y_cord) < 1) {
            System.out.println("The Pawn can NOT move from (" + piece.x_cord_str + "," + piece.y_cord_str + ") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")" );
        }
        else {
            System.out.println("The Pawn can move from (" + piece.x_cord_str + "," + piece.y_cord_str + ") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")" );
        }
    }
    public static void rook_movement(ChessPiece piece, int[] inputs){
        if (Math.abs((piece.x_cord - inputs[0])) > 0 && Math.abs((piece.y_cord - inputs[1] )) > 0){
            // if the new cords are not in both the x and y plane it is a invalid move
            System.out.println("The Rook can NOT move from (" + piece.x_cord_str +"," + piece.y_cord_str +") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")"  );
        }else {
            //nothing caught it to say it can not do it so it can
            System.out.println("The Rook can move from (" + piece.x_cord_str +"," + piece.y_cord_str +") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")"  );
        }
    }
    public static void bishop_movement(ChessPiece piece, int[] inputs){
        if (Math.abs(piece.x_cord-inputs[0]) != Math.abs(piece.y_cord-inputs[1])){
            // if the new cord are both changed the same amount on the x and y it is a invalid move
            System.out.println("The Bishop can NOT move from (" + piece.x_cord_str +"," + piece.y_cord_str +") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")"  );
        }else {
            //nothing caught it to say it can not do it so it can
            System.out.println("The Bishop can move from (" + piece.x_cord_str +"," + piece.y_cord_str +") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")"  );
        }
    }
    public static void knight_movement(ChessPiece piece, int[] inputs){
        //todo add knight logic
    }
    public static void queen_movement(ChessPiece piece, int[] inputs){
        if (Math.abs((piece.x_cord - inputs[0])) > 0 && Math.abs((piece.y_cord - inputs[1] )) > 0){
            //same logic as the rook
            System.out.println("The Queen can NOT move from (" + piece.x_cord_str +"," + piece.y_cord_str +") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")"  );
        }
        else if (Math.abs(piece.x_cord-inputs[0]) != Math.abs(piece.y_cord-inputs[1])) {
            //same logic as the bishop
            System.out.println("The Queen can NOT move from (" + piece.x_cord_str + "," + piece.y_cord_str + ") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")");
        }
        else {
            //nothing caught it to say it can not do it so it can
            System.out.println("The Queen can move from (" + piece.x_cord_str +"," + piece.y_cord_str +") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")"  );
        }
    }
    public static void king_movement(ChessPiece piece, int[] inputs){
        //todo add king logic
    }

}