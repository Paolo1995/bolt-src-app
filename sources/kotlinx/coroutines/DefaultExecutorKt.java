package kotlinx.coroutines;

import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes5.dex */
public final class DefaultExecutorKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f51256a = SystemPropsKt.e("kotlinx.coroutines.main.delay", false);

    /* renamed from: b  reason: collision with root package name */
    private static final Delay f51257b = b();

    public static final Delay a() {
        return f51257b;
    }

    private static final Delay b() {
        if (!f51256a) {
            return DefaultExecutor.f51254m;
        }
        MainCoroutineDispatcher c8 = Dispatchers.c();
        if (!MainDispatchersKt.c(c8) && (c8 instanceof Delay)) {
            return (Delay) c8;
        }
        return DefaultExecutor.f51254m;
    }
}
