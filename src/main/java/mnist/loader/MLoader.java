package mnist.loader;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Random;

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
            assert nRows == 28: "bad number row count";
            assert nCols == 28: "bad number column count";

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

    public static void main(String[] args) throws Exception {
        Random ran = new Random();
        IMLoader loader = new MLoader("data/t10k-images.idx3-ubyte","data/t10k-labels.idx1-ubyte");
//        IMLoader loader = new MLoader("data/train-images.idx3-ubyte","data/train-labels.idx1-ubyte");

        MDigit[] digits = loader.load();
        System.out.println("digits: "+loader.getNumDigits());
        System.out.println("pixels magic: "+loader.getPixelsMagic());
        System.out.println("labels magic: "+loader.getLabelsMagic());
        System.out.println("checksum: "+loader.getChecksum());
        for(int idx=27; idx < digits.length; idx++) {
            if(digits[idx].label() == 7) {
                System.out.println(digits[idx] + "");
                break;
            }
        }
    }
}
