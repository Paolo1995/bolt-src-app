package ee.mtakso.driver.uikit.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.Api;
import ee.mtakso.driver.uikit.R$attr;
import ee.mtakso.driver.uikit.R$drawable;
import ee.mtakso.driver.uikit.R$styleable;
import ee.mtakso.driver.uikit.utils.Dimens;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: CodeInputView.kt */
/* loaded from: classes5.dex */
public final class CodeInputView extends AppCompatEditText {

    /* renamed from: w  reason: collision with root package name */
    public static final Companion f36085w = new Companion(null);

    /* renamed from: x  reason: collision with root package name */
    private static final CodeInputView$Companion$SELECTION_DISABLED$1 f36086x = new ActionMode.Callback() { // from class: ee.mtakso.driver.uikit.widgets.CodeInputView$Companion$SELECTION_DISABLED$1
        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Intrinsics.f(mode, "mode");
            Intrinsics.f(item, "item");
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            Intrinsics.f(mode, "mode");
            Intrinsics.f(menu, "menu");
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode mode) {
            Intrinsics.f(mode, "mode");
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            Intrinsics.f(mode, "mode");
            Intrinsics.f(menu, "menu");
            return false;
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private Drawable f36087l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f36088m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f36089n;

    /* renamed from: o  reason: collision with root package name */
    private final int f36090o;

    /* renamed from: p  reason: collision with root package name */
    private int f36091p;

    /* renamed from: q  reason: collision with root package name */
    private int f36092q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f36093r;

    /* renamed from: s  reason: collision with root package name */
    private int f36094s;

    /* renamed from: t  reason: collision with root package name */
    private final Rect f36095t;

    /* renamed from: u  reason: collision with root package name */
    private final Rect f36096u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f36097v;

    /* compiled from: CodeInputView.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeInputView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f36097v = new LinkedHashMap();
        this.f36090o = (int) Dimens.b(16.0f);
        this.f36094s = 10;
        this.f36095t = new Rect();
        this.f36096u = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.K);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr….styleable.CodeInputView)");
        try {
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.L, R$drawable.textfield_inactive);
            int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.N, R$drawable.textfield_focused);
            int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.M, R$drawable.textfield_error);
            this.f36088m = ContextCompat.getDrawable(context, resourceId);
            setFocusedDigitBgDrawable(ContextCompat.getDrawable(context, resourceId2));
            this.f36089n = ContextCompat.getDrawable(context, resourceId3);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private final void e(Canvas canvas, String str, Drawable drawable, Rect rect) {
        canvas.save();
        canvas.translate(rect.left, rect.top);
        drawable.draw(canvas);
        canvas.restore();
        if (str != null) {
            getPaint().getTextBounds(str, 0, str.length(), this.f36096u);
            canvas.drawText(str, rect.centerX() - (this.f36096u.width() * 0.5f), rect.centerY() + (this.f36096u.height() * 0.5f), getPaint());
        }
    }

    private final int f(CharSequence charSequence) {
        int g8;
        g8 = RangesKt___RangesKt.g(charSequence.length(), this.f36094s - 1);
        return g8;
    }

    private final String g(int i8) {
        CharSequence text = getText();
        if (text == null) {
            text = "";
        }
        if (i8 < text.length()) {
            return String.valueOf(text.charAt(i8));
        }
        return null;
    }

    private final Drawable i(int i8, int i9) {
        if (this.f36093r) {
            return this.f36089n;
        }
        if (i9 == i8) {
            return this.f36087l;
        }
        return this.f36088m;
    }

    private final int j(int i8, int i9) {
        return i8 == 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i9;
    }

    public final int getCodeInputFieldsCount() {
        return this.f36094s;
    }

    public final Drawable getFocusedDigitBgDrawable() {
        return this.f36087l;
    }

    public final boolean h() {
        return this.f36093r;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        CharSequence text = getText();
        if (text == null) {
            text = "";
        }
        int f8 = f(text);
        this.f36095t.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + this.f36091p, getPaddingTop() + this.f36092q);
        int i8 = this.f36094s;
        for (int i9 = 0; i9 < i8; i9++) {
            String g8 = g(i9);
            Drawable i10 = i(i9, f8);
            Intrinsics.c(i10);
            e(canvas, g8, i10, this.f36095t);
            this.f36095t.offset(this.f36090o + this.f36091p, 0);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setPadding(0, 0, 0, 0);
        setBackground(null);
        setInputType(2);
        setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.f36094s)});
        setCustomSelectionActionModeCallback(f36086x);
        setCursorVisible(false);
        setLongClickable(false);
        setLayoutDirection(0);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i8, int i9) {
        Number valueOf;
        Number valueOf2;
        float f8;
        int b8;
        float f9;
        int mode = View.MeasureSpec.getMode(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i8);
        int size2 = View.MeasureSpec.getSize(i9);
        if (mode != 1073741824) {
            b8 = MathKt__MathJVMKt.b(getPaint().measureText("0"));
            float b9 = (Dimens.b(16.0f) * 2) + b8;
            int i10 = this.f36094s;
            f9 = RangesKt___RangesKt.f(getPaddingLeft() + getPaddingRight() + (b9 * i10) + (this.f36090o * (i10 - 1)), j(mode, size));
            valueOf = Float.valueOf(f9);
        } else {
            valueOf = Integer.valueOf(size);
        }
        if (mode2 != 1073741824) {
            f8 = RangesKt___RangesKt.f(getPaddingTop() + getPaddingBottom() + (Dimens.b(12.0f) * 2) + getLineHeight(), j(mode2, size2));
            valueOf2 = Float.valueOf(f8);
        } else {
            valueOf2 = Integer.valueOf(size2);
        }
        setMeasuredDimension(valueOf.intValue(), valueOf2.intValue());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i12 = this.f36090o;
        int i13 = this.f36094s;
        this.f36091p = (i8 - (paddingLeft + (i12 * (i13 - 1)))) / i13;
        this.f36092q = (i9 - getPaddingTop()) - getPaddingBottom();
        Rect rect = new Rect(0, 0, this.f36091p, this.f36092q);
        Drawable drawable = this.f36089n;
        Intrinsics.c(drawable);
        drawable.setBounds(rect);
        Drawable drawable2 = this.f36087l;
        Intrinsics.c(drawable2);
        drawable2.setBounds(rect);
        Drawable drawable3 = this.f36088m;
        Intrinsics.c(drawable3);
        drawable3.setBounds(rect);
    }

    public final void setDigitCount(int i8) {
        if (i8 < 1) {
            return;
        }
        this.f36094s = i8;
        setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.f36094s)});
        this.f36091p = (getWidth() - ((getPaddingLeft() + getPaddingRight()) + (this.f36090o * (this.f36094s - 1)))) / this.f36094s;
        this.f36092q = (getHeight() - getPaddingTop()) - getPaddingBottom();
        Rect rect = new Rect(0, 0, this.f36091p, this.f36092q);
        Drawable drawable = this.f36089n;
        Intrinsics.c(drawable);
        drawable.setBounds(rect);
        Drawable drawable2 = this.f36087l;
        Intrinsics.c(drawable2);
        drawable2.setBounds(rect);
        Drawable drawable3 = this.f36088m;
        Intrinsics.c(drawable3);
        drawable3.setBounds(rect);
        invalidate();
    }

    public final void setError(boolean z7) {
        if (this.f36093r != z7) {
            this.f36093r = z7;
            invalidate();
        }
    }

    public final void setFocusedDigitBgDrawable(Drawable drawable) {
        this.f36087l = drawable;
        invalidate();
    }

    public /* synthetic */ CodeInputView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? R$attr.f35748z : i8);
    }
}
