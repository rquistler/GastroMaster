package de.hsb.gastromaster.data.response;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Response<T> {

    @Nullable
    public abstract T getEntity();

    public abstract boolean getIsSuccessful();

    public abstract String getErrorMessage();

    public static <T> Builder<T> builder() {
        return new AutoValue_Response.Builder()
                .setErrorMessage("");
    }

    @AutoValue.Builder
    public abstract static class Builder<T> {

        public abstract Builder<T> setEntity(T value);

        public abstract Builder<T> setIsSuccessful(boolean value);

        public abstract Builder<T> setErrorMessage(String value);

        public abstract Response<T> build();
    }
}
