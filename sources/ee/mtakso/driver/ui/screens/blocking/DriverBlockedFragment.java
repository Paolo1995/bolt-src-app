package ee.mtakso.driver.ui.screens.blocking;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.BlockAction;
import ee.mtakso.driver.network.client.driver.BlockActionType;
import ee.mtakso.driver.network.client.driver.BlockData;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.home.v3.HomeFragment;
import ee.mtakso.driver.ui.utils.ClipboardUtil;
import ee.mtakso.driver.uikit.dialog.ItemViewFactory;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.RoundButtonStyle;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.StringUtilsKt;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DriverBlockedFragment.kt */
/* loaded from: classes3.dex */
public final class DriverBlockedFragment extends BazeFragment {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f27084p = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    private final RoutingManager f27085m;

    /* renamed from: n  reason: collision with root package name */
    private final CompositeUrlLauncher f27086n;

    /* renamed from: o  reason: collision with root package name */
    public Map<Integer, View> f27087o;

    /* compiled from: DriverBlockedFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(BlockData blockData) {
            Intrinsics.f(blockData, "blockData");
            return BundleKt.a(TuplesKt.a("argument_block_data", blockData));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DriverBlockedFragment(BaseUiDependencies deps, RoutingManager routingManager, CompositeUrlLauncher urlLauncher) {
        super(deps, R.layout.fragment_driver_blocked, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(urlLauncher, "urlLauncher");
        this.f27087o = new LinkedHashMap();
        this.f27085m = routingManager;
        this.f27086n = urlLauncher;
    }

    private final void N(final BlockAction blockAction) {
        boolean z7;
        if (blockAction.b() == BlockActionType.BUTTON) {
            if (blockAction.a().length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                R(blockAction.a()).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.blocking.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DriverBlockedFragment.O(DriverBlockedFragment.this, blockAction, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(DriverBlockedFragment this$0, BlockAction action, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(action, "$action");
        this$0.T(action.c());
    }

    private final BlockData P() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return (BlockData) arguments.getParcelable("argument_block_data");
        }
        return null;
    }

    private final Navigator Q() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    private final RoundButton R(String str) {
        String F;
        ItemViewFactory itemViewFactory = ItemViewFactory.f35921a;
        LinearLayout containerActions = (LinearLayout) M(R.id.containerActions);
        Intrinsics.e(containerActions, "containerActions");
        RoundButton r7 = ItemViewFactory.r(itemViewFactory, containerActions, str, null, new RoundButtonStyle(UiKitRoundButtonType.f36162l, UiKitRoundButtonSize.f36155i), 4, null);
        F = StringsKt__StringsJVMKt.F(str, " ", "_", false, 4, null);
        r7.setTag("action_" + F);
        return r7;
    }

    private final void S() {
        this.f27085m.b(new RoutingCommand.ActivityClass(new RoutingState(SimpleActivity.class, null, 2, null), SimpleActivity.class, SimpleActivity.Companion.d(SimpleActivity.f27004l, HomeFragment.class, null, false, 6, null), 0, 8, null), true);
        Q().c();
    }

    private final void T(String str) {
        if (!this.f27086n.a(str)) {
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            new ClipboardUtil(requireContext).a(str);
            Toast.makeText(requireContext(), (int) R.string.launch_url_copied_clipboard, 0).show();
        }
    }

    private final void U(BlockData blockData) {
        String b8 = blockData.b();
        ArrayList<BlockAction> a8 = blockData.a();
        ((TextView) M(R.id.tvBlockingReason)).setText(StringUtilsKt.a(b8));
        for (BlockAction blockAction : a8) {
            N(blockAction);
        }
        ((AppCompatImageButton) M(R.id.closeImageButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.blocking.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriverBlockedFragment.V(DriverBlockedFragment.this, view);
            }
        });
        ((RoundButton) M(R.id.btnClose)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.blocking.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriverBlockedFragment.W(DriverBlockedFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(DriverBlockedFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(DriverBlockedFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.S();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27087o.clear();
    }

    public View M(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27087o;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        BlockData P = P();
        if (P == null) {
            Kalev.d("Block data cannot be empty for campaign details screen");
            Toast.makeText(requireContext(), (int) R.string.something_went_wrong, 0).show();
            Q().c();
            return;
        }
        U(P);
    }
}
