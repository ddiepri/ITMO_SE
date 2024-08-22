// Variant -> 69


import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // create q with required numbers
        long[] q = { 6, 8, 10, 12, 14, 16, 18, 20, 22 };

        // create x
        float[] x = new float[20];

        // fill x with required random floats
        Random random = new Random();

        float min = -15.0f, max = 5.0f;
        for (int i = 0; i < x.length; i++) {
            x[i] = min + random.nextFloat() * (max - min);
        }

        // create z
        float[][] z = new float[9][20];


        // calc values in array
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 20; j++) {
                z[i][j] = switch ((int) q[i]) {
                    case 10:
                        yield (float) Math.tan(Math.pow((1.0f/3.0f - (float) Math.exp(x[j])), 2));
                    case 8, 12, 18, 20:
                        yield (float) Math.exp(Math.atan(1.0f/(Math.exp(Math.abs(x[j])))));
                    default:
                        yield (float) Math.cbrt(Math.log(Math.pow(5 * Math.pow(Math.cos(x[j]), 2), 2)));
                };
            }
        }


        // print calculated array
        for (float[] arrayOfFloats : z) {
            for (float elem : arrayOfFloats) {
                System.out.printf("%10.4f", elem);
            }
            System.out.println();
        }
    }
}