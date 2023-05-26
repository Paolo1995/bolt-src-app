package ee.mtakso.driver.ui.screens.campaigns.v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.campaign.OptInGroupSummary;
import ee.mtakso.driver.ui.views.campaigns.tile.ActiveCampaignTileViewDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import j$.util.Spliterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignBannerTileDelegate.kt */
/* loaded from: classes3.dex */
public final class CampaignBannerTileDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final DateTimeConverter f27262b;

    /* renamed from: c  reason: collision with root package name */
    private final Function2<CampaignTileMode, Long, Unit> f27263c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27264d;

    /* compiled from: CampaignBannerTileDelegate.kt */
    /* loaded from: classes3.dex */
    public enum CampaignTileMode {
        REFERRALS,
        OPT_IN,
        CIRCLE_K_LOYALTY
    }

    /* compiled from: CampaignBannerTileDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final ActiveCampaignTileViewDelegate f27279u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            this.f27279u = new ActiveCampaignTileViewDelegate(itemView, ActiveCampaignTileViewDelegate.ViewMode.TILE, ActiveCampaignTileViewDelegate.LeftActionMode.CHEVRON);
        }

        public final ActiveCampaignTileViewDelegate O() {
            return this.f27279u;
        }
    }

    /* compiled from: CampaignBannerTileDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27280a;

        static {
            int[] iArr = new int[CampaignTileMode.values().length];
            try {
                iArr[CampaignTileMode.CIRCLE_K_LOYALTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CampaignTileMode.REFERRALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f27280a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CampaignBannerTileDelegate(DateTimeConverter dateTimeConverter, Function2<? super CampaignTileMode, ? super Long, Unit> onTileClickListener) {
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Intrinsics.f(onTileClickListener, "onTileClickListener");
        this.f27262b = dateTimeConverter;
        this.f27263c = onTileClickListener;
        this.f27264d = R.layout.tile_active_campaign;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(CampaignBannerTileDelegate this$0, Model model, View view) {
        Long l8;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        Function2<CampaignTileMode, Long, Unit> function2 = this$0.f27263c;
        CampaignTileMode n8 = model.n();
        OptInGroupSummary p8 = model.p();
        if (p8 != null) {
            l8 = Long.valueOf(p8.b());
        } else {
            l8 = null;
        }
        function2.s(n8, l8);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f27264d;
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
        View inflate = inflater.inflate(R.layout.tile_active_campaign, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…_campaign, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        long j8;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.f7332a.getContext();
        ViewGroup.LayoutParams layoutParams = holder.f7332a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart(Dimens.d(8));
            marginLayoutParams.setMarginEnd(Dimens.d(8));
            holder.f7332a.setLayoutParams(marginLayoutParams);
        }
        ActiveCampaignTileViewDelegate O = holder.O();
        Context context2 = holder.f7332a.getContext();
        Intrinsics.e(context2, "holder.itemView.context");
        O.j(ContextUtilsKt.b(context2, R.attr.contentPrimary));
        int i8 = WhenMappings.f27280a[model.n().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                holder.O().k(context.getString(R.string.choose_bonus_campaign));
                ActiveCampaignTileViewDelegate O2 = holder.O();
                Object[] objArr = new Object[1];
                Intrinsics.e(context, "context");
                OptInGroupSummary p8 = model.p();
                if (p8 != null) {
                    j8 = p8.a();
                } else {
                    j8 = 1;
                }
                objArr[0] = CampaignPeriodBadgesConditionsDelegateKt.u(context, j8, false, this.f27262b);
                O2.i(context.getString(R.string.respond_by_date, objArr));
                holder.O().e(ContextCompat.getDrawable(context, R.drawable.circle_yellow900));
                holder.O().d(Integer.valueOf((int) R.drawable.ic_opt_in_campaign));
                holder.O().g(R.color.white);
                holder.O().f(8);
            } else {
                holder.O().k(context.getString(R.string.earn_amount, model.o()));
                holder.O().i(context.getString(R.string.invite_friends_drive));
                holder.O().e(ContextCompat.getDrawable(context, R.drawable.circle_purple500));
                holder.O().d(Integer.valueOf((int) R.drawable.ic_gift));
                holder.O().g(R.color.white);
                holder.O().f(8);
            }
        } else {
            holder.O().k(context.getString(R.string.circle_k_loyalty_program_title));
            holder.O().i(context.getString(R.string.circle_k_loyalty_program_description));
            holder.O().e(ContextCompat.getDrawable(context, R.drawable.round_transparent));
            holder.O().d(Integer.valueOf((int) R.drawable.ic_circle_k));
            holder.O().g(R.color.transparent);
            holder.O().f(0);
        }
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CampaignBannerTileDelegate.u(CampaignBannerTileDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: CampaignBannerTileDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f27269a;

        /* renamed from: b  reason: collision with root package name */
        private final String f27270b;

        /* renamed from: c  reason: collision with root package name */
        private final OptInGroupSummary f27271c;

        /* renamed from: d  reason: collision with root package name */
        private final CampaignTileMode f27272d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f27273e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f27274f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f27275g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f27276h;

        /* renamed from: i  reason: collision with root package name */
        private final Color f27277i;

        /* renamed from: j  reason: collision with root package name */
        private final Float f27278j;

        public /* synthetic */ Model(String str, String str2, OptInGroupSummary optInGroupSummary, CampaignTileMode campaignTileMode, boolean z7, boolean z8, boolean z9, Color color, Color color2, Float f8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : optInGroupSummary, campaignTileMode, (i8 & 16) != 0 ? true : z7, (i8 & 32) != 0 ? false : z8, (i8 & 64) != 0 ? true : z9, (i8 & 128) != 0 ? new Color.Res(R.color.transparent) : color, (i8 & Spliterator.NONNULL) != 0 ? new Color.Res(R.color.transparent) : color2, (i8 & 512) != 0 ? Float.valueOf(Dimens.c(8.0f)) : f8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f27276h;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f27273e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f27270b, model.f27270b) && Intrinsics.a(this.f27271c, model.f27271c) && this.f27272d == model.f27272d && e() == model.e() && j() == model.j() && k() == model.k() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Intrinsics.a(i(), model.i());
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f27277i;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            String str = this.f27270b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            OptInGroupSummary optInGroupSummary = this.f27271c;
            int hashCode3 = (((hashCode2 + (optInGroupSummary == null ? 0 : optInGroupSummary.hashCode())) * 31) + this.f27272d.hashCode()) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            int i9 = (hashCode3 + i8) * 31;
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
            return this.f27278j;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f27274f;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f27275g;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f27269a;
        }

        public final CampaignTileMode n() {
            return this.f27272d;
        }

        public final String o() {
            return this.f27270b;
        }

        public final OptInGroupSummary p() {
            return this.f27271c;
        }

        public String toString() {
            String m8 = m();
            String str = this.f27270b;
            OptInGroupSummary optInGroupSummary = this.f27271c;
            CampaignTileMode campaignTileMode = this.f27272d;
            boolean e8 = e();
            boolean j8 = j();
            boolean k8 = k();
            Color d8 = d();
            Color f8 = f();
            Float i8 = i();
            return "Model(listId=" + m8 + ", earningsAmount=" + str + ", optInGroupSummary=" + optInGroupSummary + ", campaignTileMode=" + campaignTileMode + ", isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ")";
        }

        public Model(String listId, String str, OptInGroupSummary optInGroupSummary, CampaignTileMode campaignTileMode, boolean z7, boolean z8, boolean z9, Color color, Color color2, Float f8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(campaignTileMode, "campaignTileMode");
            this.f27269a = listId;
            this.f27270b = str;
            this.f27271c = optInGroupSummary;
            this.f27272d = campaignTileMode;
            this.f27273e = z7;
            this.f27274f = z8;
            this.f27275g = z9;
            this.f27276h = color;
            this.f27277i = color2;
            this.f27278j = f8;
        }
    }
}
