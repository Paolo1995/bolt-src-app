package ee.mtakso.driver.ui.interactor.rateme;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RateMeFetchCategoriesInteractor_Factory implements Factory<RateMeFetchCategoriesInteractor> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final RateMeFetchCategoriesInteractor_Factory f26839a = new RateMeFetchCategoriesInteractor_Factory();

        private InstanceHolder() {
        }
    }

    public static RateMeFetchCategoriesInteractor_Factory a() {
        return InstanceHolder.f26839a;
    }

    public static RateMeFetchCategoriesInteractor c() {
        return new RateMeFetchCategoriesInteractor();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateMeFetchCategoriesInteractor get() {
        return c();
    }
}
