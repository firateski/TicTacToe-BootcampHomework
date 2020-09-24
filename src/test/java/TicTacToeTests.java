import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTests {

    @Test
    public void setCellValue_shouldSetCorrectPlace(){
        // Arrange
        TicTacToe sut = new TicTacToe();
        sut.setCellValue(CellValue.X, 1, 1);

        // Act
        CellValue output = sut.getCellValue(1, 1);

        // Verify
        assertEquals(CellValue.X, output);
    }

    @Test
    public void getCellValue_shouldGetCorrectValue(){
        // Arrange
        TicTacToe sut = new TicTacToe();
        sut.setCellValue(CellValue.O, 0, 2);

        // Act
        CellValue output = sut.getCellValue(0, 2);

        // Verify
        assertEquals(CellValue.O, output);
    }

    @Test
    public void isTableFilled_shouldReturnTrue_whenTableIsFilled(){
        // Arrange
        TicTacToe sut = new TicTacToe();

        // Fill table using nested loops
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                CellValue currentCellValue = j % 2 == 0 ? CellValue.X : CellValue.O;
                sut.setCellValue(currentCellValue, i, j);
            }
        }

        // Act
        boolean output = sut.isTableFilled();

        // Verify
        assertTrue(output);
    }

    @Test
    public void isTableFilled_shouldReturnFalse_whenTableIsEmpty(){
        // Arrange
        TicTacToe sut = new TicTacToe();

        // Act
        boolean output = sut.isTableFilled();

        // Verify
        assertFalse(output);
    }

    @Test
    public void isTableFilled_shouldReturnFalse_whenTableIsPartiallyFilled(){
        // Arrange
        TicTacToe sut = new TicTacToe();
        sut.setCellValue(CellValue.X, 0, 0);
        sut.setCellValue(CellValue.O, 0, 1);
        sut.setCellValue(CellValue.X, 1, 0);
        sut.setCellValue(CellValue.O, 2, 0);

        // Act
        boolean output = sut.isTableFilled();

        // Verify
        assertFalse(output);
    }
}
