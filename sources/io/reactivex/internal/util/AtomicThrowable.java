package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    public boolean a(Throwable th) {
        return ExceptionHelper.a(this, th);
    }

    public Throwable b() {
        return ExceptionHelper.b(this);
    }
}
