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

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * Implements the MNIST loader.
 * @author Ron.Coleman
 */
public class MLoader implements IMLoader {
    String dataPath;
    String labelsPath;
    int pixelsMagic;
    int labelsMagic;
    int nDigits;

    /**
     * Constructor
     * @param dataPath Path to the pixel data
     * @param labelsPath Path to the labels data
     */
    public MLoader(String dataPath, String labelsPath) {
        this.dataPath = dataPath;
        this.labelsPath = labelsPath;
    }

    /**
     * Loads the digits.
     * @return Digit instances
     */
    @Override
    public MDigit[] load() {
        MDigit[] digits = null;
        try {
            // Access the pixels
            DataInputStream pixelInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(dataPath)));

            this.pixelsMagic = pixelInputStream.readInt();
            nDigits = pixelInputStream.readInt();

            // This is the dimension of each pixel: should be 28x28
            int nRows = pixelInputStream.readInt();
            int nCols = pixelInputStream.readInt();
            assert nRows == 28: "bad row count";
            assert nCols == 28: "bad column count";

            DataInputStream labelInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(labelsPath)));

            this.labelsMagic = labelInputStream.readInt();
            int nLabels = labelInputStream.readInt();

            assert (nDigits == nLabels);

            // TODO: allocate the MDigit array

            // TODO: load all the digits into digits using double-nested loop

            // TODO: close the pixel and label streams
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return digits;
    }

    /**
     * Gets the pixels magic number.
     * @return Magic number
     */
    @Override
    public int getPixelsMagic() {
        return pixelsMagic;
    }

    /**
     * Gets the labels magic number.
     * @return Magic number
     */
    @Override
    public int getLabelsMagic() {
        return labelsMagic;
    }

    /**
     * Gets number of loaded digits.
     * @return Number of loaded digits
     */
    @Override
    public int getNumDigits() { return nDigits; }

    /**
     * Gets the checksum hash.
     * @return Checksum hash
     */
    @Override
    public long getChecksum() {
        return 0;
    }

    /**
     * Loads and normalizes in one-shot
     * @return A normal instance
     */
    @Override
    public Normal normalize() {
        // Invoke load here to go straight to getting digits -- normalize and load one-shot
        MDigit[] digits = this.load();

        // TODO: allocate the pixels 2D array: 1st dim for each digit, 2nd dim are pixels

        // TODO: allocate the labels 1D array: one for each digit

        return new Normal(null,null);
    }
}
