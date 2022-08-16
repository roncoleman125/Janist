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
package nist.loader;

/**
 * Interface to load the MNIST data.
 * <p>There is one instance for each sample, ie, one for the training and one for the testing database.</p>
 * @author Ron.Coleman
 */
public interface IMLoader {
    record Normal(double[][] pixels, double[][] labels) {}
    ////////////////
    // TODO: Add a constructor which takes the pixel and label paths.
    ////////////////

    /**
     * Gets the pixel and label data in row-major order.
     * @return Data in row-major order.
     */
    public MDigit[] load();

    /**
     * Gets the pixel magic number.
     * @return Magic number
     */
    public int getPixelsMagic();

    /**
     * Gets the label magic number.
     * @return Magic number
     */
    public int getLabelsMagic();

    /**
     * Gets the checksum.
     * @return Checksum
     */
    public long getChecksum();

    public int getNumDigits();

    /**
     * Normalizes the data.
     * @return Normalized data
     */
    public Normal normalize();
}
