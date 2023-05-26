package ee.mtakso.driver.platform.google.store_integrity;

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
public final class GoogleIntegrityCheck_Factory implements Factory<GoogleIntegrityCheck> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23342a;

    public GoogleIntegrityCheck_Factory(Provider<Context> provider) {
        this.f23342a = provider;
    }

    public static GoogleIntegrityCheck_Factory a(Provider<Context> provider) {
        return new GoogleIntegrityCheck_Factory(provider);
    }

    public static GoogleIntegrityCheck c(Context context) {
        return new GoogleIntegrityCheck(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GoogleIntegrityCheck get() {
        return c(this.f23342a.get());
    }
}
