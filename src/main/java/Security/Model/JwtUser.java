package Security.Model;

public class JwtUser {

    private String userName;
    private Long id;
    private String role;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
