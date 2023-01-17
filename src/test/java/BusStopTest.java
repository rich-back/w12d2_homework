import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private BusStop stop;
    private Person person;

    @Before
    public void before() {
        stop = new BusStop("George St");
        person = new Person();
    }
    @Test
    public void canAddToQueue() {
        stop.addPerson(person);
        assertEquals(1, stop.queueCount());
    }
    @Test
    public void canRemovePerson() {
        stop.addPerson(person);
        stop.addPerson(person);
        stop.removePerson();
        assertEquals(1, stop.queueCount());
    }

}
