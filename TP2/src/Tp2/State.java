 package Tp2;
 class State{
    private char approuvedChar;
    State(char c) {
      approuvedChar =c;
    }
    char getChar(){
      return approuvedChar;
    }
    boolean validate(char c){
      return c == approuvedChar;
    }
  }
