package HashLearning;

public class hashcode_CompareTest {
      public static void main(String[] args){
    	  String str1 = new String("I love u");
    	  String str2 = new String("I love u");
    	  String str3 = new String("I love u too");
    	  String str4 = "I love u";
    	  System.out.println(str1 == str2);
    	  System.out.println(str1.equals(str2));
    	  System.out.println(str1 == str4);
    	  System.out.println(str1.hashCode() == str2.hashCode());
    	  System.out.println(str1.hashCode() == str4.hashCode());
    	  System.out.println(str1.equals(str4));
    	 
    	  
    	  /*
    	  output:
    		  false  if we use ==, it means we compare the address of those value if there are two object,
    		         so == always used for compare variables but not objects, and two new String are two different objects
    		  true   equal() used for compare the value because in the object.String, they do override the equal method, it means
    		         for String.equal(), it is not the default equal() method, it will compare the vaule which in the String, for more details 
    		         we could check the source code of String
    		  false  it is same as str1 == str2, str4 create another address to store the value, and == is used for chekcing the address
    		  true   the hashcode() that in the String is made by a algorithm 31*i + value[i], so if the value is same, the hashcode should be same
    		  true   same as str1.hashcode() == str2.hashcode();
    		  true   same as No.2
    		  
    		  */
      }
}
