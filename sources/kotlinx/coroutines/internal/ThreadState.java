package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadContext.kt */
/* loaded from: classes5.dex */
public final class ThreadState {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f51845a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f51846b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadContextElement<Object>[] f51847c;

    /* renamed from: d  reason: collision with root package name */
    private int f51848d;

    public ThreadState(CoroutineContext coroutineContext, int i8) {
        this.f51845a = coroutineContext;
        this.f51846b = new Object[i8];
        this.f51847c = new ThreadContextElement[i8];
    }

    public final void a(ThreadContextElement<?> threadContextElement, Object obj) {
        Object[] objArr = this.f51846b;
        int i8 = this.f51848d;
        objArr[i8] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.f51847c;
        this.f51848d = i8 + 1;
        threadContextElementArr[i8] = threadContextElement;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.f51847c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i8 = length - 1;
            ThreadContextElement<Object> threadContextElement = this.f51847c[length];
            Intrinsics.c(threadContextElement);
            threadContextElement.c0(coroutineContext, this.f51846b[length]);
            if (i8 >= 0) {
                length = i8;
            } else {
                return;
            }
        }
    }
}
