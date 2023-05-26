package ee.mtakso.driver.network.response;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ExposeResponseTransformer_Factory implements Factory<ExposeResponseTransformer> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ExposeResponseTransformer_Factory f23017a = new ExposeResponseTransformer_Factory();

        private InstanceHolder() {
        }
    }

    public static ExposeResponseTransformer_Factory a() {
        return InstanceHolder.f23017a;
    }

    public static ExposeResponseTransformer c() {
        return new ExposeResponseTransformer();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ExposeResponseTransformer get() {
        return c();
    }
}
