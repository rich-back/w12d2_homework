import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person passenger;
    private Bus fullBus;
    private BusStop stop;
    private Person person;

    @Before
    public void before() {
        bus = new Bus("Timbuktu", 20);
        passenger = new Person();
        stop = new BusStop("Queen Street");
        person = new Person();
    }

    @Test
    public void canGetPassengerCount() {
        assertEquals(0, bus.passengerCount());
    }
    @Test
    public void canAddPassenger() {
        bus.addPassenger(passenger);
        assertEquals(1, bus.passengerCount());
    }
    @Test
    public void cannotOverfill() {
        fullBus = new Bus("Glasgow", 2);
        fullBus.addPassenger(passenger);
        fullBus.addPassenger(passenger);
        fullBus.addPassenger(passenger);
        fullBus.addPassenger(passenger);
        fullBus.addPassenger(passenger);
        assertEquals(2, fullBus.passengerCount());
    }
    @Test
    public void canRemovePassenger() {
        bus.addPassenger(passenger);
        bus.addPassenger(passenger);
        bus.addPassenger(passenger);
        bus.removePassenger();
        bus.removePassenger();
        assertEquals(1, bus.passengerCount());
    }
    @Test
    public void canPickUp() {
        stop.addPerson(person);
        stop.addPerson(person);
        stop.addPerson(person);
        bus.pickUp(stop);
        assertEquals(1, bus.passengerCount());
        assertEquals(2, stop.queueCount());
    }

}
