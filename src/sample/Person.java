package sample;
import java.util.Scanner;

public class Person //extends Application
{
    private String firstName;
    private String gender;
    private String dob;
    private String SS;
    private String lastName;
    public Person()
    {
    }

    public Person(String firstName, String gender, String dob, String SS , String lastName)
    {
        this.firstName=firstName;
        this.gender=gender;
        this.dob=dob;
        this.SS=SS;
        this.lastName=lastName;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }


    public void setLastname(String lastName) {
        this.lastName = lastName;
    }


    public String getSS() {
        return SS;
    }


    public void setSS(String SS) {
        this.SS = SS;
    }



    public String getDob() {
        return dob;
    }


    public void setDob(String dob) {
        this.dob = dob;
    }



    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public Boolean Compare(String text, String genderBoxText, String dobBoxText, String SSNBoxText,
                           String lastNameBoxText)//throws Exception
    {
        System.out.println();
        System.out.println();
        String passedInLine = text + "," + genderBoxText + "," + dobBoxText + "," + SSNBoxText + "," + lastNameBoxText + ",";
        System.out.println(" Person Compare method");

        String File = "LoginInformation.txt";
        String line = "";

        Scanner scanFile = Controller.createTextRead(File);// scan a file
        //for(int r=0;r<Controller.count;r++) {
            line = scanFile.nextLine();
            System.out.println("line has ====" + line);
            System.out.println(line.length());


            String newLine = "";
            int Count = 0;
            for (int n = 0; n < passedInLine.length(); n++)//scan line that was passed in to count the number of commas
            {
                if (passedInLine.substring(n, n + 1).contains(",")) {
                    Count++;
                    //System.out.println(Count+" commas in the String that got passed in");
                }
            }

            int commaCount = 0;
            for (int t = 0; t < line.length(); t++)//this line counts the number of commas found in the line of the scanned file
            {
                if (line.substring(t, t + 1).contains(","))//if there's a comma count if and also add it to the new string
                {
                    newLine += line.substring(t, t + 1);
                    //System.out.println(newLine+"= newLine");
                    commaCount++;
                    //System.out.println(commaCount+" commas in the String from the file");
                } else if (!line.substring(t, t + 1).contains(",")) {//add other found characters into the string
                    newLine += line.substring(t, t + 1);
                    //System.out.println(newLine+"= newLine");
                }
                //System.out.println("newLine=="+newLine);
                if (newLine.contains(passedInLine) && Count == commaCount) {//if the strings and number of commas in each string match stop the loop and compare the two
                    t = line.length();
                    System.out.println("both strings you're comparing are equal");
                }
            }

            System.out.println("newLine==" + newLine);
            System.out.println("passedInLine==" + passedInLine);
            scanFile.close();
            System.out.println();
            System.out.println();
            if (newLine.contains(passedInLine) && Count == commaCount)
                return true;
            else
                return false;
        //}
        //return false;
    }


    public void login() {
        System.out.println("hello");
    }
}
