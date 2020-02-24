import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TopReviews {

  public static void main(String[] args) {
    List<String> reviews=new ArrayList<>();
    reviews.add(" bmw benz volvo benz volvo peugeot, audi audi audi bmw audi none of the above audi benz honda");
    reviews.add(" honda toyota volvo benz volvo benz what are you saying audi 67 5 audi, benz, audi");
    int noOfcompetitors = 6;
    List<String> competitors = new ArrayList<>();  
    competitors.add("benz");
    competitors.add("audi");
    competitors.add("bmw");
    competitors.add("honda");
    competitors.add("peugeot");
    competitors.add("volvo");
    int noOfReviews=2;
    int topCompetitors=3;

    System.out.println(
      new TopReviews().getTopCompetitors(reviews, noOfcompetitors, competitors, noOfReviews, topCompetitors)
    );
  }

  public List<String> getTopCompetitors(List<String> reviews, int noOfcompetitors, 
  List<String> competitors, int noOfReviews, int topCompetitors){
    //merge the reviews into 1 string
    Map<String, Integer> comparatorFreqs = new HashMap<>();
    String allReviews="";
    for(int i=0;i<reviews.size();i++){
      allReviews+=reviews.get(i);
    }
    //for each competitor
    //int[]freqs=new int[noOfcompetitors];
    for(int j=0;j<noOfcompetitors;j++){
      //search freq in review
      int end=0;
      int freq=-1;
      while (end>-1){
        freq++;
        end = allReviews.indexOf(competitors.get(j), end);
        if(end>-1) end++;
      }
      //update frequency array
      comparatorFreqs.put(competitors.get(j), freq);
      System.out.println("comparatorFreqs = "+comparatorFreqs);
      //freqs[j]=freq;
    }
    //after looping
    final Map<String, Integer> sortedCompetitorFreqs = comparatorFreqs.entrySet().stream()
                                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(
                                  Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
      //sort competitors in desc based on freq
      //return top n competitors
    return sortedCompetitorFreqs.keySet().stream().limit(topCompetitors).collect(Collectors.toList());
  }

  public List<String> getTopCompetitors(String[] reviews, int noOfcompetitors, 
  String[] competitors, int noOfReviews, int topCompetitors){
    //merge the reviews into 1 string
    //for each competitor
      //search freq in review
      //update frequency array
    //after looping
      //sort competitors in desc based on freq
      //return top n competitors
    return null;
  }
}