package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignNoteDelegate.kt */
/* loaded from: classes3.dex */
public final class CampaignNoteDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f27479b = R.layout.delegate_item_campaigns_v2_note;

    /* compiled from: CampaignNoteDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f27480a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f27481b;

        public Model(String listId, Text text) {
            Intrinsics.f(listId, "listId");
            this.f27480a = listId;
            this.f27481b = text;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f27481b, model.f27481b);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f27481b;
            return hashCode + (text == null ? 0 : text.hashCode());
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f27480a;
        }

        public final Text n() {
            return this.f27481b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f27481b;
            return "Model(listId=" + m8 + ", text=" + text + ")";
        }
    }

    /* compiled from: CampaignNoteDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f27482u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f27483v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f27483v = new LinkedHashMap();
            this.f27482u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f27483v;
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
            return this.f27482u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f27479b;
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
        View inflate = inflater.inflate(R.layout.delegate_item_campaigns_v2_note, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…s_v2_note, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        int i8 = R.id.Hb;
        TextView textView = (TextView) holder.O(i8);
        Intrinsics.e(textView, "holder.text");
        TextViewExtKt.h(textView, model.n());
        ((TextView) holder.O(i8)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
