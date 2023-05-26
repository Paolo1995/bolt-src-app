package kotlinx.coroutines;

/* compiled from: Supervisor.kt */
/* loaded from: classes5.dex */
final class SupervisorJobImpl extends JobImpl {
    public SupervisorJobImpl(Job job) {
        super(job);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean a0(Throwable th) {
        return false;
    }
}
