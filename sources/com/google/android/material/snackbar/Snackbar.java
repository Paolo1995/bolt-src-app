package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] I;
    private static final int[] J;
    private final AccessibilityManager G;
    private boolean H;

    /* loaded from: classes.dex */
    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        /* renamed from: c */
        public void a(Snackbar snackbar, int i8) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        /* renamed from: d */
        public void b(Snackbar snackbar) {
        }
    }

    /* loaded from: classes.dex */
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        public void onMeasure(int i8, int i9) {
            super.onMeasure(i8, i9);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), Pow2.MAX_POW2));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    static {
        int i8 = R$attr.snackbarButtonStyle;
        I = new int[]{i8};
        J = new int[]{i8, R$attr.snackbarTextViewStyle};
    }

    private Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        super(context, viewGroup, view, contentViewCallback);
        this.G = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    private static ViewGroup n0(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private Button o0() {
        return p0().getActionView();
    }

    private SnackbarContentLayout p0() {
        return (SnackbarContentLayout) this.f14143i.getChildAt(0);
    }

    private TextView q0() {
        return p0().getMessageView();
    }

    private static boolean r0(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(J);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        if (resourceId == -1 || resourceId2 == -1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        B(1);
    }

    @NonNull
    public static Snackbar t0(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i8) {
        return w0(context, view, charSequence, i8);
    }

    @NonNull
    public static Snackbar u0(@NonNull View view, int i8, int i9) {
        return v0(view, view.getResources().getText(i8), i9);
    }

    @NonNull
    public static Snackbar v0(@NonNull View view, @NonNull CharSequence charSequence, int i8) {
        return w0(null, view, charSequence, i8);
    }

    @NonNull
    private static Snackbar w0(Context context, @NonNull View view, @NonNull CharSequence charSequence, int i8) {
        int i9;
        ViewGroup n02 = n0(view);
        if (n02 != null) {
            if (context == null) {
                context = n02.getContext();
            }
            LayoutInflater from = LayoutInflater.from(context);
            if (r0(context)) {
                i9 = R$layout.mtrl_layout_snackbar_include;
            } else {
                i9 = R$layout.design_layout_snackbar_include;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(i9, n02, false);
            Snackbar snackbar = new Snackbar(context, n02, snackbarContentLayout, snackbarContentLayout);
            snackbar.y0(charSequence);
            snackbar.a0(i8);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void A() {
        super.A();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int E() {
        int i8;
        int recommendedTimeoutMillis;
        int E = super.E();
        if (E == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.H) {
                i8 = 4;
            } else {
                i8 = 0;
            }
            recommendedTimeoutMillis = this.G.getRecommendedTimeoutMillis(E, i8 | 1 | 2);
            return recommendedTimeoutMillis;
        } else if (this.H && this.G.isTouchExplorationEnabled()) {
            return -2;
        } else {
            return E;
        }
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean O() {
        return super.O();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void e0() {
        super.e0();
    }

    @NonNull
    public Snackbar x0(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button o02 = o0();
        if (!TextUtils.isEmpty(charSequence) && onClickListener != null) {
            this.H = true;
            o02.setVisibility(0);
            o02.setText(charSequence);
            o02.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.snackbar.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Snackbar.this.s0(onClickListener, view);
                }
            });
        } else {
            o02.setVisibility(8);
            o02.setOnClickListener(null);
            this.H = false;
        }
        return this;
    }

    @NonNull
    public Snackbar y0(@NonNull CharSequence charSequence) {
        q0().setText(charSequence);
        return this;
    }
}
