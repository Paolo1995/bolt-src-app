package io.ktor.utils.io.jvm.javaio;

import kotlinx.coroutines.Job;

/* compiled from: Blocking.kt */
/* loaded from: classes5.dex */
public final class InputAdapter$loop$1 extends BlockingAdapter {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ InputAdapter f47495g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAdapter$loop$1(Job job, InputAdapter inputAdapter) {
        super(job);
        this.f47495g = inputAdapter;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007c -> B:25:0x007f). Please submit an issue!!! */
    @Override // io.ktor.utils.io.jvm.javaio.BlockingAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object h(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1 r0 = (io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1) r0
            int r1 = r0.f47500j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47500j = r1
            goto L18
        L13:
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1 r0 = new io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f47498h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47500j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r2 = r0.f47496f
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1 r2 = (io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1) r2
            kotlin.ResultKt.b(r10)
            goto L7f
        L30:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L38:
            java.lang.Object r2 = r0.f47497g
            io.ktor.utils.io.jvm.javaio.BlockingAdapter r2 = (io.ktor.utils.io.jvm.javaio.BlockingAdapter) r2
            java.lang.Object r2 = r0.f47496f
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1 r2 = (io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1) r2
            kotlin.ResultKt.b(r10)
            goto L61
        L44:
            kotlin.ResultKt.b(r10)
            r10 = 0
            r2 = r9
        L49:
            r2.result = r10
            r0.f47496f = r2
            r0.f47497g = r2
            r0.f47500j = r4
            java.lang.Object r10 = io.ktor.utils.io.jvm.javaio.BlockingAdapter.c(r2, r0)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            if (r10 != r5) goto L5e
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L5e:
            if (r10 != r1) goto L61
            return r1
        L61:
            byte[] r10 = (byte[]) r10
            io.ktor.utils.io.jvm.javaio.InputAdapter r5 = r2.f47495g
            io.ktor.utils.io.ByteReadChannel r5 = io.ktor.utils.io.jvm.javaio.InputAdapter.a(r5)
            int r6 = r2.f()
            int r7 = r2.e()
            r0.f47496f = r2
            r8 = 0
            r0.f47497g = r8
            r0.f47500j = r3
            java.lang.Object r10 = r5.g(r10, r6, r7, r0)
            if (r10 != r1) goto L7f
            return r1
        L7f:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            r5 = -1
            if (r10 != r5) goto L49
            io.ktor.utils.io.jvm.javaio.InputAdapter r0 = r2.f47495g
            kotlinx.coroutines.CompletableJob r0 = io.ktor.utils.io.jvm.javaio.InputAdapter.c(r0)
            r0.k()
            r2.d(r10)
            kotlin.Unit r10 = kotlin.Unit.f50853a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1.h(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
