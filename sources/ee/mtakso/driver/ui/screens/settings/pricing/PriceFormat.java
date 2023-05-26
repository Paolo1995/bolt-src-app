package ee.mtakso.driver.ui.screens.settings.pricing;

import com.google.android.gms.common.api.Api;
import ee.mtakso.driver.ui.common.PriceFormatProvider;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriceFormat.kt */
/* loaded from: classes5.dex */
public final class PriceFormat {

    /* renamed from: a  reason: collision with root package name */
    private final DecimalFormat f33245a = PriceFormatProvider.f26337a.a();

    public final String a(BigDecimal number, Integer num) {
        Intrinsics.f(number, "number");
        DecimalFormat decimalFormat = this.f33245a;
        if (num != null) {
            int max = Math.max(1, num.intValue());
            decimalFormat.setMinimumFractionDigits(max);
            decimalFormat.setMaximumFractionDigits(max);
        } else {
            decimalFormat.setMinimumFractionDigits(0);
            decimalFormat.setMaximumFractionDigits(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }
        String format = decimalFormat.format(number);
        Intrinsics.e(format, "with(decimalFormat) {\n  …     format(number)\n    }");
        return format;
    }
}
