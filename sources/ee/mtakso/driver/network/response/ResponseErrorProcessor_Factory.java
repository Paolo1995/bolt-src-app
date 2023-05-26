package ee.mtakso.driver.network.response;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ResponseErrorProcessor_Factory implements Factory<ResponseErrorProcessor> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ResponseErrorProcessor_Factory f23019a = new ResponseErrorProcessor_Factory();

        private InstanceHolder() {
        }
    }

    public static ResponseErrorProcessor_Factory a() {
        return InstanceHolder.f23019a;
    }

    public static ResponseErrorProcessor c() {
        return new ResponseErrorProcessor();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ResponseErrorProcessor get() {
        return c();
    }
}
