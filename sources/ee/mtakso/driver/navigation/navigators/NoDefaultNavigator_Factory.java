package ee.mtakso.driver.navigation.navigators;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NoDefaultNavigator_Factory implements Factory<NoDefaultNavigator> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final NoDefaultNavigator_Factory f21254a = new NoDefaultNavigator_Factory();

        private InstanceHolder() {
        }
    }

    public static NoDefaultNavigator_Factory a() {
        return InstanceHolder.f21254a;
    }

    public static NoDefaultNavigator c() {
        return new NoDefaultNavigator();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NoDefaultNavigator get() {
        return c();
    }
}
