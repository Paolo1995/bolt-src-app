package ee.mtakso.driver.service.chat;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.token.TokenManager;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.service.foreground.ChatForegroundProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ChatService_Factory implements Factory<ChatService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverChatUserInfoProvider> f24039a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatRepo> f24040b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderProvider> f24041c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatConfigManager> f24042d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<TokenManager> f24043e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ChatForegroundProvider> f24044f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ChatManager> f24045g;

    public ChatService_Factory(Provider<DriverChatUserInfoProvider> provider, Provider<ChatRepo> provider2, Provider<OrderProvider> provider3, Provider<ChatConfigManager> provider4, Provider<TokenManager> provider5, Provider<ChatForegroundProvider> provider6, Provider<ChatManager> provider7) {
        this.f24039a = provider;
        this.f24040b = provider2;
        this.f24041c = provider3;
        this.f24042d = provider4;
        this.f24043e = provider5;
        this.f24044f = provider6;
        this.f24045g = provider7;
    }

    public static ChatService_Factory a(Provider<DriverChatUserInfoProvider> provider, Provider<ChatRepo> provider2, Provider<OrderProvider> provider3, Provider<ChatConfigManager> provider4, Provider<TokenManager> provider5, Provider<ChatForegroundProvider> provider6, Provider<ChatManager> provider7) {
        return new ChatService_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ChatService c(DriverChatUserInfoProvider driverChatUserInfoProvider, Lazy<ChatRepo> lazy, OrderProvider orderProvider, ChatConfigManager chatConfigManager, TokenManager tokenManager, ChatForegroundProvider chatForegroundProvider, Lazy<ChatManager> lazy2) {
        return new ChatService(driverChatUserInfoProvider, lazy, orderProvider, chatConfigManager, tokenManager, chatForegroundProvider, lazy2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatService get() {
        return c(this.f24039a.get(), DoubleCheck.lazy(this.f24040b), this.f24041c.get(), this.f24042d.get(), this.f24043e.get(), this.f24044f.get(), DoubleCheck.lazy(this.f24045g));
    }
}
