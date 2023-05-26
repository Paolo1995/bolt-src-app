package eu.bolt.chat.client;

import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
/* loaded from: classes5.dex */
public final class ChatManagerImpl$accumulateAndPublishSeenEvents$2<T> implements FlowCollector {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38551f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatManagerImpl$accumulateAndPublishSeenEvents$2(ChatManagerImpl chatManagerImpl) {
        this.f38551f = chatManagerImpl;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4 A[RETURN] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.util.List<? extends java.util.List<java.lang.String>> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof eu.bolt.chat.client.ChatManagerImpl$accumulateAndPublishSeenEvents$2$emit$1
            if (r0 == 0) goto L13
            r0 = r13
            eu.bolt.chat.client.ChatManagerImpl$accumulateAndPublishSeenEvents$2$emit$1 r0 = (eu.bolt.chat.client.ChatManagerImpl$accumulateAndPublishSeenEvents$2$emit$1) r0
            int r1 = r0.f38556j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38556j = r1
            goto L18
        L13:
            eu.bolt.chat.client.ChatManagerImpl$accumulateAndPublishSeenEvents$2$emit$1 r0 = new eu.bolt.chat.client.ChatManagerImpl$accumulateAndPublishSeenEvents$2$emit$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.f38554h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38556j
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L42
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r13)
            goto Lc5
        L2e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L36:
            java.lang.Object r12 = r0.f38553g
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r2 = r0.f38552f
            eu.bolt.chat.client.ChatManagerImpl$accumulateAndPublishSeenEvents$2 r2 = (eu.bolt.chat.client.ChatManagerImpl$accumulateAndPublishSeenEvents$2) r2
            kotlin.ResultKt.b(r13)
            goto Lb0
        L42:
            kotlin.ResultKt.b(r13)
            eu.bolt.chat.util.UUID r13 = eu.bolt.chat.util.UUID.f39707a
            java.lang.String r13 = r13.a()
            eu.bolt.chat.client.ChatManagerImpl r2 = r11.f38551f
            boolean r2 = eu.bolt.chat.client.ChatManagerImpl.A(r2)
            if (r2 == 0) goto Lc8
            java.util.List r12 = kotlin.collections.CollectionsKt.x(r12)
            eu.bolt.chat.client.ChatManagerImpl r2 = r11.f38551f
            co.touchlab.kermit.Logger r2 = eu.bolt.chat.client.ChatManagerImpl.w(r2)
            co.touchlab.kermit.LoggerConfig r6 = r2.c()
            co.touchlab.kermit.Severity r6 = r6.a()
            co.touchlab.kermit.Severity r7 = co.touchlab.kermit.Severity.Debug
            int r6 = r6.compareTo(r7)
            if (r6 > 0) goto L8e
            java.lang.String r6 = r2.d()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "About to send collected seen events for "
            r8.append(r9)
            int r9 = r12.size()
            r8.append(r9)
            java.lang.String r9 = " messages"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r2.f(r7, r6, r5, r8)
        L8e:
            eu.bolt.chat.client.ChatManagerImpl r2 = r11.f38551f
            eu.bolt.chat.client.MessagePublisher r2 = eu.bolt.chat.client.ChatManagerImpl.x(r2)
            eu.bolt.chat.data.message.UserSeenMessage r6 = new eu.bolt.chat.data.message.UserSeenMessage
            eu.bolt.chat.client.ChatManagerImpl r7 = r11.f38551f
            java.lang.String r7 = eu.bolt.chat.client.ChatManagerImpl.t(r7)
            r6.<init>(r13, r7, r12)
            r0.f38552f = r11
            r0.f38553g = r13
            r0.f38556j = r4
            java.lang.Object r12 = r2.e(r6, r0)
            if (r12 != r1) goto Lac
            return r1
        Lac:
            r2 = r11
            r10 = r13
            r13 = r12
            r12 = r10
        Lb0:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            eu.bolt.chat.client.ChatManagerImpl r2 = r2.f38551f
            r0.f38552f = r5
            r0.f38553g = r5
            r0.f38556j = r3
            java.lang.Object r12 = eu.bolt.chat.client.ChatManagerImpl.G(r2, r13, r12, r0)
            if (r12 != r1) goto Lc5
            return r1
        Lc5:
            kotlin.Unit r12 = kotlin.Unit.f50853a
            return r12
        Lc8:
            kotlin.Unit r12 = kotlin.Unit.f50853a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl$accumulateAndPublishSeenEvents$2.b(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
