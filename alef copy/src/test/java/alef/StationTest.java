package alef;

import org.junit.Test;
import static org.junit.Assert.*;

public class StationTest {

  @Test
  public void testSameZoneTrue() {
    //Given
    boolean sameZone0 = Station.sameZone(Station.EARLS_COURT,Station.HOLBORN);
    boolean sameZone1 = Station.sameZone(Station.EARLS_COURT,Station.HAMMERSMITH);
    boolean notSameZone0 = Station.sameZone(Station.HOLBORN,Station.WIMBLEDON);
    boolean notSameZone1 = Station.sameZone(Station.HOLBORN,Station.HAMMERSMITH);
    //Then
    assertTrue(sameZone0);
    assertTrue(sameZone1);
    assertFalse(notSameZone0);
    assertFalse(notSameZone1);
  }

  @Test
  public void testIsInZone() {
    //Given
    boolean isInZone0 = Station.HOLBORN.isInZone(Station.Zone.ZONE_1);
    boolean isInZone1 = Station.EARLS_COURT.isInZone(Station.Zone.ZONE_1);
    boolean isInZone2 = Station.EARLS_COURT.isInZone(Station.Zone.ZONE_2);
    boolean isInZone3 = Station.WIMBLEDON.isInZone(Station.Zone.ZONE_3);
    boolean isInZone4 = Station.HAMMERSMITH.isInZone(Station.Zone.ZONE_2);
    //Then
    assertTrue(isInZone0);
    assertTrue(isInZone1);
    assertTrue(isInZone2);
    assertTrue(isInZone3);
    assertTrue(isInZone4);
  }

  @Test
  public void testAddZone() {
    //Given
    Station station = new Station("Imaginary Station");
    assertFalse(station.isInZone(Station.Zone.ZONE_1));
    assertFalse(station.isInZone(Station.Zone.ZONE_2));
    assertFalse(station.isInZone(Station.Zone.ZONE_3));
    station.addZone(Station.Zone.ZONE_1);
    assertTrue(station.isInZone(Station.Zone.ZONE_1));
    station.addZone(Station.Zone.ZONE_2);
    assertTrue(station.isInZone(Station.Zone.ZONE_2));
    station.addZone(Station.Zone.ZONE_3);
    assertTrue(station.isInZone(Station.Zone.ZONE_3));
  }
  
}
