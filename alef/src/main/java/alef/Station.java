package alef;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Station {

  public static final Station HOLBORN = new Station("Holborn");
  public static final Station EARLS_COURT = new Station("Earl's Court");
  public static final Station CHELSEA = new Station("Chelsea");
  public static final Station HAMMERSMITH = new Station("Hammersmith");
  public static final Station WIMBLEDON = new Station("Wimbledon");

  static{
    HOLBORN.addZone(Station.Zone.ZONE_1);
    EARLS_COURT.addZone(Station.Zone.ZONE_1);
    EARLS_COURT.addZone(Station.Zone.ZONE_2);
    HAMMERSMITH.addZone(Station.Zone.ZONE_2);
    WIMBLEDON.addZone(Station.Zone.ZONE_3);
  }

  public static boolean sameZone(Station station0, Station station1){
    Set<Zone> sameZones = station0.zones.stream()
      .distinct()
      .filter(station1.zones::contains)
      .collect(Collectors.toSet());
      return sameZones!=null&&!sameZones.isEmpty();
  }

  public boolean isInZone(Zone zone){
    return zones.contains(zone);
  }

  public void addZone(Zone zone){
    zones.add(zone);
  }

  public Station(String name){
    this.name=name;
  }

  public Station(){
  }

  private String name;

  private List<Zone> zones = new ArrayList<Zone>();

  enum Zone{
    ZONE_1(1),
    ZONE_2(2),
    ZONE_3(3);

    Zone(int id){
      this.id=id;
    }
    private int id;
  }
}