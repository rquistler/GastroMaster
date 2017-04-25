package de.hsb.gastromaster;


import android.support.annotation.Nullable;

public interface Validator {
    enum ValidationResult {
        /**
         * The input is valid
         */
        NO_ERROR
    }

    ValidationResult validate(@Nullable String input);
}
