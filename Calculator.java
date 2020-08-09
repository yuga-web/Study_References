package lambda;
interface Addable{  
    int add(int a,int b);  
}
interface Sub{  
    int subtract(int a,int b);  
}
interface Mult{  
    int mul(int a,int b);  
}
interface Div{  
    int divi(int a,int b);  
}

public class Calculator {
	public static void main(String[] args) { 
		Addable ad1=(a,b)->(a+b);  
        System.out.println("Addition "+ad1.add(129,20));  
        Sub s1=(a,b)->(a-b);  
        System.out.println("Subtraction "+s1.subtract(50,20)); 
        Mult m1=(a,b)->(a*b);  
        System.out.println("Multiplication "+m1.mul(50,2));
        Div d1=(a,b)->(a/b);  
        System.out.println("Division "+d1.divi(50,2)); 
	}

}
