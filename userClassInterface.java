package Interface;

import javafx.event.ActionEvent;

/**
 * Created by kerbeychevalier on 9/5/16.
 */
public interface userClassInterface //extends PersonUserInterface
{
    String getUserName();

    void setUserName(String userName);

    String getEmail();

    void setEmail(String email);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getPassWord();

    void setPassWord(String passWord);

    String getProfilePhoto();

    void setProfilePhoto(String profilePhoto);

    Boolean Compare2(String text, String text1, String text2, String text3);
    String getGender();

    void setGender(String gender);

    String getLastName();

    void setLastname(String lastName);

    String getSS();

    void setSS(String SS);

    String getDob();

    void setDob(String dob);

    String getFirstName();

    void setFirstName(String firstName);

    Boolean Compare(String text, String genderBoxText, String dobBoxText, String SSNBoxText,
                    String lastNameBoxText)//throws Exception
    ;

    void login(ActionEvent actionEvent);
}
