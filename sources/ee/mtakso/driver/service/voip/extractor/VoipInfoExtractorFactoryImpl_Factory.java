package ee.mtakso.driver.service.voip.extractor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipInfoExtractorFactoryImpl_Factory implements Factory<VoipInfoExtractorFactoryImpl> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final VoipInfoExtractorFactoryImpl_Factory f26145a = new VoipInfoExtractorFactoryImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static VoipInfoExtractorFactoryImpl_Factory a() {
        return InstanceHolder.f26145a;
    }

    public static VoipInfoExtractorFactoryImpl c() {
        return new VoipInfoExtractorFactoryImpl();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipInfoExtractorFactoryImpl get() {
        return c();
    }
}
