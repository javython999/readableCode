package cleancode.minesweeper.tobe.minesweeper.board.cell;

public class LandMineCell implements Cell {

    private final CellState cellState = CellState.initialize();

    @Override
    public boolean isLandMine() {
        return true;
    }

    @Override
    public boolean hasLandMineCount() {
        return false;
    }

    @Override
    public CellSnapshot getSnapshot() {
        if (cellState.isOpend()) {
            return CellSnapshot.ofLandMine();
        }

        if (cellState.isFlagged()) {
            return CellSnapshot.ofFlag();
        }

        return CellSnapshot.ofUnchecked();
    }

    @Override
    public void flag() {
        cellState.flag();
    }

    @Override
    public void open() {
        cellState.open();
    }

    @Override
    public boolean isChecked() {
        return cellState.isFlagged();
    }

    @Override
    public boolean isOpend() {
        return cellState.isOpend();
    }

    @Override
    public boolean isFlagged() {
        return cellState.isFlagged();
    }
}
