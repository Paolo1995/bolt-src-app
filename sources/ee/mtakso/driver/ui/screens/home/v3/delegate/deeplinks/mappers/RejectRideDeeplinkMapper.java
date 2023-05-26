package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RejectRideDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class RejectRideDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.RideReject deeplink) {
        List e8;
        Intrinsics.f(deeplink, "deeplink");
        e8 = CollectionsKt__CollectionsJVMKt.e(TripCancellationBottomSheetFragment.class);
        return new RoutingCommand.DialogFragmentClass(new RoutingState(FragmentActivity.class, e8), TripCancellationBottomSheetFragment.class, TripCancellationBottomSheetFragment.f31228x.a(deeplink.b()), null, 8, null);
    }
}
