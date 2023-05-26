package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsPieChartItemDelegate;
import ee.mtakso.driver.ui.views.DynamicViewHelper;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.ImageViewExtKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.chart.PieChartView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsPieChartItemDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsPieChartItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f29363b;

    /* compiled from: EarningsPieChartItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Legend {

        /* renamed from: a  reason: collision with root package name */
        private final Color f29364a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f29365b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f29366c;

        public Legend(Color color, Text text, Text text2) {
            Intrinsics.f(color, "color");
            this.f29364a = color;
            this.f29365b = text;
            this.f29366c = text2;
        }

        public final Color a() {
            return this.f29364a;
        }

        public final Text b() {
            return this.f29366c;
        }

        public final Text c() {
            return this.f29365b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Legend) {
                Legend legend = (Legend) obj;
                return Intrinsics.a(this.f29364a, legend.f29364a) && Intrinsics.a(this.f29365b, legend.f29365b) && Intrinsics.a(this.f29366c, legend.f29366c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f29364a.hashCode() * 31;
            Text text = this.f29365b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Text text2 = this.f29366c;
            return hashCode2 + (text2 != null ? text2.hashCode() : 0);
        }

        public String toString() {
            Color color = this.f29364a;
            Text text = this.f29365b;
            Text text2 = this.f29366c;
            return "Legend(color=" + color + ", title=" + text + ", subtitle=" + text2 + ")";
        }
    }

    /* compiled from: EarningsPieChartItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class LegendViewHolder implements DynamicViewHelper.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f29367a;

        /* renamed from: b  reason: collision with root package name */
        public Map<Integer, View> f29368b;

        public LegendViewHolder(View containerView) {
            Intrinsics.f(containerView, "containerView");
            this.f29368b = new LinkedHashMap();
            this.f29367a = containerView;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewHelper.ViewHolder
        public View a() {
            return this.f29367a;
        }

        public View b(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f29368b;
            View view = map.get(Integer.valueOf(i8));
            if (view == null) {
                View a8 = a();
                if (a8 == null || (findViewById = a8.findViewById(i8)) == null) {
                    return null;
                }
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return view;
        }
    }

    /* compiled from: EarningsPieChartItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f29369a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f29370b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f29371c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Segment> f29372d;

        /* renamed from: e  reason: collision with root package name */
        private final List<Legend> f29373e;

        /* renamed from: f  reason: collision with root package name */
        private final Text f29374f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f29375g;

        /* renamed from: h  reason: collision with root package name */
        private final String f29376h;

        public Model(String listId, Text text, Text text2, List<Segment> segments, List<Legend> legends, Text text3, Color linkColor, String str) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(segments, "segments");
            Intrinsics.f(legends, "legends");
            Intrinsics.f(linkColor, "linkColor");
            this.f29369a = listId;
            this.f29370b = text;
            this.f29371c = text2;
            this.f29372d = segments;
            this.f29373e = legends;
            this.f29374f = text3;
            this.f29375g = linkColor;
            this.f29376h = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f29370b, model.f29370b) && Intrinsics.a(this.f29371c, model.f29371c) && Intrinsics.a(this.f29372d, model.f29372d) && Intrinsics.a(this.f29373e, model.f29373e) && Intrinsics.a(this.f29374f, model.f29374f) && Intrinsics.a(this.f29375g, model.f29375g) && Intrinsics.a(this.f29376h, model.f29376h);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f29370b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Text text2 = this.f29371c;
            int hashCode3 = (((((hashCode2 + (text2 == null ? 0 : text2.hashCode())) * 31) + this.f29372d.hashCode()) * 31) + this.f29373e.hashCode()) * 31;
            Text text3 = this.f29374f;
            int hashCode4 = (((hashCode3 + (text3 == null ? 0 : text3.hashCode())) * 31) + this.f29375g.hashCode()) * 31;
            String str = this.f29376h;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f29369a;
        }

        public final List<Legend> n() {
            return this.f29373e;
        }

        public final Text o() {
            return this.f29374f;
        }

        public final Color p() {
            return this.f29375g;
        }

        public final String q() {
            return this.f29376h;
        }

        public final List<Segment> r() {
            return this.f29372d;
        }

        public final Text s() {
            return this.f29371c;
        }

        public final Text t() {
            return this.f29370b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f29370b;
            Text text2 = this.f29371c;
            List<Segment> list = this.f29372d;
            List<Legend> list2 = this.f29373e;
            Text text3 = this.f29374f;
            Color color = this.f29375g;
            String str = this.f29376h;
            return "Model(listId=" + m8 + ", title=" + text + ", subtitle=" + text2 + ", segments=" + list + ", legends=" + list2 + ", link=" + text3 + ", linkColor=" + color + ", payload=" + str + ")";
        }
    }

    /* compiled from: EarningsPieChartItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Segment {

        /* renamed from: a  reason: collision with root package name */
        private final float f29377a;

        /* renamed from: b  reason: collision with root package name */
        private final Color f29378b;

        public Segment(float f8, Color color) {
            Intrinsics.f(color, "color");
            this.f29377a = f8;
            this.f29378b = color;
        }

        public final Color a() {
            return this.f29378b;
        }

        public final float b() {
            return this.f29377a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Segment) {
                Segment segment = (Segment) obj;
                return Float.compare(this.f29377a, segment.f29377a) == 0 && Intrinsics.a(this.f29378b, segment.f29378b);
            }
            return false;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f29377a) * 31) + this.f29378b.hashCode();
        }

        public String toString() {
            float f8 = this.f29377a;
            Color color = this.f29378b;
            return "Segment(value=" + f8 + ", color=" + color + ")";
        }
    }

    /* compiled from: EarningsPieChartItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f29379u;

        /* renamed from: v  reason: collision with root package name */
        private final DynamicViewHelper<LegendViewHolder> f29380v;

        /* renamed from: w  reason: collision with root package name */
        public Map<Integer, View> f29381w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            List q8;
            Intrinsics.f(containerView, "containerView");
            this.f29381w = new LinkedHashMap();
            this.f29379u = containerView;
            ConstraintLayout container = (ConstraintLayout) O(R.id.M2);
            Intrinsics.e(container, "container");
            View findViewById = P().findViewById(R.id.legendItem1);
            Intrinsics.e(findViewById, "containerView.legendItem1");
            View findViewById2 = P().findViewById(R.id.legendItem2);
            Intrinsics.e(findViewById2, "containerView.legendItem2");
            View findViewById3 = P().findViewById(R.id.legendItem3);
            Intrinsics.e(findViewById3, "containerView.legendItem3");
            q8 = CollectionsKt__CollectionsKt.q(new LegendViewHolder(findViewById), new LegendViewHolder(findViewById2), new LegendViewHolder(findViewById3));
            this.f29380v = new DynamicViewHelper<>(container, q8, (Flow) O(R.id.legend), new Function2<LayoutInflater, ViewGroup, LegendViewHolder>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsPieChartItemDelegate$ViewHolder$legends$1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final EarningsPieChartItemDelegate.LegendViewHolder s(LayoutInflater inflater, ViewGroup parent) {
                    Intrinsics.f(inflater, "inflater");
                    Intrinsics.f(parent, "parent");
                    View inflate = inflater.inflate(R.layout.content_earnings_pie_chart_legend, parent, false);
                    Intrinsics.e(inflate, "inflater.inflate(R.layou…rt_legend, parent, false)");
                    return new EarningsPieChartItemDelegate.LegendViewHolder(inflate);
                }
            });
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f29381w;
            View view = map.get(Integer.valueOf(i8));
            if (view == null) {
                View P = P();
                if (P == null || (findViewById = P.findViewById(i8)) == null) {
                    return null;
                }
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return view;
        }

        public View P() {
            return this.f29379u;
        }

        public final DynamicViewHelper<LegendViewHolder> Q() {
            return this.f29380v;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EarningsPieChartItemDelegate(Function1<? super Model, Unit> onLinkClick) {
        Intrinsics.f(onLinkClick, "onLinkClick");
        this.f29363b = onLinkClick;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(EarningsPieChartItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f29363b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return R.layout.delegate_item_earnings_pie_chart;
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
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_pie_chart, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…pie_chart, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        boolean z7;
        boolean z8;
        int v7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.f7332a.getContext();
        int i8 = R.id.cc;
        TextView textView = (TextView) holder.O(i8);
        Intrinsics.e(textView, "holder.title");
        boolean z9 = true;
        if (model.t() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(textView, z7, 0, 2, null);
        TextView textView2 = (TextView) holder.O(i8);
        Intrinsics.e(textView2, "holder.title");
        TextViewExtKt.h(textView2, model.t());
        int i9 = R.id.tb;
        TextView textView3 = (TextView) holder.O(i9);
        Intrinsics.e(textView3, "holder.subtitle");
        if (model.s() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.d(textView3, z8, 0, 2, null);
        TextView textView4 = (TextView) holder.O(i9);
        Intrinsics.e(textView4, "holder.subtitle");
        TextViewExtKt.h(textView4, model.s());
        PieChartView pieChartView = (PieChartView) holder.O(R.id.pieChartView);
        List<Segment> r7 = model.r();
        v7 = CollectionsKt__IterablesKt.v(r7, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Segment segment : r7) {
            float b8 = segment.b();
            Color a8 = segment.a();
            Context context2 = ((PieChartView) holder.O(R.id.pieChartView)).getContext();
            Intrinsics.e(context2, "holder.pieChartView.context");
            arrayList.add(new PieChartView.Segment(b8, ColorKt.a(a8, context2)));
        }
        pieChartView.setSegments(arrayList);
        holder.Q().a(model.n().size(), new Function2<LegendViewHolder, Integer, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsPieChartItemDelegate$onBindDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(EarningsPieChartItemDelegate.LegendViewHolder legendViewHolder, int i10) {
                boolean z10;
                int m8;
                Intrinsics.f(legendViewHolder, "legendViewHolder");
                EarningsPieChartItemDelegate.Legend legend = EarningsPieChartItemDelegate.Model.this.n().get(i10);
                ImageView imageView = (ImageView) legendViewHolder.b(R.id.legendColor);
                Intrinsics.e(imageView, "legendViewHolder.legendColor");
                ImageViewExtKt.a(imageView, legend.a());
                TextView textView5 = (TextView) legendViewHolder.b(R.id.legendTitle);
                Intrinsics.e(textView5, "legendViewHolder.legendTitle");
                TextViewExtKt.h(textView5, legend.c());
                int i11 = R.id.legendSubtitle;
                TextView textView6 = (TextView) legendViewHolder.b(i11);
                Intrinsics.e(textView6, "legendViewHolder.legendSubtitle");
                boolean z11 = true;
                if (legend.b() != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                ViewExtKt.d(textView6, z10, 0, 2, null);
                TextView textView7 = (TextView) legendViewHolder.b(i11);
                Intrinsics.e(textView7, "legendViewHolder.legendSubtitle");
                TextViewExtKt.h(textView7, legend.b());
                View b9 = legendViewHolder.b(R.id.legendDivider);
                Intrinsics.e(b9, "legendViewHolder.legendDivider");
                m8 = CollectionsKt__CollectionsKt.m(EarningsPieChartItemDelegate.Model.this.n());
                if (i10 == m8) {
                    z11 = false;
                }
                ViewExtKt.d(b9, z11, 0, 2, null);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(EarningsPieChartItemDelegate.LegendViewHolder legendViewHolder, Integer num) {
                b(legendViewHolder, num.intValue());
                return Unit.f50853a;
            }
        });
        int i10 = R.id.link;
        LinearLayout linearLayout = (LinearLayout) holder.O(i10);
        Intrinsics.e(linearLayout, "holder.link");
        if (model.o() == null) {
            z9 = false;
        }
        ViewExtKt.d(linearLayout, z9, 0, 2, null);
        int i11 = R.id.linkText;
        TextView textView5 = (TextView) holder.O(i11);
        Intrinsics.e(textView5, "holder.linkText");
        TextViewExtKt.h(textView5, model.o());
        Color p8 = model.p();
        Intrinsics.e(context, "context");
        ((TextView) holder.O(i11)).setTextColor(ColorKt.b(p8, context));
        TextView textView6 = (TextView) holder.O(i11);
        Intrinsics.e(textView6, "holder.linkText");
        TextViewExtKt.a(textView6, model.p());
        ((LinearLayout) holder.O(i10)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsPieChartItemDelegate.u(EarningsPieChartItemDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
