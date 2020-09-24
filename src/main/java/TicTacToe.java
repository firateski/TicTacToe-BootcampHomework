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

    public boolean isTableFilled() {
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                if(getCellValue(i, j) == CellValue.EMPTY) return false;
            }
        }

        return true;
    }
}
