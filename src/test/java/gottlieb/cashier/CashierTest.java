package gottlieb.cashier;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CashierTest
{
    @Test
    public void pay() throws NotEnoughChangeException
    {
        try {
            //given
            Cashier cashier = new Cashier();
            cashier.cashRegister.setQuarters(100);
            cashier.cashRegister.setPennies(100);

            Cash payment = new Cash();
            payment.setSingles(3);

            Cash change = new Cash();

            //when
            change = cashier.pay(2.49, payment);

            //then
            assertEquals(2, change.getQuarters());
            assertEquals(1, change.getPennies());
            assertEquals(0, change.getFives());

            assertEquals(98, cashier.cashRegister.getQuarters());
            assertEquals(99, cashier.cashRegister.getPennies());
            assertEquals(3, cashier.cashRegister.getSingles());
            assertEquals(0, cashier.cashRegister.getDimes());
        }

        catch (NotEnoughChangeException ex)
        {
        }
    }

    @Test (expected = NotEnoughChangeException.class)
    public void payBrokeCashier() throws NotEnoughChangeException
    {
            //given
            Cashier cashier = new Cashier();

            Cash payment = new Cash();
            payment.setSingles(3);

            //when
            cashier.pay(2.49, payment);
    }

    @Test (expected = NotEnoughChangeException.class)
    public void payNotEnoughChange() throws NotEnoughChangeException
    {
        //given
        Cashier cashier = new Cashier();
        cashier.cashRegister.setTwenties(20);

        Cash payment = new Cash();
        payment.setSingles(3);

        //when
        cashier.pay(2.49, payment);
    }
}
