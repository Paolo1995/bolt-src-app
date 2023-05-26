package ee.mtakso.driver.ui.common.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MapPaddingViewModel_Factory implements Factory<MapPaddingViewModel> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MapPaddingViewModel_Factory f26385a = new MapPaddingViewModel_Factory();

        private InstanceHolder() {
        }
    }

    public static MapPaddingViewModel_Factory a() {
        return InstanceHolder.f26385a;
    }

    public static MapPaddingViewModel c() {
        return new MapPaddingViewModel();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MapPaddingViewModel get() {
        return c();
    }
}
