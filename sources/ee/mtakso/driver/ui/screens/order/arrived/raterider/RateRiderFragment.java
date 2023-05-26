package ee.mtakso.driver.ui.screens.order.arrived.raterider;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.math.MathUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceScreenData;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderReasonsDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uicore.components.views.RatingBarVector;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.SimpleTextWatcher;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateRiderFragment.kt */
/* loaded from: classes3.dex */
public final class RateRiderFragment extends BazeMvvmFragment<DrivePriceViewModel> {

    /* renamed from: v  reason: collision with root package name */
    public static final Companion f31191v = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f31192o;

    /* renamed from: p  reason: collision with root package name */
    private final RateRiderFragment$onCommentTextChangedListener$1 f31193p;

    /* renamed from: q  reason: collision with root package name */
    private LayoutDelegate f31194q;

    /* renamed from: r  reason: collision with root package name */
    private RiderRatingReasons f31195r;

    /* renamed from: s  reason: collision with root package name */
    private Map<Integer, String> f31196s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f31197t;

    /* renamed from: u  reason: collision with root package name */
    public Map<Integer, View> f31198u;

    /* compiled from: RateRiderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RateRiderFragment.kt */
    /* loaded from: classes3.dex */
    public final class HighRatingLayoutDelegate implements LayoutDelegate {
        public HighRatingLayoutDelegate() {
        }

        @Override // ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.LayoutDelegate
        public boolean a() {
            if (((RatingBarVector) RateRiderFragment.this.U(R.id.clientRatingStarBar)).getRating() > 0.0f) {
                return true;
            }
            return false;
        }

        @Override // ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.LayoutDelegate
        public void b() {
            String str;
            RateRiderFragment.this.f31195r = null;
            RecyclerView rateClientReasonsRecyclerView = (RecyclerView) RateRiderFragment.this.U(R.id.rateClientReasonsRecyclerView);
            Intrinsics.e(rateClientReasonsRecyclerView, "rateClientReasonsRecyclerView");
            ViewExtKt.e(rateClientReasonsRecyclerView, false, 0, 2, null);
            TextView zeroRatingLayoutAdditionlNote = (TextView) RateRiderFragment.this.U(R.id.zeroRatingLayoutAdditionlNote);
            Intrinsics.e(zeroRatingLayoutAdditionlNote, "zeroRatingLayoutAdditionlNote");
            ViewExtKt.e(zeroRatingLayoutAdditionlNote, false, 0, 2, null);
            RateRiderFragment rateRiderFragment = RateRiderFragment.this;
            int i8 = R.id.rateClientAdditionalCommentEditText;
            AppCompatEditText rateClientAdditionalCommentEditText = (AppCompatEditText) rateRiderFragment.U(i8);
            Intrinsics.e(rateClientAdditionalCommentEditText, "rateClientAdditionalCommentEditText");
            ViewExtKt.e(rateClientAdditionalCommentEditText, true, 0, 2, null);
            ((RoundButton) RateRiderFragment.this.U(R.id.rateClientConfirmButton)).setEnabled(a());
            ((AppCompatEditText) RateRiderFragment.this.U(i8)).removeTextChangedListener(RateRiderFragment.this.f31193p);
            Map map = RateRiderFragment.this.f31196s;
            if (map != null) {
                str = (String) map.get(Integer.valueOf((int) ((RatingBarVector) RateRiderFragment.this.U(R.id.clientRatingStarBar)).getRating()));
            } else {
                str = null;
            }
            if (str != null) {
                RateRiderFragment rateRiderFragment2 = RateRiderFragment.this;
                int i9 = R.id.rateClientReasonsTitle;
                ((TextView) rateRiderFragment2.U(i9)).setText(str);
                TextView rateClientReasonsTitle = (TextView) RateRiderFragment.this.U(i9);
                Intrinsics.e(rateClientReasonsTitle, "rateClientReasonsTitle");
                ViewExtKt.e(rateClientReasonsTitle, false, 0, 3, null);
                return;
            }
            TextView rateClientReasonsTitle2 = (TextView) RateRiderFragment.this.U(R.id.rateClientReasonsTitle);
            Intrinsics.e(rateClientReasonsTitle2, "rateClientReasonsTitle");
            ViewExtKt.e(rateClientReasonsTitle2, false, 0, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RateRiderFragment.kt */
    /* loaded from: classes3.dex */
    public interface LayoutDelegate {
        boolean a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RateRiderFragment.kt */
    /* loaded from: classes3.dex */
    public final class LowRatingLayoutDelegate implements LayoutDelegate {
        public LowRatingLayoutDelegate() {
        }

        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.LayoutDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a() {
            /*
                r5 = this;
                ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment r0 = ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.this
                int r1 = ee.mtakso.driver.R.id.clientRatingStarBar
                android.view.View r0 = r0.U(r1)
                ee.mtakso.driver.uicore.components.views.RatingBarVector r0 = (ee.mtakso.driver.uicore.components.views.RatingBarVector) r0
                float r0 = r0.getRating()
                ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment r1 = ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.this
                int r2 = ee.mtakso.driver.R.id.rateClientAdditionalCommentEditText
                android.view.View r1 = r1.U(r2)
                androidx.appcompat.widget.AppCompatEditText r1 = (androidx.appcompat.widget.AppCompatEditText) r1
                android.text.Editable r1 = r1.getText()
                if (r1 == 0) goto L23
                java.lang.String r1 = r1.toString()
                goto L24
            L23:
                r1 = 0
            L24:
                r2 = 0
                r3 = 1
                r4 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 <= 0) goto L42
                ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment r0 = ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.this
                ee.mtakso.driver.ui.screens.order.arrived.raterider.RiderRatingReasons r0 = ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.X(r0)
                if (r0 != 0) goto L43
                if (r1 == 0) goto L3e
                boolean r0 = kotlin.text.StringsKt.y(r1)
                if (r0 == 0) goto L3c
                goto L3e
            L3c:
                r0 = 0
                goto L3f
            L3e:
                r0 = 1
            L3f:
                if (r0 != 0) goto L42
                goto L43
            L42:
                r3 = 0
            L43:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.LowRatingLayoutDelegate.a():boolean");
        }

        @Override // ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.LayoutDelegate
        public void b() {
            String str;
            RecyclerView rateClientReasonsRecyclerView = (RecyclerView) RateRiderFragment.this.U(R.id.rateClientReasonsRecyclerView);
            Intrinsics.e(rateClientReasonsRecyclerView, "rateClientReasonsRecyclerView");
            ViewExtKt.e(rateClientReasonsRecyclerView, true, 0, 2, null);
            TextView zeroRatingLayoutAdditionlNote = (TextView) RateRiderFragment.this.U(R.id.zeroRatingLayoutAdditionlNote);
            Intrinsics.e(zeroRatingLayoutAdditionlNote, "zeroRatingLayoutAdditionlNote");
            ViewExtKt.e(zeroRatingLayoutAdditionlNote, false, 0, 2, null);
            RateRiderFragment rateRiderFragment = RateRiderFragment.this;
            int i8 = R.id.rateClientAdditionalCommentEditText;
            AppCompatEditText rateClientAdditionalCommentEditText = (AppCompatEditText) rateRiderFragment.U(i8);
            Intrinsics.e(rateClientAdditionalCommentEditText, "rateClientAdditionalCommentEditText");
            ViewExtKt.e(rateClientAdditionalCommentEditText, true, 0, 2, null);
            RateRiderFragment.this.o0();
            ((RoundButton) RateRiderFragment.this.U(R.id.rateClientConfirmButton)).setEnabled(a());
            ((AppCompatEditText) RateRiderFragment.this.U(i8)).addTextChangedListener(RateRiderFragment.this.f31193p);
            Map map = RateRiderFragment.this.f31196s;
            if (map != null) {
                str = (String) map.get(Integer.valueOf((int) ((RatingBarVector) RateRiderFragment.this.U(R.id.clientRatingStarBar)).getRating()));
            } else {
                str = null;
            }
            if (str != null) {
                RateRiderFragment rateRiderFragment2 = RateRiderFragment.this;
                int i9 = R.id.rateClientReasonsTitle;
                ((TextView) rateRiderFragment2.U(i9)).setText(str);
                TextView rateClientReasonsTitle = (TextView) RateRiderFragment.this.U(i9);
                Intrinsics.e(rateClientReasonsTitle, "rateClientReasonsTitle");
                ViewExtKt.e(rateClientReasonsTitle, false, 0, 3, null);
                return;
            }
            TextView rateClientReasonsTitle2 = (TextView) RateRiderFragment.this.U(R.id.rateClientReasonsTitle);
            Intrinsics.e(rateClientReasonsTitle2, "rateClientReasonsTitle");
            ViewExtKt.e(rateClientReasonsTitle2, false, 0, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RateRiderFragment.kt */
    /* loaded from: classes3.dex */
    public final class ZeroRatingLayoutDelegate implements LayoutDelegate {
        public ZeroRatingLayoutDelegate() {
        }

        @Override // ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.LayoutDelegate
        public boolean a() {
            return false;
        }

        @Override // ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment.LayoutDelegate
        public void b() {
            TextView zeroRatingLayoutAdditionlNote = (TextView) RateRiderFragment.this.U(R.id.zeroRatingLayoutAdditionlNote);
            Intrinsics.e(zeroRatingLayoutAdditionlNote, "zeroRatingLayoutAdditionlNote");
            ViewExtKt.e(zeroRatingLayoutAdditionlNote, true, 0, 2, null);
            TextView rateClientReasonsTitle = (TextView) RateRiderFragment.this.U(R.id.rateClientReasonsTitle);
            Intrinsics.e(rateClientReasonsTitle, "rateClientReasonsTitle");
            ViewExtKt.e(rateClientReasonsTitle, false, 0, 2, null);
            RecyclerView rateClientReasonsRecyclerView = (RecyclerView) RateRiderFragment.this.U(R.id.rateClientReasonsRecyclerView);
            Intrinsics.e(rateClientReasonsRecyclerView, "rateClientReasonsRecyclerView");
            ViewExtKt.e(rateClientReasonsRecyclerView, false, 0, 2, null);
            RateRiderFragment rateRiderFragment = RateRiderFragment.this;
            int i8 = R.id.rateClientAdditionalCommentEditText;
            AppCompatEditText rateClientAdditionalCommentEditText = (AppCompatEditText) rateRiderFragment.U(i8);
            Intrinsics.e(rateClientAdditionalCommentEditText, "rateClientAdditionalCommentEditText");
            ViewExtKt.e(rateClientAdditionalCommentEditText, false, 0, 2, null);
            ((RoundButton) RateRiderFragment.this.U(R.id.rateClientConfirmButton)).setEnabled(false);
            ((AppCompatEditText) RateRiderFragment.this.U(i8)).removeTextChangedListener(RateRiderFragment.this.f31193p);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v3, types: [ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment$onCommentTextChangedListener$1] */
    @Inject
    public RateRiderFragment(BaseUiDependencies baseUiDependencies) {
        super(baseUiDependencies, R.layout.fragment_rate_rider, null, 4, null);
        Lazy b8;
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        this.f31198u = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<DiffAdapter>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment$diffAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DiffAdapter invoke() {
                DiffAdapter diffAdapter = new DiffAdapter();
                final RateRiderFragment rateRiderFragment = RateRiderFragment.this;
                return diffAdapter.P(new RateRiderReasonsDelegate(new Function2<View, RateRiderReasonsDelegate.Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment$diffAdapter$2.1
                    {
                        super(2);
                    }

                    public final void b(View v7, RateRiderReasonsDelegate.Model model) {
                        Intrinsics.f(v7, "v");
                        Intrinsics.f(model, "model");
                        RateRiderFragment.this.i0(model);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit s(View view, RateRiderReasonsDelegate.Model model) {
                        b(view, model);
                        return Unit.f50853a;
                    }
                }));
            }
        });
        this.f31192o = b8;
        this.f31193p = new SimpleTextWatcher() { // from class: ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment$onCommentTextChangedListener$1
            @Override // ee.mtakso.driver.uicore.utils.SimpleTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RateRiderFragment.this.n0();
            }
        };
    }

    private final void f0(View view, boolean z7) {
        String str;
        RiderRatingReasons riderRatingReasons = this.f31195r;
        if (riderRatingReasons != null) {
            str = riderRatingReasons.getId();
        } else {
            str = null;
        }
        RiderRatingInfo riderRatingInfo = new RiderRatingInfo(str, String.valueOf(((AppCompatEditText) U(R.id.rateClientAdditionalCommentEditText)).getText()), (int) ((RatingBarVector) U(R.id.clientRatingStarBar)).getRating());
        if (riderRatingInfo.c() == 1 && z7) {
            g0().a(RateRiderDisclaimerFragment.class, RateRiderDisclaimerFragment.f31186h.a(riderRatingInfo));
            return;
        }
        ((RoundButton) U(R.id.rateClientConfirmButton)).k();
        g0().k(this, view, riderRatingInfo);
    }

    private final RateRiderContainer g0() {
        Fragment parentFragment = getParentFragment();
        Intrinsics.d(parentFragment, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderContainer");
        return (RateRiderContainer) parentFragment;
    }

    private final DiffAdapter h0() {
        return (DiffAdapter) this.f31192o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(RateRiderReasonsDelegate.Model model) {
        RiderRatingReasons n8;
        if (model.o()) {
            n8 = null;
        } else {
            n8 = model.n();
        }
        this.f31195r = n8;
        o0();
        n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(RateRiderFragment this$0, RatingBar ratingBar, float f8, boolean z7) {
        boolean z8;
        Intrinsics.f(this$0, "this$0");
        this$0.p0(f8);
        if (z7) {
            float a8 = MathUtils.a(f8, 1.0f, 5.0f);
            if (a8 == f8) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (!z8) {
                ratingBar.setRating(a8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(RateRiderFragment this$0, View v7) {
        Intrinsics.f(this$0, "this$0");
        if (((RoundButton) this$0.U(R.id.rateClientConfirmButton)).isEnabled()) {
            Intrinsics.e(v7, "v");
            this$0.f0(v7, this$0.f31197t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        boolean z7;
        RoundButton roundButton = (RoundButton) U(R.id.rateClientConfirmButton);
        LayoutDelegate layoutDelegate = this.f31194q;
        if (layoutDelegate != null) {
            z7 = layoutDelegate.a();
        } else {
            z7 = false;
        }
        roundButton.setEnabled(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        boolean z7;
        int J;
        DividerModel dividerModel;
        DiffAdapter h02 = h0();
        RiderRatingReasons[] values = RiderRatingReasons.values();
        ArrayList arrayList = new ArrayList(values.length);
        int length = values.length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            RiderRatingReasons riderRatingReasons = values[i8];
            int i10 = i9 + 1;
            if (riderRatingReasons == this.f31195r) {
                z7 = true;
            } else {
                z7 = false;
            }
            J = ArraysKt___ArraysKt.J(RiderRatingReasons.values());
            if (i9 != J) {
                dividerModel = new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null);
            } else {
                dividerModel = NoDivider.f34829a;
            }
            arrayList.add(new RateRiderReasonsDelegate.Model(riderRatingReasons, z7, null, dividerModel, 4, null));
            i8++;
            i9 = i10;
        }
        DiffAdapter.V(h02, arrayList, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(float f8) {
        LayoutDelegate zeroRatingLayoutDelegate;
        int i8 = R.id.rateClientContainer;
        TransitionManager.a((ConstraintLayout) U(i8));
        if (f8 >= 4.0f) {
            zeroRatingLayoutDelegate = new HighRatingLayoutDelegate();
        } else {
            boolean z7 = false;
            if (1.0f <= f8 && f8 <= 3.0f) {
                z7 = true;
            }
            if (z7) {
                zeroRatingLayoutDelegate = new LowRatingLayoutDelegate();
            } else {
                zeroRatingLayoutDelegate = new ZeroRatingLayoutDelegate();
            }
        }
        this.f31194q = zeroRatingLayoutDelegate;
        zeroRatingLayoutDelegate.b();
        ((ConstraintLayout) U(i8)).requestLayout();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f31198u.clear();
    }

    public View U(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31198u;
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
    /* renamed from: m0 */
    public DrivePriceViewModel Q() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return (DrivePriceViewModel) new ViewModelProvider(requireActivity, BazeMvvmFragment.L(this).d()).a(DrivePriceViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        RiderRatingReasons riderRatingReasons;
        String string;
        super.onCreate(bundle);
        if (bundle != null && (string = bundle.getString("selected_reason")) != null) {
            riderRatingReasons = RiderRatingReasons.f31218h.a(string);
        } else {
            riderRatingReasons = null;
        }
        this.f31195r = riderRatingReasons;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        String str;
        Intrinsics.f(outState, "outState");
        super.onSaveInstanceState(outState);
        RiderRatingReasons riderRatingReasons = this.f31195r;
        if (riderRatingReasons != null) {
            str = riderRatingReasons.getId();
        } else {
            str = null;
        }
        outState.putString("selected_reason", str);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        LiveData<DrivePriceScreenData> m02 = M().m0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<DrivePriceScreenData, Unit> function1 = new Function1<DrivePriceScreenData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DrivePriceScreenData drivePriceScreenData) {
                RateRiderFragment.this.f31196s = drivePriceScreenData.m();
                RateRiderFragment.this.f31197t = drivePriceScreenData.q();
                RateRiderFragment.this.p0(5.0f);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrivePriceScreenData drivePriceScreenData) {
                b(drivePriceScreenData);
                return Unit.f50853a;
            }
        };
        m02.i(viewLifecycleOwner, new Observer() { // from class: r4.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RateRiderFragment.j0(Function1.this, obj);
            }
        });
        int i8 = R.id.rateClientReasonsRecyclerView;
        ((RecyclerView) U(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) U(i8)).setAdapter(h0());
        ((RecyclerView) U(i8)).setItemAnimator(null);
        ((RecyclerView) U(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        int i9 = R.id.clientRatingStarBar;
        ((RatingBarVector) U(i9)).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: r4.c
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public final void onRatingChanged(RatingBar ratingBar, float f8, boolean z7) {
                RateRiderFragment.k0(RateRiderFragment.this, ratingBar, f8, z7);
            }
        });
        ((RatingBarVector) U(i9)).setRating(5.0f);
        ((RoundButton) U(R.id.rateClientConfirmButton)).setOnClickListener(new View.OnClickListener() { // from class: r4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateRiderFragment.l0(RateRiderFragment.this, view2);
            }
        });
    }
}
