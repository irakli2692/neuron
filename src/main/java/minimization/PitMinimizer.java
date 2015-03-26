package minimization;

import utils.MinimizationUtils;

import static utils.MinimizationUtils.EPS;

/**
 * Created by irakli on 3/26/2015.
 */
public class PitMinimizer implements Minimizer {


    @Override
    public double[] findMinimumPoint(double[] startPoint, MultiParameterFunction function) {

        for (int i = 0; i < startPoint.length; i++) {
            double coordinate = startPoint[i];

            double[] coordinateValues = new double[]{startPoint[i], startPoint[i] + EPS, startPoint[i] - EPS};

            double[] results = new double[3];

            for (int j = 0; j < 3; j++) {
                startPoint[i] = coordinateValues[j];

                results[j] = function.applyFunction(startPoint);
            }

            startPoint[i] = coordinateValues[0];

            if (isMinimum(results[0], results[1], results[2])) {
                continue;
            }

            int direction = getDirection(results[0], results[1]);

            double nextCoordinate = coordinate + direction * MinimizationUtils.INTERVAL_STEP;

            startPoint[i] = coordinate - direction * EPS;

            double firstPreviousResult = function.applyFunction(startPoint);

            startPoint[i] = coordinate;

            double firstResult = function.applyFunction(startPoint);

            startPoint[i] = nextCoordinate;

            double secondResult = function.applyFunction(startPoint);

            startPoint[i] = nextCoordinate + direction * EPS;

            double secondNextResult = function.applyFunction(startPoint);

            while (!pitIntervalLocated(firstPreviousResult, firstResult, secondResult, secondNextResult)) {
                coordinate = nextCoordinate;

                nextCoordinate = coordinate + direction * MinimizationUtils.INTERVAL_STEP;
            }


            if (coordinate > nextCoordinate) {
                double temp;

                temp = coordinate;
                coordinate = nextCoordinate;
                nextCoordinate = temp;
            }

            startPoint[i] = binarySearchMinimumPoint(coordinate, nextCoordinate, function, startPoint, i);
        }

        return startPoint;
    }


    private double binarySearchMinimumPoint(double first, double second, MultiParameterFunction function,
                                            double[] pointCoordinates,
                                            int i) {
        double middle;

        while (second - first >= EPS) {
            middle = (first + second) / 2;

            pointCoordinates[i] = middle - EPS;

            double leftResult = function.applyFunction(pointCoordinates);

            pointCoordinates[i] = middle;

            double middleResult = function.applyFunction(pointCoordinates);

            pointCoordinates[i] = middle + EPS;

            double rightResult = function.applyFunction(pointCoordinates);

            if (isMinimum(middleResult, rightResult, leftResult)) {
                break;
            }

            if (leftResult >= middleResult) {
                first = middle;
            } else {
                second = middle;
            }
        }

        return first;
    }

    /**
     * result parameters. return true if start result is minimal.
     *
     * @param start
     * @param next
     * @param previous
     * @return
     */
    private boolean isMinimum(double start, double next, double previous) {
        return start < next && start < previous;
    }

    private int getDirection(double startResult, double nextResult) {
        return nextResult < startResult ? 1 : -1;
    }

    private boolean pitIntervalLocated(double firstPrevious, double first, double second, double secondNext) {
        return firstPrevious >= first && secondNext >= second;
    }


}
