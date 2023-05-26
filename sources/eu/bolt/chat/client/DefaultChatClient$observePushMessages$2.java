package eu.bolt.chat.client;

import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
/* loaded from: classes5.dex */
public final class DefaultChatClient$observePushMessages$2<T> implements FlowCollector {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38777f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChatClient$observePushMessages$2(DefaultChatClient defaultChatClient) {
        this.f38777f = defaultChatClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(eu.bolt.chat.data.ChatPushMessage r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof eu.bolt.chat.client.DefaultChatClient$observePushMessages$2$emit$1
            if (r0 == 0) goto L13
            r0 = r9
            eu.bolt.chat.client.DefaultChatClient$observePushMessages$2$emit$1 r0 = (eu.bolt.chat.client.DefaultChatClient$observePushMessages$2$emit$1) r0
            int r1 = r0.f38782j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38782j = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$observePushMessages$2$emit$1 r0 = new eu.bolt.chat.client.DefaultChatClient$observePushMessages$2$emit$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f38780h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38782j
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3b
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r9)
            goto L93
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.b(r9)
            goto L7d
        L3b:
            java.lang.Object r8 = r0.f38779g
            eu.bolt.chat.client.InternalChatManager r8 = (eu.bolt.chat.client.InternalChatManager) r8
            java.lang.Object r2 = r0.f38778f
            eu.bolt.chat.data.message.ChatMessage r2 = (eu.bolt.chat.data.message.ChatMessage) r2
            kotlin.ResultKt.b(r9)
            goto L69
        L47:
            kotlin.ResultKt.b(r9)
            eu.bolt.chat.data.Chat r9 = r8.a()
            eu.bolt.chat.data.message.ChatMessage r2 = r8.b()
            eu.bolt.chat.client.DefaultChatClient r8 = r7.f38777f
            java.lang.String r6 = r9.d()
            eu.bolt.chat.client.InternalChatManager r8 = eu.bolt.chat.client.DefaultChatClient.l(r8, r6)
            r0.f38778f = r2
            r0.f38779g = r8
            r0.f38782j = r5
            java.lang.Object r9 = r8.a(r9, r0)
            if (r9 != r1) goto L69
            return r1
        L69:
            boolean r9 = r2 instanceof eu.bolt.chat.data.message.UserMessage
            r5 = 0
            if (r9 == 0) goto L80
            eu.bolt.chat.data.message.UserMessage r2 = (eu.bolt.chat.data.message.UserMessage) r2
            r0.f38778f = r5
            r0.f38779g = r5
            r0.f38782j = r4
            java.lang.Object r8 = r8.p(r2, r0)
            if (r8 != r1) goto L7d
            return r1
        L7d:
            kotlin.Unit r8 = kotlin.Unit.f50853a
            return r8
        L80:
            boolean r9 = r2 instanceof eu.bolt.chat.data.message.ServiceMessage
            if (r9 == 0) goto L96
            eu.bolt.chat.data.message.ServiceMessage r2 = (eu.bolt.chat.data.message.ServiceMessage) r2
            r0.f38778f = r5
            r0.f38779g = r5
            r0.f38782j = r3
            java.lang.Object r8 = r8.n(r2, r0)
            if (r8 != r1) goto L93
            return r1
        L93:
            kotlin.Unit r8 = kotlin.Unit.f50853a
            return r8
        L96:
            kotlin.Unit r8 = kotlin.Unit.f50853a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient$observePushMessages$2.b(eu.bolt.chat.data.ChatPushMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
