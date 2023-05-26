package ee.mtakso.driver.service.push.handler;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ChatPushHandlerWrapper_Factory implements Factory<ChatPushHandlerWrapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatPushHandler> f25672a;

    public ChatPushHandlerWrapper_Factory(Provider<ChatPushHandler> provider) {
        this.f25672a = provider;
    }

    public static ChatPushHandlerWrapper_Factory a(Provider<ChatPushHandler> provider) {
        return new ChatPushHandlerWrapper_Factory(provider);
    }

    public static ChatPushHandlerWrapper c(Lazy<ChatPushHandler> lazy) {
        return new ChatPushHandlerWrapper(lazy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatPushHandlerWrapper get() {
        return c(DoubleCheck.lazy(this.f25672a));
    }
}
