package ee.mtakso.driver.di.modules;

import android.app.NotificationManager;
import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AndroidModule_ProvideNotificationManagerFactory implements Factory<NotificationManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f20746a;

    public AndroidModule_ProvideNotificationManagerFactory(Provider<Context> provider) {
        this.f20746a = provider;
    }

    public static AndroidModule_ProvideNotificationManagerFactory a(Provider<Context> provider) {
        return new AndroidModule_ProvideNotificationManagerFactory(provider);
    }

    public static NotificationManager c(Context context) {
        return (NotificationManager) Preconditions.checkNotNullFromProvides(AndroidModule.j(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NotificationManager get() {
        return c(this.f20746a.get());
    }
}
