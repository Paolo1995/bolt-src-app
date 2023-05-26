package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubtitleItemDelegate.kt */
/* loaded from: classes5.dex */
public final class SubtitleItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f35063b = R$layout.delegate_item_subtitle;

    /* compiled from: SubtitleItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f35068u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f35069v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f35068u = containerView;
            this.f35069v = (TextView) containerView.findViewById(R$id.f34601p0);
        }

        public final TextView O() {
            return this.f35069v;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35063b;
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
        View inflate = inflater.inflate(R$layout.delegate_item_subtitle, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…_subtitle, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextView O = holder.O();
        Intrinsics.e(O, "holder.subtitle");
        TextViewExtKt.h(O, model.n());
        TextView O2 = holder.O();
        Intrinsics.e(O2, "holder.subtitle");
        TextViewExtKt.i(O2, model.o());
        TextView O3 = holder.O();
        Intrinsics.e(O3, "holder.subtitle");
        ViewExtKt.e(O3, Integer.valueOf(model.p().b()), Integer.valueOf(model.p().d()), Integer.valueOf(model.p().c()), Integer.valueOf(model.p().a()));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: SubtitleItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35064a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f35065b;

        /* renamed from: c  reason: collision with root package name */
        private final Color f35066c;

        /* renamed from: d  reason: collision with root package name */
        private final Margins f35067d;

        public /* synthetic */ Model(String str, Text text, Color color, Margins margins, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, text, (i8 & 4) != 0 ? new Color.Attr(R$attr.f34580k) : color, (i8 & 8) != 0 ? new Margins(Dimens.c(16), Dimens.c(16), Dimens.c(16), Dimens.c(8)) : margins);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35065b, model.f35065b) && Intrinsics.a(this.f35066c, model.f35066c) && Intrinsics.a(this.f35067d, model.f35067d);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (((((m().hashCode() * 31) + this.f35065b.hashCode()) * 31) + this.f35066c.hashCode()) * 31) + this.f35067d.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35064a;
        }

        public final Text n() {
            return this.f35065b;
        }

        public final Color o() {
            return this.f35066c;
        }

        public final Margins p() {
            return this.f35067d;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f35065b;
            Color color = this.f35066c;
            Margins margins = this.f35067d;
            return "Model(listId=" + m8 + ", text=" + text + ", textColor=" + color + ", textMargins=" + margins + ")";
        }

        public Model(String listId, Text text, Color textColor, Margins textMargins) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(text, "text");
            Intrinsics.f(textColor, "textColor");
            Intrinsics.f(textMargins, "textMargins");
            this.f35064a = listId;
            this.f35065b = text;
            this.f35066c = textColor;
            this.f35067d = textMargins;
        }
    }
}
