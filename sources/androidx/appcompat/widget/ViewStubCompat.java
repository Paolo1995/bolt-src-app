package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: f  reason: collision with root package name */
    private int f2286f;

    /* renamed from: g  reason: collision with root package name */
    private int f2287g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<View> f2288h;

    /* renamed from: i  reason: collision with root package name */
    private LayoutInflater f2289i;

    /* renamed from: j  reason: collision with root package name */
    private OnInflateListener f2290j;

    /* loaded from: classes.dex */
    public interface OnInflateListener {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View a() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            if (this.f2286f != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                LayoutInflater layoutInflater = this.f2289i;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from(getContext());
                }
                View inflate = layoutInflater.inflate(this.f2286f, viewGroup, false);
                int i8 = this.f2287g;
                if (i8 != -1) {
                    inflate.setId(i8);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.f2288h = new WeakReference<>(inflate);
                OnInflateListener onInflateListener = this.f2290j;
                if (onInflateListener != null) {
                    onInflateListener.a(this, inflate);
                }
                return inflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f2287g;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f2289i;
    }

    public int getLayoutResource() {
        return this.f2286f;
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i8) {
        this.f2287g = i8;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2289i = layoutInflater;
    }

    public void setLayoutResource(int i8) {
        this.f2286f = i8;
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.f2290j = onInflateListener;
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        WeakReference<View> weakReference = this.f2288h;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i8);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i8);
        if (i8 == 0 || i8 == 4) {
            a();
        }
    }

    public ViewStubCompat(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f2286f = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Q3, i8, 0);
        this.f2287g = obtainStyledAttributes.getResourceId(R$styleable.T3, -1);
        this.f2286f = obtainStyledAttributes.getResourceId(R$styleable.S3, 0);
        setId(obtainStyledAttributes.getResourceId(R$styleable.R3, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
