package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.Coordinates;
import ee.mtakso.driver.network.client.campaign.Condition;
import ee.mtakso.driver.network.client.campaign.ConditionType;
import ee.mtakso.driver.network.client.campaign.InfoBlock;
import ee.mtakso.driver.network.client.campaign.OptInChoiceV2;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignUtilsKt;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignBonusController;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignConditionDelegate;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.MapController;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.android.maps.core.container.MapContainer;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.common.dialog.InfoDialog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OptInChoiceFragment.kt */
/* loaded from: classes3.dex */
public final class OptInChoiceFragment extends BazeMvvmFragment<OptInChoiceViewModel> {

    /* renamed from: y  reason: collision with root package name */
    public static final Companion f27486y = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final MapProvider f27487o;

    /* renamed from: p  reason: collision with root package name */
    private final AppThemeManager f27488p;

    /* renamed from: q  reason: collision with root package name */
    private final CampaignBonusMapper f27489q;

    /* renamed from: r  reason: collision with root package name */
    private final CampaignInfoBlockMapper f27490r;

    /* renamed from: s  reason: collision with root package name */
    private final CampaignDynamicItemsMapper f27491s;

    /* renamed from: t  reason: collision with root package name */
    private CampaignBonusController f27492t;

    /* renamed from: u  reason: collision with root package name */
    private CampaignPeriodItemController f27493u;

    /* renamed from: v  reason: collision with root package name */
    private CampaignDynamicItemsController f27494v;

    /* renamed from: w  reason: collision with root package name */
    private final int f27495w;

    /* renamed from: x  reason: collision with root package name */
    public Map<Integer, View> f27496x;

    /* compiled from: OptInChoiceFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(long j8, long j9) {
            Bundle bundle = new Bundle();
            bundle.putLong("arg_opt_in_group_id", j8);
            bundle.putLong("arg_opt_in_choice_id", j9);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OptInChoiceFragment(MapProvider mapProvider, AppThemeManager appThemeManager, CampaignBonusMapper campaignBonusMapper, CampaignInfoBlockMapper campaignInfoBlockMapper, CampaignDynamicItemsMapper campaignDynamicItemsMapper, BaseUiDependencies deps) {
        super(deps, R.layout.fragment_campaigns_v2_opt_in_choice, null, 4, null);
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(campaignBonusMapper, "campaignBonusMapper");
        Intrinsics.f(campaignInfoBlockMapper, "campaignInfoBlockMapper");
        Intrinsics.f(campaignDynamicItemsMapper, "campaignDynamicItemsMapper");
        Intrinsics.f(deps, "deps");
        this.f27496x = new LinkedHashMap();
        this.f27487o = mapProvider;
        this.f27488p = appThemeManager;
        this.f27489q = campaignBonusMapper;
        this.f27490r = campaignInfoBlockMapper;
        this.f27491s = campaignDynamicItemsMapper;
        this.f27495w = 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(DriverAppPlugin driverAppPlugin, List<Coordinates> list) {
        ((MapContainer) T(R.id.polygonMap)).a();
        driverAppPlugin.l(list, Dimens.d(6), ContextCompat.getColor(requireContext(), R.color.green700), ContextCompat.getColor(requireContext(), R.color.green700Opacity20));
        driverAppPlugin.e(list, 0L, 25.0f);
        driverAppPlugin.c();
    }

    private final Navigator Z() {
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            return (Navigator) activity;
        }
        return null;
    }

    private final long a0() {
        return requireArguments().getLong("arg_opt_in_choice_id");
    }

    private final long b0() {
        return requireArguments().getLong("arg_opt_in_group_id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(CampaignConditionDelegate.Model model) {
        boolean z7;
        String string;
        Condition o8 = model.o();
        if (o8.c() == ConditionType.THRESHOLD && o8.b() != null) {
            String f8 = o8.b().f();
            if (o8.b().b().length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                string = o8.b().d();
            } else {
                string = getString(R.string.campaign_condition_subtitle_format, o8.b().b(), o8.b().d());
                Intrinsics.e(string, "{\n                getStr…          )\n            }");
            }
            String e8 = o8.b().e();
            InfoDialog.Companion companion = InfoDialog.f41099m;
            String string2 = getString(R.string.close);
            Intrinsics.e(string2, "getString(R.string.close)");
            FragmentUtils.b(companion.a(f8, string, e8, string2, new DefaultDialogCallback()), this, "tag_info");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(OptInChoiceFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Navigator Z = this$0.Z();
        if (Z != null) {
            Z.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(OptInChoiceState optInChoiceState) {
        boolean z7;
        InfoBlockData infoBlockData;
        final OptInChoiceV2 a8 = optInChoiceState.a();
        ((TextView) T(R.id.cc)).setText(a8.getTitle());
        CampaignPeriodItemController campaignPeriodItemController = this.f27493u;
        if (campaignPeriodItemController != null) {
            campaignPeriodItemController.d(a8.i(), a8.h());
        }
        int i8 = R.id.categoryAndLocation;
        Context context = ((TextView) T(i8)).getContext();
        Intrinsics.e(context, "categoryAndLocation.context");
        ((TextView) T(i8)).setText(CampaignUtilsKt.b(context, ((TextView) T(i8)).getLineHeight(), a8.c(), a8.g()));
        CampaignBonusController campaignBonusController = this.f27492t;
        if (campaignBonusController != null) {
            CampaignBonusController.Model a9 = this.f27489q.a(a8.b());
            InfoBlock f8 = a8.f();
            if (f8 != null) {
                infoBlockData = this.f27490r.a(f8);
            } else {
                infoBlockData = null;
            }
            campaignBonusController.b(a9, infoBlockData);
        }
        List<Coordinates> j8 = a8.j();
        if (j8 != null && !j8.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            View map = T(R.id.map);
            Intrinsics.e(map, "map");
            ViewExtKt.d(map, false, 0, 2, null);
        } else {
            View map2 = T(R.id.map);
            Intrinsics.e(map2, "map");
            ViewExtKt.d(map2, false, 0, 3, null);
            final MapStyle c8 = AppThemeUtils.f34255a.c(this.f27488p.d());
            ((MapContainer) T(R.id.polygonMap)).c(c8);
            getChildFragmentManager().beginTransaction().replace(R.id.f483polygonMap, this.f27487o.a(new Function1<MapController, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceFragment$render$mapFragment$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(MapController it) {
                    Intrinsics.f(it, "it");
                    DriverAppPlugin driverAppPlugin = (DriverAppPlugin) it.a("driver");
                    driverAppPlugin.o(MapStyle.this);
                    final OptInChoiceFragment optInChoiceFragment = this;
                    driverAppPlugin.y(new Function1<Locatable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceFragment$render$mapFragment$1.1
                        {
                            super(1);
                        }

                        public final void b(Locatable it2) {
                            OptInChoiceViewModel M;
                            Intrinsics.f(it2, "it");
                            M = OptInChoiceFragment.this.M();
                            M.K();
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Locatable locatable) {
                            b(locatable);
                            return Unit.f50853a;
                        }
                    });
                    this.Y(driverAppPlugin, a8.j());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MapController mapController) {
                    b(mapController);
                    return Unit.f50853a;
                }
            }), "map").commit();
        }
        int i9 = R.id.f19834o3;
        ((TextView) T(i9)).setText(a8.e());
        ((TextView) T(i9)).setMovementMethod(LinkMovementMethod.getInstance());
        CampaignDynamicItemsController campaignDynamicItemsController = this.f27494v;
        if (campaignDynamicItemsController != null) {
            campaignDynamicItemsController.b(this.f27491s.c(a8.d(), a8.k(), null));
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27496x.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f27495w);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        NestedScrollView content = (NestedScrollView) T(R.id.S2);
        Intrinsics.e(content, "content");
        ViewExtKt.d(content, false, 0, 3, null);
        ((CircularProgressIndicator) T(R.id.V6)).j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        NestedScrollView content = (NestedScrollView) T(R.id.S2);
        Intrinsics.e(content, "content");
        ViewExtKt.d(content, false, 0, 2, null);
        ((CircularProgressIndicator) T(R.id.V6)).q();
    }

    public View T(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27496x;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: f0 */
    public OptInChoiceViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (OptInChoiceViewModel) new ViewModelProvider(this, E.d()).a(OptInChoiceViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f27492t = null;
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        View bonus = T(R.id.bonus);
        Intrinsics.e(bonus, "bonus");
        this.f27492t = new CampaignBonusController(bonus);
        this.f27493u = new CampaignPeriodItemController(T(R.id.periods));
        View dynamicItems = T(R.id.dynamicItems);
        Intrinsics.e(dynamicItems, "dynamicItems");
        this.f27494v = new CampaignDynamicItemsController(dynamicItems, new OptInChoiceFragment$onViewCreated$1(this));
        ((PopupToolbar) T(R.id.kc)).setNavigationOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OptInChoiceFragment.d0(OptInChoiceFragment.this, view2);
            }
        });
        LiveData<OptInChoiceState> J = M().J();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<OptInChoiceState, Unit> function1 = new Function1<OptInChoiceState, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OptInChoiceState it) {
                OptInChoiceFragment optInChoiceFragment = OptInChoiceFragment.this;
                Intrinsics.e(it, "it");
                optInChoiceFragment.g0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OptInChoiceState optInChoiceState) {
                b(optInChoiceState);
                return Unit.f50853a;
            }
        };
        J.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OptInChoiceFragment.e0(Function1.this, obj);
            }
        });
        M().G(b0(), a0());
        M().L(a0());
        BaseDialogFragment.f41026i.a(getChildFragmentManager(), "tag_info", new DefaultDialogCallback());
    }
}
