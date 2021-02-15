import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;


public class driver {
    public static void main(String[] args) {
        lolui.setLookAndFeel();
        lolui UI = new lolui();
        Summoner mySum = APIQueries.getSummonerByName("Copperbones");
        //System.out.println(mySum.accountId);


    }
}
