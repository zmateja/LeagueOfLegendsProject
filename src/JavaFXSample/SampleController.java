package JavaFXSample;

import MainPackage.APIQueries;
import MainPackage.Summoner;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class SampleController {
    public Label helloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {
        Summoner mySum = APIQueries.getSummonerByName("Copperbones");
        helloWorld.setText(mySum.accountId);
    }
}
