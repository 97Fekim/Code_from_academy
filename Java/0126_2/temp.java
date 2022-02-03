public class temp {
    public static void main(String[] args) {

        int[] temp = new int[10];

        for(int i=0; i<10; ++i){
            temp[i] = (i+1)*3;
            System.out.println(temp[i]);
        }

        int sum=0;
        for(int i: temp){
            if(i%2==0)
                sum += i;
        }

        System.out.println(sum);
    }
}
