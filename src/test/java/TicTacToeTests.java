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

    @Test
    public void getWinner_shouldReturnGameNotCompleted_whenTableIsNotFilledAndNoOneWon(){
        // Arrange
        TicTacToe sut = new TicTacToe();
        sut.setCellValue(CellValue.O, 0, 0);
        sut.setCellValue(CellValue.X, 0, 1);
        sut.setCellValue(CellValue.O, 0, 2);
        sut.setCellValue(CellValue.X, 1, 1);
        sut.setCellValue(CellValue.X, 1, 2);

        // Act
        WinnerState expectedWinnerGameNotCompleted = sut.getWinner();

        // Verify
        assertEquals(WinnerState.GAME_NOT_COMPLETED, expectedWinnerGameNotCompleted);
    }

    @Test
    public void getWinner_shouldReturnTie_whenTableIsFilledAndNoOneWon(){
        // Arrange
        TicTacToe sut = new TicTacToe();
        sut.setCellValue(CellValue.O, 0, 0);
        sut.setCellValue(CellValue.X, 0, 1);
        sut.setCellValue(CellValue.O, 0, 2);
        sut.setCellValue(CellValue.O, 1, 0);
        sut.setCellValue(CellValue.X, 1, 1);
        sut.setCellValue(CellValue.X, 1, 2);
        sut.setCellValue(CellValue.X, 2, 0);
        sut.setCellValue(CellValue.O, 2, 1);
        sut.setCellValue(CellValue.X, 2, 2);

        // Act
        WinnerState expectedWinnerTie = sut.getWinner();

        // Verify
        assertEquals(WinnerState.TIE, expectedWinnerTie);
    }

    @Test
    public void getWinner_shouldReturnValidWinner_whenFirstRowFilledByWinner(){
        // Arrange
        TicTacToe sutForX = new TicTacToe();
        sutForX.setCellValue(CellValue.X, 0, 0);
        sutForX.setCellValue(CellValue.X, 0, 1);
        sutForX.setCellValue(CellValue.X, 0, 2);

        TicTacToe sutForO = new TicTacToe();
        sutForO.setCellValue(CellValue.O, 0, 0);
        sutForO.setCellValue(CellValue.O, 0, 1);
        sutForO.setCellValue(CellValue.O, 0, 2);


        // Act
        WinnerState expectedWinnerX = sutForX.getWinner();
        WinnerState expectedWinnerO = sutForO.getWinner();

        // Verify
        assertEquals(WinnerState.X, expectedWinnerX);
        assertEquals(WinnerState.O, expectedWinnerO);
    }

    @Test
    public void getWinner_shouldReturnValidWinner_whenSecondRowFilledByWinner(){
        // Arrange
        TicTacToe sutForX = new TicTacToe();
        sutForX.setCellValue(CellValue.X, 1, 0);
        sutForX.setCellValue(CellValue.X, 1, 1);
        sutForX.setCellValue(CellValue.X, 1, 2);

        TicTacToe sutForO = new TicTacToe();
        sutForO.setCellValue(CellValue.O, 1, 0);
        sutForO.setCellValue(CellValue.O, 1, 1);
        sutForO.setCellValue(CellValue.O, 1, 2);


        // Act
        WinnerState expectedWinnerX = sutForX.getWinner();
        WinnerState expectedWinnerO = sutForO.getWinner();

        // Verify
        assertEquals(WinnerState.X, expectedWinnerX);
        assertEquals(WinnerState.O, expectedWinnerO);
    }

    @Test
    public void getWinner_shouldReturnValidWinner_whenThirdRowFilledByWinner(){
        // Arrange
        TicTacToe sutForX = new TicTacToe();
        sutForX.setCellValue(CellValue.X, 2, 0);
        sutForX.setCellValue(CellValue.X, 2, 1);
        sutForX.setCellValue(CellValue.X, 2, 2);

        TicTacToe sutForO = new TicTacToe();
        sutForO.setCellValue(CellValue.O, 2, 0);
        sutForO.setCellValue(CellValue.O, 2, 1);
        sutForO.setCellValue(CellValue.O, 2, 2);


        // Act
        WinnerState expectedWinnerX = sutForX.getWinner();
        WinnerState expectedWinnerO = sutForO.getWinner();

        // Verify
        assertEquals(WinnerState.X, expectedWinnerX);
        assertEquals(WinnerState.O, expectedWinnerO);
    }

    @Test
    public void getWinner_shouldReturnValidWinner_whenFirstColumnFilledByWinner(){
        // Arrange
        TicTacToe sutForX = new TicTacToe();
        sutForX.setCellValue(CellValue.X, 0, 0);
        sutForX.setCellValue(CellValue.X, 1, 0);
        sutForX.setCellValue(CellValue.X, 2, 0);

        TicTacToe sutForO = new TicTacToe();
        sutForO.setCellValue(CellValue.O, 0, 0);
        sutForO.setCellValue(CellValue.O, 1, 0);
        sutForO.setCellValue(CellValue.O, 2, 0);


        // Act
        WinnerState expectedWinnerX = sutForX.getWinner();
        WinnerState expectedWinnerO = sutForO.getWinner();

        // Verify
        assertEquals(WinnerState.X, expectedWinnerX);
        assertEquals(WinnerState.O, expectedWinnerO);
    }

    @Test
    public void getWinner_shouldReturnValidWinner_whenSecondColumnFilledByWinner(){
        // Arrange
        TicTacToe sutForX = new TicTacToe();
        sutForX.setCellValue(CellValue.X, 0, 1);
        sutForX.setCellValue(CellValue.X, 1, 1);
        sutForX.setCellValue(CellValue.X, 2, 1);

        TicTacToe sutForO = new TicTacToe();
        sutForO.setCellValue(CellValue.O, 0, 1);
        sutForO.setCellValue(CellValue.O, 1, 1);
        sutForO.setCellValue(CellValue.O, 2, 1);


        // Act
        WinnerState expectedWinnerX = sutForX.getWinner();
        WinnerState expectedWinnerO = sutForO.getWinner();

        // Verify
        assertEquals(WinnerState.X, expectedWinnerX);
        assertEquals(WinnerState.O, expectedWinnerO);
    }

    @Test
    public void getWinner_shouldReturnValidWinner_whenThirdColumnFilledByWinner(){
        // Arrange
        TicTacToe sutForX = new TicTacToe();
        sutForX.setCellValue(CellValue.X, 0, 2);
        sutForX.setCellValue(CellValue.X, 1, 2);
        sutForX.setCellValue(CellValue.X, 2, 2);

        TicTacToe sutForO = new TicTacToe();
        sutForO.setCellValue(CellValue.O, 0, 2);
        sutForO.setCellValue(CellValue.O, 1, 2);
        sutForO.setCellValue(CellValue.O, 2, 2);


        // Act
        WinnerState expectedWinnerX = sutForX.getWinner();
        WinnerState expectedWinnerO = sutForO.getWinner();

        // Verify
        assertEquals(WinnerState.X, expectedWinnerX);
        assertEquals(WinnerState.O, expectedWinnerO);
    }

    @Test
    public void getWinner_shouldReturnValidWinner_whenTopLeftToBottomRightDiagonallyFilledByWinner(){
        // Arrange
        TicTacToe sutForX = new TicTacToe();
        sutForX.setCellValue(CellValue.X, 0, 0);
        sutForX.setCellValue(CellValue.X, 1, 1);
        sutForX.setCellValue(CellValue.X, 2, 2);

        TicTacToe sutForO = new TicTacToe();
        sutForO.setCellValue(CellValue.O, 0, 0);
        sutForO.setCellValue(CellValue.O, 1, 1);
        sutForO.setCellValue(CellValue.O, 2, 2);


        // Act
        WinnerState expectedWinnerX = sutForX.getWinner();
        WinnerState expectedWinnerO = sutForO.getWinner();

        // Verify
        assertEquals(WinnerState.X, expectedWinnerX);
        assertEquals(WinnerState.O, expectedWinnerO);
    }

    @Test
    public void getWinner_shouldReturnValidWinner_whenBottomLeftToTopRightDiagonallyFilledByWinner(){
        // Arrange
        TicTacToe sutForX = new TicTacToe();
        sutForX.setCellValue(CellValue.X, 2, 2);
        sutForX.setCellValue(CellValue.X, 1, 1);
        sutForX.setCellValue(CellValue.X, 0, 2);

        TicTacToe sutForO = new TicTacToe();
        sutForO.setCellValue(CellValue.O, 2, 2);
        sutForO.setCellValue(CellValue.O, 1, 1);
        sutForO.setCellValue(CellValue.O, 0, 2);


        // Act
        WinnerState expectedWinnerX = sutForX.getWinner();
        WinnerState expectedWinnerO = sutForO.getWinner();

        // Verify
        assertEquals(WinnerState.X, expectedWinnerX);
        assertEquals(WinnerState.O, expectedWinnerO);
    }
}
