package ee.mtakso.driver.ui.screens.order.scheduled;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.RideDetailChip;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockController;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AcceptedOrderDelegate.kt */
/* loaded from: classes3.dex */
public final class AcceptedOrderDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f31579b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31580c;

    /* compiled from: AcceptedOrderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f31588u;

        /* renamed from: v  reason: collision with root package name */
        private final OrderChipsController f31589v;

        /* renamed from: w  reason: collision with root package name */
        private final OrderLabelsController f31590w;

        /* renamed from: x  reason: collision with root package name */
        private final InfoBlockController f31591x;

        /* renamed from: y  reason: collision with root package name */
        public Map<Integer, View> f31592y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            List n8;
            List n9;
            Intrinsics.f(containerView, "containerView");
            this.f31592y = new LinkedHashMap();
            this.f31588u = containerView;
            int i8 = R.id.root;
            ConstraintLayout root = (ConstraintLayout) O(i8);
            Intrinsics.e(root, "root");
            Flow chipFlow = (Flow) O(R.id.chipFlow);
            Intrinsics.e(chipFlow, "chipFlow");
            n8 = CollectionsKt__CollectionsKt.n(O(R.id.chip1), O(R.id.chip2));
            this.f31589v = new OrderChipsController(root, chipFlow, n8);
            ConstraintLayout root2 = (ConstraintLayout) O(i8);
            Intrinsics.e(root2, "root");
            Flow subtitleFlow = (Flow) O(R.id.subtitleFlow);
            Intrinsics.e(subtitleFlow, "subtitleFlow");
            n9 = CollectionsKt__CollectionsKt.n(O(R.id.label1), O(R.id.label2), O(R.id.label3));
            this.f31590w = new OrderLabelsController(root2, subtitleFlow, n9);
            View infoBlock = O(R.id.infoBlock);
            Intrinsics.e(infoBlock, "infoBlock");
            this.f31591x = new InfoBlockController(infoBlock);
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f31592y;
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
            return this.f31589v;
        }

        public View Q() {
            return this.f31588u;
        }

        public final InfoBlockController R() {
            return this.f31591x;
        }

        public final OrderLabelsController S() {
            return this.f31590w;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AcceptedOrderDelegate(Function1<? super Model, Unit> onItemClicked) {
        Intrinsics.f(onItemClicked, "onItemClicked");
        this.f31579b = onItemClicked;
        this.f31580c = R.layout.delegate_item_accepted_order;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AcceptedOrderDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f31579b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f31580c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_accepted_order, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…ted_order, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextView textView = (TextView) holder.O(R.id.cc);
        Intrinsics.e(textView, "holder.title");
        TextViewExtKt.h(textView, model.r());
        holder.P().b(model.n());
        holder.S().a(model.p());
        holder.R().b(model.o());
        holder.O(R.id.clickableBackground).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AcceptedOrderDelegate.u(AcceptedOrderDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: AcceptedOrderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f31581a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f31582b;

        /* renamed from: c  reason: collision with root package name */
        private final List<RideDetailChip> f31583c;

        /* renamed from: d  reason: collision with root package name */
        private final List<OrderLabelModel> f31584d;

        /* renamed from: e  reason: collision with root package name */
        private final InfoBlockData f31585e;

        /* renamed from: f  reason: collision with root package name */
        private final OrderHandle f31586f;

        /* renamed from: g  reason: collision with root package name */
        private final DividerModel f31587g;

        public /* synthetic */ Model(String str, Text text, List list, List list2, InfoBlockData infoBlockData, OrderHandle orderHandle, DividerModel dividerModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, text, list, list2, infoBlockData, orderHandle, (i8 & 64) != 0 ? new Divider(false, false, true, new Color.Attr(R.attr.backTertiary), null, Float.valueOf(Dimens.b(8.0f)), 19, null) : dividerModel);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f31587g.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f31587g.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f31582b, model.f31582b) && Intrinsics.a(this.f31583c, model.f31583c) && Intrinsics.a(this.f31584d, model.f31584d) && Intrinsics.a(this.f31585e, model.f31585e) && Intrinsics.a(this.f31586f, model.f31586f) && Intrinsics.a(this.f31587g, model.f31587g);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f31587g.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f31582b;
            int hashCode2 = (((((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f31583c.hashCode()) * 31) + this.f31584d.hashCode()) * 31;
            InfoBlockData infoBlockData = this.f31585e;
            return ((((hashCode2 + (infoBlockData != null ? infoBlockData.hashCode() : 0)) * 31) + this.f31586f.hashCode()) * 31) + this.f31587g.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f31587g.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f31587g.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f31587g.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f31581a;
        }

        public final List<RideDetailChip> n() {
            return this.f31583c;
        }

        public final InfoBlockData o() {
            return this.f31585e;
        }

        public final List<OrderLabelModel> p() {
            return this.f31584d;
        }

        public final OrderHandle q() {
            return this.f31586f;
        }

        public final Text r() {
            return this.f31582b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f31582b;
            List<RideDetailChip> list = this.f31583c;
            List<OrderLabelModel> list2 = this.f31584d;
            InfoBlockData infoBlockData = this.f31585e;
            OrderHandle orderHandle = this.f31586f;
            DividerModel dividerModel = this.f31587g;
            return "Model(listId=" + m8 + ", title=" + text + ", chips=" + list + ", labels=" + list2 + ", infoBlock=" + infoBlockData + ", orderHandle=" + orderHandle + ", divider=" + dividerModel + ")";
        }

        public Model(String listId, Text text, List<RideDetailChip> chips, List<OrderLabelModel> labels, InfoBlockData infoBlockData, OrderHandle orderHandle, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(chips, "chips");
            Intrinsics.f(labels, "labels");
            Intrinsics.f(orderHandle, "orderHandle");
            Intrinsics.f(divider, "divider");
            this.f31581a = listId;
            this.f31582b = text;
            this.f31583c = chips;
            this.f31584d = labels;
            this.f31585e = infoBlockData;
            this.f31586f = orderHandle;
            this.f31587g = divider;
        }
    }
}
