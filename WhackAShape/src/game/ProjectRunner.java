// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.
// Jhanavi Ghadia (jrg2920)
package game;

/**
 * @author jhanavi ghadia
 * @version 2019.09.28
 * Project runner class to run the code
 */
public class ProjectRunner {
    /**
     * default constructor which is empty
     */
    public ProjectRunner() {
    }

    /**
     * Main method to run the project
     * @param args
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            new WhackAShape(args);
        }
        else {
            new WhackAShape();
        }
    }
}
