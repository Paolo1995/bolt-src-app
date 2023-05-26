package ee.mtakso.driver.uikit.widgets.gridlayout;

/* compiled from: SpannedGridLayoutManager.kt */
/* loaded from: classes5.dex */
public final class InvalidMaxSpansException extends RuntimeException {
    public InvalidMaxSpansException(int i8) {
        super("Invalid layout spans: " + i8 + ". Span size must be at least 1.");
    }
}
