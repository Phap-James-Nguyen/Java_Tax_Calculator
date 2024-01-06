public class test{
   public static void main(String[] args) 
   {
   
      /*Person temp = new Person();
          //System.out.println(temp.setName("Hel  ,lo"));
      //temp.setName("Hello");
      //System.out.println(temp.setBirthday("1134967/09"));
          //System.out.println(temp.setSSN("123-45-6789"));
          
      Person p2 = new Person();
      p2.setName("James");
      p2.setBirthday("1234/56/78");
      p2.setSSN("123-45-6789");
      p2.setGrossIncome(1.23f);
      System.out.println(p2.getId());
      System.out.println(p2.toString());
      
      
      Person p3 = new Person();
      System.out.println(p3.getId());
      Person p4 = new Person();
      System.out.println(p4.getId());*/
      
      Adult a1 = new Adult("name1", "1232/02/22", "987-65-4320", 0.00f, "GMU");
      Adult a2 = new Adult("name2", "1332/02/22", "987-65-4321", 1234.56f, "GMU");
      Adult a3 = new Adult("name3", "1432/02/22", "987-65-4322", 13456.78f, "GMU");
      Adult a4 = new Adult("name4", "1572/02/22", "987-65-4323", 23979.54f, "GMU");
      Adult a5 = new Adult("name5", "1632/02/22", "987-65-4324", 67890.12f, "GMU");
      Adult a6 = new Adult("name6", "1732/02/22", "987-65-4325", 123456.78f, "GMU");
      Adult a7 = new Adult("name7", "1876/05/01", "789-56-1236", 145000.98f, "Mason");
      Adult a8 = new Adult("name8", "1932/02/22", "987-65-4327", 267890.12f, "GMU");
      Adult a9 = new Adult("name9", "2032/02/22", "987-65-4328", 312346.78f, "GMU");
      Child c1 = new Child("kid1", "1200/01/01", "999-65-1110", 0.0f, "FHS", 3300.0f);
      Child c2 = new Child("kid2", "1300/01/01", "999-65-1111", 100.0f, "FHS", 0.0f);
      Child c3 = new Child("kid3", "1400/01/01", "999-65-1112", 300.0f, "FHS", 0.0f);
      Child c4 = new Child("kid4", "1500/01/01", "999-65-1113", 900.0f, "FHS", 900.0f);
      Child c5 = new Child("kid5", "1600/01/01", "999-65-1114", 1600.0f, "FHS", 1234.0f);
      Child c6 = new Child("kid6", "1700/01/01", "999-65-1115", 7300.0f, "FHS", 6650.0f);
      Child c7 = new Child("kid7", "1800/01/01", "999-65-1116", 12000.0f, "FHS", 11999.0f);
      Child c8 = new Child("kid8", "1900/01/01", "999-65-1117", 27000.0f, "FHS", 100.0f);
      Child c9 = new Child("kid9", "2000/01/01", "999-65-1118", 41560.0f, "FHS", 8765.0f);
      //System.out.println();
     
      Family f1 = new Family((byte)2, (byte)3); // test case 1
      f1.addMember(a1);
      f1.addMember(c1);
      f1.calculateTax();
      
      //System.out.println(a1.adjustedIncome()); // --> 0.0
      //System.out.println(a1.deduction(f1)); // --> 0.0
      System.out.println("aksljdfl;asjdkjf;as");
      System.out.println(f1.getTaxableIncome());
      //System.out.println(f1.calculateTax());
      
      
      Family f2 = new Family((byte)4, (byte)2);
      f2.addMember(a2);
      f2.addMember(a3);
      f2.addMember(c2);
      f2.addMember(c3);
      //f2.calculateTax();
      //System.out.println(f2.getTaxableIncome()); // -->7567.453
      System.out.println(f2.getTaxableIncome());
      System.out.println(f2.calculateTax());
      
      /*System.out.println(a2.deduction(f2));
      System.out.println(a3.deduction(f2));
      System.out.println(c2.deduction(f2));
      System.out.println(c3.deduction(f2));*/
      //System.out.println(a2.deduction(f2)); // -->3000
      //System.out.println(a3.deduction(f2));
      //System.out.println(f2.taxCredit()); // -->210.0
      
      Family f3 = new Family((byte)3, (byte)2);
      f3.addMember(a4);
      f3.addMember(a5);
      f3.addMember(c4);
      f3.calculateTax();
      //System.out.println(a5.deduction(f3));// --> 3000.0 
      //System.out.println(f3.getTaxableIncome());
      
      Family f4 = new Family((byte)6, (byte)2);
      f4.addMember(a6);
      f4.addMember(a7);
      f4.addMember(c5);
      f4.addMember(c6);
      f4.addMember(c7);
      f4.addMember(c8);
      f4.calculateTax();
      //System.out.println(a7.taxWithheld());
      //System.out.println(c6.deduction(f4));
     // System.out.println(c5.deduction(f4));
      //System.out.println(f4.getTaxableIncome());// -->283633
      //System.out.println(f4.taxCredit());// -->
      
      
      //System.out.println(a6.adjustedIncome()); // --> 114012.336 WORKS 
      //System.out.println(a6.taxWithheld()); // --> 16018.518
      //System.out.println(a6.deduction(f4)); // --> 0.0
   
      Family f5 = new Family((byte)2, (byte)2);
      f5.addMember(a8);
      f5.addMember(a9);
      f5.calculateTax();
      //System.out.println("HELLLLLLOO");
      //System.out.println(a8.deduction(f5));
      
      Family f6 = new Family((byte)1, (byte)1);
      f6.addMember(c9);
      
      
      /*System.out.println(f2.calculateTax());
      System.out.println(f3.calculateTax());
      System.out.println(f4.calculateTax());
      System.out.println(f5.calculateTax());
      System.out.println(f6.calculateTax());*/
      
     /* TaxYear y = new TaxYear(100);
      y.taxFiling(f1); // returns true
      y.taxFiling(f2); // returns true
      y.taxFiling(f3); // returns true
      y.taxFiling(f4); // returns true
      y.taxFiling(f5); // returns true
      y.taxFiling(f6); // returns false
      y.numberOfReturnsFiled(); // returns 5
      y.numberOfPersonsFiled(); // returns 17
      y.taxWithheld(); // returns 142866.65
      y.taxOwed(); // returns 216255.72
      y.taxDue(); // returns 73119.06
      y.taxCredits(); // returns 270.0 */
      
      
   }
}