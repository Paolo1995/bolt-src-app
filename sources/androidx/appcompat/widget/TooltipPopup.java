package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

/* loaded from: classes.dex */
class TooltipPopup {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2277a;

    /* renamed from: b  reason: collision with root package name */
    private final View f2278b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f2279c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f2280d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f2281e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f2282f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f2283g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TooltipPopup(@NonNull Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f2280d = layoutParams;
        this.f2281e = new Rect();
        this.f2282f = new int[2];
        this.f2283g = new int[2];
        this.f2277a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.f935s, (ViewGroup) null);
        this.f2278b = inflate;
        this.f2279c = (TextView) inflate.findViewById(R$id.f909s);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.f951a;
        layoutParams.flags = 24;
    }

    private void a(View view, int i8, int i9, boolean z7, WindowManager.LayoutParams layoutParams) {
        int height;
        int i10;
        int i11;
        int i12;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f2277a.getResources().getDimensionPixelOffset(R$dimen.f862m);
        if (view.getWidth() < dimensionPixelOffset) {
            i8 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f2277a.getResources().getDimensionPixelOffset(R$dimen.f861l);
            height = i9 + dimensionPixelOffset2;
            i10 = i9 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i10 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = this.f2277a.getResources();
        if (z7) {
            i11 = R$dimen.f864o;
        } else {
            i11 = R$dimen.f863n;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i11);
        View b8 = b(view);
        if (b8 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b8.getWindowVisibleDisplayFrame(this.f2281e);
        Rect rect = this.f2281e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources2 = this.f2277a.getResources();
            int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                i12 = resources2.getDimensionPixelSize(identifier);
            } else {
                i12 = 0;
            }
            DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
            this.f2281e.set(0, i12, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b8.getLocationOnScreen(this.f2283g);
        view.getLocationOnScreen(this.f2282f);
        int[] iArr = this.f2282f;
        int i13 = iArr[0];
        int[] iArr2 = this.f2283g;
        int i14 = i13 - iArr2[0];
        iArr[0] = i14;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i14 + i8) - (b8.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f2278b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f2278b.getMeasuredHeight();
        int i15 = this.f2282f[1];
        int i16 = ((i10 + i15) - dimensionPixelOffset3) - measuredHeight;
        int i17 = i15 + height + dimensionPixelOffset3;
        if (z7) {
            if (i16 >= 0) {
                layoutParams.y = i16;
            } else {
                layoutParams.y = i17;
            }
        } else if (measuredHeight + i17 <= this.f2281e.height()) {
            layoutParams.y = i17;
        } else {
            layoutParams.y = i16;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (!d()) {
            return;
        }
        ((WindowManager) this.f2277a.getSystemService("window")).removeView(this.f2278b);
    }

    boolean d() {
        if (this.f2278b.getParent() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view, int i8, int i9, boolean z7, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f2279c.setText(charSequence);
        a(view, i8, i9, z7, this.f2280d);
        ((WindowManager) this.f2277a.getSystemService("window")).addView(this.f2278b, this.f2280d);
    }
}
