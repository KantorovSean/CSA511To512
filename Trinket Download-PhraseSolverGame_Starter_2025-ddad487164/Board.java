/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 * Laasya Koduri, Sean Kantorov 
 * Period 7
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  Board()
  {
    //setting the phrase
    solvedPhrase = "";
    phrase = loadPhrase();

    //setting the score val per correct letter
    setLetterValue();
  }

  /* your code here - accessor(s) */
  public int getCurrentLetterValue()
  {
    return currentLetterValue;
  }

  public String getSolvedPhrase()
  {
    return solvedPhrase;
  }

  public String getPhrase()
  {
    return phrase;
  }
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("Trinket Download-PhraseSolverGame_Starter_2025-ddad487164\\phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("Trinket Download-PhraseSolverGame_Starter_2025-ddad487164\\\\phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += " ";
      }  
      else
      {
        solvedPhrase += "_";
      }
    }  
    
    return tempPhrase;
  } 

/*
 * Precondition:
 * user must guess a phrase
 * Postconditions:
 * User-inputted phrase is evaluated
 * the correctly guessed phrase is outputted
 */
  public boolean guessLetter(String guess)
  {
    //foundLetter variable is initialized to false
    boolean foundLetter = false;
    //newSolvedPhrase variable is initialized as an empty string
    String newSolvedPhrase = "";
    //lastIndex variable is initialized to the value 0
    int lastIndex = 0;

    //for loop iterates through the entire phrase
    for (int i = 0; i < phrase.length(); i++)
    {
      //conditional checks if letter was correctly guessed
      if ((String.valueOf(phrase.charAt(i)).equals(guess)))
      {
        //newSolvedPhrase variable updated each iteration if letter is correctly guessed
        newSolvedPhrase += solvedPhrase.substring(lastIndex, i) + guess;
        //lastIndex variable is being incremented on each iteration
        lastIndex = i + 1;
        //foundLetter variable is changed to true
        foundLetter = true;
      }
    }
    //sets solvedPhrase variable equal to newSolvedPhrase and the solvedPhrase
    solvedPhrase = newSolvedPhrase + solvedPhrase.substring(lastIndex);
    //Prints out final solvedPhrase
    System.out.println(solvedPhrase);
    //foundletter boolean is outputted to the program
    return foundLetter;
  } 
} 