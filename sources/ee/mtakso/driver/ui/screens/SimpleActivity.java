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
import ee.mtakso.driver.ui.views.drawer.DebugDrawerInitializer;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.impl.ActivityClassCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.driver.core.ui.translation.TranslatedContext;
import eu.bolt.driver.core.ui.translation.TranslatedResources;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleActivity.kt */
/* loaded from: classes3.dex */
public final class SimpleActivity extends AppCompatActivity implements Navigator {

    /* renamed from: l */
    public static final Companion f27004l = new Companion(null);

    /* renamed from: m */
    private static boolean f27005m;
    @Inject

    /* renamed from: f */
    public FragmentFactory f27006f;
    @Inject

    /* renamed from: g */
    public DebugDrawerInitializer f27007g;
    @Inject

    /* renamed from: h */
    public AppThemeManager f27008h;

    /* renamed from: i */
    private Navigator f27009i;

    /* renamed from: j */
    private Resources f27010j;

    /* renamed from: k */
    public Map<Integer, View> f27011k = new LinkedHashMap();

    /* compiled from: SimpleActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ActivityClassCommand b(Companion companion, Class cls, Bundle bundle, boolean z7, int i8, int i9, Object obj) {
            if ((i9 & 2) != 0) {
                bundle = null;
            }
            if ((i9 & 4) != 0) {
                z7 = false;
            }
            if ((i9 & 8) != 0) {
                i8 = 0;
            }
            return companion.a(cls, bundle, z7, i8);
        }

        public static /* synthetic */ Bundle d(Companion companion, Class cls, Bundle bundle, boolean z7, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                bundle = null;
            }
            if ((i8 & 4) != 0) {
                z7 = false;
            }
            return companion.c(cls, bundle, z7);
        }

        public static /* synthetic */ RoutingCommand.ActivityClass f(Companion companion, Class cls, Bundle bundle, boolean z7, int i8, int i9, Object obj) {
            if ((i9 & 2) != 0) {
                bundle = null;
            }
            if ((i9 & 4) != 0) {
                z7 = false;
            }
            if ((i9 & 8) != 0) {
                i8 = 0;
            }
            return companion.e(cls, bundle, z7, i8);
        }

        public static /* synthetic */ Intent h(Companion companion, Context context, Class cls, Bundle bundle, boolean z7, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                bundle = null;
            }
            if ((i8 & 8) != 0) {
                z7 = false;
            }
            return companion.g(context, cls, bundle, z7);
        }

        public static /* synthetic */ void m(Companion companion, Context context, Class cls, Bundle bundle, boolean z7, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                bundle = null;
            }
            if ((i8 & 8) != 0) {
                z7 = false;
            }
            companion.l(context, cls, bundle, z7);
        }

        public final ActivityClassCommand a(Class<? extends Fragment> fragmentClass, Bundle bundle, boolean z7, int i8) {
            Intrinsics.f(fragmentClass, "fragmentClass");
            return new ActivityClassCommand(SimpleActivity.class, c(fragmentClass, bundle, z7), i8, null, 8, null);
        }

        public final Bundle c(Class<? extends Fragment> content, Bundle bundle, boolean z7) {
            Intrinsics.f(content, "content");
            return BundleKt.a(TuplesKt.a("content", content), TuplesKt.a("args", bundle), TuplesKt.a("arg_show_toolbar", Boolean.valueOf(z7)));
        }

        public final RoutingCommand.ActivityClass e(Class<? extends Fragment> fragmentClass, Bundle bundle, boolean z7, int i8) {
            List e8;
            Intrinsics.f(fragmentClass, "fragmentClass");
            e8 = CollectionsKt__CollectionsJVMKt.e(fragmentClass);
            return new RoutingCommand.ActivityClass(new RoutingState(SimpleActivity.class, e8), SimpleActivity.class, c(fragmentClass, bundle, z7), i8);
        }

        public final Intent g(Context context, Class<? extends Fragment> content, Bundle bundle, boolean z7) {
            Intrinsics.f(context, "context");
            Intrinsics.f(content, "content");
            if (z7) {
                Kalev.l("Toolbar visibility should be controlled by toolbar appearance");
            }
            Intent intent = new Intent(context, SimpleActivity.class);
            intent.putExtras(c(content, bundle, z7));
            return intent;
        }

        public final boolean i() {
            return SimpleActivity.f27005m;
        }

        public final void j(Context context, Class<? extends Fragment> content) {
            Intrinsics.f(context, "context");
            Intrinsics.f(content, "content");
            m(this, context, content, null, false, 12, null);
        }

        public final void k(Context context, Class<? extends Fragment> content, Bundle bundle) {
            Intrinsics.f(context, "context");
            Intrinsics.f(content, "content");
            m(this, context, content, bundle, false, 8, null);
        }

        public final void l(Context context, Class<? extends Fragment> content, Bundle bundle, boolean z7) {
            Intrinsics.f(context, "context");
            Intrinsics.f(content, "content");
            context.startActivity(g(context, content, bundle, z7));
        }
    }

    private final void Q(Fragment fragment, Bundle bundle, boolean z7) {
        fragment.setArguments(bundle);
        FragmentTransaction replace = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "content");
        Intrinsics.e(replace, "supportFragmentManager.b…ner, fragment, \"content\")");
        if (z7) {
            replace = replace.addToBackStack(null);
            Intrinsics.e(replace, "transaction.addToBackStack(null)");
        }
        replace.commit();
    }

    public static final void R(Context context, Class<? extends Fragment> cls) {
        f27004l.j(context, cls);
    }

    public static final void S(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        f27004l.k(context, cls, bundle);
    }

    public static final void T(Context context, Class<? extends Fragment> cls, Bundle bundle, boolean z7) {
        f27004l.l(context, cls, bundle, z7);
    }

    public View L(int i8) {
        Map<Integer, View> map = this.f27011k;
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

    public final AppThemeManager N() {
        AppThemeManager appThemeManager = this.f27008h;
        if (appThemeManager != null) {
            return appThemeManager;
        }
        Intrinsics.w("appThemeManager");
        return null;
    }

    public final DebugDrawerInitializer O() {
        DebugDrawerInitializer debugDrawerInitializer = this.f27007g;
        if (debugDrawerInitializer != null) {
            return debugDrawerInitializer;
        }
        Intrinsics.w("debugDrawerInitializer");
        return null;
    }

    public final FragmentFactory P() {
        FragmentFactory fragmentFactory = this.f27006f;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Intrinsics.w("fragmentFactory");
        return null;
    }

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
        Q(FragmentFactoryUtils.c(P(), this, content, null, 4, null), bundle, z7);
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public Navigator e() {
        return this.f27009i;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f27010j == null) {
            Resources resources = super.getResources();
            Intrinsics.e(resources, "super.getResources()");
            this.f27010j = new TranslatedResources(resources);
        }
        return this.f27010j;
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object obj;
        Class cls;
        Fragment fragment;
        boolean z7;
        Integer F;
        Injector.f20166d.b().Y1().o(this);
        getSupportFragmentManager().setFragmentFactory(P());
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
            fragment = FragmentFactoryUtils.c(P(), this, cls, null, 4, null);
        } else {
            fragment = null;
        }
        if (fragment instanceof BazeFragment) {
            BazeFragment bazeFragment = (BazeFragment) fragment;
            if (bazeFragment.F() != null && ((F = bazeFragment.F()) == null || F.intValue() != 0)) {
                ThemeActivityExtKt.a(this, N().c());
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
        O().a(this);
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
        Q(fragment, bundle2, false);
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f27005m = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Injector.f20166d.b().a().l();
        super.onResume();
        f27005m = true;
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
        this.f27009i = navigator;
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void x(eu.bolt.driver.core.ui.common.activity.ToolbarAppearance toolbarAppearance) {
        Intrinsics.f(toolbarAppearance, "toolbarAppearance");
        PopupToolbar toolbar = (PopupToolbar) L(R.id.kc);
        Intrinsics.e(toolbar, "toolbar");
        toolbarAppearance.a(toolbar, this);
    }
}
