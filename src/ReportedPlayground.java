import java.util.ArrayList;

public class ReportedPlayground {

    private String name;
    private int id;
    private String message="";
    public  int numberOfReports=0;
    private int suspendTime=0;
    public ArrayList<Integer> idOfUser = new ArrayList<>();


    /**
     * set playground suspend time
     *
     * @param suspendTime new suspend time
     */
    public void setSuspendTime(int suspendTime) {
        this.suspendTime = suspendTime;
    }

    /**
     * set playground name
     *
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set playground id
     *
     * @param id new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * set report message
     *
     * @param message new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * set number Of Reports
     *
     * @param numberOfReports new number Of Reports
     */
    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    /**
     * get number Of Reports
     *
     * @return current number Of Reports
     */
    public int getNumberOfReports() {
        return numberOfReports;
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
     * get suspend Time
     *
     * @return current suspend Time
     */
    public int getSuspendTime() {
        return suspendTime;
    }

    /**
     * get id
     *
     * @return current id
     */
    public int getId() {
        return id;
    }

    /**
     * get message
     *
     * @return current message
     */
    public String getMessage() {
        return message;
    }


    /**
     * display all info
     *
     * @return all report info
     */
    public String display() {
        return  "Player opinion: " + message + '\n' +
                "Name: " + name + '\n' +
                "id: " + id +'\n'+
                "NumberOfReports: " + numberOfReports+'\n'+
                "Suspend Time: " + suspendTime+'\n';
    }
}
