package ee.mtakso.driver.ui.screens.home.v3.map.surge;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MvtRenderer_Factory implements Factory<MvtRenderer> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MvtRenderer_Factory f30323a = new MvtRenderer_Factory();

        private InstanceHolder() {
        }
    }

    public static MvtRenderer_Factory a() {
        return InstanceHolder.f30323a;
    }

    public static MvtRenderer c() {
        return new MvtRenderer();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MvtRenderer get() {
        return c();
    }
}
