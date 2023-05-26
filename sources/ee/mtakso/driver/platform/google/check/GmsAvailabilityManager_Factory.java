package ee.mtakso.driver.platform.google.check;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GmsAvailabilityManager_Factory implements Factory<GmsAvailabilityManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23296a;

    public GmsAvailabilityManager_Factory(Provider<Context> provider) {
        this.f23296a = provider;
    }

    public static GmsAvailabilityManager_Factory a(Provider<Context> provider) {
        return new GmsAvailabilityManager_Factory(provider);
    }

    public static GmsAvailabilityManager c(Context context) {
        return new GmsAvailabilityManager(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GmsAvailabilityManager get() {
        return c(this.f23296a.get());
    }
}
