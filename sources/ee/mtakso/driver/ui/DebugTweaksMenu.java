package ee.mtakso.driver.ui;

import android.app.Activity;
import ee.mtakso.driver.ui.screens.settings.TweaksMenu;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugTweaksMenu.kt */
/* loaded from: classes3.dex */
public final class DebugTweaksMenu implements TweaksMenu {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f26222a;

    @Override // ee.mtakso.driver.ui.screens.settings.TweaksMenu
    public void a(Activity activity) {
        Intrinsics.f(activity, "activity");
    }

    @Override // ee.mtakso.driver.ui.screens.settings.TweaksMenu
    public boolean b() {
        return this.f26222a;
    }
}
