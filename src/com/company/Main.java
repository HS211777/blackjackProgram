package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Main {
    static String houseCards = "";
    static String playerCards = "";
    static ArrayList<ArrayList<String>> cards = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    boolean end = false;
    while (!end){
        for(int i = 0; i < 4; i++){
            cards.add(new ArrayList<>());
            cards.get(i).add("1");
            cards.get(i).add("2");
            cards.get(i).add("3");
            cards.get(i).add("4");
            cards.get(i).add("5");
            cards.get(i).add("6");
            cards.get(i).add("7");
            cards.get(i).add("8");
            cards.get(i).add("9");
            cards.get(i).add("X");
            cards.get(i).add("J");
            cards.get(i).add("Q");
            cards.get(i).add("K");
        }
        System.out.println(cards);
        cardDraw(0);
        cardDraw(0);
        cardDraw(1);
        cardDraw(1);
        int userInput = 0;
        while (userInput == 0){
            System.out.println(playerCards);
            System.out.println("hit(0) or stick(1)?");
            userInput = input.nextInt();
            if (userInput == 0){
                cardDraw(1);
            }
            if (showValue(1) > 21){
                userInput = 1;
            }
        }
        boolean houseEnd = false;
        while (!houseEnd){
            if (showValue(0) < 17){
                cardDraw(0);
            }
            else if (showValue(0) < showValue(1)){
                cardDraw(0);
            }
            else if (showValue(0) > 21){
                houseEnd = true;
            }
            else{
                houseEnd = true;
            }
        }
        if (showValue(1) > 21){
            System.out.println("you lose");
        }
        else if (showValue(0)>21){
            System.out.println("you win");
        }
        else if (showValue(1)>showValue(0)){
            System.out.println("you win");
        }
        else{
            System.out.println("you lose");
        }
        System.out.println("play again? Y/N");
        String playAgain = input.next();
        if (playAgain.equalsIgnoreCase("n")){
            end = true;
            for (int i = 0; i < cards.size();i++){
                cards.remove(0);
            }
        }
    }
    }
    public static void cardDraw(int args){
        int suit;
        int cardNum;
        int suitLength;
        Random rn = new Random();
        if (args == 0){
            suit = rn.nextInt(cards.size());
            suitLength = cards.get(suit).size();
            if (suitLength == 0){
                cards.remove(suit);
                suit = rn.nextInt(cards.size());
                suitLength = cards.get(suit).size();
            }
            cardNum = rn.nextInt(suitLength)+1;
            houseCards = houseCards + cards.get(suit).get(cardNum);
            cards.get(suit).remove(cardNum);
        }
        else{
            suit = rn.nextInt(cards.size());
            suitLength = cards.get(suit).size();
            if (suitLength == 0){
                cards.remove(suit);
                suit = rn.nextInt(cards.size());
                suitLength = cards.get(suit).size();
            }
            cardNum = rn.nextInt(suitLength)+1;
            playerCards = playerCards + cards.get(suit).get(cardNum);
            cards.get(suit).remove(cardNum);
        }
    }
    public static int showValue(int args){
        int output = 0;
        if (args == 0) {
            for (int i = 0; i < houseCards.length(); i++) {
                if (houseCards.charAt(i) == (char) 2) {
                    output += 2;
                } else if (houseCards.charAt(i) == (char) 3) {
                    output += 3;
                } else if (houseCards.charAt(i) == (char) 4) {
                    output += 4;
                } else if (houseCards.charAt(i) == (char) 5) {
                    output += 5;
                } else if (houseCards.charAt(i) == (char) 6) {
                    output += 6;
                } else if (houseCards.charAt(i) == (char) 7) {
                    output += 7;
                } else if (houseCards.charAt(i) == (char) 8) {
                    output += 8;
                } else if (houseCards.charAt(i) == (char) 9) {
                    output += 9;
                } else if (houseCards.charAt(i) == (char) 1) {
                    if (output + 11 > 21) {
                        output += 1;
                    } else {
                        output += 11;
                    }
                } else{
                    output += 10;
                }
            }
        }
        else{
                for (int i = 0; i < playerCards.length();i++){
                    if (playerCards.charAt(i) == (char) 2){
                        output += 2;
                    }
                    else if (playerCards.charAt(i) == (char) 3){
                        output += 3;
                    }
                    else if (playerCards.charAt(i) == (char) 4){
                        output += 4;
                    }
                    else if (playerCards.charAt(i) == (char) 5){
                        output += 5;
                    }
                    else if (playerCards.charAt(i) == (char) 6){
                        output += 6;
                    }
                    else if (playerCards.charAt(i) == (char) 7){
                        output += 7;
                    }
                    else if (playerCards.charAt(i) == (char) 8){
                        output += 8;
                    }
                    else if (playerCards.charAt(i) == (char) 9){
                        output += 9;
                    }
                    else if (playerCards.charAt(i) == (char) 1){
                        if (output+11>21){
                            output += 1;
                        }
                        else{
                            output += 11;
                        }
                    }
                    else{
                        output += 10;
                    }
                }
        }
        return output;
    }
}
