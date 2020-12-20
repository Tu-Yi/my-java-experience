
/**递归，循环求阶乘 */
static long factorial(int n) {
    if (n == 1) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
    //1*2*3*4*5...*10
}

static  long  factorialLoop(int a){
    long d3 = System.currentTimeMillis();
    long  result = 1;
    while (a > 1) {
        result *= a * (a - 1);
        a -= 2;
    }
    long d4 = System.currentTimeMillis();
    System.out.println(result);
    System.out.printf("执行时间: %s%n", d4 - d3);
    return  result;
}