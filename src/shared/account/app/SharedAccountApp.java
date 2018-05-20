package shared.account.app;
class Person implements Runnable{
    private double balance =10000;
    private double getBalance()
    {
        return balance;
    }
    public void run()
    {
        for(int i=0;i<3;i++)
            {
                withdrawing(5000);
            }
        if(getBalance()<0)
            {
                 System.out.println("Account overwithdrawn ");
            }
    }
    private synchronized void withdrawing(double withdrawAmt)
    { 
        try{
                Thread.sleep(1000);
                    if(getBalance()>=withdrawAmt)
            {
                System.out.println(Thread.currentThread().getName()+" is withdrawing : "+withdrawAmt);
                balance = balance-withdrawAmt; 
                System.out.println(Thread.currentThread().getName()+" "+" has withdrawn : "+withdrawAmt);
            }
        else
            {
                System.out.println("Insufficient amount for "+Thread.currentThread().getName());
            }
            }catch(InterruptedException e)
            {
                System.out.println("withdrawal interrupted ");
            }
    }
}       

public class SharedAccountApp 
{
    public static void main(String[] args)
    { 
            Person person=new Person();
            Thread t1=new Thread(person);
            Thread t2=new Thread(person);
          
            t1.setName("ABC");
            t2.setName("XYZ");
            
            t1.start();
            t2.start();
    }
    
}
