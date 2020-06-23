package com.raiix.homework2;

public class App {

    void compareBlackAndWhite(String blackData, String whiteData){
        Poker black = new Poker(blackData.split(" "));
        Poker white = new Poker(whiteData.split(" "));
        PokerComparer pc = new PokerComparer(black, white);
        System.out.printf("Black:`%s` White:`%s`\n", black.toString(), white.toString());
        System.out.println(pc.whoWins());
    }

    public static void main(String[] args){
        App app = new App();
        app.compareBlackAndWhite("2H 3D 5S 9C KD", "2C 3H 4S 8C AH");
        app.compareBlackAndWhite("2H 4S 4C 2D 4H", "2S 8S AS QS 3S");
        app.compareBlackAndWhite("2H 3H 5H 9H KH", "2C 3H 4S 5C 6H");
        app.compareBlackAndWhite("2H 3D 5S 9C KD", "2D 3H 5C 9S KH");
    }
}
