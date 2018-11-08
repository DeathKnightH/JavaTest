package cn.dk;

public class Main {

    public static void main(String[] args) {
	    int a = 1;
	    Integer b = 2;
        Object[] arr = {a,b};
        for (int i = 0; i< arr.length; i++){
            System.out.println(arr[i].getClass());
        }
    }
}
