package HT_Java;

import java.util.Scanner;
interface Sport{
	 void calculateAvgAge(int[] age);
	 void retirePlayer(int id);	
	 //void playerTransfer(int fromClubid , int toClubid);
	}
class Cricket implements Sport{
    
    public void calculateAvgAge(int[] age)
    {
        int sum =0 ;
        for(int a :age)
        {sum+=a;}
        double avg =(double) sum/ age.length;
        double roundavg = Math.round(avg * 100.0)/100.0;
        
        System.out.print("The average age of the team is "+roundavg);
        System.out.print("\n");
    }
    
    public void retirePlayer(int id)
    {
        System.out.print("that is is"+id);
    }
     
    public void playerTransfer(int fromClubid , int toClubid)
    {
         System.out.print("from id "+fromClubid +"to id"+ toClubid);
    }
    
}
class Football implements Sport{
    public void calculateAvgAge(int[] age)
   {
       int sum =0 ;
       for(int a :age)
       {sum+=a;}
       double avg =(double) sum/ age.length;
       double roundavg = Math.round(avg * 100.0)/100.0;
       
       System.out.print("The average age of the team is "+roundavg);
       System.out.print("\n");
   }
   
   public void retirePlayer(int id)
   {
       System.out.print("that is is"+id);
   }
   
   public void playerTransfer(int fromClubid , int toClubid)
   {
        System.out.print("from id "+fromClubid +"to id"+ toClubid);
   }
   
}
/*
Write the implementation of the Cricket and Football classes
*/
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  Scanner sc = new Scanner(System.in);

		  Cricket c = new Cricket();
		  Football f = new Football();

		  int[] age1 = new int[11];
		  int[] age2 = new int[11];

		  for(int i = 0; i < 2; i++)
		   {
		    String[] age = sc.nextLine().split(" ");
		    if(i == 0){
		    int j = 0;
		    for(String s : age)
		     age1[j++] = Integer.parseInt(s);
		    }
		    else{
		     int j = 0;
		     for(String s : age)
		      age2[j++] = Integer.parseInt(s);	
		    }
		   }
		   System.out.print("A new cricket team has been formed \n");
		   System.out.print("A new football team has been formed \n");
		   c.calculateAvgAge(age1);
		   f.calculateAvgAge(age2);

		   for(int i = 0; i < 6; i++){
		   
		   if(i < 3){
		    int x = Integer.parseInt(sc.nextLine());

		    c.retirePlayer(x);
		   }
		   else if(i < 5){
		    int x = Integer.parseInt(sc.nextLine());
		    f.retirePlayer(x);	
		   }
		   else {
		   	String[] temp = sc.nextLine().split(" ");  
		   	f.playerTransfer(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		  }	
		 }
	}

}
