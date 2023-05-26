package ee.mtakso.driver.uikit.widgets.gridlayout;

/* compiled from: SpannedGridLayoutManager.kt */
/* loaded from: classes5.dex */
public final class InvalidSpanSizeException extends RuntimeException {
    public InvalidSpanSizeException(int i8, int i9) {
        super("Invalid item span size: " + i8 + ". Span size must be in the range: (1..." + i9 + ")");
    }
}
