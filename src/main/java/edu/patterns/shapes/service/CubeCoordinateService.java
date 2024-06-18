package edu.patterns.shapes.service;

import edu.patterns.shapes.model.CubeCoordinate;
import org.apache.log4j.Logger;

public class CubeCoordinateService {
    private static final Logger logger = Logger.getLogger(CubeCoordinateService.class);
    private static final String VECTOR_MULTIPLICATION_LOG = "Vector multiplication of %s and %s is calculated and is equal to %f";
    private static final String VECTOR_LENGTH_LOG = "Vector between %s and %s is of length %f";
    private static final String VECTOR_MODULE_LOG = "Module of vector %s is calculated and is equal to %f";

    public static double vectorMultiplication(CubeCoordinate firstVector, CubeCoordinate secondVector) {
        double xProduct = firstVector.getX() * secondVector.getX();
        double yProduct = firstVector.getY() * secondVector.getY();
        double zProduct = firstVector.getZ() * secondVector.getZ();
        double result = xProduct + yProduct + zProduct;

        logger.info(String.format(VECTOR_MULTIPLICATION_LOG, firstVector, secondVector, result));
        return result;
    }

    public static double findVector(CubeCoordinate firstCoordinate, CubeCoordinate secondCoordinate) {
        double x = firstCoordinate.getX() - secondCoordinate.getX();
        double y = firstCoordinate.getY() - secondCoordinate.getY();
        double z = firstCoordinate.getZ() - secondCoordinate.getZ();
        double vectorLength = Math.sqrt(x * x + y * y + z * z);

        logger.info(String.format(VECTOR_LENGTH_LOG, firstCoordinate, secondCoordinate, vectorLength));
        return vectorLength;
    }

    public static double findVectorModule(CubeCoordinate firstVector) {
        double xSquared = Math.pow(firstVector.getX(), 2);
        double ySquared = Math.pow(firstVector.getY(), 2);
        double zSquared = Math.pow(firstVector.getZ(), 2);
        double module = Math.sqrt(xSquared + ySquared + zSquared);

        logger.info(String.format(VECTOR_MODULE_LOG, firstVector, module));
        return module;
    }
}