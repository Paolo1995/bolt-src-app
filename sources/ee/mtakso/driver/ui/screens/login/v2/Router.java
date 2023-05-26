package ee.mtakso.driver.ui.screens.login.v2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* compiled from: Router.kt */
/* loaded from: classes3.dex */
public interface Router {

    /* compiled from: Router.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(Router router, Class cls, Bundle bundle, boolean z7, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    bundle = null;
                }
                if ((i8 & 4) != 0) {
                    z7 = true;
                }
                router.d(cls, bundle, z7);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPage");
        }
    }

    void c();

    void d(Class<? extends Fragment> cls, Bundle bundle, boolean z7);

    GoBackDelegate g();

    void l(GoBackDelegate goBackDelegate);
}
