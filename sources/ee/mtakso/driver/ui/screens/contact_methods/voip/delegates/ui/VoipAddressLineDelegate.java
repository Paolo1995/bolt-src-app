package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.ui;

import android.content.Context;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: VoipAddressLineDelegate.kt */
/* loaded from: classes3.dex */
public final class VoipAddressLineDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Context f27985a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f27986b;

    public VoipAddressLineDelegate(Context context, TextView addressTextView) {
        Intrinsics.f(context, "context");
        Intrinsics.f(addressTextView, "addressTextView");
        this.f27985a = context;
        this.f27986b = addressTextView;
    }

    private final String a(long j8) {
        if (j8 > 60) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            String format = String.format("%s %s", Arrays.copyOf(new Object[]{Long.valueOf(TimeUnit.SECONDS.toMinutes(j8)), this.f27985a.getString(R.string.minutes)}, 2));
            Intrinsics.e(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f51021a;
        String format2 = String.format("<1 %s", Arrays.copyOf(new Object[]{this.f27985a.getString(R.string.minutes)}, 1));
        Intrinsics.e(format2, "format(format, *args)");
        return format2;
    }

    private final String b(String str, Long l8) {
        if (str == null && l8 == null) {
            return "";
        }
        if (l8 != null && l8.longValue() >= 1) {
            String string = this.f27985a.getString(R.string.dot_separator);
            Intrinsics.e(string, "context.getString(R.string.dot_separator)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            String format = String.format("%1$s %2$s %3$s", Arrays.copyOf(new Object[]{str, string, a(l8.longValue())}, 3));
            Intrinsics.e(format, "format(format, *args)");
            return format;
        }
        Intrinsics.d(str, "null cannot be cast to non-null type kotlin.String");
        return str;
    }

    public final void c(String str, Long l8) {
        boolean z7;
        this.f27986b.setText(b(str, l8));
        TextView textView = this.f27986b;
        if (str != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(textView, z7, 0, 2, null);
    }
}
