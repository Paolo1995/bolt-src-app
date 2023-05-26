package eu.bolt.chat.chatcore.di;

import dagger.Binds;
import dagger.Module;
import eu.bolt.chat.chatcore.connection.ChatConnectionController;
import eu.bolt.chat.chatcore.connection.ChatConnectionControllerImpl;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import javax.inject.Singleton;

/* compiled from: ChatControllerModule.kt */
@Module
/* loaded from: classes5.dex */
public abstract class ChatControllerModule {
    @Singleton
    @Binds
    public abstract ChatConnectionController a(ChatConnectionControllerImpl chatConnectionControllerImpl);

    @Singleton
    @Binds
    public abstract ChatConnectionProvider b(ChatConnectionControllerImpl chatConnectionControllerImpl);
}
