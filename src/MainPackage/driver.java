package MainPackage;

import java.util.ArrayList;

import MainPackage.APIQueries;


public class driver {
    public static void main(String[] args) {
        //MainPackage.lolui.setLookAndFeel(); Graphics are messing me up - will work on this part later.
        //MainPackage.lolui UI = new MainPackage.lolui();
        Summoner mySum = APIQueries.getSummonerByName("Copperbones");
        ArrayList<lolMatch> myMatches = APIQueries.getMatchesForAccount(mySum.accountId);
        ArrayList<String> playerNames = myMatches.get(0).getPlayers();
        //System.out.println(mySum.accountId);
    }
}