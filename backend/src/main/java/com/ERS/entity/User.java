



public class User {
    
    @Column(name = "userId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;    

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String role;

    public User() {
    }

    public User(int userId, String firstName, String lastName, String username, String password, String role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns a string representation of the User object.
     * The string includes the userId, firstName, lastName, username, password, and role fields.
     *
     * @return a string representation of the User object
     */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId + '\\' +
                "firstName=" + firstName + '\\' +
                "lastName=" + lastName + '\\' +
                "username=" + username + '\\' +
                "password=" + password + '\\' +
                "role=" + role + '\\' +
                '}';
    }
}
