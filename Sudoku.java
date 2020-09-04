import java.util.Scanner;

public class Sudoku {
    private int[][] board = new int[9][9];
    private boolean validBoard = true;

    public Sudoku() {}

    public void enterBoard() //take user input to fill in the sudoku board
    {
        board = new int[9][9]; //1
        Scanner scan = new Scanner(System.in); //1
        int temp = 0; //1
        for (int row = 0; row < 9; row++) //n
        {
            System.out.print("Please enter row " + (row + 1) + " with spaces between each value: "); //1
            for (int col = 0; col < 9; col++) //n
            {
                temp = scan.nextInt(); //1

                if (safeRow(temp, board, row) && safeCol(temp, board, col) && safeBox(temp, board, row, col)) //3
                {
                    validBoard = true; //1
                    board[row][col] = temp; //1
                }
                else
                {
                    validBoard = false;
                }
            }
        }
    } //Time: O(n^2)
      //Space: O(1)

    public boolean safeCol(int num, int[][] board, int col) //check if it is safe to place num in the given column
    {
        boolean flag = true; //1
        for (int r = 0; r < 9; r++) //n
        {
            if (board[r][col] == num) //1 
            {
                flag = false; //1
            }
        }
        return flag; //1
    } //Time: O(n)
      //Space: O(1)

    public boolean safeRow(int num, int[][] board, int row) //check if it is safe to place num in given row
    {
        boolean flag = true; //1
        for (int c = 0; c < 9; c++) //n
        {
            if (board[row][c] == num) //1
            {
                flag = false; //1
            }
        } 
        return flag; //1
    } //Time: O(n)
      //Space: O(1)

    public boolean safeBox(int num, int[][] board, int row, int col) //check if it is safe to place num in given grid
    {
        int boxR = row - row % 3; //1
        int boxC = col - col % 3; //1
        boolean flag = true; //1

        for (int r = boxR; r < boxR + 3; r++) //n
        {
            for (int c = boxC; c < boxC + 3; c++)  //n
            {
                if (board[r][c] == num) //1
                {
                    flag = false; //1
                }
            }    
        }
        return flag; //1
    } //Time: O(n^2)
      //Space: O(1)

    public boolean play(int[][] board) //the recursive definition of fillling the board with valid moves
    {
        for (int r = 0; r < board.length; r++) //n
        {
            for (int c = 0; c < board.length; c++) //n
            {        
                if (board[r][c] == 0) //1
                {
                    for (int y = 1; y <= 9; y++) //n
                    {
                        if (safeRow(y, board, r) && safeCol(y, board, c) && safeBox(y, board, r, c)) //3n
                        {                          
                            board[r][c] = y; //fill cell with the given value (1-9) //1

                            if (play(board))
                            { //1
                                return true; //1
                            }
                            else 
                            {
                                board[r][c] = 0;   //reset cell to 0
                            }
                        }
                    }   
                    return false; //backtracking
                }
            }
        }
        return true; //returns true if board is completely filled with valid numbers //1
    } //Time: O(n!)
      //Space: O(1)
        
    public void printBoard(int[][] board) //creates a user-freindly representation of the board and prints it for the user
    {
        for (int i = 0; i < 9; i++) //n
        {
            if (i == 0) { //1
                System.out.println("-------------------------"); //prints top border of board //1
            }
            
            for (int j = 0; j < 9; j++) //n
            {
                if (j == 0)
                {
                    System.out.print("| " + board[i][j] + " ");
                }
                else if ((j+1) % 3 == 0) // 3
                {
                    System.out.print(board[i][j] + " | "); //prints divider to separate into sets of 3 columns //3
                }
                else 
                {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println(); //1

            if ((i+1) % 3 == 0) //3
            {
                System.out.println("-------------------------"); //prints to separate into sets of 3 rows //1
            }
        }
    } //Time: O(n^2)
      //Space: O(1)

    public static void main(String[] args) 
    {
        Sudoku sudoku = new Sudoku(); //1

        sudoku.enterBoard(); 

        if (sudoku.play(sudoku.board) && sudoku.validBoard) 
        {
            sudoku.printBoard(sudoku.board);
        }
        else
        {
            System.out.println("Unsolvable Board");
        }
    } //Time: O(n!)
      //Space: O(1)

}