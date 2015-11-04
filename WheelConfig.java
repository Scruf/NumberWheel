import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
/*
*
*
* @author Egor Kozitski
* */
public class WheelConfig  extends java.lang.Object implements Configuration{
  //@param BRIDGE_STR
   public static final java.lang.String BRIDGE_STR="-";
    //@param EMPTY_CELL
   public static int EMPTY_CELL=0;
    //@param TRIAD_CELL
   public static int TRIAD_CELL=3;
    //@ri TRIAD_STR
   public static java.lang.String TRIAD_STR=".";
   public ArrayList<Integer> list;
   private int []configArray;
    //Constructs an ri number wheel puzzle from an input file whose format is: #_triads bridge1_value bridge2_value...A
   public WheelConfig(java.lang.String filename)throws java.io.FileNotFoundException{
        String content=" ";
        ArrayList<String> contentList = new ArrayList<String>();
       try{
            BufferedReader  reader = new BufferedReader(new FileReader(filename));
           while((content = reader.readLine())!=null){
             contentList.add(content);
           }
           reader.close();
        }catch(java.io.IOException file){

       }
       list = new ArrayList<Integer>();
       list.add(Integer.parseInt(contentList.get(0)));
       for(String s : contentList.get(1).split(" "))
        list.add(Integer.parseInt(s));
      configArray = new int[TRIAD_CELL*list.get(0)];
      Arrays.fill(configArray,EMPTY_CELL);
    }
    //Copy constructor. Takes an incoming config and makes a complete deep copy of its attributes.
    public WheelConfig(WheelConfig config){

        this.configArray = config.configArray.clone();
    }
    //Get the collection of successors from the current one
    public java.util.Collection<Configuration> getSuccessors(){
       return null;
    }
    //Is the current configuration valid or not
    public boolean isValid(){
        return true;
    }
    //Is the current configuration a goal
    public boolean isGoal(){
        return true;
    }
    @Override
    public java.lang.String toString(){
      String temp =" ";
      for(int i=0;i<configArray.length;i++){
        if(i%3==0)
          temp+=BRIDGE_STR;
        temp += String.valueOf(configArray[i])+TRIAD_STR;

      }
      String str = temp.substring(2,temp.length()-1);
      return str;
    }
}
