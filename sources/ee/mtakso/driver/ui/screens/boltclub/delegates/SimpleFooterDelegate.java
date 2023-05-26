package ee.mtakso.driver.ui.screens.boltclub.delegates;

import android.text.method.LinkMovementMethod;
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
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleFooterDelegate.kt */
/* loaded from: classes3.dex */
public final class SimpleFooterDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f27204b = R.layout.item_offer_details_footer;

    /* compiled from: SimpleFooterDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f27213u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.f(view, "view");
            TextView textView = (TextView) view.findViewById(R.id.footer);
            Intrinsics.e(textView, "view.footer");
            this.f27213u = textView;
        }

        public final TextView O() {
            return this.f27213u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f27204b;
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
        View v7 = inflater.inflate(R.layout.item_offer_details_footer, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Text r7 = model.r();
        if (r7 instanceof Text.Resource) {
            holder.O().setText(((Text.Resource) model.r()).b());
        } else if (r7 instanceof Text.Value) {
            holder.O().setText(((Text.Value) model.r()).a());
        }
        holder.O().setMovementMethod(LinkMovementMethod.getInstance());
        TextView O = holder.O();
        int p8 = model.p();
        int q8 = model.q();
        ViewExtKt.g(O, Integer.valueOf(model.o()), Integer.valueOf(q8), Integer.valueOf(p8), Integer.valueOf(model.n()));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: SimpleFooterDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f27205a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f27206b;

        /* renamed from: c  reason: collision with root package name */
        private final int f27207c;

        /* renamed from: d  reason: collision with root package name */
        private final int f27208d;

        /* renamed from: e  reason: collision with root package name */
        private final int f27209e;

        /* renamed from: f  reason: collision with root package name */
        private final int f27210f;

        /* renamed from: g  reason: collision with root package name */
        private final DividerModel f27211g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f27212h;

        public /* synthetic */ Model(String str, Text text, int i8, int i9, int i10, int i11, DividerModel dividerModel, boolean z7, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, text, (i12 & 4) != 0 ? Dimens.c(24) : i8, (i12 & 8) != 0 ? Dimens.c(24) : i9, (i12 & 16) != 0 ? Dimens.c(16) : i10, (i12 & 32) != 0 ? Dimens.c(16) : i11, (i12 & 64) != 0 ? new Divider(false, true, true, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), Float.valueOf(Dimens.b(8.0f)), 1, null) : dividerModel, (i12 & 128) != 0 ? true : z7);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f27211g.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f27212h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f27206b, model.f27206b) && this.f27207c == model.f27207c && this.f27208d == model.f27208d && this.f27209e == model.f27209e && this.f27210f == model.f27210f && Intrinsics.a(this.f27211g, model.f27211g) && e() == model.e();
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f27211g.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f27206b;
            int hashCode2 = (((((((((((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f27207c) * 31) + this.f27208d) * 31) + this.f27209e) * 31) + this.f27210f) * 31) + this.f27211g.hashCode()) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            return hashCode2 + i8;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f27211g.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f27211g.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f27211g.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f27205a;
        }

        public final int n() {
            return this.f27210f;
        }

        public final int o() {
            return this.f27208d;
        }

        public final int p() {
            return this.f27207c;
        }

        public final int q() {
            return this.f27209e;
        }

        public final Text r() {
            return this.f27206b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f27206b;
            int i8 = this.f27207c;
            int i9 = this.f27208d;
            int i10 = this.f27209e;
            int i11 = this.f27210f;
            DividerModel dividerModel = this.f27211g;
            boolean e8 = e();
            return "Model(listId=" + m8 + ", text=" + text + ", paddingStart=" + i8 + ", paddingEnd=" + i9 + ", paddingTop=" + i10 + ", paddingBottom=" + i11 + ", divider=" + dividerModel + ", isDividerEnabled=" + e8 + ")";
        }

        public Model(String listId, Text text, int i8, int i9, int i10, int i11, DividerModel divider, boolean z7) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(divider, "divider");
            this.f27205a = listId;
            this.f27206b = text;
            this.f27207c = i8;
            this.f27208d = i9;
            this.f27209e = i10;
            this.f27210f = i11;
            this.f27211g = divider;
            this.f27212h = z7;
        }
    }
}
