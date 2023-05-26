package ee.mtakso.driver.ui.screens.home.v3.delegate;

import android.media.Ringtone;
import android.media.RingtoneManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.OrderCompletionReason;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.PastOrderDetails;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.common.dialog.NotificationWithIconDialog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CancelledOrderDialogDelegate.kt */
/* loaded from: classes3.dex */
public final class CancelledOrderDialogDelegate {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f29859b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DefaultDialogCallback f29860a = new DefaultDialogCallback();

    /* compiled from: CancelledOrderDialogDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CancelledOrderDialogDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Message {

        /* renamed from: a  reason: collision with root package name */
        private final String f29861a;

        /* renamed from: b  reason: collision with root package name */
        private final String f29862b;

        public Message(String title, String description) {
            Intrinsics.f(title, "title");
            Intrinsics.f(description, "description");
            this.f29861a = title;
            this.f29862b = description;
        }

        public final String a() {
            return this.f29861a;
        }

        public final String b() {
            return this.f29862b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Message) {
                Message message = (Message) obj;
                return Intrinsics.a(this.f29861a, message.f29861a) && Intrinsics.a(this.f29862b, message.f29862b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f29861a.hashCode() * 31) + this.f29862b.hashCode();
        }

        public String toString() {
            String str = this.f29861a;
            String str2 = this.f29862b;
            return "Message(title=" + str + ", description=" + str2 + ")";
        }
    }

    /* compiled from: CancelledOrderDialogDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29863a;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_REJECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderState.ORDER_STATE_CLIENT_CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderState.ORDER_STATE_PAYMENT_BOOKING_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29863a = iArr;
        }
    }

    public final void a(Fragment fragment) {
        Intrinsics.f(fragment, "fragment");
        BaseDialogFragment.f41026i.a(fragment.requireActivity().getSupportFragmentManager(), "terminated_order", this.f29860a);
    }

    public final void b(Fragment fragment, OrderDetails orderDetails) {
        PastOrderDetails pastOrderDetails;
        OrderState b8;
        Message message;
        OrderCompletionReason e8;
        OrderCompletionReason e9;
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(orderDetails, "orderDetails");
        OrderCompletionReason.DisplayMessage displayMessage = null;
        if (orderDetails instanceof PastOrderDetails) {
            pastOrderDetails = (PastOrderDetails) orderDetails;
        } else {
            pastOrderDetails = null;
        }
        if (pastOrderDetails == null || (e9 = pastOrderDetails.e()) == null || (b8 = e9.b()) == null) {
            b8 = orderDetails.b();
        }
        if (pastOrderDetails != null && (e8 = pastOrderDetails.e()) != null) {
            displayMessage = e8.a();
        }
        if (displayMessage != null) {
            String b9 = displayMessage.b();
            String a8 = displayMessage.a();
            if (a8 == null) {
                a8 = "";
            }
            message = new Message(b9, a8);
        } else {
            int i8 = WhenMappings.f29863a[b8.ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        String string = fragment.getString(R.string.order_cancelled_title);
                        Intrinsics.e(string, "fragment.getString(R.string.order_cancelled_title)");
                        String string2 = fragment.getString(R.string.ride_cancelled_description);
                        Intrinsics.e(string2, "fragment.getString(R.str…de_cancelled_description)");
                        message = new Message(string, string2);
                    } else {
                        String string3 = fragment.getString(R.string.order_cancelled_title);
                        Intrinsics.e(string3, "fragment.getString(R.string.order_cancelled_title)");
                        String string4 = fragment.getString(R.string.order_cancelled_payment_payment_failed_desc);
                        Intrinsics.e(string4, "fragment.getString(R.str…ment_payment_failed_desc)");
                        message = new Message(string3, string4);
                    }
                } else {
                    String string5 = fragment.getString(R.string.order_cancelled_title);
                    Intrinsics.e(string5, "fragment.getString(R.string.order_cancelled_title)");
                    String string6 = fragment.getString(R.string.order_cancelled_by_client);
                    Intrinsics.e(string6, "fragment.getString(R.str…rder_cancelled_by_client)");
                    message = new Message(string5, string6);
                }
            } else {
                return;
            }
        }
        String a9 = message.a();
        String b10 = message.b();
        NotificationWithIconDialog.Companion companion = NotificationWithIconDialog.f41101m;
        String string7 = fragment.getString(R.string.ok_lowercase);
        Intrinsics.e(string7, "fragment.getString(R.string.ok_lowercase)");
        NotificationWithIconDialog a10 = companion.a(R.drawable.ic_warning_yellow, a9, b10, string7, this.f29860a);
        Ringtone ringtone = RingtoneManager.getRingtone(fragment.requireContext(), RingtoneManager.getDefaultUri(2));
        if (ringtone != null) {
            ringtone.play();
        }
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.e(requireActivity, "fragment.requireActivity()");
        FragmentUtils.c(a10, requireActivity, "terminated_order");
    }
}
