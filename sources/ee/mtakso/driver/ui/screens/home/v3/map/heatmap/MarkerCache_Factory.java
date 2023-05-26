package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MarkerCache_Factory implements Factory<MarkerCache> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MarkerCache_Factory f30229a = new MarkerCache_Factory();

        private InstanceHolder() {
        }
    }

    public static MarkerCache_Factory a() {
        return InstanceHolder.f30229a;
    }

    public static MarkerCache c() {
        return new MarkerCache();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MarkerCache get() {
        return c();
    }
}
