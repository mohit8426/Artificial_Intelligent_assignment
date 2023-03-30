Name: Mohit Shailesh Kulkarni
UTA ID: 1002031021

1. The Task 2 is implemented in Java Programming in Windows 11
2. The Code is structured as AiPlayer.java then GameBoard.java then maxconnect4.java
3. The findBestPlay function contains the minmax and alpha beta pruining of the connect 4 task i.e. the interactive mode and the other 2 function min_val and max_val contains the one-move mode
4. Compilation of the code is simple using javac maxconnect4.java GameBoard.java AiPlayer.java and then run by java maxconnect4 one-move input1.txt output1.txt 10 for one-move mode and java 
maxconnect4 interactive input1.txt computer-next 10 for interactive mode where input1.txt is inputfile one-move/interactive is mode and 10 is depth value.
5. I have implemented this code in Visual Studio Code Java 17
6. CPURunningTime_mohit.docx file contains the running time Start time and End Time of the depth till it exceeds 1 minute time 

Bellow is the sample output I recieved:

PS C:\Users\mohit\OneDrive\Desktop\AI\assig\java> javac maxconnect4.java GameBoard.java AiPlayer.java
PS C:\Users\mohit\OneDrive\Desktop\AI\assig\java> java maxconnect4 one-move input1.txt output1.txt 10

MaxConnect-4 game
game state before move:
 -----------------
 | 0 0 0 0 0 0 0 | 
 | 0 0 0 0 0 0 0 | 
 | 0 0 0 0 0 0 0 | 
 | 0 0 0 0 0 0 0 | 
 | 0 0 0 0 0 0 0 | 
 | 0 0 0 0 0 0 0 | 
 -----------------
Score: Player 1 = 0, Player2 = 0
 
move 1: Player 1, column 6
game state after move:
 -----------------
 | 0 0 0 0 0 0 0 | 
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 1 |
 -----------------
Score: Player 1 = 0, Player2 = 0

PS C:\Users\mohit\OneDrive\Desktop\AI\assig\java> java maxconnect4 interactive input1.txt computer-next 10

Current Game Board:
 -----------------
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 -----------------
Score: Player 1 = 0, Player2 = 0

Its Computer's turn

7
move 1: Player 1, column 6

MaxConnect-4 game
game state before move:
 -----------------
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 | 
 | 0 0 0 0 0 0 1 |
 -----------------
Score: Player 1 = 0, Player2 = 0

move 2: Player 2, column 6
game state after move:
 -----------------
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 0 |
 | 0 0 0 0 0 0 2 |
 | 0 0 0 0 0 0 1 |
 -----------------
Score: Player 1 = 0, Player2 = 0
