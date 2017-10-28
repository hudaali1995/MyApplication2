package hudaali.myapplication;



public class User {
    private int _id;
    private String name;
    private String email;
    private String password;
    private String confirmpass;


    public User( String name, String email, String password, String confirmpass) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmpass = confirmpass;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }


}
