package ee.mtakso.driver.uicore.components.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.common.api.Api;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uicore.utils.Dimens;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpandableTextView.kt */
/* loaded from: classes5.dex */
public final class ExpandableTextView extends AppCompatTextView {

    /* renamed from: f  reason: collision with root package name */
    private int f35434f;

    /* renamed from: g  reason: collision with root package name */
    private float f35435g;

    /* renamed from: h  reason: collision with root package name */
    private float f35436h;

    /* renamed from: i  reason: collision with root package name */
    private int f35437i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f35438j;

    /* renamed from: k  reason: collision with root package name */
    private float f35439k;

    /* renamed from: l  reason: collision with root package name */
    private float f35440l;

    /* renamed from: m  reason: collision with root package name */
    private IconPlacement f35441m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f35442n;

    /* renamed from: o  reason: collision with root package name */
    private int f35443o;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f35444p;

    /* renamed from: q  reason: collision with root package name */
    private float f35445q;

    /* renamed from: r  reason: collision with root package name */
    private float f35446r;

    /* renamed from: s  reason: collision with root package name */
    private IconPlacement f35447s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f35448t;

    /* renamed from: u  reason: collision with root package name */
    private State f35449u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f35450v;

    /* compiled from: ExpandableTextView.kt */
    /* loaded from: classes5.dex */
    public enum IconPlacement {
        INLINE,
        NEW_LINE
    }

    /* compiled from: ExpandableTextView.kt */
    /* loaded from: classes5.dex */
    public enum State {
        EXPANDED,
        COLLAPSED
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35450v = new LinkedHashMap();
        this.f35434f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        IconPlacement iconPlacement = IconPlacement.INLINE;
        this.f35441m = iconPlacement;
        this.f35447s = iconPlacement;
        State state = State.EXPANDED;
        this.f35449u = state;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f34629e1);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…eable.ExpandableTextView)");
        this.f35434f = obtainStyledAttributes.getInt(R$styleable.f34649i1, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.f35449u = State.values()[obtainStyledAttributes.getInt(R$styleable.f34689q1, 0)];
        this.f35435g = obtainStyledAttributes.getDimension(R$styleable.f34664l1, 0.0f);
        this.f35436h = obtainStyledAttributes.getDimension(R$styleable.f34659k1, Dimens.d(10));
        this.f35438j = obtainStyledAttributes.getDrawable(R$styleable.f34634f1);
        this.f35437i = obtainStyledAttributes.getColor(R$styleable.f34644h1, 0);
        this.f35441m = IconPlacement.values()[obtainStyledAttributes.getInt(R$styleable.f34639g1, 0)];
        this.f35442n = obtainStyledAttributes.getString(R$styleable.f34654j1);
        this.f35444p = obtainStyledAttributes.getDrawable(R$styleable.f34669m1);
        this.f35443o = obtainStyledAttributes.getColor(R$styleable.f34679o1, 0);
        this.f35447s = IconPlacement.values()[obtainStyledAttributes.getInt(R$styleable.f34674n1, 0)];
        this.f35448t = obtainStyledAttributes.getString(R$styleable.f34684p1);
        obtainStyledAttributes.recycle();
        e();
        setText(this.f35448t);
        if (this.f35449u == State.COLLAPSED) {
            this.f35449u = state;
            f();
        }
    }

    private final void e() {
        float f8;
        float f9;
        float f10 = this.f35435g;
        if (f10 <= 0.0f) {
            f10 = getTextSize();
        }
        Drawable drawable = this.f35444p;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > intrinsicHeight) {
                f9 = intrinsicWidth;
            } else {
                f9 = intrinsicHeight;
            }
            float f11 = f10 / f9;
            this.f35445q = intrinsicHeight * f11;
            this.f35446r = intrinsicWidth * f11;
        } else {
            this.f35445q = 0.0f;
            this.f35446r = 0.0f;
        }
        Drawable drawable2 = this.f35438j;
        if (drawable2 != null) {
            int intrinsicWidth2 = drawable2.getIntrinsicWidth();
            int intrinsicHeight2 = drawable2.getIntrinsicHeight();
            if (intrinsicWidth2 > intrinsicHeight2) {
                f8 = intrinsicWidth2;
            } else {
                f8 = intrinsicHeight2;
            }
            float f12 = f10 / f8;
            this.f35439k = intrinsicHeight2 * f12;
            this.f35440l = intrinsicWidth2 * f12;
            return;
        }
        this.f35439k = 0.0f;
        this.f35440l = 0.0f;
    }

    public final void f() {
        setText(this.f35442n);
        if (this.f35449u == State.EXPANDED) {
            setMaxLines(this.f35434f);
            this.f35449u = State.COLLAPSED;
        }
    }

    public final void g() {
        setText(this.f35448t);
        if (this.f35449u == State.COLLAPSED) {
            setMaxLines(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f35449u = State.EXPANDED;
        }
    }

    public final Drawable getCollapseIcon() {
        return this.f35438j;
    }

    public final IconPlacement getCollapseIconPlacement() {
        return this.f35441m;
    }

    public final int getCollapseIconTint() {
        return this.f35437i;
    }

    public final int getCollapsedLines() {
        return this.f35434f;
    }

    public final CharSequence getCollapsedText() {
        return this.f35442n;
    }

    public final float getControlIconNewLinePadding() {
        return this.f35436h;
    }

    public final float getControlIconSize() {
        return this.f35435g;
    }

    public final Drawable getExpandIcon() {
        return this.f35444p;
    }

    public final IconPlacement getExpandIconPlacement() {
        return this.f35447s;
    }

    public final int getExpandIconTint() {
        return this.f35443o;
    }

    public final CharSequence getExpandedText() {
        return this.f35448t;
    }

    public final State getState() {
        return this.f35449u;
    }

    public final void h() {
        if (this.f35449u == State.EXPANDED) {
            f();
        } else {
            g();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i8;
        int textSize;
        int i9;
        int textSize2;
        Intrinsics.f(canvas, "canvas");
        super.onDraw(canvas);
        float textSize3 = getTextSize();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        State state = this.f35449u;
        boolean z7 = true;
        if (state == State.EXPANDED && this.f35438j != null) {
            if (this.f35441m == IconPlacement.NEW_LINE) {
                float f8 = measuredWidth;
                float f9 = this.f35440l;
                float f10 = 2;
                i9 = (int) ((f8 - f9) / f10);
                textSize2 = (int) (measuredHeight - this.f35439k);
                measuredWidth = (int) ((f8 + f9) / f10);
            } else {
                i9 = (int) (measuredWidth - this.f35440l);
                float f11 = this.f35439k;
                if (textSize3 != f11) {
                    z7 = false;
                }
                if (z7) {
                    textSize2 = (int) (measuredHeight - f11);
                } else {
                    float f12 = measuredHeight;
                    float f13 = 2;
                    textSize2 = (int) (f12 - ((getTextSize() + this.f35439k) / f13));
                    measuredHeight = (int) (f12 - ((getTextSize() - this.f35439k) / f13));
                }
            }
            Drawable drawable = this.f35438j;
            if (drawable != null) {
                drawable.invalidateSelf();
            }
            Drawable drawable2 = this.f35438j;
            if (drawable2 != null) {
                drawable2.setBounds(i9, textSize2, measuredWidth, measuredHeight);
            }
            Drawable drawable3 = this.f35438j;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
        } else if (state == State.COLLAPSED && this.f35444p != null) {
            if (this.f35447s == IconPlacement.NEW_LINE) {
                float f14 = measuredWidth;
                float f15 = this.f35446r;
                float f16 = 2;
                i8 = (int) ((f14 - f15) / f16);
                textSize = (int) (measuredHeight - this.f35445q);
                measuredWidth = (int) ((f14 + f15) / f16);
            } else {
                i8 = (int) (measuredWidth - this.f35446r);
                float f17 = this.f35445q;
                if (textSize3 != f17) {
                    z7 = false;
                }
                if (z7) {
                    textSize = (int) (measuredHeight - f17);
                } else {
                    float f18 = measuredHeight;
                    float f19 = 2;
                    textSize = (int) (f18 - ((getTextSize() + this.f35445q) / f19));
                    measuredHeight = (int) (f18 - ((getTextSize() - this.f35445q) / f19));
                }
            }
            Drawable drawable4 = this.f35444p;
            if (drawable4 != null) {
                drawable4.invalidateSelf();
            }
            Drawable drawable5 = this.f35444p;
            if (drawable5 != null) {
                drawable5.setBounds(i8, textSize, measuredWidth, measuredHeight);
            }
            Drawable drawable6 = this.f35444p;
            if (drawable6 != null) {
                drawable6.draw(canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        State state = this.f35449u;
        if (state == State.EXPANDED && this.f35441m == IconPlacement.NEW_LINE) {
            setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredHeight() + this.f35439k + this.f35436h));
        } else if (state == State.COLLAPSED && this.f35447s == IconPlacement.NEW_LINE) {
            setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredHeight() + this.f35445q));
        }
    }

    public final void setCollapseIcon(Drawable drawable) {
        this.f35438j = drawable;
        e();
        setCollapseIconTintColor(this.f35437i);
        if (this.f35449u == State.EXPANDED) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    public final void setCollapseIconPlacement(IconPlacement collapseIconPlacement) {
        Intrinsics.f(collapseIconPlacement, "collapseIconPlacement");
        this.f35441m = collapseIconPlacement;
        requestLayout();
    }

    public final void setCollapseIconRes(int i8) {
        setCollapseIcon(ContextCompat.getDrawable(getContext(), i8));
    }

    public final void setCollapseIconTintColor(int i8) {
        this.f35437i = i8;
        Drawable drawable = this.f35438j;
        if (drawable != null) {
            DrawableCompat.n(drawable, i8);
        }
        invalidate();
    }

    public final void setCollapseIconTintColorRes(int i8) {
        setCollapseIconTintColor(ContextCompat.getColor(getContext(), i8));
    }

    public final void setCollapsedText(CharSequence charSequence) {
        this.f35442n = charSequence;
        if (this.f35449u == State.COLLAPSED) {
            setText(charSequence);
        }
    }

    public final void setControlIconNewLinePadding(float f8) {
        this.f35436h = f8;
        requestLayout();
    }

    public final void setControlIconSize(float f8) {
        this.f35435g = f8;
        e();
        requestLayout();
    }

    public final void setExpandIcon(Drawable drawable) {
        this.f35444p = drawable;
        e();
        setExpandIconTintColor(this.f35437i);
        if (this.f35449u == State.COLLAPSED) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    public final void setExpandIconPlacement(IconPlacement expandIconPlacement) {
        Intrinsics.f(expandIconPlacement, "expandIconPlacement");
        this.f35447s = expandIconPlacement;
        requestLayout();
    }

    public final void setExpandIconRes(int i8) {
        setExpandIcon(ContextCompat.getDrawable(getContext(), i8));
    }

    public final void setExpandIconTintColor(int i8) {
        this.f35443o = i8;
        Drawable drawable = this.f35444p;
        if (drawable != null) {
            DrawableCompat.n(drawable, i8);
        }
        invalidate();
    }

    public final void setExpandIconTintColorRes(int i8) {
        setExpandIconTintColor(ContextCompat.getColor(getContext(), i8));
    }

    public final void setExpandedText(CharSequence charSequence) {
        this.f35448t = charSequence;
        if (this.f35449u == State.EXPANDED) {
            setText(charSequence);
        }
    }

    public final void setMaxCollapsedLines(int i8) {
        this.f35434f = i8;
        if (this.f35449u == State.COLLAPSED) {
            setMaxLines(i8);
        }
        invalidate();
    }

    public /* synthetic */ ExpandableTextView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 16842884 : i8);
    }
}
