public class Person
{
   private int id = 0;
   private String name;
   private String birthday;
   private String ssn;
   private float grossIncome;
   private static int countObjects = 0;

   {
      countObjects += 1;
   
   }

   public Person()
   {
      
      id += countObjects;
   
   
   }

   

   public boolean setName(String n)
   {
      this.name = n;
      boolean b = false;
      char ch;
      for(int i = 0; i < n.length(); i++)
      {
         //boolean b;
         ch = n.charAt(i);
         if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' )
         {
            b = true;
         }
         else
         {
            b = false;
            break;
         }
      
         
      }
      return b;
   
   }

   public boolean setBirthday(String date)
   {
      this.birthday = date;
      boolean b = false;
      //System.out.println(date.length());
      if(date.length() != 10)
      {
         return b;
      }
      //date[1] 
      else
      {
         if(((date.charAt(4))) != '/' || ((date.charAt(7) != '/'))) 
         {
            return b;
         }
         
         else
         {
         
            for(int i = 0; i < date.length(); i++) // loop through each index of date indeces: 0-9
            {
               if(i == 4 || i == 7)
               {
                  continue;
               }
               if((int)(date.charAt(i)) >= 48 && (int)(date.charAt(i))<= 57) // ascii values
               {
                  b = true;
               }
            }
         }
      }
   
   
      
   
   
      return b;
   }

   public boolean setSSN(String ssn)
   {
      this.ssn = ssn;
      boolean b = false;
      //System.out.println(ssn.length());
      if(ssn.length() != 11)
      {
         
         return b;
      }
      
      else
      {
         if(((ssn.charAt(3))) != '-' || ((ssn.charAt(6) != '-'))) 
         {
            return b;
         }
         
         else
         {
         
            for(int i = 0; i < ssn.length(); i++) // loop through each index of ssn indeces: 0-9
            {
               if(i == 3 || i == 6)
               {
                  continue;
               }
               if((int)(ssn.charAt(i)) >= 48 && (int)(ssn.charAt(i))<= 57) // ascii values
               {
                  b = true;
               }
            }
         }
      }
   
   
   
      return b;
   
   
   }

   public boolean setGrossIncome(float g)
   {
      
      boolean b = false;
      if(g >= 0.00)
      {
         this.grossIncome = g;
         b = true;
      }
      
      
      return b;
   
   }
   
   
   public float getGrossIncome()
   {
      return grossIncome;
   
   }
   
   public int getId()
   {
      return id;
   
   }
   
   public String getYear() // helper method to get the String of year i.e last four digit
   {
      String y = "";
      if(setBirthday(birthday) == true) // format : YYYY/MM/DD
      {
         y = birthday.substring(0,4);
      
      
      }
   
      return y;
   }
   
   public String getLastFourSSN() // helper method
   {
      String f = "";
      if(setSSN(ssn) == true) // format : YYYY/MM/DD
      {
         f = ssn.substring(7,11);
      
      
      }
   
      return f;
   } 
   
   
   
   
   public String toString()
   {
      String x = "";
      
      x += this.name + " xxx-xx-" + getLastFourSSN() + " " + getYear() + "/**/**";
      
      return x;
   
   
   }
   
   public float deduction(Family f)
   {
      return 0.0f;
   }
  
  
  
  

   /*public static void main(String[] args) 
   {
   
      Person temp = new Person();
          //System.out.println(temp.setName("Hel  ,lo"));
      temp.setName("Hello");
      System.out.println(temp.setBirthday("1134967/09"));
          //System.out.println(temp.setSSN("123-45-6789"));
          
      Person test = new Person();
      
   }*/
   
   

}

