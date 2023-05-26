package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes5.dex */
public final class MainDispatcherLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final MainDispatcherLoader f51820a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f51821b;

    /* renamed from: c  reason: collision with root package name */
    public static final MainCoroutineDispatcher f51822c;

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        f51820a = mainDispatcherLoader;
        f51821b = SystemPropsKt.e("kotlinx.coroutines.fast.service.loader", true);
        f51822c = mainDispatcherLoader.a();
    }

    private MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher a() {
        Sequence c8;
        List<MainDispatcherFactory> D;
        Object next;
        MainCoroutineDispatcher e8;
        try {
            if (f51821b) {
                D = FastServiceLoader.f51789a.c();
            } else {
                c8 = SequencesKt__SequencesKt.c(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator());
                D = SequencesKt___SequencesKt.D(c8);
            }
            Iterator<T> it = D.iterator();
            if (!it.hasNext()) {
                next = null;
            } else {
                next = it.next();
                if (it.hasNext()) {
                    int c9 = ((MainDispatcherFactory) next).c();
                    do {
                        Object next2 = it.next();
                        int c10 = ((MainDispatcherFactory) next2).c();
                        if (c9 < c10) {
                            next = next2;
                            c9 = c10;
                        }
                    } while (it.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            if (mainDispatcherFactory == null || (e8 = MainDispatchersKt.e(mainDispatcherFactory, D)) == null) {
                return MainDispatchersKt.b(null, null, 3, null);
            }
            return e8;
        } catch (Throwable th) {
            return MainDispatchersKt.b(th, null, 2, null);
        }
    }
}
