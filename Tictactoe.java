/*
* Click `Run` to execute the snippet below!
*/

import java.io.*;
import java.util.*;

/*
* To execute Java, please define "static void main" on a class
* named Solution.
*
* If you need more classes, simply define them inline.
*/

class Tictactoe {
 public static void main(String[] args) {
   
   Player p0 = new Player("Taiwo", 1);
   Player p1 = new Player("Kehinde", 2);
   players = new Player[]{p0, p1};
   
   availableSquares = new ArrayList<>(Arrays.asList("00","01","02","10","11","12","20","21","22"));
   System.out.println("Game start");
   Random randomGenerator = new Random();
   int i =-1;
   Player player = p1;
   String result = "continue";
   while(!gameIsOver(result)){
     i++;
     player = players[i%2];
     int availableSquareCount = availableSquares.size();
     int nextSquaretoFill = randomGenerator.nextInt(availableSquareCount);
     result = play(player, availableSquares.get(nextSquaretoFill));
   }
   System.out.println(player.getName() + " experienced a "+ result);
   System.out.println(Arrays.deepToString(board));
   board = new int[3][3];
 }
 
 static String play(Player player, String square){
   int row = Integer.parseInt(String.valueOf(square.charAt(0)));
   int column = Integer.parseInt(String.valueOf(square.charAt(1)));
   board[row][column]=player.getToken();
   availableSquares.remove(square);
   return getResult(player);
 }
 
 static public String getResult(Player player){
   int token = player.getToken();
   if(isWin(token)) return "win";
   if(isLoss(token)) return "loss";
   if(isDraw(token)) return "draw";
   return "continue";
 }
 
 static boolean gameIsOver(String result){
   return !result.equals("continue");
 }
 
 static boolean isDraw(int token){
   return availableSquares.size()==0;
 }
 
 static boolean isLoss(int token){
   return isWin(token==1?2:1);
 }
 
 static boolean isWin(int token){
   //8 scenarios
   return 
     ((board[0][0]==token&&board[0][1]==token&&board[0][2]==token)||
     (board[1][0]==token&&board[1][1]==token&&board[1][2]==token) ||
     (board[2][0]==token&&board[2][1]==token&&board[2][2]==token)||
     (board[0][0]==token&&board[1][0]==token&&board[2][0]==token)||
     (board[0][1]==token&&board[1][1]==token&&board[2][1]==token)||
     (board[0][1]==token&&board[1][2]==token&&board[2][2]==token)||
     (board[0][0]==token&&board[1][1]==token&&board[2][2]==token)||
     (board[0][2]==token&&board[1][1]==token&&board[2][0]==token));
 }
 
 private static int[][]board = new int[3][3];//can be bit for optimised storage
 private static List<String> availableSquares;
 private static Player[] players;
}

class Player{
 
 public String getName(){
   return name;
 }
 
 public int getToken(){
   return token;
 }
 
 Player(String name, int token){
   this.name = name;
   this.token = token;
 }
 
 private String name;
 private int token;
}