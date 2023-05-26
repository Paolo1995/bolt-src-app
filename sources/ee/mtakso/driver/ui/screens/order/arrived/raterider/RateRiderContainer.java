package ee.mtakso.driver.ui.screens.order.arrived.raterider;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

/* compiled from: RateRiderContainer.kt */
/* loaded from: classes3.dex */
public interface RateRiderContainer {

    /* compiled from: RateRiderContainer.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(RateRiderContainer rateRiderContainer, Class cls, Bundle bundle, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    bundle = null;
                }
                rateRiderContainer.a(cls, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragment");
        }
    }

    void a(Class<? extends Fragment> cls, Bundle bundle);

    void k(Fragment fragment, View view, RiderRatingInfo riderRatingInfo);
}
