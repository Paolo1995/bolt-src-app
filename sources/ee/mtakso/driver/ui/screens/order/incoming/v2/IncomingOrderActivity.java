package ee.mtakso.driver.ui.screens.order.incoming.v2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentFactory;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderHandleKt;
import ee.mtakso.driver.ui.theme.ThemeActivityExtKt;
import ee.mtakso.driver.ui.utils.WindowHelperKt;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.translation.TranslatedContext;
import eu.bolt.driver.core.ui.translation.TranslatedResources;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderActivity.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderActivity extends AppCompatActivity {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f31356i = new Companion(null);
    @Inject

    /* renamed from: f  reason: collision with root package name */
    public AppThemeManager f31357f;

    /* renamed from: g  reason: collision with root package name */
    private Resources f31358g;

    /* renamed from: h  reason: collision with root package name */
    public Map<Integer, View> f31359h = new LinkedHashMap();

    /* compiled from: IncomingOrderActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, OrderHandle orderHandle) {
            Intrinsics.f(context, "context");
            Intrinsics.f(orderHandle, "orderHandle");
            Intent intent = new Intent(context, IncomingOrderActivity.class);
            intent.setFlags(335577088);
            intent.putExtras(OrderHandleKt.d(orderHandle));
            return intent;
        }
    }

    public final AppThemeManager L() {
        AppThemeManager appThemeManager = this.f31357f;
        if (appThemeManager != null) {
            return appThemeManager;
        }
        Intrinsics.w("appThemeManager");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Intrinsics.f(context, "context");
        super.attachBaseContext(TranslatedContext.f41187b.a(Injector.f20166d.b().a().b(context)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f31358g == null) {
            Resources resources = super.getResources();
            Intrinsics.e(resources, "super.getResources()");
            this.f31358g = new TranslatedResources(resources);
        }
        return this.f31358g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Injector.Companion companion = Injector.f20166d;
        companion.b().Y1().h(this);
        ThemeActivityExtKt.a(this, L().c());
        getSupportFragmentManager().setFragmentFactory(companion.b().Y1().b());
        super.onCreate(bundle);
        setContentView(R.layout.activity_order_incoming);
        if (bundle != null) {
            return;
        }
        FragmentFactory fragmentFactory = getSupportFragmentManager().getFragmentFactory();
        Intrinsics.e(fragmentFactory, "supportFragmentManager.fragmentFactory");
        getSupportFragmentManager().beginTransaction().replace(R.id.container, (IncomingOrderFragment) FragmentFactoryUtils.c(fragmentFactory, this, IncomingOrderFragment.class, null, 4, null), "content").commit();
        WindowHelperKt.a(this);
        WindowHelperKt.b(this);
        WindowHelperKt.c(this, TimeUnit.SECONDS.toMillis(30L));
    }
}
