import java.util.*;

public class MotorCommand
{
  public static int in1 = 17;
  public static int in2 = 22;
  public static Runtime runTime = Runtime.getRuntime();
  
  public static void main(String args[]) {
            init();
            Scanner userInputScanner = new Scanner(System.in);
            System.out.println("Enter f to go forwards, r to reverse, s to stop, l for lowest speed, h for max speed, m to return to base speed");
            while (true) {
            String command = userInputScanner.nextLine();
            if (command.equals("f")) {
				stop();
				forward();
			} else if (command.equals("r")) {
				stop();
				reverse();
			} else if (command.equals("s")) {
				stop();
			} else if (command.equals("h")) {
				high();
			} else if (command.equals("l")) {
				low();
			} else if (command.equals("m")) {
				mid();
			}else {
				System.out.println("Not a valid Command, please try again.");
			}
		}
    }
    public static void init() {
		try {
			runTime.exec("gpio -g mode 17 out");
			runTime.exec("gpio -g mode 22 out");
			runTime.exec("gpio -g write 17 0");
			runTime.exec("gpio -g write 22 0");
            runTime.exec("gpio -g mode 19 pwm");
            runTime.exec("gpio -g pwm-ms");
            runTime.exec("gpio -g pwmc 205"); 
            runTime.exec("gpio -g pwmr 4000");
            runTime.exec("gpio -g pwm 19 2000");
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
			Thread.sleep(250);
		} catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
		}
	}
	
	public static void high() {
		try {
			runTime.exec("gpio -g pwm 19 4000");
			Thread.sleep(250);
		} catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
		}
	}
	
	public static void low() {
		try {
			runTime.exec("gpio -g pwm 19 1000");
			Thread.sleep(250);
		} catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
		}
	}
	
	public static void mid() {
		try {
			runTime.exec("gpio -g pwm 19 2000");
			Thread.sleep(250);
		} catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
		}
	}
}
