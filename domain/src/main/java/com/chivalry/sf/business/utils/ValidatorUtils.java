package com.chivalry.sf.business.utils;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;


public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    public static void validateEntity(Object object, Class<?>... groups)
            throws RuntimeException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            String msg = constraintViolations.parallelStream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(","));
            throw new RuntimeException(msg);
        }
    }


}
