package sample;
public class Person //extends Application
{
    private String firstName;
    private String gender;
    private String dob;
    private String SS;
    private String lastName;
//    public Person()
//    {
//    }
//    public Person(String firstName, String gender, String dob, String SS , String lastName)
//    {
//        this.firstName=firstName;
//        this.gender=gender;
//        this.dob=dob;
//        this.SS=SS;
//        this.lastName=lastName;
//    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {this.gender = gender;}

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
}
