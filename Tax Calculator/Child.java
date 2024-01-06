public class Child extends Person
{
   private String school;
   
   private float tuition;
   
   public Child(String name, String birthday, String ssn, float grossIncome, String school, float tuition)
   {
      super.setName(name);
      super.setBirthday(birthday);
      super.setSSN(ssn);
      super.setGrossIncome(grossIncome);
      this.school = school;
      this.tuition = tuition;
   
   }
   
   public String toString()
   {
      return super.toString() + " " + this.school;
   
   
   }
   
   public float getTuition()
   {
      return tuition;
   }
   
   public float deduction(Family fam)
   {
      float result = 0.0f;
      float gross = getGrossIncome();
      float BaseEx = Taxation.getchildBaseExemption(); // Taxation is static so you can get the methods
      float e;
      float numChildren = fam.getNumChildren();
      float reduce;
      float percentReduce;
      //float hello;
      
      // check if it's a single-parent family
   
      if(numChildren > 2)// each child exemption is reduced by 5%
      {
         percentReduce = 0.05f * (numChildren - 2);
      }
      
      else
      {
         percentReduce = 0.0f;
      }
      
      reduce = Math.min(percentReduce, 0.5f);
      e = BaseEx * (1 - reduce); // compute exemption
      
      if(e > gross)
      {
         e = gross; // if exemption is greater than gross, set exemption equal to adjusted income
      
      }
      
      result = e;
      
      return result;
      
   
   
   
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
      //System.out.println(A.getGrossIncome());
      //System.out.println(A.adjustedIncome());
    
      //System.out.println(A.deduction(f));
   }




}