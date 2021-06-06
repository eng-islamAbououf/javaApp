/**
 * this class for create Electronic wallet for our user
 *
 * @author Abdelrahman Ahmed
 */
public class EWallet {
    protected double balance = 0;

    /**
     * get user balance
     *
     * @return the current balance
     * */
    public double getBalance() {
        return balance;
    }

    /**
     * set the user new balance
     *
     * @param balance new balance
     */
    public void setBalance(double balance) {
        if (balance<0)
        {
            System.out.println("Incorrect Input");
            return;
        }
        this.balance = balance;
    }

    /**
     * it can withdraw balance from user EWallet
     *
     * @param amount the amount to withdraw it
     * @return true if balance is enough
     */
    public boolean withdraw(double amount){
        if(balance>=amount){
            balance -= amount;
            System.out.println("Successfully!!!");
            return true;
        }else{
            System.out.println("Your don't enough money in your eWallet");
            return false;
        }
    }

    /**
     * it use to increase user's balance
     *
     * @param amount the amount to deposit it
     * @return true if amount is avilible
     */
    public boolean deposit(double amount){
        if (amount<0)
            return false ;
        balance += amount;
        System.out.println("Successfully!!!");
        return true;
    }
}
