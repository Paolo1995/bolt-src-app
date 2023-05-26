package eu.bolt.driver.chat.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.chat.service.foreground.ChatForegroundProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatForegroundTracker_Factory implements Factory<ChatForegroundTracker> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatForegroundProvider> f40508a;

    public ChatForegroundTracker_Factory(Provider<ChatForegroundProvider> provider) {
        this.f40508a = provider;
    }

    public static ChatForegroundTracker_Factory a(Provider<ChatForegroundProvider> provider) {
        return new ChatForegroundTracker_Factory(provider);
    }

    public static ChatForegroundTracker c(ChatForegroundProvider chatForegroundProvider) {
        return new ChatForegroundTracker(chatForegroundProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatForegroundTracker get() {
        return c(this.f40508a.get());
    }
}
