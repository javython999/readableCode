package cleancode.minesweeper.tobe.minesweeper.board.cell;

public class NumberCell implements Cell {

    private final int nearbyLandMineCount;
    private final CellState cellState = CellState.initialize();

    public NumberCell(int nearbyLandMineCount) {
        this.nearbyLandMineCount = nearbyLandMineCount;
    }

    @Override
    public boolean isLandMine() {
        return false;
    }

    @Override
    public boolean hasLandMineCount() {
        return true;
    }

    @Override
    public CellSnapshot getSnapshot() {
        if (cellState.isOpend()) {
            return CellSnapshot.ofNumber(nearbyLandMineCount);
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
        return cellState.isOpend();
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
