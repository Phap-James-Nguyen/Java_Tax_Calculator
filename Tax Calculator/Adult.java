public class Adult extends Person {
   
   private String employer;
   Taxation tax;

   public Adult(String name, String birthday, String ssn, float grossIncome, String employer) {
      super.setName(name);
      super.setBirthday(birthday);
      super.setSSN(ssn);
      super.setGrossIncome(grossIncome);
      this.employer = employer;
      
   }
   
   public String toString() {
      return super.toString() + super.getGrossIncome();
   }
   
   public float adjustedIncome() 
   {
      float AdjustedIncome;
      // return adjusted income of employed adult 
      //System.out.println(getGrossIncome());
      float ssTax = 0.0f;
      
      
      if(getGrossIncome() >= Taxation.getSocialSecurityIncomeLimit())
      {
         ssTax += Taxation.getSocialSecurityIncomeLimit() * (Taxation.getSocialSecurityRate() / 100.0f);
      
      }
      
      else if(getGrossIncome() < Taxation.getSocialSecurityIncomeLimit())
      {
         ssTax += getGrossIncome() * (Taxation.getSocialSecurityRate() / 100.0f);
      }
      
      
      
      float mdTax;
      mdTax = getGrossIncome() * (Taxation.getMedicareRate() / 100.0f);
      
      //float employer = (ssTax / 2) + (mdTax/2);
      float employee = (ssTax / 2) + (mdTax/2);
      
      AdjustedIncome = getGrossIncome() - employee;
      
      
      
      return AdjustedIncome;
   }
   
   /*public float taxWithheld() 
   {
      float result = 0.0f;
      if(getGrossIncome() <= 50000.0f)
      {
         result = (float)((getGrossIncome() * 0.1f));
      
      }
      
      else if(getGrossIncome() > 50000.0f && getGrossIncome() <= 100000.0f)
      {
         float subtract = (getGrossIncome()- 50000.0f) * 0.15f;
         result = (float)((subtract) + (50000.0f * 0.1f));
      
      }
      
      else
      {
         float subtract = ((getGrossIncome() - 150000.0f) * 0.2f);
         result = (float)((subtract) + (5000.0f) + (15000.0f)); 
      
      }
      
      
      return result; // % of gross income withheld
   }*/
   
   public float taxWithheld(){//CHANGE LATER
      float tax = 0.0f;
      if(getGrossIncome() <= 50000.0f){
         tax = getGrossIncome()*0.1f;
      } else if (getGrossIncome() <= 150000.0f) {
         tax = (50000*0.1f) + 0.15f*(getGrossIncome()-50000);
      } else if (getGrossIncome() > 150000.0f) {
         tax = (50000*0.1f) +15000 + 0.20f*(getGrossIncome()-150000);
      }
      return tax;
   }

   public float deduction(Family fam)
   {
      float result = 0.0f;
      float adjusted = adjustedIncome();
      float BaseEx = Taxation.getAdultBaseExemption();
      float e;
      float percentReduce = 0.0f;
      int hello;
      
      // check if it's a single-parent family
      //System.out.println("Adjusted:" + adjusted);
      if(fam.getNumChildren() >=1 && fam.getNumAdults() == 1)// each child exemption is reduced by 5%
      {
         BaseEx = BaseEx * 2;
      }
      //System.out.println("Base:" + BaseEx);
      
      if(adjusted > 100000.0f)
      {
         hello = (int)((adjusted - 100000.0f) / 1000.0f); // from the example given, this would give the 13 from 113478
         percentReduce = hello * 0.5f; // 13 * 0.005 = 0.065
         if(percentReduce > 30.0f)
         {
         percentReduce = 30.0f;
         }
      }
      
      
      
      
      //System.out.println("PercentReduce:" + percentReduce);
            
      
      e = BaseEx - (((0.5f* percentReduce)/100)*BaseEx);

      
      
      /*if(e >= adjusted)
      {
         e = adjusted; // if exemption is greater than adjusted income, set exemption equal to adjusted income
      
      }*/
      
      result = e;
      
      return result;
      
   
   
   
   }
   
   public String getEmployer()
   {
      return this.employer;
   }
   
   
   public static void main(String[] args) 
   {
      Person[] p = new Person[3];
      p[0] = new Adult("James", "1234/56/78", "123-45-6789", 113478, "Boss");
      p[1] = new Child("A", "1111/22/33", "111-22-3333", 100000.0f, "Fairfax High School", 200000.0f);
      p[2] = new Child("B", "2222/33/44", "444-55-6666", 100000.0f, "W High School", 200000.0f);
      //Family f = new Family(p,1);
      
      //p[0].deduction(f);
      
      //Adult A = (Adult) p[0]; // Has to cast as adult because p[0] is still a Person, even though it's storing Adult element
     // System.out.println(A.getGrossIncome());
      //System.out.println(A.adjustedIncome());
    
      //System.out.println(A.deduction(f));
   }
   
}




