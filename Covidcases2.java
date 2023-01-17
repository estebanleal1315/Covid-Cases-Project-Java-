import java.util.*;
public class Covidcases2{ //open whole program//
  public static int[] gCases; //array//
  public static int gNumberCases; //size of array//
  public static void main(String []args){
    
    Scanner ginput = new Scanner(System.in);
    System.out.println("UTSA - Summer - 2021 - CS1083 - Project 2 - CovidCases - written by Esteban Leal-"); 
    System.out.print("Please enter the number of cases");
    gNumberCases = ginput.nextInt(); //number of cases input//
    gCases = new int[gNumberCases]; //array size which is same as # of cases//
    System.out.println(gNumberCases);
    System.out.println();
    int num;
    
    Boolean quit = false; //set condition of when to quit//
    while(quit == false){//states that program runs unless told to quit, option 0//
      System.out.println("MAIN MENU");
      System.out.println("0 - Exit, 1 - List , 2 - Report, 3 - Add/Modify Case, 4 - Swap Cases");
      System.out.println("Select an option : ");
      
      num = ginput.nextInt();//initializes varibale numbers//
      
      if(num == 0){//quits program//
        System.out.println("Than you for using the Covid Cases program! Bye!");
        quit = true;
      }
      else if(num == 1){//commands to list cases by case number and age//
        listCases();
      }
      else if(num == 2){//shows number of cases by age group//
        report();
      }
      else if(num == 3){//lets you modify case by case number and changing age//
        addModifyCases();
      }
      else if(num == 4){//swaps cases//
        swapCases();
      }
      else{//missinput//
        System.out.println("Value out of range, please try again");
        System.out.println();
      }
    }
  }
  public static void addModifyCases(){//MODIFY CASES CODE STARTS//
    Scanner gInput = new Scanner(System.in);
    Boolean aux3 = false;//tells code when index is not within range.//
    Boolean aux4 = false;//tells code negative number for age is not allowed//
    while(aux3 == false){//while loop when index is within range//
      System.out.println("Enter the index (0 to " + (gNumberCases -1) + ")");
      int index = 0;
      index = gInput.nextInt();
      if((0 <= index) && (index < gNumberCases)){
        while(aux4 == false){//while loop when age is not negative//
          System.out.println("Enter the age (in years) you want to assign (greater than zero) : ");
          int age = 0;
            age = gInput.nextInt();
            if(age > 0){
              gCases[index] = age;
              aux3 = true;
              aux4 = true;//when true, ends the while loops//
              System.out.println();
            }
            else{
              System.out.println("Age has to be greater than or equal to zero, please try again");
            }
        }//bracket closses off boolean aux4(non negative age)//
      }
      else{
        System.out.println("Index is out of range, please try again");
      }
    } //bracket closes off boolean aux3(within index)//
  }
  public static void listCases(){//lists cases//
    System.out.println("LIST OF CASES");
    for(int t = 0; t < gNumberCases; t++){//tells code to list every case number and the age//
      System.out.println("Case[" + t + "] : " + gCases[t]);
    }
    System.out.println();
  }
  public static void report(){//case reports//
    System.out.println("CASES REPORT");
    String classification;//opens string for classfication//
    classification = "Elderly";   //classification states what classification case number it will display, pulls from getCasesByClass//
    System.out.println("Elderly: " + getCasesByClass(classification));
    classification = "Adult";
    System.out.println("Adult: " + getCasesByClass(classification));
    classification = "Teen";
    System.out.println("Teen: " + getCasesByClass(classification));
    classification = "Child";
    System.out.println("Child: " + getCasesByClass(classification));
    classification = "N/A";
    System.out.println("N/A: " + getCasesByClass(classification));
    System.out.println();
  }
  public static int getCasesByClass(String classification){//opens string for classification//
    int counter = 0;
    if(classification == "Elderly"){
      for(int i = 0; i < gNumberCases; i++){
        if(gCases[i] >= 60){//counts every case of 60 or greater//
        counter++;
      }
    }
  }
    else if(classification == "Adult"){
      for(int i = 0; i < gNumberCases; i++){
        if((20 <= gCases[i]) && (gCases[i] < 60)){//counts every case of between 20 and 59//
          counter++;
        }
      }
    }
    else if(classification == "Teen"){
      for(int i = 0;i < gNumberCases; i++){
        if((12 <= gCases[i]) && (gCases[i] < 20)){//counts every case of 12 to 19//
          counter++;
        }
      }
    }
    else if(classification == "Child"){
     for(int i = 0; i < gNumberCases ; i++){
       if((1 <= gCases[i]) && (gCases[i]< 12)){//counts every case of 1 to 11//
         counter++;
       }
     }
   }
    else if(classification == "N/A"){//counts every case of 0, or cases where age has not been determined//
     for(int i = 0; i < gNumberCases ; i++){
       if(gCases[i] == 0){
         counter++; //counter will repeat the counting of the cases until it has finished counting every specific age class within its own class//
       }
     }
   }
    return counter;//returns counter to each counter//
  }
  public static void swapCases(){//swap cases code//
    Scanner gInput = new Scanner(System.in);
    Boolean range1 = false;//states to re-enter when input is out of range//
    int idxFrom = 0;//first index variable to switch//
    int idxTo = 0; //second index variable to change//
    while(range1 == false){
      System.out.println("Enter the index (0 to " + (gNumberCases -1 ) + ")");
      int auxrange1 = gInput.nextInt();//auxrange is cases present//
      if((0 <= auxrange1) && (auxrange1 < gNumberCases)){
        idxFrom = auxrange1;//chooses first variable//
        range1 = true;//stays within range//
      }
      else{//out of range//
        System.out.println("Value out of range, please try again");
      }
    }
    Boolean range2 = false;//states if values are not the same//
    Boolean range3 = false;//within range//
    while(range2 == false){
      while(range3 == false){
        System.out.println("Enter the index (0 to " + (gNumberCases - 1) + ") that is not " + idxFrom);
        int auxrange2 = gInput.nextInt();
        if((0 <= auxrange2) && (auxrange2 < gNumberCases)){
          idxTo = auxrange2;
          range3 = true;//states one index in to code//
        }
        else{//if number is not in range, resets while loop//
          System.out.println("Value out of range, please try again");
        }
      }
      if(idxFrom != idxTo){//if both variables are different and within range//
        swapValues(idxFrom, idxTo);
        range2 = true;
      }
      else{
        System.out.println("The index from and the index to should be different");
        range2 = false;//when both ranges are false, numbers are the same//
        range3 = false;
      }
    }
    System.out.println();
  }
  public static void swapValues(int f, int t){//swap values//
    int aux = gCases[f];//initializes values//
    int aux2= gCases[t];
    gCases[f] = aux2;//swaps values//
    gCases[t] = aux;
  }
}