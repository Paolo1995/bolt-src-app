package eu.bolt.chat.chatcore.di;

import dagger.Module;
import dagger.Provides;
import eu.bolt.chat.chatcore.ChatKit;
import eu.bolt.chat.chatcore.engine.ChatEngineTypeProvider;

/* compiled from: ChatEngineModule.kt */
@Module
/* loaded from: classes5.dex */
public final class ChatEngineModule {
    @Provides
    public final ChatEngineTypeProvider a() {
        return ChatKit.f37877a.a();
    }
}
