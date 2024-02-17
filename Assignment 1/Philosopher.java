import java.util.Random;

class Philosopher extends Thread {
  private Chopstick left, right;
  private Random random;
  private int thinkCount;

  public Philosopher(Chopstick left, Chopstick right) {
      this.left = left; this.right = right;
    random = new Random();
  }

  public void run(int philosophernumber, int cycles, int think, int eat, int rl) {
    try {
      while(true) {
        // the for loop represents the cycles that the program goes through
        for (int i = 0; i < cycles; ++i){
          ++thinkCount;
          if (thinkCount % 10 == 0)
            System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
          Thread.sleep(think);     // Think for a while
          System.out.println("Philosopher " + this + " thinks for  " + think + " units");
          // this if statement should catch either RL being even, or in the case rl is 1, the philosopher being an even one.
          if (rl == 0  ||  philosophernumber%2 == 0) {
            System.out.println("Philosopher " + this + " wants right chopstick");
            synchronized(right) {  
              System.out.println("Philosopher " + this + " has right chopstick");
              System.out.println("Philosopher " + this + " wants left chopstick");
              synchronized(left) {  
                System.out.println("Philosopher " + this + " has left chopstick");
                Thread.sleep(eat); // Eat for a while
                System.out.println("Philosopher " + this + " lets go of left chopstick");
                System.out.println("Philosopher " + this + " lets go of right chopstick");
              }
            } 
          }
          // the chopstick order is binary, only two options so an else statement works wonders here..
          else {
            System.out.println("Philosopher " + this + " wants left chopstick");
            synchronized(left) {                    // Grab left chopstick 
              System.out.println("Philosopher " + this + " has left chopstick");
              System.out.println("Philosopher " + this + " wants right chopstick");
              synchronized(right) {                 // Grab right chopstick 
                System.out.println("Philosopher " + this + " has left chopstick");
                Thread.sleep(eat); // Eat for a while
                System.out.println("Philosopher " + this + " lets go of left chopstick");
                System.out.println("Philosopher " + this + " lets go of right chopstick");
              }
            }
          }
        }
      }
    } catch(InterruptedException e) {}
  }
}


// sorry mansi for my crappy java code, i'll be submitting a fixed version this weekend for lower credit