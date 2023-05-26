package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public class JobImpl extends JobSupport implements CompletableJob {

    /* renamed from: g  reason: collision with root package name */
    private final boolean f51299g;

    public JobImpl(Job job) {
        super(true);
        w0(job);
        this.f51299g = f1();
    }

    private final boolean f1() {
        ChildHandleNode childHandleNode;
        JobSupport W;
        ChildHandleNode childHandleNode2;
        ChildHandle q02 = q0();
        if (q02 instanceof ChildHandleNode) {
            childHandleNode = (ChildHandleNode) q02;
        } else {
            childHandleNode = null;
        }
        if (childHandleNode != null && (W = childHandleNode.W()) != null) {
            while (!W.n0()) {
                ChildHandle q03 = W.q0();
                if (q03 instanceof ChildHandleNode) {
                    childHandleNode2 = (ChildHandleNode) q03;
                } else {
                    childHandleNode2 = null;
                }
                if (childHandleNode2 != null) {
                    W = childHandleNode2.W();
                    if (W == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean a(Throwable th) {
        return E0(new CompletedExceptionally(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean k() {
        return E0(Unit.f50853a);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean n0() {
        return this.f51299g;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean o0() {
        return true;
    }
}
