package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.core.R$id;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class ViewCompat {

    /* renamed from: c  reason: collision with root package name */
    private static Field f5961c;

    /* renamed from: e  reason: collision with root package name */
    private static ThreadLocal<Rect> f5963e;

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f5959a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> f5960b = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f5962d = false;

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f5964f = {R$id.f5486b, R$id.f5487c, R$id.f5498n, R$id.f5509y, R$id.B, R$id.C, R$id.D, R$id.E, R$id.F, R$id.G, R$id.f5488d, R$id.f5489e, R$id.f5490f, R$id.f5491g, R$id.f5492h, R$id.f5493i, R$id.f5494j, R$id.f5495k, R$id.f5496l, R$id.f5497m, R$id.f5499o, R$id.f5500p, R$id.f5501q, R$id.f5502r, R$id.f5503s, R$id.f5504t, R$id.f5505u, R$id.f5506v, R$id.f5507w, R$id.f5508x, R$id.f5510z, R$id.A};

    /* renamed from: g  reason: collision with root package name */
    private static final OnReceiveContentViewBehavior f5965g = new OnReceiveContentViewBehavior() { // from class: androidx.core.view.p
        @Override // androidx.core.view.OnReceiveContentViewBehavior
        public final ContentInfoCompat a(ContentInfoCompat contentInfoCompat) {
            ContentInfoCompat a02;
            a02 = ViewCompat.a0(contentInfoCompat);
            return a02;
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private static final AccessibilityPaneVisibilityManager f5966h = new AccessibilityPaneVisibilityManager();

    /* loaded from: classes.dex */
    static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: f  reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f5967f = new WeakHashMap<>();

        AccessibilityPaneVisibilityManager() {
        }

        private void b(View view, boolean z7) {
            boolean z8;
            int i8;
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z7 != z8) {
                if (z8) {
                    i8 = 16;
                } else {
                    i8 = 32;
                }
                ViewCompat.b0(view, i8);
                this.f5967f.put(view, Boolean.valueOf(z8));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            Api16Impl.o(view.getViewTreeObserver(), this);
        }

        void a(View view) {
            boolean z7;
            WeakHashMap<View, Boolean> weakHashMap = this.f5967f;
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            weakHashMap.put(view, Boolean.valueOf(z7));
            view.addOnAttachStateChangeListener(this);
            if (Api19Impl.b(view)) {
                c(view);
            }
        }

        void d(View view) {
            this.f5967f.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f5967f.entrySet()) {
                    b(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class AccessibilityViewProperty<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f5968a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f5969b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5970c;

        /* renamed from: d  reason: collision with root package name */
        private final int f5971d;

        AccessibilityViewProperty(int i8, Class<T> cls, int i9) {
            this(i8, cls, 0, i9);
        }

        private boolean b() {
            return true;
        }

        private boolean c() {
            if (Build.VERSION.SDK_INT >= this.f5970c) {
                return true;
            }
            return false;
        }

        boolean a(Boolean bool, Boolean bool2) {
            boolean z7;
            boolean z8;
            if (bool != null && bool.booleanValue()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (bool2 != null && bool2.booleanValue()) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z7 == z8) {
                return true;
            }
            return false;
        }

        abstract T d(View view);

        abstract void e(View view, T t7);

        T f(View view) {
            if (c()) {
                return d(view);
            }
            if (b()) {
                T t7 = (T) view.getTag(this.f5968a);
                if (this.f5969b.isInstance(t7)) {
                    return t7;
                }
                return null;
            }
            return null;
        }

        void g(View view, T t7) {
            if (c()) {
                e(view, t7);
            } else if (b() && h(f(view), t7)) {
                ViewCompat.l(view);
                view.setTag(this.f5968a, t7);
                ViewCompat.b0(view, this.f5971d);
            }
        }

        abstract boolean h(T t7, T t8);

        AccessibilityViewProperty(int i8, Class<T> cls, int i9, int i10) {
            this.f5968a = i8;
            this.f5969b = cls;
            this.f5971d = i9;
            this.f5970c = i10;
        }
    }

    /* loaded from: classes.dex */
    static class Api15Impl {
        private Api15Impl() {
        }

        static boolean a(@NonNull View view) {
            return view.hasOnClickListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        static int d(View view) {
            return view.getMinimumHeight();
        }

        static int e(View view) {
            return view.getMinimumWidth();
        }

        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        static boolean i(View view) {
            return view.hasTransientState();
        }

        static boolean j(View view, int i8, Bundle bundle) {
            return view.performAccessibilityAction(i8, bundle);
        }

        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        static void l(View view, int i8, int i9, int i10, int i11) {
            view.postInvalidateOnAnimation(i8, i9, i10, i11);
        }

        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        static void n(View view, Runnable runnable, long j8) {
            view.postOnAnimationDelayed(runnable, j8);
        }

        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        static void p(View view) {
            view.requestFitSystemWindows();
        }

        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        static void r(View view, boolean z7) {
            view.setHasTransientState(z7);
        }

        static void s(View view, int i8) {
            view.setImportantForAccessibility(i8);
        }
    }

    /* loaded from: classes.dex */
    static class Api17Impl {
        private Api17Impl() {
        }

        static int a() {
            return View.generateViewId();
        }

        static Display b(@NonNull View view) {
            return view.getDisplay();
        }

        static int c(View view) {
            return view.getLabelFor();
        }

        static int d(View view) {
            return view.getLayoutDirection();
        }

        static int e(View view) {
            return view.getPaddingEnd();
        }

        static int f(View view) {
            return view.getPaddingStart();
        }

        static boolean g(View view) {
            return view.isPaddingRelative();
        }

        static void h(View view, int i8) {
            view.setLabelFor(i8);
        }

        static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        static void j(View view, int i8) {
            view.setLayoutDirection(i8);
        }

        static void k(View view, int i8, int i9, int i10, int i11) {
            view.setPaddingRelative(i8, i9, i10, i11);
        }
    }

    /* loaded from: classes.dex */
    static class Api18Impl {
        private Api18Impl() {
        }

        static Rect a(@NonNull View view) {
            return view.getClipBounds();
        }

        static boolean b(@NonNull View view) {
            return view.isInLayout();
        }

        static void c(@NonNull View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        static boolean b(@NonNull View view) {
            return view.isAttachedToWindow();
        }

        static boolean c(@NonNull View view) {
            return view.isLaidOut();
        }

        static boolean d(@NonNull View view) {
            return view.isLayoutDirectionResolved();
        }

        static void e(ViewParent viewParent, View view, View view2, int i8) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i8);
        }

        static void f(View view, int i8) {
            view.setAccessibilityLiveRegion(i8);
        }

        static void g(AccessibilityEvent accessibilityEvent, int i8) {
            accessibilityEvent.setContentChangeTypes(i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api20Impl {
        private Api20Impl() {
        }

        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* loaded from: classes.dex */
    private static class Api21Impl {
        private Api21Impl() {
        }

        static void a(@NonNull WindowInsets windowInsets, @NonNull View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.S);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static WindowInsetsCompat b(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            WindowInsets u7 = windowInsetsCompat.u();
            if (u7 != null) {
                return WindowInsetsCompat.w(view.computeSystemWindowInsets(u7, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        static boolean c(@NonNull View view, float f8, float f9, boolean z7) {
            return view.dispatchNestedFling(f8, f9, z7);
        }

        static boolean d(@NonNull View view, float f8, float f9) {
            return view.dispatchNestedPreFling(f8, f9);
        }

        static boolean e(View view, int i8, int i9, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i8, i9, iArr, iArr2);
        }

        static boolean f(View view, int i8, int i9, int i10, int i11, int[] iArr) {
            return view.dispatchNestedScroll(i8, i9, i10, i11, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static WindowInsetsCompat j(@NonNull View view) {
            return WindowInsetsCompat.Api21ReflectionHolder.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(@NonNull View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f8) {
            view.setElevation(f8);
        }

        static void t(View view, boolean z7) {
            view.setNestedScrollingEnabled(z7);
        }

        static void u(@NonNull final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.L, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.S));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.Api21Impl.1

                    /* renamed from: a  reason: collision with root package name */
                    WindowInsetsCompat f5972a = null;

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        WindowInsetsCompat w7 = WindowInsetsCompat.w(windowInsets, view2);
                        int i8 = Build.VERSION.SDK_INT;
                        if (i8 < 30) {
                            Api21Impl.a(windowInsets, view);
                            if (w7.equals(this.f5972a)) {
                                return onApplyWindowInsetsListener.a(view2, w7).u();
                            }
                        }
                        this.f5972a = w7;
                        WindowInsetsCompat a8 = onApplyWindowInsetsListener.a(view2, w7);
                        if (i8 >= 30) {
                            return a8.u();
                        }
                        ViewCompat.p0(view2);
                        return a8.u();
                    }
                });
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f8) {
            view.setTranslationZ(f8);
        }

        static void x(@NonNull View view, float f8) {
            view.setZ(f8);
        }

        static boolean y(View view, int i8) {
            return view.startNestedScroll(i8);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    /* loaded from: classes.dex */
    private static class Api23Impl {
        private Api23Impl() {
        }

        public static WindowInsetsCompat a(@NonNull View view) {
            WindowInsets rootWindowInsets;
            rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat v7 = WindowInsetsCompat.v(rootWindowInsets);
            v7.s(v7);
            v7.d(view.getRootView());
            return v7;
        }

        static int b(@NonNull View view) {
            int scrollIndicators;
            scrollIndicators = view.getScrollIndicators();
            return scrollIndicators;
        }

        static void c(@NonNull View view, int i8) {
            view.setScrollIndicators(i8);
        }

        static void d(@NonNull View view, int i8, int i9) {
            view.setScrollIndicators(i8, i9);
        }
    }

    /* loaded from: classes.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static void a(@NonNull View view) {
            view.cancelDragAndDrop();
        }

        static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        static void d(@NonNull View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        static boolean e(@NonNull View view, ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, Object obj, int i8) {
            boolean startDragAndDrop;
            startDragAndDrop = view.startDragAndDrop(clipData, dragShadowBuilder, obj, i8);
            return startDragAndDrop;
        }

        static void f(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    /* loaded from: classes.dex */
    static class Api26Impl {
        private Api26Impl() {
        }

        static void a(@NonNull View view, Collection<View> collection, int i8) {
            view.addKeyboardNavigationClusters(collection, i8);
        }

        static int b(View view) {
            int importantForAutofill;
            importantForAutofill = view.getImportantForAutofill();
            return importantForAutofill;
        }

        static int c(@NonNull View view) {
            int nextClusterForwardId;
            nextClusterForwardId = view.getNextClusterForwardId();
            return nextClusterForwardId;
        }

        static boolean d(@NonNull View view) {
            boolean hasExplicitFocusable;
            hasExplicitFocusable = view.hasExplicitFocusable();
            return hasExplicitFocusable;
        }

        static boolean e(@NonNull View view) {
            boolean isFocusedByDefault;
            isFocusedByDefault = view.isFocusedByDefault();
            return isFocusedByDefault;
        }

        static boolean f(View view) {
            boolean isImportantForAutofill;
            isImportantForAutofill = view.isImportantForAutofill();
            return isImportantForAutofill;
        }

        static boolean g(@NonNull View view) {
            boolean isKeyboardNavigationCluster;
            isKeyboardNavigationCluster = view.isKeyboardNavigationCluster();
            return isKeyboardNavigationCluster;
        }

        static View h(@NonNull View view, View view2, int i8) {
            View keyboardNavigationClusterSearch;
            keyboardNavigationClusterSearch = view.keyboardNavigationClusterSearch(view2, i8);
            return keyboardNavigationClusterSearch;
        }

        static boolean i(@NonNull View view) {
            boolean restoreDefaultFocus;
            restoreDefaultFocus = view.restoreDefaultFocus();
            return restoreDefaultFocus;
        }

        static void j(@NonNull View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void k(@NonNull View view, boolean z7) {
            view.setFocusedByDefault(z7);
        }

        static void l(View view, int i8) {
            view.setImportantForAutofill(i8);
        }

        static void m(@NonNull View view, boolean z7) {
            view.setKeyboardNavigationCluster(z7);
        }

        static void n(View view, int i8) {
            view.setNextClusterForwardId(i8);
        }

        static void o(@NonNull View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static void a(@NonNull View view, @NonNull final OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            int i8 = R$id.R;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(i8);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(i8, simpleArrayMap);
            }
            Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
            View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener = new View$OnUnhandledKeyEventListener() { // from class: androidx.core.view.x0
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return ViewCompat.OnUnhandledKeyEventListenerCompat.this.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, view$OnUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
        }

        static CharSequence b(View view) {
            CharSequence accessibilityPaneTitle;
            accessibilityPaneTitle = view.getAccessibilityPaneTitle();
            return accessibilityPaneTitle;
        }

        static boolean c(View view) {
            boolean isAccessibilityHeading;
            isAccessibilityHeading = view.isAccessibilityHeading();
            return isAccessibilityHeading;
        }

        static boolean d(View view) {
            boolean isScreenReaderFocusable;
            isScreenReaderFocusable = view.isScreenReaderFocusable();
            return isScreenReaderFocusable;
        }

        static void e(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R$id.R);
            if (simpleArrayMap != null && (view$OnUnhandledKeyEventListener = (View$OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
                view.removeOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
            }
        }

        static <T> T f(View view, int i8) {
            View requireViewById;
            requireViewById = view.requireViewById(i8);
            return (T) requireViewById;
        }

        static void g(View view, boolean z7) {
            view.setAccessibilityHeading(z7);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void i(View view, boolean z7) {
            view.setScreenReaderFocusable(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static View.AccessibilityDelegate a(View view) {
            View.AccessibilityDelegate accessibilityDelegate;
            accessibilityDelegate = view.getAccessibilityDelegate();
            return accessibilityDelegate;
        }

        static List<Rect> b(View view) {
            List<Rect> systemGestureExclusionRects;
            systemGestureExclusionRects = view.getSystemGestureExclusionRects();
            return systemGestureExclusionRects;
        }

        static void c(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, AttributeSet attributeSet, @NonNull TypedArray typedArray, int i8, int i9) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i8, i9);
        }

        static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        static CharSequence a(View view) {
            CharSequence stateDescription;
            stateDescription = view.getStateDescription();
            return stateDescription;
        }

        static void b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* loaded from: classes.dex */
    private static final class Api31Impl {
        private Api31Impl() {
        }

        public static String[] a(@NonNull View view) {
            String[] receiveContentMimeTypes;
            receiveContentMimeTypes = view.getReceiveContentMimeTypes();
            return receiveContentMimeTypes;
        }

        public static ContentInfoCompat b(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
            ContentInfo performReceiveContent;
            ContentInfo f8 = contentInfoCompat.f();
            performReceiveContent = view.performReceiveContent(f8);
            if (performReceiveContent == null) {
                return null;
            }
            if (performReceiveContent == f8) {
                return contentInfoCompat;
            }
            return ContentInfoCompat.g(performReceiveContent);
        }

        public static void c(@NonNull View view, String[] strArr, OnReceiveContentListener onReceiveContentListener) {
            if (onReceiveContentListener == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new OnReceiveContentListenerAdapter(onReceiveContentListener));
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final OnReceiveContentListener f5975a;

        OnReceiveContentListenerAdapter(@NonNull OnReceiveContentListener onReceiveContentListener) {
            this.f5975a = onReceiveContentListener;
        }

        public ContentInfo onReceiveContent(@NonNull View view, @NonNull ContentInfo contentInfo) {
            ContentInfoCompat g8 = ContentInfoCompat.g(contentInfo);
            ContentInfoCompat a8 = this.f5975a.a(view, g8);
            if (a8 == null) {
                return null;
            }
            if (a8 == g8) {
                return contentInfo;
            }
            return a8.f();
        }
    }

    /* loaded from: classes.dex */
    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    static class UnhandledKeyEventManager {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f5976d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f5977a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f5978b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<KeyEvent> f5979c = null;

        UnhandledKeyEventManager() {
        }

        static UnhandledKeyEventManager a(View view) {
            int i8 = R$id.Q;
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(i8);
            if (unhandledKeyEventManager == null) {
                UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
                view.setTag(i8, unhandledKeyEventManager2);
                return unhandledKeyEventManager2;
            }
            return unhandledKeyEventManager;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f5977a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c8 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c8 != null) {
                            return c8;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f5978b == null) {
                this.f5978b = new SparseArray<>();
            }
            return this.f5978b;
        }

        private boolean e(@NonNull View view, @NonNull KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R$id.R);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f5977a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f5976d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f5977a == null) {
                    this.f5977a = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f5976d;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f5977a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f5977a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c8 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c8 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(c8));
                }
            }
            if (c8 != null) {
                return true;
            }
            return false;
        }

        boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f5979c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f5979c = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference2 = null;
            SparseArray<WeakReference<View>> d8 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d8.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d8.valueAt(indexOfKey);
                d8.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d8.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = weakReference2.get();
            if (view != null && ViewCompat.V(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    @Deprecated
    protected ViewCompat() {
    }

    private static OnReceiveContentViewBehavior A(@NonNull View view) {
        if (view instanceof OnReceiveContentViewBehavior) {
            return (OnReceiveContentViewBehavior) view;
        }
        return f5965g;
    }

    public static void A0(@NonNull View view, float f8) {
        Api21Impl.s(view, f8);
    }

    public static boolean B(@NonNull View view) {
        return Api16Impl.b(view);
    }

    @Deprecated
    public static void B0(View view, boolean z7) {
        view.setFitsSystemWindows(z7);
    }

    public static int C(@NonNull View view) {
        return Api16Impl.c(view);
    }

    public static void C0(@NonNull View view, boolean z7) {
        Api16Impl.r(view, z7);
    }

    @SuppressLint({"InlinedApi"})
    public static int D(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(view);
        }
        return 0;
    }

    public static void D0(@NonNull View view, int i8) {
        Api16Impl.s(view, i8);
    }

    public static int E(@NonNull View view) {
        return Api17Impl.d(view);
    }

    public static void E0(@NonNull View view, int i8) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.l(view, i8);
        }
    }

    public static int F(@NonNull View view) {
        return Api16Impl.d(view);
    }

    public static void F0(@NonNull View view, int i8) {
        Api17Impl.h(view, i8);
    }

    public static int G(@NonNull View view) {
        return Api16Impl.e(view);
    }

    public static void G0(@NonNull View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Api21Impl.u(view, onApplyWindowInsetsListener);
    }

    public static String[] H(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.a(view);
        }
        return (String[]) view.getTag(R$id.N);
    }

    public static void H0(@NonNull View view, int i8, int i9, int i10, int i11) {
        Api17Impl.k(view, i8, i9, i10, i11);
    }

    public static int I(@NonNull View view) {
        return Api17Impl.e(view);
    }

    public static void I0(@NonNull View view, PointerIconCompat pointerIconCompat) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (pointerIconCompat != null) {
                obj = pointerIconCompat.a();
            } else {
                obj = null;
            }
            Api24Impl.d(view, (PointerIcon) obj);
        }
    }

    public static int J(@NonNull View view) {
        return Api17Impl.f(view);
    }

    public static void J0(@NonNull View view, boolean z7) {
        r0().g(view, Boolean.valueOf(z7));
    }

    public static WindowInsetsCompat K(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(view);
        }
        return Api21Impl.j(view);
    }

    public static void K0(@NonNull View view, int i8, int i9) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.d(view, i8, i9);
        }
    }

    public static CharSequence L(@NonNull View view) {
        return Q0().f(view);
    }

    public static void L0(@NonNull View view, CharSequence charSequence) {
        Q0().g(view, charSequence);
    }

    public static String M(@NonNull View view) {
        return Api21Impl.k(view);
    }

    public static void M0(@NonNull View view, String str) {
        Api21Impl.v(view, str);
    }

    public static float N(@NonNull View view) {
        return Api21Impl.l(view);
    }

    public static void N0(@NonNull View view, float f8) {
        Api21Impl.w(view, f8);
    }

    @Deprecated
    public static int O(@NonNull View view) {
        return Api16Impl.g(view);
    }

    private static void O0(View view) {
        if (C(view) == 0) {
            D0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (C((View) parent) == 4) {
                D0(view, 2);
                return;
            }
        }
    }

    public static float P(@NonNull View view) {
        return Api21Impl.m(view);
    }

    public static void P0(@NonNull View view, float f8) {
        Api21Impl.x(view, f8);
    }

    public static boolean Q(@NonNull View view) {
        if (o(view) != null) {
            return true;
        }
        return false;
    }

    private static AccessibilityViewProperty<CharSequence> Q0() {
        return new AccessibilityViewProperty<CharSequence>(R$id.P, CharSequence.class, 64, 30) { // from class: androidx.core.view.ViewCompat.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: i */
            public CharSequence d(View view) {
                return Api30Impl.a(view);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: j */
            public void e(View view, CharSequence charSequence) {
                Api30Impl.b(view, charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: k */
            public boolean h(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static boolean R(@NonNull View view) {
        return Api15Impl.a(view);
    }

    public static void R0(@NonNull View view) {
        Api21Impl.z(view);
    }

    public static boolean S(@NonNull View view) {
        return Api16Impl.h(view);
    }

    private static void S0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static boolean T(@NonNull View view) {
        return Api16Impl.i(view);
    }

    public static boolean U(@NonNull View view) {
        Boolean f8 = b().f(view);
        if (f8 != null && f8.booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean V(@NonNull View view) {
        return Api19Impl.b(view);
    }

    public static boolean W(@NonNull View view) {
        return Api19Impl.c(view);
    }

    public static boolean X(@NonNull View view) {
        return Api21Impl.p(view);
    }

    public static boolean Y(@NonNull View view) {
        return Api17Impl.g(view);
    }

    public static boolean Z(@NonNull View view) {
        Boolean f8 = r0().f(view);
        if (f8 != null && f8.booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ContentInfoCompat a0(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }

    private static AccessibilityViewProperty<Boolean> b() {
        return new AccessibilityViewProperty<Boolean>(R$id.J, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: i */
            public Boolean d(View view) {
                return Boolean.valueOf(Api28Impl.c(view));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: j */
            public void e(View view, Boolean bool) {
                Api28Impl.g(view, bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: k */
            public boolean h(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    static void b0(View view, int i8) {
        boolean z7;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        if (r(view) != null && view.isShown() && view.getWindowVisibility() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        int i9 = 32;
        if (q(view) == 0 && !z7) {
            if (i8 == 32) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                Api19Impl.g(obtain, i8);
                obtain.setSource(view);
                view.onPopulateAccessibilityEvent(obtain);
                obtain.getText().add(r(view));
                accessibilityManager.sendAccessibilityEvent(obtain);
                return;
            } else if (view.getParent() != null) {
                try {
                    Api19Impl.e(view.getParent(), view, view, i8);
                    return;
                } catch (AbstractMethodError e8) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e8);
                    return;
                }
            } else {
                return;
            }
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
        if (!z7) {
            i9 = 2048;
        }
        obtain2.setEventType(i9);
        Api19Impl.g(obtain2, i8);
        if (z7) {
            obtain2.getText().add(r(view));
            O0(view);
        }
        view.sendAccessibilityEventUnchecked(obtain2);
    }

    public static int c(@NonNull View view, @NonNull CharSequence charSequence, @NonNull AccessibilityViewCommand accessibilityViewCommand) {
        int t7 = t(view, charSequence);
        if (t7 != -1) {
            d(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(t7, charSequence, accessibilityViewCommand));
        }
        return t7;
    }

    public static void c0(@NonNull View view, int i8) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i8);
            return;
        }
        Rect z7 = z();
        boolean z8 = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            z7.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z8 = !z7.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        f(view, i8);
        if (z8 && z7.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(z7);
        }
    }

    private static void d(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        l(view);
        n0(accessibilityActionCompat.b(), view);
        s(view).add(accessibilityActionCompat);
        b0(view, 0);
    }

    public static void d0(@NonNull View view, int i8) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i8);
            return;
        }
        Rect z7 = z();
        boolean z8 = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            z7.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z8 = !z7.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        g(view, i8);
        if (z8 && z7.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(z7);
        }
    }

    @NonNull
    public static ViewPropertyAnimatorCompat e(@NonNull View view) {
        if (f5960b == null) {
            f5960b = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = f5960b.get(view);
        if (viewPropertyAnimatorCompat == null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            f5960b.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }
        return viewPropertyAnimatorCompat;
    }

    @NonNull
    public static WindowInsetsCompat e0(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets u7 = windowInsetsCompat.u();
        if (u7 != null) {
            WindowInsets b8 = Api20Impl.b(view, u7);
            if (!b8.equals(u7)) {
                return WindowInsetsCompat.w(b8, view);
            }
        }
        return windowInsetsCompat;
    }

    private static void f(View view, int i8) {
        view.offsetLeftAndRight(i8);
        if (view.getVisibility() == 0) {
            S0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                S0((View) parent);
            }
        }
    }

    public static void f0(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.z0());
    }

    private static void g(View view, int i8) {
        view.offsetTopAndBottom(i8);
        if (view.getVisibility() == 0) {
            S0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                S0((View) parent);
            }
        }
    }

    private static AccessibilityViewProperty<CharSequence> g0() {
        return new AccessibilityViewProperty<CharSequence>(R$id.K, CharSequence.class, 8, 28) { // from class: androidx.core.view.ViewCompat.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: i */
            public CharSequence d(View view) {
                return Api28Impl.b(view);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: j */
            public void e(View view, CharSequence charSequence) {
                Api28Impl.h(view, charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: k */
            public boolean h(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    @NonNull
    public static WindowInsetsCompat h(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        return Api21Impl.b(view, windowInsetsCompat, rect);
    }

    public static boolean h0(@NonNull View view, int i8, Bundle bundle) {
        return Api16Impl.j(view, i8, bundle);
    }

    @NonNull
    public static WindowInsetsCompat i(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets u7 = windowInsetsCompat.u();
        if (u7 != null) {
            WindowInsets a8 = Api20Impl.a(view, u7);
            if (!a8.equals(u7)) {
                return WindowInsetsCompat.w(a8, view);
            }
        }
        return windowInsetsCompat;
    }

    public static ContentInfoCompat i0(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.b(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R$id.M);
        if (onReceiveContentListener != null) {
            ContentInfoCompat a8 = onReceiveContentListener.a(view, contentInfoCompat);
            if (a8 == null) {
                return null;
            }
            return A(view).a(a8);
        }
        return A(view).a(contentInfoCompat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.a(view).b(view, keyEvent);
    }

    public static void j0(@NonNull View view) {
        Api16Impl.k(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.a(view).f(keyEvent);
    }

    public static void k0(@NonNull View view, @NonNull Runnable runnable) {
        Api16Impl.m(view, runnable);
    }

    static void l(@NonNull View view) {
        AccessibilityDelegateCompat n8 = n(view);
        if (n8 == null) {
            n8 = new AccessibilityDelegateCompat();
        }
        s0(view, n8);
    }

    @SuppressLint({"LambdaLast"})
    public static void l0(@NonNull View view, @NonNull Runnable runnable, long j8) {
        Api16Impl.n(view, runnable, j8);
    }

    public static int m() {
        return Api17Impl.a();
    }

    public static void m0(@NonNull View view, int i8) {
        n0(i8, view);
        b0(view, 0);
    }

    public static AccessibilityDelegateCompat n(@NonNull View view) {
        View.AccessibilityDelegate o8 = o(view);
        if (o8 == null) {
            return null;
        }
        if (o8 instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
            return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) o8).f5918a;
        }
        return new AccessibilityDelegateCompat(o8);
    }

    private static void n0(int i8, View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> s7 = s(view);
        for (int i9 = 0; i9 < s7.size(); i9++) {
            if (s7.get(i9).b() == i8) {
                s7.remove(i9);
                return;
            }
        }
    }

    private static View.AccessibilityDelegate o(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(view);
        }
        return p(view);
    }

    public static void o0(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            m0(view, accessibilityActionCompat.b());
        } else {
            d(view, accessibilityActionCompat.a(charSequence, accessibilityViewCommand));
        }
    }

    private static View.AccessibilityDelegate p(@NonNull View view) {
        if (f5962d) {
            return null;
        }
        if (f5961c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f5961c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f5962d = true;
                return null;
            }
        }
        try {
            Object obj = f5961c.get(view);
            if (!(obj instanceof View.AccessibilityDelegate)) {
                return null;
            }
            return (View.AccessibilityDelegate) obj;
        } catch (Throwable unused2) {
            f5962d = true;
            return null;
        }
    }

    public static void p0(@NonNull View view) {
        Api20Impl.c(view);
    }

    public static int q(@NonNull View view) {
        return Api19Impl.a(view);
    }

    public static void q0(@NonNull View view, @NonNull @SuppressLint({"ContextFirst"}) Context context, @NonNull int[] iArr, AttributeSet attributeSet, @NonNull TypedArray typedArray, int i8, int i9) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.c(view, context, iArr, attributeSet, typedArray, i8, i9);
        }
    }

    public static CharSequence r(@NonNull View view) {
        return g0().f(view);
    }

    private static AccessibilityViewProperty<Boolean> r0() {
        return new AccessibilityViewProperty<Boolean>(R$id.O, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: i */
            public Boolean d(@NonNull View view) {
                return Boolean.valueOf(Api28Impl.d(view));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: j */
            public void e(@NonNull View view, Boolean bool) {
                Api28Impl.i(view, bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: k */
            public boolean h(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> s(View view) {
        int i8 = R$id.H;
        ArrayList arrayList = (ArrayList) view.getTag(i8);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(i8, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static void s0(@NonNull View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        View.AccessibilityDelegate d8;
        if (accessibilityDelegateCompat == null && (o(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (accessibilityDelegateCompat == null) {
            d8 = null;
        } else {
            d8 = accessibilityDelegateCompat.d();
        }
        view.setAccessibilityDelegate(d8);
    }

    private static int t(View view, @NonNull CharSequence charSequence) {
        boolean z7;
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> s7 = s(view);
        for (int i8 = 0; i8 < s7.size(); i8++) {
            if (TextUtils.equals(charSequence, s7.get(i8).c())) {
                return s7.get(i8).b();
            }
        }
        int i9 = 0;
        int i10 = -1;
        while (true) {
            int[] iArr = f5964f;
            if (i9 >= iArr.length || i10 != -1) {
                break;
            }
            int i11 = iArr[i9];
            boolean z8 = true;
            for (int i12 = 0; i12 < s7.size(); i12++) {
                if (s7.get(i12).b() != i11) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 &= z7;
            }
            if (z8) {
                i10 = i11;
            }
            i9++;
        }
        return i10;
    }

    public static void t0(@NonNull View view, boolean z7) {
        b().g(view, Boolean.valueOf(z7));
    }

    public static ColorStateList u(@NonNull View view) {
        return Api21Impl.g(view);
    }

    public static void u0(@NonNull View view, int i8) {
        Api19Impl.f(view, i8);
    }

    public static PorterDuff.Mode v(@NonNull View view) {
        return Api21Impl.h(view);
    }

    public static void v0(@NonNull View view, CharSequence charSequence) {
        g0().g(view, charSequence);
        if (charSequence != null) {
            f5966h.a(view);
        } else {
            f5966h.d(view);
        }
    }

    public static Rect w(@NonNull View view) {
        return Api18Impl.a(view);
    }

    public static void w0(@NonNull View view, Drawable drawable) {
        Api16Impl.q(view, drawable);
    }

    public static Display x(@NonNull View view) {
        return Api17Impl.b(view);
    }

    public static void x0(@NonNull View view, ColorStateList colorStateList) {
        boolean z7;
        int i8 = Build.VERSION.SDK_INT;
        Api21Impl.q(view, colorStateList);
        if (i8 == 21) {
            Drawable background = view.getBackground();
            if (Api21Impl.g(view) == null && Api21Impl.h(view) == null) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (background != null && z7) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                Api16Impl.q(view, background);
            }
        }
    }

    public static float y(@NonNull View view) {
        return Api21Impl.i(view);
    }

    public static void y0(@NonNull View view, PorterDuff.Mode mode) {
        boolean z7;
        int i8 = Build.VERSION.SDK_INT;
        Api21Impl.r(view, mode);
        if (i8 == 21) {
            Drawable background = view.getBackground();
            if (Api21Impl.g(view) == null && Api21Impl.h(view) == null) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (background != null && z7) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                Api16Impl.q(view, background);
            }
        }
    }

    private static Rect z() {
        if (f5963e == null) {
            f5963e = new ThreadLocal<>();
        }
        Rect rect = f5963e.get();
        if (rect == null) {
            rect = new Rect();
            f5963e.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void z0(@NonNull View view, Rect rect) {
        Api18Impl.c(view, rect);
    }
}
