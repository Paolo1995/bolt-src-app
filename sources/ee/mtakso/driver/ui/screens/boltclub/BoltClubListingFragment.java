package ee.mtakso.driver.ui.screens.boltclub;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.boltclub.delegates.OfferListDelegate;
import ee.mtakso.driver.ui.screens.boltclub.delegates.SimpleFooterDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ItemHeaderDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.IndeterminateProgressView;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltClubListingFragment.kt */
/* loaded from: classes3.dex */
public final class BoltClubListingFragment extends BazeMvvmFragment<BoltClubViewModel> {

    /* renamed from: o  reason: collision with root package name */
    public PopupToolbarAppearance f27124o;

    /* renamed from: p  reason: collision with root package name */
    private final int f27125p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f27126q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f27127r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public BoltClubListingFragment(BaseUiDependencies baseUiDependencies) {
        super(baseUiDependencies, R.layout.fragment_bolt_club_offers_listing, null, 4, null);
        Lazy b8;
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        this.f27127r = new LinkedHashMap();
        this.f27125p = 2132017818;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DiffAdapter>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubListingFragment$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DiffAdapter invoke() {
                DiffAdapter diffAdapter = new DiffAdapter();
                final BoltClubListingFragment boltClubListingFragment = BoltClubListingFragment.this;
                diffAdapter.P(new ItemHeaderDelegate());
                diffAdapter.P(new OfferListDelegate(new Function2<Long, String, Unit>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubListingFragment$adapter$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    public final void b(long j8, String offerTitle) {
                        Intrinsics.f(offerTitle, "offerTitle");
                        BoltClubListingFragment.this.b0(j8, offerTitle);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit s(Long l8, String str) {
                        b(l8.longValue(), str);
                        return Unit.f50853a;
                    }
                }));
                diffAdapter.P(new SimpleFooterDelegate());
                return diffAdapter;
            }
        });
        this.f27126q = b8;
    }

    private final Image W(String str) {
        boolean z7;
        if (str != null && str.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            return null;
        }
        return new Image.Res(R.drawable.ic_faq_link_24);
    }

    private final DiffAdapter X() {
        return (DiffAdapter) this.f27126q.getValue();
    }

    private final Navigator Y() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(String str) {
        if (str != null) {
            M().O(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(long j8, String str) {
        Navigator.DefaultImpls.b(Y(), BoltClubOfferDetailsFragment.class, BoltClubOfferDetailsFragment.f27134s.a(j8, str), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(final BoltClubOffersState boltClubOffersState) {
        Color.Attr attr = new Color.Attr(R.attr.backPrimary);
        e0(new PopupToolbarAppearance(0, new Text.Value(boltClubOffersState.d()), false, null, null, attr, W(boltClubOffersState.a()), new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubListingFragment$updateScreenData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                BoltClubListingFragment.this.a0(boltClubOffersState.a());
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }, new Color.Attr(R.attr.contentPrimary), 29, null));
        Y().x(Z());
        if (boltClubOffersState.b().isEmpty()) {
            if (boltClubOffersState.c() != null) {
                int i8 = R.id.emptyOfferListLayout;
                ((AppCompatTextView) ((ConstraintLayout) S(i8)).findViewById(R.id.noOffersTitle)).setText(boltClubOffersState.c().b());
                ((AppCompatTextView) ((ConstraintLayout) S(i8)).findViewById(R.id.noOffersSubtitle)).setText(boltClubOffersState.c().a());
                RecyclerView offersList = (RecyclerView) S(R.id.offersList);
                Intrinsics.e(offersList, "offersList");
                ViewExtKt.d(offersList, false, 0, 2, null);
                ConstraintLayout emptyOfferListLayout = (ConstraintLayout) S(i8);
                Intrinsics.e(emptyOfferListLayout, "emptyOfferListLayout");
                ViewExtKt.d(emptyOfferListLayout, false, 0, 3, null);
                return;
            }
            Kalev.d("Offer Group is empty and no_offers_available is null");
            return;
        }
        ConstraintLayout emptyOfferListLayout2 = (ConstraintLayout) S(R.id.emptyOfferListLayout);
        Intrinsics.e(emptyOfferListLayout2, "emptyOfferListLayout");
        ViewExtKt.d(emptyOfferListLayout2, false, 0, 2, null);
        RecyclerView offersList2 = (RecyclerView) S(R.id.offersList);
        Intrinsics.e(offersList2, "offersList");
        ViewExtKt.d(offersList2, false, 0, 3, null);
        DiffAdapter.V(X(), boltClubOffersState.b(), null, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27127r.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f27125p);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void G() {
        super.G();
        IndeterminateProgressView loadingView = (IndeterminateProgressView) S(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.d(loadingView, false, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void I() {
        super.I();
        IndeterminateProgressView loadingView = (IndeterminateProgressView) S(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.d(loadingView, true, 0, 2, null);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27127r;
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

    public final PopupToolbarAppearance Z() {
        PopupToolbarAppearance popupToolbarAppearance = this.f27124o;
        if (popupToolbarAppearance != null) {
            return popupToolbarAppearance;
        }
        Intrinsics.w("popupToolbarAppearance");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: d0 */
    public BoltClubViewModel Q() {
        return (BoltClubViewModel) new ViewModelProvider(this, BazeMvvmFragment.L(this).d()).a(BoltClubViewModel.class);
    }

    public final void e0(PopupToolbarAppearance popupToolbarAppearance) {
        Intrinsics.f(popupToolbarAppearance, "<set-?>");
        this.f27124o = popupToolbarAppearance;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.offersList;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(X());
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        LiveData<BoltClubOffersState> N = M().N();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<BoltClubOffersState, Unit> function1 = new Function1<BoltClubOffersState, Unit>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubListingFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(BoltClubOffersState boltClubData) {
                BoltClubListingFragment boltClubListingFragment = BoltClubListingFragment.this;
                Intrinsics.e(boltClubData, "boltClubData");
                boltClubListingFragment.f0(boltClubData);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BoltClubOffersState boltClubOffersState) {
                b(boltClubOffersState);
                return Unit.f50853a;
            }
        };
        N.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.boltclub.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BoltClubListingFragment.c0(Function1.this, obj);
            }
        });
    }
}
