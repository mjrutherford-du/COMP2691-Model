/**
 * The cpsuite code can be cloned from:
 *
 * https://github.com/takari/takari-cpsuite
 *
 * This code was adapted from this stack overflow topic:
 *
 * https://stackoverflow.com/questions/2255046/run-all-tests-in-junit-4
 */

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.extensions.cpsuite.ClasspathSuite.*;
import org.junit.runner.RunWith;
import org.junit.runner.JUnitCore;
import org.junit.internal.TextListener;
import static org.junit.extensions.cpsuite.SuiteType.*;

@RunWith(ClasspathSuite.class)
@SuiteTypes({ TEST_CLASSES })
public class RunAllSuite {
        public static void main(String args[]) {
                JUnitCore junit = new JUnitCore();
                junit.addListener(new TextListener(System.out));
                junit.run(RunAllSuite.class);
        }
}
