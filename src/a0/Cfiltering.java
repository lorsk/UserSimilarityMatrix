// **********************************************************
// Assignment0:
// UTORID:
// UT Student #:
// Author:
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences. In this semester
// we will select any three of your assignments from total of 5 and run it
// for plagiarism check.
// *********************************************************
package a0;

import java.lang.Math;

public class Cfiltering {
  // this is a 2d matrix i.e. user*movie
  private int userMovieMatrix[][];
  // this is a 2d matrix i.e. user*movie
  private float userUserMatrix[][];

  /**
   * Default Constructor.
   */
  public Cfiltering() {
    // this is 2d matrix of size 1*1
    userMovieMatrix = new int[1][1];
    // this is 2d matrix of size 1*1
    userUserMatrix = new float[1][1];
  }

  /*
   * TODO:COMPLETE THIS I.E. APPROPRIATELY CREATE THE userMovieMatrix AND
   * userUserMatrix WITH CORRECT DIMENSIONS.
   */
  /**
   * Constructs an object which contains two 2d matrices, one of size
   * users*movies which will store integer movie ratings and one of size
   * users*users which will store float similarity scores between pairs of
   * users.
   * 
   * @param numberOfUsers Determines size of matrix variables.
   * @param numberOfMovies Determines size of matrix variables.
   */
  public Cfiltering(int numberOfUsers, int numberOfMovies) {
    // create the userUserMatrix with the correct dimensions
    userUserMatrix = new float[numberOfUsers][numberOfUsers];
    // create the userMovieMatrix with the correct dimensions
    userMovieMatrix = new int[numberOfUsers][numberOfMovies];
  }

  /**
   * The purpose of this method is to populate the UserMovieMatrix. As input
   * parameters it takes in a rowNumber, columnNumber and a rating value. The
   * rating value is then inserted in the UserMovieMatrix at the specified
   * rowNumber and the columnNumber.
   * 
   * @param rowNumber The row number of the userMovieMatrix.
   * @param columnNumber The column number of the userMovieMatrix.
   * @param ratingValue The ratingValue to be inserted in the userMovieMatrix
   */
  public void populateUserMovieMatrix(int rowNumber, int columnNumber,
      int ratingValue) {
    userMovieMatrix[rowNumber][columnNumber] = ratingValue;
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC. Add/remove
   * 
   * @param AND
   * 
   * @return as required below.
   */
  /**
   * Determines how similar each pair of users is based on their ratings. This
   * similarity value is represented with with a float value between 0 and 1,
   * where 1 is perfect/identical similarity. Stores these values in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void calculateSimilarityScore() {
    // for loop that keeps track of the current user
    // this user is its own row that will have the scores compared with the
    // other users on the same line
    for (int currentUser =
        0; currentUser < userMovieMatrix.length; currentUser++) {
      // for loop that keeps track of the user that is being compared to
      // the current user
      for (int comparingUser =
          0; comparingUser < userMovieMatrix.length; comparingUser++) {
        // variable that will hold the inside of the square root of the
        // distance formula
        double valueInSqrt = 0;
        // variable that holds the difference between the two users being 
        // compared
        float movieRatingDifference = 0;
        // for loop that goes through the ratings of the two users and finds 
        // their difference
        double similarityScore = 0;
        for (int comparingMovie = 
            0; comparingMovie < userMovieMatrix[currentUser].length; comparingMovie++) {
          movieRatingDifference = userMovieMatrix[currentUser][comparingMovie]
              - userMovieMatrix[comparingUser][comparingMovie];
          valueInSqrt = valueInSqrt + Math.pow(movieRatingDifference, 2);
        }
        similarityScore = 1 / (1 + Math.sqrt(valueInSqrt));
        // next 3 lines round similarity score off to 4 decimal places
        similarityScore = similarityScore*100000;
        similarityScore = (int) similarityScore;
        similarityScore = similarityScore/100000;
        userUserMatrix[currentUser][comparingUser] = (float) similarityScore;
        }
      }
    }



  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * Prints out the similarity scores of the userUserMatrix, with each row and
   * column representing each/single user and the cell position (i,j)
   * representing the similarity score between user i and user j.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */

  public void printUserUserMatrix() {
    System.out.println("userUserMatrix is:");
    for (int column = 0; column < userUserMatrix.length; column++) {
      System.out.print('[');
      for (int row = 0; row < userUserMatrix[column].length; row++) {
        System.out.printf("%.4f",userUserMatrix[column][row]);
        if (row != (userUserMatrix[column].length - 1)) {
          System.out.print(", ");
        }
        
      }
      System.out.println(']');
    }
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * This function finds and prints the most similar pair of users in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */

  public void findAndprintMostSimilarPairOfUsers() {

  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * This function finds and prints the most dissimilar pair of users in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void findAndprintMostDissimilarPairOfUsers() {

  }
}
