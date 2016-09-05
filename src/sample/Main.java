package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Main extends Application implements EventHandler<ActionEvent>
{
    Button logIn, SignUp;
    TextField username, password;
    //Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
//     userClass u = new userClass();
//        u.SignUp(primaryStage);
        System.out.println("start");

        primaryStage.setTitle("Start window");
        //Label t= new Label();//space for text box
        //t.setMaxHeight(5);
        //t.setMaxWidth(5);
        //t.setAlignment(Pos.TOP_CENTER);
        username= new TextField();
        password= new TextField();
        username.setText("userName");
        password.setText("password");

        GridPane g= new GridPane();//space for buttons
        g.setPadding(new Insets(10,10,10,10));
        g.setHgap(8);//height for button space
        g.setVgap(12);//length for button space
        GridPane.setConstraints(username,2,0);//row by column
        GridPane.setConstraints(password,2,1);//row by column
        logIn= new Button("Login");
        logIn.setOnAction(event ->
                {
                    Controller u =new Controller();
                    try {
                        u.LogIn(primaryStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        GridPane.setConstraints(logIn,2,8);//row,column
        StackPane layout= new StackPane();


        //layout.getChildren().add(logIn);
        SignUp= new Button("Sign up");
        SignUp.setOnAction(event ->
        {
            Controller u = new Controller();
            try {
                u.SignUp(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        GridPane.setConstraints(SignUp,3,8);//row,column
        //g.add(logIn,9,9);//row,column
        //g.add(SignUp,10,9);
        //layout.getChildren().add(g);
        //g.getChildren().addAll(username, password,logIn,SignUp);
        g.getChildren().addAll(/*username, password,*/logIn,SignUp);
        layout.getChildren().add(g);
        Scene scene= new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void handle(ActionEvent event)
    {
        if (event.getSource()==logIn)
        {
        }
        else if (event.getSource() == SignUp)
        {
        }
    }

    public static void main(String[] args)
    {
        System.out.println("main");
        launch(args);
    }
}
