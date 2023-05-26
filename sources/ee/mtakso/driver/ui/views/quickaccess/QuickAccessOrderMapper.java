package ee.mtakso.driver.ui.views.quickaccess;

import android.content.Context;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.OrderKt;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import eu.bolt.driver.core.ui.translation.TranslatedResources;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessOrderMapper.kt */
/* loaded from: classes5.dex */
public final class QuickAccessOrderMapper {

    /* renamed from: a  reason: collision with root package name */
    private final Context f34483a;

    /* renamed from: b  reason: collision with root package name */
    private final TranslatedResources f34484b;

    /* compiled from: QuickAccessOrderMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34485a;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderState.ORDER_STATE_WAITING_ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVING_WITH_CLIENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f34485a = iArr;
        }
    }

    public QuickAccessOrderMapper(Context context, TranslatedResources translatedResources) {
        Intrinsics.f(context, "context");
        Intrinsics.f(translatedResources, "translatedResources");
        this.f34483a = context;
        this.f34484b = translatedResources;
    }

    private final long a(ActiveOrderDetails activeOrderDetails) {
        Integer k8 = activeOrderDetails.i().k();
        if (k8 != null) {
            return Math.abs(activeOrderDetails.l() - k8.intValue());
        }
        return activeOrderDetails.l();
    }

    private final Boolean b(ActiveOrderDetails activeOrderDetails) {
        boolean z7;
        Integer k8 = activeOrderDetails.i().k();
        if (k8 != null) {
            if (activeOrderDetails.l() > k8.intValue()) {
                z7 = true;
            } else {
                z7 = false;
            }
            return Boolean.valueOf(z7);
        }
        return null;
    }

    private final QuickAccessDetailsState c(ActiveOrderDetails activeOrderDetails) {
        String str;
        String str2;
        CharSequence text = this.f34484b.getText(R.string.state_driving_to_pickup);
        String d8 = OrderKt.d(activeOrderDetails.i());
        if (d8 == null) {
            str = "";
        } else {
            str = d8;
        }
        String e8 = activeOrderDetails.i().e();
        if (e8 == null) {
            str2 = "";
        } else {
            str2 = e8;
        }
        return new QuickAccessDetailsState(text, str, str2, new ActionButtonState(this.f34484b.getText(R.string.arrived), ContextCompat.getColor(this.f34483a, R.color.green700), ContextCompat.getColor(this.f34483a, R.color.green900)), null, g(activeOrderDetails), null, 80, null);
    }

    private final QuickAccessDetailsState d(ActiveOrderDetails activeOrderDetails) {
        CharSequence text = this.f34484b.getText(R.string.state_driving_to_destination);
        String d8 = OrderKt.d(activeOrderDetails.i());
        if (d8 == null) {
            d8 = "";
        }
        return new QuickAccessDetailsState(text, d8, null, new ActionButtonState(this.f34484b.getText(R.string.slide_to_end_ride_lowercase), ContextCompat.getColor(this.f34483a, R.color.red700), ContextCompat.getColor(this.f34483a, R.color.red900)), null, null, null, 116, null);
    }

    private final QuickAccessDetailsState e(ActiveOrderDetails activeOrderDetails, boolean z7, boolean z8) {
        CharSequence text = this.f34484b.getText(R.string.state_driving_to_next_stop);
        String d8 = OrderKt.d(activeOrderDetails.i());
        if (d8 == null) {
            d8 = "";
        }
        String str = d8;
        ActionButtonState actionButtonState = new ActionButtonState(this.f34484b.getText(R.string.slide_to_waiting_point_lowercase), ContextCompat.getColor(this.f34483a, R.color.purple700), ContextCompat.getColor(this.f34483a, R.color.purple900));
        PaidWaitingButtonState paidWaitingButtonState = new PaidWaitingButtonState(R.drawable.ic_wait_purple, true, z8);
        if (!z7) {
            paidWaitingButtonState = null;
        }
        return new QuickAccessDetailsState(text, str, null, actionButtonState, paidWaitingButtonState, null, null, 100, null);
    }

    private final QuickAccessRatingState g(ActiveOrderDetails activeOrderDetails) {
        return new QuickAccessRatingState(OrderKt.f(activeOrderDetails.i()), activeOrderDetails.i().g());
    }

    private final QuickAccessDetailsState h(ActiveOrderDetails activeOrderDetails) {
        String str;
        String str2;
        long a8 = a(activeOrderDetails);
        Boolean b8 = b(activeOrderDetails);
        Boolean bool = Boolean.FALSE;
        boolean a9 = Intrinsics.a(b8, bool);
        int i8 = R.string.title_waiting_with_time;
        if (!a9 && Intrinsics.a(b8, Boolean.TRUE)) {
            i8 = R.string.title_paid_waiting_with_time;
        }
        String d8 = OrderKt.d(activeOrderDetails.i());
        if (d8 == null) {
            str = "";
        } else {
            str = d8;
        }
        String e8 = activeOrderDetails.i().e();
        if (e8 == null) {
            str2 = "";
        } else {
            str2 = e8;
        }
        return new QuickAccessDetailsState(null, str, str2, new ActionButtonState(this.f34484b.getText(R.string.start_trip_lowercase), ContextCompat.getColor(this.f34483a, R.color.green700), ContextCompat.getColor(this.f34483a, R.color.green900)), null, g(activeOrderDetails), new QuickAccessTimerState(a8, this.f34484b.getString(i8), Intrinsics.a(b8, bool), QuickAccessTimerTarget.TITLE), 17, null);
    }

    private final QuickAccessDetailsState i(ActiveOrderDetails activeOrderDetails) {
        String str;
        long j8;
        String j9 = activeOrderDetails.j();
        if (j9 == null) {
            j9 = "";
        }
        String d8 = OrderKt.d(activeOrderDetails.i());
        if (d8 == null) {
            str = "";
        } else {
            str = d8;
        }
        TranslatedResources translatedResources = this.f34484b;
        String string = translatedResources.getString(R.string.two_separated_values, j9, translatedResources.getString(R.string.paid_waiting));
        Long m8 = activeOrderDetails.m();
        if (m8 != null) {
            j8 = m8.longValue();
        } else {
            j8 = 0;
        }
        long j10 = j8;
        QuickAccessTimerTarget quickAccessTimerTarget = QuickAccessTimerTarget.SUBTITLE;
        String string2 = this.f34484b.getString(R.string.dot_separator);
        return new QuickAccessDetailsState(string, str, null, new ActionButtonState(this.f34484b.getText(R.string.slide_depart_from_stop_lowercase), ContextCompat.getColor(this.f34483a, R.color.purple700), ContextCompat.getColor(this.f34483a, R.color.purple900)), null, null, new QuickAccessTimerState(j10, "%s " + string2 + " " + str, false, quickAccessTimerTarget, 4, null), 52, null);
    }

    public final QuickAccessDetailsState f(ActiveOrderDetails details, boolean z7, boolean z8) {
        Intrinsics.f(details, "details");
        int i8 = WhenMappings.f34485a[details.i().E().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        return null;
                    }
                    if (details.i().H().size() > 1) {
                        return e(details, z7, z8);
                    }
                    return d(details);
                }
                return i(details);
            }
            return h(details);
        }
        return c(details);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ QuickAccessOrderMapper(android.content.Context r1, eu.bolt.driver.core.ui.translation.TranslatedResources r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L12
            eu.bolt.driver.core.ui.translation.TranslatedResources r2 = new eu.bolt.driver.core.ui.translation.TranslatedResources
            android.content.res.Resources r3 = r1.getResources()
            java.lang.String r4 = "context.resources"
            kotlin.jvm.internal.Intrinsics.e(r3, r4)
            r2.<init>(r3)
        L12:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.views.quickaccess.QuickAccessOrderMapper.<init>(android.content.Context, eu.bolt.driver.core.ui.translation.TranslatedResources, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
