package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

/**
 * Created by kerbeychevalier on 9/2/16.
 */
public class Controller implements  EventHandler<ActionEvent>//implements EventHandler<ActionEvent>
{
   // String line = "";
   String File = "LoginInformation.txt";
    TextField username, password, firstNameBox, lastNameBox, dobBox
            , emailBox,genderBox, confirmPasswordBox, SSNBox, phoneNumberBox;
    Button logIn, SignUp, SignIn, addPhoto;
    Label userNameLabel, passwordLabel, confirmLabel, dobLabel, emailLabel, genderLabel,firstNameLabel,
            lastNameLabel,SSNLabel,phoneNumberLabel;

    public void LogIn(Stage primaryStage)
    {
        System.out.println("Controller LogIn");
        primaryStage.setTitle("Log In");

        userNameLabel= new Label("userName");
        passwordLabel= new Label("password(include at least 1 number, 1 upper case letter, 1 lower case letter" +
                ", 1 special character) ");
        confirmLabel= new Label("confirm password");
        username= new TextField();
        password= new TextField();

        confirmPasswordBox= new TextField();

        GridPane g= new GridPane();//space for buttons
        g.setPadding(new Insets(10,10,10,10));
        g.setHgap(8);//height for button space
        g.setVgap(18);//length for button space

        GridPane.setConstraints(username,0,1);//row by column
        GridPane.setConstraints(userNameLabel,0,0);//row by column
        GridPane.setConstraints(password,0,3);//row by column
        GridPane.setConstraints(passwordLabel,0,2);//row by column
        GridPane.setConstraints(confirmPasswordBox,0,5);//row by column
        GridPane.setConstraints(confirmLabel,0,4);//row by column

        logIn= new Button("Login");
        logIn.setOnAction(event ->
                {
                    if(password.getText().equals(confirmPasswordBox.getText())
                            && passwordcheck(password.getText())==true)
                    {
                        Scanner scanFile = Controller.createTextRead(File);// scan a file
                        //count = scanFile.nextInt();
                        String line = scanFile.nextLine();
                        for(int n=0;n<line.length();n++)
                        {
                            if(line.substring(n,n+1).contains(password.getText()))
                            {
                                //System.out.println("password confirmed welcome");
                                welcome(primaryStage);

                            }
                            else if(!line.substring(n,n+1).contains(password.getText()))
                            {
                               //System.out.println("password and confirm password match but not found in file");
                                incorrectLogin(primaryStage);
                                n=line.length();
                            }

                        }
                        System.out.println(line);
                        scanFile.close();
                    }
                    else
                    {
                        System.out.println("password and confirm password don't match");
                        incorrectLogin(primaryStage);
                    }
                }
        );
        GridPane.setConstraints(logIn,0,6);//row,column
        StackPane layout= new StackPane();
        g.getChildren().addAll(username,userNameLabel, password,passwordLabel,confirmPasswordBox,confirmLabel, logIn);
        layout.getChildren().add(g);
        Scene scene= new Scene(layout, 500, 300);//width by height of window
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void welcome(Stage primaryStage)
    {
        primaryStage.setTitle("Welcome");
        firstNameLabel = new Label("Login sucessful");
        SignIn= new Button("OK");
        GridPane grid = new GridPane();//space for buttons
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(8);//height for button space
        grid.setVgap(18);//length for button space

        GridPane.setConstraints(firstNameLabel, 0, 0);//row by column
        SignIn.setOnAction(e->
                {
                    System.exit(0);
                }
        );
        GridPane.setConstraints(SignIn, 0, 2);//row by column

        grid.getChildren().addAll(firstNameLabel,SignIn);
        StackPane layout= new StackPane();
        layout.getChildren().add(grid);
        Scene scene= new Scene(layout, 300, 100);//width by height of window
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Boolean passwordcheck(String text)
    {
        String letters="QWERTYUIOPASDFGHJKLZXCVBNM";
        String numbers="1234567890";
        String characters="~`!@#$%^&*";
        Boolean compare1= false, compare2=false, compare3=false;
        for(int n=0;n<text.length();n++)//for loop to go through password
        {
            for(int v=0;v<letters.length();v++)//for loop to go through letters
            {
                if(letters.substring(v,v+1).contains(text.substring(n,n+1)))
                {
                    compare1=true;
                    System.out.println("password has 1 capital letter");
                    v=letters.length();
                }
            }
            for(int v=0;v<numbers.length();v++)//for loop to go through numbers
            {
                if(numbers.substring(v,v+1).contains(text.substring(n,n+1)))
                {
                    compare2=true;
                    System.out.println("password has 1 number");
                    v=numbers.length();
                }
            }
            for(int v=0;v<characters.length();v++)//for loop to go through special characters
            {
                if(characters.substring(v,v+1).contains(text.substring(n,n+1)))
                {
                    compare3=true;
                    System.out.println("password has 1 special character");
                    v=characters.length();
                }
            }

        }
        if(compare1==true&&compare2==true&&compare3==true)
            return true;//if your password has all of the required characters
        else
            return false;//if your password has none of the required characters
    }

    public void SignUp(Stage primaryStage) throws Exception
    {
        System.out.println("Controller Class sign up method.");

        primaryStage.setTitle("Sign Up");
        firstNameBox= new TextField();
        firstNameLabel= new Label("firstName");
        lastNameBox= new TextField();
        lastNameLabel= new Label("lastName");
        dobBox= new TextField();
        dobLabel= new Label("date of birth");
        genderBox= new TextField();
        genderLabel= new Label("gender");
        username= new TextField();
        userNameLabel= new Label("userName");
        password= new TextField();
        passwordLabel= new Label("password (include at least 1 number, 1 upper case letter, 1 lower case letter" +
                ", 1 special character)");
        confirmPasswordBox= new TextField();
        confirmLabel= new Label("confirm password");
        GridPane g= new GridPane();//space for buttons
        g.setPadding(new Insets(10,10,10,10));
        g.setHgap(8);//height for button space
        g.setVgap(18);//length for button space
        GridPane.setConstraints(firstNameLabel,2,0);//row by column
        GridPane.setConstraints(firstNameBox,2,1);//row by column
        GridPane.setConstraints(lastNameLabel,2,2);//row by column
        GridPane.setConstraints(lastNameBox,2,3);//row by column
        GridPane.setConstraints(dobLabel,2,4);//row by column
        GridPane.setConstraints(dobBox,2,5);//row by column
        GridPane.setConstraints(genderLabel,2,6);//row by column
        GridPane.setConstraints(genderBox,2,7);//row by column
        GridPane.setConstraints(userNameLabel,2,8);//row by column
        GridPane.setConstraints(username,2,9);//row by column
        GridPane.setConstraints(passwordLabel,2,10);//row by column
        GridPane.setConstraints(password,2,11);//row by column
        GridPane.setConstraints(confirmLabel,2,12);//row by column
        GridPane.setConstraints(confirmPasswordBox,2,13);//row by column
        StackPane layout= new StackPane();
        SignIn= new Button("Next");
        SignIn.setOnAction(event ->
                {
                    if(password.getText().contains(confirmPasswordBox.getText())
                            && passwordcheck(password.getText())==true)//continue if password and confirm password are
                    {//true and have required characters
                        try {

                            SignUp2(primaryStage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        System.out.println("password's don't match");
                        try {
                            SignUp(primaryStage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        GridPane.setConstraints(SignIn,2,14);//row,column

        g.getChildren().addAll(firstNameLabel, firstNameBox,lastNameLabel, lastNameBox,dobLabel, dobBox,genderLabel
        ,genderBox,userNameLabel,username,passwordLabel,password,confirmLabel,confirmPasswordBox,SignIn);
        layout.getChildren().add(g);
        Scene scene= new Scene(layout, 700, 690);//width by height of window
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void SignUp2(Stage primaryStage) throws Exception
    {
        System.out.println("Signup2");
        primaryStage.setTitle("Sign Up part 2");
        emailBox= new TextField();
        emailLabel= new Label("email");
        SSNBox= new TextField();
        SSNLabel= new Label("Social Security Number");
        phoneNumberBox=new TextField();
        phoneNumberLabel= new Label("phone number (country code + area code + phone number)");
        GridPane g= new GridPane();//space for buttons
        g.setPadding(new Insets(10,10,10,10));
        g.setHgap(8);//height for button space
        g.setVgap(18);//length for button space
        GridPane.setConstraints(emailLabel,2,0);//row by column
        GridPane.setConstraints(emailBox,2,1);//row by column
        GridPane.setConstraints(SSNLabel,2,3);//row by column
        GridPane.setConstraints(SSNBox,2,4);//row by column
        GridPane.setConstraints(phoneNumberLabel,2,5);//row by column
        GridPane.setConstraints(phoneNumberBox,2,6);//
        SignIn= new Button("Create Account");
        SignIn.setOnAction(event ->
        {//go to person class to see if first and last name gender date of birth and social security number
            Person p = new Person(firstNameBox.getText(),genderBox.getText(),dobBox.getText(),SSNBox.getText(),
                    lastNameBox.getText());
           Boolean answer= p.Compare(firstNameBox.getText(),genderBox.getText(),dobBox.getText(),SSNBox.getText(),
                    lastNameBox.getText());
            System.out.println("Boolean answer is "+answer);
            //go to asnwer class to see if username email phonenumber and password match and to see if usernames
            //match with any others
            userClass u= new userClass(username.getText(), emailBox.getText(), phoneNumberBox.getText(),
                    password.getText());
           Boolean answer2= u.Compare2(username.getText(), emailBox.getText(), phoneNumberBox.getText()
                    , password.getText());
            System.out.println("Boolean answer2 is "+answer2);

            if((answer.equals(true)&& answer2.equals(true)) || (answer.equals(false)&&answer2.equals(true)))
            {//if signup username and username on list are same then dont write to file//and enter a different one
                primaryStage.setTitle("Incorrect");
                firstNameLabel = new Label("choose a new username");
                SignIn= new Button("OK");
                GridPane grid = new GridPane();//space for buttons
                grid.setPadding(new Insets(10, 10, 10, 10));
                grid.setHgap(8);//height for button space
                grid.setVgap(18);//length for button space

                GridPane.setConstraints(firstNameLabel, 0, 0);//row by column
                SignIn.setOnAction(e->
                        {
                            try
                            {
                                SignUp(primaryStage);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                );
                GridPane.setConstraints(SignIn, 0, 2);//row by column

                grid.getChildren().addAll(firstNameLabel,SignIn);
                StackPane layout= new StackPane();
                layout.getChildren().add(grid);
                Scene scene= new Scene(layout, 300, 100);//width by height of window
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            else
            {
                System.out.println("move this to text file");
                 String line;
                Scanner scan = new Scanner(System.in);

                PrintWriter textStream = Controller.createTextWrite(File);
                System.out.println("Enter 4 lines of text:");
                //l
                line =firstNameBox.getText() + "," + lastNameBox.getText() + "," + dobBox.getText() +
                        "," + genderBox.getText()+ "," + username.getText() + "," + password.getText() + "," +
                        emailBox.getText() + "," + SSNBox.getText()+","+emailBox.getText()+","+SSNBox.getText()
                +","+phoneNumberBox.getText()+",";
                textStream.println(line);

                textStream.close(); // did not require error handling
                System.out.println("Those lines were written to " + File);
                System.out.println();
                System.out.print("Now we will read them from " + File + " using the ");
                System.out.println("Scanner class.");

                Scanner scanFile = Controller.createTextRead(File);// scan a file
                //count = scanFile.nextInt();
                line = scanFile.nextLine();
                System.out.println(line);
                scanFile.close();
                accountCreated(primaryStage);
            }
        });
        GridPane.setConstraints(SignIn,2,7);//row,column

        addPhoto= new Button("Add Photo");
        addPhoto.setOnAction(event ->
        {
            System.out.println("Adding pictures to file");
            //ImageIcon applePicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("apple.jpg"))
            //.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
        });
        GridPane.setConstraints(addPhoto,3,7);//row,column
        g.getChildren().addAll(emailLabel, emailBox,SSNBox, SSNLabel,SignIn, addPhoto,
        phoneNumberBox, phoneNumberLabel);
        StackPane layout= new StackPane();
        layout.getChildren().add(g);
        Scene scene= new Scene(layout, 500, 350);//width by height of window
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void accountCreated(Stage primaryStage)
    {
        System.out.println("account Created method");
        primaryStage.setTitle("Account Created");
        firstNameLabel = new Label("Account now on list");
        SignIn= new Button("OK");
        GridPane grid = new GridPane();//space for buttons
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(8);//height for button space
        grid.setVgap(18);//length for button space

        GridPane.setConstraints(firstNameLabel, 0, 0);//row by column
        SignIn.setOnAction(e->
                {
                    System.exit(0);
                }
        );
        GridPane.setConstraints(SignIn, 0, 2);//row by column

        grid.getChildren().addAll(firstNameLabel,SignIn);
        StackPane layout= new StackPane();
        layout.getChildren().add(grid);
        Scene scene= new Scene(layout, 300, 100);//width by height of window
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static PrintWriter createTextWrite(String S)
    {
        PrintWriter TStream=null;
        try
        {
            System.out.println("createTextWrite sucessful");
            TStream= new PrintWriter(new FileOutputStream(S));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error opening the file in createTextWrite "+S.toString());
           System.exit(0);
        }
        return TStream;
    }
    public static Scanner createTextRead(String S)
    {
        Scanner textFile=null;
        try
        {
            System.out.println("createTextRead sucessful");
            textFile=new Scanner(new FileInputStream(new File(S)));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found "+S.toString());
            System.out.println("or could not be opened."+S.toString());
        }
        return textFile;
    }
    public void incorrectLogin(Stage primaryStage)
    {
            primaryStage.setTitle("Incorrect");
            firstNameLabel = new Label("password invalid. Please retry.");
            SignIn= new Button("OK");
            GridPane grid = new GridPane();//space for buttons
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setHgap(8);//height for button space
            grid.setVgap(18);//length for button space
            GridPane.setConstraints(firstNameLabel, 0, 0);//row by column
            SignIn.setOnAction(e->
                    {
                        try
                        {
                            LogIn(primaryStage);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
            );
            GridPane.setConstraints(SignIn, 0, 2);//row by column
            grid.getChildren().addAll(firstNameLabel,SignIn);
            StackPane layout= new StackPane();
            layout.getChildren().add(grid);
            Scene scene= new Scene(layout, 300, 100);//width by height of window
            primaryStage.setScene(scene);
            primaryStage.show();
    }
    @Override
    public void handle(ActionEvent event) {}
}