package kotlinx.coroutines;

/* compiled from: Job.kt */
/* loaded from: classes5.dex */
public interface ChildHandle extends DisposableHandle {
    boolean e(Throwable th);

    Job getParent();
}
