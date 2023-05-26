package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Method;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    private static Method L;
    private static Method M;
    private static Method N;
    private AdapterView.OnItemSelectedListener A;
    final ResizePopupRunnable B;
    private final PopupTouchInterceptor C;
    private final PopupScrollListener D;
    private final ListSelectorHider E;
    private Runnable F;
    final Handler G;
    private final Rect H;
    private Rect I;
    private boolean J;
    PopupWindow K;

    /* renamed from: f  reason: collision with root package name */
    private Context f2025f;

    /* renamed from: g  reason: collision with root package name */
    private ListAdapter f2026g;

    /* renamed from: h  reason: collision with root package name */
    DropDownListView f2027h;

    /* renamed from: i  reason: collision with root package name */
    private int f2028i;

    /* renamed from: j  reason: collision with root package name */
    private int f2029j;

    /* renamed from: k  reason: collision with root package name */
    private int f2030k;

    /* renamed from: l  reason: collision with root package name */
    private int f2031l;

    /* renamed from: m  reason: collision with root package name */
    private int f2032m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2033n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f2034o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f2035p;

    /* renamed from: q  reason: collision with root package name */
    private int f2036q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f2037r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f2038s;

    /* renamed from: t  reason: collision with root package name */
    int f2039t;

    /* renamed from: u  reason: collision with root package name */
    private View f2040u;

    /* renamed from: v  reason: collision with root package name */
    private int f2041v;

    /* renamed from: w  reason: collision with root package name */
    private DataSetObserver f2042w;

    /* renamed from: x  reason: collision with root package name */
    private View f2043x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f2044y;

    /* renamed from: z  reason: collision with root package name */
    private AdapterView.OnItemClickListener f2045z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static int a(PopupWindow popupWindow, View view, int i8, boolean z7) {
            int maxAvailableHeight;
            maxAvailableHeight = popupWindow.getMaxAvailableHeight(view, i8, z7);
            return maxAvailableHeight;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z7) {
            popupWindow.setIsClippedToScreen(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.c()) {
                ListPopupWindow.this.b();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PopupScrollListener implements AbsListView.OnScrollListener {
        PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i8, int i9, int i10) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i8) {
            if (i8 == 1 && !ListPopupWindow.this.A() && ListPopupWindow.this.K.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.G.removeCallbacks(listPopupWindow.B);
                ListPopupWindow.this.B.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x7 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.K) != null && popupWindow.isShowing() && x7 >= 0 && x7 < ListPopupWindow.this.K.getWidth() && y7 >= 0 && y7 < ListPopupWindow.this.K.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.G.postDelayed(listPopupWindow.B, 250L);
                return false;
            } else if (action == 1) {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.G.removeCallbacks(listPopupWindow2.B);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f2027h;
            if (dropDownListView != null && ViewCompat.V(dropDownListView) && ListPopupWindow.this.f2027h.getCount() > ListPopupWindow.this.f2027h.getChildCount()) {
                int childCount = ListPopupWindow.this.f2027h.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.f2039t) {
                    listPopupWindow.K.setInputMethodMode(2);
                    ListPopupWindow.this.b();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                L = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                N = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                M = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, null, R$attr.E);
    }

    private void C() {
        View view = this.f2040u;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2040u);
            }
        }
    }

    private void O(boolean z7) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = L;
            if (method != null) {
                try {
                    method.invoke(this.K, Boolean.valueOf(z7));
                    return;
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        Api29Impl.b(this.K, z7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int q() {
        int i8;
        int i9;
        int makeMeasureSpec;
        int i10;
        boolean z7 = true;
        if (this.f2027h == null) {
            Context context = this.f2025f;
            this.F = new Runnable() { // from class: androidx.appcompat.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View t7 = ListPopupWindow.this.t();
                    if (t7 != null && t7.getWindowToken() != null) {
                        ListPopupWindow.this.b();
                    }
                }
            };
            DropDownListView s7 = s(context, !this.J);
            this.f2027h = s7;
            Drawable drawable = this.f2044y;
            if (drawable != null) {
                s7.setSelector(drawable);
            }
            this.f2027h.setAdapter(this.f2026g);
            this.f2027h.setOnItemClickListener(this.f2045z);
            this.f2027h.setFocusable(true);
            this.f2027h.setFocusableInTouchMode(true);
            this.f2027h.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j8) {
                    DropDownListView dropDownListView;
                    if (i11 != -1 && (dropDownListView = ListPopupWindow.this.f2027h) != null) {
                        dropDownListView.setListSelectionHidden(false);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.f2027h.setOnScrollListener(this.D);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.A;
            if (onItemSelectedListener != null) {
                this.f2027h.setOnItemSelectedListener(onItemSelectedListener);
            }
            DropDownListView dropDownListView = this.f2027h;
            View view = this.f2040u;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i11 = this.f2041v;
                if (i11 != 0) {
                    if (i11 != 1) {
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f2041v);
                    } else {
                        linearLayout.addView(dropDownListView, layoutParams);
                        linearLayout.addView(view);
                    }
                } else {
                    linearLayout.addView(view);
                    linearLayout.addView(dropDownListView, layoutParams);
                }
                int i12 = this.f2029j;
                if (i12 >= 0) {
                    i10 = Integer.MIN_VALUE;
                } else {
                    i12 = 0;
                    i10 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i12, i10), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i8 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                dropDownListView = linearLayout;
            } else {
                i8 = 0;
            }
            this.K.setContentView(dropDownListView);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.K.getContentView();
            View view2 = this.f2040u;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i8 = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i8 = 0;
            }
        }
        Drawable background = this.K.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            Rect rect = this.H;
            int i13 = rect.top;
            i9 = rect.bottom + i13;
            if (!this.f2033n) {
                this.f2031l = -i13;
            }
        } else {
            this.H.setEmpty();
            i9 = 0;
        }
        if (this.K.getInputMethodMode() != 2) {
            z7 = false;
        }
        int u7 = u(t(), this.f2031l, z7);
        if (!this.f2037r && this.f2028i != -1) {
            int i14 = this.f2029j;
            if (i14 != -2) {
                if (i14 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, Pow2.MAX_POW2);
                } else {
                    int i15 = this.f2025f.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.H;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15 - (rect2.left + rect2.right), Pow2.MAX_POW2);
                }
            } else {
                int i16 = this.f2025f.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.H;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16 - (rect3.left + rect3.right), Integer.MIN_VALUE);
            }
            int d8 = this.f2027h.d(makeMeasureSpec, 0, -1, u7 - i8, -1);
            if (d8 > 0) {
                i8 += i9 + this.f2027h.getPaddingTop() + this.f2027h.getPaddingBottom();
            }
            return d8 + i8;
        }
        return u7 + i9;
    }

    private int u(View view, int i8, boolean z7) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = M;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.K, view, Integer.valueOf(i8), Boolean.valueOf(z7))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.K.getMaxAvailableHeight(view, i8);
        }
        return Api24Impl.a(this.K, view, i8, z7);
    }

    public boolean A() {
        if (this.K.getInputMethodMode() == 2) {
            return true;
        }
        return false;
    }

    public boolean B() {
        return this.J;
    }

    public void D(View view) {
        this.f2043x = view;
    }

    public void E(int i8) {
        this.K.setAnimationStyle(i8);
    }

    public void F(int i8) {
        Drawable background = this.K.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            Rect rect = this.H;
            this.f2029j = rect.left + rect.right + i8;
            return;
        }
        R(i8);
    }

    public void G(int i8) {
        this.f2036q = i8;
    }

    public void H(Rect rect) {
        Rect rect2;
        if (rect != null) {
            rect2 = new Rect(rect);
        } else {
            rect2 = null;
        }
        this.I = rect2;
    }

    public void I(int i8) {
        this.K.setInputMethodMode(i8);
    }

    public void J(boolean z7) {
        this.J = z7;
        this.K.setFocusable(z7);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.K.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2045z = onItemClickListener;
    }

    public void M(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.A = onItemSelectedListener;
    }

    public void N(boolean z7) {
        this.f2035p = true;
        this.f2034o = z7;
    }

    public void P(int i8) {
        this.f2041v = i8;
    }

    public void Q(int i8) {
        DropDownListView dropDownListView = this.f2027h;
        if (c() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i8);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i8, true);
            }
        }
    }

    public void R(int i8) {
        this.f2029j = i8;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void b() {
        boolean z7;
        int i8;
        int i9;
        int i10;
        int i11;
        int q8 = q();
        boolean A = A();
        PopupWindowCompat.b(this.K, this.f2032m);
        boolean z8 = true;
        if (this.K.isShowing()) {
            if (!ViewCompat.V(t())) {
                return;
            }
            int i12 = this.f2029j;
            if (i12 == -1) {
                i12 = -1;
            } else if (i12 == -2) {
                i12 = t().getWidth();
            }
            int i13 = this.f2028i;
            if (i13 == -1) {
                if (!A) {
                    q8 = -1;
                }
                if (A) {
                    PopupWindow popupWindow = this.K;
                    if (this.f2029j == -1) {
                        i11 = -1;
                    } else {
                        i11 = 0;
                    }
                    popupWindow.setWidth(i11);
                    this.K.setHeight(0);
                } else {
                    PopupWindow popupWindow2 = this.K;
                    if (this.f2029j == -1) {
                        i10 = -1;
                    } else {
                        i10 = 0;
                    }
                    popupWindow2.setWidth(i10);
                    this.K.setHeight(-1);
                }
            } else if (i13 != -2) {
                q8 = i13;
            }
            this.K.setOutsideTouchable((this.f2038s || this.f2037r) ? false : false);
            PopupWindow popupWindow3 = this.K;
            View t7 = t();
            int i14 = this.f2030k;
            int i15 = this.f2031l;
            if (i12 < 0) {
                i8 = -1;
            } else {
                i8 = i12;
            }
            if (q8 < 0) {
                i9 = -1;
            } else {
                i9 = q8;
            }
            popupWindow3.update(t7, i14, i15, i8, i9);
            return;
        }
        int i16 = this.f2029j;
        if (i16 == -1) {
            i16 = -1;
        } else if (i16 == -2) {
            i16 = t().getWidth();
        }
        int i17 = this.f2028i;
        if (i17 == -1) {
            q8 = -1;
        } else if (i17 != -2) {
            q8 = i17;
        }
        this.K.setWidth(i16);
        this.K.setHeight(q8);
        O(true);
        PopupWindow popupWindow4 = this.K;
        if (!this.f2038s && !this.f2037r) {
            z7 = true;
        } else {
            z7 = false;
        }
        popupWindow4.setOutsideTouchable(z7);
        this.K.setTouchInterceptor(this.C);
        if (this.f2035p) {
            PopupWindowCompat.a(this.K, this.f2034o);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = N;
            if (method != null) {
                try {
                    method.invoke(this.K, this.I);
                } catch (Exception e8) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e8);
                }
            }
        } else {
            Api29Impl.a(this.K, this.I);
        }
        PopupWindowCompat.c(this.K, t(), this.f2030k, this.f2031l, this.f2036q);
        this.f2027h.setSelection(-1);
        if (!this.J || this.f2027h.isInTouchMode()) {
            r();
        }
        if (!this.J) {
            this.G.post(this.E);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean c() {
        return this.K.isShowing();
    }

    public void d(Drawable drawable) {
        this.K.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.K.dismiss();
        C();
        this.K.setContentView(null);
        this.f2027h = null;
        this.G.removeCallbacks(this.B);
    }

    public int e() {
        return this.f2030k;
    }

    public void f(int i8) {
        this.f2030k = i8;
    }

    public Drawable h() {
        return this.K.getBackground();
    }

    public void j(int i8) {
        this.f2031l = i8;
        this.f2033n = true;
    }

    public int m() {
        if (!this.f2033n) {
            return 0;
        }
        return this.f2031l;
    }

    public void n(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f2042w;
        if (dataSetObserver == null) {
            this.f2042w = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.f2026g;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2026g = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f2042w);
        }
        DropDownListView dropDownListView = this.f2027h;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f2026g);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView p() {
        return this.f2027h;
    }

    public void r() {
        DropDownListView dropDownListView = this.f2027h;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    @NonNull
    DropDownListView s(Context context, boolean z7) {
        return new DropDownListView(context, z7);
    }

    public View t() {
        return this.f2043x;
    }

    public Object v() {
        if (!c()) {
            return null;
        }
        return this.f2027h.getSelectedItem();
    }

    public long w() {
        if (!c()) {
            return Long.MIN_VALUE;
        }
        return this.f2027h.getSelectedItemId();
    }

    public int x() {
        if (!c()) {
            return -1;
        }
        return this.f2027h.getSelectedItemPosition();
    }

    public View y() {
        if (!c()) {
            return null;
        }
        return this.f2027h.getSelectedView();
    }

    public int z() {
        return this.f2029j;
    }

    public ListPopupWindow(@NonNull Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public ListPopupWindow(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        this.f2028i = -2;
        this.f2029j = -2;
        this.f2032m = 1002;
        this.f2036q = 0;
        this.f2037r = false;
        this.f2038s = false;
        this.f2039t = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f2041v = 0;
        this.B = new ResizePopupRunnable();
        this.C = new PopupTouchInterceptor();
        this.D = new PopupScrollListener();
        this.E = new ListSelectorHider();
        this.H = new Rect();
        this.f2025f = context;
        this.G = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1013l1, i8, i9);
        this.f2030k = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.f1018m1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.f1023n1, 0);
        this.f2031l = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2033n = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i8, i9);
        this.K = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
