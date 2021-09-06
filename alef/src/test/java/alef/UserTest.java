package alef;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {

  @Test
  public void testLoadCard(){
    User userUnderTest = new User();
    assertEquals(0.0d, userUnderTest.getCardBalance(), 0.0d);
    userUnderTest.loadCard(100);
    assertEquals(100.0d, userUnderTest.getCardBalance(), 0.0d);
  }

  @Test
  public void testTakeTripAndGetBalance(){
    User userUnderTest = new User();
    userUnderTest.loadCard(30);
    
    Journey holbornToEarls = new Journey(
      Station.HOLBORN, Station.EARLS_COURT, Journey.Mode.TUBE, true);
    userUnderTest.takeTrip(holbornToEarls);
    assertEquals(27.5d, userUnderTest.getCardBalance(), 0.0d);

    Journey earlsToChelsea = new Journey(Station.EARLS_COURT, Station.CHELSEA, Journey.Mode.BUS, true);
    userUnderTest.takeTrip(earlsToChelsea);
    assertEquals(25.7d, userUnderTest.getCardBalance(), 0.0d);

    Journey earlsToHammersmith = new Journey(
      Station.EARLS_COURT, Station.HAMMERSMITH, Journey.Mode.TUBE, true);
    userUnderTest.takeTrip(earlsToHammersmith);
    assertEquals(23.7d, userUnderTest.getCardBalance(), 0.0d);
  }
  
}
