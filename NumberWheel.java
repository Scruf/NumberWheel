import java.io.FileNotFoundException;

/**
 * The main program for the NumberWheel puzzle.
 *
 * To run with a puzzle file and debugging enabled:
 *
 * java NumberWheel wheel1.txt true
 *
 * To run with a puzzle file and debugging disabled:
 *
 * java NumberWheel wheel1.txt false
 *
 * @author sps
 */
public class NumberWheel {

    /**
     * The main function
     *
     * @param args The command line arguments (name of input file)
     * @throws FileNotFoundException if file not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            System.err.println("Usage: java NumberWheel input-file debug");
        } else {
            WheelConfig init = new WheelConfig(args[0]);
            Backtracker bt = new Backtracker(args[1].equals("true"));
            Configuration sol = bt.solve(init);
            if (sol != null) {
                System.out.println("Solution: " + sol);
            } else {
                System.out.println("No solution!");
            }
        }
    }
}
