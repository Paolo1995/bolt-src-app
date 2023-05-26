package io.ktor.client.plugins.logging;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ObservingUtils.kt */
/* loaded from: classes5.dex */
public final class ObservingUtilsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(io.ktor.http.content.OutgoingContent r4, io.ktor.utils.io.ByteWriteChannel r5, kotlin.coroutines.Continuation<? super io.ktor.http.content.OutgoingContent> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1 r0 = (io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1) r0
            int r1 = r0.f46576i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46576i = r1
            goto L18
        L13:
            io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1 r0 = new io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f46575h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46576i
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.f46574g
            r5 = r4
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            java.lang.Object r4 = r0.f46573f
            io.ktor.http.content.OutgoingContent r4 = (io.ktor.http.content.OutgoingContent) r4
            kotlin.ResultKt.b(r6)
            goto L55
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.b(r6)
            boolean r6 = r4 instanceof io.ktor.http.content.OutgoingContent.ByteArrayContent
            if (r6 == 0) goto L59
            r6 = r4
            io.ktor.http.content.OutgoingContent$ByteArrayContent r6 = (io.ktor.http.content.OutgoingContent.ByteArrayContent) r6
            byte[] r6 = r6.e()
            r0.f46573f = r4
            r0.f46574g = r5
            r0.f46576i = r3
            java.lang.Object r6 = io.ktor.utils.io.ByteWriteChannelKt.b(r5, r6, r0)
            if (r6 != r1) goto L55
            return r1
        L55:
            io.ktor.utils.io.ByteWriteChannelKt.a(r5)
            goto L8f
        L59:
            boolean r6 = r4 instanceof io.ktor.http.content.OutgoingContent.ReadChannelContent
            r0 = 0
            r1 = 0
            if (r6 == 0) goto L74
            io.ktor.utils.io.ByteChannel r6 = io.ktor.utils.io.ByteChannelKt.b(r1, r3, r0)
            r0 = r4
            io.ktor.http.content.OutgoingContent$ReadChannelContent r0 = (io.ktor.http.content.OutgoingContent.ReadChannelContent) r0
            io.ktor.utils.io.ByteReadChannel r0 = r0.e()
            io.ktor.util.ByteChannelsKt.a(r0, r5, r6)
            io.ktor.client.plugins.logging.LoggedContent r5 = new io.ktor.client.plugins.logging.LoggedContent
            r5.<init>(r4, r6)
        L72:
            r4 = r5
            goto L8f
        L74:
            boolean r6 = r4 instanceof io.ktor.http.content.OutgoingContent.WriteChannelContent
            if (r6 == 0) goto L8c
            io.ktor.utils.io.ByteChannel r6 = io.ktor.utils.io.ByteChannelKt.b(r1, r3, r0)
            r0 = r4
            io.ktor.http.content.OutgoingContent$WriteChannelContent r0 = (io.ktor.http.content.OutgoingContent.WriteChannelContent) r0
            io.ktor.utils.io.ByteReadChannel r0 = b(r0)
            io.ktor.util.ByteChannelsKt.a(r0, r5, r6)
            io.ktor.client.plugins.logging.LoggedContent r5 = new io.ktor.client.plugins.logging.LoggedContent
            r5.<init>(r4, r6)
            goto L72
        L8c:
            io.ktor.utils.io.ByteWriteChannelKt.a(r5)
        L8f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.ObservingUtilsKt.a(io.ktor.http.content.OutgoingContent, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final ByteReadChannel b(OutgoingContent.WriteChannelContent writeChannelContent) {
        return CoroutinesKt.c(GlobalScope.f51286f, Dispatchers.a(), false, new ObservingUtilsKt$toReadChannel$1(writeChannelContent, null), 2, null).getChannel();
    }
}
