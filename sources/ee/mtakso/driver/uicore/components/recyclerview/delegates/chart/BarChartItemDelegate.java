package ee.mtakso.driver.uicore.components.recyclerview.delegates.chart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.views.chart.BarChartAdapter;
import ee.mtakso.driver.uicore.components.views.chart.BarChartView;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BarChartItemDelegate.kt */
/* loaded from: classes5.dex */
public final class BarChartItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f34856b;

    /* compiled from: BarChartItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Adapter extends BarChartAdapter {

        /* renamed from: d  reason: collision with root package name */
        private final List<BarChartAdapter.BarInfo> f34857d = new ArrayList();

        @Override // ee.mtakso.driver.uicore.components.views.chart.BarChartAdapter
        public BarChartAdapter.BarInfo a(int i8) {
            return this.f34857d.get(i8);
        }

        @Override // ee.mtakso.driver.uicore.components.views.chart.BarChartAdapter
        public int b() {
            return this.f34857d.size();
        }

        public final void f(List<BarChartAdapter.BarInfo> newItems) {
            Intrinsics.f(newItems, "newItems");
            this.f34857d.clear();
            this.f34857d.addAll(newItems);
            c();
        }
    }

    /* compiled from: BarChartItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Payload {

        /* renamed from: a  reason: collision with root package name */
        private final List<BarChartAdapter.BarInfo> f34873a;

        /* renamed from: b  reason: collision with root package name */
        private final String f34874b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f34875c;

        /* renamed from: d  reason: collision with root package name */
        private final String f34876d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f34877e;

        /* renamed from: f  reason: collision with root package name */
        private final String f34878f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f34879g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f34880h;

        /* renamed from: i  reason: collision with root package name */
        private final Float f34881i;

        /* renamed from: j  reason: collision with root package name */
        private final Color f34882j;

        /* renamed from: k  reason: collision with root package name */
        private final Float f34883k;

        /* renamed from: l  reason: collision with root package name */
        private final Color f34884l;

        /* renamed from: m  reason: collision with root package name */
        private final Color f34885m;

        /* renamed from: n  reason: collision with root package name */
        private final String f34886n;

        /* renamed from: o  reason: collision with root package name */
        private final Float f34887o;

        /* renamed from: p  reason: collision with root package name */
        private final Float f34888p;

        public Payload(List<BarChartAdapter.BarInfo> list, String str, boolean z7, String str2, boolean z8, String str3, boolean z9, Color color, Float f8, Color color2, Float f9, Color color3, Color color4, String str4, Float f10, Float f11) {
            this.f34873a = list;
            this.f34874b = str;
            this.f34875c = z7;
            this.f34876d = str2;
            this.f34877e = z8;
            this.f34878f = str3;
            this.f34879g = z9;
            this.f34880h = color;
            this.f34881i = f8;
            this.f34882j = color2;
            this.f34883k = f9;
            this.f34884l = color3;
            this.f34885m = color4;
            this.f34886n = str4;
            this.f34887o = f10;
            this.f34888p = f11;
        }

        public final Float a() {
            return this.f34888p;
        }

        public final List<BarChartAdapter.BarInfo> b() {
            return this.f34873a;
        }

        public final Color c() {
            return this.f34884l;
        }

        public final Color d() {
            return this.f34885m;
        }

        public final Float e() {
            return this.f34887o;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Payload) {
                Payload payload = (Payload) obj;
                return Intrinsics.a(this.f34873a, payload.f34873a) && Intrinsics.a(this.f34874b, payload.f34874b) && this.f34875c == payload.f34875c && Intrinsics.a(this.f34876d, payload.f34876d) && this.f34877e == payload.f34877e && Intrinsics.a(this.f34878f, payload.f34878f) && this.f34879g == payload.f34879g && Intrinsics.a(this.f34880h, payload.f34880h) && Intrinsics.a(this.f34881i, payload.f34881i) && Intrinsics.a(this.f34882j, payload.f34882j) && Intrinsics.a(this.f34883k, payload.f34883k) && Intrinsics.a(this.f34884l, payload.f34884l) && Intrinsics.a(this.f34885m, payload.f34885m) && Intrinsics.a(this.f34886n, payload.f34886n) && Intrinsics.a(this.f34887o, payload.f34887o) && Intrinsics.a(this.f34888p, payload.f34888p);
            }
            return false;
        }

        public final String f() {
            return this.f34878f;
        }

        public final Color g() {
            return this.f34882j;
        }

        public final String h() {
            return this.f34886n;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<BarChartAdapter.BarInfo> list = this.f34873a;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            String str = this.f34874b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            boolean z7 = this.f34875c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode2 + i8) * 31;
            String str2 = this.f34876d;
            int hashCode3 = (i9 + (str2 == null ? 0 : str2.hashCode())) * 31;
            boolean z8 = this.f34877e;
            int i10 = z8;
            if (z8 != 0) {
                i10 = 1;
            }
            int i11 = (hashCode3 + i10) * 31;
            String str3 = this.f34878f;
            int hashCode4 = (i11 + (str3 == null ? 0 : str3.hashCode())) * 31;
            boolean z9 = this.f34879g;
            int i12 = (hashCode4 + (z9 ? 1 : z9 ? 1 : 0)) * 31;
            Color color = this.f34880h;
            int hashCode5 = (i12 + (color == null ? 0 : color.hashCode())) * 31;
            Float f8 = this.f34881i;
            int hashCode6 = (hashCode5 + (f8 == null ? 0 : f8.hashCode())) * 31;
            Color color2 = this.f34882j;
            int hashCode7 = (hashCode6 + (color2 == null ? 0 : color2.hashCode())) * 31;
            Float f9 = this.f34883k;
            int hashCode8 = (hashCode7 + (f9 == null ? 0 : f9.hashCode())) * 31;
            Color color3 = this.f34884l;
            int hashCode9 = (hashCode8 + (color3 == null ? 0 : color3.hashCode())) * 31;
            Color color4 = this.f34885m;
            int hashCode10 = (hashCode9 + (color4 == null ? 0 : color4.hashCode())) * 31;
            String str4 = this.f34886n;
            int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Float f10 = this.f34887o;
            int hashCode12 = (hashCode11 + (f10 == null ? 0 : f10.hashCode())) * 31;
            Float f11 = this.f34888p;
            return hashCode12 + (f11 != null ? f11.hashCode() : 0);
        }

        public final Float i() {
            return this.f34883k;
        }

        public final Color j() {
            return this.f34880h;
        }

        public final Float k() {
            return this.f34881i;
        }

        public final String l() {
            return this.f34876d;
        }

        public final String m() {
            return this.f34874b;
        }

        public final boolean n() {
            return this.f34879g;
        }

        public final boolean o() {
            return this.f34877e;
        }

        public final boolean p() {
            return this.f34875c;
        }

        public String toString() {
            List<BarChartAdapter.BarInfo> list = this.f34873a;
            String str = this.f34874b;
            boolean z7 = this.f34875c;
            String str2 = this.f34876d;
            boolean z8 = this.f34877e;
            String str3 = this.f34878f;
            boolean z9 = this.f34879g;
            Color color = this.f34880h;
            Float f8 = this.f34881i;
            Color color2 = this.f34882j;
            Float f9 = this.f34883k;
            Color color3 = this.f34884l;
            Color color4 = this.f34885m;
            String str4 = this.f34886n;
            Float f10 = this.f34887o;
            Float f11 = this.f34888p;
            return "Payload(barInfos=" + list + ", title=" + str + ", isTitleShown=" + z7 + ", netLegendLabel=" + str2 + ", isNetLegendShown=" + z8 + ", expensesLegendLabel=" + str3 + ", isExpensesLegendShown=" + z9 + ", gridLineColor=" + color + ", gridLineThickness=" + f8 + ", gridLabelColor=" + color2 + ", gridLabelTextSize=" + f9 + ", barLabelColor=" + color3 + ", barLabelHighlightColor=" + color4 + ", gridLabelSuffix=" + str4 + ", barLabelTextSize=" + f10 + ", barChartRoundRadius=" + f11 + ")";
        }
    }

    /* compiled from: BarChartItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f34889u;

        /* renamed from: v  reason: collision with root package name */
        private final AppCompatTextView f34890v;

        /* renamed from: w  reason: collision with root package name */
        private final AppCompatTextView f34891w;

        /* renamed from: x  reason: collision with root package name */
        private final BarChartView f34892x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            this.f34889u = (TextView) itemView.findViewById(R$id.D0);
            this.f34890v = (AppCompatTextView) itemView.findViewById(R$id.netLegend);
            this.f34891w = (AppCompatTextView) itemView.findViewById(R$id.expensesLegend);
            this.f34892x = (BarChartView) itemView.findViewById(R$id.barChart);
        }

        public final BarChartView O() {
            return this.f34892x;
        }

        public final AppCompatTextView P() {
            return this.f34891w;
        }

        public final AppCompatTextView Q() {
            return this.f34890v;
        }

        public final TextView R() {
            return this.f34889u;
        }
    }

    public BarChartItemDelegate() {
        this(0, 1, null);
    }

    public /* synthetic */ BarChartItemDelegate(int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? R$layout.delegate_chart_item : i8);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34856b;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        return model instanceof Model;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public RecyclerView.ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View v7 = inflater.inflate(R$layout.delegate_chart_item, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        boolean z7;
        boolean z8;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextView titleView = holder.R();
        Intrinsics.e(titleView, "titleView");
        boolean z9 = true;
        if (model.z() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        Adapter adapter = null;
        ViewExtKt.e(titleView, z7, 0, 2, null);
        holder.R().setText(model.z());
        AppCompatTextView expensesLegend = holder.P();
        Intrinsics.e(expensesLegend, "expensesLegend");
        if (model.s() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.e(expensesLegend, z8, 0, 2, null);
        holder.P().setText(model.s());
        AppCompatTextView netLegend = holder.Q();
        Intrinsics.e(netLegend, "netLegend");
        if (model.y() == null) {
            z9 = false;
        }
        ViewExtKt.e(netLegend, z9, 0, 2, null);
        holder.Q().setText(model.y());
        Context context = holder.f7332a.getContext();
        BarChartView O = holder.O();
        BarChartAdapter adapter2 = O.getAdapter();
        if (adapter2 instanceof Adapter) {
            adapter = (Adapter) adapter2;
        }
        if (adapter != null) {
            adapter.f(model.o());
        }
        Color p8 = model.p();
        Intrinsics.e(context, "context");
        O.setBarLabelColor(ColorKt.a(p8, context));
        O.setBarLabelHighlightColor(ColorKt.a(model.q(), context));
        O.setBarLabelTextSize(model.r());
        O.setGridLabelColor(ColorKt.a(model.t(), context));
        O.setGridLabelTextSize(model.v());
        O.setGridLinesColor(ColorKt.a(model.w(), context));
        O.setGridLinesThickness(model.x());
        O.setAdditionalGridLabelSuffix(model.u());
        O.setBarRoundRadius(model.n());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Adapter adapter;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
        ArrayList<Payload> arrayList = new ArrayList();
        for (Object obj : payloads) {
            if (obj instanceof Payload) {
                arrayList.add(obj);
            }
        }
        for (Payload payload : arrayList) {
            if (payload.b() != null) {
                BarChartAdapter adapter2 = holder.O().getAdapter();
                if (adapter2 instanceof Adapter) {
                    adapter = (Adapter) adapter2;
                } else {
                    adapter = null;
                }
                if (adapter != null) {
                    adapter.f(payload.b());
                }
            }
            TextView R = holder.R();
            Intrinsics.e(R, "holder.titleView");
            ViewExtKt.e(R, payload.p(), 0, 2, null);
            AppCompatTextView Q = holder.Q();
            Intrinsics.e(Q, "holder.netLegend");
            ViewExtKt.e(Q, payload.o(), 0, 2, null);
            AppCompatTextView P = holder.P();
            Intrinsics.e(P, "holder.expensesLegend");
            ViewExtKt.e(P, payload.n(), 0, 2, null);
            String m8 = payload.m();
            if (m8 != null) {
                holder.R().setText(m8);
            }
            String f8 = payload.f();
            if (f8 != null) {
                holder.P().setText(f8);
            }
            String l8 = payload.l();
            if (l8 != null) {
                holder.Q().setText(l8);
            }
            Context context = holder.f7332a.getContext();
            Color c8 = payload.c();
            if (c8 != null) {
                BarChartView O = holder.O();
                Intrinsics.e(context, "context");
                O.setBarLabelColor(ColorKt.a(c8, context));
            }
            Color d8 = payload.d();
            if (d8 != null) {
                BarChartView O2 = holder.O();
                Intrinsics.e(context, "context");
                O2.setBarLabelHighlightColor(ColorKt.a(d8, context));
            }
            Float e8 = payload.e();
            if (e8 != null) {
                holder.O().setBarLabelTextSize(e8.floatValue());
            }
            Color g8 = payload.g();
            if (g8 != null) {
                BarChartView O3 = holder.O();
                Intrinsics.e(context, "context");
                O3.setGridLabelColor(ColorKt.a(g8, context));
            }
            Float i8 = payload.i();
            if (i8 != null) {
                holder.O().setGridLabelTextSize(i8.floatValue());
            }
            Color j8 = payload.j();
            if (j8 != null) {
                BarChartView O4 = holder.O();
                Intrinsics.e(context, "context");
                O4.setGridLinesColor(ColorKt.a(j8, context));
            }
            Float k8 = payload.k();
            if (k8 != null) {
                holder.O().setGridLinesThickness(k8.floatValue());
            }
            String h8 = payload.h();
            if (h8 != null) {
                holder.O().setAdditionalGridLabelSuffix(h8);
            }
            Float a8 = payload.a();
            if (a8 != null) {
                holder.O().setBarRoundRadius(a8.floatValue());
            }
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void p(ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        super.p(holder);
        holder.O().setAdapter(new Adapter());
    }

    public BarChartItemDelegate(int i8) {
        this.f34856b = i8;
    }

    /* compiled from: BarChartItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34858a;

        /* renamed from: b  reason: collision with root package name */
        private final String f34859b;

        /* renamed from: c  reason: collision with root package name */
        private final String f34860c;

        /* renamed from: d  reason: collision with root package name */
        private final String f34861d;

        /* renamed from: e  reason: collision with root package name */
        private final Color f34862e;

        /* renamed from: f  reason: collision with root package name */
        private final float f34863f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f34864g;

        /* renamed from: h  reason: collision with root package name */
        private final float f34865h;

        /* renamed from: i  reason: collision with root package name */
        private final Color f34866i;

        /* renamed from: j  reason: collision with root package name */
        private final Color f34867j;

        /* renamed from: k  reason: collision with root package name */
        private final float f34868k;

        /* renamed from: l  reason: collision with root package name */
        private final String f34869l;

        /* renamed from: m  reason: collision with root package name */
        private final float f34870m;

        /* renamed from: n  reason: collision with root package name */
        private final List<BarChartAdapter.BarInfo> f34871n;

        /* renamed from: o  reason: collision with root package name */
        private final DividerModel f34872o;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ Model(java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, ee.mtakso.driver.uikit.utils.Color r31, float r32, ee.mtakso.driver.uikit.utils.Color r33, float r34, ee.mtakso.driver.uikit.utils.Color r35, ee.mtakso.driver.uikit.utils.Color r36, float r37, java.lang.String r38, float r39, java.util.List r40, ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
            /*
                r26 = this;
                r0 = r42
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L9
                r5 = r2
                goto Lb
            L9:
                r5 = r28
            Lb:
                r1 = r0 & 4
                if (r1 == 0) goto L11
                r6 = r2
                goto L13
            L11:
                r6 = r29
            L13:
                r1 = r0 & 8
                if (r1 == 0) goto L19
                r7 = r2
                goto L1b
            L19:
                r7 = r30
            L1b:
                r1 = r0 & 32
                if (r1 == 0) goto L27
                r1 = 1065353216(0x3f800000, float:1.0)
                float r1 = ee.mtakso.driver.uicore.utils.Dimens.c(r1)
                r9 = r1
                goto L29
            L27:
                r9 = r32
            L29:
                r1 = r0 & 128(0x80, float:1.8E-43)
                r3 = 1094713344(0x41400000, float:12.0)
                if (r1 == 0) goto L35
                float r1 = ee.mtakso.driver.uicore.utils.Dimens.a(r3)
                r11 = r1
                goto L37
            L35:
                r11 = r34
            L37:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L41
                float r1 = ee.mtakso.driver.uicore.utils.Dimens.a(r3)
                r14 = r1
                goto L43
            L41:
                r14 = r37
            L43:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L49
                r15 = r2
                goto L4b
            L49:
                r15 = r38
            L4b:
                r1 = r0 & 4096(0x1000, float:5.74E-42)
                if (r1 == 0) goto L58
                r1 = 1082130432(0x40800000, float:4.0)
                float r1 = ee.mtakso.driver.uicore.utils.Dimens.c(r1)
                r16 = r1
                goto L5a
            L58:
                r16 = r39
            L5a:
                r0 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r0 == 0) goto L8c
                ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider r0 = new ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider
                r18 = 0
                r19 = 0
                r20 = 0
                ee.mtakso.driver.uikit.utils.Color$Attr r1 = new ee.mtakso.driver.uikit.utils.Color$Attr
                int r2 = ee.mtakso.driver.uicore.R$attr.backTertiary
                r1.<init>(r2)
                ee.mtakso.driver.uikit.utils.Color$Attr r3 = new ee.mtakso.driver.uikit.utils.Color$Attr
                r3.<init>(r2)
                r2 = 1090519040(0x41000000, float:8.0)
                float r2 = ee.mtakso.driver.uicore.utils.Dimens.c(r2)
                java.lang.Float r23 = java.lang.Float.valueOf(r2)
                r24 = 7
                r25 = 0
                r17 = r0
                r21 = r1
                r22 = r3
                r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25)
                r18 = r0
                goto L8e
            L8c:
                r18 = r41
            L8e:
                r3 = r26
                r4 = r27
                r8 = r31
                r10 = r33
                r12 = r35
                r13 = r36
                r17 = r40
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.recyclerview.delegates.chart.BarChartItemDelegate.Model.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, ee.mtakso.driver.uikit.utils.Color, float, ee.mtakso.driver.uikit.utils.Color, float, ee.mtakso.driver.uikit.utils.Color, ee.mtakso.driver.uikit.utils.Color, float, java.lang.String, float, java.util.List, ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f34872o.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f34872o.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f34859b, model.f34859b) && Intrinsics.a(this.f34860c, model.f34860c) && Intrinsics.a(this.f34861d, model.f34861d) && Intrinsics.a(this.f34862e, model.f34862e) && Float.compare(this.f34863f, model.f34863f) == 0 && Intrinsics.a(this.f34864g, model.f34864g) && Float.compare(this.f34865h, model.f34865h) == 0 && Intrinsics.a(this.f34866i, model.f34866i) && Intrinsics.a(this.f34867j, model.f34867j) && Float.compare(this.f34868k, model.f34868k) == 0 && Intrinsics.a(this.f34869l, model.f34869l) && Float.compare(this.f34870m, model.f34870m) == 0 && Intrinsics.a(this.f34871n, model.f34871n) && Intrinsics.a(this.f34872o, model.f34872o);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f34872o.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            String str = this.f34859b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f34860c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f34861d;
            int hashCode4 = (((((((((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f34862e.hashCode()) * 31) + Float.floatToIntBits(this.f34863f)) * 31) + this.f34864g.hashCode()) * 31) + Float.floatToIntBits(this.f34865h)) * 31) + this.f34866i.hashCode()) * 31) + this.f34867j.hashCode()) * 31) + Float.floatToIntBits(this.f34868k)) * 31;
            String str4 = this.f34869l;
            return ((((((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f34870m)) * 31) + this.f34871n.hashCode()) * 31) + this.f34872o.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f34872o.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f34872o.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f34872o.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public Object l(ListModel oldModel) {
            List<BarChartAdapter.BarInfo> list;
            String str;
            boolean z7;
            String str2;
            boolean z8;
            String str3;
            boolean z9;
            Color color;
            boolean z10;
            Float f8;
            Color color2;
            boolean z11;
            Color color3;
            Color color4;
            String str4;
            boolean z12;
            Float f9;
            boolean z13;
            Float f10;
            Intrinsics.f(oldModel, "oldModel");
            if (!(oldModel instanceof Model)) {
                return null;
            }
            List<BarChartAdapter.BarInfo> list2 = this.f34871n;
            Model model = (Model) oldModel;
            if (!Intrinsics.a(list2, model.f34871n)) {
                list = list2;
            } else {
                list = null;
            }
            String str5 = this.f34859b;
            if (!Intrinsics.a(str5, str5)) {
                str = str5;
            } else {
                str = null;
            }
            if (this.f34859b != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            String str6 = this.f34860c;
            if (!Intrinsics.a(str6, str6)) {
                str2 = str6;
            } else {
                str2 = null;
            }
            if (this.f34860c != null) {
                z8 = true;
            } else {
                z8 = false;
            }
            String str7 = this.f34861d;
            if (!Intrinsics.a(str7, str7)) {
                str3 = str7;
            } else {
                str3 = null;
            }
            if (this.f34861d != null) {
                z9 = true;
            } else {
                z9 = false;
            }
            Color color5 = this.f34862e;
            if (!Intrinsics.a(color5, model.f34862e)) {
                color = color5;
            } else {
                color = null;
            }
            Float valueOf = Float.valueOf(this.f34863f);
            if (valueOf.floatValue() == model.f34863f) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                f8 = valueOf;
            } else {
                f8 = null;
            }
            Color color6 = this.f34864g;
            if (!Intrinsics.a(color6, model.f34864g)) {
                color2 = color6;
            } else {
                color2 = null;
            }
            Float valueOf2 = Float.valueOf(this.f34865h);
            if (valueOf2.floatValue() == model.f34865h) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!(!z11)) {
                valueOf2 = null;
            }
            Color color7 = this.f34866i;
            if (!Intrinsics.a(color7, model.f34866i)) {
                color3 = color7;
            } else {
                color3 = null;
            }
            Color color8 = this.f34867j;
            if (!Intrinsics.a(color8, model.f34867j)) {
                color4 = color8;
            } else {
                color4 = null;
            }
            String str8 = this.f34869l;
            if (!Intrinsics.a(str8, model.f34869l)) {
                str4 = str8;
            } else {
                str4 = null;
            }
            Float valueOf3 = Float.valueOf(this.f34868k);
            if (valueOf3.floatValue() == model.f34868k) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                f9 = valueOf3;
            } else {
                f9 = null;
            }
            Float valueOf4 = Float.valueOf(this.f34870m);
            if (valueOf4.floatValue() == model.f34870m) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (!z13) {
                f10 = valueOf4;
            } else {
                f10 = null;
            }
            return new Payload(list, str, z7, str2, z8, str3, z9, color, f8, color2, valueOf2, color3, color4, str4, f9, f10);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34858a;
        }

        public final float n() {
            return this.f34870m;
        }

        public final List<BarChartAdapter.BarInfo> o() {
            return this.f34871n;
        }

        public final Color p() {
            return this.f34866i;
        }

        public final Color q() {
            return this.f34867j;
        }

        public final float r() {
            return this.f34868k;
        }

        public final String s() {
            return this.f34861d;
        }

        public final Color t() {
            return this.f34864g;
        }

        public String toString() {
            String m8 = m();
            String str = this.f34859b;
            String str2 = this.f34860c;
            String str3 = this.f34861d;
            Color color = this.f34862e;
            float f8 = this.f34863f;
            Color color2 = this.f34864g;
            float f9 = this.f34865h;
            Color color3 = this.f34866i;
            Color color4 = this.f34867j;
            float f10 = this.f34868k;
            String str4 = this.f34869l;
            float f11 = this.f34870m;
            List<BarChartAdapter.BarInfo> list = this.f34871n;
            DividerModel dividerModel = this.f34872o;
            return "Model(listId=" + m8 + ", title=" + str + ", netLegendLabel=" + str2 + ", expensesLegendLabel=" + str3 + ", gridLineColor=" + color + ", gridLineThickness=" + f8 + ", gridLabelColor=" + color2 + ", gridLabelTextSize=" + f9 + ", barLabelColor=" + color3 + ", barLabelHighlightColor=" + color4 + ", barLabelTextSize=" + f10 + ", gridLabelSuffix=" + str4 + ", barChartRoundRadius=" + f11 + ", barInfos=" + list + ", divider=" + dividerModel + ")";
        }

        public final String u() {
            return this.f34869l;
        }

        public final float v() {
            return this.f34865h;
        }

        public final Color w() {
            return this.f34862e;
        }

        public final float x() {
            return this.f34863f;
        }

        public final String y() {
            return this.f34860c;
        }

        public final String z() {
            return this.f34859b;
        }

        public Model(String listId, String str, String str2, String str3, Color gridLineColor, float f8, Color gridLabelColor, float f9, Color barLabelColor, Color barLabelHighlightColor, float f10, String str4, float f11, List<BarChartAdapter.BarInfo> barInfos, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(gridLineColor, "gridLineColor");
            Intrinsics.f(gridLabelColor, "gridLabelColor");
            Intrinsics.f(barLabelColor, "barLabelColor");
            Intrinsics.f(barLabelHighlightColor, "barLabelHighlightColor");
            Intrinsics.f(barInfos, "barInfos");
            Intrinsics.f(divider, "divider");
            this.f34858a = listId;
            this.f34859b = str;
            this.f34860c = str2;
            this.f34861d = str3;
            this.f34862e = gridLineColor;
            this.f34863f = f8;
            this.f34864g = gridLabelColor;
            this.f34865h = f9;
            this.f34866i = barLabelColor;
            this.f34867j = barLabelHighlightColor;
            this.f34868k = f10;
            this.f34869l = str4;
            this.f34870m = f11;
            this.f34871n = barInfos;
            this.f34872o = divider;
        }
    }
}
