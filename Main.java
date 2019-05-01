package sample;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Main extends Application {

    public Group root = new Group();

    public Scene createScene() { //this will create our initial scene

        Cube target = new Cube(Color.BLUE);
        root.getChildren().add(target);

        Scene scene = new Scene(root, 1280, 720, true); //true is the depth buffer which allows it to be 3d
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(new Translate(0, -20, -20), new Rotate(-45, Rotate.X_AXIS));
        //This code above will move our camera backwards and up and also rotate along the X axis
        scene.setCamera(camera);

        return scene;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = createScene();
        stage.setScene(scene);
        stage.show();
    }

    public static class Cube extends Box { //This class will create our box

        public Cube(Color color) { //Color color allows us to change the colour of the box
            super(1, 1, 1);
            setMaterial(new PhongMaterial(color));
        }

        public void set(Point3D p) {
            setTranslateX(p.getX());
            setTranslateY(p.getY());
            setTranslateZ(p.getZ());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
