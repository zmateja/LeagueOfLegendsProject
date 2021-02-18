package MainPackage;

import java.util.ArrayList;

import MainPackage.APIQueries;
import org.json.simple.JSONObject;


public class testDriver {
    public static void main(String[] args) {
        //MainPackage.lolui.setLookAndFeel(); Graphics are messing me up - will work on this part later.
        //MainPackage.lolui UI = new MainPackage.lolui();
        Summoner mySum = APIQueries.getSummonerByName("Copperbones");
        ArrayList<lolMatch> myMatches = APIQueries.getMatchesForAccount(mySum.accountId);
        JSONObject matchInfo = myMatches.get(0).getMatchInfo();

        ArrayList<String> playerNames = myMatches.get(0).getPlayers(matchInfo);
        ArrayList<String> playerKDA = myMatches.get(0).getPlayerKDAs(matchInfo);
        System.out.printf("%16s %8s", "Summoner Name", "K/D/A");
        System.out.println();
        for(int i = 0; i < playerNames.size(); i++){
            System.out.format("%16s %8s", playerNames.get(i), playerKDA.get(i));
            System.out.println();
        }
        //System.out.println(mySum.accountId);
    }
}