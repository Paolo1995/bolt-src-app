package ee.mtakso.driver.ui.screens.order.arrived.raterider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderReasonsDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateRiderReasonsDelegate.kt */
/* loaded from: classes3.dex */
public final class RateRiderReasonsDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function2<View, Model, Unit> f31207b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31208c;

    /* compiled from: RateRiderReasonsDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f31213u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f31214v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f31214v = new LinkedHashMap();
            this.f31213u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f31214v;
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
            return this.f31213u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RateRiderReasonsDelegate(Function2<? super View, ? super Model, Unit> onClickListener) {
        Intrinsics.f(onClickListener, "onClickListener");
        this.f31207b = onClickListener;
        this.f31208c = R.layout.delegate_item_rate_rider_reason;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(RateRiderReasonsDelegate this$0, Model model, View v7) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        Function2<View, Model, Unit> function2 = this$0.f31207b;
        Intrinsics.e(v7, "v");
        function2.s(v7, model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f31208c;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        return model instanceof Model;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        ((TextView) holder.O(R.id.drivePriceClientRateReasonItemText)).setText(model.n().c());
        ((AppCompatRadioButton) holder.O(R.id.drivePriceClientRateReasonItemRadioButton)).setChecked(model.o());
        ((ConstraintLayout) holder.O(R.id.drivePriceClientRateReasonItemContainer)).setOnClickListener(new View.OnClickListener() { // from class: r4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RateRiderReasonsDelegate.u(RateRiderReasonsDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: w */
    public ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View inflate = inflater.inflate(R.layout.delegate_item_rate_rider_reason, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…er_reason, parent, false)");
        return new ViewHolder(inflate);
    }

    /* compiled from: RateRiderReasonsDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final RiderRatingReasons f31209a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f31210b;

        /* renamed from: c  reason: collision with root package name */
        private final String f31211c;

        /* renamed from: d  reason: collision with root package name */
        private final DividerModel f31212d;

        public /* synthetic */ Model(RiderRatingReasons riderRatingReasons, boolean z7, String str, DividerModel dividerModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(riderRatingReasons, z7, (i8 & 4) != 0 ? riderRatingReasons.getId() : str, (i8 & 8) != 0 ? NoDivider.f34829a : dividerModel);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f31212d.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f31212d.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return this.f31209a == model.f31209a && this.f31210b == model.f31210b && Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f31212d, model.f31212d);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f31212d.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = this.f31209a.hashCode() * 31;
            boolean z7 = this.f31210b;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return ((((hashCode + i8) * 31) + m().hashCode()) * 31) + this.f31212d.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f31212d.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f31212d.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f31212d.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f31211c;
        }

        public final RiderRatingReasons n() {
            return this.f31209a;
        }

        public final boolean o() {
            return this.f31210b;
        }

        public String toString() {
            RiderRatingReasons riderRatingReasons = this.f31209a;
            boolean z7 = this.f31210b;
            String m8 = m();
            DividerModel dividerModel = this.f31212d;
            return "Model(reason=" + riderRatingReasons + ", selected=" + z7 + ", listId=" + m8 + ", divider=" + dividerModel + ")";
        }

        public Model(RiderRatingReasons reason, boolean z7, String listId, DividerModel divider) {
            Intrinsics.f(reason, "reason");
            Intrinsics.f(listId, "listId");
            Intrinsics.f(divider, "divider");
            this.f31209a = reason;
            this.f31210b = z7;
            this.f31211c = listId;
            this.f31212d = divider;
        }
    }
}
