package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import android.os.Bundle;
import android.view.View;
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
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignBonusController;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignConditionDelegate;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDescriptionController;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.MapController;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.android.maps.core.container.MapContainer;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.common.activity.NoToolbarAppearance;
import eu.bolt.driver.core.ui.common.dialog.InfoDialog;
import eu.bolt.driver.core.util.Optional;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignDetailsFragment.kt */
/* loaded from: classes3.dex */
public final class CampaignDetailsFragment extends BazeMvvmFragment<CampaignDetailsViewModel> {
    public static final Companion A = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final MapProvider f27429o;

    /* renamed from: p  reason: collision with root package name */
    private final AppThemeManager f27430p;

    /* renamed from: q  reason: collision with root package name */
    private final HtmlEngine f27431q;

    /* renamed from: r  reason: collision with root package name */
    private final CampaignBonusMapper f27432r;

    /* renamed from: s  reason: collision with root package name */
    private final CampaignInfoBlockMapper f27433s;

    /* renamed from: t  reason: collision with root package name */
    private final CampaignDynamicItemsMapper f27434t;

    /* renamed from: u  reason: collision with root package name */
    private CampaignHeaderController f27435u;

    /* renamed from: v  reason: collision with root package name */
    private CampaignBonusController f27436v;

    /* renamed from: w  reason: collision with root package name */
    private CampaignDescriptionController f27437w;

    /* renamed from: x  reason: collision with root package name */
    private CampaignDynamicItemsController f27438x;

    /* renamed from: y  reason: collision with root package name */
    private final int f27439y;

    /* renamed from: z  reason: collision with root package name */
    public Map<Integer, View> f27440z;

    /* compiled from: CampaignDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(long j8) {
            Bundle bundle = new Bundle();
            bundle.putLong("ARG_CAMPAIGN_ID", j8);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public CampaignDetailsFragment(MapProvider mapProvider, AppThemeManager appThemeManager, HtmlEngine htmlEngine, CampaignBonusMapper campaignBonusMapper, CampaignInfoBlockMapper campaignInfoBlockMapper, CampaignDynamicItemsMapper campaignDynamicItemsMapper, BaseUiDependencies deps) {
        super(deps, R.layout.fragment_campaigns_v2_campaign_details, null, 4, null);
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(campaignBonusMapper, "campaignBonusMapper");
        Intrinsics.f(campaignInfoBlockMapper, "campaignInfoBlockMapper");
        Intrinsics.f(campaignDynamicItemsMapper, "campaignDynamicItemsMapper");
        Intrinsics.f(deps, "deps");
        this.f27440z = new LinkedHashMap();
        this.f27429o = mapProvider;
        this.f27430p = appThemeManager;
        this.f27431q = htmlEngine;
        this.f27432r = campaignBonusMapper;
        this.f27433s = campaignInfoBlockMapper;
        this.f27434t = campaignDynamicItemsMapper;
        this.f27439y = 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(DriverAppPlugin driverAppPlugin, List<Coordinates> list) {
        ((MapContainer) T(R.id.polygonMap)).a();
        driverAppPlugin.l(list, Dimens.d(6), ContextCompat.getColor(requireContext(), R.color.green700), ContextCompat.getColor(requireContext(), R.color.green700Opacity20));
        driverAppPlugin.e(list, 0L, 25.0f);
        driverAppPlugin.c();
    }

    private final long Z() {
        return requireArguments().getLong("ARG_CAMPAIGN_ID");
    }

    private final Navigator a0() {
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            return (Navigator) activity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(CampaignConditionDelegate.Model model) {
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
    public static final void c0(CampaignDetailsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Navigator a02 = this$0.a0();
        if (a02 != null) {
            a02.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(final CampaignDetailsState campaignDetailsState) {
        boolean z7;
        InfoBlockData infoBlockData;
        if (campaignDetailsState == null) {
            NestedScrollView content = (NestedScrollView) T(R.id.S2);
            Intrinsics.e(content, "content");
            ViewExtKt.d(content, false, 0, 2, null);
            return;
        }
        NestedScrollView content2 = (NestedScrollView) T(R.id.S2);
        Intrinsics.e(content2, "content");
        ViewExtKt.d(content2, false, 0, 3, null);
        CampaignHeaderController campaignHeaderController = this.f27435u;
        if (campaignHeaderController != null) {
            campaignHeaderController.b(campaignDetailsState);
        }
        CampaignBonusController campaignBonusController = this.f27436v;
        if (campaignBonusController != null) {
            CampaignBonusController.Model a8 = this.f27432r.a(campaignDetailsState.a().b());
            InfoBlock g8 = campaignDetailsState.a().g();
            if (g8 != null) {
                infoBlockData = this.f27433s.a(g8);
            } else {
                infoBlockData = null;
            }
            campaignBonusController.b(a8, infoBlockData);
        }
        List<Coordinates> m8 = campaignDetailsState.a().m();
        if (m8 != null && !m8.isEmpty()) {
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
            final MapStyle c8 = AppThemeUtils.f34255a.c(this.f27430p.d());
            ((MapContainer) T(R.id.polygonMap)).c(c8);
            getChildFragmentManager().beginTransaction().replace(R.id.f483polygonMap, this.f27429o.a(new Function1<MapController, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsFragment$renderCampaign$mapFragment$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(MapController it) {
                    Intrinsics.f(it, "it");
                    DriverAppPlugin driverAppPlugin = (DriverAppPlugin) it.a("driver");
                    driverAppPlugin.o(MapStyle.this);
                    final CampaignDetailsFragment campaignDetailsFragment = this;
                    driverAppPlugin.y(new Function1<Locatable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsFragment$renderCampaign$mapFragment$1.1
                        {
                            super(1);
                        }

                        public final void b(Locatable it2) {
                            CampaignDetailsViewModel M;
                            Intrinsics.f(it2, "it");
                            M = CampaignDetailsFragment.this.M();
                            M.P();
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Locatable locatable) {
                            b(locatable);
                            return Unit.f50853a;
                        }
                    });
                    this.Y(driverAppPlugin, campaignDetailsState.a().m());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MapController mapController) {
                    b(mapController);
                    return Unit.f50853a;
                }
            }), "map").commit();
        }
        CampaignDescriptionController campaignDescriptionController = this.f27437w;
        if (campaignDescriptionController != null) {
            campaignDescriptionController.b(new CampaignDescriptionController.Model(new Text.Value(this.f27431q.a(campaignDetailsState.a().f())), campaignDetailsState.a().c()));
        }
        CampaignDynamicItemsController campaignDynamicItemsController = this.f27438x;
        if (campaignDynamicItemsController != null) {
            campaignDynamicItemsController.b(this.f27434t.c(campaignDetailsState.a().e(), campaignDetailsState.a().p(), campaignDetailsState.a().o()));
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27440z.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f27439y);
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
        Map<Integer, View> map = this.f27440z;
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
    /* renamed from: e0 */
    public CampaignDetailsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (CampaignDetailsViewModel) new ViewModelProvider(this, E.d()).a(CampaignDetailsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f27435u = null;
        this.f27436v = null;
        this.f27437w = null;
        this.f27438x = null;
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Navigator a02 = a0();
        if (a02 != null) {
            a02.x(new NoToolbarAppearance());
        }
        View header = T(R.id.header);
        Intrinsics.e(header, "header");
        this.f27435u = new CampaignHeaderController(header);
        View bonus = T(R.id.bonus);
        Intrinsics.e(bonus, "bonus");
        this.f27436v = new CampaignBonusController(bonus);
        View conditions = T(R.id.conditions);
        Intrinsics.e(conditions, "conditions");
        this.f27437w = new CampaignDescriptionController(conditions);
        View dynamicItems = T(R.id.dynamicItems);
        Intrinsics.e(dynamicItems, "dynamicItems");
        this.f27438x = new CampaignDynamicItemsController(dynamicItems, new CampaignDetailsFragment$onViewCreated$1(this));
        ((PopupToolbar) T(R.id.kc)).setNavigationOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CampaignDetailsFragment.c0(CampaignDetailsFragment.this, view2);
            }
        });
        M().O(Z());
        M().I(Z());
        LiveData<Optional<CampaignDetailsState>> N = M().N();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Optional<CampaignDetailsState>, Unit> function1 = new Function1<Optional<CampaignDetailsState>, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<CampaignDetailsState> optional) {
                CampaignDetailsFragment.this.f0(optional.b());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<CampaignDetailsState> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        N.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CampaignDetailsFragment.d0(Function1.this, obj);
            }
        });
        BaseDialogFragment.f41026i.a(getChildFragmentManager(), "tag_info", new DefaultDialogCallback());
    }
}
