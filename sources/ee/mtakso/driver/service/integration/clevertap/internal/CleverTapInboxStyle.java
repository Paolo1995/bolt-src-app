package ee.mtakso.driver.service.integration.clevertap.internal;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import ee.mtakso.driver.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CleverTapInboxStyle.kt */
/* loaded from: classes3.dex */
public final class CleverTapInboxStyle {

    /* renamed from: a  reason: collision with root package name */
    public static final CleverTapInboxStyle f24577a = new CleverTapInboxStyle();

    private CleverTapInboxStyle() {
    }

    public static final CTInboxStyleConfig a(Context context) {
        Intrinsics.f(context, "context");
        CTInboxStyleConfig cTInboxStyleConfig = new CTInboxStyleConfig();
        CleverTapInboxStyle cleverTapInboxStyle = f24577a;
        cTInboxStyleConfig.s(cleverTapInboxStyle.b(context, R.color.neutral900));
        cTInboxStyleConfig.u(cleverTapInboxStyle.b(context, R.color.white));
        cTInboxStyleConfig.q(cleverTapInboxStyle.b(context, R.color.white));
        cTInboxStyleConfig.r(cleverTapInboxStyle.b(context, R.color.white));
        cTInboxStyleConfig.x(cleverTapInboxStyle.b(context, R.color.neutral900));
        cTInboxStyleConfig.t(context.getString(R.string.bolt_news));
        cTInboxStyleConfig.v(context.getString(R.string.no_news));
        return cTInboxStyleConfig;
    }

    private final String b(Context context, int i8) {
        String hexString = Integer.toHexString(ContextCompat.getColor(context, i8));
        return "#" + hexString;
    }
}
