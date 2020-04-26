package gottlieb.cashier;

public class Cash
{
    private int pennies,
                nickels,
                dimes,
                quarters,
                singles,
                fives,
                tens,
                twenties;

    public Cash()
    {
        pennies = 0;
        nickels = 0;
        dimes = 0;
        quarters = 0;
        singles = 0;
        fives = 0;
        tens = 0;
        twenties = 0;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies)
    {
        this.pennies = pennies;
    }

    public void addPennies(int pennies)
    {
        this.pennies += pennies;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public void addNickels(int nickels)
    {
        this.nickels += nickels;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public void addDimes (int dimes)
    {
        this.dimes += dimes;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public void addQuarters (int quarters)
    {
        this.quarters += quarters;
    }

    public int getSingles() {
        return singles;
    }

    public void setSingles(int singles) {
        this.singles = singles;
    }

    public void addSingles (int singles)
    {
        this.singles += singles;
    }

    public int getFives() {
        return fives;
    }

    public void setFives(int fives) {
        this.fives = fives;
    }

    public void addFives (int fives)
    {
        this.fives += fives;
    }

    public int getTens() {
        return tens;
    }

    public void setTens(int tens) {
        this.tens = tens;
    }

    public void addTens (int tens)
    {
        this.tens += tens;
    }

    public int getTwenties() {
        return twenties;
    }

    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    public void addTwenties (int twenties)
    {
        this.twenties += twenties;
    }
}