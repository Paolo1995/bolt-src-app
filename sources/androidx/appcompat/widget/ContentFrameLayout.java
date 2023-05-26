package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: f  reason: collision with root package name */
    private TypedValue f1960f;

    /* renamed from: g  reason: collision with root package name */
    private TypedValue f1961g;

    /* renamed from: h  reason: collision with root package name */
    private TypedValue f1962h;

    /* renamed from: i  reason: collision with root package name */
    private TypedValue f1963i;

    /* renamed from: j  reason: collision with root package name */
    private TypedValue f1964j;

    /* renamed from: k  reason: collision with root package name */
    private TypedValue f1965k;

    /* renamed from: l  reason: collision with root package name */
    private final Rect f1966l;

    /* renamed from: m  reason: collision with root package name */
    private OnAttachListener f1967m;

    /* loaded from: classes.dex */
    public interface OnAttachListener {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public void a(int i8, int i9, int i10, int i11) {
        this.f1966l.set(i8, i9, i10, i11);
        if (ViewCompat.W(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1964j == null) {
            this.f1964j = new TypedValue();
        }
        return this.f1964j;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1965k == null) {
            this.f1965k = new TypedValue();
        }
        return this.f1965k;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1962h == null) {
            this.f1962h = new TypedValue();
        }
        return this.f1962h;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1963i == null) {
            this.f1963i = new TypedValue();
        }
        return this.f1963i;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1960f == null) {
            this.f1960f = new TypedValue();
        }
        return this.f1960f;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1961g == null) {
            this.f1961g = new TypedValue();
        }
        return this.f1961g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener onAttachListener = this.f1967m;
        if (onAttachListener != null) {
            onAttachListener.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.f1967m;
        if (onAttachListener != null) {
            onAttachListener.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.f1967m = onAttachListener;
    }

    public ContentFrameLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f1966l = new Rect();
    }
}
