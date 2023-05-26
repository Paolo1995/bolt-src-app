package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Dimens;
import eu.bolt.kalev.Kalev;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBreakdownPayoutStubDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsBreakdownPayoutStubDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f28934b = R.layout.delegate_item_earnings_breakdown_payout_stub;

    /* compiled from: EarningsBreakdownPayoutStubDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f28935a;

        /* renamed from: b  reason: collision with root package name */
        private final int f28936b;

        public Model(String listId, int i8) {
            Intrinsics.f(listId, "listId");
            this.f28935a = listId;
            this.f28936b = i8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && this.f28936b == model.f28936b;
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (m().hashCode() * 31) + this.f28936b;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f28935a;
        }

        public final int n() {
            return this.f28936b;
        }

        public String toString() {
            String m8 = m();
            int i8 = this.f28936b;
            return "Model(listId=" + m8 + ", count=" + i8 + ")";
        }
    }

    /* compiled from: EarningsBreakdownPayoutStubDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f28937u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.f(view, "view");
            View findViewById = this.f7332a.findViewById(R.id.S2);
            Intrinsics.d(findViewById, "null cannot be cast to non-null type android.view.View");
            this.f28937u = findViewById;
        }

        public final View O() {
            return this.f28937u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f28934b;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        return model instanceof Model;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        int n8 = model.n();
        Kalev.b("onBindDelegate " + n8);
        View O = holder.O();
        ViewGroup.LayoutParams layoutParams = O.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = model.n() * (Dimens.c(8) + Dimens.a(24));
            O.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_breakdown_payout_stub, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…yout_stub, parent, false)");
        return new ViewHolder(inflate);
    }
}
