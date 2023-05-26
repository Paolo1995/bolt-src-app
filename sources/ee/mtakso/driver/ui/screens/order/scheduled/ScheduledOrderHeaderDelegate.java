package ee.mtakso.driver.ui.screens.order.scheduled;

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
import ee.mtakso.driver.network.client.order.RideDetailChip;
import ee.mtakso.driver.network.client.order.RideDetailRoutePoint;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockController;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderHeaderDelegate.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderHeaderDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final MapProvider f31725b;

    /* renamed from: c  reason: collision with root package name */
    private final AppThemeManager f31726c;

    /* renamed from: d  reason: collision with root package name */
    private final MarkerParamsFactory f31727d;

    /* renamed from: e  reason: collision with root package name */
    private final int f31728e;

    /* compiled from: ScheduledOrderHeaderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f31729a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f31730b;

        /* renamed from: c  reason: collision with root package name */
        private final List<RideDetailChip> f31731c;

        /* renamed from: d  reason: collision with root package name */
        private final List<OrderLabelModel> f31732d;

        /* renamed from: e  reason: collision with root package name */
        private final OrderMapPoints f31733e;

        /* renamed from: f  reason: collision with root package name */
        private final List<RideDetailRoutePoint> f31734f;

        /* renamed from: g  reason: collision with root package name */
        private final InfoBlockData f31735g;

        public Model(String listId, Text text, List<RideDetailChip> chips, List<OrderLabelModel> labels, OrderMapPoints mapPoints, List<RideDetailRoutePoint> routePoints, InfoBlockData infoBlockData) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(chips, "chips");
            Intrinsics.f(labels, "labels");
            Intrinsics.f(mapPoints, "mapPoints");
            Intrinsics.f(routePoints, "routePoints");
            this.f31729a = listId;
            this.f31730b = text;
            this.f31731c = chips;
            this.f31732d = labels;
            this.f31733e = mapPoints;
            this.f31734f = routePoints;
            this.f31735g = infoBlockData;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f31730b, model.f31730b) && Intrinsics.a(this.f31731c, model.f31731c) && Intrinsics.a(this.f31732d, model.f31732d) && Intrinsics.a(this.f31733e, model.f31733e) && Intrinsics.a(this.f31734f, model.f31734f) && Intrinsics.a(this.f31735g, model.f31735g);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f31730b;
            int hashCode2 = (((((((((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f31731c.hashCode()) * 31) + this.f31732d.hashCode()) * 31) + this.f31733e.hashCode()) * 31) + this.f31734f.hashCode()) * 31;
            InfoBlockData infoBlockData = this.f31735g;
            return hashCode2 + (infoBlockData != null ? infoBlockData.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f31729a;
        }

        public final List<RideDetailChip> n() {
            return this.f31731c;
        }

        public final InfoBlockData o() {
            return this.f31735g;
        }

        public final List<OrderLabelModel> p() {
            return this.f31732d;
        }

        public final OrderMapPoints q() {
            return this.f31733e;
        }

        public final List<RideDetailRoutePoint> r() {
            return this.f31734f;
        }

        public final Text s() {
            return this.f31730b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f31730b;
            List<RideDetailChip> list = this.f31731c;
            List<OrderLabelModel> list2 = this.f31732d;
            OrderMapPoints orderMapPoints = this.f31733e;
            List<RideDetailRoutePoint> list3 = this.f31734f;
            InfoBlockData infoBlockData = this.f31735g;
            return "Model(listId=" + m8 + ", title=" + text + ", chips=" + list + ", labels=" + list2 + ", mapPoints=" + orderMapPoints + ", routePoints=" + list3 + ", infoBlock=" + infoBlockData + ")";
        }
    }

    /* compiled from: ScheduledOrderHeaderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public Map<Integer, View> A;

        /* renamed from: u  reason: collision with root package name */
        private final View f31736u;

        /* renamed from: v  reason: collision with root package name */
        private final OrderChipsController f31737v;

        /* renamed from: w  reason: collision with root package name */
        private final OrderLabelsController f31738w;

        /* renamed from: x  reason: collision with root package name */
        private final OrderPointsController f31739x;

        /* renamed from: y  reason: collision with root package name */
        private final InfoBlockController f31740y;

        /* renamed from: z  reason: collision with root package name */
        private final OrderMapController f31741z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView, MapProvider mapProvider, AppThemeManager themeManager, MarkerParamsFactory markerParamsFactory) {
            super(containerView);
            List n8;
            List n9;
            List n10;
            Intrinsics.f(containerView, "containerView");
            Intrinsics.f(mapProvider, "mapProvider");
            Intrinsics.f(themeManager, "themeManager");
            Intrinsics.f(markerParamsFactory, "markerParamsFactory");
            this.A = new LinkedHashMap();
            this.f31736u = containerView;
            int i8 = R.id.root;
            ConstraintLayout root = (ConstraintLayout) O(i8);
            Intrinsics.e(root, "root");
            Flow chipFlow = (Flow) O(R.id.chipFlow);
            Intrinsics.e(chipFlow, "chipFlow");
            n8 = CollectionsKt__CollectionsKt.n(O(R.id.chip1), O(R.id.chip2));
            this.f31737v = new OrderChipsController(root, chipFlow, n8);
            ConstraintLayout root2 = (ConstraintLayout) O(i8);
            Intrinsics.e(root2, "root");
            Flow subtitleFlow = (Flow) O(R.id.subtitleFlow);
            Intrinsics.e(subtitleFlow, "subtitleFlow");
            n9 = CollectionsKt__CollectionsKt.n(O(R.id.label1), O(R.id.label2));
            this.f31738w = new OrderLabelsController(root2, subtitleFlow, n9);
            LinearLayout routePointLayout = (LinearLayout) O(R.id.routePointLayout);
            Intrinsics.e(routePointLayout, "routePointLayout");
            n10 = CollectionsKt__CollectionsKt.n(O(R.id.routePoint1), O(R.id.routePoint2), O(R.id.routePoint3));
            this.f31739x = new OrderPointsController(routePointLayout, n10);
            View infoBlock = O(R.id.infoBlock);
            Intrinsics.e(infoBlock, "infoBlock");
            this.f31740y = new InfoBlockController(infoBlock);
            ConstraintLayout root3 = (ConstraintLayout) O(i8);
            Intrinsics.e(root3, "root");
            View mapContainer = O(R.id.mapContainer);
            Intrinsics.e(mapContainer, "mapContainer");
            this.f31741z = new OrderMapController(root3, mapContainer, mapProvider, themeManager, markerParamsFactory);
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.A;
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

        public final OrderChipsController P() {
            return this.f31737v;
        }

        public View Q() {
            return this.f31736u;
        }

        public final InfoBlockController R() {
            return this.f31740y;
        }

        public final OrderLabelsController S() {
            return this.f31738w;
        }

        public final OrderMapController T() {
            return this.f31741z;
        }

        public final OrderPointsController U() {
            return this.f31739x;
        }
    }

    public ScheduledOrderHeaderDelegate(MapProvider mapProvider, AppThemeManager themeManager, MarkerParamsFactory markerParamsFactory) {
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(themeManager, "themeManager");
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        this.f31725b = mapProvider;
        this.f31726c = themeManager;
        this.f31727d = markerParamsFactory;
        this.f31728e = R.layout.delegate_item_scheduled_order_details_header;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f31728e;
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
        View inflate = inflater.inflate(R.layout.delegate_item_scheduled_order_details_header, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…ls_header, parent, false)");
        return new ViewHolder(inflate, this.f31725b, this.f31726c, this.f31727d);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextView textView = (TextView) holder.O(R.id.cc);
        Intrinsics.e(textView, "holder.title");
        TextViewExtKt.h(textView, model.s());
        ImageView imageView = (ImageView) holder.O(R.id.chipsDivider);
        Intrinsics.e(imageView, "holder.chipsDivider");
        ViewExtKt.d(imageView, model.n().isEmpty(), 0, 2, null);
        holder.P().b(model.n());
        holder.S().a(model.p());
        holder.T().f(model.q());
        holder.U().b(model.r());
        holder.R().b(model.o());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void l(ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        super.l(holder);
    }
}
