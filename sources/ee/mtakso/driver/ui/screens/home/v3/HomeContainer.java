package ee.mtakso.driver.ui.screens.home.v3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.ui.screens.home.v3.footer.FooterAppearance;
import ee.mtakso.driver.ui.screens.home.v3.header.HeaderAppearance;

/* compiled from: HomeContainer.kt */
/* loaded from: classes3.dex */
public interface HomeContainer {

    /* compiled from: HomeContainer.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(HomeContainer homeContainer, Class cls, Bundle bundle, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    bundle = null;
                }
                homeContainer.a(cls, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragment");
        }
    }

    void a(Class<? extends Fragment> cls, Bundle bundle);

    void b(HeaderAppearance headerAppearance, FooterAppearance footerAppearance);

    void j(String str);

    void l(String str);
}
