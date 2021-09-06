/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
INPUT STRING:

product_id,name,description,price
1,blender,blends,20
2,rice cooker, cooks rice,$30
3, saucepan, too much      whitespace    , $10
4d, scale, "  a description, including a comma  ", $30.30

OUTPUT:
[{
  product_id=1,
  name=blender,
  description=blends,
  price=20
}, {
  product_id=2,
  name=rice cooker,
  description=cooks rice,
  price=$30
}, {
  product_id=3,
  name=saucepan,
  description=too much      whitespace,
  price=$10
}, {
  product_id=4d,
  name=scale,
  description=  a description, including a comma  ,
  price=$30.30
}]

INPUT STRING:

source,title,article_length
nytimes.com,"White space, with intention. ", 1000
newyorker.com, Coöperating with umlauts, 54

OUTPUT:
[{
  source=nytimes.com,
  title=White space, with intention. ,
  article_length=1000
}, {
  source=newyorker.com,
  title=Coöperating with umlauts,
  article_length=54
}]
 
 */

public class ListOfMaps {
  public static void main(String[] args) {
    
    String longString = "product_id,name,description,price\n"
+"1,blender,blends,20\n"
+"2,rice cooker, cooks rice,$30\n"
+"3, saucepan, too much      whitespace    , $10\n"
+"4d, scale, \"  a description, including a comma  \", $30.30";
    
    System.out.println(getListOfMaps(longString));
  }
  
  public static List<Map<String,String>> getListOfMaps(String longString){
    
    //split lines into hashMaps using endofline symbol
    String[] rows = longString.split("\n");
    List<Map<String,String>> listOfHashMaps = new ArrayList<>();
    String[] keys = rows[0].split(",");
    
    for(int i=1;i<rows.length;i++){
      Map<String, String> rowMap = new HashMap<>();
      if(rows[i].contains("\"")){
        rowMap = splitStringWithQuotes(rows[i], keys);
      }
      else{
        String[] eachRow = rows[i].split(",");
        for(int j = 0; j<eachRow.length;j++){
          rowMap.put(keys[j],eachRow[j]);
        }
      }
      listOfHashMaps.add(rowMap);
    }
    return listOfHashMaps;
  }

  public static Map<String, String> splitStringWithQuotes(String stringWithQuotes, String[] keys){
    boolean flag = false;
    StringBuilder current=new StringBuilder("");
    int counter = 0;
    Map<String, String> rowMap = new HashMap<>();
    for(int k=0;k<stringWithQuotes.length();k++){
      char currentChar = stringWithQuotes.charAt(k);
      if(currentChar!='"'&&currentChar!=','){
        current.append(currentChar);
      }
      else{
        if(currentChar=='"'){
          if(flag){
            rowMap.put(keys[counter],current.toString());
            counter++;
            current.setLength(0);
          }
          flag = !flag;
        }
        else if(currentChar==','&&!flag){
          rowMap.put(keys[counter],current.toString());
          counter++;
          current.setLength(0);
        }
      }
    }
    return rowMap;
  }
  
}
