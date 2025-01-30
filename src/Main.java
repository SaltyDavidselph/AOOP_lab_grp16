import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<String> piece_info = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new File("input_file.txt"))) {
            while (scanner.hasNextLine()) {
                //add lines into an array
                //System.out.println(scanner.nextLine().trim());
                piece_info.add(scanner.nextLine().trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter the Letter for the space you would like the piece to move: ");
        String x_movement = user_input.nextLine();
        System.out.println("Enter the number for the space you would like the piece to move: ");
        String y_movement = user_input.nextLine();

        System.out.println("(" + x_movement + " " + y_movement + ")");
        

        for (String piece : piece_info) {
            System.out.println(piece);
        }

    }


}