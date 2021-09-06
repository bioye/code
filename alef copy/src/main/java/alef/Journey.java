package alef;

public class Journey {

  public double getFare(){
    if(vehicle==Mode.BUS){
      return 1.80;
    }
    if(!swiped){
      return 3.20;
    }
    if(origin.isInZone(Station.Zone.ZONE_1)&&destination.isInZone(Station.Zone.ZONE_1)){
      return 2.50;
    }
    if(Station.sameZone(origin, destination)){
      return 2;
    }
    if(origin.isInZone(Station.Zone.ZONE_1)||destination.isInZone(Station.Zone.ZONE_1)){
      return 3;
    }
    return 2.25;
  }

  public Journey(Station start, Station end, Mode vehicle, boolean swiped){
    this.origin=start;
    this.destination=end;
    this.vehicle=vehicle;
    this.swiped=swiped;
  }

  public Journey() {
  }

  Station origin;
  Station destination;
  Mode vehicle;
  boolean swiped;
  
  enum Mode{
    BUS,TUBE
  }
}