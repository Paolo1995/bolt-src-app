package eu.bolt.chat.client;

import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
/* loaded from: classes5.dex */
public final class DefaultChatClient$flushPendingMessagesWhenConnected$3<T> implements FlowCollector {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38730f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChatClient$flushPendingMessagesWhenConnected$3(DefaultChatClient defaultChatClient) {
        this.f38730f = defaultChatClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(eu.bolt.chat.data.ClientStatus r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r7 = r8 instanceof eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$3$emit$1
            if (r7 == 0) goto L13
            r7 = r8
            eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$3$emit$1 r7 = (eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$3$emit$1) r7
            int r0 = r7.f38734i
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r7.f38734i = r0
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$3$emit$1 r7 = new eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$3$emit$1
            r7.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r7.f38732g
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r1 = r7.f38734i
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r1 = r7.f38731f
            java.util.Iterator r1 = (java.util.Iterator) r1
            kotlin.ResultKt.b(r8)
            goto L9d
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r8)
            eu.bolt.chat.client.DefaultChatClient r8 = r6.f38730f
            kotlinx.coroutines.flow.MutableStateFlow r8 = eu.bolt.chat.client.DefaultChatClient.k(r8)
            java.lang.Object r8 = r8.getValue()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            eu.bolt.chat.client.DefaultChatClient r1 = r6.f38730f
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.v(r8, r4)
            r3.<init>(r4)
            java.util.Iterator r8 = r8.iterator()
        L55:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L6d
            java.lang.Object r4 = r8.next()
            eu.bolt.chat.data.Chat r4 = (eu.bolt.chat.data.Chat) r4
            java.lang.String r4 = r4.d()
            eu.bolt.chat.client.InternalChatManager r4 = eu.bolt.chat.client.DefaultChatClient.l(r1, r4)
            r3.add(r4)
            goto L55
        L6d:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r1 = r3.iterator()
        L76:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L98
            java.lang.Object r3 = r1.next()
            r4 = r3
            eu.bolt.chat.client.InternalChatManager r4 = (eu.bolt.chat.client.InternalChatManager) r4
            eu.bolt.chat.async.ObservableStateFlow r4 = r4.r()
            java.lang.Object r4 = r4.getValue()
            eu.bolt.chat.data.ChatStatus r5 = eu.bolt.chat.data.ChatStatus.STARTED
            if (r4 != r5) goto L91
            r4 = 1
            goto L92
        L91:
            r4 = 0
        L92:
            if (r4 == 0) goto L76
            r8.add(r3)
            goto L76
        L98:
            java.util.Iterator r8 = r8.iterator()
            r1 = r8
        L9d:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto Lb4
            java.lang.Object r8 = r1.next()
            eu.bolt.chat.client.InternalChatManager r8 = (eu.bolt.chat.client.InternalChatManager) r8
            r7.f38731f = r1
            r7.f38734i = r2
            java.lang.Object r8 = r8.e(r7)
            if (r8 != r0) goto L9d
            return r0
        Lb4:
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$3.b(eu.bolt.chat.data.ClientStatus, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
