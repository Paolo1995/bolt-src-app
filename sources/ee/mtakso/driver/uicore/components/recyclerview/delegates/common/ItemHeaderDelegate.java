package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ItemHeaderDelegate.kt */
/* loaded from: classes5.dex */
public final class ItemHeaderDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f34985b = R$layout.delegate_header;

    /* compiled from: ItemHeaderDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f34992u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.f34604s0);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f34992u = appCompatTextView;
        }

        public final TextView O() {
            return this.f34992u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34985b;
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
        View v7 = inflater.inflate(e(), parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextView O = holder.O();
        if (model.p() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(O, z7, 0, 2, null);
        TextView O2 = holder.O();
        CharSequence p8 = model.p();
        if (p8 == null) {
            p8 = "";
        }
        O2.setText(p8);
        Integer q8 = model.q();
        if (q8 != null) {
            TextViewCompat.o(holder.O(), q8.intValue());
        }
        TextViewExtKt.i(holder.O(), model.r());
        ee.mtakso.driver.uikit.utils.ViewExtKt.a(holder.O(), model.n());
        Integer o8 = model.o();
        if (o8 != null) {
            int intValue = o8.intValue();
            TextView O3 = holder.O();
            O3.setPadding(O3.getPaddingLeft(), intValue, O3.getPaddingRight(), O3.getPaddingBottom());
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: ItemHeaderDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34986a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f34987b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f34988c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f34989d;

        /* renamed from: e  reason: collision with root package name */
        private final Color f34990e;

        /* renamed from: f  reason: collision with root package name */
        private final Integer f34991f;

        public /* synthetic */ Model(String str, CharSequence charSequence, Integer num, Color color, Color color2, Integer num2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : charSequence, (i8 & 4) != 0 ? null : num, (i8 & 8) != 0 ? null : color, (i8 & 16) != 0 ? new Color.Res(R$color.f34586k) : color2, (i8 & 32) == 0 ? num2 : null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f34987b, model.f34987b) && Intrinsics.a(this.f34988c, model.f34988c) && Intrinsics.a(this.f34989d, model.f34989d) && Intrinsics.a(this.f34990e, model.f34990e) && Intrinsics.a(this.f34991f, model.f34991f);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            CharSequence charSequence = this.f34987b;
            int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            Integer num = this.f34988c;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Color color = this.f34989d;
            int hashCode4 = (((hashCode3 + (color == null ? 0 : color.hashCode())) * 31) + this.f34990e.hashCode()) * 31;
            Integer num2 = this.f34991f;
            return hashCode4 + (num2 != null ? num2.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34986a;
        }

        public final Color n() {
            return this.f34990e;
        }

        public final Integer o() {
            return this.f34991f;
        }

        public final CharSequence p() {
            return this.f34987b;
        }

        public final Integer q() {
            return this.f34988c;
        }

        public final Color r() {
            return this.f34989d;
        }

        public String toString() {
            String m8 = m();
            CharSequence charSequence = this.f34987b;
            Integer num = this.f34988c;
            Color color = this.f34989d;
            Color color2 = this.f34990e;
            Integer num2 = this.f34991f;
            return "Model(listId=" + m8 + ", text=" + ((Object) charSequence) + ", textAppearance=" + num + ", textColor=" + color + ", backgroundColor=" + color2 + ", paddingTop=" + num2 + ")";
        }

        public Model(String listId, CharSequence charSequence, Integer num, Color color, Color backgroundColor, Integer num2) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(backgroundColor, "backgroundColor");
            this.f34986a = listId;
            this.f34987b = charSequence;
            this.f34988c = num;
            this.f34989d = color;
            this.f34990e = backgroundColor;
            this.f34991f = num2;
        }
    }
}
