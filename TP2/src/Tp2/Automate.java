package Tp2;

 class Automate {
  private State[] states;
  Automate(){
      states  =null;
  }
  Automate(String s){
    states = new State[s.length()];
    int i=0; //index
    for(char c : s.toCharArray() ){
      states[i++]=new State(c);
    }
  }
  Automate(ObjectType t){
      states = new State[]{new State(t.asChar())};
  }

     /**
      * reconnait si un String est dans le langage
      * @param s String to be checked
      * @return true if the String is recognised in it's language
      */
     private boolean validate(String s) {
      if (s.length() >= states.length) {
          char[] sArray = s.toCharArray();
          int i = 0; //index
          while (states[i].validate(sArray[i])) {
              i++;
              if (i == states.length) {
                  return true;
              }
          }
      }
      return false;
  }
  Entrepot filterByName(Entrepot e){
      Entrepot retval = new Entrepot();
      for(Objet o : e ){
          if(validate(o.getName()))
              retval.add(o);
      }
      return retval;
  }
  Entrepot filterByHex(Entrepot e){
      Entrepot retval = new Entrepot();
      for(Objet o : e ){
          if(validate(o.getID().toString()))
              retval.add(o);
      }
      return retval;
  }
  Entrepot filterByType(Entrepot e){
      Entrepot retval = new Entrepot();
      for(Objet o : e ){
          if(validate(o.getType().toString()))
              retval.add(o);
      }
      return retval;
  }
  boolean isNull(){return states==null;}
}
