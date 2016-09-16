package sample;

import java.io.*;
import java.util.Scanner;

/**
 * Created by kerbeychevalier on 8/31/16.
 */
public class userClass extends Person //implements EventHandler<ActionEvent>
{
   private String profilePhoto;
   private String UserName;
   private String email;
   private String phoneNumber;
   private String passWord;

   public userClass()
   {
      System.out.println("userClass default constructor");
   }

   public userClass( String UserName, String email, String phoneNumber, String passWord, String profilePhoto)
   {
      this.profilePhoto=profilePhoto;
      this.UserName=UserName;
      this.email=email;
      this.phoneNumber=phoneNumber;
      this.passWord=passWord;
   }


   public String getUserName()
   {
      return UserName;
   }


   public void setUserName(String userName)
   {
      UserName = userName;
   }


   public String getEmail()
   {
      return email;
   }


   public void setEmail(String email)
   {
      this.email = email;
   }


   public String getPhoneNumber()
   {
      return phoneNumber;
   }


   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }


   public String getPassWord()
   {
      return passWord;
   }


   public void setPassWord(String passWord)
   {
      this.passWord = passWord;
   }


   public String getProfilePhoto()
   {
      return profilePhoto;
   }


   public void setProfilePhoto(String profilePhoto)
   {
      this.profilePhoto = profilePhoto;
   }

    public Boolean Compare2(String passedInpassword)
    {
        System.out.println();
        System.out.println();
        System.out.println(" Person Compare method");

        String File = "LoginInformation.txt";
        String line = "";

        Scanner scanFile = Controller.createTextRead(File);// scan a file
        for(int r=0;r<Controller.count;r++) {
            line = scanFile.nextLine();
            System.out.println("line has ====" + line);
            System.out.println(line.length());
            if(line.contains(passedInpassword))
            {
                return true;
            }
        }
        return false;
    }
    public void insert(String File)
    {
        System.out.println("now inserting info to file");
        Scanner scanFile = Controller.createTextRead(File);// scan a file
        String olderLines = "";
        olderLines += scanFile.nextLine();
        //System.out.println(" olderLines==" + olderLines);
        System.out.println();
        for (int n = 1; n < Controller.count; n++) {
            //for loop for going through multiple lines in a text file to add to a string that will get reprinted
            olderLines += "\n" + scanFile.nextLine();
            //System.out.println("loop, olderLines==" + olderLines);
            System.out.println();
        }
        String line = Controller.count+1+" "+getFirstName()+","+getLastName()+","+getDob()+","+getGender()
        +","+getUserName()+","+getPassWord()+","+getSS()+","+getPhoneNumber()+","+getProfilePhoto();

        olderLines += "\n" + line;
        Controller.count++;
        PrintWriter rewrite2 = null;
        try {
            rewrite2 = new PrintWriter("LoginInformation.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        rewrite2.print(olderLines);
        rewrite2.close();
        System.out.print("new person added to file");

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
