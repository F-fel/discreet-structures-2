package Tp2;

import java.util.ArrayList;
public class Automate {
  private State[] states;
  Automate( State[] stateList){
    states = stateList;
  }
  Automate(String s){
    states = new State[s.length()];
    int i=0; //index
    for(char c : s.toCharArray() ){
      states[i++]=new State(c);
    }
  }
  public ArrayList<String> filter(String[] data){
    ArrayList<String> retval = new ArrayList<>();
    for(String s : data){
      if(s.length() >= states.length){
        char[] sArray  = s.toCharArray();
        int i = 0; //index
        while(states[i].validate(sArray[i])){
          i++;
          if(i == states.length){
            retval.add(s);
            break;
          }
        } 
      }
    }//end for
    return retval;
  }
}
