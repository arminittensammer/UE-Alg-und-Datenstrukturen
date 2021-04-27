package ue03;

public class aufgabe03 {
    public static void main(String[] args) {
        int[] numbers = {2,3,4,5,6,8,9,13,16};
        int n = 4;
        int index = binSearch(numbers,n);
        System.out.println(index);
    }

    private static int binSearch(int[] numbers, int n) {
        int bot = 0;
        int top = numbers.length-1;

        if(numbers.length == 0){
            System.out.println("Array leer");
            return -1;
        }
        if(n < numbers[0] || n > numbers[numbers.length-1]){
            System.out.println("number not in interval");
            return -1;
        }
        while(bot <= top){
            int mid = (top+bot) / 2;
            if(n == numbers[mid]){
                if(mid == numbers.length-1 || n != numbers[mid+1]){
                    return mid;
                }

            } else if (n < numbers[mid]){
                top = mid - 1;
            } else{     // n > numbers[mid]
                bot = mid + 1;
            }
        }
        System.out.println("Error");
        return -1;
    }

}
