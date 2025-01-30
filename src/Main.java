import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String path = "input_file.txt";

        List<String> piece_info = getTextFileInput(path);

       int[] inputs =  get_user_inputs();

        System.out.println("(" + inputs[0] + "," + inputs[1] + ")");

        for (String piece : piece_info) {
            System.out.println(piece);
        }

    }

    public static ArrayList getTextFileInput(String fileName) {
        List<String> piece_info = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                //add lines into an array
                //System.out.println(scanner.nextLine().trim());
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

}