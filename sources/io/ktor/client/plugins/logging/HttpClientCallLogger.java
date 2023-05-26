package io.ktor.client.plugins.logging;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: HttpClientCallLogger.kt */
/* loaded from: classes5.dex */
public final class HttpClientCallLogger {

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f46496f = AtomicIntegerFieldUpdater.newUpdater(HttpClientCallLogger.class, "requestLogged");

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f46497g = AtomicIntegerFieldUpdater.newUpdater(HttpClientCallLogger.class, "responseLogged");

    /* renamed from: a  reason: collision with root package name */
    private final Logger f46498a;

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f46499b;

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f46500c;

    /* renamed from: d  reason: collision with root package name */
    private final CompletableJob f46501d;

    /* renamed from: e  reason: collision with root package name */
    private final CompletableJob f46502e;
    private volatile /* synthetic */ int requestLogged;
    private volatile /* synthetic */ int responseLogged;

    public HttpClientCallLogger(Logger logger) {
        CompletableJob b8;
        CompletableJob b9;
        Intrinsics.f(logger, "logger");
        this.f46498a = logger;
        this.f46499b = new StringBuilder();
        this.f46500c = new StringBuilder();
        b8 = JobKt__JobKt.b(null, 1, null);
        this.f46501d = b8;
        b9 = JobKt__JobKt.b(null, 1, null);
        this.f46502e = b9;
        this.requestLogged = 0;
        this.responseLogged = 0;
    }

    public final void a() {
        CharSequence Y0;
        boolean z7 = false;
        if (!f46496f.compareAndSet(this, 0, 1)) {
            return;
        }
        try {
            Y0 = StringsKt__StringsKt.Y0(this.f46499b);
            String obj = Y0.toString();
            if (obj.length() > 0) {
                z7 = true;
            }
            if (z7) {
                this.f46498a.log(obj);
            }
        } finally {
            this.f46501d.k();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1 r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1) r0
            int r1 = r0.f46506i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46506i = r1
            goto L18
        L13:
            io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1 r0 = new io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f46504g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46506i
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r0 = r0.f46503f
            io.ktor.client.plugins.logging.HttpClientCallLogger r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger) r0
            kotlin.ResultKt.b(r6)
            goto L52
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.b(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = io.ktor.client.plugins.logging.HttpClientCallLogger.f46497g
            boolean r6 = r6.compareAndSet(r5, r3, r4)
            if (r6 != 0) goto L44
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L44:
            kotlinx.coroutines.CompletableJob r6 = r5.f46501d
            r0.f46503f = r5
            r0.f46506i = r4
            java.lang.Object r6 = r6.v0(r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            r0 = r5
        L52:
            java.lang.StringBuilder r6 = r0.f46500c
            java.lang.CharSequence r6 = kotlin.text.StringsKt.Y0(r6)
            java.lang.String r6 = r6.toString()
            int r1 = r6.length()
            if (r1 <= 0) goto L63
            r3 = 1
        L63:
            if (r3 == 0) goto L6a
            io.ktor.client.plugins.logging.Logger r0 = r0.f46498a
            r0.log(r6)
        L6a:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.HttpClientCallLogger.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void c(String message) {
        CharSequence Y0;
        Intrinsics.f(message, "message");
        StringBuilder sb = this.f46499b;
        Y0 = StringsKt__StringsKt.Y0(message);
        sb.append(Y0.toString());
        Intrinsics.e(sb, "append(value)");
        sb.append('\n');
        Intrinsics.e(sb, "append('\\n')");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1 r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1) r0
            int r1 = r0.f46511j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46511j = r1
            goto L18
        L13:
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1 r0 = new io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f46509h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46511j
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f46508g
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.f46507f
            io.ktor.client.plugins.logging.HttpClientCallLogger r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger) r0
            kotlin.ResultKt.b(r6)
            goto L4c
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.CompletableJob r6 = r4.f46502e
            r0.f46507f = r4
            r0.f46508g = r5
            r0.f46511j = r3
            java.lang.Object r6 = r6.v0(r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
        L4c:
            java.lang.StringBuilder r6 = r0.f46500c
            r6.append(r5)
            kotlin.Unit r5 = kotlin.Unit.f50853a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.HttpClientCallLogger.d(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1 r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1) r0
            int r1 = r0.f46516j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46516j = r1
            goto L18
        L13:
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1 r0 = new io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f46514h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46516j
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f46513g
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.f46512f
            io.ktor.client.plugins.logging.HttpClientCallLogger r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger) r0
            kotlin.ResultKt.b(r6)
            goto L4c
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.CompletableJob r6 = r4.f46501d
            r0.f46512f = r4
            r0.f46513g = r5
            r0.f46516j = r3
            java.lang.Object r6 = r6.v0(r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
        L4c:
            io.ktor.client.plugins.logging.Logger r6 = r0.f46498a
            java.lang.CharSequence r5 = kotlin.text.StringsKt.Y0(r5)
            java.lang.String r5 = r5.toString()
            r6.log(r5)
            kotlin.Unit r5 = kotlin.Unit.f50853a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.HttpClientCallLogger.e(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void f(String message) {
        CharSequence Y0;
        Intrinsics.f(message, "message");
        StringBuilder sb = this.f46500c;
        Y0 = StringsKt__StringsKt.Y0(message);
        sb.append(Y0.toString());
        Intrinsics.e(sb, "append(value)");
        sb.append('\n');
        Intrinsics.e(sb, "append('\\n')");
        this.f46502e.k();
    }
}
