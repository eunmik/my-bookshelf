package com.cleancode.chapter13;

import org.junit.Test;

import static org.junit.Assert.fail;

public class ClassWithThreadingProblemTest {
    @Test
    public void twoThreadsShouldFailEventually() throws Exception {

        //Create a single instance of ClassWithThreadingProblem. Note, we must use the final keyword because we use it below in an anonymous inner class.
        final ClassWithThreadingProblem classWithThreadingProblem = new ClassWithThreadingProblem();

        //Create an anonymous inner class that uses the single instance of ClassWithThreadingProblem.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("starting thread");
                classWithThreadingProblem.takeNextId();
            }
        };

        //Run this code “enough” times to demonstrate that the code failed, but not so much that the test “takes too long.”
        // This is a balancing act; we don’t want to wait too long to demonstrate failure.
        // Picking this number is hard— although later we’ll see that we can greatly reduce this number.
        for (int i =0; i < 50000; ++i){
            //Remember the starting value. This test is trying to prove that the code in ClassWithThreadingProblem is broken.
            //If this test passes, it proved that the code was broken. If this test fails, the test was unable to prove that the code is broken.
            int startingId = classWithThreadingProblem.nextId;
            //We expect the final value to be two more than the current value.
            int expectedResult = 2 + startingId;

            //Create two threads, both of which use the object we created in lines 12–16.
            //This gives us the potential of two threads trying to use our single instance of ClassWithThreadingProblem and interfering with each other.
            Thread t1 = new Thread(runnable);
            Thread t2 = new Thread(runnable);
            //Make our two threads eligible to run.
            t1.start();
            t2.start();
            //Wait for both threads to finish before we check the results.
            t1.join();
            t2.join();

            //Record the actual final value.
            int endingId = classWithThreadingProblem.nextId;

            //Did our endingId differ from what we expected? If so, return end the test— we’ve proven that the code is broken. If not, try again.
            if (endingId != expectedResult)
                return;
        }
        //If we got to here, our test was unable to prove the production code was bro- ken in a “reasonable” amount of time; our code has failed.
        //Either the code is not broken or we didn’t run enough iterations to get the failure condition to occur.
        fail("Should have exposed a threading issue but it did not.");
    }
}
