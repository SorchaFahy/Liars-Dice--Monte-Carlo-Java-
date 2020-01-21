
import java.util.Scanner;


import java.util.Random;

public class LiarsDiceGuess{
public static void main(String [] args){
        Scanner sc = new Scanner(System.in);       //read in guess from input
        int numPlayers = Integer.parseInt(sc.nextLine());   //read in number of players in game
        String [] dice = sc.nextLine().split(" ");   //create string array of my die faces
        String [] guess = sc.nextLine().split(" ");  //create array of two guess integers
       
        int numTimes = Integer.parseInt(guess[0]);      //fill guess array (number of times)
        int face = Integer.parseInt(guess[1]);          //with input (faces value)
        int newNumTimes = numTimes;                    //initialize new variable with number of times

    for(int i = 0; i<dice.length; i++){
        int temp = Integer.parseInt(dice[i]);  //loop through my own die faces
        if (temp == face || temp == 1)         //if they're equal to the guess or one(one's are wild)
   
            {
                newNumTimes--;                  //decrement the amount of times it's occured
            }
        }  

Random rand = new Random();


    int rolls = (numPlayers - 1) * 5;   //calculate the amount of rolls of all players(excluding mine)
    int totalOccurances = 0;            // initialize total occurences of face variable
    int monte = 500000;                 //monte carlo simulation amount

    for(int i=0; i<monte; i++){         //monte carlo begins
            int countFaces = 0;         

    for(int j=0; j<rolls; j++){       
 
    int tempFace = rand.nextInt(6) + 1;  //create random numbers of faces


        if(tempFace == face || tempFace == 1){ //if any of them are equal to the guess face or one
            countFaces++;                      //increment countFaces
        }
    }

        if(countFaces >= newNumTimes){    //if the number of times the face occured in monte carlo sim >=newNumTimes
            totalOccurances++;             //increment total occurences of the face
           
        }
}

    double answer = ((double)totalOccurances/(double)monte) * 100;   // get the percentage probability

        int answer1=(int) Math.round (answer);

        System.out.println(answer1);
   }

}