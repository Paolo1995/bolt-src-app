package ee.mtakso.driver.ui.screens.boltclub.delegates;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.boltclub.delegatemodel.OfferModel;
import ee.mtakso.driver.ui.screens.boltclub.delegates.OfferListDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OfferListDelegate.kt */
/* loaded from: classes3.dex */
public final class OfferListDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function2<Long, String, Unit> f27197b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27198c;

    /* compiled from: OfferListDelegate.kt */
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        final /* synthetic */ OfferListDelegate f27203u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(OfferListDelegate offerListDelegate, View view) {
            super(view);
            Intrinsics.f(view, "view");
            this.f27203u = offerListDelegate;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfferListDelegate(Function2<? super Long, ? super String, Unit> onItemClickListener) {
        Intrinsics.f(onItemClickListener, "onItemClickListener");
        this.f27197b = onItemClickListener;
        this.f27198c = R.layout.item_offer_groups_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(OfferListDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f27197b.s(Long.valueOf(model.n().c()), model.n().e());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f27198c;
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
        View v7 = inflater.inflate(R.layout.item_offer_groups_list, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(this, v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        OfferModel n8 = model.n();
        Context context = holder.f7332a.getContext();
        Intrinsics.e(context, "holder.itemView.context");
        ColorDrawable colorDrawable = new ColorDrawable(ContextUtilsKt.b(context, R.attr.dynamicNeutral01));
        Image b8 = n8.b();
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.f7332a.findViewById(R.id.logoIcon);
        Intrinsics.e(appCompatImageView, "holder.itemView.logoIcon");
        ImageKt.a(b8, appCompatImageView, colorDrawable);
        String a8 = n8.a();
        if (a8 != null && a8.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            View view = holder.f7332a;
            int i8 = R.id.discountPercent;
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(i8);
            Intrinsics.e(appCompatTextView, "holder.itemView.discountPercent");
            ViewExtKt.d(appCompatTextView, false, 0, 3, null);
            ((AppCompatTextView) holder.f7332a.findViewById(i8)).setText(n8.a());
        } else {
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) holder.f7332a.findViewById(R.id.discountPercent);
            Intrinsics.e(appCompatTextView2, "holder.itemView.discountPercent");
            ViewExtKt.d(appCompatTextView2, false, 0, 2, null);
        }
        ((AppCompatTextView) holder.f7332a.findViewById(R.id.vendorName)).setText(n8.e());
        ((AppCompatTextView) holder.f7332a.findViewById(R.id.shortDescription)).setText(n8.d());
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: w2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OfferListDelegate.u(OfferListDelegate.this, model, view2);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: OfferListDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f27199a;

        /* renamed from: b  reason: collision with root package name */
        private final OfferModel f27200b;

        /* renamed from: c  reason: collision with root package name */
        private final DividerModel f27201c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f27202d;

        public /* synthetic */ Model(String str, OfferModel offerModel, DividerModel dividerModel, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, offerModel, (i8 & 4) != 0 ? new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null) : dividerModel, (i8 & 8) != 0 ? true : z7);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f27201c.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f27202d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f27200b, model.f27200b) && Intrinsics.a(this.f27201c, model.f27201c) && e() == model.e();
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f27201c.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((m().hashCode() * 31) + this.f27200b.hashCode()) * 31) + this.f27201c.hashCode()) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f27201c.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f27201c.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f27201c.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f27199a;
        }

        public final OfferModel n() {
            return this.f27200b;
        }

        public String toString() {
            String m8 = m();
            OfferModel offerModel = this.f27200b;
            DividerModel dividerModel = this.f27201c;
            boolean e8 = e();
            return "Model(listId=" + m8 + ", offerModel=" + offerModel + ", divider=" + dividerModel + ", isDividerEnabled=" + e8 + ")";
        }

        public Model(String listId, OfferModel offerModel, DividerModel divider, boolean z7) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(offerModel, "offerModel");
            Intrinsics.f(divider, "divider");
            this.f27199a = listId;
            this.f27200b = offerModel;
            this.f27201c = divider;
            this.f27202d = z7;
        }
    }
}
