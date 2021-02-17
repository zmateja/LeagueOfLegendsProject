package MainPackage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class lolMatch {
    private long gameId;
    private String role;
    private String champion;


    public lolMatch(JSONObject summoner_data) {
        gameId = (long) summoner_data.get("gameId");
        champion = summoner_data.get("champion").toString();
        role = summoner_data.get("champion").toString();
    }

    public ArrayList<String> getPlayers(){
        ArrayList<String> playerNames = new ArrayList<>();
        JSONObject matchInfo = APIQueries.getMatchInfo(this.gameId);
        JSONArray playerIdArr = (JSONArray) matchInfo.get("participantIdentities");

        for (Object o : playerIdArr) {
            JSONObject new_obj = (JSONObject) o;
            JSONObject Player = (JSONObject) new_obj.get("player");
            playerNames.add(Player.get("summonerName").toString());
        }
        return playerNames;
    }
}
