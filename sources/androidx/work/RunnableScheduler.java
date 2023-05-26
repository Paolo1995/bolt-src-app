package androidx.work;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface RunnableScheduler {
    void a(@NonNull Runnable runnable);

    void b(long j8, @NonNull Runnable runnable);
}
