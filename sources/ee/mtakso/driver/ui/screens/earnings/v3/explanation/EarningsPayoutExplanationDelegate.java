package ee.mtakso.driver.ui.screens.earnings.v3.explanation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsPayoutExplanationDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsPayoutExplanationDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f29062b = R.layout.delegate_item_earnings_explanation;

    /* compiled from: EarningsPayoutExplanationDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f29063a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f29064b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f29065c;

        /* renamed from: d  reason: collision with root package name */
        private final DividerModel f29066d;

        public Model(String listId, Text number, Text text, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(number, "number");
            Intrinsics.f(text, "text");
            Intrinsics.f(divider, "divider");
            this.f29063a = listId;
            this.f29064b = number;
            this.f29065c = text;
            this.f29066d = divider;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f29066d.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f29066d.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f29064b, model.f29064b) && Intrinsics.a(this.f29065c, model.f29065c) && Intrinsics.a(this.f29066d, model.f29066d);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f29066d.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (((((m().hashCode() * 31) + this.f29064b.hashCode()) * 31) + this.f29065c.hashCode()) * 31) + this.f29066d.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f29066d.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f29066d.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f29066d.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f29063a;
        }

        public final Text n() {
            return this.f29064b;
        }

        public final Text o() {
            return this.f29065c;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f29064b;
            Text text2 = this.f29065c;
            DividerModel dividerModel = this.f29066d;
            return "Model(listId=" + m8 + ", number=" + text + ", text=" + text2 + ", divider=" + dividerModel + ")";
        }
    }

    /* compiled from: EarningsPayoutExplanationDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f29067u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f29068v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.f(view, "view");
            TextView textView = (TextView) view.findViewById(R.id.number);
            Intrinsics.d(textView, "null cannot be cast to non-null type android.widget.TextView");
            this.f29067u = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.Hb);
            Intrinsics.d(textView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f29068v = textView2;
        }

        public final TextView O() {
            return this.f29067u;
        }

        public final TextView P() {
            return this.f29068v;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f29062b;
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
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_explanation, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…planation, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.f7332a.getContext();
        TextView O = holder.O();
        Text n8 = model.n();
        Intrinsics.e(context, "context");
        O.setText(TextKt.a(n8, context));
        holder.P().setText(TextKt.a(model.o(), context));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
