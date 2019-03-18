public class Motor
{
  public static int in1 = 17;
  public static int in2 = 22;
  public static Runtime runTime = Runtime.getRuntime();
  
  public static void main(String args[]) {
            /*runTime.exec("gpio mode 1 pwm");
            runTime.exec("gpio pwm-ms");
            runTime.exec("gpio pwmc 205"); 
            runTime.exec("gpio pwmr 2000"); 
            runTime.exec("gpio pwm 1 152"); // ~center*/
            init();
            
            /*Runtime runTime2 = Runtime.getRuntime();
            runTime2.exec("gpio mode " + in2 + " out");
            runTime2.exec("gpio write " + in2 + " 0");*/
            forward();
            reverse();
            stop();
    }
    public static void init() {
		try {
			runTime.exec("gpio -g mode 17 out");
			runTime.exec("gpio -g mode 22 out");
			runTime.exec("gpio -g write 17 0");
			runTime.exec("gpio -g write 22 0");
		} catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
		}
	}
    
    public static void forward() {
        try {
			runTime.exec("gpio -g write " + in1 + " 1");
			runTime.exec("gpio -g write " + in2 + " 0");
			Thread.sleep(500);
		} catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
		}
	}
	
	public static void reverse() {
        try {
        runTime.exec("gpio -g write " + in1 + " 0");
        runTime.exec("gpio -g write " + in2 + " 1");
        Thread.sleep(500);
		} catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
		}
	}
	
	public static void stop() {
		try {
        runTime.exec("gpio -g write " + in1 + " 0");
        runTime.exec("gpio -g write " + in2 + " 0");
        Thread.sleep(500);
		} catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
		}
	}
  }
