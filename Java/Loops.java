package Java;
public class Loops {

    public static void main(String[] args){
        int i;
        for(i=0; i<=6; i++){
            System.out.println(i);
        }

        System.out.println("\n------------------ \n");

        for(i=0; i<=6; i++){
            if (i%2==0){
                System.out.println(i);
            }
        }

        System.out.println("\n------------------ \n");

        for(i=0; i<=6; i++){
            if(isPrime(i)){
                System.out.println("i");
            }
        }
    }   
    
    public static boolean isPrime(int num){
        for (int i = 2; i <= num/i; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
