// Mattania Mckoy
package model;
import java.io.Serializable;
import java.util.Objects;

public  abstract class User implements Serializable {
    private String id;
    private String password;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String id, String password, String firstName, String lastName) {
        this.id = id;
        this.password = PasswordEncoder.hashPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public boolean checkPassword(String plainText) {
        return Objects.equals(PasswordEncoder.hashPassword(plainText), this.password);
    }

   //test
//    public static void main(String[] args){
//        User user = new User("12345", "exam", "Mattania", "Mckoy");
//
//
//        System.out.println(user.toString());
//
//        System.out.println(user.checkPassword("exam"));
//
//    }

}
