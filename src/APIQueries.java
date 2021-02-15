import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIQueries {
    public static Summoner getSummonerByName(String summonerName) {
        try {
            String summonerAPI = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
            URL url = new URL("" + summonerAPI + summonerName + "?api_key=" + SecretStuff.getAPIKey());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();

            if (responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            else {
                String inline = "";
                Scanner scan = new Scanner(url.openStream());

                while (scan.hasNext()) {
                    inline += scan.nextLine();
                }

                scan.close();

                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);
                Summoner mySummoner = new Summoner(data_obj);
                return mySummoner;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
