package ee.mtakso.driver.service.restriction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import ee.mtakso.driver.identity.verification.IdentityVerificationManager;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.device.DriverAppDisabledReason;
import ee.mtakso.driver.network.client.driver.BoltIdentityVerificationData;
import ee.mtakso.driver.network.client.driver.DriverMightBeBlocked;
import ee.mtakso.driver.network.client.driver.MightBeBlockedType;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.analytics.event.facade.AppVerificationAnalytics;
import ee.mtakso.driver.service.deviceinfo.DeviceInfoSender;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledFragment;
import ee.mtakso.driver.ui.screens.blocking.DriverBlockedFragment;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.android.code.AppVerificationStatus;
import eu.bolt.android.code.AppVerifier;
import eu.bolt.android.code.BoltStringUtils;
import eu.bolt.android.code.Native;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverRestrictionManager.kt */
/* loaded from: classes3.dex */
public final class DriverRestrictionManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f25820a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverManager f25821b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderProvider f25822c;

    /* renamed from: d  reason: collision with root package name */
    private final DeviceInfoSender f25823d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverFeatures f25824e;

    /* renamed from: f  reason: collision with root package name */
    private final AppVerificationAnalytics f25825f;

    /* renamed from: g  reason: collision with root package name */
    private final IdentityVerificationManager f25826g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverTrainingRestrictionManager f25827h;

    /* compiled from: DriverRestrictionManager.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25828a;

        static {
            int[] iArr = new int[AppVerificationStatus.values().length];
            try {
                iArr[AppVerificationStatus.SIGNATURE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppVerificationStatus.INSTALLER_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppVerificationStatus.PACKAGE_NAME_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AppVerificationStatus.DEBUGGABLE_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AppVerificationStatus.VERIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f25828a = iArr;
        }
    }

    @Inject
    public DriverRestrictionManager(Context context, DriverManager driverManager, OrderProvider orderProvider, DeviceInfoSender deviceInfoSender, DriverFeatures driverFeatures, AppVerificationAnalytics appVerificationAnalytics, IdentityVerificationManager identityVerificationManager, DriverTrainingRestrictionManager driverTrainingRestrictionManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(driverManager, "driverManager");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(deviceInfoSender, "deviceInfoSender");
        Intrinsics.f(driverFeatures, "driverFeatures");
        Intrinsics.f(appVerificationAnalytics, "appVerificationAnalytics");
        Intrinsics.f(identityVerificationManager, "identityVerificationManager");
        Intrinsics.f(driverTrainingRestrictionManager, "driverTrainingRestrictionManager");
        this.f25820a = context;
        this.f25821b = driverManager;
        this.f25822c = orderProvider;
        this.f25823d = deviceInfoSender;
        this.f25824e = driverFeatures;
        this.f25825f = appVerificationAnalytics;
        this.f25826g = identityVerificationManager;
        this.f25827h = driverTrainingRestrictionManager;
    }

    private final DriverAppDisabledReason d(AppVerificationStatus appVerificationStatus) {
        int i8 = WhenMappings.f25828a[appVerificationStatus.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new IllegalArgumentException("There is no disabled reason for verified app");
                    }
                    return DriverAppDisabledReason.VERIFICATION_DEBUGGABLE_APP;
                }
                return DriverAppDisabledReason.VERIFICATION_PACKAGE_NAME;
            }
            return DriverAppDisabledReason.VERIFICATION_INSTALLER;
        }
        return DriverAppDisabledReason.VERIFICATION_SIGNATURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void h(BoltIdentityVerificationData boltIdentityVerificationData) {
        if (!this.f25824e.m()) {
            Kalev.e(new IllegalStateException("Bolt verification requested but disabled"), "Bolt verification requested but disabled!");
        } else {
            this.f25826g.d(boltIdentityVerificationData.a());
        }
    }

    public final void c(DriverMightBeBlocked data) {
        Intrinsics.f(data, "data");
        this.f25821b.m();
        if (data.a() != null) {
            Intent g8 = SimpleActivity.f27004l.g(this.f25820a, DriverBlockedFragment.class, DriverBlockedFragment.f27084p.a(data.a()), false);
            g8.setFlags(268468224);
            this.f25820a.startActivity(g8);
        } else if (data.f() == MightBeBlockedType.BLOCKED_BY_TRAINING) {
            this.f25827h.a();
        } else if (data.c() != null) {
            h(data.c());
        } else {
            Kalev.e(new IllegalArgumentException("Unexpected driver block: " + data), "Block data and driver identity verification data is null!");
        }
    }

    @SuppressLint({"CheckResult"})
    public final void e(DriverAppDisabledReason reason) {
        Long l8;
        OrderHandle a8;
        Intrinsics.f(reason, "reason");
        this.f25821b.m();
        SimpleActivity.Companion companion = SimpleActivity.f27004l;
        if (companion.i() || RestrictionUtil.f25859a.a(reason)) {
            DriverAppDisabledFragment.Companion companion2 = DriverAppDisabledFragment.f27050r;
            if (!companion2.a()) {
                Intent g8 = companion.g(this.f25820a, DriverAppDisabledFragment.class, companion2.b(reason), false);
                g8.setFlags(268468224);
                this.f25820a.startActivity(g8);
                ActiveOrderDetails j8 = OrderProviderUtils.j(this.f25822c.f());
                DeviceInfoSender deviceInfoSender = this.f25823d;
                if (j8 != null && (a8 = j8.a()) != null) {
                    l8 = Long.valueOf(a8.b());
                } else {
                    l8 = null;
                }
                Single<Optional<EmptyServerResponse>> a9 = deviceInfoSender.a(reason, l8);
                final DriverRestrictionManager$disableApp$1 driverRestrictionManager$disableApp$1 = new Function1<Optional<EmptyServerResponse>, Unit>() { // from class: ee.mtakso.driver.service.restriction.DriverRestrictionManager$disableApp$1
                    public final void b(Optional<EmptyServerResponse> optional) {
                        Kalev.k("App disabled event sent");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Optional<EmptyServerResponse> optional) {
                        b(optional);
                        return Unit.f50853a;
                    }
                };
                Consumer<? super Optional<EmptyServerResponse>> consumer = new Consumer() { // from class: ee.mtakso.driver.service.restriction.c
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        DriverRestrictionManager.f(Function1.this, obj);
                    }
                };
                final DriverRestrictionManager$disableApp$2 driverRestrictionManager$disableApp$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.restriction.DriverRestrictionManager$disableApp$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.f50853a;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.e(it, "it");
                        Kalev.e(it, "Failed to send app disabled event");
                    }
                };
                a9.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.restriction.d
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        DriverRestrictionManager.g(Function1.this, obj);
                    }
                });
            }
        }
    }

    public final boolean i() {
        AppVerificationStatus b8;
        String T;
        if (!this.f25824e.g()) {
            return true;
        }
        int appVerificationStatus = Native.getAppVerificationStatus();
        AppVerificationStatus appVerificationStatus2 = AppVerificationStatus.VERIFIED;
        if (appVerificationStatus != appVerificationStatus2.ordinal()) {
            b8 = AppVerificationStatus.values()[Native.getAppVerificationStatus()];
        } else if (Native.appVerificationStatus != appVerificationStatus2.ordinal()) {
            b8 = AppVerificationStatus.values()[Native.appVerificationStatus];
        } else {
            b8 = AppVerifier.b(this.f25820a, "liveGoogle", "release");
        }
        this.f25825f.O1(b8);
        if (b8 == appVerificationStatus2) {
            return true;
        }
        String[] randomStrings = BoltStringUtils.getRandomStrings(this.f25820a);
        Intrinsics.e(randomStrings, "getRandomStrings(context)");
        T = ArraysKt___ArraysKt.T(randomStrings, "-", null, null, 0, null, null, 62, null);
        Kalev.e(new RuntimeException("App verification failed, signatures: " + T + ", Verification status: " + b8), "App verification failed");
        if (!this.f25824e.f()) {
            return true;
        }
        e(d(b8));
        return false;
    }
}
