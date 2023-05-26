package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
final class CallbackException extends RuntimeException {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
