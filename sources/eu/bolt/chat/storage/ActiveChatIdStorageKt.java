package eu.bolt.chat.storage;

import co.touchlab.kermit.Logger;
import com.russhwolf.settings.Settings;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveChatIdStorage.kt */
/* loaded from: classes5.dex */
public final class ActiveChatIdStorageKt {
    public static final ActiveChatIdStorage a(Settings settings, Logger logger) {
        Intrinsics.f(settings, "settings");
        Intrinsics.f(logger, "logger");
        return new DefaultActiveChatIdStorage(settings, logger);
    }
}
