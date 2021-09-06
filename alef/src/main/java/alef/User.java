package alef;

public class User {

  public static void main(String[] args) {

    User user = new User();
    user.loadCard(30);
    
    Journey holbornToEarls = new Journey(
      Station.HOLBORN, Station.EARLS_COURT, Journey.Mode.TUBE, true);
    user.takeTrip(holbornToEarls);

    Journey earlsToChelsea = new Journey(Station.EARLS_COURT, Station.CHELSEA, Journey.Mode.BUS, true);
    user.takeTrip(earlsToChelsea);

    Journey earlsToHammersmith = new Journey(Station.EARLS_COURT, Station.HAMMERSMITH, Journey.Mode.TUBE, true);
    user.takeTrip(earlsToHammersmith);

    System.out.printf("\u00A3%1.2f %n", user.getCardBalance());
  }

  public double getCardBalance() {
    return cardBalance;
  }

  public void takeTrip(Journey journey){
    cardBalance-=journey.getFare();
  }

  public void loadCard(double amount){
    cardBalance=amount;
  }

  private double cardBalance;
}