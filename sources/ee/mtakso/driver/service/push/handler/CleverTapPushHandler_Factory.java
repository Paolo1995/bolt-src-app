package ee.mtakso.driver.service.push.handler;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CleverTapPushHandler_Factory implements Factory<CleverTapPushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f25675a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CleverTapManager> f25676b;

    public CleverTapPushHandler_Factory(Provider<Context> provider, Provider<CleverTapManager> provider2) {
        this.f25675a = provider;
        this.f25676b = provider2;
    }

    public static CleverTapPushHandler_Factory a(Provider<Context> provider, Provider<CleverTapManager> provider2) {
        return new CleverTapPushHandler_Factory(provider, provider2);
    }

    public static CleverTapPushHandler c(Context context, CleverTapManager cleverTapManager) {
        return new CleverTapPushHandler(context, cleverTapManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CleverTapPushHandler get() {
        return c(this.f25675a.get(), this.f25676b.get());
    }
}
