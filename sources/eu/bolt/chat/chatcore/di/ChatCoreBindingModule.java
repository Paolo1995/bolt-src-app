package eu.bolt.chat.chatcore.di;

import dagger.Binds;
import dagger.Module;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;

/* compiled from: ChatCoreBindingModule.kt */
@Module
/* loaded from: classes5.dex */
public abstract class ChatCoreBindingModule {
    @Binds
    public abstract ChatRepo a(InternalChatRepo internalChatRepo);
}
