package ee.mtakso.driver.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DebugTweaksMenu_Factory implements Factory<DebugTweaksMenu> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DebugTweaksMenu_Factory f26223a = new DebugTweaksMenu_Factory();

        private InstanceHolder() {
        }
    }

    public static DebugTweaksMenu_Factory a() {
        return InstanceHolder.f26223a;
    }

    public static DebugTweaksMenu c() {
        return new DebugTweaksMenu();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DebugTweaksMenu get() {
        return c();
    }
}
