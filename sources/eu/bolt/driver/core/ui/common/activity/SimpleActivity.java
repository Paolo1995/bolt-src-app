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
import eu.bolt.driver.core.ui.base.activity.BaseActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleActivity.kt */
/* loaded from: classes5.dex */
public final class SimpleActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f41065k = new Companion(null);

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, View> f41066j = new LinkedHashMap();

    /* compiled from: SimpleActivity.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void N(Intent intent) {
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

    @Override // eu.bolt.driver.core.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        DriverCore.f40758a.b().a(this);
        super.onCreate(bundle);
        setContentView(R$layout.activity_simple);
        if (bundle == null) {
            Intent intent = getIntent();
            Intrinsics.e(intent, "intent");
            N(intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.f(intent, "intent");
        super.onNewIntent(intent);
        N(intent);
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
}
