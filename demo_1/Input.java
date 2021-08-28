package demo_1;

import java.util.Scanner;

public class Input {
    public long inputScannerInt() {
        while (true) {
            try {
                Scanner keyboard = new Scanner(System.in);
                String input = keyboard.nextLine();
                long pressedType = Long.parseLong(input);
                return pressedType;
            } catch (NumberFormatException e) {
                System.out.println("nhap sai dinh dang so");
            }
        }
    }
    public String inputScannerString(){
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        return input;
    }
}
