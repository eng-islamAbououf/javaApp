public class Bookings {
    protected String name;
    protected String location;
    protected String duration;
    protected double price;
    protected int time;
    protected long cancellationPeriod;

    /**
     * it return the time of cancellation period
     *
     * @return time of cancellation period
     */
    public long getCancellationPeriod() {
        long timeExecutionResult = (cancellationPeriod-timeExecution());
        return timeExecutionResult;
    }

    /**
     * it set time cancellation period
     *
     * @param cancellationPeriod current time
     */
    public void setCancellationPeriod(long cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }

    /**
     * get the player name
     *
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * set player name
     *
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get booking location
     *
     * @return current location
     */
    public String getLocation() {
        return location;
    }

    /**
     * set booking location
     *
     * @param location new location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * get booking duration
     *
     * @return current duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * set booking duration
     *
     * @param duration new duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * get booking price
     *
     * @return current price
     */
    public double getPrice() {
        return price;
    }

    /**
     * set booking price
     *
     * @param price new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * get booking time
     *
     * @return current time
     */
    public int getTime() {
        return time;
    }

    /**
     * set booking time
     *
     * @param time new time
     */
    public void setTime(int time) {
        this.time = time;
    }
    /**
     * calculate time Execution
     *
     * @return time Execution
     */
    public long timeExecution(){
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();

        return( (endTime - startTime)/(1000L *60*60*60));
    }

    /**
     * get the booking info
     *
     * @return all booking info
     */
    public String display() {
        long timeExecutionResult = (cancellationPeriod-timeExecution());
        if( timeExecutionResult <0){
            timeExecutionResult = 0;
        }
        return "Booking:\n" +
                "Club Name: " + name + '\n' +
                "Location: " + location + '\n' +
                "Duration: " + duration + '\n' +
                "Price: " + price + '\n' +
                "Time: " + time +" PM"+ '\n'+
                "Cancellation Period: " + timeExecutionResult +" PM"+ '\n';
    }
}
