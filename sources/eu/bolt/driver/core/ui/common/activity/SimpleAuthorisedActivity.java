package eu.bolt.driver.core.ui.common.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import eu.bolt.driver.core.DriverCore;
import eu.bolt.driver.core.R$id;
import eu.bolt.driver.core.R$layout;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import eu.bolt.driver.core.ui.base.activity.BaseAuthorisedActivity;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.impl.ActivityClassCommand;
import eu.bolt.driver.core.ui.routing.command.impl.AnimationResources;
import eu.bolt.driver.core.ui.theme.AppThemeUiUtils;
import eu.bolt.driver.core.ui.theme.ThemeProvider;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleAuthorisedActivity.kt */
/* loaded from: classes5.dex */
public final class SimpleAuthorisedActivity extends BaseAuthorisedActivity {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f41067q = new Companion(null);
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public ThemeProvider f41068n;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public LanguageManager f41069o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f41070p = new LinkedHashMap();

    /* compiled from: SimpleAuthorisedActivity.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Bundle a(Class<? extends Fragment> cls, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("content", cls);
            bundle2.putParcelable("args", bundle);
            return bundle2;
        }

        public static /* synthetic */ RoutingCommand c(Companion companion, Class cls, Bundle bundle, int i8, AnimationResources animationResources, int i9, Object obj) {
            if ((i9 & 2) != 0) {
                bundle = new Bundle();
            }
            if ((i9 & 4) != 0) {
                i8 = 0;
            }
            if ((i9 & 8) != 0) {
                animationResources = null;
            }
            return companion.b(cls, bundle, i8, animationResources);
        }

        public final RoutingCommand b(Class<? extends Fragment> fragmentClass, Bundle args, int i8, AnimationResources animationResources) {
            Intrinsics.f(fragmentClass, "fragmentClass");
            Intrinsics.f(args, "args");
            return new ActivityClassCommand(SimpleAuthorisedActivity.class, a(fragmentClass, args), 536870912 | i8, animationResources);
        }
    }

    private final void T(Intent intent) {
        Object obj;
        Class cls;
        Bundle bundle;
        boolean z7;
        Bundle extras = intent.getExtras();
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
        if (cls != null) {
            CoreFragmentFactory L = L();
            ClassLoader classLoader = getClassLoader();
            Intrinsics.e(classLoader, "this.classLoader");
            String name = cls.getName();
            Intrinsics.e(name, "fragmentClass.name");
            Fragment instantiate = L.instantiate(classLoader, name);
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                bundle = extras2.getBundle("args");
            } else {
                bundle = null;
            }
            instantiate.setArguments(bundle);
            if (getSupportFragmentManager().getFragments().size() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            FragmentTransaction replace = getSupportFragmentManager().beginTransaction().replace(R$id.f40765c, instantiate);
            Intrinsics.e(replace, "supportFragmentManager.b…R.id.container, fragment)");
            if (z7) {
                replace.addToBackStack(null);
            }
            replace.commit();
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // eu.bolt.driver.core.ui.base.activity.BaseAuthorisedActivity
    public void P(Bundle bundle) {
        setContentView(R$layout.activity_simple);
        if (bundle == null) {
            Intent intent = getIntent();
            Intrinsics.e(intent, "intent");
            T(intent);
        }
    }

    @Override // eu.bolt.driver.core.ui.base.activity.BaseAuthorisedActivity
    public void Q(Bundle bundle) {
        DriverCore.f40758a.a().v(this);
        AppThemeUiUtils.f41180a.a(this, S().a());
    }

    public final LanguageManager R() {
        LanguageManager languageManager = this.f41069o;
        if (languageManager != null) {
            return languageManager;
        }
        Intrinsics.w("languageManager");
        return null;
    }

    public final ThemeProvider S() {
        ThemeProvider themeProvider = this.f41068n;
        if (themeProvider != null) {
            return themeProvider;
        }
        Intrinsics.w("themeProvider");
        return null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.f(intent, "intent");
        super.onNewIntent(intent);
        T(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.f(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        R().l();
        super.onResume();
    }
}
