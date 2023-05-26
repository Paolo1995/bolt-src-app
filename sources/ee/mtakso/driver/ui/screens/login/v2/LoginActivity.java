package ee.mtakso.driver.ui.screens.login.v2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.ui.helper.ErrorDialogDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.update.GoogleServicesUpdateDelegate;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.translation.TranslatedContext;
import eu.bolt.driver.core.ui.translation.TranslatedResources;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginActivity.kt */
/* loaded from: classes3.dex */
public final class LoginActivity extends AppCompatActivity implements Router {

    /* renamed from: n */
    public static final Companion f30446n = new Companion(null);

    /* renamed from: f */
    public FragmentFactory f30447f;

    /* renamed from: g */
    public DeeplinkDelegate f30448g;

    /* renamed from: h */
    public RoutingManager f30449h;

    /* renamed from: i */
    private Resources f30450i;

    /* renamed from: j */
    private GoBackDelegate f30451j;

    /* renamed from: k */
    private final Lazy f30452k;

    /* renamed from: l */
    private final Lazy f30453l;

    /* renamed from: m */
    public Map<Integer, View> f30454m = new LinkedHashMap();

    /* compiled from: LoginActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, Context context, Class cls, int i8, Bundle bundle, Throwable th, int i9, Object obj) {
            int i10;
            Bundle bundle2;
            Throwable th2;
            if ((i9 & 4) != 0) {
                i10 = -1;
            } else {
                i10 = i8;
            }
            if ((i9 & 8) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            if ((i9 & 16) != 0) {
                th2 = null;
            } else {
                th2 = th;
            }
            companion.b(context, cls, i10, bundle2, th2);
        }

        public final Intent a(Context context, Class<? extends Fragment> content, int i8, Bundle bundle, Throwable th) {
            Intrinsics.f(context, "context");
            Intrinsics.f(content, "content");
            Intent intent = new Intent(context, LoginActivity.class);
            intent.putExtra("content", content);
            intent.putExtra("args", bundle);
            intent.putExtra("launching_error", th);
            if (i8 == -1) {
                intent.setFlags(268468224);
            } else {
                intent.setFlags(i8);
            }
            return intent;
        }

        public final void b(Context context, Class<? extends Fragment> content, int i8, Bundle bundle, Throwable th) {
            Intrinsics.f(context, "context");
            Intrinsics.f(content, "content");
            context.startActivity(a(context, content, i8, bundle, th));
        }
    }

    public LoginActivity() {
        Lazy b8;
        Lazy b9;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ErrorDialogDelegate>() { // from class: ee.mtakso.driver.ui.screens.login.v2.LoginActivity$errorDialogDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ErrorDialogDelegate invoke() {
                return new ErrorDialogDelegate(LoginActivity.this);
            }
        });
        this.f30452k = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<GoogleServicesUpdateDelegate>() { // from class: ee.mtakso.driver.ui.screens.login.v2.LoginActivity$googleServicesUpdateDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final GoogleServicesUpdateDelegate invoke() {
                ErrorDialogDelegate N;
                RoutingManager R = LoginActivity.this.R();
                N = LoginActivity.this.N();
                return new GoogleServicesUpdateDelegate(R, N);
            }
        });
        this.f30453l = b9;
    }

    public final ErrorDialogDelegate N() {
        return (ErrorDialogDelegate) this.f30452k.getValue();
    }

    private final GoogleServicesUpdateDelegate P() {
        return (GoogleServicesUpdateDelegate) this.f30453l.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x003e A[Catch: IllegalArgumentException -> 0x0043, TRY_LEAVE, TryCatch #0 {IllegalArgumentException -> 0x0043, blocks: (B:34:0x0001, B:37:0x0009, B:39:0x000f, B:41:0x0015, B:52:0x0038, B:54:0x003e, B:43:0x0020, B:45:0x0026, B:47:0x002c, B:49:0x0032, B:51:0x0036), top: B:59:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Throwable Q() {
        /*
            r4 = this;
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.IllegalArgumentException -> L43
            r2 = 33
            java.lang.String r3 = "launching_error"
            if (r1 < r2) goto L20
            android.content.Intent r1 = r4.getIntent()     // Catch: java.lang.IllegalArgumentException -> L43
            if (r1 == 0) goto L1e
            android.os.Bundle r1 = r1.getExtras()     // Catch: java.lang.IllegalArgumentException -> L43
            if (r1 == 0) goto L1e
            java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
            java.io.Serializable r1 = r1.getSerializable(r3, r2)     // Catch: java.lang.IllegalArgumentException -> L43
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch: java.lang.IllegalArgumentException -> L43
            goto L38
        L1e:
            r1 = r0
            goto L38
        L20:
            android.content.Intent r1 = r4.getIntent()     // Catch: java.lang.IllegalArgumentException -> L43
            if (r1 == 0) goto L31
            android.os.Bundle r1 = r1.getExtras()     // Catch: java.lang.IllegalArgumentException -> L43
            if (r1 == 0) goto L31
            java.io.Serializable r1 = r1.getSerializable(r3)     // Catch: java.lang.IllegalArgumentException -> L43
            goto L32
        L31:
            r1 = r0
        L32:
            boolean r2 = r1 instanceof java.lang.Throwable     // Catch: java.lang.IllegalArgumentException -> L43
            if (r2 == 0) goto L1e
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch: java.lang.IllegalArgumentException -> L43
        L38:
            android.content.Intent r2 = r4.getIntent()     // Catch: java.lang.IllegalArgumentException -> L43
            if (r2 == 0) goto L41
            r2.removeExtra(r3)     // Catch: java.lang.IllegalArgumentException -> L43
        L41:
            r0 = r1
            goto L49
        L43:
            r1 = move-exception
            java.lang.String r2 = "Failed to get launching error"
            eu.bolt.kalev.Kalev.e(r1, r2)
        L49:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.login.v2.LoginActivity.Q():java.lang.Throwable");
    }

    private final void S() {
        Object obj;
        Class<? extends Fragment> cls;
        Bundle extras = getIntent().getExtras();
        Bundle bundle = null;
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
        if (cls == null) {
            return;
        }
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null) {
            bundle = extras2.getBundle("args");
        }
        d(cls, bundle, false);
    }

    private final void T() {
        Throwable Q = Q();
        if (Q instanceof StoreIntegrityVerificationResult.Error) {
            P().a(Q);
        } else if (Q != null) {
            N().a(Q);
        }
    }

    public final DeeplinkDelegate M() {
        DeeplinkDelegate deeplinkDelegate = this.f30448g;
        if (deeplinkDelegate != null) {
            return deeplinkDelegate;
        }
        Intrinsics.w("deeplinkDelegate");
        return null;
    }

    public final FragmentFactory O() {
        FragmentFactory fragmentFactory = this.f30447f;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Intrinsics.w("fragmentFactory");
        return null;
    }

    public final RoutingManager R() {
        RoutingManager routingManager = this.f30449h;
        if (routingManager != null) {
            return routingManager;
        }
        Intrinsics.w("routingManager");
        return null;
    }

    public final void U(DeeplinkDelegate deeplinkDelegate) {
        Intrinsics.f(deeplinkDelegate, "<set-?>");
        this.f30448g = deeplinkDelegate;
    }

    public final void V(FragmentFactory fragmentFactory) {
        Intrinsics.f(fragmentFactory, "<set-?>");
        this.f30447f = fragmentFactory;
    }

    public final void W(RoutingManager routingManager) {
        Intrinsics.f(routingManager, "<set-?>");
        this.f30449h = routingManager;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        Intrinsics.f(newBase, "newBase");
        super.attachBaseContext(TranslatedContext.f41187b.a(Injector.f20166d.b().a().b(newBase)));
    }

    @Override // ee.mtakso.driver.ui.screens.login.v2.Router
    public void c() {
        onBackPressed();
    }

    @Override // ee.mtakso.driver.ui.screens.login.v2.Router
    public void d(Class<? extends Fragment> content, Bundle bundle, boolean z7) {
        Intrinsics.f(content, "content");
        Fragment c8 = FragmentFactoryUtils.c(O(), this, content, null, 4, null);
        c8.setArguments(bundle);
        FragmentTransaction replace = getSupportFragmentManager().beginTransaction().replace(R.id.container, c8, "content");
        Intrinsics.e(replace, "supportFragmentManager.b…ner, fragment, \"content\")");
        if (z7) {
            replace = replace.addToBackStack(null);
            Intrinsics.e(replace, "transaction.addToBackStack(null)");
        }
        replace.commit();
    }

    @Override // ee.mtakso.driver.ui.screens.login.v2.Router
    public GoBackDelegate g() {
        return this.f30451j;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f30450i == null) {
            Resources resources = super.getResources();
            Intrinsics.e(resources, "super.getResources()");
            this.f30450i = new TranslatedResources(resources);
        }
        return this.f30450i;
    }

    @Override // ee.mtakso.driver.ui.screens.login.v2.Router
    public void l(GoBackDelegate goBackDelegate) {
        this.f30451j = goBackDelegate;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        GoBackDelegate g8 = g();
        boolean z7 = true;
        if (!((g8 == null || !g8.c()) ? false : false)) {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Injector.Companion companion = Injector.f20166d;
        V(companion.b().X1().b());
        U(companion.b().X1().d());
        W(companion.b().X1().c());
        getSupportFragmentManager().setFragmentFactory(O());
        super.onCreate(bundle);
        setContentView(R.layout.activity_simple);
        if (bundle != null) {
            return;
        }
        S();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        S();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        M().g(false);
        T();
    }
}
