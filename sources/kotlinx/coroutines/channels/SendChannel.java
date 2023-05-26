package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: Channel.kt */
/* loaded from: classes5.dex */
public interface SendChannel<E> {

    /* compiled from: Channel.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean a(SendChannel sendChannel, Throwable th, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 1) != 0) {
                    th = null;
                }
                return sendChannel.b(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    Object D(E e8, Continuation<? super Unit> continuation);

    boolean E();

    boolean b(Throwable th);

    void s(Function1<? super Throwable, Unit> function1);

    Object u(E e8);
}
