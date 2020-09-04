# RecursiveSudoku

Name: Yordanos Solomon

Professor: Professor Brizan

Runtime and Space Analysis of Each Function:
  - enterBoard, safeBox, and printBoard: Runtime = O(n^2) because the function contains two nested for loops that each run n times.
                                         Space = O(1) because only three variables and two for loops are initialized.
  - safeRow and safeCol : Runtime = O(n) because each function contains one for loop that runs n times.
                          Space = O(1) because each function only initializes one variable and one for loop.
  - play : Runtime = O(n!) because each for loop (each executed n times) slowly runs out of spaces to fill and returns a value once there are no spaces left.
           Space = O(1) because only two for loops are initialized.
  - main : Runtime = O(n!) because it calls the play method and it has the largest runtime of the called methods.
           Space = O(1) because only one variable is initialized.

Comments to Grader: When entering values for each row, separate by spaces (ie. 1 0 2 0 4 5...)
