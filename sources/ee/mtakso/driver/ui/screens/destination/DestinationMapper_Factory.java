package ee.mtakso.driver.ui.screens.destination;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DestinationMapper_Factory implements Factory<DestinationMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DestinationMapper_Factory f28172a = new DestinationMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DestinationMapper_Factory a() {
        return InstanceHolder.f28172a;
    }

    public static DestinationMapper c() {
        return new DestinationMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DestinationMapper get() {
        return c();
    }
}
