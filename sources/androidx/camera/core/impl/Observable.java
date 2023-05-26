package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface Observable<T> {

    /* loaded from: classes.dex */
    public interface Observer<T> {
        void a(T t7);

        void onError(@NonNull Throwable th);
    }

    void a(@NonNull Executor executor, @NonNull Observer<? super T> observer);

    void b(@NonNull Observer<? super T> observer);
}
