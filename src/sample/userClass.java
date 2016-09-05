package sample;

import java.util.Scanner;

/**
 * Created by kerbeychevalier on 8/31/16.
 */
public class userClass extends Person implements userClassInterface// implements EventHandler<ActionEvent>
{
   private String profilePhoto;
    //protected Stage primaryStage;
   private String UserName;
   private String email;
   private String phoneNumber;/* (country code + area code + phone number)*/
   private String passWord;

//   TextField username, password, firstNameBox, lastNameBox, dobBox
//           , genderBox, usernameBox, passwordBox, confirmPasswordBox;
//   Button logIn, SignUp, SignIn;

   public userClass()
   {
      System.out.println("userClass default constructor");
   }

   public userClass(/*String profilePhoto,*/ String UserName, String email, String phoneNumber, String passWord)
   {
      this.profilePhoto=profilePhoto;
      this.UserName=UserName;
      this.email=email;
      this.phoneNumber=phoneNumber;
      this.passWord=passWord;
   }

   @Override
   public String getUserName()
   {
      return UserName;
   }

   @Override
   public void setUserName(String userName)
   {
      UserName = userName;
   }

   @Override
   public String getEmail()
   {
      return email;
   }

   @Override
   public void setEmail(String email)
   {
      this.email = email;
   }

   @Override
   public String getPhoneNumber()
   {
      return phoneNumber;
   }

   @Override
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

   @Override
   public String getPassWord()
   {
      return passWord;
   }

   @Override
   public void setPassWord(String passWord)
   {
      this.passWord = passWord;
   }

   @Override
   public String getProfilePhoto()
   {
      return profilePhoto;
   }

   @Override
   public void setProfilePhoto(String profilePhoto)
   {
      this.profilePhoto = profilePhoto;
   }

    @Override
    public Boolean Compare2(String text, String text1, String text2, String text3)
    {
        System.out.println();
        System.out.println();
            String passedInLine= text+","+text1+","+text2+","+text3;
            System.out.println(" userClass Compare2");

            String File = "LoginInformation.txt";
            String line = "";

            Scanner scanFile = Controller.createTextRead(File);// scan a file
            line = scanFile.nextLine();
            System.out.println("line has ===="+line);
            System.out.println(line.length());


            String newLine="";
            int Count=0;
            for(int n=0;n<passedInLine.length();n++)//scan line that was passed in to count the number of commas
            {
                if(passedInLine.substring(n,n+1).contains(","))
                {
                    Count++;
                    System.out.println(Count+" commas in the String that got passed in");
                }
            }

            int commaCount=0;
            for(int t=0;t<line.length();t++)//this line counts the number of commas found in the line of the scanned file
            {
                if(line.substring(t,t+1).contains(","))//if there's a comma count if and also add it to the new string
                {
                    newLine+=line.substring(t,t+1);
                    System.out.println(newLine+"= newLine");
                    commaCount++;
                    System.out.println(commaCount+" commas in the String from the file");
                }
                else if(!line.substring(t,t+1).contains(","))
                {//add other found characters into the string
                    newLine+=line.substring(t,t+1);
                    System.out.println(newLine+"= newLine");
                }
                System.out.println("newLine=="+newLine);
                if(newLine.equals(passedInLine)&&Count==commaCount)
                {//if the strings and number of commas in each string match stop the loop and compare the two
                    t=line.length();
                    System.out.println("both strings you're comparing are equal");
                }
            }
            scanFile.close();
        System.out.println();
        System.out.println();
            if(newLine.equals(passedInLine)&&Count==commaCount)
                return true;//if it returns true then the signup information matches a line in the text file
            else
                return false;
    }
}