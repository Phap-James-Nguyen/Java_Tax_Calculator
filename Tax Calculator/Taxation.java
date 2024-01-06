import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Taxation
{
   private static float socialSecurityRate = 12.4f;
   private static float socialSecurityIncomeLimit = 137700.0f;
   private static float medicareRate = 2.9f;
   private static float adultBaseExemption = 3000.0f;
   private static float childBaseExemption = 2000.0f;
   private static float medianIncomePerCapita = 31099.0f;
   
   private static float [][] incomeBrackets = {{0.0f,10000.0f},{0.0f, 20000.0f},{0.0f,30000.0f},
                                          {10000.01f,40000.0f},{20000.01f,70000.0f}, {12000.01f,44000.0f},
                                          {40000.01f, 80000.0f},{70000.01f,160000.0f},{44000.01f, 88000.0f},
                                          {80000.01f,160000.0f},{160000.01f,310000.0f},{88000.01f,170000.0f},
                                          {160000.01f, Float.MAX_VALUE},{310000.01f, Float.MAX_VALUE},{170000.01f, Float.MAX_VALUE}};
                                          
                                 
   private static int [][] taxRates =     {{10},{10},{10},
                                          {12},{12}, {12},
                                          {22},{23},{24},
                                          {24},{25},{26},
                                          {32},{33},{35}};
      
   
                                    
   
   
   /*public Taxation()
   {
      this.socialSecurityRate = 12.4f;
      this.socialSecurityIncomeLimit = 137700.0f;
   }*/

   public static float getSocialSecurityRate() {
      return socialSecurityRate;
   }

   public static float getMedicareRate() {
      return medicareRate;
   }

   public static float getSocialSecurityIncomeLimit() {
      return socialSecurityIncomeLimit;
   }

   public static float getAdultBaseExemption() {
      return adultBaseExemption;
   }
   
   public static float getchildBaseExemption() {
      return childBaseExemption;
   }
   
   public static float medianIncomePerCapita() {
      return medianIncomePerCapita;
   }
 
   
   public static void loadParameters(String filename)
   {
      String[] hello = new String[6];
      //int counter = 0;
      String name;
      float value;
      try
      {
         Scanner s = new Scanner(new File(filename));
         for(int i = 0; i < 6; i ++) // loop through the 6 lines
         {
            hello[i] = s.next(); // load all the strings of input file into each array memory
                                 // hello is now an array of strings with 6 memory locations
         
         }
         
         for(int i = 0; i < hello.length; i++)
         {
            String[] split = hello[i].split(" ");
            name = split[0];
            value = (float)(Integer.parseInt(split[0]));
            switch (name) {
               case "medicareRate":
                  Taxation.medicareRate = value;
                  break;
               case "medianIncomePerCapita":
                  Taxation.medianIncomePerCapita = value;
                  break;
               case "socialSecurityIncomeLimit":
                  Taxation.socialSecurityIncomeLimit = value;
                  break;
               case "adultBaseExemption":
                  Taxation.adultBaseExemption = value;
                  break;
               case "childBaseExemption":
                  Taxation.childBaseExemption = value;
                  break;
               case "socialSecurityRate":
                  Taxation.socialSecurityRate = value;
                  break;
            
            } 
         
         
         }
      
      }
      
      catch(FileNotFoundException e) 
      {
         System.out.println("Error");
      }
   }
   
   /*public static int getHighestBracketRange(int bracket, int fillingStatus) // helper method to get the highest value of an array
   {
      //float famTaxableIncome = f.getTaxableIncome();
      //bracket = row
      // fillingStatus = col
      
      return incomeBrackets[bracket][fillingStatus][1]; // [bracket][fillingStatus][1] is the highest value in the inner array range
      
      
   
   }*/
   
   
   public static float bracketIncome(Family f, int b)
   {
      //Returns the portion of a family’s taxable
      //income that falls within bracket b.
      //Bracket numbering starts from 1.
      //bracket b = row
      // fillingStatus = col
      float result = 0.0f;
      int status = f.getFilingStatus();
      float famTaxableIncome = f.getTaxableIncome();
      int familyTaxBracket = Taxation.maxIncomeTaxBracket(f);
      
      if(status == 1)
      {
         if(familyTaxBracket == 1) 
         {result = 0.0f;}
         
         if(familyTaxBracket == b)// Family Taxable income falls within the range of bracket parameter b
         {
            
            result = famTaxableIncome - incomeBrackets[b - 1][status][1]; // [bracket][fillingStatus][1] is the highest value in the inner array range
         
         }
         
         if(familyTaxBracket > b)// Family Taxable income is higher than the range of bracket parameter b
         {
            
            result = famTaxableIncome - incomeBrackets[b][status][0];
         
         }
         if(familyTaxBracket < b)// Family Taxable income is lower than the range of bracket parameter b
         {
            
            result = 0.0f;
         
         }
      }
      
      return result;
     
   
   
   
   
   }
   
   public static float bracketTaxRate(int b, int f)
   {
      float result = 0.0f;
      if(f == 1)
      {
         if(b == 1)
         {
            result = 10.0f;
         }
         if(b == 2)
         {
            result = 12.0f;
         }
         if(b == 3)
         {
            result = 22.0f;
         }
         if(b == 4)
         {
            result = 24.0f;
         }
         if(b == 5)
         {
            result = 32.0f;
         }
      
      
      }
      if(f == 2)
      {
         if(b == 1)
         {
            result = 10.0f;
         }
         if(b == 2)
         {
            result = 12.0f;
         }
         if(b == 3)
         {
            result = 23.0f;
         }
         if(b == 4)
         {
            result = 25.0f;
         }
         if(b == 5)
         {
            result = 33.0f;
         }
      
      
      }
      
      if(f == 3)
      {
         if(b == 1)
         {
            result = 10.0f;
         }
         if(b == 2)
         {
            result = 12.0f;
         }
         if(b == 3)
         {
            result = 24.0f;
         }
         if(b == 4)
         {
            result = 26.0f;
         }
         if(b == 5)
         {
            result = 35.0f;
         }
      
      
      }
      
      return result;
   
   
   }


   public static byte getNumTaxBrackets()
   {
      return (byte)(incomeBrackets.length / 3);
   
   
   }
   
   public static int maxIncomeTaxBracket(Family fam)//returns the maximum tax bracket that a family’s income is in
   {
      int bracket = 0;
      int BracketRow = 0;
      float familyTaxableIncome = fam.getTaxableIncome();
      int status = fam.getFilingStatus();
      
      if(status == 1)
      {
         for(int row = 0; row < getNumTaxBrackets(); row++)
         {
            if(familyTaxableIncome > incomeBrackets[row][0] && familyTaxableIncome <= incomeBrackets[row][0])
            
               BracketRow = row; 
            
         }
         
      }
      
      
      
   
      if(status == 2)
      {
         for(int row = 0; row < getNumTaxBrackets(); row++)
         {
            if(familyTaxableIncome > incomeBrackets[row][1] && familyTaxableIncome <= incomeBrackets[row][1])
            {
               BracketRow = row; 
            
            }
         
         }
      
      
      }
   
      if(status == 3)
      {
         for(int row = 0; row < getNumTaxBrackets(); row++)
         {
            if(familyTaxableIncome > incomeBrackets[row][2] && familyTaxableIncome <= incomeBrackets[row][2])
            
               BracketRow = row; 
            
         }
         
      }
      
      
      
      
      if(BracketRow == 0){bracket = 1;}
      if(BracketRow == 1){bracket = 2;}
      if(BracketRow == 2){bracket = 3;}
      if(BracketRow == 3){bracket = 4;}
      if(BracketRow == 4){bracket = 5;}
      
      return bracket;
   
   }
   
   //bracketIncome(Family, int b) 
   
   //bracketTaxRate(int b, int f) 

   public static void main(String[] args) 
   {
      /*Person[] p = new Person[3];
      p[0] = new Adult("James", "1234/56/78", "123-45-6789", 113478, "Boss");
      p[1] = new Child("A", "1111/22/33", "111-22-3333", 100000.0f, "Fairfax High School", 200000.0f);
      p[2] = new Child("B", "2222/33/44", "444-55-6666", 100000.0f, "W High School", 200000.0f);*/
      //Family f = new Family(p,1);
      
      //System.out.println(maxIncomeTaxBracket(f));
      
      //p[0].deduction(f);
      
      //Adult A = (Adult) p[0]; // Has to cast as adult because p[0] is still a Person, even though it's storing Adult element
     // System.out.println(A.getGrossIncome());
      //System.out.println(A.adjustedIncome());
    
      //System.out.println(A.deduction(f));
   
      Adult a4 = new Adult("name4", "1572/02/22", "987-65-4323", 23979.54f, "GMU");
      Adult a5 = new Adult("name5", "1632/02/22", "987-65-4324", 67890.12f, "GMU");
      Child c4 = new Child("kid4", "1500/01/01", "999-65-1113", 900.0f, "FHS", 900.0f);
   
      Family f3 = new Family((byte)3, (byte)2);
      f3.addMember(a4);
      f3.addMember(a5);
      f3.addMember(c4);
      //f3.calculateTax();
      //System.out.println(" Taxable Income: " + f3.getTaxableIncome());
   
      //System.out.println(" Max Tax Bracket: " + maxIncomeTaxBracket(f3)); // --> bracket 3
   
   
   
   
   
   }

}