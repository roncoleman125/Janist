/*
 Copyright (c) Ron Coleman

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package basic;

import nist.loader.IMLoader;
import nist.loader.MLoader;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test the training database has the expected number of digits.
 * @author Ron.Coleman
 * @see <a href="https://junit.org/junit4/javadoc/4.12/index.html?org/junit/FixMethodOrder.html>FixMethodOrder</a>"
 */
@FixMethodOrder(MethodSorters.DEFAULT)
public class LoadTrainingTest {
    @Test
    public void test() {
        IMLoader loader = new MLoader("data/train-images.idx3-ubyte","data/train-labels.idx1-ubyte");

        loader.load();

        int nDigits = loader.getNumDigits();
        assert nDigits == 60000: "unexpected number of digits";
        System.out.println("digits: "+nDigits);
    }
}
