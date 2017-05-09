package de.hsb.gastromaster.data.response;


import android.support.annotation.Nullable;

import de.hsb.gastromaster.data.order.IOrder;

public class Response<T> {

    @Nullable
    private T entity;
    private boolean isSuccessful;
    private String errorMessage;

    public Response(T entity,
                    boolean isSuccessful,
                    String errorMessage) {

        this.entity = entity;
        this.isSuccessful = isSuccessful;
        this.errorMessage = errorMessage;
    }

    public Response(T entity, boolean isSuccessful) {
        this.entity = entity;
        this.isSuccessful = isSuccessful;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
