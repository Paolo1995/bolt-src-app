package ee.mtakso.driver.ui.screens;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Navigator.kt */
/* loaded from: classes3.dex */
public interface Navigator {

    /* compiled from: Navigator.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static void a(Navigator navigator, eu.bolt.driver.core.ui.common.activity.ToolbarAppearance toolbarAppearance) {
            Intrinsics.f(toolbarAppearance, "toolbarAppearance");
        }

        public static /* synthetic */ void b(Navigator navigator, Class cls, Bundle bundle, boolean z7, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    bundle = null;
                }
                if ((i8 & 4) != 0) {
                    z7 = true;
                }
                navigator.d(cls, bundle, z7);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPage");
        }
    }

    boolean c();

    void d(Class<? extends Fragment> cls, Bundle bundle, boolean z7);

    Navigator e();

    void n(ToolbarAppearance toolbarAppearance);

    void q(Navigator navigator);

    void x(eu.bolt.driver.core.ui.common.activity.ToolbarAppearance toolbarAppearance);
}
