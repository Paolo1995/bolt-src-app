package ee.mtakso.driver.uikit.onbordingtooltips;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uikit.R$color;
import ee.mtakso.driver.uikit.R$drawable;
import ee.mtakso.driver.uikit.R$id;
import ee.mtakso.driver.uikit.R$layout;
import ee.mtakso.driver.uikit.internal.drawable.RippleDrawableHelper;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jctools.util.Pow2;

/* compiled from: TooltipOnbordingDelegate.kt */
/* loaded from: classes5.dex */
public final class TooltipOnbordingDelegate {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f35950k = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private static final int f35951l = Dimens.c(56);

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f35952a;

    /* renamed from: b  reason: collision with root package name */
    private final RecyclerView f35953b;

    /* renamed from: c  reason: collision with root package name */
    private final DiffAdapter f35954c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f35955d;

    /* renamed from: e  reason: collision with root package name */
    private List<TooltipElement> f35956e;

    /* renamed from: f  reason: collision with root package name */
    private int f35957f;

    /* renamed from: g  reason: collision with root package name */
    private final Lazy f35958g;

    /* renamed from: h  reason: collision with root package name */
    private PopupWindow f35959h;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f35960i;

    /* renamed from: j  reason: collision with root package name */
    private final Rect f35961j;

    /* compiled from: TooltipOnbordingDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TooltipOnbordingDelegate.kt */
    /* loaded from: classes5.dex */
    public enum TooltipAllignment {
        START,
        CENTER,
        END
    }

    /* compiled from: TooltipOnbordingDelegate.kt */
    /* loaded from: classes5.dex */
    public static abstract class TooltipAnchor {

        /* compiled from: TooltipOnbordingDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class ListItem extends TooltipAnchor {

            /* renamed from: a  reason: collision with root package name */
            private final String f35967a;

            /* renamed from: b  reason: collision with root package name */
            private final Integer f35968b;

            public /* synthetic */ ListItem(String str, Integer num, int i8, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i8 & 2) != 0 ? null : num);
            }

            public final String a() {
                return this.f35967a;
            }

            public final Integer b() {
                return this.f35968b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ListItem) {
                    ListItem listItem = (ListItem) obj;
                    return Intrinsics.a(this.f35967a, listItem.f35967a) && Intrinsics.a(this.f35968b, listItem.f35968b);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.f35967a.hashCode() * 31;
                Integer num = this.f35968b;
                return hashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                String str = this.f35967a;
                Integer num = this.f35968b;
                return "ListItem(listId=" + str + ", resId=" + num + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ListItem(String listId, Integer num) {
                super(null);
                Intrinsics.f(listId, "listId");
                this.f35967a = listId;
                this.f35968b = num;
            }
        }

        /* compiled from: TooltipOnbordingDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class ViewItem extends TooltipAnchor {

            /* renamed from: a  reason: collision with root package name */
            private final int f35969a;

            public final int a() {
                return this.f35969a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ViewItem) && this.f35969a == ((ViewItem) obj).f35969a;
            }

            public int hashCode() {
                return this.f35969a;
            }

            public String toString() {
                int i8 = this.f35969a;
                return "ViewItem(resId=" + i8 + ")";
            }
        }

        private TooltipAnchor() {
        }

        public /* synthetic */ TooltipAnchor(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TooltipOnbordingDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class TooltipElement {

        /* renamed from: a  reason: collision with root package name */
        private final Text f35970a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f35971b;

        /* renamed from: c  reason: collision with root package name */
        private final TooltipAllignment f35972c;

        /* renamed from: d  reason: collision with root package name */
        private final TooltipAnchor f35973d;

        public TooltipElement(Text title, Text text, TooltipAllignment alignmnt, TooltipAnchor anchor) {
            Intrinsics.f(title, "title");
            Intrinsics.f(text, "text");
            Intrinsics.f(alignmnt, "alignmnt");
            Intrinsics.f(anchor, "anchor");
            this.f35970a = title;
            this.f35971b = text;
            this.f35972c = alignmnt;
            this.f35973d = anchor;
        }

        public final TooltipAllignment a() {
            return this.f35972c;
        }

        public final TooltipAnchor b() {
            return this.f35973d;
        }

        public final Text c() {
            return this.f35971b;
        }

        public final Text d() {
            return this.f35970a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TooltipElement) {
                TooltipElement tooltipElement = (TooltipElement) obj;
                return Intrinsics.a(this.f35970a, tooltipElement.f35970a) && Intrinsics.a(this.f35971b, tooltipElement.f35971b) && this.f35972c == tooltipElement.f35972c && Intrinsics.a(this.f35973d, tooltipElement.f35973d);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f35970a.hashCode() * 31) + this.f35971b.hashCode()) * 31) + this.f35972c.hashCode()) * 31) + this.f35973d.hashCode();
        }

        public String toString() {
            Text text = this.f35970a;
            Text text2 = this.f35971b;
            TooltipAllignment tooltipAllignment = this.f35972c;
            TooltipAnchor tooltipAnchor = this.f35973d;
            return "TooltipElement(title=" + text + ", text=" + text2 + ", alignmnt=" + tooltipAllignment + ", anchor=" + tooltipAnchor + ")";
        }
    }

    public TooltipOnbordingDelegate(ViewGroup rootLayout, RecyclerView recyclerView, DiffAdapter diffAdapter, Function0<Unit> onFinished) {
        List<TooltipElement> k8;
        Lazy b8;
        Intrinsics.f(rootLayout, "rootLayout");
        Intrinsics.f(onFinished, "onFinished");
        this.f35952a = rootLayout;
        this.f35953b = recyclerView;
        this.f35954c = diffAdapter;
        this.f35955d = onFinished;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f35956e = k8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Context>() { // from class: ee.mtakso.driver.uikit.onbordingtooltips.TooltipOnbordingDelegate$context$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Context invoke() {
                return TooltipOnbordingDelegate.this.m().getContext();
            }
        });
        this.f35958g = b8;
        this.f35960i = new Rect();
        this.f35961j = new Rect();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void e(final PopupWindow popupWindow, final ViewGroup viewGroup) {
        popupWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: ee.mtakso.driver.uikit.onbordingtooltips.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean f8;
                f8 = TooltipOnbordingDelegate.f(viewGroup, popupWindow, view, motionEvent);
                return f8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(ViewGroup popupLayout, PopupWindow this_dismissToolTipOnTapOutside, View view, MotionEvent motionEvent) {
        Intrinsics.f(popupLayout, "$popupLayout");
        Intrinsics.f(this_dismissToolTipOnTapOutside, "$this_dismissToolTipOnTapOutside");
        Rect rect = new Rect();
        popupLayout.getGlobalVisibleRect(rect);
        if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            this_dismissToolTipOnTapOutside.dismiss();
            return true;
        }
        return false;
    }

    private final View g(TooltipAnchor.ListItem listItem) {
        IntRange o8;
        int v7;
        Object obj;
        View findViewById;
        String str;
        RecyclerView recyclerView = this.f35953b;
        if (recyclerView == null || this.f35954c == null) {
            return null;
        }
        o8 = RangesKt___RangesKt.o(0, recyclerView.getChildCount());
        v7 = CollectionsKt__IterablesKt.v(o8, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<Integer> it = o8.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f35953b.getChildAt(((IntIterator) it).nextInt()));
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                ListModel R = this.f35954c.R(this.f35953b.j0((View) obj).l());
                if (R != null) {
                    str = R.m();
                } else {
                    str = null;
                }
                if (Intrinsics.a(str, listItem.a())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        View view = (View) obj;
        if (view == null) {
            return null;
        }
        listItem.b();
        Integer b8 = listItem.b();
        if (b8 != null && (findViewById = view.findViewById(b8.intValue())) != null) {
            return findViewById;
        }
        return view;
    }

    private final View h(TooltipAnchor.ViewItem viewItem) {
        return this.f35952a.findViewById(viewItem.a());
    }

    private final View i(TooltipAnchor tooltipAnchor) {
        if (tooltipAnchor instanceof TooltipAnchor.ViewItem) {
            return h((TooltipAnchor.ViewItem) tooltipAnchor);
        }
        if (tooltipAnchor instanceof TooltipAnchor.ListItem) {
            return g((TooltipAnchor.ListItem) tooltipAnchor);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Context j() {
        return (Context) this.f35958g.getValue();
    }

    private final int l() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i8;
        View view = this.f35952a;
        int i9 = 0;
        for (int i10 = 50; view != null && i10 > 0; i10--) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                i8 = marginLayoutParams.topMargin;
            } else {
                i8 = 0;
            }
            i9 += i8;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return i9;
    }

    private final void p() {
        boolean z7;
        boolean z8 = false;
        this.f35957f = 0;
        do {
            z7 = true;
            if (o()) {
                this.f35955d.invoke();
                continue;
            } else {
                if (z8) {
                    this.f35957f++;
                }
                z7 = v();
                z8 = true;
                continue;
            }
        } while (!z7);
    }

    private final void q() {
        boolean z7;
        do {
            z7 = true;
            if (o()) {
                this.f35955d.invoke();
                continue;
            } else {
                this.f35957f++;
                z7 = v();
                continue;
            }
        } while (!z7);
    }

    private final void r(ViewGroup viewGroup, int i8, int i9) {
        IntRange o8;
        boolean z7;
        viewGroup.removeAllViews();
        if (i9 <= 0) {
            return;
        }
        o8 = RangesKt___RangesKt.o(0, i9);
        Iterator<Integer> it = o8.iterator();
        while (it.hasNext()) {
            if (((IntIterator) it).nextInt() == i8) {
                z7 = true;
            } else {
                z7 = false;
            }
            n(viewGroup, z7);
        }
    }

    private final void s(TooltipElement tooltipElement, ViewGroup viewGroup) {
        int i8;
        int color = ContextCompat.getColor(j(), R$color.f35750b);
        int color2 = ContextCompat.getColor(j(), R$color.f35749a);
        Text d8 = tooltipElement.d();
        Context context = j();
        Intrinsics.e(context, "context");
        ((AppCompatTextView) viewGroup.findViewById(R$id.f35759m)).setText(TextKt.a(d8, context));
        Text c8 = tooltipElement.c();
        Context context2 = j();
        Intrinsics.e(context2, "context");
        ((AppCompatTextView) viewGroup.findViewById(R$id.f35758l)).setText(TextKt.a(c8, context2));
        RippleDrawableHelper rippleDrawableHelper = RippleDrawableHelper.f35939a;
        int i9 = R$id.f35757h;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewGroup.findViewById(i9);
        Intrinsics.e(appCompatImageView, "popupLayout.nextButton");
        rippleDrawableHelper.a(appCompatImageView, color, color2);
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R$id.tabIndicatorLayout);
        Intrinsics.e(linearLayout, "popupLayout.tabIndicatorLayout");
        r(linearLayout, this.f35957f, this.f35956e.size());
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewGroup.findViewById(i9);
        if (o()) {
            i8 = R$drawable.ic_close_24dp_white;
        } else {
            i8 = R$drawable.ic_forward_arrow;
        }
        appCompatImageView2.setImageResource(i8);
        ((AppCompatImageView) viewGroup.findViewById(i9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uikit.onbordingtooltips.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TooltipOnbordingDelegate.t(TooltipOnbordingDelegate.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(TooltipOnbordingDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        PopupWindow popupWindow = this$0.f35959h;
        if (popupWindow == null) {
            Intrinsics.w("popupWindow");
            popupWindow = null;
        }
        popupWindow.dismiss();
        if (this$0.o()) {
            this$0.f35955d.invoke();
        } else {
            this$0.q();
        }
    }

    private final boolean v() {
        final boolean z7;
        final TooltipElement k8 = k();
        if (k8 == null) {
            return false;
        }
        View inflate = LayoutInflater.from(j()).inflate(R$layout.popout_layout, this.f35952a, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        final ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        s(k8, constraintLayout);
        View i8 = i(k8.b());
        if (i8 == null) {
            return false;
        }
        PopupWindow popupWindow = new PopupWindow(j());
        this.f35959h = popupWindow;
        popupWindow.setContentView(constraintLayout);
        PopupWindow popupWindow2 = this.f35959h;
        PopupWindow popupWindow3 = null;
        if (popupWindow2 == null) {
            Intrinsics.w("popupWindow");
            popupWindow2 = null;
        }
        popupWindow2.setWidth(this.f35952a.getWidth());
        PopupWindow popupWindow4 = this.f35959h;
        if (popupWindow4 == null) {
            Intrinsics.w("popupWindow");
            popupWindow4 = null;
        }
        popupWindow4.setBackgroundDrawable(new ColorDrawable(0));
        constraintLayout.setAlpha(0.0f);
        final ConstraintLayout constraintLayout2 = (ConstraintLayout) constraintLayout.findViewById(R$id.popupRoot);
        constraintLayout2.measure(View.MeasureSpec.makeMeasureSpec(this.f35952a.getWidth(), Pow2.MAX_POW2), 0);
        i8.getGlobalVisibleRect(this.f35960i);
        this.f35952a.getGlobalVisibleRect(this.f35961j);
        Rect rect = this.f35960i;
        int i9 = rect.top;
        Rect rect2 = this.f35961j;
        int i10 = i9 - rect2.top;
        int i11 = rect2.bottom - rect.bottom;
        int i12 = 80;
        if (this.f35952a.getResources().getConfiguration().orientation == 1) {
            if (i11 >= i10) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                i12 = 48;
            }
            constraintLayout.getLayoutParams().width = this.f35952a.getWidth();
            if (z7) {
                i10 = i11;
            }
            if (constraintLayout2.getMeasuredHeight() > i10) {
                int measuredHeight = constraintLayout2.getMeasuredHeight() - i10;
                int measuredHeight2 = constraintLayout2.getMeasuredHeight();
                int i13 = R$id.contentScrollParent;
                ((NestedScrollView) constraintLayout2.findViewById(i13)).getLayoutParams().height = (((ConstraintLayout) constraintLayout2.findViewById(R$id.popupContent)).getMeasuredHeight() - measuredHeight) - (measuredHeight2 - ((NestedScrollView) constraintLayout2.findViewById(i13)).getMeasuredHeight());
            }
            constraintLayout.post(new Runnable() { // from class: ee.mtakso.driver.uikit.onbordingtooltips.a
                @Override // java.lang.Runnable
                public final void run() {
                    TooltipOnbordingDelegate.w(TooltipOnbordingDelegate.this, k8, constraintLayout, z7);
                }
            });
        } else {
            if (constraintLayout2.getMeasuredHeight() > i11) {
                int measuredHeight3 = constraintLayout2.getMeasuredHeight();
                int i14 = R$id.contentScrollParent;
                int measuredHeight4 = measuredHeight3 - ((NestedScrollView) constraintLayout2.findViewById(i14)).getMeasuredHeight();
                if (i11 != 0 && i11 > i10) {
                    ((NestedScrollView) constraintLayout2.findViewById(i14)).getLayoutParams().height = i11;
                } else if (i10 != 0 && i10 > i11 && i10 < this.f35961j.height()) {
                    if (((AppCompatTextView) constraintLayout2.findViewById(R$id.f35758l)).getMeasuredHeight() < 160) {
                        ((NestedScrollView) constraintLayout2.findViewById(i14)).getLayoutParams().height = ((NestedScrollView) constraintLayout2.findViewById(i14)).getMeasuredHeight();
                    } else {
                        ((NestedScrollView) constraintLayout2.findViewById(i14)).getLayoutParams().height = i10 - measuredHeight4;
                    }
                } else {
                    ((NestedScrollView) constraintLayout2.findViewById(i14)).getLayoutParams().height = this.f35961j.height() - measuredHeight4;
                }
            }
            constraintLayout.post(new Runnable() { // from class: ee.mtakso.driver.uikit.onbordingtooltips.b
                @Override // java.lang.Runnable
                public final void run() {
                    TooltipOnbordingDelegate.x(TooltipOnbordingDelegate.this, constraintLayout2, constraintLayout);
                }
            });
        }
        if (o()) {
            PopupWindow popupWindow5 = this.f35959h;
            if (popupWindow5 == null) {
                Intrinsics.w("popupWindow");
                popupWindow5 = null;
            }
            popupWindow5.setOutsideTouchable(true);
            PopupWindow popupWindow6 = this.f35959h;
            if (popupWindow6 == null) {
                Intrinsics.w("popupWindow");
                popupWindow6 = null;
            }
            e(popupWindow6, constraintLayout);
        } else {
            PopupWindow popupWindow7 = this.f35959h;
            if (popupWindow7 == null) {
                Intrinsics.w("popupWindow");
                popupWindow7 = null;
            }
            popupWindow7.setOutsideTouchable(false);
        }
        PopupWindow popupWindow8 = this.f35959h;
        if (popupWindow8 == null) {
            Intrinsics.w("popupWindow");
        } else {
            popupWindow3 = popupWindow8;
        }
        popupWindow3.showAtLocation(this.f35952a, i12, 0, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(TooltipOnbordingDelegate this$0, TooltipElement element, ConstraintLayout popupLayout, boolean z7) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(element, "$element");
        Intrinsics.f(popupLayout, "$popupLayout");
        this$0.y(element, popupLayout, this$0.f35960i, this$0.f35961j, z7);
        popupLayout.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(TooltipOnbordingDelegate this$0, ConstraintLayout constraintLayout, ConstraintLayout popupLayout) {
        int b02;
        int i8;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(popupLayout, "$popupLayout");
        b02 = CollectionsKt___CollectionsKt.b0(this$0.f35956e, this$0.k());
        if (b02 != 0) {
            int i9 = R$id.horizontalPointer;
            AppCompatImageView appCompatImageView = (AppCompatImageView) constraintLayout.findViewById(i9);
            if (appCompatImageView != null) {
                i8 = appCompatImageView.getMeasuredHeight();
            } else {
                i8 = 0;
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) constraintLayout.findViewById(i9);
            if (appCompatImageView2 != null) {
                ViewExtKt.h(appCompatImageView2, null, Integer.valueOf(constraintLayout.getMeasuredHeight() - i8), null, null, 13, null);
            }
        }
        popupLayout.setAlpha(1.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void y(ee.mtakso.driver.uikit.onbordingtooltips.TooltipOnbordingDelegate.TooltipElement r20, android.view.ViewGroup r21, android.graphics.Rect r22, android.graphics.Rect r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uikit.onbordingtooltips.TooltipOnbordingDelegate.y(ee.mtakso.driver.uikit.onbordingtooltips.TooltipOnbordingDelegate$TooltipElement, android.view.ViewGroup, android.graphics.Rect, android.graphics.Rect, boolean):void");
    }

    public final TooltipElement k() {
        Object Z;
        Z = CollectionsKt___CollectionsKt.Z(this.f35956e, this.f35957f);
        return (TooltipElement) Z;
    }

    public final ViewGroup m() {
        return this.f35952a;
    }

    public final View n(ViewGroup parent, boolean z7) {
        int i8;
        Intrinsics.f(parent, "parent");
        AppCompatImageView appCompatImageView = new AppCompatImageView(parent.getContext());
        appCompatImageView.setLayoutParams(new LinearLayout.LayoutParams(Dimens.c(6), Dimens.c(6)));
        ViewExtKt.h(appCompatImageView, Integer.valueOf(Dimens.c(8)), null, null, null, 14, null);
        parent.addView(appCompatImageView);
        if (z7) {
            i8 = R$drawable.ic_dot_selected;
        } else {
            i8 = R$drawable.ic_dot_unselected;
        }
        appCompatImageView.setImageResource(i8);
        return appCompatImageView;
    }

    public final boolean o() {
        if (this.f35956e.size() == this.f35957f + 1) {
            return true;
        }
        return false;
    }

    public final void u(List<TooltipElement> tooltips) {
        Intrinsics.f(tooltips, "tooltips");
        this.f35956e = tooltips;
        this.f35957f = 0;
        p();
    }

    public /* synthetic */ TooltipOnbordingDelegate(ViewGroup viewGroup, RecyclerView recyclerView, DiffAdapter diffAdapter, Function0 function0, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, recyclerView, diffAdapter, (i8 & 8) != 0 ? new Function0<Unit>() { // from class: ee.mtakso.driver.uikit.onbordingtooltips.TooltipOnbordingDelegate.1
            public final void b() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        } : function0);
    }
}
