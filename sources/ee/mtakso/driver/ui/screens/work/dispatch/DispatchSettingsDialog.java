package ee.mtakso.driver.ui.screens.work.dispatch;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.settings.AutoOrderAcceptance;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment;
import ee.mtakso.driver.ui.onbordingtooltips.SurgeToolTipDelegate;
import ee.mtakso.driver.ui.screens.dialogs.InfoDialog;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserItemDivider;
import ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog;
import ee.mtakso.driver.ui.views.DynamicViewHelper;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.ContextUtils;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.common.dialog.InfoDialog;
import eu.bolt.driver.core.ui.common.error.view.ErrorViewController;
import eu.bolt.driver.core.ui.common.error.view.ErrorViewInflater;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DispatchSettingsDialog.kt */
/* loaded from: classes5.dex */
public final class DispatchSettingsDialog extends BaseMvvmBottomSheetDialogFragment<DispatchSettingsViewModel> {
    public static final Companion D = new Companion(null);
    private final boolean A;
    private final Lazy B;
    public Map<Integer, View> C = new LinkedHashMap();

    /* renamed from: r  reason: collision with root package name */
    private SurgeToolTipDelegate f33972r;

    /* renamed from: s  reason: collision with root package name */
    private Disposable f33973s;

    /* renamed from: t  reason: collision with root package name */
    private final Function2<Integer, Boolean, Unit> f33974t;

    /* renamed from: u  reason: collision with root package name */
    private final Function1<Integer, Unit> f33975u;

    /* renamed from: v  reason: collision with root package name */
    private final CategoryAdapter f33976v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f33977w;

    /* renamed from: x  reason: collision with root package name */
    private final Lazy f33978x;

    /* renamed from: y  reason: collision with root package name */
    private DynamicViewHelper<ChipViewHolder> f33979y;

    /* renamed from: z  reason: collision with root package name */
    private final int f33980z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DispatchSettingsDialog.kt */
    /* loaded from: classes5.dex */
    public static final class ChipViewHolder implements DynamicViewHelper.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f33981a;

        /* renamed from: b  reason: collision with root package name */
        private final Chip f33982b;

        /* renamed from: c  reason: collision with root package name */
        public Map<Integer, View> f33983c;

        public ChipViewHolder(View containerView) {
            Intrinsics.f(containerView, "containerView");
            this.f33983c = new LinkedHashMap();
            this.f33981a = containerView;
            View a8 = a();
            Intrinsics.d(a8, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            this.f33982b = (Chip) a8;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewHelper.ViewHolder
        public View a() {
            return this.f33981a;
        }

        public final Chip b() {
            return this.f33982b;
        }
    }

    /* compiled from: DispatchSettingsDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DispatchSettingsDialog a(String carName) {
            Intrinsics.f(carName, "carName");
            Bundle bundle = new Bundle();
            bundle.putString("argument_car_name", carName);
            DispatchSettingsDialog dispatchSettingsDialog = new DispatchSettingsDialog();
            dispatchSettingsDialog.setArguments(bundle);
            return dispatchSettingsDialog;
        }
    }

    public DispatchSettingsDialog() {
        Lazy b8;
        Lazy b9;
        Function2<Integer, Boolean, Unit> function2 = new Function2<Integer, Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$checkboxCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(int i8, boolean z7) {
                CategoryAdapter categoryAdapter;
                if (i8 > -1) {
                    DispatchSettingsViewModel P = DispatchSettingsDialog.this.P();
                    categoryAdapter = DispatchSettingsDialog.this.f33976v;
                    P.d0(categoryAdapter.R().get(i8), z7);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(Integer num, Boolean bool) {
                b(num.intValue(), bool.booleanValue());
                return Unit.f50853a;
            }
        };
        this.f33974t = function2;
        Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$surgeButtonCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(int i8) {
                CategoryAdapter categoryAdapter;
                if (i8 > -1) {
                    categoryAdapter = DispatchSettingsDialog.this.f33976v;
                    DispatchCategorySetting dispatchCategorySetting = categoryAdapter.R().get(i8);
                    Boolean c8 = dispatchCategorySetting.c();
                    if (Intrinsics.a(c8, Boolean.TRUE)) {
                        DispatchSettingsDialog.this.P().e0(dispatchCategorySetting.a().c());
                    } else if (Intrinsics.a(c8, Boolean.FALSE)) {
                        DispatchSettingsDialog.this.P().f0(dispatchCategorySetting.a().c());
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                b(num.intValue());
                return Unit.f50853a;
            }
        };
        this.f33975u = function1;
        this.f33976v = new CategoryAdapter(function2, function1);
        b8 = LazyKt__LazyJVMKt.b(new Function0<ErrorViewController>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$errorViewController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ErrorViewController invoke() {
                ErrorViewInflater errorViewInflater = ErrorViewInflater.f41109a;
                ViewStub errorViewStub = (ViewStub) DispatchSettingsDialog.this.j0(R.id.errorViewStub);
                Intrinsics.e(errorViewStub, "errorViewStub");
                return errorViewInflater.a(errorViewStub);
            }
        });
        this.f33978x = b8;
        this.f33980z = R.layout.fragment_car_category_picker;
        this.A = true;
        b9 = LazyKt__LazyJVMKt.b(new Function0<DispatchSettingsViewModel>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DispatchSettingsViewModel invoke() {
                DispatchSettingsDialog dispatchSettingsDialog = DispatchSettingsDialog.this;
                return (DispatchSettingsViewModel) new ViewModelProvider(dispatchSettingsDialog, dispatchSettingsDialog.Q()).a(DispatchSettingsViewModel.class);
            }
        });
        this.B = b9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(DispatchSettingsDialog this$0, DispatchSettingsState it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.M0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(DispatchSettingsDialog this$0, String str) {
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        if (str != null && str.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7 && this$0.getActivity() != null) {
            Toast.makeText(this$0.getActivity(), str, 0).show();
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(DispatchSettingsDialog this$0, Boolean isLoading) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(isLoading, "isLoading");
        if (isLoading.booleanValue()) {
            ((RoundButton) this$0.j0(R.id.confirmBtn)).k();
        } else {
            ((RoundButton) this$0.j0(R.id.confirmBtn)).g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0() {
        View view;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        View view2;
        Fragment parentFragment = getParentFragment();
        Integer num = null;
        if (parentFragment != null) {
            view = parentFragment.getView();
        } else {
            view = null;
        }
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        View view3 = getView();
        if (view3 instanceof ViewGroup) {
            viewGroup2 = (ViewGroup) view3;
        } else {
            viewGroup2 = null;
        }
        if (viewGroup != null && viewGroup2 != null) {
            int i8 = 0;
            ((LinearLayout) j0(R.id.carCategoryPickerContainer)).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            RecyclerView.ViewHolder a02 = ((RecyclerView) j0(R.id.categories)).a0(0);
            if (a02 != null && (view2 = a02.f7332a) != null) {
                num = Integer.valueOf(view2.getHeight() / 2);
            }
            if (num != null) {
                i8 = num.intValue();
            }
            this.f33972r = new SurgeToolTipDelegate(viewGroup, viewGroup2, ((TextView) j0(R.id.carCategorySelectionTitle)).getMeasuredHeight() + ((TextView) j0(R.id.carCategorySelectionSubTitle)).getMeasuredHeight() + i8, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$showCategoriesToolTip$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final void b() {
                    DispatchSettingsDialog.this.q0();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
            E0();
            return;
        }
        Kalev.d("Rootlayout or parentLayout is null");
    }

    private final void E0() {
        Observable observeOn = Observable.just(Unit.f50853a).delay(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.a());
        final Function1<Unit, Unit> function1 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$showOnBoardingWithDelay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Unit unit) {
                SurgeToolTipDelegate surgeToolTipDelegate;
                surgeToolTipDelegate = DispatchSettingsDialog.this.f33972r;
                if (surgeToolTipDelegate != null) {
                    surgeToolTipDelegate.f();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                b(unit);
                return Unit.f50853a;
            }
        };
        this.f33973s = observeOn.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsDialog.F0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0() {
        List<DispatchCategorySetting> list;
        boolean z7;
        DispatchSettingsState f8 = P().W().f();
        AutoOrderAcceptance autoOrderAcceptance = null;
        if (f8 != null) {
            list = f8.b();
        } else {
            list = null;
        }
        LinearLayout autoAcceptanceContainer = (LinearLayout) j0(R.id.autoAcceptanceContainer);
        Intrinsics.e(autoAcceptanceContainer, "autoAcceptanceContainer");
        if (autoAcceptanceContainer.getVisibility() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (((SwitchCompat) j0(R.id.switchEnabledAutoAcceptance)).isChecked()) {
                autoOrderAcceptance = AutoOrderAcceptance.AUTO;
            } else {
                autoOrderAcceptance = AutoOrderAcceptance.MANUAL;
            }
        }
        P().i0(list, autoOrderAcceptance);
    }

    private final void H0(DispatchSettingsState dispatchSettingsState) {
        boolean z7;
        List<DispatchCategorySetting> b8 = dispatchSettingsState.b();
        AutoOrderAcceptance a8 = dispatchSettingsState.a();
        if ((b8 != null && b8.isEmpty()) || a8 == null) {
            LinearLayout autoAcceptanceContainer = (LinearLayout) j0(R.id.autoAcceptanceContainer);
            Intrinsics.e(autoAcceptanceContainer, "autoAcceptanceContainer");
            ViewExtKt.e(autoAcceptanceContainer, false, 0, 2, null);
            return;
        }
        LinearLayout autoAcceptanceContainer2 = (LinearLayout) j0(R.id.autoAcceptanceContainer);
        Intrinsics.e(autoAcceptanceContainer2, "autoAcceptanceContainer");
        ViewExtKt.e(autoAcceptanceContainer2, false, 0, 3, null);
        SwitchCompat switchCompat = (SwitchCompat) j0(R.id.switchEnabledAutoAcceptance);
        if (a8 == AutoOrderAcceptance.AUTO) {
            z7 = true;
        } else {
            z7 = false;
        }
        switchCompat.setChecked(z7);
        if (b8 == null) {
            TextView textAutoAcceptanceNoCategory = (TextView) j0(R.id.textAutoAcceptanceNoCategory);
            Intrinsics.e(textAutoAcceptanceNoCategory, "textAutoAcceptanceNoCategory");
            ViewExtKt.e(textAutoAcceptanceNoCategory, true, 0, 2, null);
            AppCompatImageView aboutAutoAcceptance = (AppCompatImageView) j0(R.id.aboutAutoAcceptance);
            Intrinsics.e(aboutAutoAcceptance, "aboutAutoAcceptance");
            ViewExtKt.e(aboutAutoAcceptance, false, 0, 2, null);
            View autoAcceptanceScrollableShadowIndicator = j0(R.id.autoAcceptanceScrollableShadowIndicator);
            Intrinsics.e(autoAcceptanceScrollableShadowIndicator, "autoAcceptanceScrollableShadowIndicator");
            ViewExtKt.e(autoAcceptanceScrollableShadowIndicator, false, 0, 2, null);
            return;
        }
        TextView textAutoAcceptanceNoCategory2 = (TextView) j0(R.id.textAutoAcceptanceNoCategory);
        Intrinsics.e(textAutoAcceptanceNoCategory2, "textAutoAcceptanceNoCategory");
        ViewExtKt.e(textAutoAcceptanceNoCategory2, false, 0, 2, null);
        AppCompatImageView aboutAutoAcceptance2 = (AppCompatImageView) j0(R.id.aboutAutoAcceptance);
        Intrinsics.e(aboutAutoAcceptance2, "aboutAutoAcceptance");
        ViewExtKt.e(aboutAutoAcceptance2, true, 0, 2, null);
    }

    private final void I0(final DispatchSettingsState dispatchSettingsState) {
        int i8 = R.id.confirmBtn;
        ((RoundButton) j0(i8)).setEnabled(true);
        if (dispatchSettingsState.c()) {
            this.f33976v.V();
        } else {
            this.f33976v.S();
        }
        if (dispatchSettingsState.b() == null) {
            TextView carCategorySelectionTitle = (TextView) j0(R.id.carCategorySelectionTitle);
            Intrinsics.e(carCategorySelectionTitle, "carCategorySelectionTitle");
            ViewExtKt.e(carCategorySelectionTitle, false, 0, 2, null);
            TextView carCategorySelectionSubTitle = (TextView) j0(R.id.carCategorySelectionSubTitle);
            Intrinsics.e(carCategorySelectionSubTitle, "carCategorySelectionSubTitle");
            ViewExtKt.e(carCategorySelectionSubTitle, false, 0, 2, null);
            RecyclerView categories = (RecyclerView) j0(R.id.categories);
            Intrinsics.e(categories, "categories");
            ViewExtKt.e(categories, false, 0, 2, null);
            View autoAcceptanceScrollableShadowIndicator = j0(R.id.autoAcceptanceScrollableShadowIndicator);
            Intrinsics.e(autoAcceptanceScrollableShadowIndicator, "autoAcceptanceScrollableShadowIndicator");
            ViewExtKt.e(autoAcceptanceScrollableShadowIndicator, false, 0, 2, null);
            View noCategoryPicker = j0(R.id.noCategoryPicker);
            Intrinsics.e(noCategoryPicker, "noCategoryPicker");
            ViewExtKt.e(noCategoryPicker, false, 0, 2, null);
        } else if (dispatchSettingsState.b().isEmpty()) {
            this.f33977w = true;
            ((TextView) j0(R.id.noCategorySubtitle)).setText(r0());
            ((TextView) j0(R.id.noCategoryMessage)).setText(getString(R.string.categories_not_available_message));
            TextView categoriesError = (TextView) j0(R.id.categoriesError);
            Intrinsics.e(categoriesError, "categoriesError");
            ViewExtKt.e(categoriesError, false, 0, 2, null);
            LinearLayout carCategoryPickerContainer = (LinearLayout) j0(R.id.carCategoryPickerContainer);
            Intrinsics.e(carCategoryPickerContainer, "carCategoryPickerContainer");
            ViewExtKt.e(carCategoryPickerContainer, false, 0, 2, null);
            View noCategoryPicker2 = j0(R.id.noCategoryPicker);
            Intrinsics.e(noCategoryPicker2, "noCategoryPicker");
            ViewExtKt.e(noCategoryPicker2, true, 0, 2, null);
        } else {
            this.f33977w = false;
            LinearLayout carCategoryPickerContainer2 = (LinearLayout) j0(R.id.carCategoryPickerContainer);
            Intrinsics.e(carCategoryPickerContainer2, "carCategoryPickerContainer");
            ViewExtKt.e(carCategoryPickerContainer2, false, 0, 3, null);
            View noCategoryPicker3 = j0(R.id.noCategoryPicker);
            Intrinsics.e(noCategoryPicker3, "noCategoryPicker");
            ViewExtKt.e(noCategoryPicker3, false, 0, 2, null);
            TextView carCategorySelectionTitle2 = (TextView) j0(R.id.carCategorySelectionTitle);
            Intrinsics.e(carCategorySelectionTitle2, "carCategorySelectionTitle");
            ViewExtKt.e(carCategorySelectionTitle2, false, 0, 3, null);
            int i9 = R.id.carCategorySelectionSubTitle;
            TextView carCategorySelectionSubTitle2 = (TextView) j0(i9);
            Intrinsics.e(carCategorySelectionSubTitle2, "carCategorySelectionSubTitle");
            ViewExtKt.e(carCategorySelectionSubTitle2, false, 0, 3, null);
            TextView categoriesError2 = (TextView) j0(R.id.categoriesError);
            Intrinsics.e(categoriesError2, "categoriesError");
            ViewExtKt.e(categoriesError2, false, 0, 2, null);
            this.f33976v.W(dispatchSettingsState.b(), dispatchSettingsState.c());
            ((TextView) j0(i9)).setText(getString(R.string.categories_available));
            int i10 = R.id.categories;
            RecyclerView categories2 = (RecyclerView) j0(i10);
            Intrinsics.e(categories2, "categories");
            ViewExtKt.e(categories2, false, 0, 3, null);
            ((RoundButton) j0(i8)).setText(getString(R.string.categories_confirm_lowercase));
            View autoAcceptanceScrollableShadowIndicator2 = j0(R.id.autoAcceptanceScrollableShadowIndicator);
            Intrinsics.e(autoAcceptanceScrollableShadowIndicator2, "autoAcceptanceScrollableShadowIndicator");
            ViewExtKt.e(autoAcceptanceScrollableShadowIndicator2, true, 0, 2, null);
            ((RecyclerView) j0(i10)).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$updateCategories$1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ((RecyclerView) DispatchSettingsDialog.this.j0(R.id.categories)).getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (!dispatchSettingsState.e() && dispatchSettingsState.b().get(0).c() != null) {
                        DispatchSettingsDialog.this.D0();
                        DispatchSettingsDialog.this.P().m0();
                    }
                }
            });
        }
    }

    private final void J0(final DispatchSettingsState dispatchSettingsState) {
        if (dispatchSettingsState.d() == null) {
            View heatmapIndicator = j0(R.id.heatmapIndicator);
            Intrinsics.e(heatmapIndicator, "heatmapIndicator");
            ViewExtKt.e(heatmapIndicator, false, 0, 2, null);
            ConstraintLayout heatmapSwitchLayout = (ConstraintLayout) j0(R.id.heatmapSwitchLayout);
            Intrinsics.e(heatmapSwitchLayout, "heatmapSwitchLayout");
            ViewExtKt.e(heatmapSwitchLayout, false, 0, 2, null);
            ConstraintLayout heatmapChipsLayout = (ConstraintLayout) j0(R.id.heatmapChipsLayout);
            Intrinsics.e(heatmapChipsLayout, "heatmapChipsLayout");
            ViewExtKt.e(heatmapChipsLayout, false, 0, 2, null);
            return;
        }
        View heatmapIndicator2 = j0(R.id.heatmapIndicator);
        Intrinsics.e(heatmapIndicator2, "heatmapIndicator");
        boolean z7 = true;
        ViewExtKt.e(heatmapIndicator2, true, 0, 2, null);
        ConstraintLayout heatmapSwitchLayout2 = (ConstraintLayout) j0(R.id.heatmapSwitchLayout);
        Intrinsics.e(heatmapSwitchLayout2, "heatmapSwitchLayout");
        ViewExtKt.e(heatmapSwitchLayout2, true, 0, 2, null);
        ((ImageView) j0(R.id.heatmapSwitchAbout)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DispatchSettingsDialog.K0(DispatchSettingsDialog.this, dispatchSettingsState, view);
            }
        });
        int i8 = R.id.heatmapSwitch;
        ((SwitchCompat) j0(i8)).setChecked(dispatchSettingsState.d().a());
        ((SwitchCompat) j0(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DispatchSettingsDialog.L0(DispatchSettingsDialog.this, dispatchSettingsState, view);
            }
        });
        ConstraintLayout heatmapChipsLayout2 = (ConstraintLayout) j0(R.id.heatmapChipsLayout);
        Intrinsics.e(heatmapChipsLayout2, "heatmapChipsLayout");
        ViewExtKt.e(heatmapChipsLayout2, (dispatchSettingsState.d().a() && (dispatchSettingsState.d().b().isEmpty() ^ true)) ? false : false, 0, 2, null);
        DynamicViewHelper<ChipViewHolder> dynamicViewHelper = this.f33979y;
        if (dynamicViewHelper != null) {
            dynamicViewHelper.a(dispatchSettingsState.d().b().size(), new DispatchSettingsDialog$updateHeatmap$3(dispatchSettingsState, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(DispatchSettingsDialog this$0, DispatchSettingsState state, View view) {
        String string;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(state, "$state");
        InfoDialog.Companion companion = InfoDialog.f41099m;
        String string2 = this$0.getString(R.string.heatmap);
        Intrinsics.e(string2, "getString(R.string.heatmap)");
        if (state.d().a()) {
            string = this$0.getString(R.string.setting_on);
        } else {
            string = this$0.getString(R.string.setting_off);
        }
        String string3 = this$0.getString(R.string.heatmap_info_message);
        String string4 = this$0.getString(R.string.close);
        Intrinsics.e(string4, "getString(R.string.close)");
        InfoDialog a8 = companion.a(string2, string, string3, string4, new DefaultDialogCallback());
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(a8, requireActivity, "tag_heatmap");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(DispatchSettingsDialog this$0, DispatchSettingsState state, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(state, "$state");
        this$0.P().g0(!state.d().a());
    }

    private final void M0(DispatchSettingsState dispatchSettingsState) {
        I0(dispatchSettingsState);
        J0(dispatchSettingsState);
        H0(dispatchSettingsState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        SurgeToolTipDelegate surgeToolTipDelegate = this.f33972r;
        if (surgeToolTipDelegate != null) {
            surgeToolTipDelegate.d();
        }
    }

    private final String r0() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getString("argument_car_name");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ErrorViewController s0() {
        return (ErrorViewController) this.f33978x.getValue();
    }

    public static final DispatchSettingsDialog u0(String str) {
        return D.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog;
        FrameLayout frameLayout;
        if (dialogInterface instanceof BottomSheetDialog) {
            bottomSheetDialog = (BottomSheetDialog) dialogInterface;
        } else {
            bottomSheetDialog = null;
        }
        if (bottomSheetDialog == null || (frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet)) == null) {
            return;
        }
        BottomSheetBehavior k02 = BottomSheetBehavior.k0(frameLayout);
        k02.Q0(3);
        k02.P0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(DispatchSettingsDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(DispatchSettingsDialog this$0, View view) {
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        if (this$0.f33977w) {
            this$0.dismissAllowingStateLoss();
            return;
        }
        DispatchSettingsState f8 = this$0.P().W().f();
        if (f8 != null && !f8.c()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this$0.G0();
            return;
        }
        this$0.f33976v.V();
        int i8 = R.id.categoriesError;
        ((TextView) this$0.j0(i8)).setText(R.string.categories_empty_selection);
        ((TextView) this$0.j0(i8)).setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(DispatchSettingsDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        InfoDialog.Companion companion = ee.mtakso.driver.ui.screens.dialogs.InfoDialog.f28307n;
        String string = this$0.getString(R.string.auto_accept);
        String string2 = this$0.getString(R.string.auto_accept_description);
        String string3 = this$0.getString(R.string.close);
        Intrinsics.e(string3, "getString(R.string.close)");
        ee.mtakso.driver.ui.screens.dialogs.InfoDialog b8 = InfoDialog.Companion.b(companion, string, string2, string3, null, null, 16, null);
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(b8, requireActivity, "dialog_auto_acceptance");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(DispatchSettingsDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        DispatchSettingsViewModel P = this$0.P();
        Intrinsics.d(view, "null cannot be cast to non-null type android.widget.CompoundButton");
        P.Z(((CompoundButton) view).isChecked());
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.C.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    protected boolean I() {
        return this.A;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f33980z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void R() {
        IndeterminateProgressView progressView = (IndeterminateProgressView) j0(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
        LinearLayout carCategoryPickerContainer = (LinearLayout) j0(R.id.carCategoryPickerContainer);
        Intrinsics.e(carCategoryPickerContainer, "carCategoryPickerContainer");
        ViewExtKt.e(carCategoryPickerContainer, !this.f33977w, 0, 2, null);
        View noCategoryPicker = j0(R.id.noCategoryPicker);
        Intrinsics.e(noCategoryPicker, "noCategoryPicker");
        ViewExtKt.e(noCategoryPicker, this.f33977w, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().x(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void W(Throwable error) {
        Intrinsics.f(error, "error");
        IndeterminateProgressView progressView = (IndeterminateProgressView) j0(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
        LinearLayout carCategoryPickerContainer = (LinearLayout) j0(R.id.carCategoryPickerContainer);
        Intrinsics.e(carCategoryPickerContainer, "carCategoryPickerContainer");
        ViewExtKt.e(carCategoryPickerContainer, false, 0, 2, null);
        ErrorViewController s02 = s0();
        String string = getString(R.string.something_went_wrong);
        Intrinsics.e(string, "getString(R.string.something_went_wrong)");
        String string2 = getString(R.string.try_again_later);
        Intrinsics.e(string2, "getString(R.string.try_again_later)");
        String string3 = getString(R.string.try_again);
        Intrinsics.e(string3, "getString(R.string.try_again)");
        s02.e(R.drawable.legacy_ic_chat_connection_error, string, string2, string3, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$showError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                ErrorViewController s03;
                LinearLayout carCategoryPickerContainer2 = (LinearLayout) DispatchSettingsDialog.this.j0(R.id.carCategoryPickerContainer);
                Intrinsics.e(carCategoryPickerContainer2, "carCategoryPickerContainer");
                ViewExtKt.e(carCategoryPickerContainer2, true, 0, 2, null);
                s03 = DispatchSettingsDialog.this.s0();
                ViewExtKt.e(s03.d(), false, 0, 2, null);
                DispatchSettingsDialog.this.G0();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$showError$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                DispatchSettingsDialog.this.dismissAllowingStateLoss();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void X() {
        IndeterminateProgressView progressView = (IndeterminateProgressView) j0(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, true, 0, 2, null);
        LinearLayout carCategoryPickerContainer = (LinearLayout) j0(R.id.carCategoryPickerContainer);
        Intrinsics.e(carCategoryPickerContainer, "carCategoryPickerContainer");
        ViewExtKt.e(carCategoryPickerContainer, false, 0, 2, null);
    }

    public View j0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.C;
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        setStyle(0, 2132017805);
        super.onCreate(bundle);
        BaseDialogFragment.f41026i.a(getParentFragmentManager(), "tag_heatmap", new DefaultDialogCallback());
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.k
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DispatchSettingsDialog.v0(dialogInterface);
            }
        });
        return onCreateDialog;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f33979y = null;
        H();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Disposable disposable = this.f33973s;
        if (disposable != null) {
            disposable.dispose();
        }
        q0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        List q8;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        String r02 = r0();
        if (r02 == null) {
            Kalev.d("Car name cannot be empty for car category picker!");
            Toast.makeText(requireContext(), (int) R.string.something_went_wrong, 0).show();
            dismissAllowingStateLoss();
            return;
        }
        ((TextView) j0(R.id.carCategorySelectionTitle)).setText(getString(R.string.categories_title, r02));
        ((TextView) j0(R.id.textAutoAcceptanceNoCategory)).setText(getString(R.string.auto_accept_description));
        int i8 = R.id.categories;
        ((RecyclerView) j0(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) j0(i8)).setAdapter(this.f33976v);
        NavigatorChooserItemDivider navigatorChooserItemDivider = new NavigatorChooserItemDivider();
        Color.Attr attr = new Color.Attr(R.attr.dynamicNeutral01);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        navigatorChooserItemDivider.l(ColorKt.a(attr, requireContext));
        navigatorChooserItemDivider.m(Dimens.c(24.0f));
        ((RecyclerView) j0(i8)).h(navigatorChooserItemDivider);
        ((RecyclerView) j0(i8)).setItemAnimator(null);
        View heatmapIndicator = j0(R.id.heatmapIndicator);
        Intrinsics.e(heatmapIndicator, "heatmapIndicator");
        ViewExtKt.e(heatmapIndicator, false, 0, 2, null);
        ConstraintLayout heatmapSwitchLayout = (ConstraintLayout) j0(R.id.heatmapSwitchLayout);
        Intrinsics.e(heatmapSwitchLayout, "heatmapSwitchLayout");
        ViewExtKt.e(heatmapSwitchLayout, false, 0, 2, null);
        int i9 = R.id.heatmapChipsLayout;
        ConstraintLayout heatmapChipsLayout = (ConstraintLayout) j0(i9);
        Intrinsics.e(heatmapChipsLayout, "heatmapChipsLayout");
        ViewExtKt.e(heatmapChipsLayout, false, 0, 2, null);
        ConstraintLayout heatmapChipsLayout2 = (ConstraintLayout) j0(i9);
        Intrinsics.e(heatmapChipsLayout2, "heatmapChipsLayout");
        View heatmapChip1 = j0(R.id.heatmapChip1);
        Intrinsics.e(heatmapChip1, "heatmapChip1");
        View heatmapChip2 = j0(R.id.heatmapChip2);
        Intrinsics.e(heatmapChip2, "heatmapChip2");
        View heatmapChip3 = j0(R.id.heatmapChip3);
        Intrinsics.e(heatmapChip3, "heatmapChip3");
        q8 = CollectionsKt__CollectionsKt.q(new ChipViewHolder(heatmapChip1), new ChipViewHolder(heatmapChip2), new ChipViewHolder(heatmapChip3));
        this.f33979y = new DynamicViewHelper<>(heatmapChipsLayout2, q8, (Flow) j0(R.id.heatmapChipsFlow), new Function2<LayoutInflater, ViewGroup, ChipViewHolder>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$onViewCreated$2
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final DispatchSettingsDialog.ChipViewHolder s(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.f(inflater, "inflater");
                Intrinsics.f(parent, "parent");
                View inflate = inflater.inflate(R.layout.content_category_heatmap_item, parent, false);
                Intrinsics.e(inflate, "inflater.inflate(R.layou…tmap_item, parent, false)");
                return new DispatchSettingsDialog.ChipViewHolder(inflate);
            }
        });
        int i10 = R.id.confirmBtn;
        ((RoundButton) j0(i10)).setEnabled(!this.f33976v.R().isEmpty());
        ((RoundButton) j0(i10)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DispatchSettingsDialog.x0(DispatchSettingsDialog.this, view2);
            }
        });
        ((AppCompatImageView) j0(R.id.aboutAutoAcceptance)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DispatchSettingsDialog.y0(DispatchSettingsDialog.this, view2);
            }
        });
        ((SwitchCompat) j0(R.id.switchEnabledAutoAcceptance)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DispatchSettingsDialog.z0(DispatchSettingsDialog.this, view2);
            }
        });
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        if (!ContextUtils.b(requireActivity)) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog$onViewCreated$6
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewGroup.MarginLayoutParams marginLayoutParams;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams = null;
                    }
                    if (marginLayoutParams != null) {
                        View view2 = view;
                        marginLayoutParams.topMargin = Dimens.d(64);
                        view2.setLayoutParams(marginLayoutParams);
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
        P().W().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DispatchSettingsDialog.A0(DispatchSettingsDialog.this, (DispatchSettingsState) obj);
            }
        });
        P().Y().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DispatchSettingsDialog.B0(DispatchSettingsDialog.this, (String) obj);
            }
        });
        P().X().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DispatchSettingsDialog.C0(DispatchSettingsDialog.this, (Boolean) obj);
            }
        });
        ((ImageView) j0(R.id.noCategoryCancelAction)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DispatchSettingsDialog.w0(DispatchSettingsDialog.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    /* renamed from: t0 */
    public DispatchSettingsViewModel P() {
        return (DispatchSettingsViewModel) this.B.getValue();
    }
}
