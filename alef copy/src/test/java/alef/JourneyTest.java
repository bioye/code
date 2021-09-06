package alef;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JourneyTest {

  @Test
  public void testGetFareHolbornEarls(){
    //Given
    Journey testJourney0 = new Journey(
      Station.HOLBORN, Station.EARLS_COURT, Journey.Mode.TUBE, true);
    double testFare = testJourney0.getFare();
    //Then
    assertEquals(2.50d,testFare, 0.0d);
  }

  @Test
  public void testGetFare_HolbornEarlsNoswipe(){
    //Given
    Journey testJourney0 = new Journey(
      Station.HOLBORN, Station.EARLS_COURT, Journey.Mode.TUBE, false);
    double testFare = testJourney0.getFare();
    //Then
    assertEquals(3.20d,testFare, 0.0d);
  }

  @Test
  public void testGetFareEarlsChelsea(){
    //Given
    Journey testJourney0 = new Journey(Station.EARLS_COURT, Station.CHELSEA, Journey.Mode.BUS, true);
    double testFare = testJourney0.getFare();
    //Then
    assertEquals(1.80d,testFare, 0.0d);
  }

  @Test
  public void testGetFareEarlsHammersmith(){
    //Given
    Journey testJourney0 = new Journey(Station.EARLS_COURT, Station.HAMMERSMITH, Journey.Mode.TUBE, true);
    double testFare = testJourney0.getFare();
    //Then
    assertEquals(2.0d,testFare, 0.0d);
  }

  @Test
  public void testGetFareEarlsHammersmithNoswipe(){
    //Given
    Journey testJourney0 = new Journey(Station.EARLS_COURT, Station.HAMMERSMITH, Journey.Mode.TUBE, false);
    double testFare = testJourney0.getFare();
    //Then
    assertEquals(3.2d,testFare, 0.0d);
  }
}