package com.company;

public class Main
{
    public static void main(String[] args)
    {
        int[] math = {87,23,45,67,89,100,78};
        int[] eng = {97,93,95,97,99,60,88};
        int[] korea = {77,88,77,89,89,10,70};
        int[] total = {77,88,77,89,89,10,70};
//        String[] str1 = new String [math.length];
//        Score[] scores = new Score[math.length];
        Score score = new Score();
        int a;
        int b;
        int cnt=0;

        for(int i= 0; i < math.length; ++i)
        {
            a = math[i]%5;
            b = eng[i]%6;
            for(int j= 0; j < b-1; ++j)
                a *= a;
            if((total[i] = a)%2 == 0)
                System.out.println("count : " + (++cnt));
        }

        for(int i= 0; i < total.length; ++i)
        {
            System.out.println("total[i] : " + total[i]);
        }
    }
}
