package ee.mtakso.driver.service.voip.effects;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipEffectsFactory_Factory implements Factory<VoipEffectsFactory> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final VoipEffectsFactory_Factory f26139a = new VoipEffectsFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static VoipEffectsFactory_Factory a() {
        return InstanceHolder.f26139a;
    }

    public static VoipEffectsFactory c() {
        return new VoipEffectsFactory();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipEffectsFactory get() {
        return c();
    }
}
