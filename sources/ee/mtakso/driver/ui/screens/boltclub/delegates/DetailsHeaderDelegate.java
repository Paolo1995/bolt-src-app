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
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetailsHeaderDelegate.kt */
/* loaded from: classes3.dex */
public final class DetailsHeaderDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f27194b = R.layout.item_offer_details_header;

    /* compiled from: DetailsHeaderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f27195a;

        /* renamed from: b  reason: collision with root package name */
        private final OfferModel f27196b;

        public Model(String listId, OfferModel offerModel) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(offerModel, "offerModel");
            this.f27195a = listId;
            this.f27196b = offerModel;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f27196b, model.f27196b);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (m().hashCode() * 31) + this.f27196b.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f27195a;
        }

        public final OfferModel n() {
            return this.f27196b;
        }

        public String toString() {
            String m8 = m();
            OfferModel offerModel = this.f27196b;
            return "Model(listId=" + m8 + ", offerModel=" + offerModel + ")";
        }
    }

    /* compiled from: DetailsHeaderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.f(view, "view");
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f27194b;
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
        View v7 = inflater.inflate(R.layout.item_offer_details_header, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
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
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
