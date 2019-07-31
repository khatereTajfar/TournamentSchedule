package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
//        Pane root = new Pane();
//        Rectangle rectangle = new Rectangle(10, 10, 50, 50);
//        rectangle.setStroke(Color.BLACK);
//        rectangle.setFill(Color.AQUA);
//        rectangle.setStrokeWidth(5);
//        primaryStage.show();
//        root.getChildren().add(rectangle);
//        primaryStage.setTitle("Hi");
//        primaryStage.setScene(new Scene(root, 100, 100));
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.setOnCloseRequest(event -> System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO \n Why Closed Me!?"));
    }


    public static void main(String[] args) {
//        launch(args);
        Schedule mySchedule = new Schedule();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of teams:\n");
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println("Number of teams can't be one!try another number:");
            n = scanner.nextInt();
        }

        float m = (float) (Math.log(n) / Math.log(2));

        System.out.println("now m is equal to " + m);
        m = (float) Math.ceil(m);
        System.out.println("now m is equal to " + m);

        if (n == (int) Math.pow(2, m))
            mySchedule.isPowerOfTwo = true;
        else
            mySchedule.m = n;

        n = (int) Math.pow(2, m);
        System.out.println("new n is equal to " + n + "\n---------------------------------------------------------");

        mySchedule.schedule(n);
        mySchedule.printArray(n);

    }
}
