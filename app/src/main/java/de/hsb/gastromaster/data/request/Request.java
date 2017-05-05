package de.hsb.gastromaster.data.request;


import android.support.annotation.Nullable;

public class Request<T> {

    @Nullable
    private T entity;

    public Request(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
