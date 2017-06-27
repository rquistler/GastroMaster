/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.request;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.Nullable;

/**
 * The type Request.
 *
 * @param <T> the type parameter
 */
@AutoValue
public abstract class Request<T> {

    /**
     * Gets entity.
     *
     * @return the entity
     */
    @Nullable
    public abstract T getEntity();

    /**
     * Builder builder.
     *
     * @param <T> the type parameter
     * @return the builder
     */
    public static <T> Builder<T> builder() {
        return new AutoValue_Request.Builder();
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
         * Build request.
         *
         * @return the request
         */
        public abstract Request<T> build();
    }
}
