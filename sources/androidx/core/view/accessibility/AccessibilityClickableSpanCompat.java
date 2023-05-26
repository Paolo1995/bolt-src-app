package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {

    /* renamed from: f  reason: collision with root package name */
    private final int f6033f;

    /* renamed from: g  reason: collision with root package name */
    private final AccessibilityNodeInfoCompat f6034g;

    /* renamed from: h  reason: collision with root package name */
    private final int f6035h;

    public AccessibilityClickableSpanCompat(int i8, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i9) {
        this.f6033f = i8;
        this.f6034g = accessibilityNodeInfoCompat;
        this.f6035h = i9;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f6033f);
        this.f6034g.O(this.f6035h, bundle);
    }
}
