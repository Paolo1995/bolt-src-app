package ee.mtakso.driver.ui.screens.settings;

import android.content.Context;
import ee.mtakso.driver.R;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.settings.DriverPricing;
import ee.mtakso.driver.network.client.work_time.WorkingTimeInfo;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.settings.AutoAcceptanceState;
import ee.mtakso.driver.service.settings.CategorySelectionAutoAcceptanceState;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.driver.core.language.Language;
import eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsInteractor.kt */
/* loaded from: classes5.dex */
public final class SettingsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final Context f33055a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f33056b;

    /* renamed from: c  reason: collision with root package name */
    private final DeviceInfo f33057c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkingTimeManager f33058d;

    /* renamed from: e  reason: collision with root package name */
    private final NavigationAppTypeFactory f33059e;

    /* renamed from: f  reason: collision with root package name */
    private final DriverReferralCampaignManager f33060f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverStatusProvider f33061g;

    /* renamed from: h  reason: collision with root package name */
    private final DeviceSettings f33062h;

    /* renamed from: i  reason: collision with root package name */
    private final LanguageManager f33063i;

    /* renamed from: j  reason: collision with root package name */
    private final DriverManager f33064j;

    /* renamed from: k  reason: collision with root package name */
    private final DispatchSettingsManager f33065k;

    /* renamed from: l  reason: collision with root package name */
    private final OnBoardingManager f33066l;

    /* renamed from: m  reason: collision with root package name */
    private final AppThemeManager f33067m;

    /* renamed from: n  reason: collision with root package name */
    private final DriverFeatures f33068n;

    /* renamed from: o  reason: collision with root package name */
    private final PublishSubject<Object> f33069o;

    @Inject
    public SettingsInteractor(Context context, DriverProvider driverProvider, DeviceInfo deviceInfo, WorkingTimeManager workingTimeInfoService, NavigationAppTypeFactory navigationAppTypeFactory, DriverReferralCampaignManager driverReferralCampaignManager, DriverStatusProvider driverStatusProvider, DeviceSettings deviceSettings, LanguageManager languageManager, DriverManager driverManager, DispatchSettingsManager dispatchSettingsManager, OnBoardingManager onBoardingManager, AppThemeManager appThemeManager, DriverFeatures driverFeatures) {
        Intrinsics.f(context, "context");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(deviceInfo, "deviceInfo");
        Intrinsics.f(workingTimeInfoService, "workingTimeInfoService");
        Intrinsics.f(navigationAppTypeFactory, "navigationAppTypeFactory");
        Intrinsics.f(driverReferralCampaignManager, "driverReferralCampaignManager");
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(languageManager, "languageManager");
        Intrinsics.f(driverManager, "driverManager");
        Intrinsics.f(dispatchSettingsManager, "dispatchSettingsManager");
        Intrinsics.f(onBoardingManager, "onBoardingManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(driverFeatures, "driverFeatures");
        this.f33055a = context;
        this.f33056b = driverProvider;
        this.f33057c = deviceInfo;
        this.f33058d = workingTimeInfoService;
        this.f33059e = navigationAppTypeFactory;
        this.f33060f = driverReferralCampaignManager;
        this.f33061g = driverStatusProvider;
        this.f33062h = deviceSettings;
        this.f33063i = languageManager;
        this.f33064j = driverManager;
        this.f33065k = dispatchSettingsManager;
        this.f33066l = onBoardingManager;
        this.f33067m = appThemeManager;
        this.f33068n = driverFeatures;
        PublishSubject<Object> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create()");
        this.f33069o = e8;
    }

    private final SettingsScreenState h(AutoAcceptanceState autoAcceptanceState, WorkingTimeInfo workingTimeInfo, Boolean bool, DriverPricing driverPricing) {
        boolean z7;
        boolean z8;
        boolean r7;
        boolean z9;
        String a8 = this.f33057c.a();
        String a9 = this.f33062h.i().a();
        String A = this.f33056b.m().A();
        DriverConfig d8 = this.f33056b.d();
        String str = (d8 == null || (r1 = d8.D()) == null) ? "" : "";
        ReferralConfig m8 = m();
        String l8 = this.f33056b.m().l();
        Text k8 = k();
        LanguageConfig j8 = j();
        QuickAccessConfig l9 = l();
        String q8 = this.f33056b.m().q();
        if (q8.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            q8 = null;
        }
        String str2 = q8;
        if (AppThemeUtils.f34255a.c(this.f33067m.d()) == MapStyle.DARK) {
            z8 = true;
        } else {
            z8 = false;
        }
        boolean a10 = this.f33056b.t().f().a();
        if (bool != null) {
            r7 = bool.booleanValue();
        } else {
            r7 = this.f33064j.r();
        }
        boolean d9 = this.f33066l.d();
        DocumentsExpiringWarning i8 = i();
        if (this.f33056b.m().d() != AppVersionState.OK) {
            z9 = true;
        } else {
            z9 = false;
        }
        return new SettingsScreenState(a8, z9, a9, A, str, m8, l8, k8, j8, l9, r7, d9, str2, i8, a10, z8, workingTimeInfo, autoAcceptanceState, driverPricing, this.f33056b.q().p(), this.f33056b.q().q(), this.f33067m.c());
    }

    private final DocumentsExpiringWarning i() {
        boolean O = this.f33056b.m().O();
        boolean N = this.f33056b.m().N();
        if (!O && !N) {
            return null;
        }
        return new DocumentsExpiringWarning(N, this.f33056b.m().n());
    }

    private final LanguageConfig j() {
        Language f8 = this.f33063i.f();
        return new LanguageConfig(f8, this.f33063i.h(f8));
    }

    private final QuickAccessConfig l() {
        return new QuickAccessConfig(this.f33056b.t().E().a(), this.f33056b.t().F().a());
    }

    private final Observable<Optional<AutoAcceptanceState>> n() {
        Observable<CategorySelectionAutoAcceptanceState> v7 = this.f33065k.v();
        final SettingsInteractor$observeAutoAcceptanceState$1 settingsInteractor$observeAutoAcceptanceState$1 = new Function1<CategorySelectionAutoAcceptanceState, AutoAcceptanceState>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsInteractor$observeAutoAcceptanceState$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AutoAcceptanceState invoke(CategorySelectionAutoAcceptanceState it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Observable<R> map = v7.map(new Function() { // from class: ee.mtakso.driver.ui.screens.settings.t
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AutoAcceptanceState o8;
                o8 = SettingsInteractor.o(Function1.this, obj);
                return o8;
            }
        });
        final SettingsInteractor$observeAutoAcceptanceState$2 settingsInteractor$observeAutoAcceptanceState$2 = new Function1<AutoAcceptanceState, Optional<AutoAcceptanceState>>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsInteractor$observeAutoAcceptanceState$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<AutoAcceptanceState> invoke(AutoAcceptanceState it) {
                Intrinsics.f(it, "it");
                return Optional.f(it);
            }
        };
        Observable map2 = map.map(new Function() { // from class: ee.mtakso.driver.ui.screens.settings.u
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional p8;
                p8 = SettingsInteractor.p(Function1.this, obj);
                return p8;
            }
        });
        Intrinsics.e(map2, "dispatchSettingsManager.… .map { Optional.of(it) }");
        return ObservableExtKt.g(map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AutoAcceptanceState o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AutoAcceptanceState) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    private final Observable<Optional<DriverPricing>> q() {
        return ObservableExtKt.g(this.f33065k.x());
    }

    private final Observable<Optional<Boolean>> r() {
        Observable<DriverStatus> distinctUntilChanged = this.f33061g.g().distinctUntilChanged();
        final SettingsInteractor$observeLogoutVisibility$1 settingsInteractor$observeLogoutVisibility$1 = new Function1<DriverStatus, Boolean>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsInteractor$observeLogoutVisibility$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DriverStatus it) {
                List n8;
                Intrinsics.f(it, "it");
                n8 = CollectionsKt__CollectionsKt.n(DriverStatus.WAITING_ORDER, DriverStatus.INACTIVE, DriverStatus.OFFLINE, DriverStatus.BUSY);
                return Boolean.valueOf(n8.contains(it));
            }
        };
        Observable<DriverStatus> filter = distinctUntilChanged.filter(new Predicate() { // from class: ee.mtakso.driver.ui.screens.settings.q
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean s7;
                s7 = SettingsInteractor.s(Function1.this, obj);
                return s7;
            }
        });
        final SettingsInteractor$observeLogoutVisibility$2 settingsInteractor$observeLogoutVisibility$2 = new Function1<DriverStatus, Boolean>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsInteractor$observeLogoutVisibility$2

            /* compiled from: SettingsInteractor.kt */
            /* loaded from: classes5.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f33074a;

                static {
                    int[] iArr = new int[DriverStatus.values().length];
                    try {
                        iArr[DriverStatus.WAITING_ORDER.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[DriverStatus.INACTIVE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[DriverStatus.OFFLINE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[DriverStatus.BUSY.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f33074a = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DriverStatus it) {
                Intrinsics.f(it, "it");
                int i8 = WhenMappings.f33074a[it.ordinal()];
                boolean z7 = true;
                if (i8 != 1) {
                    if (i8 != 2 && i8 != 3 && i8 != 4) {
                        throw new IllegalStateException("Not possible as we filtered out all those values".toString());
                    }
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<R> map = filter.map(new Function() { // from class: ee.mtakso.driver.ui.screens.settings.r
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean t7;
                t7 = SettingsInteractor.t(Function1.this, obj);
                return t7;
            }
        });
        final SettingsInteractor$observeLogoutVisibility$3 settingsInteractor$observeLogoutVisibility$3 = new Function1<Boolean, Optional<Boolean>>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsInteractor$observeLogoutVisibility$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<Boolean> invoke(Boolean it) {
                Intrinsics.f(it, "it");
                return Optional.f(it);
            }
        };
        Observable<Optional<Boolean>> startWith = map.map(new Function() { // from class: ee.mtakso.driver.ui.screens.settings.s
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional u7;
                u7 = SettingsInteractor.u(Function1.this, obj);
                return u7;
            }
        }).startWith((Observable) Optional.a());
        Intrinsics.e(startWith, "driverStatusProvider.obs…artWith(Optional.empty())");
        return startWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SettingsScreenState w(SettingsInteractor this$0, Optional logoutVisibility, Optional autoAcceptanceState, Optional optWorkingTimeInfo, Optional pricing, Object obj) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(logoutVisibility, "logoutVisibility");
        Intrinsics.f(autoAcceptanceState, "autoAcceptanceState");
        Intrinsics.f(optWorkingTimeInfo, "optWorkingTimeInfo");
        Intrinsics.f(pricing, "pricing");
        Intrinsics.f(obj, "<anonymous parameter 4>");
        return this$0.h((AutoAcceptanceState) autoAcceptanceState.c(), (WorkingTimeInfo) optWorkingTimeInfo.c(), (Boolean) logoutVisibility.c(), (DriverPricing) pricing.c());
    }

    private final Observable<Optional<WorkingTimeInfo>> x() {
        if (this.f33056b.m().M() == DriverFeaturesConfig.WorkingTimeMode.DISABLED) {
            Observable<Optional<WorkingTimeInfo>> just = Observable.just(Optional.a());
            Intrinsics.e(just, "{\n        Observable.just(Optional.empty())\n    }");
            return just;
        }
        Observable g8 = ObservableExtKt.g(this.f33058d.f());
        final SettingsInteractor$observeWorkTime$1 settingsInteractor$observeWorkTime$1 = new Function1<WorkingTimeInfo, Optional<WorkingTimeInfo>>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsInteractor$observeWorkTime$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<WorkingTimeInfo> invoke(WorkingTimeInfo it) {
                Intrinsics.f(it, "it");
                return Optional.f(it);
            }
        };
        Observable<Optional<WorkingTimeInfo>> startWith = g8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.settings.p
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional y7;
                y7 = SettingsInteractor.y(Function1.this, obj);
                return y7;
            }
        }).startWith((Observable) Optional.a());
        Intrinsics.e(startWith, "{\n        workingTimeInf…h(Optional.empty())\n    }");
        return startWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public final Text k() {
        if (this.f33068n.r()) {
            NavigationOption a8 = this.f33056b.v().I().a();
            if (a8 != null) {
                return new Text.Value(a8.getName());
            }
            return new Text.Resource(R.string.no_default_navigation, null, 2, null);
        }
        return new Text.Value(this.f33059e.c(this.f33056b.t().r().a()).a(this.f33055a));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r2 != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final ee.mtakso.driver.ui.screens.settings.ReferralConfig m() {
        /*
            r4 = this;
            ee.mtakso.driver.param.DriverProvider r0 = r4.f33056b
            ee.mtakso.driver.param.DriverConfig r0 = r0.m()
            java.lang.String r0 = r0.E()
            r1 = 0
            if (r0 == 0) goto L19
            int r2 = r0.length()
            if (r2 <= 0) goto L15
            r2 = 1
            goto L16
        L15:
            r2 = 0
        L16:
            if (r2 == 0) goto L19
            goto L1a
        L19:
            r0 = r1
        L1a:
            ee.mtakso.driver.param.DriverReferralCampaignManager r1 = r4.f33060f
            boolean r1 = r1.e()
            if (r1 == 0) goto L35
            ee.mtakso.driver.ui.screens.settings.ReferralConfig$Campaign r1 = new ee.mtakso.driver.ui.screens.settings.ReferralConfig$Campaign
            r2 = 2131296263(0x7f090007, float:1.8210438E38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            ee.mtakso.driver.param.DriverReferralCampaignManager r3 = r4.f33060f
            java.lang.String r3 = r3.c()
            r1.<init>(r2, r0, r3)
            goto L3a
        L35:
            ee.mtakso.driver.ui.screens.settings.ReferralConfig$Invite r1 = new ee.mtakso.driver.ui.screens.settings.ReferralConfig$Invite
            r1.<init>(r0)
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.settings.SettingsInteractor.m():ee.mtakso.driver.ui.screens.settings.ReferralConfig");
    }

    public final Observable<SettingsScreenState> v() {
        Observable<SettingsScreenState> combineLatest = Observable.combineLatest(r().distinctUntilChanged(), n().distinctUntilChanged(), x().distinctUntilChanged(), q().distinctUntilChanged(), this.f33069o, new Function5() { // from class: ee.mtakso.driver.ui.screens.settings.o
            @Override // io.reactivex.functions.Function5
            public final Object a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                SettingsScreenState w7;
                w7 = SettingsInteractor.w(SettingsInteractor.this, (Optional) obj, (Optional) obj2, (Optional) obj3, (Optional) obj4, obj5);
                return w7;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(\n         …         )\n            })");
        return combineLatest;
    }

    public final void z() {
        this.f33069o.onNext(new Object());
    }
}
