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
   public Set<Integer> succesor ;
   public int comparator= 0;
   public int []bridges;
   public int numberOfCells ;
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
        bridges = new int [list.size()];
      configArray = new int[3];
      numberOfCells = (list.size()-1)*3;
      Arrays.fill(configArray,EMPTY_CELL);

      succesor = new HashSet<Integer>();
      int n = (list.size()-1)*3;
      comparator = (n*(n+1)/2)/3;
}
    public WheelConfig(int []arr){

      configArray = arr.clone();
    }
    //Copy constructor. Takes an incoming config and makes a complete deep copy of its attributes.
    public WheelConfig(WheelConfig config){

        this.configArray = config.configArray.clone();

    }
    //Get the collection of successors from the current one
    public java.util.Collection<Configuration> getSuccessors(){
        ArrayList<Configuration> successors = new ArrayList<Configuration>();
        int index = 0 ;
        for(int i=0;i<configArray.length;i++){
          if(configArray[i]==0){
            index=i;
            break;
          }
        }
        for(Object o : succesor){
          int num =(int)o;
          int []temp = configArray.clone();
          temp[index]=num;
          WheelConfig config = new WheelConfig(temp);
          successors.add(config);
        }
        return successors;
    }
    //Is the current configuration valid or not
    public boolean isValid(){
  		int index = 0;
      for(int i = 0; i < configArray.length; i++){
            if(configArray[i] == EMPTY_CELL){
                if(i != 0)
                    index = i - 1;
                else
                    index = 0;
                break;
            }
        }
  	if(index == 0)
  		  return false;
  	else if(index % 4 == 0)
  			return configArray[index - 2] + configArray[index] == configArray[index - 1];
  	else if(index % 4 == 2)
  			return configArray[index] + configArray[index - 1] + configArray[index - 2] == comparator;
  		else
  			return true;
  	}
    public boolean isGoal(){
      return true;
    }
  @Override
    public java.lang.String toString(){
      String temp =" ";
      for(int i=0;i<configArray.length;i++){
        if(i%3==0 && i!=0)
          temp+=BRIDGE_STR;
        temp += String.valueOf(configArray[i]);
        if(i<configArray.length)
          temp+=TRIAD_STR;

      }
    return temp.substring(0,temp.length()-1);
    }
}
