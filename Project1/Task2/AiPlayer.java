import java.util.*;

//Mohit Shailesh Kulkarni
//UTA ID: 1002031021
//Java Implementation in Windows 11
// References:
//https://stackabuse.com/minimax-and-alpha-beta-pruning-in-python/
//https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-4-alpha_value-beta_value-pruning/
//https://www.javatpoint.com/ai-alpha_value-beta_value-pruning
/**
 * This is the AiPlayer class.  It simulates a minimax player for the max
 * connect four game.
 * The constructor essentially does nothing. 
 * 
 * @author james spargo
 *
 */

public class AiPlayer 
{
    // setting the value of alpha_value and beta_value to minimum and maximum values
    public int depth_value;
    public int alpha_value = -1000000000;   //alpha value can be 1000000000
    public int beta_value = 1000000000;     // beta value can be 100000000
    public GameBoard game;

    /**
     * The constructor essentially does nothing except instantiate an
     * AiPlayer object.
     *
     */
    public AiPlayer(GameBoard game, int depth_value) 
    {
        this.game = game;
        this.depth_value = depth_value;
    }

    /**
     * This method plays a piece randomly on the board
     * @param currentGame The GameBoard object that is currently being used to
     * play the game.
     * @return an integer indicating which column the AiPlayer would like
     * to play in.
     */
    public int findBestPlay(GameBoard currentGame) 
    {   // Intializing all the temporary variables to 0
        GameBoard nextGame;
    	int x1 = 0;
        int x2 = 0;  
        int a = 0;   
        int b = 0; 
        if(currentGame.getCurrentTurn() != 1)
        {     // Getting value for Alpha in the game board   
            for(int y = 0; y <= 6; y++){
                
                if(currentGame.isValidPlay(y))
                {                  
                    nextGame = new GameBoard(currentGame.getGameBoard());
                    nextGame.playPiece(y);                   
                    x1 = min_val(alpha_value, beta_value , depth_value , nextGame);
                    a = alpha_value;                  
                    if(alpha_value < x1) 
                    {
                        a = x1;
                        x2 = y;
                    }               
                }
            }            
        }
        else 
        {     // getting value for the beta in the game board       
            for(int y = 0; y <= 6; y++)
            {               
                if(currentGame.isValidPlay(y))
                {                   
                    nextGame = new GameBoard(currentGame.getGameBoard());
                    nextGame.playPiece(y);  
                    x1 = max_val(alpha_value, beta_value ,depth_value ,nextGame);
                    b = beta_value;                   
                    if(beta_value > x1)
                    {
                        b = x1;
                        x2 = y;
                    }               
                }
            }          
        }        
    return x2;
    }

    //****************** Getting Minimum Value******************* 
    private int min_val(int min, int max, int depth_value, GameBoard game)
    {
        GameBoard new_game1;
        int x2 = 0;
        int res = 1000;
        if(depth_value != 0 && game.getPieceCount() < 42)
        {
            for (int y = 0; y <= 6; y++)
            {
                if(game.isValidPlay(y))
                {
                    new_game1 = new GameBoard (game.getGameBoard());
                    new_game1.playPiece(y);
                    x2 = max_val(min, max, depth_value - 1, new_game1);
                    res = Math.min(beta_value, x2);
                    if(res <= min)
                    {
                        return res;
                    }
                    max = Math.min(max,res);
                }
            }
            return res;
        }
        else
            return res = game.getScore(2) - game.getScore(1);
    }

    //*********************Getting Maximum Value*************** */
    private int max_val(int min, int max, int depth_value, GameBoard game)
    {
        int x1 = 0;
        GameBoard new_game2;
        int res = -1000;
        if(depth_value != 0 && game.getPieceCount() < 42)
        {
            for (int y = 0; y <= 6; y++)
            {
                if(game.isValidPlay(y))
                {
                    new_game2 = new GameBoard (game.getGameBoard());
                    new_game2.playPiece(y);
                    x1 = min_val(min, max, depth_value - 1, new_game2);
                    res = Math.max(alpha_value, x1);
                    if(res >= max)
                    {
                        return res;
                    }
                    min = Math.max(min,res);
                }
            }
            return res;
        }
        else
            return res = game.getScore(2) - game.getScore(1);
    }   
}