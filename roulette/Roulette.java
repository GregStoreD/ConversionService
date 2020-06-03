package lotto;

import java.util.Random;       
import java.io.File;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;
import java.util.ArrayList; 
import java.io.FileNotFoundException;
import java.util.Arrays;

    public class Roulette {
       
         enum Level {
            WON,
            LOSE          
         }      
        
        private String [] getPlayerBets(){
        
            String csvFile = "lotto.csv";
            File file= new File(csvFile);
            List<List<String>> lines = new ArrayList<>();
            Scanner inputStream;

            try{
                inputStream = new Scanner(file);

                while(inputStream.hasNext()){
                    String line= inputStream.next();
                    String[] values = line.split(",");
                    lines.add(Arrays.asList(values));
                }             
                inputStream.close();
                String[] playersArray = lines.toArray(new String[0]);
                return playersArray;
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
        
        public int [] getSecondRoundBets(){            
          int count = 5;         
          int [] bets = new int [count];
           for (int i=0; i < count; i++){
                bets[i] = new Random().nextInt(36);                
           }       
           return bets;
        }
        
        private int getWinnerBall(){        
            Random rand = new Random();
            return rand.nextInt(36);
        }
        
        public static boolean isInteger(String s) {
           boolean isValidInteger = false;
           try {
               Integer.parseInt(s);
               isValidInteger = true;
           }catch (NumberFormatException ex) {
               //System.out.println("Validate Integer fail:" + ex);
           }
            return isValidInteger;
        }
       
       public static boolean checkEvenInt(int i){
            return i % 2 == 0 ? true : false; 
       }
       
       
       public static String evenOrOdd(int i, String bet){
            return (checkEvenInt(i) && bet.equals("EVEN")) ? "EVEN" : "ODD"; 
       }
       
                           
        private void getOutcomeResults(){
                   
            String [] bets = getPlayerBets();
            int winner = getWinnerBall();
            int win = 0;
            int count = 0;
            int index = 0;
            int [] nextRoundBets = getSecondRoundBets();
            double playerRewards = 0.0;
            //Outcome
            System.out.println("Number:" + winner);
            System.out.println();
            System.out.println("##################################################################");
            System.out.format("%15s %15s %15s %15s", "Player", "Bet", "Outcome", "Winnings\n");
            System.out.println("##################################################################");
           
           
            while (count <= 2){
                for (String item : bets) {
                    String[] bet = item.split("\\s+");                              
                    // is integer
                    if (isInteger(bet[1+index])) {                   
                        int playerBet = Integer.parseInt(bet[1+index]);                      
                        if (playerBet == winner) {
                            playerRewards = Double.parseDouble(bet[2+index]) * 36;                           
                            System.out.format("%15s %15s %15s %15.2f", bet[0], bet[1+index], Level.WON, playerRewards);
                            System.out.println();
                            win++;
                        }                     
                        else{
                            playerRewards = 0.0;
                            System.out.format("%15s %15s %15s %15.2f", bet[0], bet[1+index], Level.LOSE, playerRewards);
                            System.out.println();
                        }

                    // is EVEN or ODD 
                    }else { 
                        playerRewards = Double.parseDouble(bet[2]);
                        if (evenOrOdd(winner, bet[1]).equals(bet[1+index])){                       
                            playerRewards = Double.parseDouble(bet[2+index]) * 2;
                            System.out.format("%15s %15s %15s %15.2f", bet[0], bet[1+index], Level.WON, playerRewards);
                            System.out.println();
                            win++
                        }
                        else {
                            playerRewards = 0.0;
                            System.out.format("%15s %15s %15s %15.2f", bet[0], bet[1+index], Level.LOSE, playerRewards);
                            System.out.println();
                        }
                    }
                System.out.println();
                System.out.format(bet[0] + " has won " + win + " with an amount of " + bet[2+index]);
                }
            count++;
            index+=2;
            }
        }
    }
       
   public static void main(String[] args) {       
              
      TimerTask task = new TimerTask() {
          
      @Override
      public void run() {

          Roulette lO = new Roulette();
          lO.getOutcomeResults();
        }
      };

      int count = 0;
      Timer timer = new Timer();
      long delay = 5000;
      long intevalPeriod = 30000; 
      timer.schedule(task, delay,intevalPeriod);
      if (++count == 3){
          timer.cancel();
      }    
    }       
    