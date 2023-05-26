package ee.mtakso.driver.service.push.handler;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InternalTokenHandler_Factory implements Factory<InternalTokenHandler> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final InternalTokenHandler_Factory f25679a = new InternalTokenHandler_Factory();

        private InstanceHolder() {
        }
    }

    public static InternalTokenHandler_Factory a() {
        return InstanceHolder.f25679a;
    }

    public static InternalTokenHandler c() {
        return new InternalTokenHandler();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InternalTokenHandler get() {
        return c();
    }
}
