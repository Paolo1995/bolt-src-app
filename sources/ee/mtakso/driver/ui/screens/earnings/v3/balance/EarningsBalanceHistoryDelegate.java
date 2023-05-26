package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceHistoryDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBalanceHistoryDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsBalanceHistoryDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<String, Unit> f28807b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28808c;

    /* compiled from: EarningsBalanceHistoryDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f28809a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f28810b;

        /* renamed from: c  reason: collision with root package name */
        private final Color f28811c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f28812d;

        /* renamed from: e  reason: collision with root package name */
        private final Color f28813e;

        /* renamed from: f  reason: collision with root package name */
        private final Text f28814f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f28815g;

        /* renamed from: h  reason: collision with root package name */
        private final Text f28816h;

        /* renamed from: i  reason: collision with root package name */
        private final Color f28817i;

        /* renamed from: j  reason: collision with root package name */
        private final String f28818j;

        /* renamed from: k  reason: collision with root package name */
        private final DividerModel f28819k;

        public Model(String listId, Text title, Color titleColor, Text text, Color color, Text text2, Color color2, Text text3, Color color3, String str, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(titleColor, "titleColor");
            Intrinsics.f(divider, "divider");
            this.f28809a = listId;
            this.f28810b = title;
            this.f28811c = titleColor;
            this.f28812d = text;
            this.f28813e = color;
            this.f28814f = text2;
            this.f28815g = color2;
            this.f28816h = text3;
            this.f28817i = color3;
            this.f28818j = str;
            this.f28819k = divider;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f28819k.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f28819k.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f28810b, model.f28810b) && Intrinsics.a(this.f28811c, model.f28811c) && Intrinsics.a(this.f28812d, model.f28812d) && Intrinsics.a(this.f28813e, model.f28813e) && Intrinsics.a(this.f28814f, model.f28814f) && Intrinsics.a(this.f28815g, model.f28815g) && Intrinsics.a(this.f28816h, model.f28816h) && Intrinsics.a(this.f28817i, model.f28817i) && Intrinsics.a(this.f28818j, model.f28818j) && Intrinsics.a(this.f28819k, model.f28819k);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f28819k.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((m().hashCode() * 31) + this.f28810b.hashCode()) * 31) + this.f28811c.hashCode()) * 31;
            Text text = this.f28812d;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Color color = this.f28813e;
            int hashCode3 = (hashCode2 + (color == null ? 0 : color.hashCode())) * 31;
            Text text2 = this.f28814f;
            int hashCode4 = (hashCode3 + (text2 == null ? 0 : text2.hashCode())) * 31;
            Color color2 = this.f28815g;
            int hashCode5 = (hashCode4 + (color2 == null ? 0 : color2.hashCode())) * 31;
            Text text3 = this.f28816h;
            int hashCode6 = (hashCode5 + (text3 == null ? 0 : text3.hashCode())) * 31;
            Color color3 = this.f28817i;
            int hashCode7 = (hashCode6 + (color3 == null ? 0 : color3.hashCode())) * 31;
            String str = this.f28818j;
            return ((hashCode7 + (str != null ? str.hashCode() : 0)) * 31) + this.f28819k.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f28819k.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f28819k.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f28819k.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f28809a;
        }

        public final String n() {
            return this.f28818j;
        }

        public final Text o() {
            return this.f28812d;
        }

        public final Color p() {
            return this.f28813e;
        }

        public final Text q() {
            return this.f28810b;
        }

        public final Color r() {
            return this.f28811c;
        }

        public final Text s() {
            return this.f28816h;
        }

        public final Color t() {
            return this.f28817i;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f28810b;
            Color color = this.f28811c;
            Text text2 = this.f28812d;
            Color color2 = this.f28813e;
            Text text3 = this.f28814f;
            Color color3 = this.f28815g;
            Text text4 = this.f28816h;
            Color color4 = this.f28817i;
            String str = this.f28818j;
            DividerModel dividerModel = this.f28819k;
            return "Model(listId=" + m8 + ", title=" + text + ", titleColor=" + color + ", subtitle=" + text2 + ", subtitleColor=" + color2 + ", trailingTitle=" + text3 + ", trailingTitleColor=" + color3 + ", trailingSubtitle=" + text4 + ", trailingSubtitleColor=" + color4 + ", payload=" + str + ", divider=" + dividerModel + ")";
        }

        public final Text u() {
            return this.f28814f;
        }

        public final Color v() {
            return this.f28815g;
        }
    }

    /* compiled from: EarningsBalanceHistoryDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f28820u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f28821v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f28821v = new LinkedHashMap();
            this.f28820u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f28821v;
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
            return this.f28820u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EarningsBalanceHistoryDelegate(Function1<? super String, Unit> onPayloadClick) {
        Intrinsics.f(onPayloadClick, "onPayloadClick");
        this.f28807b = onPayloadClick;
        this.f28808c = R.layout.delegate_item_earnings_balance_history;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Model model, EarningsBalanceHistoryDelegate this$0, View view) {
        Intrinsics.f(model, "$model");
        Intrinsics.f(this$0, "this$0");
        String n8 = model.n();
        if (n8 != null) {
            this$0.f28807b.invoke(n8);
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f28808c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_balance_history, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(\n      …      false\n            )");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        boolean z7;
        CharSequence charSequence;
        ColorStateList colorStateList;
        boolean z8;
        CharSequence charSequence2;
        ColorStateList colorStateList2;
        boolean z9;
        CharSequence charSequence3;
        boolean z10;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.f7332a.getContext();
        int i8 = R.id.cc;
        Text q8 = model.q();
        Intrinsics.e(context, "context");
        ((TextView) holder.O(i8)).setText(TextKt.a(q8, context));
        ((TextView) holder.O(i8)).setTextColor(ColorKt.b(model.r(), context));
        int i9 = R.id.tb;
        TextView textView = (TextView) holder.O(i9);
        Intrinsics.e(textView, "holder.subtitle");
        boolean z11 = true;
        if (model.o() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ColorStateList colorStateList3 = null;
        ViewExtKt.d(textView, z7, 0, 2, null);
        TextView textView2 = (TextView) holder.O(i9);
        Text o8 = model.o();
        if (o8 != null) {
            charSequence = TextKt.a(o8, context);
        } else {
            charSequence = null;
        }
        textView2.setText(charSequence);
        TextView textView3 = (TextView) holder.O(i9);
        Color p8 = model.p();
        if (p8 != null) {
            colorStateList = ColorKt.b(p8, context);
        } else {
            colorStateList = null;
        }
        textView3.setTextColor(colorStateList);
        int i10 = R.id.trailingTitle;
        TextView textView4 = (TextView) holder.O(i10);
        Intrinsics.e(textView4, "holder.trailingTitle");
        if (model.u() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.d(textView4, z8, 0, 2, null);
        TextView textView5 = (TextView) holder.O(i10);
        Text u7 = model.u();
        if (u7 != null) {
            charSequence2 = TextKt.a(u7, context);
        } else {
            charSequence2 = null;
        }
        textView5.setText(charSequence2);
        TextView textView6 = (TextView) holder.O(i10);
        Color v7 = model.v();
        if (v7 != null) {
            colorStateList2 = ColorKt.b(v7, context);
        } else {
            colorStateList2 = null;
        }
        textView6.setTextColor(colorStateList2);
        int i11 = R.id.trailingSubtitle;
        TextView textView7 = (TextView) holder.O(i11);
        Intrinsics.e(textView7, "holder.trailingSubtitle");
        if (model.s() != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        ViewExtKt.d(textView7, z9, 0, 2, null);
        TextView textView8 = (TextView) holder.O(i11);
        Text s7 = model.s();
        if (s7 != null) {
            charSequence3 = TextKt.a(s7, context);
        } else {
            charSequence3 = null;
        }
        textView8.setText(charSequence3);
        TextView textView9 = (TextView) holder.O(i11);
        Color t7 = model.t();
        if (t7 != null) {
            colorStateList3 = ColorKt.b(t7, context);
        }
        textView9.setTextColor(colorStateList3);
        int i12 = R.id.f19835r2;
        holder.O(i12).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsBalanceHistoryDelegate.u(EarningsBalanceHistoryDelegate.Model.this, this, view);
            }
        });
        View O = holder.O(i12);
        if (model.n() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        O.setClickable(z10);
        View O2 = holder.O(i12);
        if (model.n() == null) {
            z11 = false;
        }
        O2.setFocusable(z11);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
