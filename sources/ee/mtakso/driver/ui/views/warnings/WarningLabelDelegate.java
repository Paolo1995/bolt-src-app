package ee.mtakso.driver.ui.views.warnings;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.connectivity.ConnectionMessage;
import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.utils.StatusBarUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WarningLabelDelegate.kt */
/* loaded from: classes5.dex */
public final class WarningLabelDelegate {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f34525f = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Activity f34526a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f34527b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f34528c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f34529d;

    /* renamed from: e  reason: collision with root package name */
    private WarningMessage f34530e;

    /* compiled from: WarningLabelDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WarningLabelDelegate.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34531a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f34532b;

        static {
            int[] iArr = new int[GeoLocationManagerState.values().length];
            try {
                iArr[GeoLocationManagerState.LOCATION_ACCESS_ISSUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GeoLocationManagerState.WAITING_FOR_LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f34531a = iArr;
            int[] iArr2 = new int[NetworkConnectionStatus.values().length];
            try {
                iArr2[NetworkConnectionStatus.INTERNET_NOT_ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[NetworkConnectionStatus.CONNECTION_ISSUES.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f34532b = iArr2;
        }
    }

    public WarningLabelDelegate(Activity activity) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(activity, "activity");
        this.f34526a = activity;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ViewGroup>() { // from class: ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate$layout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ViewGroup invoke() {
                Activity activity2;
                activity2 = WarningLabelDelegate.this.f34526a;
                return (ViewGroup) activity2.findViewById(R.id.statusBarLayout);
            }
        });
        this.f34527b = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<TextView>() { // from class: ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate$textView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final TextView invoke() {
                Activity activity2;
                activity2 = WarningLabelDelegate.this.f34526a;
                return (TextView) activity2.findViewById(R.id.statusBarText);
            }
        });
        this.f34528c = b9;
        this.f34529d = new Function0<Unit>() { // from class: ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate$dismissCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                WarningLabelDelegate.this.e();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        ViewGroup f8 = f();
        if (f8 == null) {
            return;
        }
        ViewExtKt.e(f8, false, 0, 2, null);
        Window window = this.f34526a.getWindow();
        Intrinsics.e(window, "activity.window");
        StatusBarUtils.a(window, ContextUtilsKt.d(this.f34526a, R.attr.colorPrimaryDark), ContextUtilsKt.a(this.f34526a, R.attr.isLightTheme));
    }

    private final ViewGroup f() {
        return (ViewGroup) this.f34527b.getValue();
    }

    private final TextView g() {
        return (TextView) this.f34528c.getValue();
    }

    private final void i(ConnectionMessage connectionMessage) {
        if (connectionMessage instanceof ConnectionMessage.Reconnected) {
            String string = this.f34526a.getString(R.string.internetIsBack);
            Intrinsics.e(string, "activity.getString(R.string.internetIsBack)");
            k(string, R.color.green700, 5000L);
        } else if (connectionMessage instanceof ConnectionMessage.Status) {
            int i8 = WhenMappings.f34532b[((ConnectionMessage.Status) connectionMessage).a().ordinal()];
            if (i8 != 1 && i8 != 2) {
                e();
                return;
            }
            String string2 = this.f34526a.getString(R.string.noInternetError);
            Intrinsics.e(string2, "activity.getString(R.string.noInternetError)");
            l(this, string2, R.color.red500, 0L, 4, null);
        }
    }

    private final void j(GeoLocationManagerState geoLocationManagerState) {
        int i8 = WhenMappings.f34531a[geoLocationManagerState.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                e();
                return;
            }
            String string = this.f34526a.getString(R.string.label_waiting_for_gps);
            Intrinsics.e(string, "activity.getString(R.string.label_waiting_for_gps)");
            l(this, string, R.color.orange700, 0L, 4, null);
            return;
        }
        String string2 = this.f34526a.getString(R.string.label_location_services_disabled);
        Intrinsics.e(string2, "activity.getString(R.str…cation_services_disabled)");
        l(this, string2, R.color.red500, 0L, 4, null);
    }

    private final void k(String str, int i8, long j8) {
        TextView g8;
        ViewGroup f8 = f();
        if (f8 == null || (g8 = g()) == null) {
            return;
        }
        final Function0<Unit> function0 = this.f34529d;
        f8.removeCallbacks(new Runnable() { // from class: m5.a
            @Override // java.lang.Runnable
            public final void run() {
                WarningLabelDelegate.m(Function0.this);
            }
        });
        ViewExtKt.e(f8, true, 0, 2, null);
        f8.setBackgroundColor(ContextCompat.getColor(this.f34526a, i8));
        g8.setText(str);
        Window window = this.f34526a.getWindow();
        Intrinsics.e(window, "activity.window");
        StatusBarUtils.a(window, i8, true);
        if (j8 > 0) {
            final Function0<Unit> function02 = this.f34529d;
            f8.postDelayed(new Runnable() { // from class: m5.b
                @Override // java.lang.Runnable
                public final void run() {
                    WarningLabelDelegate.n(Function0.this);
                }
            }, j8);
        }
    }

    static /* synthetic */ void l(WarningLabelDelegate warningLabelDelegate, String str, int i8, long j8, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            j8 = 0;
        }
        warningLabelDelegate.k(str, i8, j8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void o(WarningMessage warningMessage) {
        if (warningMessage instanceof WarningMessage.Connection) {
            i(((WarningMessage.Connection) warningMessage).a());
        } else if (warningMessage instanceof WarningMessage.Location) {
            j(((WarningMessage.Location) warningMessage).a());
        } else if (warningMessage instanceof WarningMessage.Polling) {
            l(this, ((WarningMessage.Polling) warningMessage).a().a(), R.color.orange700, 0L, 4, null);
        } else {
            e();
        }
    }

    public final void h(WarningMessage warningMessage) {
        if (!Intrinsics.a(this.f34530e, warningMessage)) {
            o(warningMessage);
        }
        this.f34530e = warningMessage;
    }
}
