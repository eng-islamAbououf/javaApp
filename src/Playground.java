import java.util.ArrayList;

public class Playground {
    protected int playgroundID ;
    protected String location ;
    protected int playgroundOwnerID ;
    protected String playgroundName;
    private double price;
    private ArrayList<Integer> avaHour=new ArrayList<>();


    Playground(){
        avaHour.add(0,12);
        for(int i=1;i<12;i++){
            avaHour.add(i,i);
        }
    }


    /**
     * set the playground price with new price
     *
     * @param price new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * set the playground location with new location
     *
     * @param location new location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * set the playground ID with new ID
     *
     * @param playgroundID new playground ID
     */
    public void setPlaygroundID(int playgroundID) {
        this.playgroundID = playgroundID;
    }

    /**
     * set the playground Name with new Name
     *
     * @param playgroundName new playground Name
     */
    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    /**
     * set the playground owner ID with new ID
     *
     * @param playgroundOwnerID new playground Owner ID
     */
    public void setPlaygroundOwnerID(int playgroundOwnerID) {
        this.playgroundOwnerID = playgroundOwnerID;
    }

    /**
     * set the playground available Hour with new available Hour
     *
     * @param avaHour new available Hour
     */
    public void setAvaHour(ArrayList<Integer> avaHour) {
        this.avaHour = avaHour;
    }


    /**
     * get list of avilible hour
     *
     * @return list of avilible hour
     */
    public ArrayList<Integer> getAvaHour() {
        return avaHour;
    }


    /**
     * get playground Owner ID
     *
     * @return current playground Owner ID
     */
    public int getPlaygroundOwnerID() { return playgroundOwnerID; }

    /**
     * get playground Name
     *
     * @return current playground Name
     */
    public String getPlaygroundName() {
        return playgroundName;
    }

    /**
     * get playground ID
     *
     * @return current playground ID
     */
    public int getPlaygroundID() {
        return playgroundID;
    }

    /**
     * get playground location
     *
     * @return current playground location
     */
    public String getLocation() {
        return location;
    }

    /**
     * get playground price
     *
     * @return current playground price
     */
    public double getPrice() {
        return price;
    }

    /**
     * display all avilible hour
     *
     */
    public void displayAvaHour(){
        int count=1;
        for(int ava:avaHour){
            System.out.println(count+"- From "+ava+" Pm ");
            count++;
        }
    }

    /**
     * get all info about playground
     *
     * @return all playground info
     */
    @Override
    public String toString() {
        return
                "Playground Name = " + playgroundName + '\n'+
                "  Location = " + location + '\n'+
                "  Price = " + price +" LE"+ '\n';
    }
}
