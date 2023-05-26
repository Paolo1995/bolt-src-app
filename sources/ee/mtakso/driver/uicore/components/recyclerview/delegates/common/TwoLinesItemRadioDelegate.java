package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoLinesItemRadioDelegate.kt */
/* loaded from: classes5.dex */
public final class TwoLinesItemRadioDelegate<T> extends DiffAdapterDelegate<ViewHolder, Model<T>> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model<T>, Unit> f35138b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35139c;

    /* compiled from: TwoLinesItemRadioDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f35152u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f35153v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f35153v = new LinkedHashMap();
            this.f35152u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f35153v;
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
            return this.f35152u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TwoLinesItemRadioDelegate(Function1<? super Model<T>, Unit> onItemClick) {
        Intrinsics.f(onItemClick, "onItemClick");
        this.f35138b = onItemClick;
        this.f35139c = R$layout.delegate_item_two_lines_radio;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(TwoLinesItemRadioDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35138b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35139c;
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
        View inflate = inflater.inflate(R$layout.delegate_item_two_lines_radio, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…nes_radio, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model<T> model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        int i8 = R$id.R;
        TextView textView = (TextView) holder.O(i8);
        Intrinsics.e(textView, "holder.keyText");
        TextViewExtKt.h(textView, model.p());
        Integer q8 = model.q();
        if (q8 != null) {
            TextViewCompat.o((TextView) holder.O(i8), q8.intValue());
        }
        TextView textView2 = (TextView) holder.O(i8);
        Intrinsics.e(textView2, "holder.keyText");
        TextViewExtKt.i(textView2, model.r());
        int i9 = R$id.valueText;
        TextView textView3 = (TextView) holder.O(i9);
        Intrinsics.e(textView3, "holder.valueText");
        TextViewExtKt.h(textView3, model.t());
        Integer u7 = model.u();
        if (u7 != null) {
            TextViewCompat.o((TextView) holder.O(i9), u7.intValue());
        }
        TextView textView4 = (TextView) holder.O(i9);
        Intrinsics.e(textView4, "holder.valueText");
        TextViewExtKt.i(textView4, model.v());
        ViewExtKt.a(holder.P(), model.n());
        ((RadioButton) holder.O(R$id.f34594e0)).setChecked(model.o());
        holder.O(R$id.f34597j).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TwoLinesItemRadioDelegate.u(TwoLinesItemRadioDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: TwoLinesItemRadioDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model<T> extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35140a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f35141b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f35142c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f35143d;

        /* renamed from: e  reason: collision with root package name */
        private final Text f35144e;

        /* renamed from: f  reason: collision with root package name */
        private final Integer f35145f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f35146g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f35147h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f35148i;

        /* renamed from: j  reason: collision with root package name */
        private final T f35149j;

        /* renamed from: k  reason: collision with root package name */
        private final DividerModel f35150k;

        /* renamed from: l  reason: collision with root package name */
        private final boolean f35151l;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ Model(java.lang.String r22, ee.mtakso.driver.uikit.utils.Text r23, java.lang.Integer r24, ee.mtakso.driver.uikit.utils.Color r25, ee.mtakso.driver.uikit.utils.Text r26, java.lang.Integer r27, ee.mtakso.driver.uikit.utils.Color r28, ee.mtakso.driver.uikit.utils.Color r29, boolean r30, java.lang.Object r31, ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel r32, boolean r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
            /*
                r21 = this;
                r0 = r34
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L9
                r5 = r2
                goto Lb
            L9:
                r5 = r23
            Lb:
                r1 = r0 & 4
                if (r1 == 0) goto L11
                r6 = r2
                goto L13
            L11:
                r6 = r24
            L13:
                r1 = r0 & 8
                if (r1 == 0) goto L19
                r7 = r2
                goto L1b
            L19:
                r7 = r25
            L1b:
                r1 = r0 & 16
                if (r1 == 0) goto L21
                r8 = r2
                goto L23
            L21:
                r8 = r26
            L23:
                r1 = r0 & 32
                if (r1 == 0) goto L29
                r9 = r2
                goto L2b
            L29:
                r9 = r27
            L2b:
                r1 = r0 & 64
                if (r1 == 0) goto L31
                r10 = r2
                goto L33
            L31:
                r10 = r28
            L33:
                r1 = r0 & 128(0x80, float:1.8E-43)
                if (r1 == 0) goto L40
                ee.mtakso.driver.uikit.utils.Color$Attr r1 = new ee.mtakso.driver.uikit.utils.Color$Attr
                int r2 = ee.mtakso.driver.uicore.R$attr.backPrimary
                r1.<init>(r2)
                r11 = r1
                goto L42
            L40:
                r11 = r29
            L42:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L62
                ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider r1 = new ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider
                r13 = 0
                r14 = 0
                r15 = 0
                ee.mtakso.driver.uikit.utils.Color$Attr r2 = new ee.mtakso.driver.uikit.utils.Color$Attr
                int r3 = ee.mtakso.driver.uicore.R$attr.f34582m
                r2.<init>(r3)
                r17 = 0
                r18 = 0
                r19 = 55
                r20 = 0
                r12 = r1
                r16 = r2
                r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
                r14 = r1
                goto L64
            L62:
                r14 = r32
            L64:
                r0 = r0 & 2048(0x800, float:2.87E-42)
                if (r0 == 0) goto L6e
                boolean r0 = r14.e()
                r15 = r0
                goto L70
            L6e:
                r15 = r33
            L70:
                r3 = r21
                r4 = r22
                r12 = r30
                r13 = r31
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemRadioDelegate.Model.<init>(java.lang.String, ee.mtakso.driver.uikit.utils.Text, java.lang.Integer, ee.mtakso.driver.uikit.utils.Color, ee.mtakso.driver.uikit.utils.Text, java.lang.Integer, ee.mtakso.driver.uikit.utils.Color, ee.mtakso.driver.uikit.utils.Color, boolean, java.lang.Object, ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f35150k.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f35151l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35141b, model.f35141b) && Intrinsics.a(this.f35142c, model.f35142c) && Intrinsics.a(this.f35143d, model.f35143d) && Intrinsics.a(this.f35144e, model.f35144e) && Intrinsics.a(this.f35145f, model.f35145f) && Intrinsics.a(this.f35146g, model.f35146g) && Intrinsics.a(this.f35147h, model.f35147h) && this.f35148i == model.f35148i && Intrinsics.a(this.f35149j, model.f35149j) && Intrinsics.a(this.f35150k, model.f35150k) && e() == model.e();
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f35150k.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f35141b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Integer num = this.f35142c;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Color color = this.f35143d;
            int hashCode4 = (hashCode3 + (color == null ? 0 : color.hashCode())) * 31;
            Text text2 = this.f35144e;
            int hashCode5 = (hashCode4 + (text2 == null ? 0 : text2.hashCode())) * 31;
            Integer num2 = this.f35145f;
            int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Color color2 = this.f35146g;
            int hashCode7 = (((hashCode6 + (color2 != null ? color2.hashCode() : 0)) * 31) + this.f35147h.hashCode()) * 31;
            boolean z7 = this.f35148i;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int hashCode8 = (((((hashCode7 + i8) * 31) + this.f35149j.hashCode()) * 31) + this.f35150k.hashCode()) * 31;
            boolean e8 = e();
            return hashCode8 + (e8 ? 1 : e8 ? 1 : 0);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f35150k.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f35150k.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f35150k.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35140a;
        }

        public final Color n() {
            return this.f35147h;
        }

        public final boolean o() {
            return this.f35148i;
        }

        public final Text p() {
            return this.f35141b;
        }

        public final Integer q() {
            return this.f35142c;
        }

        public final Color r() {
            return this.f35143d;
        }

        public final T s() {
            return this.f35149j;
        }

        public final Text t() {
            return this.f35144e;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f35141b;
            Integer num = this.f35142c;
            Color color = this.f35143d;
            Text text2 = this.f35144e;
            Integer num2 = this.f35145f;
            Color color2 = this.f35146g;
            Color color3 = this.f35147h;
            boolean z7 = this.f35148i;
            T t7 = this.f35149j;
            DividerModel dividerModel = this.f35150k;
            boolean e8 = e();
            return "Model(listId=" + m8 + ", keyText=" + text + ", keyTextAppearance=" + num + ", keyTextColor=" + color + ", valueText=" + text2 + ", valueTextAppearance=" + num2 + ", valueTextColor=" + color2 + ", backgroundColor=" + color3 + ", checked=" + z7 + ", payload=" + t7 + ", divider=" + dividerModel + ", isDividerEnabled=" + e8 + ")";
        }

        public final Integer u() {
            return this.f35145f;
        }

        public final Color v() {
            return this.f35146g;
        }

        public Model(String listId, Text text, Integer num, Color color, Text text2, Integer num2, Color color2, Color backgroundColor, boolean z7, T payload, DividerModel divider, boolean z8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(backgroundColor, "backgroundColor");
            Intrinsics.f(payload, "payload");
            Intrinsics.f(divider, "divider");
            this.f35140a = listId;
            this.f35141b = text;
            this.f35142c = num;
            this.f35143d = color;
            this.f35144e = text2;
            this.f35145f = num2;
            this.f35146g = color2;
            this.f35147h = backgroundColor;
            this.f35148i = z7;
            this.f35149j = payload;
            this.f35150k = divider;
            this.f35151l = z8;
        }
    }
}
