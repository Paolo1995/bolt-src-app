package ee.mtakso.driver.ui.common;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/* compiled from: PriceFormatProvider.kt */
/* loaded from: classes3.dex */
public final class PriceFormatProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final PriceFormatProvider f26337a = new PriceFormatProvider();

    private PriceFormatProvider() {
    }

    public final DecimalFormat a() {
        DecimalFormat decimalFormat = new DecimalFormat();
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(',');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat;
    }
}
