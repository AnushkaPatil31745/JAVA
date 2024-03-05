import java.util.Scanner;
class complexNumber{
     double real;
     double imag;
 public complexNumber (double real ,double imag){
  this.real=real;
  this.imag=imag;
  }
 public double getR(){
  return real;
 }
public double getimag(){
 return imag;
}
 public String toString(){
  return real + "+" +imag + "i";
}
 public static complexNumber add (complexNumber num1 ,complexNumber num2){
  double realpart= num1.getR()+num2.getR();
  double imaginarypart= num1.getimag() + num2.getimag();
  return new complexNumber(realpart,imaginarypart);
 }
 public static complexNumber Sub (complexNumber num1 ,complexNumber num2){
  double realpart= num1.getR()-num2.getR();
  double imaginarypart= num1.getimag() - num2.getimag();
  return new complexNumber(realpart,imaginarypart);
 }
 public static complexNumber mul (complexNumber num1 ,complexNumber num2){
  double realpart= num1.getR()*num2.getR();
  double imaginarypart= num1.getimag() * num2.getimag();
  return new complexNumber(realpart,imaginarypart);
 }
    public static void main(String[] args) {
        char choice;
        Scanner scanner = new Scanner(System.in);
        complexNumber result = new complexNumber(0, 0);
        do {
            double realPart, imaginaryPart;
            char operator;

            realPart = scanner.nextDouble();
            imaginaryPart = scanner.nextDouble();
             complexNumber num1 = new complexNumber(realPart, imaginaryPart);
            operator = scanner.next().charAt(0);

            realPart = scanner.nextDouble();
            
            imaginaryPart = scanner.nextDouble();

            complexNumber num2 = new complexNumber(realPart, imaginaryPart);

            switch (operator) {
                case '+':
                    result = complexNumber.add(num1,num2);
                    break;
                case '-':
                    result = complexNumber.Sub(num1,num2);
                    break;
                    case '*':
                    result = complexNumber.mul(num1,num2);
                    break;
                
                
            }

            System.out.println(""+ result);

      System.out.println("Do you want to perform more operations? 'y' for yes, 'n' for no");
            choice = scanner.next().charAt(0);

        } while (choice == 'y');
        scanner.close();
    }
}


