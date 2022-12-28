package nam.tran;

import java.util.Scanner;

public class Utils {

    public static String inputLine(Scanner scanner){
        StringBuilder text = new StringBuilder();
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            if (input.isEmpty())
                continue;
            text.append(input);
            break;
        }
        return text.toString();
    }
}
