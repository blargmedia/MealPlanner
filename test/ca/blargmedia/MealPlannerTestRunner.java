package ca.blargmedia;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Test Runner
 */
public class MealPlannerTestRunner {

    public class TestRunner {
        public void main(String[] args) {
            Result result = JUnitCore.runClasses(MealPlannerTest.class);

            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }

            System.out.println(result.wasSuccessful());
        }
    }
}
