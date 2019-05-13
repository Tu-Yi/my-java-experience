class Data{
    public static void main(String args[]){
        {
            byte b = 3;
            b = (byte)(b+3);
            System.out.println(b);

            int a = 'a' + 1;
            System.out.println(a);

            int a1 = 6370;
            a1 = a1 / 1000;
            System.out.println(a1);

            boolean aa = true;
            String bb = aa + "1";
            System.out.println(bb);
        }
        
        {
            System.out.println(true ^ true); //false
            System.out.println(true ^ false);
            System.out.println(false ^ true);
            System.out.println(false ^ false);    
        }

        
        {
            int m=89;
            System.out.println("{}: "+m);
        }

        {
            String aaa = "yuankun";
            switch(aaa){
                case "yuankun":
                    System.out.println("right");
                    break;
                case "yuankun1":
                    System.out.println("right1");
                    break;
                case "yuankun2":
                    System.out.println("right2");
                    break;
                default:
                    System.out.println("righ3");  
            }

            int month = 3;
            switch(month){
                case 3:
                case 4:
                case 5:
                    System.out.println("??"); 
                    break; 
            }
        
        }
    }
}