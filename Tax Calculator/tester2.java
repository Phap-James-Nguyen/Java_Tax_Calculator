public class tester2
{
   public static void main(String[] args){
   
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
      Family f2 = new Family((byte)4, (byte)2);
      f2.addMember(a2);
      f2.addMember(a3);
      f2.addMember(c2);
      f2.addMember(c3);
      Family f3 = new Family((byte)3, (byte)2);
      f3.addMember(a4);
      f3.addMember(a5);
      f3.addMember(c4);
      f3.calculateTax();
      Family f4 = new Family((byte)6, (byte)2);
      f4.addMember(a6);
      f4.addMember(a7);
      f4.addMember(c5);
      f4.addMember(c6);
      f4.addMember(c7);
      f4.addMember(c8);
      f4.calculateTax();
      Family f5 = new Family((byte)2, (byte)2);
      f5.addMember(a8);
      f5.addMember(a9);
      f5.calculateTax();
      
      //System.out.println(a2.deduction(f2));
      //System.out.println(a2.adjustedIncome());
      System.out.println();
      System.out.println(f1.getTaxableIncome());
      System.out.println(f2.getTaxableIncome());
      System.out.println(f3.getTaxableIncome());
      System.out.println(f4.getTaxableIncome());
      System.out.println(f5.getTaxableIncome());
   
   
   
   
   }

}