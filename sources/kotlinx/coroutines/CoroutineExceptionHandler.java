package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes5.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {

    /* renamed from: c  reason: collision with root package name */
    public static final Key f51243c = Key.f51244f;

    /* compiled from: CoroutineExceptionHandler.kt */
    /* loaded from: classes5.dex */
    public static final class Key implements CoroutineContext.Key<CoroutineExceptionHandler> {

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ Key f51244f = new Key();

        private Key() {
        }
    }

    void k0(CoroutineContext coroutineContext, Throwable th);
}
