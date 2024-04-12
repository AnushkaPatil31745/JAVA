class myException extends Exception{
private static int acc[] ={ 1001,1002};
private static String name[] ={ " hgsdj", "ygdk" };
private static double bal[] ={ 1000000,20000 };
 myException (){
 }
 myException ( String str ){
 super(str);
 }
 public static void  main (String args[]){
 try {
 System.out.println("ACCNO"+"\t"+ "CUATOMOR"+"\t"+"BALANCE");
 for(int i=0;i<=1;i++){
 System.out.println(acc[i]+"\t"+ name[i]+"\t"+bal[i]);
 if (bal[i]<100000)
 { 
 
 myException me =new myException ("balance amount is less");
 throw me;
 }
 }
 }
 catch(myException me){
 me.printStackTrace();
 }
 }}
