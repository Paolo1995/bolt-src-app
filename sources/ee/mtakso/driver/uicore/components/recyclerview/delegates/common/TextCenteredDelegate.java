package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
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

/* compiled from: TextCenteredDelegate.kt */
/* loaded from: classes5.dex */
public final class TextCenteredDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f35070b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35071c;

    /* compiled from: TextCenteredDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f35084u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.f34604s0);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f35084u = appCompatTextView;
        }

        public final TextView O() {
            return this.f35084u;
        }
    }

    public TextCenteredDelegate() {
        this(null, 1, null);
    }

    public /* synthetic */ TextCenteredDelegate(Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new Function1<Model, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TextCenteredDelegate.1
            public final void b(Model it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Model model) {
                b(model);
                return Unit.f50853a;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(TextCenteredDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35070b.invoke(model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(View view) {
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35071c;
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
    /* renamed from: u */
    public void g(ViewHolder holder, final Model model) {
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
        holder.O().setBackgroundColor(model.n());
        if (model.q()) {
            Color o8 = model.o();
            Context context = holder.O().getContext();
            Intrinsics.e(context, "textView.context");
            RippleProvider.f35730a.a(holder.O(), model.n(), ColorKt.a(o8, context));
            holder.O().setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TextCenteredDelegate.v(TextCenteredDelegate.this, model, view);
                }
            });
            return;
        }
        holder.O().setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextCenteredDelegate.w(view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: x */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: TextCenteredDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35073a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f35074b;

        /* renamed from: c  reason: collision with root package name */
        private final int f35075c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f35076d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f35077e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f35078f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f35079g;

        /* renamed from: h  reason: collision with root package name */
        private final float f35080h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f35081i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f35082j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f35083k;

        public /* synthetic */ Model(String str, CharSequence charSequence, int i8, Color color, boolean z7, Color color2, Color color3, float f8, boolean z8, boolean z9, boolean z10, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i9 & 2) != 0 ? null : charSequence, (i9 & 4) != 0 ? 0 : i8, (i9 & 8) != 0 ? new Color.Attr(R$attr.f34582m) : color, (i9 & 16) != 0 ? false : z7, (i9 & 32) != 0 ? new Color.Res(R$color.f34586k) : color2, (i9 & 64) == 0 ? color3 : null, (i9 & 128) != 0 ? 0.0f : f8, (i9 & Spliterator.NONNULL) != 0 ? false : z8, (i9 & 512) != 0 ? false : z9, (i9 & Spliterator.IMMUTABLE) == 0 ? z10 : false);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f35078f;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f35082j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35074b, model.f35074b) && this.f35075c == model.f35075c && Intrinsics.a(this.f35076d, model.f35076d) && this.f35077e == model.f35077e && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Float.compare(i().floatValue(), model.i().floatValue()) == 0 && j() == model.j() && e() == model.e() && k() == model.k();
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f35079g;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            CharSequence charSequence = this.f35074b;
            int hashCode2 = (((((hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + this.f35075c) * 31) + this.f35076d.hashCode()) * 31;
            boolean z7 = this.f35077e;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int hashCode3 = (((((((hashCode2 + i8) * 31) + d().hashCode()) * 31) + (f() != null ? f().hashCode() : 0)) * 31) + i().hashCode()) * 31;
            boolean j8 = j();
            int i9 = j8;
            if (j8) {
                i9 = 1;
            }
            int i10 = (hashCode3 + i9) * 31;
            boolean e8 = e();
            int i11 = e8;
            if (e8) {
                i11 = 1;
            }
            int i12 = (i10 + i11) * 31;
            boolean k8 = k();
            return i12 + (k8 ? 1 : k8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return Float.valueOf(this.f35080h);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f35081i;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f35083k;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35073a;
        }

        public final int n() {
            return this.f35075c;
        }

        public final Color o() {
            return this.f35076d;
        }

        public final CharSequence p() {
            return this.f35074b;
        }

        public final boolean q() {
            return this.f35077e;
        }

        public String toString() {
            String m8 = m();
            CharSequence charSequence = this.f35074b;
            int i8 = this.f35075c;
            Color color = this.f35076d;
            boolean z7 = this.f35077e;
            Color d8 = d();
            Color f8 = f();
            Float i9 = i();
            boolean j8 = j();
            boolean e8 = e();
            boolean k8 = k();
            return "Model(listId=" + m8 + ", text=" + ((Object) charSequence) + ", backgroundColor=" + i8 + ", rippleColor=" + color + ", isCLickable=" + z7 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i9 + ", isDividerAtTheTop=" + j8 + ", isDividerEnabled=" + e8 + ", shouldIgnoreMargins=" + k8 + ")";
        }

        public Model(String listId, CharSequence charSequence, int i8, Color rippleColor, boolean z7, Color dividerColor, Color color, float f8, boolean z8, boolean z9, boolean z10) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(rippleColor, "rippleColor");
            Intrinsics.f(dividerColor, "dividerColor");
            this.f35073a = listId;
            this.f35074b = charSequence;
            this.f35075c = i8;
            this.f35076d = rippleColor;
            this.f35077e = z7;
            this.f35078f = dividerColor;
            this.f35079g = color;
            this.f35080h = f8;
            this.f35081i = z8;
            this.f35082j = z9;
            this.f35083k = z10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextCenteredDelegate(Function1<? super Model, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f35070b = onClick;
        this.f35071c = R$layout.delegate_centered_text;
    }
}
