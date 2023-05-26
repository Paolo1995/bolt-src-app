package ee.mtakso.driver.ui.common.progress.view;

import android.view.View;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressViewController.kt */
/* loaded from: classes3.dex */
public final class ProgressViewController {

    /* renamed from: a  reason: collision with root package name */
    private final View f26389a;

    public ProgressViewController(View view) {
        Intrinsics.f(view, "view");
        this.f26389a = view;
    }

    public final void a() {
        ViewExtKt.e(this.f26389a, false, 0, 2, null);
    }

    public final void b() {
        ViewExtKt.e(this.f26389a, false, 0, 3, null);
    }
}
