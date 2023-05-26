package ee.mtakso.driver.ui.screens.boltclub;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.boltclub.delegates.BoltClubSectionDelegate;
import ee.mtakso.driver.ui.screens.boltclub.delegates.DetailsHeaderDelegate;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.IndeterminateProgressView;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltClubOfferDetailsFragment.kt */
/* loaded from: classes3.dex */
public final class BoltClubOfferDetailsFragment extends BazeMvvmFragment<BoltClubOfferDetailsViewModel> {

    /* renamed from: s  reason: collision with root package name */
    public static final Companion f27134s = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final int f27135o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f27136p;

    /* renamed from: q  reason: collision with root package name */
    private Snackbar f27137q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f27138r;

    /* compiled from: BoltClubOfferDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Bundle b(Companion companion, long j8, String str, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                str = null;
            }
            return companion.a(j8, str);
        }

        public final Bundle a(long j8, String str) {
            Bundle bundle = new Bundle();
            bundle.putLong("ARG_OFFER_ID", j8);
            bundle.putString("ARG_OFFER_TITLE", str);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public BoltClubOfferDetailsFragment(BaseUiDependencies baseUiDependencies) {
        super(baseUiDependencies, R.layout.fragment_bolt_club_offer_details, null, 4, null);
        Lazy b8;
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        this.f27138r = new LinkedHashMap();
        this.f27135o = 2132017818;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DiffAdapter>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsFragment$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DiffAdapter invoke() {
                DiffAdapter diffAdapter = new DiffAdapter();
                BoltClubOfferDetailsFragment boltClubOfferDetailsFragment = BoltClubOfferDetailsFragment.this;
                diffAdapter.P(new DetailsHeaderDelegate());
                diffAdapter.P(new BoltClubSectionDelegate());
                diffAdapter.P(new ButtonItemDelegate(new BoltClubOfferDetailsFragment$adapter$2$1$1(boltClubOfferDetailsFragment)));
                return diffAdapter;
            }
        });
        this.f27136p = b8;
    }

    private final DiffAdapter W() {
        return (DiffAdapter) this.f27136p.getValue();
    }

    private final Navigator X() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    private final long Y() {
        return requireArguments().getLong("ARG_OFFER_ID");
    }

    private final String Z() {
        return requireArguments().getString("ARG_OFFER_TITLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(ButtonItemDelegate.Model<String> model) {
        M().V();
        String t7 = model.t();
        if (t7 != null) {
            M().T(t7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(boolean z7) {
        boolean z8 = !z7;
        M().Q(z8);
        c0(z8);
    }

    private final void c0(boolean z7) {
        Snackbar snackbar = this.f27137q;
        if (snackbar != null) {
            if (!snackbar.O() && z7) {
                snackbar.e0();
            } else {
                snackbar.A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void f0(View view) {
        this.f27137q = Snackbar.u0(view, R.string.offers_added_to_favorites, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(BoltClubDetailsState boltClubDetailsState) {
        h0(boltClubDetailsState);
        DiffAdapter.V(W(), boltClubDetailsState.d(), null, 2, null);
    }

    private final void h0(BoltClubDetailsState boltClubDetailsState) {
        Image.Res res;
        final boolean g8 = boltClubDetailsState.g();
        if (boltClubDetailsState.h()) {
            if (g8) {
                res = new Image.Res(R.drawable.ic_heart_fill_24);
            } else {
                res = new Image.Res(R.drawable.ic_heart_no_fill_24);
            }
        } else {
            res = null;
        }
        X().x(new PopupToolbarAppearance(0, new Text.Value(""), false, null, null, null, res, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsFragment$updateToolbar$popupToolbarAppearance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                BoltClubOfferDetailsFragment.this.b0(g8);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }, new Color.Attr(R.attr.contentPrimary), 61, null));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27138r.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f27135o);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void G() {
        super.G();
        IndeterminateProgressView loadingView = (IndeterminateProgressView) S(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.e(loadingView, false, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void I() {
        super.I();
        IndeterminateProgressView loadingView = (IndeterminateProgressView) S(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.e(loadingView, true, 0, 2, null);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27138r;
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
    public BoltClubOfferDetailsViewModel Q() {
        return (BoltClubOfferDetailsViewModel) new ViewModelProvider(this, BazeMvvmFragment.L(this).d()).a(BoltClubOfferDetailsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Snackbar snackbar = this.f27137q;
        if (snackbar != null) {
            snackbar.A();
        }
        this.f27137q = null;
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LiveData<BoltClubDetailsState> P = M().P();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<BoltClubDetailsState, Unit> function1 = new Function1<BoltClubDetailsState, Unit>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsFragment$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(BoltClubDetailsState offerDescription) {
                BoltClubOfferDetailsFragment boltClubOfferDetailsFragment = BoltClubOfferDetailsFragment.this;
                Intrinsics.e(offerDescription, "offerDescription");
                boltClubOfferDetailsFragment.g0(offerDescription);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BoltClubDetailsState boltClubDetailsState) {
                b(boltClubDetailsState);
                return Unit.f50853a;
            }
        };
        P.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.boltclub.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BoltClubOfferDetailsFragment.d0(Function1.this, obj);
            }
        });
        String Z = Z();
        if (Z != null) {
            M().W(Z);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        PopupToolbarAppearance popupToolbarAppearance = new PopupToolbarAppearance(0, new Text.Value(""), false, null, null, new Color.Attr(R.attr.backTertiary), null, null, new Color.Attr(R.attr.contentPrimary), 221, null);
        f0(view);
        X().x(popupToolbarAppearance);
        int i8 = R.id.descriptionList;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(W());
        long Y = Y();
        AppThemeUtils appThemeUtils = AppThemeUtils.f34255a;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        M().L(Y, appThemeUtils.b(requireContext));
    }
}
