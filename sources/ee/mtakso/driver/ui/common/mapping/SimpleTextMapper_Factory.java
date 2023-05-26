package ee.mtakso.driver.ui.common.mapping;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SimpleTextMapper_Factory implements Factory<SimpleTextMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final SimpleTextMapper_Factory f26388a = new SimpleTextMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SimpleTextMapper_Factory a() {
        return InstanceHolder.f26388a;
    }

    public static SimpleTextMapper c() {
        return new SimpleTextMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SimpleTextMapper get() {
        return c();
    }
}
