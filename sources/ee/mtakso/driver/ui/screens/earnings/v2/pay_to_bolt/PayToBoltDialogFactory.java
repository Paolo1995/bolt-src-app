package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayToBoltDialogFactory.kt */
/* loaded from: classes3.dex */
public final class PayToBoltDialogFactory {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f28619b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f28620a;

    /* compiled from: PayToBoltDialogFactory.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PayToBoltDialogFactory.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        SUCCESS,
        FAILURE
    }

    /* compiled from: PayToBoltDialogFactory.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28624a;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f28624a = iArr;
        }
    }

    public PayToBoltDialogFactory(Context context) {
        Intrinsics.f(context, "context");
        this.f28620a = context;
    }

    private final String b(int i8) {
        String string = this.f28620a.getString(i8);
        Intrinsics.e(string, "context.getString(stringRes)");
        return string;
    }

    public final NotificationDialog a(Type type, Function3<? super DialogFragment, ? super View, Object, Unit> dismissListener) {
        Intrinsics.f(type, "type");
        Intrinsics.f(dismissListener, "dismissListener");
        int i8 = WhenMappings.f28624a[type.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return NotificationDialog.Companion.d(NotificationDialog.f28313n, b(R.string.debt_payment_fail_title), b(R.string.debt_payment_fail_message), b(R.string.ok_lowercase), null, dismissListener, 8, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        return NotificationDialog.f28313n.g(b(R.string.debt_payment_ok_title), b(R.string.debt_payment_ok_message), b(R.string.ok_lowercase), dismissListener);
    }

    public final void c(FragmentManager fragmentManager, Function3<? super DialogFragment, ? super View, Object, Unit> dismissListener) {
        NotificationDialog notificationDialog;
        Intrinsics.f(fragmentManager, "fragmentManager");
        Intrinsics.f(dismissListener, "dismissListener");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("PayToBoltDialog");
        if (findFragmentByTag instanceof NotificationDialog) {
            notificationDialog = (NotificationDialog) findFragmentByTag;
        } else {
            notificationDialog = null;
        }
        if (notificationDialog == null) {
            return;
        }
        notificationDialog.K(dismissListener);
    }
}
