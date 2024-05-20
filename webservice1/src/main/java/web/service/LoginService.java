package web.service;

public class LoginService {
    public boolean login(String username, String password, String dob) {
        // Business logic for login
        return "validUser".equals(username) && "validPass".equals(password) && "2000-01-01".equals(dob);
    }
}
