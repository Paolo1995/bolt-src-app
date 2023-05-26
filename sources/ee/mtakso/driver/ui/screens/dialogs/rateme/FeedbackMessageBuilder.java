package ee.mtakso.driver.ui.screens.dialogs.rateme;

import android.content.Context;
import android.os.Build;
import ee.mtakso.driver.R;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedbackMessageBuilder.kt */
/* loaded from: classes3.dex */
public final class FeedbackMessageBuilder {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f28315d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f28316a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f28317b;

    /* renamed from: c  reason: collision with root package name */
    private final String f28318c;

    /* compiled from: FeedbackMessageBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FeedbackMessageBuilder(Context context, DriverProvider driverProvider) {
        Intrinsics.f(context, "context");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f28316a = context;
        this.f28317b = driverProvider;
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        String str4 = Build.PRODUCT;
        this.f28318c = str + " - " + str2 + " - " + str3 + " - " + str4;
    }

    public final String a() {
        DriverConfig m8 = this.f28317b.m();
        Context context = this.f28316a;
        StringBuilder sb = new StringBuilder();
        String string = context.getString(R.string.feedback_email_msg_support_country, m8.j());
        sb.append(string + "\n");
        String string2 = context.getString(R.string.feedback_email_msg_driver_id, String.valueOf(m8.t()));
        sb.append(string2 + "\n");
        String string3 = context.getString(R.string.feedback_email_msg_device, this.f28318c);
        sb.append(string3 + "\n");
        String string4 = context.getString(R.string.feedback_email_msg_app, "DA.58.0");
        sb.append(string4 + "\n");
        String string5 = context.getString(R.string.feedback_email_msg_os, Build.VERSION.RELEASE, String.valueOf(Build.VERSION.SDK_INT));
        sb.append(string5 + "\n");
        String string6 = context.getString(R.string.feedback_email_msg_feedback);
        sb.append(string6 + "\n");
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder()\n        …              .toString()");
        return sb2;
    }

    public final String b() {
        String string = this.f28316a.getString(R.string.feedback_email_title, this.f28317b.m().j());
        Intrinsics.e(string, "context.getString(\n     …entDriver().country\n    )");
        return string;
    }
}
