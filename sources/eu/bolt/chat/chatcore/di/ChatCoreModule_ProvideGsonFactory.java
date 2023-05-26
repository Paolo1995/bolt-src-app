package eu.bolt.chat.chatcore.di;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideGsonFactory implements Factory<Gson> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38084a;

    public ChatCoreModule_ProvideGsonFactory(ChatCoreModule chatCoreModule) {
        this.f38084a = chatCoreModule;
    }

    public static ChatCoreModule_ProvideGsonFactory a(ChatCoreModule chatCoreModule) {
        return new ChatCoreModule_ProvideGsonFactory(chatCoreModule);
    }

    public static Gson c(ChatCoreModule chatCoreModule) {
        return (Gson) Preconditions.checkNotNullFromProvides(chatCoreModule.h());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Gson get() {
        return c(this.f38084a);
    }
}
