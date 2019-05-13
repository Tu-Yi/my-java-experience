class OverLoad{
    public static void main(String args[]){
        double wawa = add(1,2.1);
        System.out.println(add(1,2.1));
    }
    public static int add(int a,int b){
        return a+b;
    }
    public static double add(double a,double b){
        return a+b;
    }
}