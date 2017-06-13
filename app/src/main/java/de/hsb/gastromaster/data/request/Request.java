package de.hsb.gastromaster.data.request;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.Nullable;

@AutoValue
public abstract class Request<T> {

    @Nullable
    public abstract T getEntity();

    public static <T> Builder<T> builder() {
        return new AutoValue_Request.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder<T> {

        public abstract Builder<T> setEntity(T value);

        public abstract Request<T> build();
    }
}
