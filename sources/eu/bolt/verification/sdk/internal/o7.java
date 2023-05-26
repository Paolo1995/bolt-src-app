package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter;
import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.client.design.button.a;
import eu.bolt.client.design.listitem.DesignListItemView;
import eu.bolt.client.design.toolbar.DesignCollapsingToolbarView;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.sdk.internal.db;
import eu.bolt.verification.sdk.internal.n7;
import eu.bolt.verification.sdk.internal.nh;
import eu.bolt.verification.sdk.internal.w7;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;
import org.jctools.util.Pow2;

/* loaded from: classes5.dex */
public final class o7 implements n7 {

    /* renamed from: m  reason: collision with root package name */
    private static final b f44416m = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private final v7 f44417a;

    /* renamed from: b  reason: collision with root package name */
    private final db f44418b;

    /* renamed from: c  reason: collision with root package name */
    private final PublishRelay<n7.b.C0075b> f44419c;

    /* renamed from: d  reason: collision with root package name */
    private final PublishRelay<n7.b.c> f44420d;

    /* renamed from: e  reason: collision with root package name */
    private final PublishRelay<n7.b.g> f44421e;

    /* renamed from: f  reason: collision with root package name */
    private final PublishRelay<n7.b.f> f44422f;

    /* renamed from: g  reason: collision with root package name */
    private final PublishRelay<n7.b.d> f44423g;

    /* renamed from: h  reason: collision with root package name */
    private final PublishRelay<n7.b.e> f44424h;

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<aa, Integer> f44425i;

    /* renamed from: j  reason: collision with root package name */
    private final HashMap<aa, Integer> f44426j;

    /* renamed from: k  reason: collision with root package name */
    private nh.b.a f44427k;

    /* renamed from: l  reason: collision with root package name */
    private final AsyncListDifferDelegationAdapter<w7> f44428l;

    /* loaded from: classes5.dex */
    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView f44430b;

        a(RecyclerView recyclerView) {
            this.f44430b = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void a(RecyclerView recyclerView, int i8) {
            Intrinsics.f(recyclerView, "recyclerView");
            if (this.f44430b.getScrollState() == 1) {
                db.a.a(o7.this.f44418b, null, false, 3, null);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void b(RecyclerView recyclerView, int i8, int i9) {
            Intrinsics.f(recyclerView, "recyclerView");
            o7.this.O();
        }
    }

    /* loaded from: classes5.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44431a;

        static {
            int[] iArr = new int[nh.b.a.values().length];
            try {
                iArr[nh.b.a.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[nh.b.a.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[nh.b.a.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[nh.b.a.FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f44431a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function0<Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ RecyclerView f44432f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ o7 f44433g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(RecyclerView recyclerView, o7 o7Var) {
            super(0);
            this.f44432f = recyclerView;
            this.f44433g = o7Var;
        }

        public final void b() {
            RecyclerView.Adapter adapter = this.f44432f.getAdapter();
            if (adapter != null) {
                RecyclerView recyclerView = this.f44432f;
                o7 o7Var = this.f44433g;
                if (adapter.r() <= 0 || !nf.b(recyclerView)) {
                    return;
                }
                o7Var.b0();
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends DiffUtil.ItemCallback<w7> {
        e() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: d */
        public boolean a(w7 oldItem, w7 newItem) {
            Intrinsics.f(oldItem, "oldItem");
            Intrinsics.f(newItem, "newItem");
            return oldItem.b(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: e */
        public boolean b(w7 oldItem, w7 newItem) {
            Intrinsics.f(oldItem, "oldItem");
            Intrinsics.f(newItem, "newItem");
            return Intrinsics.a(oldItem.a(), newItem.a());
        }
    }

    /* loaded from: classes5.dex */
    static final class f extends Lambda implements Function1<ud, Unit> {
        f() {
            super(1);
        }

        public final void b(ud it) {
            Intrinsics.f(it, "it");
            o7.this.f44420d.accept(new n7.b.c(it));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ud udVar) {
            b(udVar);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class g extends Lambda implements Function2<String, Date, Unit> {
        g() {
            super(2);
        }

        public final void b(String fieldId, Date date) {
            Intrinsics.f(fieldId, "fieldId");
            o7.this.f44424h.accept(new n7.b.e(fieldId, date));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit s(String str, Date date) {
            b(str, date);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class h extends Lambda implements Function2<aa, Integer, Unit> {
        h() {
            super(2);
        }

        public final void b(aa source, int i8) {
            Intrinsics.f(source, "source");
            o7.this.G(source, i8);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit s(aa aaVar, Integer num) {
            b(aaVar, num.intValue());
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class i extends Lambda implements Function2<String, List<? extends cm>, Unit> {
        i() {
            super(2);
        }

        public final void b(String url, List<cm> urlIntercepts) {
            Intrinsics.f(url, "url");
            Intrinsics.f(urlIntercepts, "urlIntercepts");
            o7.this.M(url, urlIntercepts);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit s(String str, List<? extends cm> list) {
            b(str, list);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class j extends Lambda implements Function2<String, String, Unit> {
        j() {
            super(2);
        }

        public final void b(String fieldId, String input) {
            Intrinsics.f(fieldId, "fieldId");
            Intrinsics.f(input, "input");
            o7.this.f44421e.accept(new n7.b.g(fieldId, input));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit s(String str, String str2) {
            b(str, str2);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class k extends Lambda implements Function1<k2, Unit> {
        k() {
            super(1);
        }

        public final void b(k2 payload) {
            Intrinsics.f(payload, "payload");
            o7.this.f44423g.accept(new n7.b.d(payload));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(k2 k2Var) {
            b(k2Var);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class l extends Lambda implements Function1<Unit, n7.b.a> {

        /* renamed from: f  reason: collision with root package name */
        public static final l f44440f = new l();

        l() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final n7.b.a invoke(Unit it) {
            Intrinsics.f(it, "it");
            return n7.b.a.f44294a;
        }
    }

    @Inject
    public o7(v7 view, db keyboardController) {
        Intrinsics.f(view, "view");
        Intrinsics.f(keyboardController, "keyboardController");
        this.f44417a = view;
        this.f44418b = keyboardController;
        PublishRelay<n7.b.C0075b> e8 = PublishRelay.e();
        Intrinsics.e(e8, "create<ButtonClicks>()");
        this.f44419c = e8;
        PublishRelay<n7.b.c> e9 = PublishRelay.e();
        Intrinsics.e(e9, "create<CheckBoxOptionClicks>()");
        this.f44420d = e9;
        PublishRelay<n7.b.g> e10 = PublishRelay.e();
        Intrinsics.e(e10, "create<TextInput>()");
        this.f44421e = e10;
        PublishRelay<n7.b.f> e11 = PublishRelay.e();
        Intrinsics.e(e11, "create<FormBuilderPresen…vent.ParagraphUrlClick>()");
        this.f44422f = e11;
        PublishRelay<n7.b.d> e12 = PublishRelay.e();
        Intrinsics.e(e12, "create<CountryPickerClicks>()");
        this.f44423g = e12;
        PublishRelay<n7.b.e> e13 = PublishRelay.e();
        Intrinsics.e(e13, "create<DateInput>()");
        this.f44424h = e13;
        this.f44425i = new HashMap<>();
        this.f44426j = new HashMap<>();
        this.f44427k = nh.b.a.CENTER;
        AsyncListDifferDelegationAdapter<w7> asyncListDifferDelegationAdapter = new AsyncListDifferDelegationAdapter<>(new e(), s1.a(new f()), q3.a(new g(), new pr(1901, 2021)), r9.a(new h()), dc.a(), ce.a(new i()), kl.a(new j()), m2.a(new k()));
        this.f44428l = asyncListDifferDelegationAdapter;
        RecyclerView recyclerView = view.getBinding().f43405f;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(asyncListDifferDelegationAdapter);
        recyclerView.setItemAnimator(null);
        recyclerView.l(new a(recyclerView));
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: eu.bolt.verification.sdk.internal.av
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                o7.Y(o7.this);
            }
        });
        U();
    }

    private final int B() {
        this.f44417a.getBinding().f43405f.measure(View.MeasureSpec.makeMeasureSpec(this.f44417a.getBinding().f43405f.getWidth(), Pow2.MAX_POW2), 0);
        return this.f44417a.getBinding().f43405f.getMeasuredHeight();
    }

    private final eu.bolt.client.design.button.a C(final w7.e eVar) {
        int dimensionPixelSize = this.f44417a.getResources().getDimensionPixelSize(R$dimen.button_height);
        a.C0024a c0024a = eu.bolt.client.design.button.a.f39995x;
        Context context = this.f44417a.getContext();
        Intrinsics.e(context, "view.context");
        eu.bolt.client.design.button.a a8 = c0024a.a(context, eVar.d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dimensionPixelSize);
        int dimensionPixelSize2 = this.f44417a.getResources().getDimensionPixelSize(R$dimen.big_margin);
        int dimensionPixelSize3 = this.f44417a.getResources().getDimensionPixelSize(R$dimen.small_side_margin);
        layoutParams.setMargins(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3);
        a8.setLayoutParams(layoutParams);
        a8.setTag(eVar.c().a());
        il.d(a8, eVar.e());
        a8.setEnabled(eVar.f());
        a8.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.bv
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o7.K(o7.this, eVar, view);
            }
        });
        return a8;
    }

    private final DesignListItemView D(final w7.a aVar) {
        ta b8 = ta.b(LayoutInflater.from(this.f44417a.getContext()), this.f44417a, false);
        Intrinsics.e(b8, "inflate(LayoutInflater.f…ew.context), view, false)");
        DesignListItemView root = b8.getRoot();
        if (aVar.d().c()) {
            root.setEndCheckBoxVisible(false);
            root.setStartCheckBoxVisible(true);
            root.setCheckBoxRound(false);
        } else {
            root.setEndCheckBoxVisible(true);
            root.setStartCheckBoxVisible(false);
            root.setCheckBoxRound(true);
        }
        root.setSelected(aVar.e());
        root.setTitleTextModel(aVar.g());
        root.setSubtitleTextModel(aVar.f());
        root.setIconImageModel(aVar.c());
        root.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.dv
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o7.J(o7.this, aVar, view);
            }
        });
        DesignListItemView root2 = b8.getRoot();
        Intrinsics.e(root2, "checkBoxViewBinding.root");
        return root2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n7.b.a E(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (n7.b.a) tmp0.invoke(obj);
    }

    private final Integer F(aa aaVar) {
        List<w7> P = this.f44428l.P();
        Intrinsics.e(P, "layoutAdapter.items");
        Iterator<w7> it = P.iterator();
        int i8 = 0;
        while (true) {
            if (!it.hasNext()) {
                i8 = -1;
                break;
            }
            w7 next = it.next();
            if ((next instanceof w7.f) && Intrinsics.a(((w7.f) next).c(), aaVar)) {
                break;
            }
            i8++;
        }
        Integer valueOf = Integer.valueOf(i8);
        if (valueOf.intValue() != -1) {
            return valueOf;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(aa aaVar, int i8) {
        Integer valueOf;
        HashMap<aa, Integer> hashMap;
        Integer num;
        Integer num2;
        Integer F = F(aaVar);
        if (F != null) {
            F.intValue();
            if (!this.f44425i.containsKey(aaVar) || (num = this.f44425i.get(aaVar)) == null || num.intValue() != i8) {
                valueOf = Integer.valueOf(i8);
                hashMap = this.f44425i;
            } else if (!this.f44426j.containsKey(aaVar) || (num2 = this.f44426j.get(aaVar)) == null || num2.intValue() != i8) {
                valueOf = Integer.valueOf(i8);
                hashMap = this.f44426j;
            }
            hashMap.put(aaVar, valueOf);
            this.f44428l.x(F.intValue());
        }
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(o7 this$0, w7.a checkBoxUiModel, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(checkBoxUiModel, "$checkBoxUiModel");
        this$0.f44420d.accept(new n7.b.c(checkBoxUiModel.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(o7 this$0, w7.e button, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(button, "$button");
        db.a.a(this$0.f44418b, null, false, 3, null);
        this$0.f44419c.accept(new n7.b.C0075b(button.c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(String str, List<cm> list) {
        this.f44422f.accept(new n7.b.f(str, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        int m8;
        float f8;
        RecyclerView.LayoutManager layoutManager = this.f44417a.getBinding().f43405f.getLayoutManager();
        Intrinsics.d(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int l22 = ((LinearLayoutManager) layoutManager).l2();
        List<w7> P = this.f44428l.P();
        Intrinsics.e(P, "layoutAdapter.items");
        m8 = CollectionsKt__CollectionsKt.m(P);
        if (m8 <= l22 || l22 == -1) {
            f8 = 0.0f;
        } else {
            Context context = this.f44417a.getContext();
            Intrinsics.e(context, "view.context");
            f8 = f2.i(context, 16.0f);
        }
        this.f44417a.getBinding().f43402c.setZ(f8);
    }

    private final void P(List<? extends w7> list) {
        View C;
        LinearLayout linearLayout = this.f44417a.getBinding().f43402c;
        linearLayout.removeAllViews();
        for (w7 w7Var : list) {
            if (w7Var instanceof w7.e) {
                C = C((w7.e) w7Var);
            } else if (w7Var instanceof w7.a) {
                C = D((w7.a) w7Var);
            }
            linearLayout.addView(C);
        }
    }

    private final void U() {
        RecyclerView recyclerView = this.f44417a.getBinding().f43405f;
        Intrinsics.e(recyclerView, "view.binding.recyclerView");
        uq.O(recyclerView, new d(recyclerView, this));
    }

    private final void V() {
        int i8 = c.f44431a[this.f44427k.ordinal()];
        if (i8 == 1) {
            Z();
        } else if (i8 == 2) {
            a0();
        } else if (i8 != 3) {
        } else {
            X();
        }
    }

    private final void X() {
        int B = B();
        int height = this.f44417a.getBinding().f43404e.getHeight() - this.f44417a.getBinding().f43401b.getHeight();
        int i8 = height > B ? height - B : 0;
        RecyclerView recyclerView = this.f44417a.getBinding().f43405f;
        Intrinsics.e(recyclerView, "view.binding.recyclerView");
        ViewGroup.MarginLayoutParams a02 = uq.a0(recyclerView);
        if (a02 != null) {
            uq.E(a02, 0, i8, 0, 0, null, 29, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(o7 this$0) {
        Intrinsics.f(this$0, "this$0");
        if (ViewCompat.V(this$0.f44417a.getBinding().f43405f)) {
            this$0.O();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
        if (r0 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void Z() {
        /*
            r12 = this;
            int r0 = r12.B()
            eu.bolt.verification.sdk.internal.v7 r1 = r12.f44417a
            eu.bolt.verification.sdk.internal.hg r1 = r1.getBinding()
            androidx.coordinatorlayout.widget.CoordinatorLayout r1 = r1.f43404e
            int r1 = r1.getHeight()
            eu.bolt.verification.sdk.internal.v7 r2 = r12.f44417a
            eu.bolt.verification.sdk.internal.hg r2 = r2.getBinding()
            com.google.android.material.appbar.AppBarLayout r2 = r2.f43401b
            int r2 = r2.getHeight()
            int r1 = r1 - r2
            r2 = 1
            r3 = 0
            if (r1 <= r0) goto L4f
            int r1 = r1 - r0
            int r1 = r1 / 2
            eu.bolt.verification.sdk.internal.v7 r0 = r12.f44417a
            eu.bolt.verification.sdk.internal.hg r0 = r0.getBinding()
            eu.bolt.client.design.toolbar.DesignCollapsingToolbarView r0 = r0.f43403d
            java.lang.CharSequence r0 = r0.getTitle()
            if (r0 == 0) goto L38
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L39
        L38:
            r3 = 1
        L39:
            if (r3 == 0) goto L4d
            eu.bolt.verification.sdk.internal.v7 r0 = r12.f44417a
            eu.bolt.verification.sdk.internal.hg r0 = r0.getBinding()
            com.google.android.material.appbar.AppBarLayout r0 = r0.f43401b
            int r0 = r0.getHeight()
            int r0 = r0 / 4
            int r3 = r1 - r0
            r6 = r3
            goto L50
        L4d:
            r6 = r1
            goto L50
        L4f:
            r6 = 0
        L50:
            eu.bolt.verification.sdk.internal.v7 r0 = r12.f44417a
            eu.bolt.verification.sdk.internal.hg r0 = r0.getBinding()
            androidx.recyclerview.widget.RecyclerView r0 = r0.f43405f
            java.lang.String r1 = "view.binding.recyclerView"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            android.view.ViewGroup$MarginLayoutParams r4 = eu.bolt.verification.sdk.internal.uq.a0(r0)
            if (r4 == 0) goto L6d
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 29
            r11 = 0
            eu.bolt.verification.sdk.internal.uq.E(r4, r5, r6, r7, r8, r9, r10, r11)
        L6d:
            eu.bolt.verification.sdk.internal.v7 r0 = r12.f44417a
            eu.bolt.verification.sdk.internal.hg r0 = r0.getBinding()
            androidx.recyclerview.widget.RecyclerView r0 = r0.f43405f
            com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter<eu.bolt.verification.sdk.internal.w7> r1 = r12.f44428l
            java.util.List r1 = r1.P()
            int r1 = r1.size()
            int r1 = r1 - r2
            r0.p1(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.o7.Z():void");
    }

    private final void a0() {
        RecyclerView recyclerView = this.f44417a.getBinding().f43405f;
        Intrinsics.e(recyclerView, "view.binding.recyclerView");
        ViewGroup.MarginLayoutParams a02 = uq.a0(recyclerView);
        if (a02 != null) {
            uq.E(a02, 0, 0, 0, 0, null, 29, null);
        }
        this.f44417a.getBinding().f43405f.p1(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        DesignCollapsingToolbarView designCollapsingToolbarView = this.f44417a.getBinding().f43403d;
        ViewGroup.LayoutParams layoutParams = designCollapsingToolbarView.getLayoutParams();
        Intrinsics.d(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
        if (19 != layoutParams2.c()) {
            layoutParams2.g(19);
            designCollapsingToolbarView.setLayoutParams(layoutParams2);
        }
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Observable<n7.b> h() {
        List n8;
        Observable<Unit> z7 = this.f44417a.getBinding().f43403d.z();
        final l lVar = l.f44440f;
        n8 = CollectionsKt__CollectionsKt.n(z7.map(new Function() { // from class: eu.bolt.verification.sdk.internal.cv
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                n7.b.a E;
                E = o7.E(Function1.this, obj);
                return E;
            }
        }), this.f44419c, this.f44420d, this.f44421e, this.f44423g, this.f44424h, this.f44422f);
        Observable<n7.b> merge = Observable.merge(n8);
        Intrinsics.e(merge, "merge(\n            listO…,\n            )\n        )");
        return merge;
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Flow<n7.b> p() {
        return n7.a.a(this);
    }

    @Override // eu.bolt.verification.sdk.internal.n7
    public void v(b8 uiModel) {
        Intrinsics.f(uiModel, "uiModel");
        this.f44427k = uiModel.a();
        P(uiModel.b());
        this.f44417a.getBinding().f43403d.setTitle(uiModel.d());
        this.f44417a.getBinding().f43403d.getToolbar().setHomeButtonIcon(uiModel.e());
        this.f44428l.Q(uiModel.c());
        V();
    }

    @Override // eu.bolt.verification.sdk.internal.n7
    public void w(String tag, boolean z7) {
        Intrinsics.f(tag, "tag");
        LinearLayout linearLayout = this.f44417a.getBinding().f43402c;
        Intrinsics.e(linearLayout, "view.binding.buttonContainer");
        int childCount = linearLayout.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = linearLayout.getChildAt(i8);
            Intrinsics.e(childAt, "getChildAt(index)");
            eu.bolt.client.design.button.a aVar = childAt instanceof eu.bolt.client.design.button.a ? (eu.bolt.client.design.button.a) childAt : null;
            if (Intrinsics.a(aVar != null ? aVar.getTag() : null, tag)) {
                aVar.x(z7, true);
            } else if (aVar != null) {
                aVar.setEnabled(!z7);
            }
        }
    }
}
