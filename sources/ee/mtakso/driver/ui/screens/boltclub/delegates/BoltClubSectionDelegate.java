package ee.mtakso.driver.ui.screens.boltclub.delegates;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.boltclub.delegatemodel.SectionModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltClubSectionDelegate.kt */
/* loaded from: classes3.dex */
public final class BoltClubSectionDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f27191b = R.layout.item_offer_details_section;

    /* compiled from: BoltClubSectionDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f27192a;

        /* renamed from: b  reason: collision with root package name */
        private final SectionModel f27193b;

        public Model(String listId, SectionModel sectionModel) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(sectionModel, "sectionModel");
            this.f27192a = listId;
            this.f27193b = sectionModel;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f27193b, model.f27193b);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (m().hashCode() * 31) + this.f27193b.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f27192a;
        }

        public final SectionModel n() {
            return this.f27193b;
        }

        public String toString() {
            String m8 = m();
            SectionModel sectionModel = this.f27193b;
            return "Model(listId=" + m8 + ", sectionModel=" + sectionModel + ")";
        }
    }

    /* compiled from: BoltClubSectionDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.f(view, "view");
        }
    }

    private final void s(CharSequence charSequence, TextView textView) {
        Integer t7 = t(charSequence);
        if (t7 != null) {
            textView.setLinkTextColor(t7.intValue());
        }
    }

    private final Integer t(CharSequence charSequence) {
        Object F;
        if (!(charSequence instanceof Spannable)) {
            return null;
        }
        boolean z7 = false;
        ForegroundColorSpan[] foregroundSpan = (ForegroundColorSpan[]) ((Spannable) charSequence).getSpans(0, charSequence.length(), ForegroundColorSpan.class);
        Intrinsics.e(foregroundSpan, "foregroundSpan");
        if (foregroundSpan.length == 0) {
            z7 = true;
        }
        if (!(!z7)) {
            return null;
        }
        F = ArraysKt___ArraysKt.F(foregroundSpan);
        return Integer.valueOf(((ForegroundColorSpan) F).getForegroundColor());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f27191b;
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
        View v7 = inflater.inflate(R.layout.item_offer_details_section, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        SectionModel n8 = model.n();
        ((TextView) holder.f7332a.findViewById(R.id.sectionTitle)).setText(n8.b());
        View view = holder.f7332a;
        int i8 = R.id.f19832m3;
        ((TextView) view.findViewById(i8)).setText(n8.a());
        ((TextView) holder.f7332a.findViewById(i8)).setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence a8 = model.n().a();
        TextView textView = (TextView) holder.f7332a.findViewById(i8);
        Intrinsics.e(textView, "holder.itemView.description");
        s(a8, textView);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
