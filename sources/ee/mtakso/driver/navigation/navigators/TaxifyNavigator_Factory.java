package ee.mtakso.driver.navigation.navigators;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TaxifyNavigator_Factory implements Factory<TaxifyNavigator> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final TaxifyNavigator_Factory f21257a = new TaxifyNavigator_Factory();

        private InstanceHolder() {
        }
    }

    public static TaxifyNavigator_Factory a() {
        return InstanceHolder.f21257a;
    }

    public static TaxifyNavigator c() {
        return new TaxifyNavigator();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TaxifyNavigator get() {
        return c();
    }
}
