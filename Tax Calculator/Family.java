public class Family 
{
   private byte numMembers;
   private byte filingStatus;
   Person[] members; // array of Person objects. Person array contains objects that extends it. ie Adult and Child
   
   Family(byte numMembers, byte filingStatus)
   {
      this.filingStatus = filingStatus;
      this.numMembers = numMembers;
      this.members = new Person[numMembers];
   
   
   }
   
   
   public void addMember(Person p)
   {
      Person[] temp = new Person[members.length + 1];
      for(int i = 0; i < members.length; i++)
      {
         temp[i] = members[i];
      
      
      }
      
      temp[members.length] = p;
      this.members = temp;
      
      
   
   }
   
   public int getNumAdults()
   {
      int adult = 0;
      for(int i = 0; i < members.length; i++)
      {
         if(members[i] instanceof Adult)
         {
            adult +=1;
         
         }
      
      }
      
      return adult;
   
   }
   
   
   public int getNumChildren()
   {
      int c = 0;
      for(int i = 0; i < members.length; i++)
      {
         if(members[i] instanceof Child)
         {
            c +=1;
         
         }
      
      }
      
      return c;
   
   }
      
   public int getFilingStatus()
   {
      return filingStatus;   
   }
   
   public float getTaxableIncome() // MIGHT NEED SOME FIXING whole family income --> 
   {
      //Family f = new Family(this.members,this.filingStatus);
      float result = 0.0f;
      float adjusted = 0.0f;
      float gross = 0.0f;
      float adultDeductible = 0.0f;
      float childDeductible = 0.0f;
      float AdultRes = 0.0f;
      float ChildRes = 0.0f;
      for(int i = 0; i < members.length; i++)
      {
         if(members[i] instanceof Adult)
         {
            //Adult a = (Adult) members[i];
            adjusted += ((Adult)(members[i])).adjustedIncome();
            adultDeductible += ((Adult)(members[i])).deduction(this);
         }
         
         else if(members[i] instanceof Child)
         {
            //Child c = (Child) members[i];
            gross +=  ((Child)(members[i])).getGrossIncome();
            childDeductible += ((Child)(members[i])).deduction(this); //this refers to the object user c
         
         }
      }
      /*System.out.println("LINE MARKINGS");
      System.out.println(adjusted);
      System.out.println(gross);*/
      AdultRes = adjusted - adultDeductible;
      ChildRes = gross - childDeductible;
      /*System.out.println("LINE MARKINGS");
      System.out.println(AdultRes);
      System.out.println(ChildRes);*/
      return AdultRes + ChildRes;
   
   }
   
   public float taxCredit() // return family taxCredit
   {
      //Family f = new Family(this.members,this.filingStatus);
   
      float result = 0.0f;
      float credit = 0.0f; // adult credit
      int wholeThousand = 0;
      float totalChildTuition = 0.0f;
      float FileSeparately = 0.0f;
   
      float taxableIncome = getTaxableIncome();
      
      for(int n = 0; n < members.length; n++) // calculating child taxCredit
      {
         if(members[n] instanceof Child)
         {
            Child temp = (Child) members[n];
            if(temp.getTuition() < 1000.0f)
            {
               totalChildTuition += temp.getTuition(); 
            }
            else
            {
               totalChildTuition += 1000.0f; 
            }
         
         }
      
      
      }
      if(filingStatus == 3 && taxableIncome < Taxation.medianIncomePerCapita() * 0.5f)
      {
         for(int n = 0; n < members.length; n++)
         {
            if(members[n] instanceof Adult)
            {
               Adult separate = (Adult) members[n];
               FileSeparately = separate.adjustedIncome() - members[n].deduction(this); // get the taxable income of adult
               if(FileSeparately < Taxation.medianIncomePerCapita() * 0.5)
               {
                  wholeThousand = (int)(taxableIncome / 1000);
                  credit += (float)(wholeThousand * 15.0f);
               
               }
            
            }
         
         }
      
      }
      if(taxableIncome < Taxation.medianIncomePerCapita() * 0.5f)
      {
         wholeThousand = (int)(taxableIncome / 1000);
         credit = (float)(wholeThousand * 30.0f);
         
      }
      
      result = totalChildTuition + credit;
       
      if(result > 2000.0f){result = 2000.0f;}
      
     
      
      
      return result;
      
      
      //System.out.println(taxableIncome);
      
   
   }
   
   public float calculateTax()
   {
      float taxableIncome = getTaxableIncome(); // 1. Calculate the taxable income
      int taxBracket = Taxation.maxIncomeTaxBracket(this); //2. Find the maximum tax bracket that the taxable income corresponds to
      //System.out.println(taxBracket);
      int status = this.getFilingStatus();

      //3. Sum the amounts of tax that correspond to each tax bracket up to the maximum tax bracket. 
      //This is the total calculated tax
      
      float totalCalculateTax = Taxation.bracketIncome(this, taxBracket) * Taxation.bracketTaxRate(taxBracket, status);
      float FamilyTaxCredit = this.taxCredit(); // 4.Calculate the tax credit and subtract it from the total calculated tax
      

      float beforeWithHeld = totalCalculateTax - FamilyTaxCredit;
      float taxWithheld = 0.0f;
      float afterWithheld = 0.0f;

      for(int i = 0; i < members.length; i++)
      {
         if(members[i] instanceof Adult)
         {
            taxWithheld += ((Adult) members[i]).taxWithheld();
         }

      }
      afterWithheld += beforeWithHeld - taxWithheld; //5. Finally, subtract any taxes that were withheld during payroll
      return afterWithheld;
   
   
   }
   
   public static void main(String[] args) 
   {
      Person[] p = new Person[3];
      p[0] = new Adult("James", "1234/56/78", "123-45-6789", 113478, "Boss");
      p[1] = new Child("A", "1111/22/33", "111-22-3333", 100000.0f, "Fairfax High School", 200000.0f);
      p[2] = new Child("B", "2222/33/44", "444-55-6666", 100000.0f, "W High School", 200000.0f);
      /*Family f = new Family(p,1);
      System.out.println(f.getTaxableIncome());
      System.out.println(f.taxCredit());
      p[0].deduction(f);*/
      
      //Adult A = (Adult) p[0]; // Has to cast as adult because p[0] is still a Person, even though it's storing Adult element
      //System.out.println(A.getGrossIncome());
      //System.out.println(A.adjustedIncome());
    
      //System.out.println(A.deduction(f));
   }

   
   
   
   

}