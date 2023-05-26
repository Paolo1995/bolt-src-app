package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes5.dex */
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {

    /* renamed from: i  reason: collision with root package name */
    private ThreadLocal<Pair<CoroutineContext, Object>> f51346i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UndispatchedCoroutine(kotlin.coroutines.CoroutineContext r3, kotlin.coroutines.Continuation<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.UndispatchedMarker r0 = kotlinx.coroutines.UndispatchedMarker.f51347f
            kotlin.coroutines.CoroutineContext$Element r1 = r3.g(r0)
            if (r1 != 0) goto Ld
            kotlin.coroutines.CoroutineContext r0 = r3.s0(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f51346i = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.ContinuationInterceptor$Key r0 = kotlin.coroutines.ContinuationInterceptor.f50909b
            kotlin.coroutines.CoroutineContext$Element r4 = r4.g(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r4)
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r4)
            r2.m1(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.UndispatchedCoroutine.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):void");
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    protected void f1(Object obj) {
        Pair<CoroutineContext, Object> pair = this.f51346i.get();
        UndispatchedCoroutine<?> undispatchedCoroutine = null;
        if (pair != null) {
            ThreadContextKt.a(pair.a(), pair.b());
            this.f51346i.set(null);
        }
        Object a8 = CompletionStateKt.a(obj, this.f51830h);
        Continuation<T> continuation = this.f51830h;
        CoroutineContext context = continuation.getContext();
        Object c8 = ThreadContextKt.c(context, null);
        if (c8 != ThreadContextKt.f51837a) {
            undispatchedCoroutine = CoroutineContextKt.g(continuation, context, c8);
        }
        try {
            this.f51830h.resumeWith(a8);
            Unit unit = Unit.f50853a;
        } finally {
            if (undispatchedCoroutine == null || undispatchedCoroutine.l1()) {
                ThreadContextKt.a(context, c8);
            }
        }
    }

    public final boolean l1() {
        if (this.f51346i.get() == null) {
            return false;
        }
        this.f51346i.set(null);
        return true;
    }

    public final void m1(CoroutineContext coroutineContext, Object obj) {
        this.f51346i.set(TuplesKt.a(coroutineContext, obj));
    }
}
