package model;

public class Student extends User{
    private String email;

    public Student(String id, String password, String firstName, String lastName, String email) {
        super(id, password, firstName, lastName);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
