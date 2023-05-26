package ee.mtakso.driver.ui.screens.car_chooser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.driver.Car;
import ee.mtakso.driver.ui.base.mvvm.BaseDynamicTranslatedMvvmActivity;
import ee.mtakso.driver.ui.theme.ThemeActivityExtKt;
import ee.mtakso.driver.ui.utils.ClipboardUtil;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import eu.bolt.driver.core.theme.AppThemeManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CarChooserActivity.kt */
/* loaded from: classes3.dex */
public final class CarChooserActivity extends BaseDynamicTranslatedMvvmActivity<CarChooserViewModel> {

    /* renamed from: u  reason: collision with root package name */
    public static final Companion f27656u = new Companion(null);
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public CompositeUrlLauncher f27657o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public AppThemeManager f27658p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f27659q;

    /* renamed from: r  reason: collision with root package name */
    private final DiffAdapter f27660r;

    /* renamed from: s  reason: collision with root package name */
    private ClipboardUtil f27661s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f27662t = new LinkedHashMap();

    /* compiled from: CarChooserActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.f(context, "context");
            Intent intent = new Intent(context, CarChooserActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public CarChooserActivity() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<CarChooserViewModel>() { // from class: ee.mtakso.driver.ui.screens.car_chooser.CarChooserActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final CarChooserViewModel invoke() {
                CarChooserActivity carChooserActivity = CarChooserActivity.this;
                return (CarChooserViewModel) new ViewModelProvider(carChooserActivity, carChooserActivity.R()).a(CarChooserViewModel.class);
            }
        });
        this.f27659q = b8;
        this.f27660r = new DiffAdapter().P(new CarChooserDelegate(new CarChooserActivity$diffAdapter$1(this), new CarChooserActivity$diffAdapter$2(this)));
    }

    @SuppressLint({"WrongConstant"})
    private final void i0(int i8) {
        Snackbar.u0((CoordinatorLayout) f0(R.id.rootView), i8, 0).e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(Car car) {
        Q().a0(car);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(CarChooserActivity this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q().W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(CarChooserActivity this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q().W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(CarChooserActivity this$0, Boolean bool) {
        Intrinsics.f(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(CarChooserActivity this$0, Boolean bool) {
        Intrinsics.f(this$0, "this$0");
        this$0.i0(R.string.car_change_error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(CarChooserActivity this$0, List items) {
        Intrinsics.f(this$0, "this$0");
        if (items.isEmpty()) {
            RecyclerView recyclerView = (RecyclerView) this$0.f0(R.id.H9);
            Intrinsics.e(recyclerView, "recyclerView");
            ViewExtKt.e(recyclerView, false, 0, 2, null);
            ConstraintLayout emptyView = (ConstraintLayout) this$0.f0(R.id.emptyView);
            Intrinsics.e(emptyView, "emptyView");
            ViewExtKt.e(emptyView, true, 0, 2, null);
            ((ExtendedFloatingActionButton) this$0.f0(R.id.fabAddCar)).y();
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) this$0.f0(R.id.H9);
        Intrinsics.e(recyclerView2, "recyclerView");
        ViewExtKt.e(recyclerView2, false, 0, 3, null);
        ((ExtendedFloatingActionButton) this$0.f0(R.id.fabAddCar)).E();
        DiffAdapter diffAdapter = this$0.f27660r;
        Intrinsics.e(items, "items");
        DiffAdapter.V(diffAdapter, items, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(CarChooserActivity this$0, String it) {
        Intrinsics.f(this$0, "this$0");
        CompositeUrlLauncher k02 = this$0.k0();
        Intrinsics.e(it, "it");
        k02.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(String str) {
        ClipboardUtil clipboardUtil = this.f27661s;
        if (clipboardUtil == null) {
            Intrinsics.w("clipboardUtil");
            clipboardUtil = null;
        }
        clipboardUtil.a(str);
        i0(R.string.car_insurance_key_message);
    }

    public static final void u0(Context context) {
        f27656u.a(context);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void T() {
        Injector.f20166d.b().Y1().A(this);
    }

    public View f0(int i8) {
        Map<Integer, View> map = this.f27662t;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View findViewById = findViewById(i8);
            if (findViewById != null) {
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    public final AppThemeManager j0() {
        AppThemeManager appThemeManager = this.f27658p;
        if (appThemeManager != null) {
            return appThemeManager;
        }
        Intrinsics.w("appThemeManager");
        return null;
    }

    public final CompositeUrlLauncher k0() {
        CompositeUrlLauncher compositeUrlLauncher = this.f27657o;
        if (compositeUrlLauncher != null) {
            return compositeUrlLauncher;
        }
        Intrinsics.w("urlLauncher");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    /* renamed from: l0 */
    public CarChooserViewModel Q() {
        return (CarChooserViewModel) this.f27659q.getValue();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ThemeActivityExtKt.a(this, j0().c());
        setContentView(R.layout.activity_car_chooser);
        setSupportActionBar((Toolbar) f0(R.id.kc));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.w(getString(R.string.active_car));
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.s(true);
        }
        this.f27661s = ClipboardUtil.f34300b.a(this);
        ((ExtendedFloatingActionButton) f0(R.id.fabAddCar)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.car_chooser.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarChooserActivity.n0(CarChooserActivity.this, view);
            }
        });
        ((RoundButton) f0(R.id.btnAddCar)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.car_chooser.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarChooserActivity.o0(CarChooserActivity.this, view);
            }
        });
        int i8 = R.id.H9;
        RecyclerView recyclerView = (RecyclerView) f0(i8);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f27660r);
        recyclerView.h(new ListItemDepthDecoration(Dimens.d(24)));
        recyclerView.h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ((RecyclerView) f0(i8)).l(new RecyclerView.OnScrollListener() { // from class: ee.mtakso.driver.ui.screens.car_chooser.CarChooserActivity$onCreate$4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView2, int i9, int i10) {
                LinearLayoutManager linearLayoutManager;
                Intrinsics.f(recyclerView2, "recyclerView");
                super.b(recyclerView2, i9, i10);
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    linearLayoutManager = (LinearLayoutManager) layoutManager;
                } else {
                    linearLayoutManager = null;
                }
                if (linearLayoutManager == null) {
                    return;
                }
                if (linearLayoutManager.g2() == 0) {
                    ((ExtendedFloatingActionButton) CarChooserActivity.this.f0(R.id.fabAddCar)).w();
                } else {
                    ((ExtendedFloatingActionButton) CarChooserActivity.this.f0(R.id.fabAddCar)).F();
                }
            }
        });
        Q().R().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.car_chooser.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarChooserActivity.p0(CarChooserActivity.this, (Boolean) obj);
            }
        });
        Q().S().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.car_chooser.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarChooserActivity.q0(CarChooserActivity.this, (Boolean) obj);
            }
        });
        Q().P().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.car_chooser.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarChooserActivity.r0(CarChooserActivity.this, (List) obj);
            }
        });
        Q().Q().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.car_chooser.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CarChooserActivity.s0(CarChooserActivity.this, (String) obj);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.f(item, "item");
        if (item.getItemId() == 16908332) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
