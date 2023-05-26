package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.DebugStringsKt;

/* compiled from: Tasks.kt */
/* loaded from: classes5.dex */
public final class TaskImpl extends Task {

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f51962h;

    public TaskImpl(Runnable runnable, long j8, TaskContext taskContext) {
        super(j8, taskContext);
        this.f51962h = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f51962h.run();
        } finally {
            this.f51960g.a();
        }
    }

    public String toString() {
        return "Task[" + DebugStringsKt.a(this.f51962h) + '@' + DebugStringsKt.b(this.f51962h) + ", " + this.f51959f + ", " + this.f51960g + ']';
    }
}
