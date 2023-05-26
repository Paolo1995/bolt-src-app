package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import eu.bolt.chat.data.message.QuickReplyMessage;
import eu.bolt.chat.data.message.QuickReplyRequestMessage;
import eu.bolt.chat.data.message.UserSeenMessage;
import eu.bolt.chat.data.message.UserTextMessage;
import eu.bolt.chat.network.data.ChatConfig;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.data.serializer.MqttChatMessageEncoder;
import eu.bolt.chat.network.engine.MqttClient;
import eu.bolt.chat.storage.PendingRawMessageStorage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessagePublisher.kt */
/* loaded from: classes5.dex */
public final class DefaultMessagePublisher implements MessagePublisher {

    /* renamed from: a  reason: collision with root package name */
    private final Logger f38885a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatConfig f38886b;

    /* renamed from: c  reason: collision with root package name */
    private final MqttClient f38887c;

    /* renamed from: d  reason: collision with root package name */
    private final MqttChatMessageEncoder f38888d;

    /* renamed from: e  reason: collision with root package name */
    private final PendingRawMessageStorage f38889e;

    public DefaultMessagePublisher(Logger logger, ChatConfig chatConfig, MqttClient mqttClient, MqttChatMessageEncoder messageEncoder, PendingRawMessageStorage pendingRawMessageStorage) {
        Intrinsics.f(logger, "logger");
        Intrinsics.f(chatConfig, "chatConfig");
        Intrinsics.f(mqttClient, "mqttClient");
        Intrinsics.f(messageEncoder, "messageEncoder");
        Intrinsics.f(pendingRawMessageStorage, "pendingRawMessageStorage");
        this.f38885a = logger;
        this.f38886b = chatConfig;
        this.f38887c = mqttClient;
        this.f38888d = messageEncoder;
        this.f38889e = pendingRawMessageStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(java.lang.String r9, java.lang.String r10, java.lang.String r11, kotlin.coroutines.Continuation<? super java.lang.Boolean> r12) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultMessagePublisher.i(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(eu.bolt.chat.network.data.MqttMessage r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof eu.bolt.chat.client.DefaultMessagePublisher$sendRawMessage$1
            if (r0 == 0) goto L13
            r0 = r8
            eu.bolt.chat.client.DefaultMessagePublisher$sendRawMessage$1 r0 = (eu.bolt.chat.client.DefaultMessagePublisher$sendRawMessage$1) r0
            int r1 = r0.f38910i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38910i = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultMessagePublisher$sendRawMessage$1 r0 = new eu.bolt.chat.client.DefaultMessagePublisher$sendRawMessage$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f38908g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38910i
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.f38907f
            eu.bolt.chat.client.DefaultMessagePublisher r7 = (eu.bolt.chat.client.DefaultMessagePublisher) r7
            kotlin.ResultKt.b(r8)
            goto L4c
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r8)
            eu.bolt.chat.network.engine.MqttClient r8 = r6.f38887c
            eu.bolt.chat.network.data.ChatConfig r2 = r6.f38886b
            eu.bolt.chat.network.data.QoS r2 = r2.d()
            r0.f38907f = r6
            r0.f38910i = r3
            java.lang.Object r8 = r8.d(r7, r2, r0)
            if (r8 != r1) goto L4b
            return r1
        L4b:
            r7 = r6
        L4c:
            eu.bolt.chat.network.engine.PublishingEvent r8 = (eu.bolt.chat.network.engine.PublishingEvent) r8
            boolean r0 = r8 instanceof eu.bolt.chat.network.engine.PublishingEvent.Success
            if (r0 == 0) goto L84
            co.touchlab.kermit.Logger r7 = r7.f38885a
            co.touchlab.kermit.LoggerConfig r0 = r7.c()
            co.touchlab.kermit.Severity r0 = r0.a()
            co.touchlab.kermit.Severity r1 = co.touchlab.kermit.Severity.Debug
            int r0 = r0.compareTo(r1)
            if (r0 > 0) goto Lbd
            java.lang.String r0 = r7.d()
            r2 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Successfully published a message: "
            r4.append(r5)
            eu.bolt.chat.network.engine.PublishingEvent$Success r8 = (eu.bolt.chat.network.engine.PublishingEvent.Success) r8
            eu.bolt.chat.network.data.MqttMessage r8 = r8.a()
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            r7.f(r1, r0, r2, r8)
            goto Lbd
        L84:
            boolean r0 = r8 instanceof eu.bolt.chat.network.engine.PublishingEvent.Failure
            if (r0 == 0) goto Lc2
            co.touchlab.kermit.Logger r7 = r7.f38885a
            eu.bolt.chat.network.engine.PublishingEvent$Failure r8 = (eu.bolt.chat.network.engine.PublishingEvent.Failure) r8
            eu.bolt.chat.network.exception.PublishingException r0 = r8.a()
            co.touchlab.kermit.LoggerConfig r1 = r7.c()
            co.touchlab.kermit.Severity r1 = r1.a()
            co.touchlab.kermit.Severity r2 = co.touchlab.kermit.Severity.Error
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto Lbc
            java.lang.String r1 = r7.d()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Can not publish a message: "
            r3.append(r4)
            eu.bolt.chat.network.data.MqttMessage r8 = r8.b()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r7.f(r2, r1, r0, r8)
        Lbc:
            r3 = 0
        Lbd:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        Lc2:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultMessagePublisher.j(eu.bolt.chat.network.data.MqttMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.chat.client.MessagePublisher
    public Object a(QuickReplyMessage quickReplyMessage, Continuation<? super Boolean> continuation) {
        return i(this.f38888d.a(quickReplyMessage), quickReplyMessage.getId(), quickReplyMessage.d(), continuation);
    }

    @Override // eu.bolt.chat.client.MessagePublisher
    public Object b(String str, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = this.f38889e.a(str, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.MessagePublisher
    public Object c(UserTextMessage userTextMessage, Continuation<? super Boolean> continuation) {
        return i(this.f38888d.c(userTextMessage), userTextMessage.getId(), userTextMessage.d(), continuation);
    }

    @Override // eu.bolt.chat.client.MessagePublisher
    public Object d(QuickReplyRequestMessage quickReplyRequestMessage, Continuation<? super Unit> continuation) {
        Object d8;
        Object j8 = j(new MqttMessage(this.f38886b.e(), this.f38888d.d(quickReplyRequestMessage)), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (j8 == d8) {
            return j8;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.MessagePublisher
    public Object e(UserSeenMessage userSeenMessage, Continuation<? super Boolean> continuation) {
        return i(this.f38888d.b(userSeenMessage), userSeenMessage.getId(), userSeenMessage.d(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018f A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x014f -> B:15:0x004c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0189 -> B:36:0x00fa). Please submit an issue!!! */
    @Override // eu.bolt.chat.client.MessagePublisher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object f(java.lang.String r19, java.util.Set<java.lang.String> r20, kotlin.coroutines.Continuation<? super java.util.Set<java.lang.String>> r21) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultMessagePublisher.f(java.lang.String, java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
