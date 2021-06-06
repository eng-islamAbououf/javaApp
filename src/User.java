import java.util.ArrayList;

public class User {

    protected String name ;
    protected String email  ;
    protected String password ;
    protected String location  ;
    protected String type ;
    protected String gander ;
    protected int userID ;
    protected ArrayList<Bookings> myBookings = new ArrayList<>();
    protected EWallet myMoney = new EWallet();
    protected MyPlaygrounds myPlaygrounds = new MyPlaygrounds();


    /**
     * default constructor
     */
    public User() {}

    /**
     * parameterized constructor
     *
     * @param name user's name
     * @param email user's email
     * @param password user's password
     * @param location user's location
     * @param type user's type
     * @param gander user's gander
     */
    public User(String name, String email, String password, String location, String type, String gander) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.location = location;
        this.type = type;
        this.gander = gander;
    }


    /**
     * get myPlaygrounds
     *
     * @return  my Playgrounds
     */
    public MyPlaygrounds getMyPlaygrounds() {
        return myPlaygrounds;
    }

    /**
     * set myPlaygrounds with new myPlaygrounds
     *
     * @param myPlaygrounds new user's Playgrounds
     */
    public void setMyPlaygrounds(MyPlaygrounds myPlaygrounds) {
        this.myPlaygrounds = myPlaygrounds;
    }

    /**
     * get myMoney
     *
     * @return current Money
     */
    public EWallet getMyMoney() {
        return myMoney;
    }

    /**
     * set myMoney with new myMoney
     *
     * @param myMoney new user's Money
     */
    public void setMyMoney(EWallet myMoney) {
        this.myMoney = myMoney;
    }

    /**
     * get myBookings
     *
     * @return  myBookings
     */
    public ArrayList<Bookings> getMyBookings() {
        return myBookings;
    }

    /**
     * set myBookings with new list of myBookings
     *
     * @param myBookings new user's Bookings
     */
    public void setMyBookings(ArrayList<Bookings> myBookings) {
        this.myBookings = myBookings;
    }

    /**
     * get userID
     *
     * @return current user ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * set userID with new userID
     *
     * @param userID new user's userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }


    /**
     * get name
     *
     * @return current name
     */
    public String getName() {
        return name;
    }

    /**
     * set name with new name
     *
     * @param name new user's name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * get email
     *
     * @return current email
     */
    public String getEmail() {
        return email;
    }

    /**
     * set email with new email
     *
     * @param email new user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get password
     *
     * @return current password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set password with new password
     *
     * @param password new user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * get location
     *
     * @return current location
     */
    public String getLocation() {
        return location;
    }

    /**
     * set location with new location
     *
     * @param location new user's location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * get type
     *
     * @return current type
     */
    public String getType() {
        return type;
    }

    /**
     * set type with new type
     *
     * @param type new user's  type
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * get gander
     *
     * @return current gander
     */
    public String getGander() {
        return gander;
    }

    /**
     * set gander with new gander
     *
     * @param gander new user's gander
     */
    public void setGander(String gander) {
        this.gander = gander;
    }


    /**
     * display all user info
     *
     * @return all user info
     */
    @Override
    public String toString() {
        return "User{" +
                "Name='" + name + '\n' +
                ", Email='" + email + '\n' +
                ", Location='" + location + '\n' +
                ", Type='" + type + '\n' +
                ", Gander='" + gander + '\n' +
                '}';
    }
}
