public class Authentication {
    private HashMap<String, String> studentCredentials;
    private HashMap<String, String> staffCredentials;

    public Authentication() {
        // Initialize the hash maps with sample credentials
        studentCredentials = new HashMap<String, String>();
        studentCredentials.put("1001234", "password1");
        studentCredentials.put("1005678", "password2");

        staffCredentials = new HashMap<String, String>();
        staffCredentials.put("supervisor1", "password1");
        staffCredentials.put("supervisor2", "password2");
        staffCredentials.put("advisor1", "password3");
        staffCredentials.put("advisor2", "password4");
    }

    public boolean isValidStudent(String studentId, String password) {
        String storedPassword = studentCredentials.get(studentId);
        return storedPassword != null && storedPassword.equals(password);
    }

    public boolean isValidStaff(String staffId, String password) {
        String storedPassword = staffCredentials.get(staffId);
        return storedPassword != null && storedPassword.equals(password);
    }
}
