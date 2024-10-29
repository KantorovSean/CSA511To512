/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 * Laasya Koduri, Sean Kantorov 
 * Period 7
 */
import java.util.Scanner;
import java.util.ArrayList;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private ArrayList<Player> players;
  private Board board;
  private Scanner input;
  private int numPlayers;

  /* your code here - constructor(s) */ 
  PhraseSolver()
  {
    this.board = new Board();
    this.input = new Scanner(System.in);
    this.players = new ArrayList<Player>();
  }
  /* your code here - accessor(s) */
  public ArrayList<Player> getPlayers()
  {
    return players;
  }
  /* your code here - mutator(s)  */
  private void playerMaker() //make private, public is for testing
  {
    System.out.println("How many players? ");
    boolean worked = false;
    while(!worked)
    {
      String tempString = input.nextLine(); 
      try
      {
        numPlayers = Integer.valueOf(tempString);
        if(numPlayers > 0)
        {
          worked = true;
        }
      }
      catch(Exception e)
      {
        System.out.println("Make sure to enter a number");
      }
    }
    System.out.println(numPlayers);
    for(;numPlayers > 0; numPlayers--)
    {
      System.out.println("Enter name a name you have " + numPlayers + " that need names");
      String name = input.nextLine();
      Player player = new Player(name);
      players.add(player);
    }
    numPlayers = players.size(); 
  } 

  public void play()
  {
    playerMaker();
    
    while (!board.isSolved(board.getSolvedPhrase())) //determines if the phrase has been solved or not
    {
      for(int currentPlayer = 0; currentPlayer < players.size(); currentPlayer++) //loops through each player
      {
        //checking if the player's turn will be skipped
        if (players.get(currentPlayer).getTurn() == false)
        {
          players.get(currentPlayer).nextTurn(true);
          continue;
        }
        //getting the user input
        System.out.println("It's " + players.get(currentPlayer).getName() + "'s turn");
        System.out.println("Enter your guess: ");
        String guess = input.nextLine();
        
        //checking which type of guess it is
        if (guess.length() > 1)//whole phrase guess
        {
          players.get(currentPlayer).nextTurn((board.isSolved(guess)));  
        }
        else//single letter guess
        {
          players.get(currentPlayer).nextTurn(board.guessLetter(guess)); //automatically updates their future turn policy
          
          if(players.get(currentPlayer).getTurn()) //if they still have a turn they will have their score updated
          {
            players.get(currentPlayer).updateScore(board.getCurrentLetterValue());
          }
        }
        if (!players.get(currentPlayer).getTurn())
        {
          System.out.println("your turn will be skipped next round");
        }
        if(board.isSolved(board.getSolvedPhrase()))
        {
          System.out.println("This player won the game " + players.get(currentPlayer).getName());
          break;
        }
      }
    } 
  }
  
}