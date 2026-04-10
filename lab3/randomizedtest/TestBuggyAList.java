package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        aListNoResizing.addLast(4);
        buggyAList.addLast(4);
        aListNoResizing.addLast(5);
        buggyAList.addLast(5);
        aListNoResizing.addLast(6);
        buggyAList.addLast(6);

        Assert.assertEquals(aListNoResizing.removeLast(), buggyAList.removeLast());
        Assert.assertEquals(aListNoResizing.removeLast(), buggyAList.removeLast());
        Assert.assertEquals(aListNoResizing.removeLast(), buggyAList.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = B.size();

                Assert.assertEquals(size1, size2);
            } else if (operationNumber == 2 && L.size() > 0) {
                int getLast1 = L.getLast();
                int getLast2 = B.getLast();

                Assert.assertEquals(getLast1, getLast2);
            } else if (operationNumber == 3 && L.size() > 0) {
                int removeLast1 = L.removeLast();
                int removeLast2 = B.removeLast();

                Assert.assertEquals(removeLast1, removeLast2);
            }
        }
    }
}
