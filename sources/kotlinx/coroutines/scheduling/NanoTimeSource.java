package kotlinx.coroutines.scheduling;

/* compiled from: Tasks.kt */
/* loaded from: classes5.dex */
public final class NanoTimeSource extends SchedulerTimeSource {

    /* renamed from: a  reason: collision with root package name */
    public static final NanoTimeSource f51953a = new NanoTimeSource();

    private NanoTimeSource() {
    }

    @Override // kotlinx.coroutines.scheduling.SchedulerTimeSource
    public long a() {
        return System.nanoTime();
    }
}
