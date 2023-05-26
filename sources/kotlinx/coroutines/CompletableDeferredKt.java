package kotlinx.coroutines;

/* compiled from: CompletableDeferred.kt */
/* loaded from: classes5.dex */
public final class CompletableDeferredKt {
    public static final <T> CompletableDeferred<T> a(Job job) {
        return new CompletableDeferredImpl(job);
    }

    public static /* synthetic */ CompletableDeferred b(Job job, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            job = null;
        }
        return a(job);
    }
}
