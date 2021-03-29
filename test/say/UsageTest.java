package say;

import org.junit.Assert;
import org.junit.Test;

public class UsageTest {

    public static final String PERSON1 = "MAX";


    private Say getSay(){
        return new SayImpl();
    }

    @Test
    public void usage1() throws StatusException {
        Say w = new getSay();

        Words personsword =w.pick(PERSON1, Words.Hello);

        Assert.assertEquals(Words.Hello,personsword);


    }

    public void usage2() throws StatusException{
        Say w = new getSay();

        Words personsword =w.pick(PERSON1, Words.Hello);

        boolean said = w.say(personsword);
        Assert.assertTrue(said);
    }



}
