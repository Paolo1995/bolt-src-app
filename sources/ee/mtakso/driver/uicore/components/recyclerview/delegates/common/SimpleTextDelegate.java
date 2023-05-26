package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import j$.util.Spliterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleTextDelegate.kt */
/* loaded from: classes5.dex */
public final class SimpleTextDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f35045d = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private static final Color.Res f35046e = new Color.Res(R$color.neutral200);

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f35047b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35048c;

    /* compiled from: SimpleTextDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Color.Res a() {
            return SimpleTextDelegate.f35046e;
        }
    }

    /* compiled from: SimpleTextDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f35062u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.f(view, "view");
            TextView textView = (TextView) view.findViewById(R$id.f34604s0);
            Intrinsics.e(textView, "view.text");
            this.f35062u = textView;
        }

        public final TextView O() {
            return this.f35062u;
        }
    }

    public SimpleTextDelegate() {
        this(null, 1, null);
    }

    public /* synthetic */ SimpleTextDelegate(Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new Function1<Model, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.SimpleTextDelegate.1
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
    public static final void v(SimpleTextDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35047b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35048c;
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
        View inflate = inflater.inflate(R$layout.delegate_simple_text, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…mple_text, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.O().getContext();
        Color n8 = model.n();
        if (n8 == null) {
            n8 = f35046e;
        }
        TextView O = holder.O();
        Color w7 = model.w();
        Intrinsics.e(context, "context");
        O.setTextColor(ColorKt.a(w7, context));
        holder.O().setTextSize(0, model.x());
        holder.O().setBackgroundColor(ColorKt.a(n8, context));
        TextView O2 = holder.O();
        Text u7 = model.u();
        O2.setText((u7 == null || (r3 = TextKt.a(u7, context)) == null) ? "" : "");
        if (model.o()) {
            RippleProvider.b(RippleProvider.f35730a, holder.O(), ColorKt.a(n8, context), 0, 2, null);
        }
        holder.O().setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleTextDelegate.v(SimpleTextDelegate.this, model, view);
            }
        });
        Integer v7 = model.v();
        if (v7 != null) {
            TextViewCompat.o(holder.O(), v7.intValue());
        }
        holder.O().setPaddingRelative(model.r(), model.s(), model.q(), model.p());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: w */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleTextDelegate(Function1<? super Model, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f35047b = onClick;
        this.f35048c = R$layout.delegate_simple_text;
    }

    /* compiled from: SimpleTextDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35050a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f35051b;

        /* renamed from: c  reason: collision with root package name */
        private final Color f35052c;

        /* renamed from: d  reason: collision with root package name */
        private final int f35053d;

        /* renamed from: e  reason: collision with root package name */
        private final int f35054e;

        /* renamed from: f  reason: collision with root package name */
        private final int f35055f;

        /* renamed from: g  reason: collision with root package name */
        private final int f35056g;

        /* renamed from: h  reason: collision with root package name */
        private final float f35057h;

        /* renamed from: i  reason: collision with root package name */
        private final Integer f35058i;

        /* renamed from: j  reason: collision with root package name */
        private final Color f35059j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f35060k;

        /* renamed from: l  reason: collision with root package name */
        private final Object f35061l;

        public /* synthetic */ Model(String str, Text text, Color color, int i8, int i9, int i10, int i11, float f8, Integer num, Color color2, boolean z7, Object obj, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? "" : str, text, (i12 & 4) != 0 ? SimpleTextDelegate.f35045d.a() : color, (i12 & 8) != 0 ? Dimens.d(16) : i8, (i12 & 16) != 0 ? Dimens.d(16) : i9, (i12 & 32) != 0 ? Dimens.d(24) : i10, (i12 & 64) != 0 ? Dimens.d(24) : i11, (i12 & 128) != 0 ? Dimens.c(14.0f) : f8, (i12 & Spliterator.NONNULL) != 0 ? null : num, (i12 & 512) != 0 ? new Color.Res(R$color.neutral500) : color2, (i12 & Spliterator.IMMUTABLE) != 0 ? false : z7, (i12 & 2048) != 0 ? null : obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35051b, model.f35051b) && Intrinsics.a(this.f35052c, model.f35052c) && this.f35053d == model.f35053d && this.f35054e == model.f35054e && this.f35055f == model.f35055f && this.f35056g == model.f35056g && Float.compare(this.f35057h, model.f35057h) == 0 && Intrinsics.a(this.f35058i, model.f35058i) && Intrinsics.a(this.f35059j, model.f35059j) && this.f35060k == model.f35060k && Intrinsics.a(this.f35061l, model.f35061l);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f35051b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Color color = this.f35052c;
            int hashCode3 = (((((((((((hashCode2 + (color == null ? 0 : color.hashCode())) * 31) + this.f35053d) * 31) + this.f35054e) * 31) + this.f35055f) * 31) + this.f35056g) * 31) + Float.floatToIntBits(this.f35057h)) * 31;
            Integer num = this.f35058i;
            int hashCode4 = (((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + this.f35059j.hashCode()) * 31;
            boolean z7 = this.f35060k;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode4 + i8) * 31;
            Object obj = this.f35061l;
            return i9 + (obj != null ? obj.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35050a;
        }

        public final Color n() {
            return this.f35052c;
        }

        public final boolean o() {
            return this.f35060k;
        }

        public final int p() {
            return this.f35056g;
        }

        public final int q() {
            return this.f35054e;
        }

        public final int r() {
            return this.f35053d;
        }

        public final int s() {
            return this.f35055f;
        }

        public final Object t() {
            return this.f35061l;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f35051b;
            Color color = this.f35052c;
            int i8 = this.f35053d;
            int i9 = this.f35054e;
            int i10 = this.f35055f;
            int i11 = this.f35056g;
            float f8 = this.f35057h;
            Integer num = this.f35058i;
            Color color2 = this.f35059j;
            boolean z7 = this.f35060k;
            Object obj = this.f35061l;
            return "Model(listId=" + m8 + ", text=" + text + ", backgroundColor=" + color + ", paddingStart=" + i8 + ", paddingEnd=" + i9 + ", paddingTop=" + i10 + ", paddingBottom=" + i11 + ", textSize=" + f8 + ", textAppearance=" + num + ", textColorRes=" + color2 + ", clickable=" + z7 + ", payload=" + obj + ")";
        }

        public final Text u() {
            return this.f35051b;
        }

        public final Integer v() {
            return this.f35058i;
        }

        public final Color w() {
            return this.f35059j;
        }

        public final float x() {
            return this.f35057h;
        }

        public Model(String listId, Text text, Color color, int i8, int i9, int i10, int i11, float f8, Integer num, Color textColorRes, boolean z7, Object obj) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(textColorRes, "textColorRes");
            this.f35050a = listId;
            this.f35051b = text;
            this.f35052c = color;
            this.f35053d = i8;
            this.f35054e = i9;
            this.f35055f = i10;
            this.f35056g = i11;
            this.f35057h = f8;
            this.f35058i = num;
            this.f35059j = textColorRes;
            this.f35060k = z7;
            this.f35061l = obj;
        }
    }
}
