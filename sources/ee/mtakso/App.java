package ee.mtakso;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.emoji.bundled.BundledEmojiCompatConfig;
import androidx.emoji.text.EmojiCompat;
import androidx.multidex.MultiDexApplication;
import com.google.android.gms.common.api.Api;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.identity.verification.IdentityVerificationCoordinator;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.integration.clevertap.CleverTapCoordinator;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodChooserCoordinator;
import ee.mtakso.driver.ui.screens.home.v3.DeeplinkHomeContainerCoordinator;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.DeeplinkCoordinator;
import ee.mtakso.driver.ui.screens.login.v2.RouterFragmentCoordinator;
import ee.mtakso.driver.utils.ActivityLifecycleLoggingManager;
import ee.mtakso.driver.utils.customtabs.CustomTabsUrlLauncher;
import ee.mtakso.driver.utils.urlcomand.DriverPortalUrlCoordinator;
import ee.mtakso.driver.utils.urlcomand.UrlCoordinator;
import eu.bolt.android.code.BoltStringUtils;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.chat.ui.ChatForegroundTracker;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.coordinator.ActivitiesStackClassCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.ActivityClassCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.ActivityIntentCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.BackgroundActivityCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.DialogFragmentCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.NoOpCoordinator;
import eu.bolt.driver.core.ui.routing.state.StateTracker;
import eu.bolt.driver.core.ui.translation.TranslatedContext;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class App extends MultiDexApplication {

    /* renamed from: x  reason: collision with root package name */
    private static App f19804x;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    ActivityLifecycleLoggingManager f19805f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    ChatForegroundTracker f19806g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    DriverProvider f19807h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    StateTracker f19808i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    RoutingManager f19809j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    ActivityClassCoordinator f19810k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    ActivitiesStackClassCoordinator f19811l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    ActivityIntentCoordinator f19812m;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    RouterFragmentCoordinator f19813n;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    DeeplinkHomeContainerCoordinator f19814o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    DeeplinkCoordinator f19815p;
    @Inject

    /* renamed from: q  reason: collision with root package name */
    CleverTapCoordinator f19816q;
    @Inject

    /* renamed from: r  reason: collision with root package name */
    UrlCoordinator f19817r;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    DriverPortalUrlCoordinator f19818s;
    @Inject

    /* renamed from: t  reason: collision with root package name */
    IdentityVerificationCoordinator f19819t;
    @Inject

    /* renamed from: u  reason: collision with root package name */
    DialogFragmentCoordinator f19820u;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    PermissionManager f19821v;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    CustomTabsUrlLauncher f19822w;

    static {
        BoltStringUtils.RANDOM_STRING = "release,false,liveGoogle,false,";
        BoltStringUtils.RANDOM_CHARS = "DA.58.0";
    }

    private void a() {
        EmojiCompat.f(new BundledEmojiCompatConfig(this));
    }

    public static App getInstance() {
        return f19804x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(TranslatedContext.a(context));
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        if (super.getBaseContext() instanceof ContextWrapper) {
            return ((ContextWrapper) super.getBaseContext()).getBaseContext();
        }
        return super.getBaseContext();
    }

    @Override // android.app.Application
    public void onCreate() {
        Injector.f2().G1().q(this);
        super.onCreate();
        AppCompatDelegate.S(true);
        f19804x = this;
        Injector.f2().k(this);
        ContactMethodChooserCoordinator contactMethodChooserCoordinator = new ContactMethodChooserCoordinator();
        registerActivityLifecycleCallbacks(this.f19805f);
        registerActivityLifecycleCallbacks(this.f19806g);
        registerActivityLifecycleCallbacks(this.f19808i);
        registerActivityLifecycleCallbacks(this.f19810k);
        registerActivityLifecycleCallbacks(this.f19811l);
        registerActivityLifecycleCallbacks(this.f19812m);
        registerActivityLifecycleCallbacks(this.f19813n);
        registerActivityLifecycleCallbacks(this.f19822w);
        registerActivityLifecycleCallbacks(this.f19820u);
        registerActivityLifecycleCallbacks(contactMethodChooserCoordinator);
        a();
        DriverChatSdk.f40388a.e(Injector.f2());
        this.f19809j.g(Integer.MIN_VALUE, new NoOpCoordinator());
        this.f19809j.g(0, new BackgroundActivityCoordinator(this));
        this.f19809j.g(0, this.f19810k);
        this.f19809j.g(0, this.f19811l);
        this.f19809j.g(0, this.f19812m);
        this.f19809j.g(0, this.f19813n);
        this.f19809j.g(Api.BaseClientBuilder.API_PRIORITY_OTHER, this.f19814o);
        this.f19809j.g(0, this.f19815p);
        this.f19809j.g(0, this.f19816q);
        this.f19809j.g(0, this.f19819t);
        this.f19809j.g(0, this.f19818s);
        this.f19809j.g(0, this.f19817r);
        this.f19809j.g(0, this.f19820u);
        this.f19809j.g(0, contactMethodChooserCoordinator);
    }
}
