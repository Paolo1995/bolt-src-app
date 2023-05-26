package kotlinx.coroutines.scheduling;

/* compiled from: Tasks.kt */
/* loaded from: classes5.dex */
final class TaskContextImpl implements TaskContext {

    /* renamed from: a  reason: collision with root package name */
    private final int f51961a;

    public TaskContextImpl(int i8) {
        this.f51961a = i8;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void a() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int b() {
        return this.f51961a;
    }
}
