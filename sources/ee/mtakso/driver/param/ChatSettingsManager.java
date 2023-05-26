package ee.mtakso.driver.param;

import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatSettingsManager.kt */
/* loaded from: classes3.dex */
public final class ChatSettingsManager {

    /* renamed from: b  reason: collision with root package name */
    private static final Companion f23072b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f23073a;

    /* compiled from: ChatSettingsManager.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ChatSettingsManager(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f23073a = driverProvider;
    }

    public final boolean a() {
        return this.f23073a.s().getBoolean("EAGER_CONNECTION_ENABLED", false);
    }

    public final void b() {
        c(false);
    }

    public final void c(boolean z7) {
        this.f23073a.s().h("EAGER_CONNECTION_ENABLED", Boolean.valueOf(z7));
    }
}
