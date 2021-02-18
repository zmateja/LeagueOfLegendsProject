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
    public JSONObject getMatchInfo(){
        return APIQueries.getMatchInfo(this.gameId);
    }

    public ArrayList<String> getPlayers(JSONObject matchInfo){
        ArrayList<String> playerNames = new ArrayList<>();
        JSONArray playerIdArr = (JSONArray) matchInfo.get("participantIdentities");
        for (Object o : playerIdArr) {
            JSONObject new_obj = (JSONObject) o;
            int partId = Integer.parseInt(new_obj.get("participantId").toString()); // there has to be a better way to do this but it works for now
            JSONObject Player = (JSONObject) new_obj.get("player");
            playerNames.add(partId-1, Player.get("summonerName").toString());
        }
        return playerNames;
    }

    private static JSONObject[] getPlayerStats(JSONObject matchInfo){
        JSONArray playerArr = (JSONArray) matchInfo.get("participants");
        JSONObject[] outputStatsArr = new JSONObject[playerArr.size()];
        for (Object o : playerArr) {
            JSONObject player = (JSONObject) o;
            int partId = Integer.parseInt(player.get("participantId").toString());
            outputStatsArr[partId] = (JSONObject) player.get("stats");
        }
        return outputStatsArr;
    }
    public ArrayList<String> getPlayerKDAs(JSONObject matchInfo){
        ArrayList<String> playerKDA = new ArrayList<>();

        JSONObject[] statsArr = getPlayerStats(matchInfo);
        for (JSONObject playerStats : statsArr) {
            int kills = Integer.parseInt(playerStats.get("kills").toString());
            int deaths = Integer.parseInt(playerStats.get("deaths").toString());
            int assists = Integer.parseInt(playerStats.get("assists").toString());
            String kda = kills + "/" + deaths + "/" + assists;
            playerKDA.add(kda);
        }
        return playerKDA;
    }
}



