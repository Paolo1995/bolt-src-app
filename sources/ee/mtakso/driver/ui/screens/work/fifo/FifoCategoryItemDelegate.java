package ee.mtakso.driver.ui.screens.work.fifo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoCategoryItemDelegate.kt */
/* loaded from: classes5.dex */
public final class FifoCategoryItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f34064b = R.layout.delegate_item_fifo_category;

    /* compiled from: FifoCategoryItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f34072u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f34073v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f34073v = new LinkedHashMap();
            this.f34072u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f34073v;
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
            return this.f34072u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34064b;
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
        View inflate = inflater.inflate(R.layout.delegate_item_fifo_category, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…_category, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        CharSequence charSequence;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.P().getContext();
        int i8 = R.id.cc;
        Text n8 = model.n();
        Intrinsics.e(context, "context");
        ((TextView) holder.O(i8)).setText(TextKt.a(n8, context));
        ((TextView) holder.O(i8)).setTextColor(ColorKt.b(model.o(), context));
        int i9 = R.id.Ec;
        TextView textView = (TextView) holder.O(i9);
        Text r7 = model.r();
        CharSequence charSequence2 = null;
        if (r7 != null) {
            charSequence = TextKt.a(r7, context);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
        ((TextView) holder.O(i9)).setTextColor(ColorKt.b(model.s(), context));
        int i10 = R.id.unit;
        TextView textView2 = (TextView) holder.O(i10);
        Text p8 = model.p();
        if (p8 != null) {
            charSequence2 = TextKt.a(p8, context);
        }
        textView2.setText(charSequence2);
        ((TextView) holder.O(i10)).setTextColor(ColorKt.b(model.q(), context));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: FifoCategoryItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34065a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f34066b;

        /* renamed from: c  reason: collision with root package name */
        private final Color f34067c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f34068d;

        /* renamed from: e  reason: collision with root package name */
        private final Color f34069e;

        /* renamed from: f  reason: collision with root package name */
        private final Text f34070f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f34071g;

        public /* synthetic */ Model(String str, Text text, Color color, Text text2, Color color2, Text text3, Color color3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, text, (i8 & 4) != 0 ? new Color.Attr(R.attr.contentPrimary) : color, text2, (i8 & 16) != 0 ? new Color.Attr(R.attr.contentPrimary) : color2, text3, (i8 & 64) != 0 ? new Color.Attr(R.attr.contentSecondary) : color3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f34066b, model.f34066b) && Intrinsics.a(this.f34067c, model.f34067c) && Intrinsics.a(this.f34068d, model.f34068d) && Intrinsics.a(this.f34069e, model.f34069e) && Intrinsics.a(this.f34070f, model.f34070f) && Intrinsics.a(this.f34071g, model.f34071g);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((m().hashCode() * 31) + this.f34066b.hashCode()) * 31) + this.f34067c.hashCode()) * 31;
            Text text = this.f34068d;
            int hashCode2 = (((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f34069e.hashCode()) * 31;
            Text text2 = this.f34070f;
            return ((hashCode2 + (text2 != null ? text2.hashCode() : 0)) * 31) + this.f34071g.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34065a;
        }

        public final Text n() {
            return this.f34066b;
        }

        public final Color o() {
            return this.f34067c;
        }

        public final Text p() {
            return this.f34070f;
        }

        public final Color q() {
            return this.f34071g;
        }

        public final Text r() {
            return this.f34068d;
        }

        public final Color s() {
            return this.f34069e;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f34066b;
            Color color = this.f34067c;
            Text text2 = this.f34068d;
            Color color2 = this.f34069e;
            Text text3 = this.f34070f;
            Color color3 = this.f34071g;
            return "Model(listId=" + m8 + ", title=" + text + ", titleColor=" + color + ", value=" + text2 + ", valueColor=" + color2 + ", unit=" + text3 + ", unitColor=" + color3 + ")";
        }

        public Model(String listId, Text title, Color titleColor, Text text, Color valueColor, Text text2, Color unitColor) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(titleColor, "titleColor");
            Intrinsics.f(valueColor, "valueColor");
            Intrinsics.f(unitColor, "unitColor");
            this.f34065a = listId;
            this.f34066b = title;
            this.f34067c = titleColor;
            this.f34068d = text;
            this.f34069e = valueColor;
            this.f34070f = text2;
            this.f34071g = unitColor;
        }
    }
}
