// Duarte Rodrigues - a22206488
// Licenciatura de Engenharia Informática e Aplicações - IPLuso

public class Homework2{
    public static void main(String[] args){
        //Define Variables
        int num0 = 8;
        int num1 = 4;
        int num2 = 3;
        int num3 = 2;
        int num4 = 8;
        int num5 = 7;
        int num6 = 23450;
        int num7 = 23461;
        int num8 = 25;
        int num9 = 78;
        int num10 = 87;
        int a = 15;
        int b = 27;
        int i, j, n=4;
        int limit = 11;
        int var = 1;
        double result = 4.0*(1-(1.0/3)+(1.0/5)-(1.0/7)+(1.0/9)-(1.0/11));

        System.out.println("Hello \nDuarte Rodrigues");

        //Console separators
        System.out.println("\n-----------------------\n");

        System.out.println(74+36);
        
        //Console separators
        System.out.println("\n-----------------------\n");

        System.out.println(50/3);
        
        //Console separators
        System.out.println("\n-----------------------\n");

        System.out.println(-5+8*6);
        System.out.println((55+9)%9);
        System.out.println(20+(-3)*5/8);
        System.out.println(5+15/3*2-8%3);

        //Console separators
        System.out.println("\n-----------------------\n");

        for(int k=0; k<10; k++){
            System.out.println(num0 + " x " + (k+1) + " = " + (num0 *(k+1)));
        }

        //Console separators
        System.out.println("\n-----------------------\n");

        System.out.println(result);

        //Console separators
        System.out.println("\n-----------------------\n");

        final double radius = 7.5;
            double perimeter = 2 * Math.PI * radius;
            double area = Math.PI * radius * radius;

            System.out.println("Perimeter is: "+ perimeter);
            System.out.println("Perimeter is: "+ area);

        //Console separators
        System.out.println("\n-----------------------\n");

        System.out.println("Average of five numbers is: " + (num1+num2+num3+num4+num5)%5);

        //Console separators
        System.out.println("\n-----------------------\n");
        
        System.out.println("Before swapping: a = "+ a +", b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping: a = "+ a +", b = " + b);

         //Console separators
        System.out.println("\n-----------------------\n");

        if(num6 == num7){
            System.out.printf("%d == %d\n", num6, num7);
        }
        if(num6 != num7){
            System.out.printf("%d != %d\n", num6, num7);
        }
        if(num6 < num7){
            System.out.printf("%d < %d\n", num6, num7);
        }
        if(num6 > num7){
            System.out.printf("%d > %d\n", num6, num7);
        }
        if(num6 <= num7){
            System.out.printf("%d <= %d\n", num6, num7);
        }
        if(num6 >= num7){
            System.out.printf("%d >= %d\n", num6, num7);
        }

        //Console separators
        System.out.println("\n-----------------------\n");

        if(num8 > num9){
            if (num8 > num10){
                System.out.println("The greatest: "+ num8);
            }
        }

        if(num9 > num8){
            if(num9 > num10){
                System.out.println("The greatest: " + num9);
            }
        }

        if(num10 > num8){
            if(num10 > num9){
                System.out.println("The greatest: "+ num10);
            }
        }

        //Console separators
        System.out.println("\n-----------------------\n");

        for (i = 1; i <= n; i++){
            for (j = 1; j <= i; j++){
                System.out.println(i);
            }
            System.out.println("-");
        }

        //Console separators
        System.out.println("\n-----------------------\n");

        while(var < limit){
            System.out.println("Loop counter: " + var);
            var++;
        }

    }
}