package ee.mtakso.driver.ui.common.mapping;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InformationMessageMapper_Factory implements Factory<InformationMessageMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final InformationMessageMapper_Factory f26387a = new InformationMessageMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static InformationMessageMapper_Factory a() {
        return InstanceHolder.f26387a;
    }

    public static InformationMessageMapper c() {
        return new InformationMessageMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InformationMessageMapper get() {
        return c();
    }
}
