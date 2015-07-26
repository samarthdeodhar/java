package JavaFundamentals;

public class EqualsAndEqualEqual {
	
	 public static void main(String[] args) {
		 
		   String s1 ="abc";
		   String s2 = s1;
		   String s3 = new String("abc");
		   String s4 = new String("abc");
		   String s5 = "abc";
		 
		  
		   System.out.println("== comparison : " + (s1 == s5));		 
		   System.out.println("== comparison : " + (s1 == s2));
		   System.out.println("Using equals method : " + s1.equals(s2));
		   
		   System.out.println("String.valueOf(s3==s4) : " + String.valueOf(s3==s4));
		   System.out.println("Using equals method s3.equals(s4) : " + s3.equals(s4));
	 }
}
