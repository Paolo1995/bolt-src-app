package kotlinx.coroutines;

/* compiled from: Supervisor.kt */
/* loaded from: classes5.dex */
public final class SupervisorKt {
    public static final CompletableJob a(Job job) {
        return new SupervisorJobImpl(job);
    }

    public static /* synthetic */ CompletableJob b(Job job, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            job = null;
        }
        return a(job);
    }
}
