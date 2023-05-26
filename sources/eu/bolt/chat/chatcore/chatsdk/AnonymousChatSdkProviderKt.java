package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.tools.logger.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnonymousChatSdkProvider.kt */
/* loaded from: classes5.dex */
public final class AnonymousChatSdkProviderKt {
    public static final AnonymousChatSdkProvider a(Logger logger) {
        Intrinsics.f(logger, "logger");
        return new AnonymousChatSdkProviderImpl(logger);
    }
}
