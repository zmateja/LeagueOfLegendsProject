import org.json.simple.JSONObject;

public class Summoner {
    public String accountId;
    public String name;

    public Summoner(JSONObject summoner_data){
        accountId = summoner_data.get("accountId").toString();
        name = summoner_data.get("name").toString();
    }
}
