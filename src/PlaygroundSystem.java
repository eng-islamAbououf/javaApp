
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlaygroundSystem {

    Scanner scanner = new Scanner(System.in) ;
    protected  ArrayList<Playground> Playgrounds = new ArrayList<>() ;
    protected  ArrayList<User> users = new ArrayList<>() ;
    protected ArrayList<Integer> idOfReportedPlayground = new ArrayList<>();
    protected ArrayList<ReportedPlayground> playgroundReported = new ArrayList<>();
    protected ArrayList<ReportedPlayground> suspendedPlayground = new ArrayList<>();

    static int playerID = 1;
    static int playgroundID = 1000;

    final String ADMIN_MAIL = "admin@mail.com" ;
    final String ADMIN_PASSWORD = "admin" ;

    ////////////////////////////////////////

    /**
     * this is the starting point for our program
     * it have a main menu and all functions that we need
     *
     */
    public PlaygroundSystem() {
        System.out.println("Welcome to GOFO");
        do {
            System.out.println("1- Sign in");
            System.out.println("2- Sign Up");
            System.out.println("OR press any number to Exit");
            int c = scanner.nextInt();
            if (c == 1) {
                System.out.println("Enter ur Email : ");
                scanner.nextLine();
                String mail = scanner.nextLine();

                System.out.println("Enter ur Password : ");
                String pass = scanner.nextLine();

                int id = signIn(mail, pass);
                if (id==0)
                    adminHome();
                else if (id > 0) {
                    if (users.get(id - 1).getType().equals("Player")) {
                        PlayerHome(id);
                    } else if (users.get(id - 1).getType().equals("Playground Owner")){
                        playgroundOwnerHome(id);
                    }

                } else
                    System.out.println("Failed!!");;

            } else if (c == 2)
                signUp();
            else {
                System.out.println("goodbye !");
                scanner.close();
                System.exit(0);
            }
        }while (true) ;
    }

    /**
     * this is admin home and all features he need
     * it contain admin menu and show reported playgrounds
     * and he can suspend or remove this playground from our system
     */
    protected void adminHome() {
        while (true) {
            System.out.println("1- Show reported playgrounds");
            System.out.println("2- Show suspended playgrounds");
            System.out.println("3- Logout");
            int choice = scanner.nextInt();
            if (choice == 1) {
                int count=1;
                for(ReportedPlayground r:playgroundReported){
                    if(r.numberOfReports!=0){
                        System.out.println(count+"-"+r.display());
                        count++;
                    }
                }
                System.out.println("Please choose playground");
                choice=scanner.nextInt();
                System.out.println(playgroundReported.get(choice-1).display());
                System.out.println("1-Delete this playground");
                System.out.println("2-Suspend this playground");
                System.out.println("3-Back to Admin Home");
                int anotherChoice =scanner.nextInt();
                if(anotherChoice==1){
                    for(int i=0;i<Playgrounds.size();i++){
                        if(playgroundReported.get(choice-1).getId()==Playgrounds.get(i).getPlaygroundID()){
                            Playgrounds.remove(i);
                            break;
                        }
                    }
                    for(User o:users){
                        for(int i=0;i<o.getMyPlaygrounds().getPlayground().size();i++){
                            if(o.getMyPlaygrounds().getPlayground().get(i).getPlaygroundID()==playgroundReported.get(choice-1).getId()){
                                o.getMyPlaygrounds().getPlayground().remove(i);
                                break;
                            }

                        }
                    }
                    playgroundReported.remove(choice-1);
                    System.out.println("Deleted Successfully!!!");
                }else if(anotherChoice==2){
                    System.out.println("Please enter suspend time");
                    anotherChoice = scanner.nextInt();
                    playgroundReported.get(choice-1).setSuspendTime(anotherChoice);
                    suspendedPlayground.add(playgroundReported.get(choice-1));
                    playgroundReported.remove(choice-1);
                    System.out.println("Suspended Successfully!!!");
                }
            }else if(choice==2){
                int count=1;
                for(ReportedPlayground r:suspendedPlayground){
                    if(r.numberOfReports!=0){
                        System.out.println(count+"-"+r.display());
                        count++;
                    }
                }
            }
            else if (choice == 3) {
                break;
            }
        }
    }

    /**
     * this is playground owner home
     * it allow him to add playgrounds
     * and add money in his EWallet
     *
     * @param id user's id he can access this profile
     */
    protected void playgroundOwnerHome(int id) {
        while (true) {
            System.out.println("1- Add playground");
            System.out.println("2- My eWallet");
            System.out.println("3- My Playgrounds");
            System.out.println("4- Logout");
            int choice = scanner.nextInt();
            if (choice == 1) {
                addPlayground(id);
            } else if(choice == 2){
                System.out.println("Your balance is: "+users.get(id-1).myMoney.getBalance());
                System.out.println("1- Deposit");
                System.out.println("2- Back");
                choice = scanner.nextInt();
                if(choice == 1){
                    System.out.println("Please enter amount of money");
                    double amount = scanner.nextDouble();
                    users.get(id-1).myMoney.deposit(amount);
                }
            }else if (choice == 3) {
               if(users.get(id-1).getMyPlaygrounds().getPlayground().size()!=0){
                   for(Playground obj:users.get(id-1).getMyPlaygrounds().getPlayground()){
                       System.out.println(obj.toString());
                   }
               }else{
                   users.get(id-1).setType("Player");
                   System.out.println("You don't have playgrounds you can booking now");
                   PlayerHome(id);
                   break;
               }

            } else if (choice == 4) {
                break;
            }
        }
    }

    /**
     * add playground in our system
     *
     * @param id the owner id
     */
    protected void addPlayground(int id) {

        users.get(id-1).setType("Playground Owner");
        Playground newPlayground = new Playground() ;
        ReportedPlayground reportedPlayground = new ReportedPlayground();
        System.out.println("Enter Location");
        scanner.nextLine() ;
        String temp = scanner.nextLine();
        newPlayground.setLocation(temp);

        String name = validationPlaygroundName() ;
        reportedPlayground.setName(name);

        newPlayground.setPlaygroundName(name);

        System.out.println("Enter price");
        newPlayground.setPrice(scanner.nextDouble());
        newPlayground.setPlaygroundID(playgroundID);
        reportedPlayground.setId(playgroundID);
        playgroundID++;

        newPlayground.setPlaygroundOwnerID(id);
        Playgrounds.add(newPlayground);
        users.get(id-1).getMyPlaygrounds().getPlayground().add(newPlayground);
        playgroundReported.add(reportedPlayground);
        System.out.println("Added successfully !!");
        playgroundOwnerHome(id);
    }

    /**
     * this is player home
     * it allow him to add playgrounds then his type will convert to "Playground Owner"
     * and add money in his EWallet
     * and Booking an hours
     * and he can show his bookings and cancel it while still in period time
     *
     * @param id user's id he can access this profile
     */
    public void PlayerHome(int id) {
        while (true) {
            System.out.println("1- Booking an hour");
            System.out.println("2- Report playground ");
            System.out.println("3- MyBookings ");
            System.out.println("4- Add Playground ");
            System.out.println("5- My eWallet");
            System.out.println("6- Logout");
            int choice = scanner.nextInt();
            if (choice == 1) {
                displayAllAvailablePlayground(id);
            } else if (choice == 2) {
                if(Playgrounds.size()!=0){
                    System.out.println("Please Choose playground");
                    for(int i =0;i<Playgrounds.size();i++){
                        System.out.println(i+1+"-"+Playgrounds.get(i).getPlaygroundName());
                    }
                    int numberOfReportedPlayground = scanner.nextInt();
                    scanner.nextLine();
                    reportPlayground(Playgrounds.get(numberOfReportedPlayground-1).getPlaygroundID(),id);
                }
            }else if(choice == 3){
                int bookingsCounter = 1;
                if(users.get(id-1).getMyBookings().size()!=0){
                    System.out.println("Please Choose number of booking");
                    for(Bookings book:users.get(id-1).getMyBookings()){
                        System.out.println(bookingsCounter+"- "+book.display());
                    }
                    int num = scanner.nextInt();
                    System.out.println("1- Cancel Booking");
                    System.out.println("2- Back");
                    choice = scanner.nextInt();
                    if(choice == 1){
                        if(users.get(id-1).getMyBookings().get(num-1).getCancellationPeriod()>0){
                            for(Playground obj:Playgrounds){
                                if(obj.getPlaygroundName().equals(users.get(id - 1).getMyBookings().get(num - 1).getName())){
                                    obj.getAvaHour().add(users.get(id-1).getMyBookings().get(num-1).time);
                                    obj.getAvaHour().sort(Collections.reverseOrder());
                                    users.get(id-1).myMoney.deposit(users.get(id-1).getMyBookings().get(num-1).getPrice());
                                    for(User o:users){
                                        for(Playground obj2: o.getMyPlaygrounds().getPlayground()){
                                            if(obj2.getPlaygroundName().equals(users.get(id - 1).getMyBookings().get(num - 1).getName())){
                                                o.myMoney.withdraw((users.get(id-1).getMyBookings().get(num-1).getPrice()));
                                                users.get(id-1).getMyBookings().remove(num-1);
                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }
                }else{
                    System.out.println("You don't have any bookings!!");
                }

            }else if (choice == 4) {
                addPlayground(id);
                break;
            }else if (choice == 5) {
                System.out.println("Your balance is: "+users.get(id-1).myMoney.getBalance());
                System.out.println("1- Deposit");
                System.out.println("2- Back");
                choice = scanner.nextInt();
                if(choice == 1){
                    System.out.println("Please enter amount of money");
                    double amount = scanner.nextDouble();
                    users.get(id-1).myMoney.deposit(amount);
                }
            }
            else if (choice == 6) {
                break;
            }
        }
    }

    /**
     * this fun used to make a report for any playground and send this report to the admin page
     *
     * @param groundID id for playground that want to report it
     * @param id id for the user who make the report
     */
    void reportPlayground(int groundID,int id){
        boolean mainFlag=false;
        boolean flag=false;
        if( idOfReportedPlayground.contains(groundID)){
            for(ReportedPlayground rep:playgroundReported){
                if(rep.getId()==groundID)
                    for(int i:rep.idOfUser){
                        if(i==id){
                            flag=true;
                            break;
                        }
                    }
            }
            if(flag){
                System.out.println("You reported this playground before!!");
                mainFlag=true;
            }else{
                for(ReportedPlayground rep:playgroundReported){
                    if(groundID==rep.getId()){
                        rep.numberOfReports++;
                        System.out.println("Please Enter your opinion:");
                        String report = scanner.nextLine();
                        rep.setMessage(rep.getMessage()+"\n"+
                                users.get(id-1).getName()+" Said: "+report);
                        mainFlag=true;
                        break;
                    }
                }
                for(ReportedPlayground rep:playgroundReported){
                    if(groundID==rep.getId()){
                        rep.idOfUser.add(id);
                    }
                }

            }
        }



        if(!mainFlag){
            System.out.println("Please Enter your opinion:");
            String report=scanner.nextLine();
            for(ReportedPlayground rep:playgroundReported){
                if(groundID==rep.getId()){
                    rep.setMessage(rep.getMessage()+"\n"+
                            users.get(id-1).getName()+" Said: "+report);
                    rep.numberOfReports++;
                    break;
                }
            }


            idOfReportedPlayground.add(groundID);
            for(ReportedPlayground rep:playgroundReported){
                if(groundID==rep.getId()){
                    rep.idOfUser.add(id);
                }
            }
        }



    }

    /**
     * this fun is used to display the nearest playgrounds then display other playgrounds
     *
     * @param id user's id
     */
    public void displayAllAvailablePlayground(int id){
        int count=1;
        ArrayList<Integer> nearBookings =new ArrayList<>();
        System.out.println("Please choose playgrounds who want:");
        for(int i = 0 ; i < Playgrounds.size() ; i++){
            if (users.get(id-1).getLocation().equalsIgnoreCase(Playgrounds.get(i).getLocation())){
                System.out.println(count+"-"+Playgrounds.get(i));
                nearBookings.add(i);
                count++;
            }
        }

        for(int i = 0 ; i < Playgrounds.size() ; i++){
            if (!(users.get(id-1).getLocation().equalsIgnoreCase(Playgrounds.get(i).getLocation()))){
                System.out.println(count+"-"+Playgrounds.get(i));
                nearBookings.add(i);
                count++;
            }
        }

        int scan = scanner.nextInt();
        if(users.get(id-1).myMoney.withdraw(Playgrounds.get(nearBookings.get(count-2)).getPrice())){
            for(User obj:users){
               for(Playground obj2: obj.myPlaygrounds.getPlayground()){
                   if(obj2.getPlaygroundID()==Playgrounds.get(nearBookings.get(count-2)).getPlaygroundID()){
                       obj.myMoney.deposit(Playgrounds.get(nearBookings.get(count-2)).getPrice());
                   }
               }
            }
            if(scan < count){

                System.out.println("Please choose the right time for you:");
                Playgrounds.get(nearBookings.get(count-2)).displayAvaHour();
                scan=scanner.nextInt();

                Bookings book = new Bookings();
                book.setName(Playgrounds.get(nearBookings.get(count-2)).getPlaygroundName());
                book.setLocation(Playgrounds.get(nearBookings.get(count-2)).getLocation());
                book.setPrice(Playgrounds.get(nearBookings.get(count-2)).getPrice());
                book.setDuration("1 Hour");
                book.setTime(Playgrounds.get(nearBookings.get((count-2))).getAvaHour().get(scan-1));
                book.setCancellationPeriod(48);
                users.get(id-1).getMyBookings().add(book);
                Playgrounds.get(nearBookings.get((count-2))).getAvaHour().remove(scan-1);
            }
        }

    }

    /**
     * add user to our system
     *
     * @param user new user
     */
    public void addUser(User user){
        user.setUserID(playerID);
        playerID++ ;
        users.add(user);
    }


    /**
     * this fun is used to sign in to the system with email and password
     * that already stored in our system
     *
     * @param email user email
     * @param password user password
     * @return if exist return user id else return -1
     */
    public int signIn(String email ,String password){
        int  x = -1 ;
        if (email.equals(ADMIN_MAIL)&&password.equals(ADMIN_PASSWORD))
            return 0 ;
        for (User user:users) {
            if (user.getEmail().equalsIgnoreCase(email)&&user.getPassword().equals(password)){
                x = user.getUserID() ;
                break;
            }
        }
        return x ;
    }

    /**
     * this fun is used to check to email in Sign up
     * and return valid email that not match to any other account in our system
     *
     * @return valid email
     */
    String validation(){
        String temp;
        boolean flag = true;
        if(users.size()!=0){
            System.out.println("Enter ur Email");
            temp = scanner.nextLine() ;
            while (true){
                for (User user : users) {
                    if (temp.equals(user.getEmail())) {
                        System.out.println("Email already existing!!");
                        System.out.println("Enter ur Email again");
                        temp = scanner.nextLine();
                        flag = false;
                        break;

                    }
                    flag = true;
                }
                if(flag) {
                    return temp;
                }
            }
        }else{
            System.out.println("Enter ur Email");
            temp = scanner.nextLine() ;
            return temp;
        }
    }

    /**
     * this fun is used to check to Playground Name in addPlayground fun
     * and return valid PlaygroundName that not match to any other PlaygroundName in our system
     *
     * @return valid PlaygroundName
     */
    String validationPlaygroundName(){
        String temp;
        boolean flag = true;
        if(users.size()!=0){
            System.out.println("Enter ur Playground Name");
            temp = scanner.nextLine() ;
            while (true){
                for(int i=0;i<Playgrounds.size();i++){
                    if(temp.equals(Playgrounds.get(i).getPlaygroundName())){
                        System.out.println("Name already existing!!");
                        System.out.println("Enter ur Playground Name again");
                        temp = scanner.nextLine() ;
                        flag=false;
                        break;

                    }
                    flag=true;
                }
                if(flag) {
                    return temp;
                }
            }
        }else{
            System.out.println("Enter ur Playground Name");
            temp = scanner.nextLine() ;
            return temp;
        }
    }

    /**
     * this method is used to create a new user in our system and add it
     * it can get all valid user info then create this user
     * then go to playerHome fun
     *
     */
    public void signUp(){

        String temp ;
        User newUser = new User();
        newUser.setType("Player");
        scanner.nextLine();

        System.out.println("Enter ur name");
        temp = scanner.nextLine() ;
        newUser.setName(temp);
        newUser.setEmail(validation());

        System.out.println("Enter ur Password");
        temp = scanner.nextLine() ;
        newUser.setPassword(temp);

        System.out.println("Enter ur Location");
        temp = scanner.nextLine() ;
        newUser.setLocation(temp);

        System.out.println("Choose ur Gander");
        System.out.println("1- Male");
        System.out.println("2- Female");
        int c = scanner.nextInt() ;
        if (c==1) {
            newUser.setGander("Male");
        }else if (c==2)
            newUser.setGander("Female");

        addUser(newUser);

        System.out.println("Your Email Created Successfully");
        PlayerHome(newUser.getUserID());
    }
}
