package ee.mtakso.driver.network.exception;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ApiExceptionFactory_Factory implements Factory<ApiExceptionFactory> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ApiExceptionFactory_Factory f22929a = new ApiExceptionFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static ApiExceptionFactory_Factory a() {
        return InstanceHolder.f22929a;
    }

    public static ApiExceptionFactory c() {
        return new ApiExceptionFactory();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ApiExceptionFactory get() {
        return c();
    }
}
