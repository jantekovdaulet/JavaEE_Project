package kz.kenzhakhimov.javaEE;

public class User {
    private Long id;
    private String email;
    private String password;
    private String city;

    public User(Long id, String email, String password, String city) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.city = city;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
