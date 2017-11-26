import static java.lang.System.err;

/**
 * Created by Oana on 08.11.2017.
 */




    public class Main
    {
        public static int solution;
        public static String hashpassword="B4B7C3A9BDEAB19949A497BFB420F49CF3EE08A5C643D41C1B635C138518B091";
        public static void main(String[] args)
        {
            try {

                Thread[] thread = new Thread[65];
                int min,max,sectiune_subinterval;//sectiune_interval=cate numere sunt intr-un interval
                min=10000000;
                max=99999999;
                sectiune_subinterval=(max-min+1)/65;
                max=min+sectiune_subinterval;

                for (int i = 0; i < thread.length; i++) {
                    if (max + sectiune_subinterval * i + sectiune_subinterval > 99999999)
                        max = 109999999 -(max + sectiune_subinterval * i)+sectiune_subinterval;
                    thread[i] = new MyThread(min+sectiune_subinterval*i,max+sectiune_subinterval*i ,i );//i retine id subinterval,ca sa trecem la urmatorul subinterval*i
                }
                for (int i = 0; i < thread.length; i++) {
                    thread[i].start();
                }
                for(int i=0;i<thread.length;i++){
                    thread[i].join();
                }
                System.out.println("print solution" + solution);


            }catch (Exception e){
                System.out.println("Got an exception! " + err);
            }
        }
    }//

