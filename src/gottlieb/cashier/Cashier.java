package gottlieb.cashier;

public class Cashier
{
    Cash cashRegister = new Cash();

    public Cash pay(double price, Cash payment) throws NotEnoughChangeException
    {
        updateRegister(payment);

        double paid = calculatePayment(payment);

        Cash change = new Cash();
        double remaining = 0.00;
        if (paid > price)
        {
            remaining = paid - price;
            remaining = Math.round(remaining * 100);
            remaining /= 100;
        }

        if (remaining != 0.00)
        {

            while (remaining >= 20.00 && cashRegister.getTwenties() >= 1) {
                change.addTwenties(1);
                remaining -= 20;
                cashRegister.addTwenties(-1);
                if (remaining == 0.00)
                {
                    break;
                }
            }

            while (remaining >= 10.00 && cashRegister.getTens() >= 1) {
                change.addTens(1);
                remaining -= 10;
                cashRegister.addTens(-1);
                if (remaining == 0.00)
                {
                    break;
                }
            }

            while (remaining >= 5.00 && cashRegister.getFives() >= 1) {
                change.addFives(1);
                remaining -= 5;
                cashRegister.addFives(-1);
                if (remaining == 0.00)
                {
                    break;
                }
            }

            while (remaining >= 1.00 && cashRegister.getSingles() >= 1) {
                change.addSingles(1);
                remaining -= 1;
                cashRegister.addSingles(-1);
                if (remaining == 0.00)
                {
                    break;
                }
            }

            while (remaining >= 0.25 && cashRegister.getQuarters() >= 1) {
                change.addQuarters(1);
                remaining -= 0.25;
                cashRegister.addQuarters(-1);
                if (remaining == 0.00)
                {
                    break;
                }
            }

            while (remaining >= 0.10 && cashRegister.getDimes() >= 1) {
                change.addDimes(1);
                remaining -= 0.10;
                cashRegister.addDimes(-1);
                if (remaining == 0.00)
                {
                    break;
                }
            }

            while (remaining >= 0.05 && cashRegister.getNickels() >= 1) {
                change.addNickels(1);
                remaining -= 0.05;
                cashRegister.addNickels(-1);
                if (remaining == 0.00)
                {
                    break;
                }
            }

            while (remaining >= 0.01 && cashRegister.getPennies() >= 1) {
                change.addPennies(1);
                remaining -= 0.01;
                cashRegister.addPennies(-1);
            }

        }

        if (remaining != 0.00)
        {
            throw new NotEnoughChangeException();
        }

        return change;
    }

    private void updateRegister(Cash payment)
    {
        cashRegister.addPennies(payment.getPennies());
        cashRegister.addNickels(payment.getNickels());
        cashRegister.addDimes(payment.getDimes());
        cashRegister.addQuarters(payment.getQuarters());
        cashRegister.addSingles(payment.getSingles());
        cashRegister.addFives(payment.getFives());
        cashRegister.addTens(payment.getTens());
        cashRegister.addTwenties(payment.getTwenties());
    }

    private double calculatePayment(Cash payment)
    {
        double paid = 0;

        paid += (.01 * payment.getPennies());

        paid += (.05 * payment.getNickels());

        paid += (.10 * payment.getDimes());

        paid += (.25 * payment.getQuarters());

        paid += (1 * payment.getSingles());

        paid += (5 * payment.getFives());

        paid += (10 * payment.getTens());

        paid += (20 * payment.getTwenties());

        return paid;
    }

}