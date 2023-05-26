package ee.mtakso.driver.ui.screens.signup;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrackActivityRecreatedDelegate.kt */
/* loaded from: classes5.dex */
public final class TrackActivityRecreatedDelegate {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f33384c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Function0<Unit> f33385a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f33386b;

    /* compiled from: TrackActivityRecreatedDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TrackActivityRecreatedDelegate(Function0<Unit> action) {
        Intrinsics.f(action, "action");
        this.f33385a = action;
    }

    public final void a(Bundle bundle) {
        if (bundle != null && bundle.getBoolean("TRACK_ACTIVIVT_RECREATED_PROCESS_STARTED")) {
            this.f33385a.invoke();
        }
    }

    public final void b() {
        this.f33386b = true;
    }

    public final void c() {
        this.f33386b = false;
    }

    public final void d(Bundle outBundle) {
        Intrinsics.f(outBundle, "outBundle");
        outBundle.putBoolean("TRACK_ACTIVIVT_RECREATED_PROCESS_STARTED", this.f33386b);
    }
}
