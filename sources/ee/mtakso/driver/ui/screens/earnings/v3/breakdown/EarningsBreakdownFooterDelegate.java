package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBreakdownFooterDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsBreakdownFooterDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f28882b = R.layout.delegate_item_earnings_breakdown_footer;

    /* compiled from: EarningsBreakdownFooterDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f28888u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f28889v;

        /* renamed from: w  reason: collision with root package name */
        private final TextView f28890w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.f(view, "view");
            TextView textView = (TextView) view.findViewById(R.id.footerPrimaryText);
            Intrinsics.d(textView, "null cannot be cast to non-null type android.widget.TextView");
            this.f28888u = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.footerSecondaryText);
            Intrinsics.d(textView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f28889v = textView2;
            TextView textView3 = (TextView) view.findViewById(R.id.footerSubtitle);
            Intrinsics.d(textView3, "null cannot be cast to non-null type android.widget.TextView");
            this.f28890w = textView3;
        }

        public final TextView O() {
            return this.f28888u;
        }

        public final TextView P() {
            return this.f28889v;
        }

        public final TextView Q() {
            return this.f28890w;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f28882b;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        return model instanceof Model;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.f7332a.getContext();
        TextView O = holder.O();
        Text n8 = model.n();
        CharSequence charSequence3 = null;
        if (n8 != null) {
            Intrinsics.e(context, "context");
            charSequence = TextKt.a(n8, context);
        } else {
            charSequence = null;
        }
        O.setText(charSequence);
        TextView P = holder.P();
        Text o8 = model.o();
        if (o8 != null) {
            Intrinsics.e(context, "context");
            charSequence2 = TextKt.a(o8, context);
        } else {
            charSequence2 = null;
        }
        P.setText(charSequence2);
        TextView Q = holder.Q();
        Text p8 = model.p();
        if (p8 != null) {
            Intrinsics.e(context, "context");
            charSequence3 = TextKt.a(p8, context);
        }
        Q.setText(charSequence3);
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
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_breakdown_footer, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(\n      …      false\n            )");
        return new ViewHolder(inflate);
    }

    /* compiled from: EarningsBreakdownFooterDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f28883a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f28884b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f28885c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f28886d;

        /* renamed from: e  reason: collision with root package name */
        private final Divider f28887e;

        public /* synthetic */ Model(String str, Text text, Text text2, Text text3, Divider divider, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, text, text2, text3, (i8 & 16) != 0 ? new Divider(false, false, false, null, new Color.Attr(R.attr.backTertiary), Float.valueOf(Dimens.b(8.0f)), 15, null) : divider);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f28887e.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f28887e.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f28884b, model.f28884b) && Intrinsics.a(this.f28885c, model.f28885c) && Intrinsics.a(this.f28886d, model.f28886d) && Intrinsics.a(this.f28887e, model.f28887e);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f28887e.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f28884b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Text text2 = this.f28885c;
            int hashCode3 = (hashCode2 + (text2 == null ? 0 : text2.hashCode())) * 31;
            Text text3 = this.f28886d;
            return ((hashCode3 + (text3 != null ? text3.hashCode() : 0)) * 31) + this.f28887e.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f28887e.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f28887e.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f28887e.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f28883a;
        }

        public final Text n() {
            return this.f28884b;
        }

        public final Text o() {
            return this.f28885c;
        }

        public final Text p() {
            return this.f28886d;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f28884b;
            Text text2 = this.f28885c;
            Text text3 = this.f28886d;
            Divider divider = this.f28887e;
            return "Model(listId=" + m8 + ", primaryText=" + text + ", secondaryText=" + text2 + ", subtitle=" + text3 + ", divider=" + divider + ")";
        }

        public Model(String listId, Text text, Text text2, Text text3, Divider divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(divider, "divider");
            this.f28883a = listId;
            this.f28884b = text;
            this.f28885c = text2;
            this.f28886d = text3;
            this.f28887e = divider;
        }
    }
}
