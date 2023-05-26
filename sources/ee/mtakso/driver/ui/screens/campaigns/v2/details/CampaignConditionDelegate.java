package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.Condition;
import ee.mtakso.driver.network.client.campaign.ConditionType;
import ee.mtakso.driver.network.client.campaign.ProgressCondition;
import ee.mtakso.driver.network.client.campaign.ThresholdCondition;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignConditionDelegate.kt */
/* loaded from: classes3.dex */
public final class CampaignConditionDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f27417b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27418c;

    /* compiled from: CampaignConditionDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f27423u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f27424v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f27424v = new LinkedHashMap();
            this.f27423u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f27424v;
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
            return this.f27423u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CampaignConditionDelegate(Function1<? super Model, Unit> onInfoClicked) {
        Intrinsics.f(onInfoClicked, "onInfoClicked");
        this.f27417b = onInfoClicked;
        this.f27418c = R.layout.delegate_item_campaigns_v2_condition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(CampaignConditionDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f27417b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f27418c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_campaigns_v2_condition, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(\n      …      false\n            )");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        ProgressCondition a8 = model.o().a();
        ThresholdCondition b8 = model.o().b();
        boolean z8 = true;
        if (model.o().c() == ConditionType.PROGRESS && a8 != null) {
            ((TextView) holder.O(R.id.gc)).setText(a8.f());
            ((TextView) holder.O(R.id.wb)).setText(a8.c());
            ImageView imageView = (ImageView) holder.O(R.id.statusImage);
            Intrinsics.e(imageView, "holder.statusImage");
            ViewExtKt.d(imageView, a8.d(), 0, 2, null);
            int i8 = R.id.progressBar;
            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) holder.O(i8);
            Intrinsics.e(linearProgressIndicator, "holder.progressBar");
            ViewExtKt.d(linearProgressIndicator, (a8.d() || a8.e() <= 0.0d) ? false : false, 0, 2, null);
            ((LinearProgressIndicator) holder.O(i8)).setProgress((int) (a8.e() * ((LinearProgressIndicator) holder.O(i8)).getMax()));
            ImageButton imageButton = (ImageButton) holder.O(R.id.infoButton);
            Intrinsics.e(imageButton, "holder.infoButton");
            ViewExtKt.d(imageButton, false, 0, 2, null);
            TextView textView = (TextView) holder.O(R.id.lb);
            Intrinsics.e(textView, "holder.statusText");
            ViewExtKt.d(textView, false, 0, 2, null);
        } else if (model.o().c() == ConditionType.THRESHOLD && b8 != null) {
            ((TextView) holder.O(R.id.gc)).setText(b8.f());
            int i9 = R.id.infoButton;
            ImageButton imageButton2 = (ImageButton) holder.O(i9);
            Intrinsics.e(imageButton2, "holder.infoButton");
            if (b8.e() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewExtKt.d(imageButton2, z7, 0, 2, null);
            ((ImageButton) holder.O(i9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CampaignConditionDelegate.u(CampaignConditionDelegate.this, model, view);
                }
            });
            int i10 = R.id.wb;
            ((TextView) holder.O(i10)).setText(b8.d());
            Integer n8 = model.n();
            if (n8 != null) {
                int intValue = n8.intValue();
                TextView textView2 = (TextView) holder.O(i10);
                Intrinsics.e(textView2, "holder.subtitleText");
                ViewExtKt.e(textView2, 0, 0, 0, Integer.valueOf(intValue));
            }
            ImageView imageView2 = (ImageView) holder.O(R.id.statusImage);
            Intrinsics.e(imageView2, "holder.statusImage");
            ViewExtKt.d(imageView2, b8.c(), 0, 2, null);
            int i11 = R.id.lb;
            TextView textView3 = (TextView) holder.O(i11);
            Intrinsics.e(textView3, "holder.statusText");
            ViewExtKt.d(textView3, !b8.c(), 0, 2, null);
            ((TextView) holder.O(i11)).setText(b8.b());
            LinearProgressIndicator linearProgressIndicator2 = (LinearProgressIndicator) holder.O(R.id.progressBar);
            Intrinsics.e(linearProgressIndicator2, "holder.progressBar");
            ViewExtKt.d(linearProgressIndicator2, false, 0, 2, null);
        } else {
            String str = "Unsupported condition type: " + model.o().c() + " or value is null";
            Kalev.e(new RuntimeException(str), str);
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: CampaignConditionDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f27419a;

        /* renamed from: b  reason: collision with root package name */
        private final Condition f27420b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f27421c;

        /* renamed from: d  reason: collision with root package name */
        private final DividerModel f27422d;

        public /* synthetic */ Model(String str, Condition condition, Integer num, DividerModel dividerModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, condition, (i8 & 4) != 0 ? null : num, (i8 & 8) != 0 ? new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), null, null, 55, null) : dividerModel);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f27422d.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f27422d.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f27420b, model.f27420b) && Intrinsics.a(this.f27421c, model.f27421c) && Intrinsics.a(this.f27422d, model.f27422d);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f27422d.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((m().hashCode() * 31) + this.f27420b.hashCode()) * 31;
            Integer num = this.f27421c;
            return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.f27422d.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f27422d.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f27422d.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f27422d.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f27419a;
        }

        public final Integer n() {
            return this.f27421c;
        }

        public final Condition o() {
            return this.f27420b;
        }

        public String toString() {
            String m8 = m();
            Condition condition = this.f27420b;
            Integer num = this.f27421c;
            DividerModel dividerModel = this.f27422d;
            return "Model(listId=" + m8 + ", condition=" + condition + ", bottomSpace=" + num + ", divider=" + dividerModel + ")";
        }

        public Model(String listId, Condition condition, Integer num, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(condition, "condition");
            Intrinsics.f(divider, "divider");
            this.f27419a = listId;
            this.f27420b = condition;
            this.f27421c = num;
            this.f27422d = divider;
        }
    }
}
