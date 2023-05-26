package ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.price.PriceReviewReason;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChooseReviewReasonDelegate.kt */
/* loaded from: classes3.dex */
public final class ChooseReviewReasonDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<PriceReviewReason, Unit> f31118b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31119c;

    /* compiled from: ChooseReviewReasonDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f31128u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.itemChooseReviewText);
            Intrinsics.e(findViewById, "itemView.findViewById(R.id.itemChooseReviewText)");
            this.f31128u = (TextView) findViewById;
        }

        public final TextView O() {
            return this.f31128u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChooseReviewReasonDelegate(Function1<? super PriceReviewReason, Unit> onReviewReasonClickListener) {
        Intrinsics.f(onReviewReasonClickListener, "onReviewReasonClickListener");
        this.f31118b = onReviewReasonClickListener;
        this.f31119c = R.layout.item_choose_review;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ChooseReviewReasonDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f31118b.invoke(model.n());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f31119c;
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
        View inflate = inflater.inflate(R.layout.item_choose_review, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…se_review, parent, false)");
        return new ViewHolder(inflate);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        String a8 = model.n().a();
        switch (a8.hashCode()) {
            case -1533946884:
                if (a8.equals("driver_set_client_did_not_pay")) {
                    holder.O().setText(R.string.price_review_client_did_not_pay_title);
                    break;
                }
                holder.O().setText(model.n().b());
                break;
            case -1248868316:
                if (a8.equals("driver_set_client_underpaid")) {
                    holder.O().setText(R.string.price_review_client_underpaid_title);
                    break;
                }
                holder.O().setText(model.n().b());
                break;
            case -1071202639:
                if (a8.equals("driver_set_additional_fees_problem")) {
                    holder.O().setText(R.string.price_review_additional_fees_problem);
                    break;
                }
                holder.O().setText(model.n().b());
                break;
            case -359543396:
                if (a8.equals("driver_set_other")) {
                    holder.O().setText(R.string.price_review_other_problem);
                    break;
                }
                holder.O().setText(model.n().b());
                break;
            case 331337089:
                if (a8.equals("driver_set_ride_did_not_happen")) {
                    holder.O().setText(R.string.price_review_cancelled_ride_title);
                    break;
                }
                holder.O().setText(model.n().b());
                break;
            case 1770258883:
                if (a8.equals("driver_set_wrong_price")) {
                    holder.O().setText(R.string.price_review_wrong_price_title);
                    break;
                }
                holder.O().setText(model.n().b());
                break;
            default:
                holder.O().setText(model.n().b());
                break;
        }
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooseReviewReasonDelegate.u(ChooseReviewReasonDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: ChooseReviewReasonDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final PriceReviewReason f31120a;

        /* renamed from: b  reason: collision with root package name */
        private final String f31121b;

        /* renamed from: c  reason: collision with root package name */
        private final Color f31122c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f31123d;

        /* renamed from: e  reason: collision with root package name */
        private final float f31124e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f31125f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f31126g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f31127h;

        public /* synthetic */ Model(PriceReviewReason priceReviewReason, String str, Color color, Color color2, float f8, boolean z7, boolean z8, boolean z9, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(priceReviewReason, str, (i8 & 4) != 0 ? new Color.Attr(R.attr.dynamicNeutral01) : color, (i8 & 8) != 0 ? new Color.Attr(R.attr.backPrimary) : color2, (i8 & 16) != 0 ? Dimens.c(1.0f) : f8, (i8 & 32) != 0 ? false : z7, (i8 & 64) != 0 ? true : z8, (i8 & 128) != 0 ? false : z9);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f31122c;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f31126g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(this.f31120a, model.f31120a) && Intrinsics.a(m(), model.m()) && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Float.compare(i().floatValue(), model.i().floatValue()) == 0 && j() == model.j() && e() == model.e() && k() == model.k();
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f31123d;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((((((this.f31120a.hashCode() * 31) + m().hashCode()) * 31) + d().hashCode()) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + i().hashCode()) * 31;
            boolean j8 = j();
            int i8 = j8;
            if (j8) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            boolean e8 = e();
            int i10 = e8;
            if (e8) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            boolean k8 = k();
            return i11 + (k8 ? 1 : k8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return Float.valueOf(this.f31124e);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f31125f;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f31127h;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f31121b;
        }

        public final PriceReviewReason n() {
            return this.f31120a;
        }

        public String toString() {
            PriceReviewReason priceReviewReason = this.f31120a;
            String m8 = m();
            Color d8 = d();
            Color f8 = f();
            Float i8 = i();
            boolean j8 = j();
            boolean e8 = e();
            boolean k8 = k();
            return "Model(reason=" + priceReviewReason + ", listId=" + m8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ", isDividerAtTheTop=" + j8 + ", isDividerEnabled=" + e8 + ", shouldIgnoreMargins=" + k8 + ")";
        }

        public Model(PriceReviewReason reason, String listId, Color dividerColor, Color color, float f8, boolean z7, boolean z8, boolean z9) {
            Intrinsics.f(reason, "reason");
            Intrinsics.f(listId, "listId");
            Intrinsics.f(dividerColor, "dividerColor");
            this.f31120a = reason;
            this.f31121b = listId;
            this.f31122c = dividerColor;
            this.f31123d = color;
            this.f31124e = f8;
            this.f31125f = z7;
            this.f31126g = z8;
            this.f31127h = z9;
        }
    }
}
