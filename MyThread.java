public class MyThread extends  Thread
{
    private static boolean done = false;
    private String password;
    private int numar_thread;
    public int solution;
    private int min,max,hold_nrthread;

    public MyThread(int min,int max,int hold_nrthread)
    {
        this.min=min;
        this.max=max;
        this.hold_nrthread=hold_nrthread;
    }
    public void run() {
        if (done == false) {
            for (int i = min; (i <= max) && (done == false); i++) {//done==false nu s-a gasit parola
                if (Main.hashpassword.equals(SHA256.convert("" + i))) {
                        password = "" + i;
                        numar_thread = hold_nrthread;
                    System.out.println("Parola " + password + " a fost gasita in Threadul " + numar_thread);
                    Main.solution=i;
                    System.out.println("solution is " + Main.solution);
                    setDone();
                }
            }
        }
    }

    public void setDone()
    {
        done = true;
    }


}
