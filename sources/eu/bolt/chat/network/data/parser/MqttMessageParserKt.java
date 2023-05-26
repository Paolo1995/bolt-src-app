package eu.bolt.chat.network.data.parser;

import co.touchlab.kermit.Logger;
import eu.bolt.chat.data.util.MessageDirectionDetector;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MqttMessageParser.kt */
/* loaded from: classes5.dex */
public final class MqttMessageParserKt {
    public static final MqttMessageParser a(MessageDirectionDetector messageDirectionDetector, Logger logger) {
        Intrinsics.f(messageDirectionDetector, "messageDirectionDetector");
        Intrinsics.f(logger, "logger");
        return new DefaultMessageParser(messageDirectionDetector, logger);
    }
}
