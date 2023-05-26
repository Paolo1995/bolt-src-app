package kotlinx.coroutines.scheduling;

/* compiled from: Tasks.kt */
/* loaded from: classes5.dex */
public abstract class Task implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public long f51959f;

    /* renamed from: g  reason: collision with root package name */
    public TaskContext f51960g;

    public Task(long j8, TaskContext taskContext) {
        this.f51959f = j8;
        this.f51960g = taskContext;
    }

    public Task() {
        this(0L, TasksKt.f51968f);
    }
}
