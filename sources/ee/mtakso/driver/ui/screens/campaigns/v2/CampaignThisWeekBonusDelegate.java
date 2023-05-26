package ee.mtakso.driver.ui.screens.campaigns.v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.CampaignDisplayPrice;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignThisWeekBonusDelegate.kt */
/* loaded from: classes3.dex */
public final class CampaignThisWeekBonusDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f27311b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<Unit> f27312c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27313d;

    /* compiled from: CampaignThisWeekBonusDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f27322u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f27323v;

        /* renamed from: w  reason: collision with root package name */
        private final TextView f27324w;

        /* renamed from: x  reason: collision with root package name */
        private final View f27325x;

        /* renamed from: y  reason: collision with root package name */
        private final View f27326y;

        /* renamed from: z  reason: collision with root package name */
        private final TextView f27327z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.campaignBonusAmountCurrencyBefore);
            Intrinsics.e(findViewById, "itemView.findViewById(R.…onusAmountCurrencyBefore)");
            this.f27322u = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.campaignBonusAmount);
            Intrinsics.e(findViewById2, "itemView.findViewById(R.id.campaignBonusAmount)");
            this.f27323v = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.campaignBonusAmountCurrencyAfter);
            Intrinsics.e(findViewById3, "itemView.findViewById(R.…BonusAmountCurrencyAfter)");
            this.f27324w = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.campaignBonusAmountContainer);
            Intrinsics.e(findViewById4, "itemView.findViewById(R.…aignBonusAmountContainer)");
            this.f27325x = findViewById4;
            View findViewById5 = itemView.findViewById(R.id.campaignGroupBonus);
            Intrinsics.e(findViewById5, "itemView.findViewById(R.id.campaignGroupBonus)");
            this.f27326y = findViewById5;
            View findViewById6 = itemView.findViewById(R.id.f486previousCampaignTitle);
            Intrinsics.e(findViewById6, "itemView.findViewById(R.id.previousCampaignTitle)");
            this.f27327z = (TextView) findViewById6;
        }

        public final TextView O() {
            return this.f27323v;
        }

        public final View P() {
            return this.f27325x;
        }

        public final TextView Q() {
            return this.f27324w;
        }

        public final TextView R() {
            return this.f27322u;
        }

        public final View S() {
            return this.f27326y;
        }

        public final TextView T() {
            return this.f27327z;
        }
    }

    public CampaignThisWeekBonusDelegate(Function0<Unit> onPreviousCampaignsClickListener, Function0<Unit> onCampaignEarningsClickListener) {
        Intrinsics.f(onPreviousCampaignsClickListener, "onPreviousCampaignsClickListener");
        Intrinsics.f(onCampaignEarningsClickListener, "onCampaignEarningsClickListener");
        this.f27311b = onPreviousCampaignsClickListener;
        this.f27312c = onCampaignEarningsClickListener;
        this.f27313d = R.layout.delegate_item_campaign_this_week_bonus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(CampaignThisWeekBonusDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f27311b.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(CampaignThisWeekBonusDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f27312c.invoke();
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f27313d;
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
        View inflate = inflater.inflate(R.layout.delegate_item_campaign_this_week_bonus, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…eek_bonus, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void g(ViewHolder holder, Model model) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        if (model.n() != null) {
            boolean z8 = true;
            ViewExtKt.e(holder.S(), true, 0, 2, null);
            holder.R().setText(model.n().c());
            TextView R = holder.R();
            if (model.n().c() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewExtKt.e(R, z7, 0, 2, null);
            holder.O().setText(model.n().a());
            holder.Q().setText(model.n().b());
            TextView Q = holder.Q();
            if (model.n().b() == null) {
                z8 = false;
            }
            ViewExtKt.e(Q, z8, 0, 2, null);
        } else {
            ViewExtKt.e(holder.S(), false, 0, 2, null);
        }
        holder.T().setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CampaignThisWeekBonusDelegate.v(CampaignThisWeekBonusDelegate.this, view);
            }
        });
        holder.P().setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CampaignThisWeekBonusDelegate.w(CampaignThisWeekBonusDelegate.this, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: x */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: CampaignThisWeekBonusDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f27314a;

        /* renamed from: b  reason: collision with root package name */
        private final CampaignDisplayPrice f27315b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f27316c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f27317d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f27318e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f27319f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f27320g;

        /* renamed from: h  reason: collision with root package name */
        private final Float f27321h;

        public /* synthetic */ Model(String str, CampaignDisplayPrice campaignDisplayPrice, boolean z7, boolean z8, boolean z9, Color color, Color color2, Float f8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, campaignDisplayPrice, (i8 & 4) != 0 ? true : z7, (i8 & 8) != 0 ? false : z8, (i8 & 16) != 0 ? true : z9, (i8 & 32) != 0 ? new Color.Res(R.color.transparent) : color, (i8 & 64) != 0 ? new Color.Res(R.color.transparent) : color2, (i8 & 128) != 0 ? Float.valueOf(Dimens.c(8.0f)) : f8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f27319f;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f27316c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f27315b, model.f27315b) && e() == model.e() && j() == model.j() && k() == model.k() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Intrinsics.a(i(), model.i());
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f27320g;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            CampaignDisplayPrice campaignDisplayPrice = this.f27315b;
            int hashCode2 = (hashCode + (campaignDisplayPrice == null ? 0 : campaignDisplayPrice.hashCode())) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            int i9 = (hashCode2 + i8) * 31;
            boolean j8 = j();
            int i10 = j8;
            if (j8) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            boolean k8 = k();
            return ((((((i11 + (k8 ? 1 : k8)) * 31) + (d() == null ? 0 : d().hashCode())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + (i() != null ? i().hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f27321h;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f27317d;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f27318e;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f27314a;
        }

        public final CampaignDisplayPrice n() {
            return this.f27315b;
        }

        public String toString() {
            String m8 = m();
            CampaignDisplayPrice campaignDisplayPrice = this.f27315b;
            boolean e8 = e();
            boolean j8 = j();
            boolean k8 = k();
            Color d8 = d();
            Color f8 = f();
            Float i8 = i();
            return "Model(listId=" + m8 + ", thisWeekBonus=" + campaignDisplayPrice + ", isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ")";
        }

        public Model(String listId, CampaignDisplayPrice campaignDisplayPrice, boolean z7, boolean z8, boolean z9, Color color, Color color2, Float f8) {
            Intrinsics.f(listId, "listId");
            this.f27314a = listId;
            this.f27315b = campaignDisplayPrice;
            this.f27316c = z7;
            this.f27317d = z8;
            this.f27318e = z9;
            this.f27319f = color;
            this.f27320g = color2;
            this.f27321h = f8;
        }
    }
}
