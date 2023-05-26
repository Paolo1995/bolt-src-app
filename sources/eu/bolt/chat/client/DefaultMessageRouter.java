package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.data.parser.MqttMessageParser;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: DefaultMessageRouter.kt */
/* loaded from: classes5.dex */
public final class DefaultMessageRouter implements MessageRouter {

    /* renamed from: a  reason: collision with root package name */
    private final MqttMessageParser f38911a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f38912b;

    /* renamed from: c  reason: collision with root package name */
    private final MutableSharedFlow<MessageBox> f38913c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedFlow<MessageBox> f38914d;

    public DefaultMessageRouter(MqttMessageParser messageParser, Logger logger) {
        Intrinsics.f(messageParser, "messageParser");
        Intrinsics.f(logger, "logger");
        this.f38911a = messageParser;
        this.f38912b = logger;
        MutableSharedFlow<MessageBox> b8 = SharedFlowKt.b(0, 0, null, 7, null);
        this.f38913c = b8;
        this.f38914d = FlowKt.b(b8);
    }

    @Override // eu.bolt.chat.client.MessageRouter
    public Object a(MqttMessage mqttMessage, Continuation<? super Unit> continuation) {
        Object d8;
        MessageBox a8 = this.f38911a.a(mqttMessage);
        if (a8 == null) {
            Logger logger = this.f38912b;
            Severity a9 = logger.c().a();
            Severity severity = Severity.Error;
            if (a9.compareTo(severity) <= 0) {
                String d9 = logger.d();
                logger.f(severity, d9, null, "Unable to parse " + mqttMessage + '!');
            }
            return Unit.f50853a;
        }
        Object b8 = this.f38913c.b(a8, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (b8 == d8) {
            return b8;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.MessageRouter
    public SharedFlow<MessageBox> b() {
        return this.f38914d;
    }
}
