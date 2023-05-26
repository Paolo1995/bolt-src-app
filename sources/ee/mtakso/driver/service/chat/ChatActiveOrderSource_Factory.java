package ee.mtakso.driver.service.chat;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ChatActiveOrderSource_Factory implements Factory<ChatActiveOrderSource> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f23991a;

    public ChatActiveOrderSource_Factory(Provider<OrderProvider> provider) {
        this.f23991a = provider;
    }

    public static ChatActiveOrderSource_Factory a(Provider<OrderProvider> provider) {
        return new ChatActiveOrderSource_Factory(provider);
    }

    public static ChatActiveOrderSource c(OrderProvider orderProvider) {
        return new ChatActiveOrderSource(orderProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatActiveOrderSource get() {
        return c(this.f23991a.get());
    }
}
