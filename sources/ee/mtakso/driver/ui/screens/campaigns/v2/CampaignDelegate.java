package ee.mtakso.driver.ui.screens.campaigns.v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignDelegate.kt */
/* loaded from: classes3.dex */
public final class CampaignDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f27281b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27282c;

    /* compiled from: CampaignDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ChipModel {

        /* renamed from: a  reason: collision with root package name */
        private final Text f27283a;

        /* renamed from: b  reason: collision with root package name */
        private final Image f27284b;

        /* renamed from: c  reason: collision with root package name */
        private final Color f27285c;

        public ChipModel(Text text, Image image, Color background) {
            Intrinsics.f(background, "background");
            this.f27283a = text;
            this.f27284b = image;
            this.f27285c = background;
        }

        public final Color a() {
            return this.f27285c;
        }

        public final Image b() {
            return this.f27284b;
        }

        public final Text c() {
            return this.f27283a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChipModel) {
                ChipModel chipModel = (ChipModel) obj;
                return Intrinsics.a(this.f27283a, chipModel.f27283a) && Intrinsics.a(this.f27284b, chipModel.f27284b) && Intrinsics.a(this.f27285c, chipModel.f27285c);
            }
            return false;
        }

        public int hashCode() {
            Text text = this.f27283a;
            int hashCode = (text == null ? 0 : text.hashCode()) * 31;
            Image image = this.f27284b;
            return ((hashCode + (image != null ? image.hashCode() : 0)) * 31) + this.f27285c.hashCode();
        }

        public String toString() {
            Text text = this.f27283a;
            Image image = this.f27284b;
            Color color = this.f27285c;
            return "ChipModel(text=" + text + ", image=" + image + ", background=" + color + ")";
        }
    }

    /* compiled from: CampaignDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ConditionModel {

        /* renamed from: a  reason: collision with root package name */
        private final Text f27286a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f27287b;

        public ConditionModel(Text text, boolean z7) {
            Intrinsics.f(text, "text");
            this.f27286a = text;
            this.f27287b = z7;
        }

        public final boolean a() {
            return this.f27287b;
        }

        public final Text b() {
            return this.f27286a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ConditionModel) {
                ConditionModel conditionModel = (ConditionModel) obj;
                return Intrinsics.a(this.f27286a, conditionModel.f27286a) && this.f27287b == conditionModel.f27287b;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f27286a.hashCode() * 31;
            boolean z7 = this.f27287b;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        public String toString() {
            Text text = this.f27286a;
            boolean z7 = this.f27287b;
            return "ConditionModel(text=" + text + ", success=" + z7 + ")";
        }
    }

    /* compiled from: CampaignDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f27288a;

        /* renamed from: b  reason: collision with root package name */
        private final long f27289b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f27290c;

        /* renamed from: d  reason: collision with root package name */
        private final List<ChipModel> f27291d;

        /* renamed from: e  reason: collision with root package name */
        private final Text f27292e;

        /* renamed from: f  reason: collision with root package name */
        private final Text f27293f;

        /* renamed from: g  reason: collision with root package name */
        private final Text f27294g;

        /* renamed from: h  reason: collision with root package name */
        private final Text f27295h;

        /* renamed from: i  reason: collision with root package name */
        private final List<ConditionModel> f27296i;

        /* renamed from: j  reason: collision with root package name */
        private final Text f27297j;

        /* renamed from: k  reason: collision with root package name */
        private final DividerModel f27298k;

        public Model(String listId, long j8, Text text, List<ChipModel> list, Text text2, Text text3, Text text4, Text text5, List<ConditionModel> list2, Text text6, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(divider, "divider");
            this.f27288a = listId;
            this.f27289b = j8;
            this.f27290c = text;
            this.f27291d = list;
            this.f27292e = text2;
            this.f27293f = text3;
            this.f27294g = text4;
            this.f27295h = text5;
            this.f27296i = list2;
            this.f27297j = text6;
            this.f27298k = divider;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f27298k.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f27298k.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && this.f27289b == model.f27289b && Intrinsics.a(this.f27290c, model.f27290c) && Intrinsics.a(this.f27291d, model.f27291d) && Intrinsics.a(this.f27292e, model.f27292e) && Intrinsics.a(this.f27293f, model.f27293f) && Intrinsics.a(this.f27294g, model.f27294g) && Intrinsics.a(this.f27295h, model.f27295h) && Intrinsics.a(this.f27296i, model.f27296i) && Intrinsics.a(this.f27297j, model.f27297j) && Intrinsics.a(this.f27298k, model.f27298k);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f27298k.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((m().hashCode() * 31) + i0.a.a(this.f27289b)) * 31;
            Text text = this.f27290c;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            List<ChipModel> list = this.f27291d;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            Text text2 = this.f27292e;
            int hashCode4 = (hashCode3 + (text2 == null ? 0 : text2.hashCode())) * 31;
            Text text3 = this.f27293f;
            int hashCode5 = (hashCode4 + (text3 == null ? 0 : text3.hashCode())) * 31;
            Text text4 = this.f27294g;
            int hashCode6 = (hashCode5 + (text4 == null ? 0 : text4.hashCode())) * 31;
            Text text5 = this.f27295h;
            int hashCode7 = (hashCode6 + (text5 == null ? 0 : text5.hashCode())) * 31;
            List<ConditionModel> list2 = this.f27296i;
            int hashCode8 = (hashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
            Text text6 = this.f27297j;
            return ((hashCode8 + (text6 != null ? text6.hashCode() : 0)) * 31) + this.f27298k.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f27298k.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f27298k.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f27298k.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f27288a;
        }

        public final long n() {
            return this.f27289b;
        }

        public final Text o() {
            return this.f27293f;
        }

        public final List<ChipModel> p() {
            return this.f27291d;
        }

        public final List<ConditionModel> q() {
            return this.f27296i;
        }

        public final Text r() {
            return this.f27290c;
        }

        public final Text s() {
            return this.f27295h;
        }

        public final Text t() {
            return this.f27297j;
        }

        public String toString() {
            String m8 = m();
            long j8 = this.f27289b;
            Text text = this.f27290c;
            List<ChipModel> list = this.f27291d;
            Text text2 = this.f27292e;
            Text text3 = this.f27293f;
            Text text4 = this.f27294g;
            Text text5 = this.f27295h;
            List<ConditionModel> list2 = this.f27296i;
            Text text6 = this.f27297j;
            DividerModel dividerModel = this.f27298k;
            return "Model(listId=" + m8 + ", campaignId=" + j8 + ", date=" + text + ", chips=" + list + ", title=" + text2 + ", category=" + text3 + ", location=" + text4 + ", description=" + text5 + ", conditions=" + list2 + ", info=" + text6 + ", divider=" + dividerModel + ")";
        }

        public final Text u() {
            return this.f27294g;
        }

        public final Text v() {
            return this.f27292e;
        }
    }

    /* compiled from: CampaignDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f27299u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f27300v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f27300v = new LinkedHashMap();
            this.f27299u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f27300v;
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
            return this.f27299u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CampaignDelegate(Function1<? super Model, Unit> onItemClicked) {
        Intrinsics.f(onItemClicked, "onItemClicked");
        this.f27281b = onItemClicked;
        this.f27282c = R.layout.delegate_item_campaigns_v2_campaign;
    }

    private final void t(TextView textView, ChipModel chipModel) {
        int i8;
        if (chipModel == null) {
            ViewExtKt.d(textView, false, 0, 2, null);
            return;
        }
        ViewExtKt.d(textView, false, 0, 3, null);
        TextViewExtKt.h(textView, chipModel.c());
        ViewExtKt.b(textView, chipModel.a());
        if (chipModel.b() == null) {
            i8 = 6;
        } else {
            i8 = 8;
        }
        int c8 = Dimens.c(i8);
        textView.setPaddingRelative(c8, textView.getPaddingTop(), c8, textView.getPaddingBottom());
        Image b8 = chipModel.b();
        if (b8 != null) {
            ImageKt.d(b8, textView, Dimens.c(16), Dimens.c(16));
        }
    }

    private final void u(TextView textView, ConditionModel conditionModel) {
        if (conditionModel == null) {
            ViewExtKt.d(textView, false, 0, 2, null);
            return;
        }
        ViewExtKt.d(textView, false, 0, 3, null);
        TextViewExtKt.h(textView, conditionModel.b());
        if (conditionModel.a()) {
            ViewExtKt.b(textView, new Color.Attr(R.attr.dynamicGreen03));
            TextViewExtKt.a(textView, new Color.Attr(R.attr.linkPrimary));
            TextViewExtKt.d(textView, R.drawable.ic_check_16dp);
            return;
        }
        ViewExtKt.b(textView, new Color.Attr(R.attr.dynamicNeutral01));
        TextViewExtKt.d(textView, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(CampaignDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f27281b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f27282c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_campaigns_v2_campaign, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…_campaign, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void g(ViewHolder holder, final Model model) {
        ChipModel chipModel;
        ChipModel chipModel2;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        ConditionModel conditionModel;
        ConditionModel conditionModel2;
        ConditionModel conditionModel3;
        Object Z;
        Object Z2;
        Object Z3;
        Object Z4;
        Object Z5;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextView textView = (TextView) holder.O(R.id.dateText);
        Intrinsics.e(textView, "holder.dateText");
        TextViewExtKt.h(textView, model.r());
        TextView textView2 = (TextView) holder.O(R.id.badge1Text);
        Intrinsics.e(textView2, "holder.badge1Text");
        List<ChipModel> p8 = model.p();
        if (p8 != null) {
            Z5 = CollectionsKt___CollectionsKt.Z(p8, 0);
            chipModel = (ChipModel) Z5;
        } else {
            chipModel = null;
        }
        t(textView2, chipModel);
        TextView textView3 = (TextView) holder.O(R.id.badge2Text);
        Intrinsics.e(textView3, "holder.badge2Text");
        List<ChipModel> p9 = model.p();
        boolean z12 = true;
        if (p9 != null) {
            Z4 = CollectionsKt___CollectionsKt.Z(p9, 1);
            chipModel2 = (ChipModel) Z4;
        } else {
            chipModel2 = null;
        }
        t(textView3, chipModel2);
        int i8 = R.id.gc;
        TextView textView4 = (TextView) holder.O(i8);
        Intrinsics.e(textView4, "holder.titleText");
        if (model.v() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(textView4, z7, 0, 2, null);
        TextView textView5 = (TextView) holder.O(i8);
        Intrinsics.e(textView5, "holder.titleText");
        TextViewExtKt.h(textView5, model.v());
        Group group = (Group) holder.O(R.id.categoriesGroup);
        Intrinsics.e(group, "holder.categoriesGroup");
        if (model.o() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.d(group, z8, 0, 2, null);
        TextView textView6 = (TextView) holder.O(R.id.categoryText);
        Intrinsics.e(textView6, "holder.categoryText");
        TextViewExtKt.h(textView6, model.o());
        ImageView imageView = (ImageView) holder.O(R.id.categoryLocationDivider);
        Intrinsics.e(imageView, "holder.categoryLocationDivider");
        if (model.o() != null && model.u() != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        ViewExtKt.d(imageView, z9, 0, 2, null);
        Group group2 = (Group) holder.O(R.id.locationsGroup);
        Intrinsics.e(group2, "holder.locationsGroup");
        if (model.u() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ViewExtKt.d(group2, z10, 0, 2, null);
        TextView textView7 = (TextView) holder.O(R.id.locationText);
        Intrinsics.e(textView7, "holder.locationText");
        TextViewExtKt.h(textView7, model.u());
        int i9 = R.id.f19834o3;
        TextView textView8 = (TextView) holder.O(i9);
        Intrinsics.e(textView8, "holder.descriptionText");
        if (model.s() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        ViewExtKt.d(textView8, z11, 0, 2, null);
        TextView textView9 = (TextView) holder.O(i9);
        Intrinsics.e(textView9, "holder.descriptionText");
        TextViewExtKt.h(textView9, model.s());
        TextView textView10 = (TextView) holder.O(R.id.bonus1Text);
        Intrinsics.e(textView10, "holder.bonus1Text");
        List<ConditionModel> q8 = model.q();
        if (q8 != null) {
            Z3 = CollectionsKt___CollectionsKt.Z(q8, 0);
            conditionModel = (ConditionModel) Z3;
        } else {
            conditionModel = null;
        }
        u(textView10, conditionModel);
        TextView textView11 = (TextView) holder.O(R.id.bonus2Text);
        Intrinsics.e(textView11, "holder.bonus2Text");
        List<ConditionModel> q9 = model.q();
        if (q9 != null) {
            Z2 = CollectionsKt___CollectionsKt.Z(q9, 1);
            conditionModel2 = (ConditionModel) Z2;
        } else {
            conditionModel2 = null;
        }
        u(textView11, conditionModel2);
        TextView textView12 = (TextView) holder.O(R.id.bonus3Text);
        Intrinsics.e(textView12, "holder.bonus3Text");
        List<ConditionModel> q10 = model.q();
        if (q10 != null) {
            Z = CollectionsKt___CollectionsKt.Z(q10, 2);
            conditionModel3 = (ConditionModel) Z;
        } else {
            conditionModel3 = null;
        }
        u(textView12, conditionModel3);
        int i10 = R.id.infoText;
        TextView textView13 = (TextView) holder.O(i10);
        Intrinsics.e(textView13, "holder.infoText");
        if (model.t() == null) {
            z12 = false;
        }
        ViewExtKt.d(textView13, z12, 0, 2, null);
        TextView textView14 = (TextView) holder.O(i10);
        Intrinsics.e(textView14, "holder.infoText");
        TextViewExtKt.h(textView14, model.t());
        holder.O(R.id.backView).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CampaignDelegate.w(CampaignDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: x */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
