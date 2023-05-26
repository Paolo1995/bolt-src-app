package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.EarningsRipple;
import ee.mtakso.driver.ui.screens.earnings.v3.EarningsSpan;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityChartItemDelegate;
import ee.mtakso.driver.ui.views.DynamicViewHelper;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsActivityChartItemDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsActivityChartItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f29254b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29255c;

    /* compiled from: EarningsActivityChartItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Bar {

        /* renamed from: a  reason: collision with root package name */
        private final int f29256a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f29257b;

        public Bar(int i8, Text legend) {
            Intrinsics.f(legend, "legend");
            this.f29256a = i8;
            this.f29257b = legend;
        }

        public final Text a() {
            return this.f29257b;
        }

        public final int b() {
            return this.f29256a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Bar) {
                Bar bar = (Bar) obj;
                return this.f29256a == bar.f29256a && Intrinsics.a(this.f29257b, bar.f29257b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f29256a * 31) + this.f29257b.hashCode();
        }

        public String toString() {
            int i8 = this.f29256a;
            Text text = this.f29257b;
            return "Bar(progress=" + i8 + ", legend=" + text + ")";
        }
    }

    /* compiled from: EarningsActivityChartItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ChartViewHolder implements DynamicViewHelper.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f29258a;

        /* renamed from: b  reason: collision with root package name */
        public Map<Integer, View> f29259b;

        public ChartViewHolder(View containerView) {
            Intrinsics.f(containerView, "containerView");
            this.f29259b = new LinkedHashMap();
            this.f29258a = containerView;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewHelper.ViewHolder
        public View a() {
            return this.f29258a;
        }

        public View b(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f29259b;
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

    /* compiled from: EarningsActivityChartItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f29265u;

        /* renamed from: v  reason: collision with root package name */
        private final DynamicViewHelper<ChartViewHolder> f29266v;

        /* renamed from: w  reason: collision with root package name */
        public Map<Integer, View> f29267w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            List q8;
            Intrinsics.f(containerView, "containerView");
            this.f29267w = new LinkedHashMap();
            this.f29265u = containerView;
            LinearLayout linearLayout = (LinearLayout) Q().findViewById(R.id.chart);
            Intrinsics.e(linearLayout, "containerView.chart");
            View findViewById = Q().findViewById(R.id.chartItem1);
            Intrinsics.e(findViewById, "containerView.chartItem1");
            View findViewById2 = Q().findViewById(R.id.chartItem2);
            Intrinsics.e(findViewById2, "containerView.chartItem2");
            View findViewById3 = Q().findViewById(R.id.chartItem3);
            Intrinsics.e(findViewById3, "containerView.chartItem3");
            View findViewById4 = Q().findViewById(R.id.chartItem4);
            Intrinsics.e(findViewById4, "containerView.chartItem4");
            View findViewById5 = Q().findViewById(R.id.chartItem5);
            Intrinsics.e(findViewById5, "containerView.chartItem5");
            View findViewById6 = Q().findViewById(R.id.chartItem6);
            Intrinsics.e(findViewById6, "containerView.chartItem6");
            View findViewById7 = Q().findViewById(R.id.chartItem7);
            Intrinsics.e(findViewById7, "containerView.chartItem7");
            q8 = CollectionsKt__CollectionsKt.q(new ChartViewHolder(findViewById), new ChartViewHolder(findViewById2), new ChartViewHolder(findViewById3), new ChartViewHolder(findViewById4), new ChartViewHolder(findViewById5), new ChartViewHolder(findViewById6), new ChartViewHolder(findViewById7));
            this.f29266v = new DynamicViewHelper<>(linearLayout, q8, null, new Function2<LayoutInflater, ViewGroup, ChartViewHolder>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityChartItemDelegate$ViewHolder$charts$1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final EarningsActivityChartItemDelegate.ChartViewHolder s(LayoutInflater inflater, ViewGroup parent) {
                    Intrinsics.f(inflater, "inflater");
                    Intrinsics.f(parent, "parent");
                    View inflate = inflater.inflate(R.layout.content_earnings_activity_tile_chart_item, parent, false);
                    Intrinsics.e(inflate, "inflater.inflate(\n      …  false\n                )");
                    return new EarningsActivityChartItemDelegate.ChartViewHolder(inflate);
                }
            }, 4, null);
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f29267w;
            View view = map.get(Integer.valueOf(i8));
            if (view == null) {
                View Q = Q();
                if (Q == null || (findViewById = Q.findViewById(i8)) == null) {
                    return null;
                }
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return view;
        }

        public final DynamicViewHelper<ChartViewHolder> P() {
            return this.f29266v;
        }

        public View Q() {
            return this.f29265u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EarningsActivityChartItemDelegate(Function1<? super Model, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f29254b = onClick;
        this.f29255c = R.layout.delegate_item_earnings_activity_chart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(EarningsActivityChartItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f29254b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f29255c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_activity_chart, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(\n      …      false\n            )");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        int i8 = R.id.f19825a0;
        ((ImageView) holder.O(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsActivityChartItemDelegate.u(EarningsActivityChartItemDelegate.this, model, view);
            }
        });
        EarningsRipple earningsRipple = EarningsRipple.f28765a;
        ImageView imageView = (ImageView) holder.O(i8);
        Intrinsics.e(imageView, "holder.background");
        earningsRipple.a(imageView);
        TextView textView = (TextView) holder.O(R.id.cc);
        Intrinsics.e(textView, "holder.title");
        TextViewExtKt.h(textView, model.p());
        holder.P().a(model.n().size(), new Function2<ChartViewHolder, Integer, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityChartItemDelegate$onBindDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(EarningsActivityChartItemDelegate.ChartViewHolder chartHolder, int i9) {
                Intrinsics.f(chartHolder, "chartHolder");
                EarningsActivityChartItemDelegate.Bar bar = EarningsActivityChartItemDelegate.Model.this.n().get(i9);
                ((ProgressBar) chartHolder.b(R.id.activityChartProgress)).setProgress(bar.b());
                TextView textView2 = (TextView) chartHolder.b(R.id.activityChartLegend);
                Intrinsics.e(textView2, "chartHolder.activityChartLegend");
                TextViewExtKt.h(textView2, bar.a());
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(EarningsActivityChartItemDelegate.ChartViewHolder chartViewHolder, Integer num) {
                b(chartViewHolder, num.intValue());
                return Unit.f50853a;
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: EarningsActivityChartItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements SpanModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f29260a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f29261b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Bar> f29262c;

        /* renamed from: d  reason: collision with root package name */
        private final String f29263d;

        /* renamed from: e  reason: collision with root package name */
        private final SpanModel f29264e;

        public /* synthetic */ Model(String str, Text text, List list, String str2, SpanModel spanModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, text, list, str2, (i8 & 16) != 0 ? EarningsSpan.f28766a : spanModel);
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int b() {
            return this.f29264e.b();
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int c() {
            return this.f29264e.c();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f29261b, model.f29261b) && Intrinsics.a(this.f29262c, model.f29262c) && Intrinsics.a(this.f29263d, model.f29263d) && Intrinsics.a(this.f29264e, model.f29264e);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int g() {
            return this.f29264e.g();
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int h() {
            return this.f29264e.h();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((m().hashCode() * 31) + this.f29261b.hashCode()) * 31) + this.f29262c.hashCode()) * 31;
            String str = this.f29263d;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f29264e.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f29260a;
        }

        public final List<Bar> n() {
            return this.f29262c;
        }

        public final String o() {
            return this.f29263d;
        }

        public final Text p() {
            return this.f29261b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f29261b;
            List<Bar> list = this.f29262c;
            String str = this.f29263d;
            SpanModel spanModel = this.f29264e;
            return "Model(listId=" + m8 + ", title=" + text + ", bars=" + list + ", payload=" + str + ", span=" + spanModel + ")";
        }

        public Model(String listId, Text title, List<Bar> bars, String str, SpanModel span) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(bars, "bars");
            Intrinsics.f(span, "span");
            this.f29260a = listId;
            this.f29261b = title;
            this.f29262c = bars;
            this.f29263d = str;
            this.f29264e = span;
        }
    }
}
