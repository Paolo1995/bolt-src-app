package io.ktor.client.call;

/* compiled from: SavedCall.kt */
/* loaded from: classes5.dex */
public final class SavedCallKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(io.ktor.client.call.HttpClientCall r8, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.client.call.SavedCallKt$save$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.client.call.SavedCallKt$save$1 r0 = (io.ktor.client.call.SavedCallKt$save$1) r0
            int r1 = r0.f46087h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46087h = r1
            goto L18
        L13:
            io.ktor.client.call.SavedCallKt$save$1 r0 = new io.ktor.client.call.SavedCallKt$save$1
            r0.<init>(r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.f46086g
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r1 = r4.f46087h
            r7 = 1
            if (r1 == 0) goto L36
            if (r1 != r7) goto L2e
            java.lang.Object r8 = r4.f46085f
            io.ktor.client.call.HttpClientCall r8 = (io.ktor.client.call.HttpClientCall) r8
            kotlin.ResultKt.b(r9)
            goto L50
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.b(r9)
            io.ktor.client.statement.HttpResponse r9 = r8.f()
            io.ktor.utils.io.ByteReadChannel r1 = r9.a()
            r2 = 0
            r5 = 1
            r6 = 0
            r4.f46085f = r8
            r4.f46087h = r7
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.a(r1, r2, r4, r5, r6)
            if (r9 != r0) goto L50
            return r0
        L50:
            io.ktor.utils.io.core.ByteReadPacket r9 = (io.ktor.utils.io.core.ByteReadPacket) r9
            r0 = 0
            r1 = 0
            byte[] r9 = io.ktor.utils.io.core.StringsKt.c(r9, r0, r7, r1)
            io.ktor.client.call.SavedHttpCall r0 = new io.ktor.client.call.SavedHttpCall
            io.ktor.client.HttpClient r1 = r8.c()
            io.ktor.client.request.HttpRequest r2 = r8.e()
            io.ktor.client.statement.HttpResponse r8 = r8.f()
            r0.<init>(r1, r2, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.call.SavedCallKt.a(io.ktor.client.call.HttpClientCall, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
