/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
import java.util.ArrayList;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private ArrayList<Player> players = new ArrayList<Player>();
  private Board board;

  /* your code here - constructor(s) */ 
  PhraseSolver(int numPlayers)
  {
    board = new Board();
  }
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      
      /* your code here - game logic */
      
      
      /* your code here - determine how game ends */
      solved = true; 
    } 
   
  }
  
}