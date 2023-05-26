package eu.bolt.chat.chatcore.network.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatEventMapper_Factory implements Factory<ChatEventMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UserInfoProvider> f38363a;

    public ChatEventMapper_Factory(Provider<UserInfoProvider> provider) {
        this.f38363a = provider;
    }

    public static ChatEventMapper_Factory a(Provider<UserInfoProvider> provider) {
        return new ChatEventMapper_Factory(provider);
    }

    public static ChatEventMapper c(UserInfoProvider userInfoProvider) {
        return new ChatEventMapper(userInfoProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatEventMapper get() {
        return c(this.f38363a.get());
    }
}
