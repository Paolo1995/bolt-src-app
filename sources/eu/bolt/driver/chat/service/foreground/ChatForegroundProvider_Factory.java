package eu.bolt.driver.chat.service.foreground;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatForegroundProvider_Factory implements Factory<ChatForegroundProvider> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ChatForegroundProvider_Factory f40496a = new ChatForegroundProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static ChatForegroundProvider_Factory a() {
        return InstanceHolder.f40496a;
    }

    public static ChatForegroundProvider c() {
        return new ChatForegroundProvider();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatForegroundProvider get() {
        return c();
    }
}
