package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.EarningsGoal deeplink) {
        List e8;
        Intrinsics.f(deeplink, "deeplink");
        e8 = CollectionsKt__CollectionsJVMKt.e(EarningsGoalFragment.class);
        return new RoutingCommand.DialogFragmentClass(new RoutingState(FragmentActivity.class, e8), EarningsGoalFragment.class, null, null, 12, null);
    }
}
