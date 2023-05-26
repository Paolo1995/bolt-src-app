package ee.mtakso.driver.ui.screens;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.ui.base.mvvm.BazeFragment;
import ee.mtakso.driver.ui.theme.ThemeActivityExtKt;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.translation.TranslatedContext;
import eu.bolt.driver.core.ui.translation.TranslatedResources;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnonymousSimpleActivity.kt */
/* loaded from: classes3.dex */
public final class AnonymousSimpleActivity extends AppCompatActivity implements Navigator {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f26995k = new Companion(null);
    @Inject

    /* renamed from: f  reason: collision with root package name */
    public FragmentFactory f26996f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    public AppThemeManager f26997g;

    /* renamed from: h  reason: collision with root package name */
    private Navigator f26998h;

    /* renamed from: i  reason: collision with root package name */
    private Resources f26999i;

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, View> f27000j = new LinkedHashMap();

    /* compiled from: AnonymousSimpleActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent c(Companion companion, Context context, Class cls, Bundle bundle, boolean z7, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                bundle = null;
            }
            if ((i8 & 8) != 0) {
                z7 = false;
            }
            return companion.b(context, cls, bundle, z7);
        }

        public final Bundle a(Class<? extends Fragment> content, Bundle bundle, boolean z7) {
            Intrinsics.f(content, "content");
            return BundleKt.a(TuplesKt.a("content", content), TuplesKt.a("args", bundle), TuplesKt.a("arg_show_toolbar", Boolean.valueOf(z7)));
        }

        public final Intent b(Context context, Class<? extends Fragment> content, Bundle bundle, boolean z7) {
            Intrinsics.f(context, "context");
            Intrinsics.f(content, "content");
            if (z7) {
                Kalev.l("Toolbar visibility should be controlled by toolbar appearance");
            }
            Intent intent = new Intent(context, AnonymousSimpleActivity.class);
            intent.putExtras(a(content, bundle, z7));
            return intent;
        }
    }

    private final void O(Fragment fragment, Bundle bundle, boolean z7) {
        fragment.setArguments(bundle);
        FragmentTransaction replace = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "content");
        Intrinsics.e(replace, "supportFragmentManager.b…ner, fragment, \"content\")");
        if (z7) {
            replace = replace.addToBackStack(null);
            Intrinsics.e(replace, "transaction.addToBackStack(null)");
        }
        replace.commit();
    }

    public View L(int i8) {
        Map<Integer, View> map = this.f27000j;
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

    public final AppThemeManager M() {
        AppThemeManager appThemeManager = this.f26997g;
        if (appThemeManager != null) {
            return appThemeManager;
        }
        Intrinsics.w("appThemeManager");
        return null;
    }

    public final FragmentFactory N() {
        FragmentFactory fragmentFactory = this.f26996f;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Intrinsics.w("fragmentFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        Intrinsics.f(newBase, "newBase");
        super.attachBaseContext(TranslatedContext.f41187b.a(Injector.f20166d.b().a().b(newBase)));
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public boolean c() {
        boolean z7;
        Navigator e8 = e();
        if (e8 != null) {
            z7 = e8.c();
        } else {
            z7 = false;
        }
        if (!z7) {
            super.onBackPressed();
            return true;
        }
        return true;
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void d(Class<? extends Fragment> content, Bundle bundle, boolean z7) {
        Intrinsics.f(content, "content");
        O(FragmentFactoryUtils.c(N(), this, content, null, 4, null), bundle, z7);
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public Navigator e() {
        return this.f26998h;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f26999i == null) {
            Resources resources = super.getResources();
            Intrinsics.e(resources, "super.getResources()");
            this.f26999i = new TranslatedResources(resources);
        }
        return this.f26999i;
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void n(ToolbarAppearance toolbarAppearance) {
        Intrinsics.f(toolbarAppearance, "toolbarAppearance");
        PopupToolbar toolbar = (PopupToolbar) L(R.id.kc);
        Intrinsics.e(toolbar, "toolbar");
        toolbarAppearance.a(toolbar, this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object obj;
        Class cls;
        Fragment fragment;
        boolean z7;
        Integer F;
        Injector.f20166d.b().X1().e(this);
        getSupportFragmentManager().setFragmentFactory(N());
        Bundle extras = getIntent().getExtras();
        Bundle bundle2 = null;
        if (extras != null) {
            obj = extras.get("content");
        } else {
            obj = null;
        }
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else {
            cls = null;
        }
        AssertUtils.c(cls, "Content class is null");
        if (cls != null) {
            fragment = FragmentFactoryUtils.c(N(), this, cls, null, 4, null);
        } else {
            fragment = null;
        }
        if (fragment instanceof BazeFragment) {
            BazeFragment bazeFragment = (BazeFragment) fragment;
            if (bazeFragment.F() != null && ((F = bazeFragment.F()) == null || F.intValue() != 0)) {
                ThemeActivityExtKt.a(this, M().c());
            }
        }
        super.onCreate(bundle);
        if (bundle != null && bundle.getInt("process_id") != Process.myPid()) {
            AppRoutingManager.f25869b.c(this);
            finish();
        }
        setContentView(R.layout.activity_simple);
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null && extras2.getBoolean("arg_show_toolbar")) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i8 = R.id.kc;
            ((PopupToolbar) L(i8)).setVisibility(0);
            setSupportActionBar((PopupToolbar) L(i8));
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.s(true);
            }
        } else {
            ((PopupToolbar) L(R.id.kc)).setVisibility(8);
        }
        if (bundle != null) {
            return;
        }
        if (fragment == null) {
            finish();
            return;
        }
        Bundle extras3 = getIntent().getExtras();
        if (extras3 != null) {
            bundle2 = extras3.getBundle("args");
        }
        O(fragment, bundle2, false);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.f(item, "item");
        if (item.getItemId() == 16908332) {
            c();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.f(outState, "outState");
        outState.putInt("process_id", Process.myPid());
        super.onSaveInstanceState(outState);
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void q(Navigator navigator) {
        this.f26998h = navigator;
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void x(eu.bolt.driver.core.ui.common.activity.ToolbarAppearance toolbarAppearance) {
        Intrinsics.f(toolbarAppearance, "toolbarAppearance");
        PopupToolbar toolbar = (PopupToolbar) L(R.id.kc);
        Intrinsics.e(toolbar, "toolbar");
        toolbarAppearance.a(toolbar, this);
    }
}
