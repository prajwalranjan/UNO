package com.mycompany.uno;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ujjwaljain
 */

import java.util.Scanner;
import Player.Player;
import Pile.*;
import Card.*;
import UtilClasses.DeckInitializer;
import static java.lang.Thread.*;
import java.util.ArrayList;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainGame {
	
	static Player[] createPlayers(int numPlayers, Scanner sc, DrawPile drawPile, DiscardPile discardPile) {
		Player[] players = new Player[numPlayers];
		int playerNum;
		for(int i=0; i<4; i++) {
			playerNum = i+1;
			System.out.println("Player " + playerNum + " Name: ");
			String playerName = sc.nextLine();
			players[i] = new Player(playerName, playerNum, discardPile, drawPile);
		}
		return players;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws NoSuchElementException {
		System.out.println("***** Welcome to UNO! *****");
		
		DeckInitializer deckInitializer = new DeckInitializer();
		final DrawPile drawPile = deckInitializer.getDrawPile();
		final DiscardPile discardPile = deckInitializer.getDiscardPile();
                Game game;
                int gamedir = 1;
                discardPile.addCardToPile(drawPile.returnTopCard());
                while(discardPile.returnTopCard().getCardType()=="Special"){
                   discardPile.addCardToPile(drawPile.returnTopCard());
                }
		
		Scanner sc = new Scanner(System.in);
                ArrayList<Player> players = new ArrayList<>();

		
		Player currentPlayer;
                int startingPlayerNumber = 0, currentPlayerNumber = startingPlayerNumber;
		StartMenu menu=new StartMenu(players,drawPile,discardPile);
                menu.setTitle("Main Menu");
                menu.setVisible(true);
                try {
                    sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                while(menu.getinitplay().isVisible()){
                    try { 
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while(true) {		
                Card topCard = discardPile.returnTopCard();
		currentPlayer = players.get(currentPlayerNumber);
                game = new Game(currentPlayer,discardPile,drawPile);
                game.setVisible(true);
                currentPlayer.showPlayerHand();
                while(game.isVisible()){
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(topCard.getCardType().equals("Normal")){
                    currentPlayerNumber=(currentPlayerNumber+gamedir)%4;
                    continue;
                }
                else if (topCard.getCardDetails().equals("reverse")){
                    gamedir*=-1;
                    currentPlayerNumber=(currentPlayerNumber+gamedir)%4;
                    continue;
                }
                if(currentPlayer.numCardsLeft()==0){
                    System.out.println(currentPlayer.getPlayerName()+" is the Winner !!!");
                    break;
                }
                    
//		discardPile.addCardToPile(drawPile.returnTopCard());
            }
		
//		while(true) {			
//			Card topCard = discardPile.returnTopCard();
//			currentPlayer = players[currentPlayerNumber];
//			topCard.displayCard();
//			
//			if(topCard.getCardType().equals("Normal")) { //Normal card
//				currentPlayer.start();
//				currentPlayerNumber = (currentPlayerNumber+1)%4;
//			} else if(topCard.getCardType().equals("Special")) { //Special card
//				String topCardAttr = topCard.getCardDetails();
////				String topCardColor = topCard.getCardColor();
//				
//				switch(topCardAttr) {
//				case("Reverse"):
//					currentPlayerNumber = (4+(currentPlayerNumber-1))%4;
//					break;
//					
//				case("Skip"):
//					currentPlayerNumber = ((currentPlayerNumber+1))%4;
//					break;
//				
//				case("DrawTwo"):
//					currentPlayer.start();
//					currentPlayerNumber = (currentPlayerNumber+1)%4;
//					break;
//				
//				case("DrawFour"):
//					currentPlayer.start();
//					currentPlayerNumber = (currentPlayerNumber+1)%4;
//					break;
//				
//				case("Wild"):
//					currentPlayer.start();
//					currentPlayerNumber = (currentPlayerNumber+1)%4;
//					break;
//				}
//			}
//			
//			if(currentPlayer.numCardsLeft()==0) {
//				break;
//			}
//			
//			currentPlayer.stop();
//		}
//		
//		System.out.println("Winner: ");
//		
	}

}
