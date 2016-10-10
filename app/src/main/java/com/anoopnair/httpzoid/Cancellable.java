package com.anoopnair.httpzoid;

/**
 * (c) Artur Sharipov
 */
public interface Cancellable {
    public static final Cancellable Empty = new Cancellable() {
        @Override
        public void cancel() {
        }
    };
    public void cancel();
}

