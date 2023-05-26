package ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager;

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
public final class OutgoingWindowManager_Factory implements Factory<OutgoingWindowManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f26181a;

    public OutgoingWindowManager_Factory(Provider<Context> provider) {
        this.f26181a = provider;
    }

    public static OutgoingWindowManager_Factory a(Provider<Context> provider) {
        return new OutgoingWindowManager_Factory(provider);
    }

    public static OutgoingWindowManager c(Context context) {
        return new OutgoingWindowManager(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OutgoingWindowManager get() {
        return c(this.f26181a.get());
    }
}
