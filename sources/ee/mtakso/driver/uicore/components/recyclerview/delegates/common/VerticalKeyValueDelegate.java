package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import j$.util.Spliterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerticalKeyValueDelegate.kt */
/* loaded from: classes5.dex */
public final class VerticalKeyValueDelegate<T> extends DiffAdapterDelegate<ViewHolder, Model<T>> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model<T>, Unit> f35159b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35160c;

    /* compiled from: VerticalKeyValueDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f35174u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f35175v;

        /* renamed from: w  reason: collision with root package name */
        private final ImageView f35176w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.R);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f35174u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.valueText);
            Intrinsics.d(appCompatTextView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f35175v = appCompatTextView2;
            ImageView imageView = (ImageView) itemView.findViewById(R$id.infoIcon);
            Intrinsics.d(imageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f35176w = imageView;
        }

        public final ImageView O() {
            return this.f35176w;
        }

        public final TextView P() {
            return this.f35174u;
        }

        public final TextView Q() {
            return this.f35175v;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VerticalKeyValueDelegate(Function1<? super Model<T>, Unit> onInfoClick) {
        Intrinsics.f(onInfoClick, "onInfoClick");
        this.f35159b = onInfoClick;
        this.f35160c = R$layout.delegate_vertical_key_value_item;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(VerticalKeyValueDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35159b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35160c;
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
    public void g(ViewHolder holder, final Model<T> model) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.P().setText(model.p());
        holder.Q().setText(model.s());
        ImageView O = holder.O();
        if (model.o() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(O, z7, 0, 2, null);
        if (model.o() != null) {
            holder.O().setImageResource(model.o().intValue());
        }
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerticalKeyValueDelegate.u(VerticalKeyValueDelegate.this, model, view);
            }
        });
        RippleProvider rippleProvider = RippleProvider.f35730a;
        View itemView = holder.f7332a;
        Intrinsics.e(itemView, "itemView");
        int color = ContextCompat.getColor(holder.f7332a.getContext(), model.n());
        Color r7 = model.r();
        Context context = holder.f7332a.getContext();
        Intrinsics.e(context, "itemView.context");
        rippleProvider.a(itemView, color, ColorKt.a(r7, context));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: VerticalKeyValueDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model<T> extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35161a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f35162b;

        /* renamed from: c  reason: collision with root package name */
        private final CharSequence f35163c;

        /* renamed from: d  reason: collision with root package name */
        private final Integer f35164d;

        /* renamed from: e  reason: collision with root package name */
        private final int f35165e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f35166f;

        /* renamed from: g  reason: collision with root package name */
        private final T f35167g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f35168h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f35169i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f35170j;

        /* renamed from: k  reason: collision with root package name */
        private final Color f35171k;

        /* renamed from: l  reason: collision with root package name */
        private final Color f35172l;

        /* renamed from: m  reason: collision with root package name */
        private final Float f35173m;

        public /* synthetic */ Model(String str, CharSequence charSequence, CharSequence charSequence2, Integer num, int i8, Color color, Object obj, boolean z7, boolean z8, boolean z9, Color color2, Color color3, Float f8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, charSequence, charSequence2, (i9 & 8) != 0 ? null : num, (i9 & 16) != 0 ? R$color.neutral900 : i8, (i9 & 32) != 0 ? new Color.Attr(R$attr.f34582m) : color, obj, (i9 & 128) != 0 ? true : z7, (i9 & Spliterator.NONNULL) != 0 ? false : z8, (i9 & 512) != 0 ? true : z9, (i9 & Spliterator.IMMUTABLE) != 0 ? null : color2, (i9 & 2048) != 0 ? null : color3, (i9 & 4096) != 0 ? null : f8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f35171k;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f35168h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35162b, model.f35162b) && Intrinsics.a(this.f35163c, model.f35163c) && Intrinsics.a(this.f35164d, model.f35164d) && this.f35165e == model.f35165e && Intrinsics.a(this.f35166f, model.f35166f) && Intrinsics.a(this.f35167g, model.f35167g) && e() == model.e() && j() == model.j() && k() == model.k() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Intrinsics.a(i(), model.i());
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f35172l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((m().hashCode() * 31) + this.f35162b.hashCode()) * 31) + this.f35163c.hashCode()) * 31;
            Integer num = this.f35164d;
            int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.f35165e) * 31) + this.f35166f.hashCode()) * 31;
            T t7 = this.f35167g;
            int hashCode3 = (hashCode2 + (t7 == null ? 0 : t7.hashCode())) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode3 + i8) * 31;
            boolean j8 = j();
            int i10 = j8;
            if (j8 != 0) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            boolean k8 = k();
            return ((((((i11 + (k8 ? 1 : k8 ? 1 : 0)) * 31) + (d() == null ? 0 : d().hashCode())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + (i() != null ? i().hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f35173m;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f35169i;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f35170j;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35161a;
        }

        public final int n() {
            return this.f35165e;
        }

        public final Integer o() {
            return this.f35164d;
        }

        public final CharSequence p() {
            return this.f35162b;
        }

        public final T q() {
            return this.f35167g;
        }

        public final Color r() {
            return this.f35166f;
        }

        public final CharSequence s() {
            return this.f35163c;
        }

        public String toString() {
            String m8 = m();
            CharSequence charSequence = this.f35162b;
            CharSequence charSequence2 = this.f35163c;
            Integer num = this.f35164d;
            int i8 = this.f35165e;
            Color color = this.f35166f;
            T t7 = this.f35167g;
            boolean e8 = e();
            boolean j8 = j();
            boolean k8 = k();
            Color d8 = d();
            Color f8 = f();
            Float i9 = i();
            return "Model(listId=" + m8 + ", keyText=" + ((Object) charSequence) + ", valueText=" + ((Object) charSequence2) + ", infoIcon=" + num + ", backgroundColorRes=" + i8 + ", rippleColor=" + color + ", payload=" + t7 + ", isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i9 + ")";
        }

        public Model(String listId, CharSequence keyText, CharSequence valueText, Integer num, int i8, Color rippleColor, T t7, boolean z7, boolean z8, boolean z9, Color color, Color color2, Float f8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(keyText, "keyText");
            Intrinsics.f(valueText, "valueText");
            Intrinsics.f(rippleColor, "rippleColor");
            this.f35161a = listId;
            this.f35162b = keyText;
            this.f35163c = valueText;
            this.f35164d = num;
            this.f35165e = i8;
            this.f35166f = rippleColor;
            this.f35167g = t7;
            this.f35168h = z7;
            this.f35169i = z8;
            this.f35170j = z9;
            this.f35171k = color;
            this.f35172l = color2;
            this.f35173m = f8;
        }
    }
}
