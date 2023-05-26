package ee.mtakso.driver.service.chat;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ChatTerminationMessageProvider_Factory implements Factory<ChatTerminationMessageProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f24048a;

    public ChatTerminationMessageProvider_Factory(Provider<Context> provider) {
        this.f24048a = provider;
    }

    public static ChatTerminationMessageProvider_Factory a(Provider<Context> provider) {
        return new ChatTerminationMessageProvider_Factory(provider);
    }

    public static ChatTerminationMessageProvider c(Context context) {
        return new ChatTerminationMessageProvider(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatTerminationMessageProvider get() {
        return c(this.f24048a.get());
    }
}
