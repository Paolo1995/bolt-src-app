package kotlinx.coroutines;

import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: Dispatchers.kt */
/* loaded from: classes5.dex */
public final class Dispatchers {

    /* renamed from: a  reason: collision with root package name */
    public static final Dispatchers f51262a = new Dispatchers();

    /* renamed from: b  reason: collision with root package name */
    private static final CoroutineDispatcher f51263b = DefaultScheduler.f51952n;

    /* renamed from: c  reason: collision with root package name */
    private static final CoroutineDispatcher f51264c = Unconfined.f51345h;

    /* renamed from: d  reason: collision with root package name */
    private static final CoroutineDispatcher f51265d = DefaultIoScheduler.f51950i;

    private Dispatchers() {
    }

    public static final CoroutineDispatcher a() {
        return f51263b;
    }

    public static final CoroutineDispatcher b() {
        return f51265d;
    }

    public static final MainCoroutineDispatcher c() {
        return MainDispatcherLoader.f51822c;
    }

    public static final CoroutineDispatcher d() {
        return f51264c;
    }
}
