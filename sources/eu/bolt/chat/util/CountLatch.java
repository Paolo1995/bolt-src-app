package eu.bolt.chat.util;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: CountLatch.kt */
/* loaded from: classes5.dex */
public final class CountLatch {

    /* renamed from: a  reason: collision with root package name */
    private final int f39684a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext f39685b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicRef<CompletableDeferred<Unit>> f39686c;

    /* renamed from: d  reason: collision with root package name */
    private final Mutex f39687d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicInt f39688e;

    public CountLatch(int i8, int i9, CoroutineContext context) {
        Intrinsics.f(context, "context");
        this.f39684a = i9;
        this.f39685b = context;
        AtomicRef<CompletableDeferred<Unit>> e8 = AtomicFU.e(CompletableDeferredKt.b(null, 1, null));
        this.f39686c = e8;
        this.f39687d = MutexKt.b(false, 1, null);
        this.f39688e = AtomicFU.c(i8);
        if (!(i8 >= 0)) {
            throw new IllegalArgumentException("Initial CountLatch value must be >= 0".toString());
        }
        if (i8 <= i9) {
            if (i8 == 0) {
                e8.b().d0(Unit.f50853a);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Initial CountLatch must be <= " + i9).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a A[Catch: all -> 0x009b, TryCatch #0 {all -> 0x009b, blocks: (B:28:0x007c, B:30:0x008a, B:31:0x0093), top: B:37:0x007c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(kotlin.jvm.functions.Function0<java.lang.Integer> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.util.CountLatch$updateLatch$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.util.CountLatch$updateLatch$1 r0 = (eu.bolt.chat.util.CountLatch$updateLatch$1) r0
            int r1 = r0.f39699j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39699j = r1
            goto L18
        L13:
            eu.bolt.chat.util.CountLatch$updateLatch$1 r0 = new eu.bolt.chat.util.CountLatch$updateLatch$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f39697h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39699j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f39696g
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r0 = r0.f39695f
            eu.bolt.chat.util.CountLatch r0 = (eu.bolt.chat.util.CountLatch) r0
            kotlin.ResultKt.b(r7)
            goto L7c
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.b(r7)
            java.lang.Object r6 = r6.invoke()
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r6 >= 0) goto L50
            kotlinx.atomicfu.AtomicInt r6 = r5.f39688e
            r7 = 0
            r6.c(r7)
            goto L69
        L50:
            int r7 = r5.f39684a
            if (r6 <= r7) goto L5a
            kotlinx.atomicfu.AtomicInt r6 = r5.f39688e
            r6.c(r7)
            goto L69
        L5a:
            if (r6 != 0) goto L6c
            kotlinx.atomicfu.AtomicRef<kotlinx.coroutines.CompletableDeferred<kotlin.Unit>> r6 = r5.f39686c
            java.lang.Object r6 = r6.b()
            kotlinx.coroutines.CompletableDeferred r6 = (kotlinx.coroutines.CompletableDeferred) r6
            kotlin.Unit r7 = kotlin.Unit.f50853a
            r6.d0(r7)
        L69:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L6c:
            kotlinx.coroutines.sync.Mutex r6 = r5.f39687d
            r0.f39695f = r5
            r0.f39696g = r6
            r0.f39699j = r3
            java.lang.Object r7 = r6.a(r4, r0)
            if (r7 != r1) goto L7b
            return r1
        L7b:
            r0 = r5
        L7c:
            kotlinx.atomicfu.AtomicRef<kotlinx.coroutines.CompletableDeferred<kotlin.Unit>> r7 = r0.f39686c     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r7 = r7.b()     // Catch: java.lang.Throwable -> L9b
            kotlinx.coroutines.CompletableDeferred r7 = (kotlinx.coroutines.CompletableDeferred) r7     // Catch: java.lang.Throwable -> L9b
            boolean r7 = r7.c()     // Catch: java.lang.Throwable -> L9b
            if (r7 == 0) goto L93
            kotlinx.atomicfu.AtomicRef<kotlinx.coroutines.CompletableDeferred<kotlin.Unit>> r7 = r0.f39686c     // Catch: java.lang.Throwable -> L9b
            kotlinx.coroutines.CompletableDeferred r0 = kotlinx.coroutines.CompletableDeferredKt.b(r4, r3, r4)     // Catch: java.lang.Throwable -> L9b
            r7.c(r0)     // Catch: java.lang.Throwable -> L9b
        L93:
            kotlin.Unit r7 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L9b
            r6.b(r4)
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L9b:
            r7 = move-exception
            r6.b(r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.util.CountLatch.f(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object c(Continuation<? super Unit> continuation) {
        Object d8;
        Object N = this.f39686c.b().N(continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (N == d8) {
            return N;
        }
        return Unit.f50853a;
    }

    public final void d() {
        BuildersKt.e(this.f39685b, new CountLatch$countDown$1(this, null));
    }

    public final void e() {
        BuildersKt.e(this.f39685b, new CountLatch$countUp$1(this, null));
    }

    public /* synthetic */ CountLatch(int i8, int i9, CoroutineContext coroutineContext, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(i8, (i10 & 2) != 0 ? i8 : i9, coroutineContext);
    }
}
