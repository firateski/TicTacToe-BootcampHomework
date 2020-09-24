public class TicTacToe {
    private final CellValue[][] table =
            {
                { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY },
                { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY },
                { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY }
            };
    public CellValue getCellValue(int x, int y){
        return table[x][y];
    }

    public void setCellValue(CellValue state, int x, int y){
        table[x][y] = state;
    }
}
