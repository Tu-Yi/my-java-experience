class Loop{
    public static void main(String args[]){
//		*****
//		*****
//		*****
//		*****
		 for(int i=1;i<=4;i++) {
            for(int j=1;j<=5;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("&&&&&&&&&&&&");
//		 *****
//		 ****
//		 ***
//		 **
//		 *
        for(int i=1;i<=5;i++) {
            for(int y=5;y>=i;y--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("&&&&&&&&&&&&");
//		 *
//		 **
//		 ***
//		 ****
//		 *****
        for(int i=1;i<=5;i++) {
            for(int y=1;y<=i;y++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("&&&&&&&&&&&&");
//		 54321
//		 5432
//		 543
//		 54
//		 5
        for(int i=1;i<=5;i++) {
            for(int y=5;y>=i;y--) {
                System.out.print(y);
            }
            System.out.println();
        }
//		 1
//		 22
//		 333
//		 4444
//		 55555
        System.out.println("&&&&&&&&&&&&");
        for(int i=1;i<=5;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println("&&&&&&&&&&&&");
//		 1*1=1	
//		 2*1=2	2*2=4	
//		 3*1=3	3*2=6	3*3=9	
//		 4*1=4	4*2=8	4*3=12	4*4=16	
//		 5*1=5	5*2=10	5*3=15	5*4=20	5*5=25	
//		 6*1=6	6*2=12	6*3=18	6*4=24	6*5=30	6*6=36	
//		 7*1=7	7*2=14	7*3=21	7*4=28	7*5=35	7*6=42	7*7=49	
//		 8*1=8	8*2=16	8*3=24	8*4=32	8*5=40	8*6=48	8*7=56	8*8=64	
//		 9*1=9	9*2=18	9*3=27	9*4=36	9*5=45	9*6=54	9*7=63	9*8=72	9*9=81
        for(int i=1;i<=9;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(i + "*" + j + "=" + (i*j) + "\t");
            }
            System.out.println();
        }
        System.out.println("&&&&&&&&&&&&");
//		 * * * * * 
//		  * * * * 
//		   * * * 
//		    * * 
//		     * 
        for(int i=1;i<=5;i++) {
            for(int x=1;x<i;x++) {
                System.out.print(" ");
            }
            for(int y=5;y>=i;y--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        //打印质数
        outer:
		for(int i=101;i<150;i++) {
			for(int j=2;j<i/2;j++) {
				if(i%j==0) {
					continue outer;
				}
			}
			System.out.println(i);
		}

    }
        
        
}
