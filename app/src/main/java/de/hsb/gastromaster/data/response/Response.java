package de.hsb.gastromaster.data.response;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

/**
 * The type Response.
 *
 * @param <T> the type parameter
 */
@AutoValue
public abstract class Response<T> {

    /**
     * Gets entity.
     *
     * @return the entity
     */
    @Nullable
    public abstract T getEntity();

    /**
     * Gets is successful.
     *
     * @return the is successful
     */
    public abstract boolean getIsSuccessful();

    /**
     * Gets error message.
     *
     * @return the error message
     */
    public abstract String getErrorMessage();

    /**
     * Builder builder.
     *
     * @param <T> the type parameter
     * @return the builder
     */
    public static <T> Builder<T> builder() {
        return new AutoValue_Response.Builder()
                .setErrorMessage("");
    }

    /**
     * The type Builder.
     *
     * @param <T> the type parameter
     */
    @AutoValue.Builder
    public abstract static class Builder<T> {

        /**
         * Sets entity.
         *
         * @param value the value
         * @return the entity
         */
        public abstract Builder<T> setEntity(T value);

        /**
         * Sets is successful.
         *
         * @param value the value
         * @return the is successful
         */
        public abstract Builder<T> setIsSuccessful(boolean value);

        /**
         * Sets error message.
         *
         * @param value the value
         * @return the error message
         */
        public abstract Builder<T> setErrorMessage(String value);

        /**
         * Build response.
         *
         * @return the response
         */
        public abstract Response<T> build();
    }
}
