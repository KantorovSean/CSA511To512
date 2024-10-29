/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
public class Player
{
  /* your code here - attributes */
  private String name;
  private int score;
  boolean turn;
  /* your code here - constructor(s) */ 
  Player(String name)
  {
    this.name = name;
    this.score = 0;
    this.turn = true;
  }

  /* your code here - accessor(s) */ 
  public String getName()
  {
    return name;
  }

  public int getScore()
  {
    return score;
  }

  public boolean getTurn()
  {
    return turn;
  }
  /* your code here - mutator(s) */
  public int updateScore(int amount)
  {
    return score += amount;
  }

  public void nextTurn(boolean turnStatus)
  {
    turn = turnStatus;
  }

}