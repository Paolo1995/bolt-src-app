package ee.mtakso.driver.service.language;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LanguageListProviderImpl_Factory implements Factory<LanguageListProviderImpl> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final LanguageListProviderImpl_Factory f24591a = new LanguageListProviderImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static LanguageListProviderImpl_Factory a() {
        return InstanceHolder.f24591a;
    }

    public static LanguageListProviderImpl c() {
        return new LanguageListProviderImpl();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LanguageListProviderImpl get() {
        return c();
    }
}
