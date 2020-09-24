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
}
