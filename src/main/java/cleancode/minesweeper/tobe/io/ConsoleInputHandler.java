package cleancode.minesweeper.tobe.io;

import cleancode.minesweeper.tobe.BoadIndexConverter;
import cleancode.minesweeper.tobe.position.CellPosition;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    private final BoadIndexConverter boadIndexConverter = new BoadIndexConverter();

    @Override
    public String getUserInput() {
        return SCANNER.nextLine();
    }

    @Override
    public CellPosition getCellPositionFromUser() {
        String userInput = SCANNER.nextLine();

        int rowIndex = boadIndexConverter.getSelectedRowIndex(userInput);
        int colIndex = boadIndexConverter.getSelectedColIndex(userInput);
        return CellPosition.of(rowIndex, colIndex);
    }
}
