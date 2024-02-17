public class DiningPhilosophers {

  public static void main(String[] args) throws InterruptedException {
    Philosopher[] philosophers = new Philosopher[Integer.parseInt(args[0])];
    Chopstick[] chopsticks = new Chopstick[Integer.parseInt(args[0])];

    for (int i = 0; i < Integer.parseInt(args[0]); ++i)
      chopsticks[i] = new Chopstick(i);
    for (int i = 0; i < Integer.parseInt(args[0]); ++i) {
      philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % 5]);
      // this line below is where my lack of java experience combined with bad procrastination skills messed with me, i have no idea how
      // the run function of Philosopher.java started
      philosophers[i].start(args[1], args[2], args[3], args[4]);
    }
    for (int i = 0; i < 5; ++i)
      philosophers[i].join();
  }
}
