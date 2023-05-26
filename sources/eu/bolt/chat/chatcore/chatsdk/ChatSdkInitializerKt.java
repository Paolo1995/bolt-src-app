package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider;
import eu.bolt.chat.data.connection.ChatConnectionSettings;
import eu.bolt.chat.network.CredentialsProvider;
import eu.bolt.chat.tools.logger.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatSdkInitializer.kt */
/* loaded from: classes5.dex */
public final class ChatSdkInitializerKt {
    public static final ChatSdkInitializer a(ChatConnectionSettingsProvider connectionSettingsProvider, CredentialsProvider credentialsProvider, Logger logger) {
        Intrinsics.f(connectionSettingsProvider, "connectionSettingsProvider");
        Intrinsics.f(credentialsProvider, "credentialsProvider");
        Intrinsics.f(logger, "logger");
        return new ChatSdkInitializerImpl(connectionSettingsProvider, credentialsProvider, logger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatConnectionSettings c(ChatConnectionSettingsProvider chatConnectionSettingsProvider, CredentialsProvider credentialsProvider) {
        return new ChatConnectionSettings(chatConnectionSettingsProvider.d(), chatConnectionSettingsProvider.i(), chatConnectionSettingsProvider.r(), chatConnectionSettingsProvider.n(), chatConnectionSettingsProvider.c(), chatConnectionSettingsProvider.getDeviceId(), chatConnectionSettingsProvider.o(), chatConnectionSettingsProvider.g(), chatConnectionSettingsProvider.e(), chatConnectionSettingsProvider.a(), chatConnectionSettingsProvider.m(), chatConnectionSettingsProvider.q(), chatConnectionSettingsProvider.b(), credentialsProvider);
    }
}
