import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class Main extends Application {



    public static Field[] addedArray(int length, Field fields[], Field addedField) {
        /**
         * @param length
         * @param fields[]
         * @param addedField
         * @returns The original array's contents with a new Field object added at the end.
         */
        Field newFields[] = new Field[length + 1];
        for (int i = 0; i < length; i++) {
            newFields[i] = fields[i];
        }
        newFields[length] = addedField;
        return newFields;
    }


    @Override
    public void start(Stage stage) throws Exception {
        /**
         * @param stage
         * @description Overrides the start function and creates a set of labels
         * of the class fields described in Person.java and Player.java
         */
        stage.setTitle("Sean Morgan Hw2");
        FlowPane pane = new FlowPane(Orientation.VERTICAL);
        List<Label> labels = new ArrayList<>();
        Field fields[] = Player.class.getDeclaredFields();
        Field personFields[] = Person.class.getDeclaredFields();
        for (int i = 0; i < personFields.length; i++) {
            fields = addedArray(fields.length, fields, personFields[i]);
        }

        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
            Label label = new Label(fields[i].getName());
            labels.add(label);
            pane.getChildren().add(labels.get(i));
        }

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /**
         * @param args
         * @description Launches an application and then generates 3 Player objects that could be modified to test
         * for throws and bugs ("if any bugs").
         */
        Application.launch(args);
        Player hockeyPlayer1 = new Player();
        Player hockeyPlayer2 = new Player("Sean", "Morgan", "MALE", (byte) 22, "Expert", "A team");
        Player hockeyPlayer3 = new Player("Sean", "Morgan", "A", "Mr", "II",
                "MALE", (byte) 22, 0, 0, 0, "Expert", "A team", 0, 0);
    }
}
