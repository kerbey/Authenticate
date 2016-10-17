package sample;
import DataStructure.LLOrderedList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;
/**
 * Created by kerbeychevalier on 9/2/16.
 */
public class Controller
{
    String line = "",message2;Scanner scanFile;String File = "LoginInformation.txt";
    static int count=0;
    TextField username, password, firstNameBox, lastNameBox, dobBox, emailBox,genderBox, confirmPasswordBox, SSNBox,
            phoneNumberBox, photoPathBox;
    Button logIn, SignUp, SignIn, addPhoto;
    Label firstNameLabel;
    String compareLine="";//string made for the username on the line
     LLOrderedList<String> list = new LLOrderedList<String>();

    public void LogIn(Stage primaryStage,String message) throws IOException {
        Countfilelines();
       // System.out.println("Controller LogIn");
        primaryStage.setTitle(message);
        username= new TextField();
        username.setPromptText("enter username");
        username.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        username.getText();
        password= new TextField();
        password.setPromptText("enter password");
        password.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        password.getText();
        confirmPasswordBox= new TextField();
        confirmPasswordBox.setPromptText("confirm password");
        confirmPasswordBox.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        confirmPasswordBox.getText();
        GridPane g= new GridPane();//space for buttons
        g.setPadding(new Insets(10,10,10,10));
        g.setHgap(5);//height for button space
        g.setVgap(5);//length for button space
        GridPane.setConstraints(username,0,1);//row by column
        GridPane.setConstraints(password,0,2);//row by column
        GridPane.setConstraints(confirmPasswordBox,0,3);//row by column

        logIn= new Button("Login");
        logIn.setOnAction(event ->
                {
                    if(password.getText().equals(confirmPasswordBox.getText())
                            && passwordcheck(password.getText())==true)
                    {//when both passwords match check on the file to see if they match the file's password
                        System.out.println("passwords match");
                         scanFile = Controller.createTextRead(File);// scan a file
                        count = scanFile.nextInt();
                        for(int n=0;n<count;n++)
                        {//for loop for going through multiple lines in a text file
                            compareLine="";//string made for the username on the line
                            line = scanFile.nextLine();
                            //System.out.println("line=="+line);
                            int commaCount=0;
                            for(int m=0;m<line.length();m++)
                            {//for loop for going through multiple characters in a text file line
                                //System.out.println("Line.substring==" + line.substring(m,m+1));
                                if(line.substring(m,m+1).contains(","))
                                {//counts the commas until getting to the fourth and stops erasing the string
                                    commaCount++;
                                    if(commaCount>5)
                                    {
                                        m=line.length();
                                    }
                                    else if (commaCount==5)
                                    {
                                        compareLine += line.substring(m, m + 1);
                                        System.out.println("compareLine==" + compareLine);
                                    }
                                    else if(commaCount!=5)
                                    {
                                        System.out.println("compareLine 5=="+compareLine);
                                        compareLine = "";
                                    }
                                }
                               else if(!line.substring(m,m+1).contains(",") && commaCount>3 && commaCount<6)
                                {//adds other characters to the string we'll be comparing
                                        compareLine += line.substring(m, m + 1);
                                        System.out.println("compareLine==" + compareLine);
                                }
                            }//this if else statement compares entered in username and password with the one from the
                            //textfile
                            if (line.contains(compareLine)) {
                                System.out.println("Line=="+line);
                                System.out.println("compareLine=="+compareLine);
                                System.out.println("username and password confirmed welcome");
                                 message2="Welcome user.";
                                try {
                                    LogIn(primaryStage, message2);//ogIn(primaryStage, message2);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                n=line.length();
                                } else if (!line.contains(compareLine)) {
                                System.out.println("Line=="+line);
                                System.out.println("compareLine=="+compareLine);
                                System.out.println("username incorrect");

                                //System.out.println("password and confirm password match but not found in file");
                                 message2="incorrect username";
                                try {
                                    LogIn(primaryStage, message2);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                    n = line.length();
                                }
                        }
                        //System.out.println(line);
                        scanFile.close();
                    }
                    //else
                    else if(!password.getText().equals(confirmPasswordBox.getText())
                            && !passwordcheck(password.getText())==true)
                    {
//                        System.out.println("Line=="+line);
//                        System.out.println("compareLine=="+compareLine);
                        System.out.println("password and confirm password don't match");
                        message2="incorrect password";
                        try {
                            LogIn(primaryStage, message2);//ogIn(primaryStage, message2);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        GridPane.setConstraints(logIn,0,6);//row,column
        StackPane layout= new StackPane();
        g.getChildren().addAll(username,password, confirmPasswordBox,logIn);
        layout.getChildren().add(g);
        Scene scene = new Scene(layout, 400, 200);//width by height of window
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void Countfilelines() throws IOException
    {
        //System.out.println("Countfilelines");
        LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(File)));
        lnr.skip(Long.MAX_VALUE);
        System.out.println(lnr.getLineNumber()+1); //Add 1 because line index starts at 0
// Finally, the LineNumberReader object should be closed to prevent resource leak
        lnr.close();
        count=lnr.getLineNumber()+1;
        //System.out.println("count=="+count);
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
                    //System.out.println("password has 1 capital letter");
                    v=letters.length();
                }
            }
            for(int v=0;v<numbers.length();v++)//for loop to go through numbers
            {
                if(numbers.substring(v,v+1).contains(text.substring(n,n+1)))
                {
                    compare2=true;
                    //System.out.println("password has 1 number");
                    v=numbers.length();
                }
            }
            for(int v=0;v<characters.length();v++)//for loop to go through special characters
            {
                if(characters.substring(v,v+1).contains(text.substring(n,n+1)))
                {
                    compare3=true;
                    //System.out.println("password has 1 special character");
                    v=characters.length();
                }
            }
        }
        if(compare1==true&&compare2==true&&compare3==true) {
            return true;//if your password has all of the required characters
        }
        else if(compare1==false) {
            message2 = "password is missing capital letters";
            return false;
        }
        else if(compare2==false) {
            message2 = "password is missing a number";
            return false;
        }
        else if(compare3==false) {
            message2 = "password is missing one of these special characters "+characters;
            return false;
        }
        else if(compare3==false &&compare1==false) {
            message2 = "password is missing capital letters & special character("+characters+")";
            return false;
        }
        else if(compare3==false &&compare2==false) {
            message2 = "password is missing number and special character("+characters+")";
            return false;
        }
        else if(compare1==false &&compare2==false) {
            message2 = "password is missing capital letter & number";
            return false;
        }
        else message2="password missing number,capital letter,special character("+characters+")";
            return false;//if your password has none of the required characters
    }

    public void SignUp(Stage primaryStage, String message) throws Exception
    {
        Countfilelines();
        //System.out.println("Controller Class sign up method.");

        primaryStage.setTitle(message);
        firstNameBox= new TextField();
        firstNameBox.setPromptText("enter firstname");
        firstNameBox.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        firstNameBox.getText();
        lastNameBox= new TextField();
        lastNameBox.setPromptText("enter lastname");
        lastNameBox.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        lastNameBox.getText();
        dobBox= new TextField();
        dobBox.setPromptText("enter date of birth");
        dobBox.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        dobBox.getText();
        genderBox= new TextField();
        genderBox.setPromptText("enter gender");
        genderBox.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        genderBox.getText();
        username= new TextField();
        username.setPromptText("enter username");
        username.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        username.getText();
        password= new TextField();
        password.setPromptText("password (include at least 1 number, 1 upper case letter, 1 lower case letter"+
                ", 1 special character)");
        password.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        password.getText();
        confirmPasswordBox= new TextField();
        confirmPasswordBox.setPromptText("confirm password");
        confirmPasswordBox.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        confirmPasswordBox.getText();
        emailBox= new TextField();
        emailBox.setPromptText("enter email");
        emailBox.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        emailBox.getText();
        SSNBox= new TextField();
        SSNBox.setPromptText("enter social security number");
        SSNBox.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        SSNBox.getText();
        phoneNumberBox=new TextField();
        phoneNumberBox.setPromptText("enter phonenumber");
        phoneNumberBox.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
        phoneNumberBox.getText();
        photoPathBox=new TextField();
        GridPane g= new GridPane();//space for buttons
        g.setPadding(new Insets(10,10,10,10));
        g.setHgap(8);//height for button space
        g.setVgap(18);//length for button space
        GridPane.setConstraints(firstNameBox,2,0);//row by column
        GridPane.setConstraints(lastNameBox,2,1);//row by column
        GridPane.setConstraints(dobBox,2,2);//row by column
        GridPane.setConstraints(genderBox,2,3);//row by column
        GridPane.setConstraints(username,2,4);//row by column
        GridPane.setConstraints(password,2,5);//row by column
        GridPane.setConstraints(confirmPasswordBox,2,6);//row by column
        GridPane.setConstraints(emailBox,2,7);//row by column
        GridPane.setConstraints(SSNBox,2,8);//row by column
        GridPane.setConstraints(phoneNumberBox,2,9);//

        addPhoto= new Button("Browse");
        addPhoto.setOnAction(event ->
        {
            FileChooser fileChooser = new FileChooser();
            Stage newprimaryStage= (Stage) (((Node) event.getSource()).getScene().getWindow());
            //^gets window for user to choose pictures
            File file= fileChooser.showOpenDialog(primaryStage);//user is able to choose a photo because of this


            photoPathBox.setText(file.getPath());
            //^path to photo stored in string to add to text file
            photoPathBox.setPrefColumnCount(10);//amount of characters that are shown in textbox at once
            photoPathBox.getText();
        });
        GridPane.setConstraints(addPhoto,2,11);//row, column

        SignIn= new Button("Create Account");
        SignIn.setOnAction(event ->
        {

            genderBox.setText(genderBox.getText().toLowerCase());//lower case for gender
            userClass u= new userClass(username.getText(), emailBox.getText(), phoneNumberBox.getText(),
                    password.getText(), photoPathBox.getText(), firstNameBox.getText(),genderBox.getText()
                    ,dobBox.getText(),SSNBox.getText(), lastNameBox.getText());

            if(u.Compare2(username.getText()) == true&&username.getText().isEmpty()==false)
            {
                System.out.println("username already used");
                 message2="username already used";
                try {
                    username.setText("");
                    SignUp(primaryStage,message2);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(SSNBox.getText().length()!=9 || !SSNBox.getText().matches(".*\\d.*"))
            {
                System.out.println("must have 9 digits in social security number");
                 message2="must have 9 digits in social security number";
                try {
                    SSNBox.setText("");
                    SignUp(primaryStage,message2);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(phoneNumberBox.getText().length()!=9 || !phoneNumberBox.getText().matches(".*\\d.*"))
            {
                phoneNumberBox.setText("");
                System.out.println("must have 9 digits in phone number");
                 message2="must have 9 digits in phone number";
                try {
                    SignUp(primaryStage,message2);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(!genderBox.getText().contains("male") &&!genderBox.getText().contains("female"))
            {
                genderBox.setText("");
                System.out.println("gender incorrect");
                 message2="please enter male or female";
                try {
                    SignUp(primaryStage,message2);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(emailBox.getText().equals(""))
            {
                System.out.println("no email has been entered");
                message2 = "no email has been entered";
                try {
                    emailBox.setText("");
                    SignUp(primaryStage, message2);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(!emailBox.getText().contains("@") && (!emailBox.getText().contains(".com")
            || !emailBox.getText().contains(".net") || !emailBox.getText().contains(".org")))
            {//email must have these charcters
                    System.out.println("email needs @ and .net,.com,or .org");
                 message2="email needs @ and .net,.com,or .org";
                try {
                    emailBox.setText("");
                    SignUp(primaryStage,message2);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(photoPathBox.getText().isEmpty()==true)
            {//this if statement doesnt work
                System.out.println("please add photo");
                 message2="please add photo";
                try {
                    emailBox.setText("");
                    SignUp(primaryStage,message2);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (username.getText().isEmpty()==true||emailBox.getText().isEmpty()==true||
                    phoneNumberBox.getText().isEmpty()==true ||phoneNumberBox.getText().isEmpty()==true
                    ||photoPathBox.getText().isEmpty()==true ||firstNameBox.getText().isEmpty()==true
                    ||lastNameBox.getText().isEmpty()==true|| genderBox.getText().isEmpty()==true
                    ||dobBox.getText().isEmpty()==true ||SSNBox.getText().isEmpty()==true ||
                    lastNameBox.getText().isEmpty()==true)
            {
                System.out.println("not all information is entered");
                message2="not all information is entered";
                try {
                    SignUp(primaryStage,message2);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Boolean passwordCheck= passwordcheck(password.getText());//password check method stored in passwordCheck
            if(password.getText().equals(confirmPasswordBox.getText())
                && passwordCheck==true)//continue if password and confirm password are matching
            {//and are in the correct format
                Boolean answer= u.Compare2(password.getText());
                System.out.println("Boolean answer2 is "+answer);
                if (answer.equals(true))// && answer2.equals(true)) || (answer.equals(false) && answer2.equals(true)))
                {//if signup username and username on list are same/marked true then dont write to file//and enter
                 //a different one
                    System.out.println("incorrect");
                     message2="info already exists try again";
                    try {
                        password.setText("");
                        confirmPasswordBox.setText("");
                        SignUp(primaryStage,message2);
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {//if not found or everything is marked false then data can be written to file
                    u.insert(File);
                    message2="new person added to file";
                    try {
                        list.add(username.getText());
                        System.out.println("USERNAME LIST== "+list.toString());

                        SignUp(primaryStage,message2);
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //System.out.println("done.");
            }
            if(!(password.getText().equals(confirmPasswordBox.getText()))
                    || passwordCheck.equals(false))//|| passwordcheck(password.getText())==false)
            {//if password isnt confirmed or doesnt have required characters its invalid
                //System.out.println("password and confirm password dont match");
                try {
                    password.setText("");
                    confirmPasswordBox.setText("");
                    SignUp(primaryStage,message2);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //System.out.println("now done and added.");
        GridPane.setConstraints(SignIn,2,10);//row, column
        GridPane.setConstraints(photoPathBox,2,12);//row,column
        g.getChildren().addAll( firstNameBox, lastNameBox, dobBox
        ,genderBox,username,password,confirmPasswordBox,SignIn, addPhoto, phoneNumberBox,photoPathBox, emailBox, SSNBox);
        StackPane layout= new StackPane();
        layout.getChildren().add(g);
        Scene scene= new Scene(layout, 300, 570);//width by height of window
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
}
