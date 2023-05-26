package eu.bolt.chat.util;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* compiled from: AppStateObserver.kt */
/* loaded from: classes5.dex */
public final class AppStateObserver implements ForegroundStateListener {

    /* renamed from: a  reason: collision with root package name */
    private final Logger f39676a;

    /* renamed from: b  reason: collision with root package name */
    private final CountLatch f39677b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f39678c;

    public AppStateObserver(CoroutineContext context, Logger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(logger, "logger");
        this.f39676a = logger;
        this.f39677b = new CountLatch(1, 0, context, 2, null);
        this.f39678c = AtomicFU.a(true);
    }

    @Override // eu.bolt.chat.util.ForegroundStateListener
    public void a() {
        if (this.f39678c.a(false, true)) {
            Logger logger = this.f39676a;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Info;
            if (a8.compareTo(severity) <= 0) {
                logger.f(severity, logger.d(), null, "App is in the background");
            }
            this.f39677b.e();
        }
    }

    @Override // eu.bolt.chat.util.ForegroundStateListener
    public void b() {
        if (this.f39678c.a(true, false)) {
            Logger logger = this.f39676a;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Info;
            if (a8.compareTo(severity) <= 0) {
                logger.f(severity, logger.d(), null, "App is in the foreground");
            }
            this.f39677b.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof eu.bolt.chat.util.AppStateObserver$ensureInForeground$1
            if (r0 == 0) goto L13
            r0 = r9
            eu.bolt.chat.util.AppStateObserver$ensureInForeground$1 r0 = (eu.bolt.chat.util.AppStateObserver$ensureInForeground$1) r0
            int r1 = r0.f39683j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39683j = r1
            goto L18
        L13:
            eu.bolt.chat.util.AppStateObserver$ensureInForeground$1 r0 = new eu.bolt.chat.util.AppStateObserver$ensureInForeground$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f39681h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39683j
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            boolean r1 = r0.f39680g
            java.lang.Object r0 = r0.f39679f
            eu.bolt.chat.util.AppStateObserver r0 = (eu.bolt.chat.util.AppStateObserver) r0
            kotlin.ResultKt.b(r9)
            goto L6f
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L38:
            kotlin.ResultKt.b(r9)
            kotlinx.atomicfu.AtomicBoolean r9 = r8.f39678c
            boolean r9 = r9.b()
            if (r9 == 0) goto L5e
            co.touchlab.kermit.Logger r2 = r8.f39676a
            co.touchlab.kermit.LoggerConfig r5 = r2.c()
            co.touchlab.kermit.Severity r5 = r5.a()
            co.touchlab.kermit.Severity r6 = co.touchlab.kermit.Severity.Debug
            int r5 = r5.compareTo(r6)
            if (r5 > 0) goto L5e
            java.lang.String r5 = r2.d()
            java.lang.String r7 = "App is in the background. Need to wait until it's in the foreground"
            r2.f(r6, r5, r3, r7)
        L5e:
            eu.bolt.chat.util.CountLatch r2 = r8.f39677b
            r0.f39679f = r8
            r0.f39680g = r9
            r0.f39683j = r4
            java.lang.Object r0 = r2.c(r0)
            if (r0 != r1) goto L6d
            return r1
        L6d:
            r0 = r8
            r1 = r9
        L6f:
            if (r1 == 0) goto L8c
            co.touchlab.kermit.Logger r9 = r0.f39676a
            co.touchlab.kermit.LoggerConfig r0 = r9.c()
            co.touchlab.kermit.Severity r0 = r0.a()
            co.touchlab.kermit.Severity r1 = co.touchlab.kermit.Severity.Debug
            int r0 = r0.compareTo(r1)
            if (r0 > 0) goto L8c
            java.lang.String r0 = r9.d()
            java.lang.String r2 = "Resumed currently suspended operation"
            r9.f(r1, r0, r3, r2)
        L8c:
            kotlin.Unit r9 = kotlin.Unit.f50853a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.util.AppStateObserver.c(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
