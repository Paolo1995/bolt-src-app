package ee.mtakso.driver.ui.screens.order.scheduled;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.RideDetailRoutePoint;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderDelegate.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final MapProvider f31654b;

    /* renamed from: c  reason: collision with root package name */
    private final AppThemeManager f31655c;

    /* renamed from: d  reason: collision with root package name */
    private final MarkerParamsFactory f31656d;

    /* renamed from: e  reason: collision with root package name */
    private final Function1<Model, Unit> f31657e;

    /* renamed from: f  reason: collision with root package name */
    private final int f31658f;

    /* compiled from: ScheduledOrderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f31666u;

        /* renamed from: v  reason: collision with root package name */
        private final OrderPointsController f31667v;

        /* renamed from: w  reason: collision with root package name */
        private final OrderLabelsController f31668w;

        /* renamed from: x  reason: collision with root package name */
        private final OrderMapController f31669x;

        /* renamed from: y  reason: collision with root package name */
        public Map<Integer, View> f31670y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView, MapProvider mapProvider, AppThemeManager themeManager, MarkerParamsFactory markerParamsFactory) {
            super(containerView);
            List n8;
            List n9;
            Intrinsics.f(containerView, "containerView");
            Intrinsics.f(mapProvider, "mapProvider");
            Intrinsics.f(themeManager, "themeManager");
            Intrinsics.f(markerParamsFactory, "markerParamsFactory");
            this.f31670y = new LinkedHashMap();
            this.f31666u = containerView;
            LinearLayout routePointLayout = (LinearLayout) O(R.id.routePointLayout);
            Intrinsics.e(routePointLayout, "routePointLayout");
            n8 = CollectionsKt__CollectionsKt.n(O(R.id.routePoint1), O(R.id.routePoint2), O(R.id.routePoint3));
            this.f31667v = new OrderPointsController(routePointLayout, n8);
            int i8 = R.id.root;
            ConstraintLayout root = (ConstraintLayout) O(i8);
            Intrinsics.e(root, "root");
            Flow subtitleFlow = (Flow) O(R.id.subtitleFlow);
            Intrinsics.e(subtitleFlow, "subtitleFlow");
            n9 = CollectionsKt__CollectionsKt.n(O(R.id.label1), O(R.id.label2), O(R.id.label3));
            this.f31668w = new OrderLabelsController(root, subtitleFlow, n9);
            ConstraintLayout root2 = (ConstraintLayout) O(i8);
            Intrinsics.e(root2, "root");
            View mapContainer = O(R.id.mapContainer);
            Intrinsics.e(mapContainer, "mapContainer");
            this.f31669x = new OrderMapController(root2, mapContainer, mapProvider, themeManager, markerParamsFactory);
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f31670y;
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
            return this.f31666u;
        }

        public final OrderLabelsController Q() {
            return this.f31668w;
        }

        public final OrderMapController R() {
            return this.f31669x;
        }

        public final OrderPointsController S() {
            return this.f31667v;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScheduledOrderDelegate(MapProvider mapProvider, AppThemeManager themeManager, MarkerParamsFactory markerParamsFactory, Function1<? super Model, Unit> onItemClicked) {
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(themeManager, "themeManager");
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        Intrinsics.f(onItemClicked, "onItemClicked");
        this.f31654b = mapProvider;
        this.f31655c = themeManager;
        this.f31656d = markerParamsFactory;
        this.f31657e = onItemClicked;
        this.f31658f = R.layout.delegate_item_scheduled_order;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ScheduledOrderDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f31657e.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f31658f;
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
        View inflate = inflater.inflate(R.layout.delegate_item_scheduled_order, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…led_order, parent, false)");
        return new ViewHolder(inflate, this.f31654b, this.f31655c, this.f31656d);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextView textView = (TextView) holder.O(R.id.cc);
        Intrinsics.e(textView, "holder.title");
        TextViewExtKt.h(textView, model.r());
        holder.O(R.id.clickableBackground).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScheduledOrderDelegate.u(ScheduledOrderDelegate.this, model, view);
            }
        });
        holder.Q().a(model.n());
        holder.S().b(model.q());
        holder.R().f(model.o());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: w */
    public void l(ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        holder.R().g();
    }

    /* compiled from: ScheduledOrderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f31659a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f31660b;

        /* renamed from: c  reason: collision with root package name */
        private final List<OrderLabelModel> f31661c;

        /* renamed from: d  reason: collision with root package name */
        private final OrderMapPoints f31662d;

        /* renamed from: e  reason: collision with root package name */
        private final List<RideDetailRoutePoint> f31663e;

        /* renamed from: f  reason: collision with root package name */
        private final OrderHandle f31664f;

        /* renamed from: g  reason: collision with root package name */
        private final DividerModel f31665g;

        public /* synthetic */ Model(String str, Text text, List list, OrderMapPoints orderMapPoints, List list2, OrderHandle orderHandle, DividerModel dividerModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, text, list, orderMapPoints, list2, orderHandle, (i8 & 64) != 0 ? new Divider(false, false, true, new Color.Attr(R.attr.backTertiary), null, Float.valueOf(Dimens.b(8.0f)), 19, null) : dividerModel);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f31665g.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f31665g.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f31660b, model.f31660b) && Intrinsics.a(this.f31661c, model.f31661c) && Intrinsics.a(this.f31662d, model.f31662d) && Intrinsics.a(this.f31663e, model.f31663e) && Intrinsics.a(this.f31664f, model.f31664f) && Intrinsics.a(this.f31665g, model.f31665g);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f31665g.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f31660b;
            return ((((((((((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f31661c.hashCode()) * 31) + this.f31662d.hashCode()) * 31) + this.f31663e.hashCode()) * 31) + this.f31664f.hashCode()) * 31) + this.f31665g.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f31665g.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f31665g.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f31665g.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f31659a;
        }

        public final List<OrderLabelModel> n() {
            return this.f31661c;
        }

        public final OrderMapPoints o() {
            return this.f31662d;
        }

        public final OrderHandle p() {
            return this.f31664f;
        }

        public final List<RideDetailRoutePoint> q() {
            return this.f31663e;
        }

        public final Text r() {
            return this.f31660b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f31660b;
            List<OrderLabelModel> list = this.f31661c;
            OrderMapPoints orderMapPoints = this.f31662d;
            List<RideDetailRoutePoint> list2 = this.f31663e;
            OrderHandle orderHandle = this.f31664f;
            DividerModel dividerModel = this.f31665g;
            return "Model(listId=" + m8 + ", title=" + text + ", labels=" + list + ", mapPoints=" + orderMapPoints + ", routePoints=" + list2 + ", orderHandle=" + orderHandle + ", divider=" + dividerModel + ")";
        }

        public Model(String listId, Text text, List<OrderLabelModel> labels, OrderMapPoints mapPoints, List<RideDetailRoutePoint> routePoints, OrderHandle orderHandle, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(labels, "labels");
            Intrinsics.f(mapPoints, "mapPoints");
            Intrinsics.f(routePoints, "routePoints");
            Intrinsics.f(orderHandle, "orderHandle");
            Intrinsics.f(divider, "divider");
            this.f31659a = listId;
            this.f31660b = text;
            this.f31661c = labels;
            this.f31662d = mapPoints;
            this.f31663e = routePoints;
            this.f31664f = orderHandle;
            this.f31665g = divider;
        }
    }
}
