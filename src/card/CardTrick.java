/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
import java.util.Scanner;
/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Vadim Titov, Student ID 991777510
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Scanner input = new Scanner(System.in);
        
        for (int i=0; i<magicHand.length; i++)
        {
            // generate a random card
            Card c = new Card();
            c.setValue(1 + (int)(Math.random() * 13));
            c.setSuit(Card.SUITS[(int)(Math.random() * 4)]);
            
            // display the generated card
            System.out.println(c.getSuit() + " " + c.getValue());
            
            // add the card to magic hand
            magicHand[i] = c;
        }
        
        // ask user for a card value and suit number
        System.out.print("Enter a card value (1-13): ");
        int userCardValue = input.nextInt();
        System.out.print("Enter a suit "
                + "(0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int userSuitNumber = input.nextInt();
        
        // compensate for the discrepancy in the output screenshot and 
        // the order in the Card.SUITS constant
        if (userSuitNumber == 2) 
            userSuitNumber = 3;
        else if (userSuitNumber == 3)
            userSuitNumber = 2;
        
        String userSuitName;
        // get the name of the suit with corresponding number, if exists
        if (userSuitNumber >= 0 && userSuitNumber <= 3) {
            userSuitName = Card.SUITS[ userSuitNumber ];
        } else {
            userSuitName = "Invalid";
        }
        
        boolean cardsMatch = false;
        // check if the provided card exists in the magic hand
        for (Card magicHandCard : magicHand) {
            if ( userCardValue == magicHandCard.getValue() 
                    && userSuitName.equals(magicHandCard.getSuit()) ) {
                cardsMatch = true;
            }
        }
        
        // report the result
        if (cardsMatch)
            System.out.println("Your card is in the magic hand.");
        else 
            System.out.println("Sorry, your card is not in the magic hand.");
        

        // add one luckcard hard code 2,clubs
        Card luckyCard =  new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        
        boolean userWon = false; 
        // check if luckyCard is in magicHand
        for (Card magicHandCard : magicHand ) {
            if ( luckyCard.getValue() == magicHandCard.getValue() 
                    && luckyCard.getSuit().equals(magicHandCard.getSuit()) )
                userWon = true;
        }
        
        if (userWon)
            System.out.println(""
                    + "Magic hand had the lucky card, you won!");
        else
            System.out.println(""
                    + "Magic hand didn't have the lucky card, you lost...");
        }
 }
    
