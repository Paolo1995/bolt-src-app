package ee.mtakso.driver.ui.screens;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.ui.screens.Navigator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Navigator.kt */
/* loaded from: classes3.dex */
public interface GoBackNavigatorDelegate extends Navigator {

    /* compiled from: Navigator.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Navigator a(GoBackNavigatorDelegate goBackNavigatorDelegate) {
            return null;
        }

        public static void b(GoBackNavigatorDelegate goBackNavigatorDelegate, Navigator navigator) {
        }

        public static void c(GoBackNavigatorDelegate goBackNavigatorDelegate, ToolbarAppearance toolbarAppearance) {
            Intrinsics.f(toolbarAppearance, "toolbarAppearance");
        }

        public static void d(GoBackNavigatorDelegate goBackNavigatorDelegate, eu.bolt.driver.core.ui.common.activity.ToolbarAppearance toolbarAppearance) {
            Intrinsics.f(toolbarAppearance, "toolbarAppearance");
            Navigator.DefaultImpls.a(goBackNavigatorDelegate, toolbarAppearance);
        }

        public static void e(GoBackNavigatorDelegate goBackNavigatorDelegate, Class<? extends Fragment> content, Bundle bundle, boolean z7) {
            Intrinsics.f(content, "content");
        }
    }
}
