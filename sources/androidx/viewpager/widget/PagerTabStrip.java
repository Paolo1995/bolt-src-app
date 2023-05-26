package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private int A;
    private final Paint B;
    private final Rect C;
    private int D;
    private boolean E;
    private boolean F;
    private int G;
    private boolean H;
    private float I;
    private float J;
    private int K;

    /* renamed from: v  reason: collision with root package name */
    private int f8027v;

    /* renamed from: w  reason: collision with root package name */
    private int f8028w;

    /* renamed from: x  reason: collision with root package name */
    private int f8029x;

    /* renamed from: y  reason: collision with root package name */
    private int f8030y;

    /* renamed from: z  reason: collision with root package name */
    private int f8031z;

    public PagerTabStrip(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.B = paint;
        this.C = new Rect();
        this.D = 255;
        this.E = false;
        this.F = false;
        int i8 = this.f8049s;
        this.f8027v = i8;
        paint.setColor(i8);
        float f8 = context.getResources().getDisplayMetrics().density;
        this.f8028w = (int) ((3.0f * f8) + 0.5f);
        this.f8029x = (int) ((6.0f * f8) + 0.5f);
        this.f8030y = (int) (64.0f * f8);
        this.A = (int) ((16.0f * f8) + 0.5f);
        this.G = (int) ((1.0f * f8) + 0.5f);
        this.f8031z = (int) ((f8 * 32.0f) + 0.5f);
        this.K = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f8037g.setFocusable(true);
        this.f8037g.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewPager viewPager = PagerTabStrip.this.f8036f;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
        this.f8039i.setFocusable(true);
        this.f8039i.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewPager viewPager = PagerTabStrip.this.f8036f;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.E = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void d(int i8, float f8, boolean z7) {
        Rect rect = this.C;
        int height = getHeight();
        int left = this.f8038h.getLeft() - this.A;
        int right = this.f8038h.getRight() + this.A;
        int i9 = height - this.f8028w;
        rect.set(left, i9, right, height);
        super.d(i8, f8, z7);
        this.D = (int) (Math.abs(f8 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f8038h.getLeft() - this.A, i9, this.f8038h.getRight() + this.A, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f8031z);
    }

    public int getTabIndicatorColor() {
        return this.f8027v;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f8038h.getLeft() - this.A;
        int right = this.f8038h.getRight() + this.A;
        this.B.setColor((this.D << 24) | (this.f8027v & 16777215));
        float f8 = height;
        canvas.drawRect(left, height - this.f8028w, right, f8, this.B);
        if (this.E) {
            this.B.setColor((-16777216) | (this.f8027v & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.G, getWidth() - getPaddingRight(), f8, this.B);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.H) {
            return false;
        }
        float x7 = motionEvent.getX();
        float y7 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (Math.abs(x7 - this.I) > this.K || Math.abs(y7 - this.J) > this.K)) {
                    this.H = true;
                }
            } else if (x7 < this.f8038h.getLeft() - this.A) {
                ViewPager viewPager = this.f8036f;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            } else if (x7 > this.f8038h.getRight() + this.A) {
                ViewPager viewPager2 = this.f8036f;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        } else {
            this.I = x7;
            this.J = y7;
            this.H = false;
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        boolean z7;
        super.setBackgroundColor(i8);
        if (!this.F) {
            if ((i8 & (-16777216)) == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.E = z7;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        boolean z7;
        super.setBackgroundDrawable(drawable);
        if (!this.F) {
            if (drawable == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.E = z7;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i8) {
        boolean z7;
        super.setBackgroundResource(i8);
        if (!this.F) {
            if (i8 == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.E = z7;
        }
    }

    public void setDrawFullUnderline(boolean z7) {
        this.E = z7;
        this.F = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i8, int i9, int i10, int i11) {
        int i12 = this.f8029x;
        if (i11 < i12) {
            i11 = i12;
        }
        super.setPadding(i8, i9, i10, i11);
    }

    public void setTabIndicatorColor(int i8) {
        this.f8027v = i8;
        this.B.setColor(i8);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i8) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i8));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i8) {
        int i9 = this.f8030y;
        if (i8 < i9) {
            i8 = i9;
        }
        super.setTextSpacing(i8);
    }
}
