package ee.mtakso.driver.uicore.components.recyclerview.delegates.payout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.payout.PayoutDelegate;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutDelegate.kt */
/* loaded from: classes5.dex */
public final class PayoutDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f35367b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35368c;

    /* compiled from: PayoutDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35369a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f35370b;

        /* renamed from: c  reason: collision with root package name */
        private final CharSequence f35371c;

        /* renamed from: d  reason: collision with root package name */
        private final CharSequence f35372d;

        /* renamed from: e  reason: collision with root package name */
        private final Integer f35373e;

        /* renamed from: f  reason: collision with root package name */
        private final Object f35374f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f35375g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f35376h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f35377i;

        /* renamed from: j  reason: collision with root package name */
        private final Color f35378j;

        /* renamed from: k  reason: collision with root package name */
        private final Color f35379k;

        /* renamed from: l  reason: collision with root package name */
        private final Float f35380l;

        public Model(String listId, CharSequence title, CharSequence date, CharSequence amout, Integer num, Object obj, boolean z7, boolean z8, boolean z9, Color color, Color color2, Float f8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(date, "date");
            Intrinsics.f(amout, "amout");
            this.f35369a = listId;
            this.f35370b = title;
            this.f35371c = date;
            this.f35372d = amout;
            this.f35373e = num;
            this.f35374f = obj;
            this.f35375g = z7;
            this.f35376h = z8;
            this.f35377i = z9;
            this.f35378j = color;
            this.f35379k = color2;
            this.f35380l = f8;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f35378j;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f35375g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35370b, model.f35370b) && Intrinsics.a(this.f35371c, model.f35371c) && Intrinsics.a(this.f35372d, model.f35372d) && Intrinsics.a(this.f35373e, model.f35373e) && Intrinsics.a(this.f35374f, model.f35374f) && e() == model.e() && j() == model.j() && k() == model.k() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Intrinsics.a(i(), model.i());
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f35379k;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((((m().hashCode() * 31) + this.f35370b.hashCode()) * 31) + this.f35371c.hashCode()) * 31) + this.f35372d.hashCode()) * 31;
            Integer num = this.f35373e;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Object obj = this.f35374f;
            int hashCode3 = (hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            int i9 = (hashCode3 + i8) * 31;
            boolean j8 = j();
            int i10 = j8;
            if (j8) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            boolean k8 = k();
            return ((((((i11 + (k8 ? 1 : k8)) * 31) + (d() == null ? 0 : d().hashCode())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + (i() != null ? i().hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f35380l;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f35376h;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f35377i;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35369a;
        }

        public final CharSequence n() {
            return this.f35372d;
        }

        public final CharSequence o() {
            return this.f35371c;
        }

        public final Object p() {
            return this.f35374f;
        }

        public final Integer q() {
            return this.f35373e;
        }

        public final CharSequence r() {
            return this.f35370b;
        }

        public String toString() {
            String m8 = m();
            CharSequence charSequence = this.f35370b;
            CharSequence charSequence2 = this.f35371c;
            CharSequence charSequence3 = this.f35372d;
            Integer num = this.f35373e;
            Object obj = this.f35374f;
            boolean e8 = e();
            boolean j8 = j();
            boolean k8 = k();
            Color d8 = d();
            Color f8 = f();
            Float i8 = i();
            return "Model(listId=" + m8 + ", title=" + ((Object) charSequence) + ", date=" + ((Object) charSequence2) + ", amout=" + ((Object) charSequence3) + ", statusIcon=" + num + ", payload=" + obj + ", isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ")";
        }
    }

    /* compiled from: PayoutDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f35381u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f35382v;

        /* renamed from: w  reason: collision with root package name */
        private final TextView f35383w;

        /* renamed from: x  reason: collision with root package name */
        private final ImageView f35384x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.D0);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f35381u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.date);
            Intrinsics.d(appCompatTextView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f35382v = appCompatTextView2;
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) itemView.findViewById(R$id.f34591a);
            Intrinsics.d(appCompatTextView3, "null cannot be cast to non-null type android.widget.TextView");
            this.f35383w = appCompatTextView3;
            ImageView imageView = (ImageView) itemView.findViewById(R$id.f34600o0);
            Intrinsics.d(imageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f35384x = imageView;
        }

        public final TextView O() {
            return this.f35383w;
        }

        public final TextView P() {
            return this.f35382v;
        }

        public final ImageView Q() {
            return this.f35384x;
        }

        public final TextView R() {
            return this.f35381u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PayoutDelegate(Function1<? super Model, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f35367b = onClick;
        this.f35368c = R$layout.delegate_payout_item;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(PayoutDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35367b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35368c;
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
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.R().setText(model.r());
        holder.P().setText(model.o());
        holder.O().setText(model.n());
        ImageView Q = holder.Q();
        if (model.q() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(Q, z7, 0, 2, null);
        if (model.q() != null) {
            holder.Q().setImageResource(model.q().intValue());
        }
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: v5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayoutDelegate.u(PayoutDelegate.this, model, view);
            }
        });
        RippleProvider rippleProvider = RippleProvider.f35730a;
        View itemView = holder.f7332a;
        Intrinsics.e(itemView, "itemView");
        RippleProvider.b(rippleProvider, itemView, ContextCompat.getColor(holder.f7332a.getContext(), R$color.neutral900), 0, 2, null);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
