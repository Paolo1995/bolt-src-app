package ee.mtakso.driver.param;

import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipPrefsManager.kt */
/* loaded from: classes3.dex */
public final class VoipPrefsManager {

    /* renamed from: b  reason: collision with root package name */
    private static final Companion f23249b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f23250a;

    /* compiled from: VoipPrefsManager.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public VoipPrefsManager(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f23250a = driverProvider;
    }

    public final void a() {
        this.f23250a.s().h("permission_dialog_was_showed", Boolean.TRUE);
    }

    public final boolean b() {
        return this.f23250a.s().getBoolean("permission_dialog_was_showed", false);
    }
}
