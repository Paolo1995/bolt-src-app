package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jctools.util.Pow2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FlexboxHelper {

    /* renamed from: a  reason: collision with root package name */
    private final FlexContainer f12387a;

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f12388b;

    /* renamed from: c  reason: collision with root package name */
    int[] f12389c;

    /* renamed from: d  reason: collision with root package name */
    long[] f12390d;

    /* renamed from: e  reason: collision with root package name */
    private long[] f12391e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FlexLinesResult {

        /* renamed from: a  reason: collision with root package name */
        List<FlexLine> f12392a;

        /* renamed from: b  reason: collision with root package name */
        int f12393b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            this.f12392a = null;
            this.f12393b = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Order implements Comparable<Order> {

        /* renamed from: f  reason: collision with root package name */
        int f12394f;

        /* renamed from: g  reason: collision with root package name */
        int f12395g;

        private Order() {
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull Order order) {
            int i8 = this.f12395g;
            int i9 = order.f12395g;
            if (i8 != i9) {
                return i8 - i9;
            }
            return this.f12394f - order.f12394f;
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.f12395g + ", index=" + this.f12394f + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlexboxHelper(FlexContainer flexContainer) {
        this.f12387a = flexContainer;
    }

    private int A(int i8, FlexItem flexItem, int i9) {
        FlexContainer flexContainer = this.f12387a;
        int c8 = flexContainer.c(i8, flexContainer.getPaddingLeft() + this.f12387a.getPaddingRight() + flexItem.G0() + flexItem.Z0() + i9, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(c8);
        if (size > flexItem.c0()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.c0(), View.MeasureSpec.getMode(c8));
        }
        if (size < flexItem.w()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.w(), View.MeasureSpec.getMode(c8));
        }
        return c8;
    }

    private int B(FlexItem flexItem, boolean z7) {
        if (z7) {
            return flexItem.D0();
        }
        return flexItem.Z0();
    }

    private int C(FlexItem flexItem, boolean z7) {
        if (z7) {
            return flexItem.Z0();
        }
        return flexItem.D0();
    }

    private int D(FlexItem flexItem, boolean z7) {
        if (z7) {
            return flexItem.y();
        }
        return flexItem.G0();
    }

    private int E(FlexItem flexItem, boolean z7) {
        if (z7) {
            return flexItem.G0();
        }
        return flexItem.y();
    }

    private int F(FlexItem flexItem, boolean z7) {
        if (z7) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    private int G(FlexItem flexItem, boolean z7) {
        if (z7) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    private int H(boolean z7) {
        if (z7) {
            return this.f12387a.getPaddingBottom();
        }
        return this.f12387a.getPaddingEnd();
    }

    private int I(boolean z7) {
        if (z7) {
            return this.f12387a.getPaddingEnd();
        }
        return this.f12387a.getPaddingBottom();
    }

    private int J(boolean z7) {
        if (z7) {
            return this.f12387a.getPaddingTop();
        }
        return this.f12387a.getPaddingStart();
    }

    private int K(boolean z7) {
        if (z7) {
            return this.f12387a.getPaddingStart();
        }
        return this.f12387a.getPaddingTop();
    }

    private int L(View view, boolean z7) {
        if (z7) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int M(View view, boolean z7) {
        if (z7) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private boolean N(int i8, int i9, FlexLine flexLine) {
        if (i8 == i9 - 1 && flexLine.c() != 0) {
            return true;
        }
        return false;
    }

    private boolean P(View view, int i8, int i9, int i10, int i11, FlexItem flexItem, int i12, int i13, int i14) {
        if (this.f12387a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.Z()) {
            return true;
        }
        if (i8 == 0) {
            return false;
        }
        int maxLine = this.f12387a.getMaxLine();
        if (maxLine != -1 && maxLine <= i14 + 1) {
            return false;
        }
        int k8 = this.f12387a.k(view, i12, i13);
        if (k8 > 0) {
            i11 += k8;
        }
        if (i9 >= i10 + i11) {
            return false;
        }
        return true;
    }

    private void T(int i8, int i9, FlexLine flexLine, int i10, int i11, boolean z7) {
        int i12;
        int i13;
        int i14;
        int i15 = flexLine.f12373e;
        float f8 = flexLine.f12379k;
        float f9 = 0.0f;
        if (f8 > 0.0f && i10 <= i15) {
            float f10 = (i15 - i10) / f8;
            flexLine.f12373e = i11 + flexLine.f12374f;
            if (!z7) {
                flexLine.f12375g = Integer.MIN_VALUE;
            }
            int i16 = 0;
            boolean z8 = false;
            int i17 = 0;
            float f11 = 0.0f;
            while (i16 < flexLine.f12376h) {
                int i18 = flexLine.f12383o + i16;
                View i19 = this.f12387a.i(i18);
                if (i19 != null && i19.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) i19.getLayoutParams();
                    int flexDirection = this.f12387a.getFlexDirection();
                    if (flexDirection != 0 && flexDirection != 1) {
                        int measuredHeight = i19.getMeasuredHeight();
                        long[] jArr = this.f12391e;
                        if (jArr != null) {
                            measuredHeight = x(jArr[i18]);
                        }
                        int measuredWidth = i19.getMeasuredWidth();
                        long[] jArr2 = this.f12391e;
                        if (jArr2 != null) {
                            measuredWidth = y(jArr2[i18]);
                        }
                        if (!this.f12388b[i18] && flexItem.m() > f9) {
                            float m8 = measuredHeight - (flexItem.m() * f10);
                            if (i16 == flexLine.f12376h - 1) {
                                m8 += f11;
                                f11 = 0.0f;
                            }
                            int round = Math.round(m8);
                            if (round < flexItem.c1()) {
                                round = flexItem.c1();
                                this.f12388b[i18] = true;
                                flexLine.f12379k -= flexItem.m();
                                i12 = i15;
                                i13 = i16;
                                z8 = true;
                            } else {
                                f11 += m8 - round;
                                i12 = i15;
                                i13 = i16;
                                double d8 = f11;
                                if (d8 > 1.0d) {
                                    round++;
                                    f11 -= 1.0f;
                                } else if (d8 < -1.0d) {
                                    round--;
                                    f11 += 1.0f;
                                }
                            }
                            int A = A(i8, flexItem, flexLine.f12381m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, Pow2.MAX_POW2);
                            i19.measure(A, makeMeasureSpec);
                            measuredWidth = i19.getMeasuredWidth();
                            int measuredHeight2 = i19.getMeasuredHeight();
                            Z(i18, A, makeMeasureSpec, i19);
                            this.f12387a.j(i18, i19);
                            measuredHeight = measuredHeight2;
                        } else {
                            i12 = i15;
                            i13 = i16;
                        }
                        i14 = Math.max(i17, measuredWidth + flexItem.G0() + flexItem.Z0() + this.f12387a.g(i19));
                        flexLine.f12373e += measuredHeight + flexItem.y() + flexItem.D0();
                    } else {
                        i12 = i15;
                        int i20 = i16;
                        int measuredWidth2 = i19.getMeasuredWidth();
                        long[] jArr3 = this.f12391e;
                        if (jArr3 != null) {
                            measuredWidth2 = y(jArr3[i18]);
                        }
                        int measuredHeight3 = i19.getMeasuredHeight();
                        long[] jArr4 = this.f12391e;
                        if (jArr4 != null) {
                            measuredHeight3 = x(jArr4[i18]);
                        }
                        if (!this.f12388b[i18] && flexItem.m() > 0.0f) {
                            float m9 = measuredWidth2 - (flexItem.m() * f10);
                            i13 = i20;
                            if (i13 == flexLine.f12376h - 1) {
                                m9 += f11;
                                f11 = 0.0f;
                            }
                            int round2 = Math.round(m9);
                            if (round2 < flexItem.w()) {
                                round2 = flexItem.w();
                                this.f12388b[i18] = true;
                                flexLine.f12379k -= flexItem.m();
                                z8 = true;
                            } else {
                                f11 += m9 - round2;
                                double d9 = f11;
                                if (d9 > 1.0d) {
                                    round2++;
                                    f11 -= 1.0f;
                                } else if (d9 < -1.0d) {
                                    round2--;
                                    f11 += 1.0f;
                                }
                            }
                            int z9 = z(i9, flexItem, flexLine.f12381m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, Pow2.MAX_POW2);
                            i19.measure(makeMeasureSpec2, z9);
                            int measuredWidth3 = i19.getMeasuredWidth();
                            int measuredHeight4 = i19.getMeasuredHeight();
                            Z(i18, makeMeasureSpec2, z9, i19);
                            this.f12387a.j(i18, i19);
                            measuredWidth2 = measuredWidth3;
                            measuredHeight3 = measuredHeight4;
                        } else {
                            i13 = i20;
                        }
                        int max = Math.max(i17, measuredHeight3 + flexItem.y() + flexItem.D0() + this.f12387a.g(i19));
                        flexLine.f12373e += measuredWidth2 + flexItem.G0() + flexItem.Z0();
                        i14 = max;
                    }
                    flexLine.f12375g = Math.max(flexLine.f12375g, i14);
                    i17 = i14;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                i16 = i13 + 1;
                i15 = i12;
                f9 = 0.0f;
            }
            int i21 = i15;
            if (z8 && i21 != flexLine.f12373e) {
                T(i8, i9, flexLine, i10, i11, true);
            }
        }
    }

    private int[] U(int i8, List<Order> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i8];
        int i9 = 0;
        for (Order order : list) {
            int i10 = order.f12394f;
            iArr[i9] = i10;
            sparseIntArray.append(i10, order.f12395g);
            i9++;
        }
        return iArr;
    }

    private void V(View view, int i8, int i9) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i8 - flexItem.G0()) - flexItem.Z0()) - this.f12387a.g(view), flexItem.w()), flexItem.c0());
        long[] jArr = this.f12391e;
        if (jArr != null) {
            measuredHeight = x(jArr[i9]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, Pow2.MAX_POW2);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, Pow2.MAX_POW2);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Z(i9, makeMeasureSpec2, makeMeasureSpec, view);
        this.f12387a.j(i9, view);
    }

    private void W(View view, int i8, int i9) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i8 - flexItem.y()) - flexItem.D0()) - this.f12387a.g(view), flexItem.c1()), flexItem.f1());
        long[] jArr = this.f12391e;
        if (jArr != null) {
            measuredWidth = y(jArr[i9]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, Pow2.MAX_POW2);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, Pow2.MAX_POW2);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Z(i9, makeMeasureSpec, makeMeasureSpec2, view);
        this.f12387a.j(i9, view);
    }

    private void Z(int i8, int i9, int i10, View view) {
        long[] jArr = this.f12390d;
        if (jArr != null) {
            jArr[i8] = S(i9, i10);
        }
        long[] jArr2 = this.f12391e;
        if (jArr2 != null) {
            jArr2[i8] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void a(List<FlexLine> list, FlexLine flexLine, int i8, int i9) {
        flexLine.f12381m = i9;
        this.f12387a.h(flexLine);
        flexLine.f12384p = i8;
        list.add(flexLine);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.w()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.w()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.c0()
            if (r1 <= r3) goto L26
            int r1 = r0.c0()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.c1()
            if (r2 >= r5) goto L32
            int r2 = r0.c1()
            goto L3e
        L32:
            int r5 = r0.f1()
            if (r2 <= r5) goto L3d
            int r2 = r0.f1()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Z(r8, r1, r0, r7)
            com.google.android.flexbox.FlexContainer r0 = r6.f12387a
            r0.j(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxHelper.i(android.view.View, int):void");
    }

    private List<FlexLine> k(List<FlexLine> list, int i8, int i9) {
        ArrayList arrayList = new ArrayList();
        FlexLine flexLine = new FlexLine();
        flexLine.f12375g = (i8 - i9) / 2;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 == 0) {
                arrayList.add(flexLine);
            }
            arrayList.add(list.get(i10));
            if (i10 == list.size() - 1) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<Order> l(int i8) {
        ArrayList arrayList = new ArrayList(i8);
        for (int i9 = 0; i9 < i8; i9++) {
            Order order = new Order();
            order.f12395g = ((FlexItem) this.f12387a.e(i9).getLayoutParams()).getOrder();
            order.f12394f = i9;
            arrayList.add(order);
        }
        return arrayList;
    }

    private void r(int i8) {
        boolean[] zArr = this.f12388b;
        if (zArr == null) {
            if (i8 < 10) {
                i8 = 10;
            }
            this.f12388b = new boolean[i8];
        } else if (zArr.length < i8) {
            int length = zArr.length * 2;
            if (length >= i8) {
                i8 = length;
            }
            this.f12388b = new boolean[i8];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void v(CompoundButton compoundButton) {
        int minimumWidth;
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int w7 = flexItem.w();
        int c12 = flexItem.c1();
        Drawable a8 = CompoundButtonCompat.a(compoundButton);
        int i8 = 0;
        if (a8 == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = a8.getMinimumWidth();
        }
        if (a8 != null) {
            i8 = a8.getMinimumHeight();
        }
        if (w7 == -1) {
            w7 = minimumWidth;
        }
        flexItem.C0(w7);
        if (c12 == -1) {
            c12 = i8;
        }
        flexItem.F(c12);
    }

    private void w(int i8, int i9, FlexLine flexLine, int i10, int i11, boolean z7) {
        int i12;
        int i13;
        int i14;
        double d8;
        int i15;
        double d9;
        float f8 = flexLine.f12378j;
        float f9 = 0.0f;
        if (f8 > 0.0f && i10 >= (i12 = flexLine.f12373e)) {
            float f10 = (i10 - i12) / f8;
            flexLine.f12373e = i11 + flexLine.f12374f;
            if (!z7) {
                flexLine.f12375g = Integer.MIN_VALUE;
            }
            int i16 = 0;
            boolean z8 = false;
            int i17 = 0;
            float f11 = 0.0f;
            while (i16 < flexLine.f12376h) {
                int i18 = flexLine.f12383o + i16;
                View i19 = this.f12387a.i(i18);
                if (i19 != null && i19.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) i19.getLayoutParams();
                    int flexDirection = this.f12387a.getFlexDirection();
                    if (flexDirection != 0 && flexDirection != 1) {
                        int measuredHeight = i19.getMeasuredHeight();
                        long[] jArr = this.f12391e;
                        if (jArr != null) {
                            measuredHeight = x(jArr[i18]);
                        }
                        int measuredWidth = i19.getMeasuredWidth();
                        long[] jArr2 = this.f12391e;
                        if (jArr2 != null) {
                            measuredWidth = y(jArr2[i18]);
                        }
                        if (!this.f12388b[i18] && flexItem.N() > f9) {
                            float N = measuredHeight + (flexItem.N() * f10);
                            if (i16 == flexLine.f12376h - 1) {
                                N += f11;
                                f11 = 0.0f;
                            }
                            int round = Math.round(N);
                            if (round > flexItem.f1()) {
                                round = flexItem.f1();
                                this.f12388b[i18] = true;
                                flexLine.f12378j -= flexItem.N();
                                i15 = i12;
                                z8 = true;
                            } else {
                                f11 += N - round;
                                i15 = i12;
                                double d10 = f11;
                                if (d10 > 1.0d) {
                                    round++;
                                    d9 = d10 - 1.0d;
                                } else if (d10 < -1.0d) {
                                    round--;
                                    d9 = d10 + 1.0d;
                                }
                                f11 = (float) d9;
                            }
                            int A = A(i8, flexItem, flexLine.f12381m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, Pow2.MAX_POW2);
                            i19.measure(A, makeMeasureSpec);
                            measuredWidth = i19.getMeasuredWidth();
                            int measuredHeight2 = i19.getMeasuredHeight();
                            Z(i18, A, makeMeasureSpec, i19);
                            this.f12387a.j(i18, i19);
                            measuredHeight = measuredHeight2;
                        } else {
                            i15 = i12;
                        }
                        i14 = Math.max(i17, measuredWidth + flexItem.G0() + flexItem.Z0() + this.f12387a.g(i19));
                        flexLine.f12373e += measuredHeight + flexItem.y() + flexItem.D0();
                        i13 = i15;
                    } else {
                        int i20 = i12;
                        int measuredWidth2 = i19.getMeasuredWidth();
                        long[] jArr3 = this.f12391e;
                        if (jArr3 != null) {
                            measuredWidth2 = y(jArr3[i18]);
                        }
                        int measuredHeight3 = i19.getMeasuredHeight();
                        long[] jArr4 = this.f12391e;
                        i13 = i20;
                        if (jArr4 != null) {
                            measuredHeight3 = x(jArr4[i18]);
                        }
                        if (!this.f12388b[i18] && flexItem.N() > 0.0f) {
                            float N2 = measuredWidth2 + (flexItem.N() * f10);
                            if (i16 == flexLine.f12376h - 1) {
                                N2 += f11;
                                f11 = 0.0f;
                            }
                            int round2 = Math.round(N2);
                            if (round2 > flexItem.c0()) {
                                round2 = flexItem.c0();
                                this.f12388b[i18] = true;
                                flexLine.f12378j -= flexItem.N();
                                z8 = true;
                            } else {
                                f11 += N2 - round2;
                                double d11 = f11;
                                if (d11 > 1.0d) {
                                    round2++;
                                    d8 = d11 - 1.0d;
                                } else if (d11 < -1.0d) {
                                    round2--;
                                    d8 = d11 + 1.0d;
                                }
                                f11 = (float) d8;
                            }
                            int z9 = z(i9, flexItem, flexLine.f12381m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, Pow2.MAX_POW2);
                            i19.measure(makeMeasureSpec2, z9);
                            int measuredWidth3 = i19.getMeasuredWidth();
                            int measuredHeight4 = i19.getMeasuredHeight();
                            Z(i18, makeMeasureSpec2, z9, i19);
                            this.f12387a.j(i18, i19);
                            measuredWidth2 = measuredWidth3;
                            measuredHeight3 = measuredHeight4;
                        }
                        int max = Math.max(i17, measuredHeight3 + flexItem.y() + flexItem.D0() + this.f12387a.g(i19));
                        flexLine.f12373e += measuredWidth2 + flexItem.G0() + flexItem.Z0();
                        i14 = max;
                    }
                    flexLine.f12375g = Math.max(flexLine.f12375g, i14);
                    i17 = i14;
                } else {
                    i13 = i12;
                }
                i16++;
                i12 = i13;
                f9 = 0.0f;
            }
            int i21 = i12;
            if (z8 && i21 != flexLine.f12373e) {
                w(i8, i9, flexLine, i10, i11, true);
            }
        }
    }

    private int z(int i8, FlexItem flexItem, int i9) {
        FlexContainer flexContainer = this.f12387a;
        int f8 = flexContainer.f(i8, flexContainer.getPaddingTop() + this.f12387a.getPaddingBottom() + flexItem.y() + flexItem.D0() + i9, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(f8);
        if (size > flexItem.f1()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.f1(), View.MeasureSpec.getMode(f8));
        }
        if (size < flexItem.c1()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.c1(), View.MeasureSpec.getMode(f8));
        }
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f12387a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i8 = 0; i8 < flexItemCount; i8++) {
            View e8 = this.f12387a.e(i8);
            if (e8 != null && ((FlexItem) e8.getLayoutParams()).getOrder() != sparseIntArray.get(i8)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(View view, FlexLine flexLine, int i8, int i9, int i10, int i11) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f12387a.getAlignItems();
        if (flexItem.k() != -1) {
            alignItems = flexItem.k();
        }
        int i12 = flexLine.f12375g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3) {
                        if (alignItems != 4) {
                            return;
                        }
                    } else if (this.f12387a.getFlexWrap() != 2) {
                        int max = Math.max(flexLine.f12380l - view.getBaseline(), flexItem.y());
                        view.layout(i8, i9 + max, i10, i11 + max);
                        return;
                    } else {
                        int max2 = Math.max((flexLine.f12380l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.D0());
                        view.layout(i8, i9 - max2, i10, i11 - max2);
                        return;
                    }
                } else {
                    int measuredHeight = (((i12 - view.getMeasuredHeight()) + flexItem.y()) - flexItem.D0()) / 2;
                    if (this.f12387a.getFlexWrap() != 2) {
                        int i13 = i9 + measuredHeight;
                        view.layout(i8, i13, i10, view.getMeasuredHeight() + i13);
                        return;
                    }
                    int i14 = i9 - measuredHeight;
                    view.layout(i8, i14, i10, view.getMeasuredHeight() + i14);
                    return;
                }
            } else if (this.f12387a.getFlexWrap() != 2) {
                int i15 = i9 + i12;
                view.layout(i8, (i15 - view.getMeasuredHeight()) - flexItem.D0(), i10, i15 - flexItem.D0());
                return;
            } else {
                view.layout(i8, (i9 - i12) + view.getMeasuredHeight() + flexItem.y(), i10, (i11 - i12) + view.getMeasuredHeight() + flexItem.y());
                return;
            }
        }
        if (this.f12387a.getFlexWrap() != 2) {
            view.layout(i8, i9 + flexItem.y(), i10, i11 + flexItem.y());
        } else {
            view.layout(i8, i9 - flexItem.D0(), i10, i11 - flexItem.D0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(View view, FlexLine flexLine, boolean z7, int i8, int i9, int i10, int i11) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f12387a.getAlignItems();
        if (flexItem.k() != -1) {
            alignItems = flexItem.k();
        }
        int i12 = flexLine.f12375g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3 && alignItems != 4) {
                        return;
                    }
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int measuredWidth = (((i12 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.b(marginLayoutParams)) - MarginLayoutParamsCompat.a(marginLayoutParams)) / 2;
                    if (!z7) {
                        view.layout(i8 + measuredWidth, i9, i10 + measuredWidth, i11);
                        return;
                    } else {
                        view.layout(i8 - measuredWidth, i9, i10 - measuredWidth, i11);
                        return;
                    }
                }
            } else if (!z7) {
                view.layout(((i8 + i12) - view.getMeasuredWidth()) - flexItem.Z0(), i9, ((i10 + i12) - view.getMeasuredWidth()) - flexItem.Z0(), i11);
                return;
            } else {
                view.layout((i8 - i12) + view.getMeasuredWidth() + flexItem.G0(), i9, (i10 - i12) + view.getMeasuredWidth() + flexItem.G0(), i11);
                return;
            }
        }
        if (!z7) {
            view.layout(i8 + flexItem.G0(), i9, i10 + flexItem.G0(), i11);
        } else {
            view.layout(i8 - flexItem.Z0(), i9, i10 - flexItem.Z0(), i11);
        }
    }

    long S(int i8, int i9) {
        return (i8 & 4294967295L) | (i9 << 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X() {
        Y(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(int i8) {
        int i9;
        View i10;
        if (i8 >= this.f12387a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f12387a.getFlexDirection();
        if (this.f12387a.getAlignItems() == 4) {
            int[] iArr = this.f12389c;
            if (iArr != null) {
                i9 = iArr[i8];
            } else {
                i9 = 0;
            }
            List<FlexLine> flexLinesInternal = this.f12387a.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            while (i9 < size) {
                FlexLine flexLine = flexLinesInternal.get(i9);
                int i11 = flexLine.f12376h;
                for (int i12 = 0; i12 < i11; i12++) {
                    int i13 = flexLine.f12383o + i12;
                    if (i12 < this.f12387a.getFlexItemCount() && (i10 = this.f12387a.i(i13)) != null && i10.getVisibility() != 8) {
                        FlexItem flexItem = (FlexItem) i10.getLayoutParams();
                        if (flexItem.k() == -1 || flexItem.k() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                                V(i10, flexLine.f12375g, i13);
                            } else {
                                W(i10, flexLine.f12375g, i13);
                            }
                        }
                    }
                }
                i9++;
            }
            return;
        }
        for (FlexLine flexLine2 : this.f12387a.getFlexLinesInternal()) {
            for (Integer num : flexLine2.f12382n) {
                View i14 = this.f12387a.i(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                    V(i14, flexLine2.f12375g, num.intValue());
                } else {
                    W(i14, flexLine2.f12375g, num.intValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(FlexLinesResult flexLinesResult, int i8, int i9, int i10, int i11, int i12, List<FlexLine> list) {
        ArrayList arrayList;
        boolean z7;
        int i13;
        FlexLinesResult flexLinesResult2;
        int i14;
        int i15;
        int i16;
        List<FlexLine> list2;
        int i17;
        View view;
        int i18;
        int i19;
        int i20;
        boolean z8;
        boolean z9;
        int i21;
        int i22;
        int i23;
        FlexLine flexLine;
        int i24;
        int i25 = i8;
        int i26 = i9;
        int i27 = i12;
        boolean l8 = this.f12387a.l();
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        flexLinesResult.f12392a = arrayList;
        if (i27 == -1) {
            z7 = true;
        } else {
            z7 = false;
        }
        int K = K(l8);
        int I = I(l8);
        int J = J(l8);
        int H = H(l8);
        FlexLine flexLine2 = new FlexLine();
        int i28 = i11;
        flexLine2.f12383o = i28;
        int i29 = I + K;
        flexLine2.f12373e = i29;
        int flexItemCount = this.f12387a.getFlexItemCount();
        boolean z10 = z7;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = Integer.MIN_VALUE;
        while (true) {
            if (i28 < flexItemCount) {
                View i34 = this.f12387a.i(i28);
                if (i34 == null) {
                    if (N(i28, flexItemCount, flexLine2)) {
                        a(arrayList, flexLine2, i28, i30);
                    }
                } else if (i34.getVisibility() == 8) {
                    flexLine2.f12377i++;
                    flexLine2.f12376h++;
                    if (N(i28, flexItemCount, flexLine2)) {
                        a(arrayList, flexLine2, i28, i30);
                    }
                } else {
                    if (i34 instanceof CompoundButton) {
                        v((CompoundButton) i34);
                    }
                    FlexItem flexItem = (FlexItem) i34.getLayoutParams();
                    int i35 = flexItemCount;
                    if (flexItem.k() == 4) {
                        flexLine2.f12382n.add(Integer.valueOf(i28));
                    }
                    int G = G(flexItem, l8);
                    if (flexItem.Y() != -1.0f && mode == 1073741824) {
                        G = Math.round(size * flexItem.Y());
                    }
                    if (l8) {
                        int c8 = this.f12387a.c(i25, i29 + E(flexItem, true) + C(flexItem, true), G);
                        i14 = size;
                        i15 = mode;
                        int f8 = this.f12387a.f(i26, J + H + D(flexItem, true) + B(flexItem, true) + i30, F(flexItem, true));
                        i34.measure(c8, f8);
                        Z(i28, c8, f8, i34);
                        i16 = c8;
                    } else {
                        i14 = size;
                        i15 = mode;
                        int c9 = this.f12387a.c(i26, J + H + D(flexItem, false) + B(flexItem, false) + i30, F(flexItem, false));
                        int f9 = this.f12387a.f(i25, E(flexItem, false) + i29 + C(flexItem, false), G);
                        i34.measure(c9, f9);
                        Z(i28, c9, f9, i34);
                        i16 = f9;
                    }
                    this.f12387a.j(i28, i34);
                    i(i34, i28);
                    i31 = View.combineMeasuredStates(i31, i34.getMeasuredState());
                    int i36 = i30;
                    int i37 = i29;
                    FlexLine flexLine3 = flexLine2;
                    int i38 = i28;
                    list2 = arrayList;
                    int i39 = i16;
                    if (P(i34, i15, i14, flexLine2.f12373e, C(flexItem, l8) + M(i34, l8) + E(flexItem, l8), flexItem, i38, i32, arrayList.size())) {
                        if (flexLine3.c() > 0) {
                            if (i38 > 0) {
                                i24 = i38 - 1;
                                flexLine = flexLine3;
                            } else {
                                flexLine = flexLine3;
                                i24 = 0;
                            }
                            a(list2, flexLine, i24, i36);
                            i30 = flexLine.f12375g + i36;
                        } else {
                            i30 = i36;
                        }
                        if (l8) {
                            if (flexItem.getHeight() == -1) {
                                FlexContainer flexContainer = this.f12387a;
                                i17 = i9;
                                i28 = i38;
                                view = i34;
                                view.measure(i39, flexContainer.f(i17, flexContainer.getPaddingTop() + this.f12387a.getPaddingBottom() + flexItem.y() + flexItem.D0() + i30, flexItem.getHeight()));
                                i(view, i28);
                            } else {
                                i17 = i9;
                                view = i34;
                                i28 = i38;
                            }
                        } else {
                            i17 = i9;
                            view = i34;
                            i28 = i38;
                            if (flexItem.getWidth() == -1) {
                                FlexContainer flexContainer2 = this.f12387a;
                                view.measure(flexContainer2.c(i17, flexContainer2.getPaddingLeft() + this.f12387a.getPaddingRight() + flexItem.G0() + flexItem.Z0() + i30, flexItem.getWidth()), i39);
                                i(view, i28);
                            }
                        }
                        flexLine2 = new FlexLine();
                        flexLine2.f12376h = 1;
                        i18 = i37;
                        flexLine2.f12373e = i18;
                        flexLine2.f12383o = i28;
                        i19 = 0;
                        i20 = Integer.MIN_VALUE;
                    } else {
                        i17 = i9;
                        view = i34;
                        i28 = i38;
                        flexLine2 = flexLine3;
                        i18 = i37;
                        flexLine2.f12376h++;
                        i19 = i32 + 1;
                        i30 = i36;
                        i20 = i33;
                    }
                    boolean z11 = flexLine2.f12385q;
                    if (flexItem.N() != 0.0f) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    flexLine2.f12385q = z11 | z8;
                    boolean z12 = flexLine2.f12386r;
                    if (flexItem.m() != 0.0f) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    flexLine2.f12386r = z12 | z9;
                    int[] iArr = this.f12389c;
                    if (iArr != null) {
                        iArr[i28] = list2.size();
                    }
                    flexLine2.f12373e += M(view, l8) + E(flexItem, l8) + C(flexItem, l8);
                    flexLine2.f12378j += flexItem.N();
                    flexLine2.f12379k += flexItem.m();
                    this.f12387a.b(view, i28, i19, flexLine2);
                    int max = Math.max(i20, L(view, l8) + D(flexItem, l8) + B(flexItem, l8) + this.f12387a.g(view));
                    flexLine2.f12375g = Math.max(flexLine2.f12375g, max);
                    if (l8) {
                        if (this.f12387a.getFlexWrap() != 2) {
                            flexLine2.f12380l = Math.max(flexLine2.f12380l, view.getBaseline() + flexItem.y());
                        } else {
                            flexLine2.f12380l = Math.max(flexLine2.f12380l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.D0());
                        }
                    }
                    i21 = i35;
                    if (N(i28, i21, flexLine2)) {
                        a(list2, flexLine2, i28, i30);
                        i30 += flexLine2.f12375g;
                    }
                    i22 = i12;
                    if (i22 != -1 && list2.size() > 0) {
                        if (list2.get(list2.size() - 1).f12384p >= i22 && i28 >= i22 && !z10) {
                            i30 = -flexLine2.a();
                            i23 = i10;
                            z10 = true;
                            if (i30 <= i23 && z10) {
                                flexLinesResult2 = flexLinesResult;
                                i13 = i31;
                                break;
                            }
                            i32 = i19;
                            i33 = max;
                            i28++;
                            i25 = i8;
                            flexItemCount = i21;
                            i26 = i17;
                            i29 = i18;
                            arrayList = list2;
                            mode = i15;
                            i27 = i22;
                            size = i14;
                        }
                    }
                    i23 = i10;
                    if (i30 <= i23) {
                    }
                    i32 = i19;
                    i33 = max;
                    i28++;
                    i25 = i8;
                    flexItemCount = i21;
                    i26 = i17;
                    i29 = i18;
                    arrayList = list2;
                    mode = i15;
                    i27 = i22;
                    size = i14;
                }
                i14 = size;
                i15 = mode;
                i17 = i26;
                i22 = i27;
                list2 = arrayList;
                i18 = i29;
                i21 = flexItemCount;
                i28++;
                i25 = i8;
                flexItemCount = i21;
                i26 = i17;
                i29 = i18;
                arrayList = list2;
                mode = i15;
                i27 = i22;
                size = i14;
            } else {
                i13 = i31;
                flexLinesResult2 = flexLinesResult;
                break;
            }
        }
        flexLinesResult2.f12393b = i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(FlexLinesResult flexLinesResult, int i8, int i9) {
        b(flexLinesResult, i8, i9, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(FlexLinesResult flexLinesResult, int i8, int i9, int i10, int i11, List<FlexLine> list) {
        b(flexLinesResult, i8, i9, i10, i11, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(FlexLinesResult flexLinesResult, int i8, int i9, int i10, int i11, List<FlexLine> list) {
        b(flexLinesResult, i8, i9, i10, 0, i11, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(FlexLinesResult flexLinesResult, int i8, int i9) {
        b(flexLinesResult, i9, i8, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(FlexLinesResult flexLinesResult, int i8, int i9, int i10, int i11, List<FlexLine> list) {
        b(flexLinesResult, i9, i8, i10, i11, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(FlexLinesResult flexLinesResult, int i8, int i9, int i10, int i11, List<FlexLine> list) {
        b(flexLinesResult, i9, i8, i10, 0, i11, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(List<FlexLine> list, int i8) {
        int i9 = this.f12389c[i8];
        if (i9 == -1) {
            i9 = 0;
        }
        for (int size = list.size() - 1; size >= i9; size--) {
            list.remove(size);
        }
        int[] iArr = this.f12389c;
        int length = iArr.length - 1;
        if (i8 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i8, length, -1);
        }
        long[] jArr = this.f12390d;
        int length2 = jArr.length - 1;
        if (i8 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i8, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f12387a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] n(View view, int i8, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f12387a.getFlexItemCount();
        List<Order> l8 = l(flexItemCount);
        Order order = new Order();
        if (view != null && (layoutParams instanceof FlexItem)) {
            order.f12395g = ((FlexItem) layoutParams).getOrder();
        } else {
            order.f12395g = 1;
        }
        if (i8 != -1 && i8 != flexItemCount) {
            if (i8 < this.f12387a.getFlexItemCount()) {
                order.f12394f = i8;
                while (i8 < flexItemCount) {
                    l8.get(i8).f12394f++;
                    i8++;
                }
            } else {
                order.f12394f = flexItemCount;
            }
        } else {
            order.f12394f = flexItemCount;
        }
        l8.add(order);
        return U(flexItemCount + 1, l8, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i8, int i9, int i10) {
        int i11;
        int i12;
        int flexDirection = this.f12387a.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            i11 = View.MeasureSpec.getMode(i8);
            i12 = View.MeasureSpec.getSize(i8);
        } else {
            int mode = View.MeasureSpec.getMode(i9);
            int size = View.MeasureSpec.getSize(i9);
            i11 = mode;
            i12 = size;
        }
        List<FlexLine> flexLinesInternal = this.f12387a.getFlexLinesInternal();
        if (i11 == 1073741824) {
            int sumOfCrossSize = this.f12387a.getSumOfCrossSize() + i10;
            int i13 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f12375g = i12 - i10;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f12387a.getAlignContent();
                if (alignContent != 1) {
                    if (alignContent != 2) {
                        if (alignContent != 3) {
                            if (alignContent != 4) {
                                if (alignContent == 5 && sumOfCrossSize < i12) {
                                    float size2 = (i12 - sumOfCrossSize) / flexLinesInternal.size();
                                    int size3 = flexLinesInternal.size();
                                    float f8 = 0.0f;
                                    while (i13 < size3) {
                                        FlexLine flexLine = flexLinesInternal.get(i13);
                                        float f9 = flexLine.f12375g + size2;
                                        if (i13 == flexLinesInternal.size() - 1) {
                                            f9 += f8;
                                            f8 = 0.0f;
                                        }
                                        int round = Math.round(f9);
                                        f8 += f9 - round;
                                        if (f8 > 1.0f) {
                                            round++;
                                            f8 -= 1.0f;
                                        } else if (f8 < -1.0f) {
                                            round--;
                                            f8 += 1.0f;
                                        }
                                        flexLine.f12375g = round;
                                        i13++;
                                    }
                                    return;
                                }
                                return;
                            } else if (sumOfCrossSize >= i12) {
                                this.f12387a.setFlexLines(k(flexLinesInternal, i12, sumOfCrossSize));
                                return;
                            } else {
                                int size4 = (i12 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                                ArrayList arrayList = new ArrayList();
                                FlexLine flexLine2 = new FlexLine();
                                flexLine2.f12375g = size4;
                                for (FlexLine flexLine3 : flexLinesInternal) {
                                    arrayList.add(flexLine2);
                                    arrayList.add(flexLine3);
                                    arrayList.add(flexLine2);
                                }
                                this.f12387a.setFlexLines(arrayList);
                                return;
                            }
                        } else if (sumOfCrossSize < i12) {
                            float size5 = (i12 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                            ArrayList arrayList2 = new ArrayList();
                            int size6 = flexLinesInternal.size();
                            float f10 = 0.0f;
                            while (i13 < size6) {
                                arrayList2.add(flexLinesInternal.get(i13));
                                if (i13 != flexLinesInternal.size() - 1) {
                                    FlexLine flexLine4 = new FlexLine();
                                    if (i13 == flexLinesInternal.size() - 2) {
                                        flexLine4.f12375g = Math.round(f10 + size5);
                                        f10 = 0.0f;
                                    } else {
                                        flexLine4.f12375g = Math.round(size5);
                                    }
                                    int i14 = flexLine4.f12375g;
                                    f10 += size5 - i14;
                                    if (f10 > 1.0f) {
                                        flexLine4.f12375g = i14 + 1;
                                        f10 -= 1.0f;
                                    } else if (f10 < -1.0f) {
                                        flexLine4.f12375g = i14 - 1;
                                        f10 += 1.0f;
                                    }
                                    arrayList2.add(flexLine4);
                                }
                                i13++;
                            }
                            this.f12387a.setFlexLines(arrayList2);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.f12387a.setFlexLines(k(flexLinesInternal, i12, sumOfCrossSize));
                    return;
                }
                int i15 = i12 - sumOfCrossSize;
                FlexLine flexLine5 = new FlexLine();
                flexLine5.f12375g = i15;
                flexLinesInternal.add(0, flexLine5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i8, int i9) {
        q(i8, i9, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i8, int i9, int i10) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.f12387a.getFlexItemCount());
        if (i10 >= this.f12387a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f12387a.getFlexDirection();
        int flexDirection2 = this.f12387a.getFlexDirection();
        if (flexDirection2 != 0 && flexDirection2 != 1) {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode = View.MeasureSpec.getMode(i9);
            size = View.MeasureSpec.getSize(i9);
            if (mode != 1073741824) {
                size = this.f12387a.getLargestMainSize();
            }
            paddingLeft = this.f12387a.getPaddingTop();
            paddingRight = this.f12387a.getPaddingBottom();
        } else {
            int mode2 = View.MeasureSpec.getMode(i8);
            size = View.MeasureSpec.getSize(i8);
            int largestMainSize = this.f12387a.getLargestMainSize();
            if (mode2 != 1073741824 && largestMainSize <= size) {
                size = largestMainSize;
            }
            paddingLeft = this.f12387a.getPaddingLeft();
            paddingRight = this.f12387a.getPaddingRight();
        }
        int i11 = paddingLeft + paddingRight;
        int i12 = 0;
        int[] iArr = this.f12389c;
        if (iArr != null) {
            i12 = iArr[i10];
        }
        List<FlexLine> flexLinesInternal = this.f12387a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i13 = i12; i13 < size2; i13++) {
            FlexLine flexLine = flexLinesInternal.get(i13);
            int i14 = flexLine.f12373e;
            if (i14 < size && flexLine.f12385q) {
                w(i8, i9, flexLine, size, i11, false);
            } else if (i14 > size && flexLine.f12386r) {
                T(i8, i9, flexLine, size, i11, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i8) {
        int[] iArr = this.f12389c;
        if (iArr == null) {
            if (i8 < 10) {
                i8 = 10;
            }
            this.f12389c = new int[i8];
        } else if (iArr.length < i8) {
            int length = iArr.length * 2;
            if (length >= i8) {
                i8 = length;
            }
            this.f12389c = Arrays.copyOf(iArr, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i8) {
        long[] jArr = this.f12390d;
        if (jArr == null) {
            if (i8 < 10) {
                i8 = 10;
            }
            this.f12390d = new long[i8];
        } else if (jArr.length < i8) {
            int length = jArr.length * 2;
            if (length >= i8) {
                i8 = length;
            }
            this.f12390d = Arrays.copyOf(jArr, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i8) {
        long[] jArr = this.f12391e;
        if (jArr == null) {
            if (i8 < 10) {
                i8 = 10;
            }
            this.f12391e = new long[i8];
        } else if (jArr.length < i8) {
            int length = jArr.length * 2;
            if (length >= i8) {
                i8 = length;
            }
            this.f12391e = Arrays.copyOf(jArr, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(long j8) {
        return (int) (j8 >> 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y(long j8) {
        return (int) j8;
    }
}
