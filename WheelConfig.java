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
   static final java.lang.String BRIDGE_STR="-";
    //@param EMPTY_CELL
   static int EMPTY_CELL=0;
    //@param TRIAD_CELL
   static int TRIAD_CELL=3;
    //@param TRIAD_STR
   static java.lang.String TRIAD_STR=".";
    //Constructs an initial number wheel puzzle from an input file whose format is: #_triads bridge1_value bridge2_value...A
   public WheelConfig(java.lang.String filename)throws java.io.FileNotFoundException{
        String content=" ";
       try{
            BufferedReader  reader = new BufferedReader(new FileReader(filename));
           while((content = reader.readLine())!=null){

           }
        }catch(java.io.IOException file){
           System.out.print(file);
       }
    }
    //Copy constructor. Takes an incoming config and makes a complete deep copy of its attributes.
    public WheelConfig(WheelConfig config){

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
        return " ";
    }
}
