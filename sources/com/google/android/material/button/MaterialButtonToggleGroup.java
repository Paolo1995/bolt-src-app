package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: p  reason: collision with root package name */
    private static final int f13103p = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: f  reason: collision with root package name */
    private final List<CornerData> f13104f;

    /* renamed from: g  reason: collision with root package name */
    private final PressedStateTracker f13105g;

    /* renamed from: h  reason: collision with root package name */
    private final LinkedHashSet<OnButtonCheckedListener> f13106h;

    /* renamed from: i  reason: collision with root package name */
    private final Comparator<MaterialButton> f13107i;

    /* renamed from: j  reason: collision with root package name */
    private Integer[] f13108j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13109k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13110l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f13111m;

    /* renamed from: n  reason: collision with root package name */
    private final int f13112n;

    /* renamed from: o  reason: collision with root package name */
    private Set<Integer> f13113o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CornerData {

        /* renamed from: e  reason: collision with root package name */
        private static final CornerSize f13116e = new AbsoluteCornerSize(0.0f);

        /* renamed from: a  reason: collision with root package name */
        CornerSize f13117a;

        /* renamed from: b  reason: collision with root package name */
        CornerSize f13118b;

        /* renamed from: c  reason: collision with root package name */
        CornerSize f13119c;

        /* renamed from: d  reason: collision with root package name */
        CornerSize f13120d;

        CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.f13117a = cornerSize;
            this.f13118b = cornerSize3;
            this.f13119c = cornerSize4;
            this.f13120d = cornerSize2;
        }

        public static CornerData a(CornerData cornerData) {
            CornerSize cornerSize = f13116e;
            return new CornerData(cornerSize, cornerData.f13120d, cornerSize, cornerData.f13119c);
        }

        public static CornerData b(CornerData cornerData, View view) {
            if (ViewUtils.f(view)) {
                return c(cornerData);
            }
            return d(cornerData);
        }

        public static CornerData c(CornerData cornerData) {
            CornerSize cornerSize = cornerData.f13117a;
            CornerSize cornerSize2 = cornerData.f13120d;
            CornerSize cornerSize3 = f13116e;
            return new CornerData(cornerSize, cornerSize2, cornerSize3, cornerSize3);
        }

        public static CornerData d(CornerData cornerData) {
            CornerSize cornerSize = f13116e;
            return new CornerData(cornerSize, cornerSize, cornerData.f13118b, cornerData.f13119c);
        }

        public static CornerData e(CornerData cornerData, View view) {
            if (ViewUtils.f(view)) {
                return d(cornerData);
            }
            return c(cornerData);
        }

        public static CornerData f(CornerData cornerData) {
            CornerSize cornerSize = cornerData.f13117a;
            CornerSize cornerSize2 = f13116e;
            return new CornerData(cornerSize, cornerSize2, cornerData.f13118b, cornerSize2);
        }
    }

    /* loaded from: classes.dex */
    public interface OnButtonCheckedListener {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i8, boolean z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void a(@NonNull MaterialButton materialButton, boolean z7) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    private void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i8 = firstVisibleChildIndex + 1; i8 < getChildCount(); i8++) {
            MaterialButton h8 = h(i8);
            int min = Math.min(h8.getStrokeWidth(), h(i8 - 1).getStrokeWidth());
            LinearLayout.LayoutParams d8 = d(h8);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.c(d8, 0);
                MarginLayoutParamsCompat.d(d8, -min);
                d8.topMargin = 0;
            } else {
                d8.bottomMargin = 0;
                d8.topMargin = -min;
                MarginLayoutParamsCompat.d(d8, 0);
            }
            h8.setLayoutParams(d8);
        }
        n(firstVisibleChildIndex);
    }

    @NonNull
    private LinearLayout.LayoutParams d(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void e(int i8, boolean z7) {
        if (i8 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i8);
            return;
        }
        HashSet hashSet = new HashSet(this.f13113o);
        if (z7 && !hashSet.contains(Integer.valueOf(i8))) {
            if (this.f13110l && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i8));
        } else if (!z7 && hashSet.contains(Integer.valueOf(i8))) {
            if (!this.f13111m || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i8));
            }
        } else {
            return;
        }
        q(hashSet);
    }

    private void g(int i8, boolean z7) {
        Iterator<OnButtonCheckedListener> it = this.f13106h.iterator();
        while (it.hasNext()) {
            it.next().a(this, i8, z7);
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            if (k(i8)) {
                return i8;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (k(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i8 = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            if ((getChildAt(i9) instanceof MaterialButton) && k(i9)) {
                i8++;
            }
        }
        return i8;
    }

    private MaterialButton h(int i8) {
        return (MaterialButton) getChildAt(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            if (getChildAt(i9) == view) {
                return i8;
            }
            if ((getChildAt(i9) instanceof MaterialButton) && k(i9)) {
                i8++;
            }
        }
        return -1;
    }

    private CornerData j(int i8, int i9, int i10) {
        boolean z7;
        CornerData cornerData = this.f13104f.get(i8);
        if (i9 == i10) {
            return cornerData;
        }
        if (getOrientation() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (i8 == i9) {
            if (z7) {
                return CornerData.e(cornerData, this);
            }
            return CornerData.f(cornerData);
        } else if (i8 == i10) {
            if (z7) {
                return CornerData.b(cornerData, this);
            }
            return CornerData.a(cornerData);
        } else {
            return null;
        }
    }

    private boolean k(int i8) {
        if (getChildAt(i8).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private void n(int i8) {
        if (getChildCount() != 0 && i8 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) h(i8).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            MarginLayoutParamsCompat.c(layoutParams, 0);
            MarginLayoutParamsCompat.d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void o(int i8, boolean z7) {
        View findViewById = findViewById(i8);
        if (findViewById instanceof MaterialButton) {
            this.f13109k = true;
            ((MaterialButton) findViewById).setChecked(z7);
            this.f13109k = false;
        }
    }

    private static void p(ShapeAppearanceModel.Builder builder, CornerData cornerData) {
        if (cornerData == null) {
            builder.o(0.0f);
        } else {
            builder.B(cornerData.f13117a).t(cornerData.f13120d).F(cornerData.f13118b).x(cornerData.f13119c);
        }
    }

    private void q(Set<Integer> set) {
        Set<Integer> set2 = this.f13113o;
        this.f13113o = new HashSet(set);
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            int id = h(i8).getId();
            o(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                g(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void r() {
        TreeMap treeMap = new TreeMap(this.f13107i);
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            treeMap.put(h(i8), Integer.valueOf(i8));
        }
        this.f13108j = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.m());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f13105g);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i8, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        e(materialButton.getId(), materialButton.isChecked());
        ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f13104f.add(new CornerData(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        materialButton.setEnabled(isEnabled());
        ViewCompat.s0(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view2, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.b0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, MaterialButtonToggleGroup.this.i(view2), 1, false, ((MaterialButton) view2).isChecked()));
            }
        });
    }

    public void b(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.f13106h.add(onButtonCheckedListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        r();
        super.dispatchDraw(canvas);
    }

    public void f() {
        q(new HashSet());
    }

    public int getCheckedButtonId() {
        if (this.f13110l && !this.f13113o.isEmpty()) {
            return this.f13113o.iterator().next().intValue();
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            int id = h(i8).getId();
            if (this.f13113o.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i8, int i9) {
        Integer[] numArr = this.f13108j;
        if (numArr != null && i9 < numArr.length) {
            return numArr[i9].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i9;
    }

    public boolean l() {
        return this.f13110l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(@NonNull MaterialButton materialButton, boolean z7) {
        if (this.f13109k) {
            return;
        }
        e(materialButton.getId(), z7);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i8 = this.f13112n;
        if (i8 != -1) {
            q(Collections.singleton(Integer.valueOf(i8)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i8;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat A0 = AccessibilityNodeInfoCompat.A0(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (l()) {
            i8 = 1;
        } else {
            i8 = 2;
        }
        A0.a0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(1, visibleButtonCount, false, i8));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        s();
        c();
        super.onMeasure(i8, i9);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f13104f.remove(indexOfChild);
        }
        s();
        c();
    }

    void s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i8 = 0; i8 < childCount; i8++) {
            MaterialButton h8 = h(i8);
            if (h8.getVisibility() != 8) {
                ShapeAppearanceModel.Builder v7 = h8.getShapeAppearanceModel().v();
                p(v7, j(i8, firstVisibleChildIndex, lastVisibleChildIndex));
                h8.setShapeAppearanceModel(v7.m());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            h(i8).setEnabled(z7);
        }
    }

    public void setSelectionRequired(boolean z7) {
        this.f13111m = z7;
    }

    public void setSingleSelection(boolean z7) {
        if (this.f13110l != z7) {
            this.f13110l = z7;
            f();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.f13103p
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.f13104f = r7
            com.google.android.material.button.MaterialButtonToggleGroup$PressedStateTracker r7 = new com.google.android.material.button.MaterialButtonToggleGroup$PressedStateTracker
            r0 = 0
            r7.<init>()
            r6.f13105g = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f13106h = r7
            com.google.android.material.button.MaterialButtonToggleGroup$1 r7 = new com.google.android.material.button.MaterialButtonToggleGroup$1
            r7.<init>()
            r6.f13107i = r7
            r7 = 0
            r6.f13109k = r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r6.f13113o = r0
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R$styleable.U3
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.i(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R$styleable.Y3
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = com.google.android.material.R$styleable.W3
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f13112n = r9
            int r9 = com.google.android.material.R$styleable.X3
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f13111m = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            int r9 = com.google.android.material.R$styleable.V3
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setEnabled(r9)
            r8.recycle()
            androidx.core.view.ViewCompat.D0(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(int i8) {
        setSingleSelection(getResources().getBoolean(i8));
    }
}
