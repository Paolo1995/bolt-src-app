package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {

    /* renamed from: f  reason: collision with root package name */
    private TextView f14196f;

    /* renamed from: g  reason: collision with root package name */
    private Button f14197g;

    /* renamed from: h  reason: collision with root package name */
    private final TimeInterpolator f14198h;

    /* renamed from: i  reason: collision with root package name */
    private int f14199i;

    public SnackbarContentLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14198h = MotionUtils.g(context, R$attr.motionEasingEmphasizedInterpolator, AnimationUtils.f12721b);
    }

    private static void d(@NonNull View view, int i8, int i9) {
        if (ViewCompat.Y(view)) {
            ViewCompat.H0(view, ViewCompat.J(view), i8, ViewCompat.I(view), i9);
        } else {
            view.setPadding(view.getPaddingLeft(), i8, view.getPaddingRight(), i9);
        }
    }

    private boolean e(int i8, int i9, int i10) {
        boolean z7;
        if (i8 != getOrientation()) {
            setOrientation(i8);
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f14196f.getPaddingTop() == i9 && this.f14196f.getPaddingBottom() == i10) {
            return z7;
        }
        d(this.f14196f, i9, i10);
        return true;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void a(int i8, int i9) {
        this.f14196f.setAlpha(0.0f);
        long j8 = i9;
        long j9 = i8;
        this.f14196f.animate().alpha(1.0f).setDuration(j8).setInterpolator(this.f14198h).setStartDelay(j9).start();
        if (this.f14197g.getVisibility() == 0) {
            this.f14197g.setAlpha(0.0f);
            this.f14197g.animate().alpha(1.0f).setDuration(j8).setInterpolator(this.f14198h).setStartDelay(j9).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void b(int i8, int i9) {
        this.f14196f.setAlpha(1.0f);
        long j8 = i9;
        long j9 = i8;
        this.f14196f.animate().alpha(0.0f).setDuration(j8).setInterpolator(this.f14198h).setStartDelay(j9).start();
        if (this.f14197g.getVisibility() == 0) {
            this.f14197g.setAlpha(1.0f);
            this.f14197g.animate().alpha(0.0f).setDuration(j8).setInterpolator(this.f14198h).setStartDelay(j9).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f8) {
        if (f8 != 1.0f) {
            this.f14197g.setTextColor(MaterialColors.j(MaterialColors.d(this, R$attr.colorSurface), this.f14197g.getCurrentTextColor(), f8));
        }
    }

    public Button getActionView() {
        return this.f14197g;
    }

    public TextView getMessageView() {
        return this.f14196f;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f14196f = (TextView) findViewById(R$id.snackbar_text);
        this.f14197g = (Button) findViewById(R$id.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
        if (e(1, r0, r0 - r2) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
        if (e(0, r0, r0) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
        if (r1 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
        super.onMeasure(r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.getOrientation()
            r1 = 1
            if (r0 != r1) goto Lb
            return
        Lb:
            android.content.res.Resources r0 = r7.getResources()
            int r2 = com.google.android.material.R$dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r2)
            android.content.res.Resources r2 = r7.getResources()
            int r3 = com.google.android.material.R$dimen.design_snackbar_padding_vertical
            int r2 = r2.getDimensionPixelSize(r3)
            android.widget.TextView r3 = r7.f14196f
            android.text.Layout r3 = r3.getLayout()
            r4 = 0
            if (r3 == 0) goto L30
            int r3 = r3.getLineCount()
            if (r3 <= r1) goto L30
            r3 = 1
            goto L31
        L30:
            r3 = 0
        L31:
            if (r3 == 0) goto L4a
            int r5 = r7.f14199i
            if (r5 <= 0) goto L4a
            android.widget.Button r5 = r7.f14197g
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f14199i
            if (r5 <= r6) goto L4a
            int r2 = r0 - r2
            boolean r0 = r7.e(r1, r0, r2)
            if (r0 == 0) goto L55
            goto L56
        L4a:
            if (r3 == 0) goto L4d
            goto L4e
        L4d:
            r0 = r2
        L4e:
            boolean r0 = r7.e(r4, r0, r0)
            if (r0 == 0) goto L55
            goto L56
        L55:
            r1 = 0
        L56:
            if (r1 == 0) goto L5b
            super.onMeasure(r8, r9)
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i8) {
        this.f14199i = i8;
    }
}
