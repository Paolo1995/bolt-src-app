package eu.bolt.android.chat;

import android.content.Context;
import dagger.BindsInstance;
import dagger.Component;
import eu.bolt.chat.chatcore.di.ChatControllerModule;
import eu.bolt.chat.chatcore.di.ChatCoreModule;
import eu.bolt.chat.chatcore.di.ChatEngineModule;
import eu.bolt.chat.chatcore.di.MqttControllerModule;
import eu.bolt.client.chatdb.di.ChatDbModule;
import javax.inject.Singleton;

/* compiled from: ChatComponent.kt */
@Component(modules = {ChatCoreModule.class, ChatEngineModule.class, ChatDbModule.class, MqttControllerModule.class, ChatControllerModule.class})
@Singleton
/* loaded from: classes5.dex */
public interface ChatComponent extends ChatDependencyProvider {

    /* compiled from: ChatComponent.kt */
    @Component.Builder
    /* loaded from: classes5.dex */
    public interface Builder {
        ChatComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}
