package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public abstract class JobNode extends CompletionHandlerBase implements DisposableHandle, Incomplete {

    /* renamed from: i  reason: collision with root package name */
    public JobSupport f51300i;

    public final JobSupport W() {
        JobSupport jobSupport = this.f51300i;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.w("job");
        return null;
    }

    public final void X(JobSupport jobSupport) {
        this.f51300i = jobSupport;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList d() {
        return null;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        W().R0(this);
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this) + "[job@" + DebugStringsKt.b(W()) + ']';
    }
}
