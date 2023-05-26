package ee.mtakso.driver.service.voip;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipCache_Factory implements Factory<VoipCache> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final VoipCache_Factory f26101a = new VoipCache_Factory();

        private InstanceHolder() {
        }
    }

    public static VoipCache_Factory a() {
        return InstanceHolder.f26101a;
    }

    public static VoipCache c() {
        return new VoipCache();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipCache get() {
        return c();
    }
}
