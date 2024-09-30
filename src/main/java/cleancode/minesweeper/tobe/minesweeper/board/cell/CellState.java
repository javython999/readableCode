package cleancode.minesweeper.tobe.minesweeper.board.cell;

public class CellState {

    private boolean isFlagged;
    private boolean isOpend;

    private CellState(boolean isFlagged, boolean isOpend) {
        this.isFlagged = isFlagged;
        this.isOpend = isOpend;
    }

    public static CellState initialize() {
        return new CellState(false, false);
    }

    public void flag() {
        this.isFlagged = true;
    }

    public void open() {
        this.isOpend = true;
    }

    public boolean isOpend() {
        return isOpend;
    }

    public boolean isFlagged() {
        return isFlagged;
    }
}
