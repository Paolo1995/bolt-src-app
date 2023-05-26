package androidx.arch.core.executor;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class TaskExecutor {
    public abstract void a(@NonNull Runnable runnable);

    public abstract boolean b();

    public abstract void c(@NonNull Runnable runnable);
}
