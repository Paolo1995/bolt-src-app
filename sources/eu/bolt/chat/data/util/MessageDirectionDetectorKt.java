package eu.bolt.chat.data.util;

import eu.bolt.chat.network.data.ChatConfig;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageDirectionDetector.kt */
/* loaded from: classes5.dex */
public final class MessageDirectionDetectorKt {
    public static final MessageDirectionDetector a(ChatConfig chatConfig) {
        Intrinsics.f(chatConfig, "chatConfig");
        return new MessageDirectionDetectorImpl(chatConfig);
    }
}
