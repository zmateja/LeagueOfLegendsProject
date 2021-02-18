package MainPackage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class APIQueries {
    public static Summoner getSummonerByName(String summonerName) {
       String summonerAPI = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName;
       return new Summoner(genQuery(summonerAPI));
    }
    public static ArrayList<lolMatch> getMatchesForAccount(String accountId){
        ArrayList<lolMatch> matchList = new ArrayList<>();
        String matchesAPI = "https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId;
        JSONObject data_obj = genQuery(matchesAPI);
        JSONArray matchArr = (JSONArray) data_obj.get("matches");

        for (Object o : matchArr) {
            JSONObject new_obj = (JSONObject) o;
            lolMatch new_match = new lolMatch(new_obj);
            matchList.add(new_match);
        }
        return matchList;
    }
    public static JSONObject getMatchInfo(long gameId){
        return genQuery("https://na1.api.riotgames.com//lol/match/v4/matches/" + gameId);
    }
    private static JSONObject genQuery(String apiUrl){
        try {

            URL url = new URL(apiUrl + SecretStuff.getAPIKey());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();

            if (responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            else {
                StringBuilder inline = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());

                while (scan.hasNext()) {
                    inline.append(scan.nextLine());
                }

                scan.close();

                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline.toString());
                return data_obj;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
