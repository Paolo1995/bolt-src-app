package kotlinx.coroutines;

/* compiled from: Job.kt */
/* loaded from: classes5.dex */
public final class NonDisposableHandle implements DisposableHandle, ChildHandle {

    /* renamed from: f  reason: collision with root package name */
    public static final NonDisposableHandle f51324f = new NonDisposableHandle();

    private NonDisposableHandle() {
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean e(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public Job getParent() {
        return null;
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
