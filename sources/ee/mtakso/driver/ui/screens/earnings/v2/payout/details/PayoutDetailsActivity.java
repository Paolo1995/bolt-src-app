package ee.mtakso.driver.ui.screens.earnings.v2.payout.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.earnings.PayoutHistoryItem;
import ee.mtakso.driver.network.client.earnings.PayoutResponce;
import ee.mtakso.driver.network.client.earnings.PayoutState;
import ee.mtakso.driver.ui.base.mvvm.BaseDynamicTranslatedMvvmActivity;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsViewModel;
import ee.mtakso.driver.ui.views.TabFragmentAdapter;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.utils.StringUtilsKt;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.ui.routing.command.impl.ActivityClassCommand;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: PayoutDetailsActivity.kt */
/* loaded from: classes3.dex */
public final class PayoutDetailsActivity extends BaseDynamicTranslatedMvvmActivity<PayoutDetailsViewModel> {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f28656r = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private MenuItem f28657o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f28658p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f28659q = new LinkedHashMap();

    /* compiled from: PayoutDetailsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Bundle b(long j8) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("CONFIG", new PayoutDetailsViewModel.Config(j8, null, null, null, null, 30, null));
            return bundle;
        }

        public final ActivityClassCommand a(long j8) {
            return new ActivityClassCommand(PayoutDetailsActivity.class, b(j8), 0, null, 12, null);
        }

        public final Intent c(Context context, PayoutHistoryItem payout) {
            Intrinsics.f(context, "context");
            Intrinsics.f(payout, "payout");
            Intent putExtra = new Intent(context, PayoutDetailsActivity.class).putExtra("CONFIG", new PayoutDetailsViewModel.Config(payout.c(), payout.d(), payout.b(), payout.a(), payout.e()));
            Intrinsics.e(putExtra, "Intent(context, PayoutDe…      )\n                )");
            return putExtra;
        }
    }

    /* compiled from: PayoutDetailsActivity.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28660a;

        static {
            int[] iArr = new int[PayoutState.values().length];
            try {
                iArr[PayoutState.REJECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PayoutState.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PayoutState.COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f28660a = iArr;
        }
    }

    public PayoutDetailsActivity() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<PayoutDetailsViewModel>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final PayoutDetailsViewModel invoke() {
                PayoutDetailsActivity payoutDetailsActivity = PayoutDetailsActivity.this;
                return (PayoutDetailsViewModel) new ViewModelProvider(payoutDetailsActivity, payoutDetailsActivity.R()).a(PayoutDetailsViewModel.class);
            }
        });
        this.f28658p = b8;
    }

    private final void d0(PayoutDetailsViewModel.Config config) {
        boolean z7;
        boolean z8;
        int i8;
        int i9;
        int i10;
        int i11 = R.id.ib;
        ImageView statusIcon = (ImageView) b0(i11);
        Intrinsics.e(statusIcon, "statusIcon");
        if (config.c() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(statusIcon, z7, 0, 2, null);
        int i12 = R.id.lb;
        AppCompatTextView statusText = (AppCompatTextView) b0(i12);
        Intrinsics.e(statusText, "statusText");
        if (config.c() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.e(statusText, z8, 0, 2, null);
        if (config.c() != null) {
            ImageView imageView = (ImageView) b0(i11);
            PayoutState c8 = config.c();
            int i13 = -1;
            if (c8 == null) {
                i8 = -1;
            } else {
                i8 = WhenMappings.f28660a[c8.ordinal()];
            }
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        i9 = R.drawable.ic_payout_accepted;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    i9 = R.drawable.ic_progress_big;
                }
            } else {
                i9 = R.drawable.ic_payout_rejected;
            }
            imageView.setImageResource(i9);
            AppCompatTextView appCompatTextView = (AppCompatTextView) b0(i12);
            PayoutState c9 = config.c();
            if (c9 != null) {
                i13 = WhenMappings.f28660a[c9.ordinal()];
            }
            if (i13 != 1) {
                if (i13 != 2) {
                    if (i13 == 3) {
                        i10 = R.string.payout_status_accepted;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    i10 = R.string.payout_status_reserved;
                }
            } else {
                i10 = R.string.payout_status_rejected;
            }
            appCompatTextView.setText(getString(i10));
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) b0(R.id.L);
        String a8 = config.a();
        if (a8 == null) {
            a8 = "";
        }
        appCompatTextView2.setText(a8);
        ((AppCompatTextView) b0(R.id.amountCommentText)).setText("");
    }

    private final void e0(PayoutResponce payoutResponce) {
        i0(payoutResponce);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(PayoutDetailsActivity this$0, PayoutDetailsViewModel.ScreenState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.c0(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(PayoutDetailsActivity this$0, Object obj) {
        Intrinsics.f(this$0, "this$0");
        this$0.finish();
    }

    private final void i0(PayoutResponce payoutResponce) {
        int i8;
        int i9;
        int color;
        int i10 = R.id.ib;
        ImageView statusIcon = (ImageView) b0(i10);
        Intrinsics.e(statusIcon, "statusIcon");
        boolean z7 = false;
        ViewExtKt.e(statusIcon, false, 0, 3, null);
        int i11 = R.id.lb;
        AppCompatTextView statusText = (AppCompatTextView) b0(i11);
        Intrinsics.e(statusText, "statusText");
        ViewExtKt.e(statusText, false, 0, 3, null);
        MenuItem menuItem = this.f28657o;
        if (menuItem != null) {
            if (payoutResponce.f() != null) {
                z7 = true;
            }
            menuItem.setVisible(z7);
        }
        ImageView imageView = (ImageView) b0(i10);
        PayoutState h8 = payoutResponce.h();
        int[] iArr = WhenMappings.f28660a;
        int i12 = iArr[h8.ordinal()];
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 == 3) {
                    i8 = R.drawable.ic_payout_accepted;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                i8 = R.drawable.ic_progress_big;
            }
        } else {
            i8 = R.drawable.ic_payout_rejected;
        }
        imageView.setImageResource(i8);
        AppCompatTextView appCompatTextView = (AppCompatTextView) b0(i11);
        int i13 = iArr[payoutResponce.h().ordinal()];
        if (i13 != 1) {
            if (i13 != 2) {
                if (i13 == 3) {
                    i9 = R.string.payout_status_accepted;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                i9 = R.string.payout_status_reserved;
            }
        } else {
            i9 = R.string.payout_status_rejected;
        }
        appCompatTextView.setText(getString(i9));
        int i14 = R.id.L;
        ((AppCompatTextView) b0(i14)).setText(payoutResponce.a());
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) b0(i14);
        if (iArr[payoutResponce.h().ordinal()] == 1) {
            color = ContextCompat.getColor(this, R.color.red500);
        } else {
            color = ContextCompat.getColor(this, R.color.white);
        }
        appCompatTextView2.setTextColor(color);
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) b0(R.id.amountCommentText);
        String b8 = payoutResponce.b();
        appCompatTextView3.setText((b8 == null || (r8 = StringUtilsKt.a(b8)) == null) ? "" : "");
    }

    private final void j0() {
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.e(supportFragmentManager, "supportFragmentManager");
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(supportFragmentManager);
        Fragment c8 = FragmentFactoryUtils.c(N(), this, PayoutDetailsProgressPageFragment.class, null, 4, null);
        String string = getString(R.string.payout_page_progress);
        Intrinsics.e(string, "getString(R.string.payout_page_progress)");
        tabFragmentAdapter.a(c8, string);
        Fragment c9 = FragmentFactoryUtils.c(N(), this, PayoutDetailsInfoPageFragment.class, null, 4, null);
        String string2 = getString(R.string.payout_page_details);
        Intrinsics.e(string2, "getString(R.string.payout_page_details)");
        tabFragmentAdapter.a(c9, string2);
        int i8 = R.id.Mc;
        ((ViewPager) b0(i8)).setAdapter(tabFragmentAdapter);
        int i9 = R.id.Eb;
        ((TabLayout) b0(i9)).setupWithViewPager((ViewPager) b0(i8));
        TabLayout tab = (TabLayout) b0(i9);
        Intrinsics.e(tab, "tab");
        ViewExtKt.c(tab, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsActivity$setupViewPager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                Ref$IntRef ref$IntRef2 = Ref$IntRef.this;
                PayoutDetailsActivity payoutDetailsActivity = this;
                int i10 = R.id.Eb;
                ref$IntRef2.f51014f = ((TabLayout) payoutDetailsActivity.b0(i10)).getWidth() / ((TabLayout) this.b0(i10)).getTabCount();
                PayoutDetailsActivity payoutDetailsActivity2 = this;
                int i11 = R.id.V5;
                ViewGroup.LayoutParams layoutParams = payoutDetailsActivity2.b0(i11).getLayoutParams();
                Intrinsics.d(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = Ref$IntRef.this.f51014f;
                this.b0(i11).setLayoutParams(layoutParams2);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        ((ViewPager) b0(i8)).c(new ViewPager.OnPageChangeListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsActivity$setupViewPager$2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void a(int i10, float f8, int i11) {
                PayoutDetailsActivity payoutDetailsActivity = PayoutDetailsActivity.this;
                int i12 = R.id.V5;
                ViewGroup.LayoutParams layoutParams = payoutDetailsActivity.b0(i12).getLayoutParams();
                Intrinsics.d(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = (int) ((f8 + i10) * ref$IntRef.f51014f);
                PayoutDetailsActivity.this.b0(i12).setLayoutParams(marginLayoutParams);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void c(int i10) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void d(int i10) {
            }
        });
    }

    private final void k0() {
        Q().J();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void S() {
        FrameLayout progressLayout = (FrameLayout) b0(R.id.progressLayout);
        Intrinsics.e(progressLayout, "progressLayout");
        ViewExtKt.e(progressLayout, false, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void T() {
        Injector.f20166d.b().Y1().D(this);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void X(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = getString(R.string.error);
        String k8 = ApiExceptionUtils.k(error, this);
        String string2 = getString(R.string.ok_lowercase);
        Intrinsics.e(string2, "getString(R.string.ok_lowercase)");
        FragmentUtils.c(NotificationDialog.Companion.d(companion, string, k8, string2, error, null, 16, null), this, "TAG_ERROR_DIALOG");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void Y() {
        FrameLayout progressLayout = (FrameLayout) b0(R.id.progressLayout);
        Intrinsics.e(progressLayout, "progressLayout");
        ViewExtKt.e(progressLayout, false, 0, 3, null);
    }

    public View b0(int i8) {
        Map<Integer, View> map = this.f28659q;
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

    public final void c0(PayoutDetailsViewModel.ScreenState state) {
        Unit unit;
        Intrinsics.f(state, "state");
        PayoutResponce d8 = state.d();
        if (d8 != null) {
            e0(d8);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            d0(state.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    /* renamed from: f0 */
    public PayoutDetailsViewModel Q() {
        return (PayoutDetailsViewModel) this.f28658p.getValue();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        PayoutDetailsViewModel.Config config;
        super.onCreate(bundle);
        setContentView(R.layout.fragment_payout_details);
        setSupportActionBar((PopupToolbar) b0(R.id.kc));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.s(true);
        }
        setTitle("");
        j0();
        Parcelable parcelableExtra = getIntent().getParcelableExtra("CONFIG");
        if (parcelableExtra instanceof PayoutDetailsViewModel.Config) {
            config = (PayoutDetailsViewModel.Config) parcelableExtra;
        } else {
            config = null;
        }
        if (config == null) {
            finish();
            return;
        }
        Q().P(config);
        Q().I().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PayoutDetailsActivity.g0(PayoutDetailsActivity.this, (PayoutDetailsViewModel.ScreenState) obj);
            }
        });
        Q().H().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PayoutDetailsActivity.h0(PayoutDetailsActivity.this, obj);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem;
        getMenuInflater().inflate(R.menu.payout_history_view_menu, menu);
        if (menu != null) {
            menuItem = menu.findItem(R.id.actionHelp);
        } else {
            menuItem = null;
        }
        this.f28657o = menuItem;
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.f(item, "item");
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.actionHelp) {
                return false;
            }
            k0();
            return true;
        }
        finish();
        return true;
    }
}
