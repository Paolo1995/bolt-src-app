package ee.mtakso.driver.uicore.components.recyclerview.delegates.generic;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$drawable;
import ee.mtakso.driver.uicore.R$font;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DepthModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericItemDelegate;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenericItemDelegate.kt */
/* loaded from: classes5.dex */
public final class GenericItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f35266b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<PopupInfo, Unit> f35267c;

    /* renamed from: d  reason: collision with root package name */
    private final int f35268d;

    /* compiled from: GenericItemDelegate.kt */
    /* loaded from: classes5.dex */
    public enum ChevronState {
        OPENED(R$drawable.ic_tree_chevron_up),
        COLLAPSED(R$drawable.ic_tree_chevron_down);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f35272f;

        ChevronState(int i8) {
            this.f35272f = i8;
        }

        public final int c() {
            return this.f35272f;
        }
    }

    /* compiled from: GenericItemDelegate.kt */
    /* loaded from: classes5.dex */
    public enum TextStyle {
        NORMAL(R$font.f34590c),
        BOLD(R$font.f34589b);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f35312f;

        TextStyle(int i8) {
            this.f35312f = i8;
        }

        public final int c() {
            return this.f35312f;
        }
    }

    /* compiled from: GenericItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f35313u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f35314v;

        /* renamed from: w  reason: collision with root package name */
        private final ImageView f35315w;

        /* renamed from: x  reason: collision with root package name */
        private final ImageView f35316x;

        /* renamed from: y  reason: collision with root package name */
        private final TextView f35317y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.D0);
            Intrinsics.e(appCompatTextView, "itemView.title");
            this.f35313u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.L0);
            Intrinsics.e(appCompatTextView2, "itemView.value");
            this.f35314v = appCompatTextView2;
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R$id.chevron);
            Intrinsics.e(appCompatImageView, "itemView.chevron");
            this.f35315w = appCompatImageView;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) itemView.findViewById(R$id.infoSign);
            Intrinsics.e(appCompatImageView2, "itemView.infoSign");
            this.f35316x = appCompatImageView2;
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) itemView.findViewById(R$id.warningText);
            Intrinsics.e(appCompatTextView3, "itemView.warningText");
            this.f35317y = appCompatTextView3;
        }

        public final ImageView O() {
            return this.f35315w;
        }

        public final ImageView P() {
            return this.f35316x;
        }

        public final TextView Q() {
            return this.f35313u;
        }

        public final TextView R() {
            return this.f35314v;
        }

        public final TextView S() {
            return this.f35317y;
        }
    }

    public /* synthetic */ GenericItemDelegate(Function1 function1, Function1 function12, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i8 & 2) != 0 ? null : function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(GenericItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35266b.invoke(model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Model model, GenericItemDelegate this$0, View view) {
        Function1<PopupInfo, Unit> function1;
        Intrinsics.f(model, "$model");
        Intrinsics.f(this$0, "this$0");
        if (model.p() != null && (function1 = this$0.f35267c) != null) {
            function1.invoke(model.p());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(GenericItemDelegate this$0, PopupInfo popupInfo, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(popupInfo, "$popupInfo");
        Function1<PopupInfo, Unit> function1 = this$0.f35267c;
        if (function1 != null) {
            function1.invoke(popupInfo);
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35268d;
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
        View v7 = inflater.inflate(R$layout.delegate_generic_item, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void g(ViewHolder holder, final Model model) {
        boolean z7;
        CharSequence charSequence;
        boolean z8;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.f7332a.getContext();
        Resources resources = context.getResources();
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: t5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GenericItemDelegate.w(GenericItemDelegate.this, model, view);
            }
        });
        TextView Q = holder.Q();
        Text q8 = model.q();
        Intrinsics.e(context, "context");
        Q.setText(TextKt.a(q8, context));
        boolean z9 = false;
        holder.Q().setTextSize(0, resources.getDimension(model.s()));
        holder.Q().setTextColor(ColorKt.b(model.r(), context));
        holder.R().setText(TextKt.a(model.t(), context));
        holder.R().setTextSize(0, resources.getDimension(model.v()));
        holder.R().setTextColor(ColorKt.b(model.u(), context));
        holder.R().setTypeface(ResourcesCompat.h(holder.R().getContext(), model.w().c()));
        TextView S = holder.S();
        if (model.x() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(S, z7, 0, 2, null);
        TextView S2 = holder.S();
        Text x7 = model.x();
        if (x7 != null) {
            charSequence = TextKt.a(x7, context);
        } else {
            charSequence = null;
        }
        S2.setText(charSequence);
        ImageView P = holder.P();
        if (model.p() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.e(P, z8, 0, 2, null);
        holder.P().setOnClickListener(new View.OnClickListener() { // from class: t5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GenericItemDelegate.x(GenericItemDelegate.Model.this, this, view);
            }
        });
        ImageView O = holder.O();
        if (model.o() != null) {
            z9 = true;
        }
        ViewExtKt.d(O, z9, 4);
        ChevronState o8 = model.o();
        if (o8 != null) {
            holder.O().setImageResource(o8.c());
        }
        holder.f7332a.setBackgroundColor(ColorKt.a(model.n(), context));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: y */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
        Context context = holder.f7332a.getContext();
        Resources resources = context.getResources();
        ArrayList<Payload> arrayList = new ArrayList();
        for (Object obj : payloads) {
            if (obj instanceof Payload) {
                arrayList.add(obj);
            }
        }
        for (Payload payload : arrayList) {
            Text e8 = payload.e();
            if (e8 != null) {
                TextView Q = holder.Q();
                Intrinsics.e(context, "context");
                Q.setText(TextKt.a(e8, context));
            }
            Color f8 = payload.f();
            if (f8 != null) {
                TextView Q2 = holder.Q();
                Intrinsics.e(context, "context");
                Q2.setTextColor(ColorKt.a(f8, context));
            }
            Integer g8 = payload.g();
            if (g8 != null) {
                holder.Q().setTextSize(0, resources.getDimension(g8.intValue()));
            }
            Text h8 = payload.h();
            if (h8 != null) {
                TextView R = holder.R();
                Intrinsics.e(context, "context");
                R.setText(TextKt.a(h8, context));
            }
            Color i8 = payload.i();
            if (i8 != null) {
                TextView R2 = holder.R();
                Intrinsics.e(context, "context");
                R2.setTextColor(ColorKt.a(i8, context));
            }
            Integer j8 = payload.j();
            if (j8 != null) {
                holder.R().setTextSize(0, resources.getDimension(j8.intValue()));
            }
            ImageView O = holder.O();
            if (payload.b() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewExtKt.d(O, z7, 4);
            ChevronState b8 = payload.b();
            if (b8 != null) {
                holder.O().setImageResource(b8.c());
            }
            TextStyle k8 = payload.k();
            if (k8 != null) {
                holder.R().setTypeface(ResourcesCompat.h(context, k8.c()));
            }
            Boolean d8 = payload.d();
            if (d8 != null) {
                boolean booleanValue = d8.booleanValue();
                ImageView P = holder.P();
                if (P != null) {
                    ViewExtKt.e(P, booleanValue, 0, 2, null);
                }
            }
            final PopupInfo c8 = payload.c();
            if (c8 != null) {
                holder.P().setOnClickListener(new View.OnClickListener() { // from class: t5.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GenericItemDelegate.z(GenericItemDelegate.this, c8, view);
                    }
                });
            }
            Color a8 = payload.a();
            if (a8 != null) {
                View view = holder.f7332a;
                Intrinsics.e(context, "context");
                view.setBackgroundColor(ColorKt.a(a8, context));
            }
        }
    }

    /* compiled from: GenericItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DepthModel, DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35273a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f35274b;

        /* renamed from: c  reason: collision with root package name */
        private final int f35275c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f35276d;

        /* renamed from: e  reason: collision with root package name */
        private final Text f35277e;

        /* renamed from: f  reason: collision with root package name */
        private final int f35278f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f35279g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f35280h;

        /* renamed from: i  reason: collision with root package name */
        private final Text f35281i;

        /* renamed from: j  reason: collision with root package name */
        private final ChevronState f35282j;

        /* renamed from: k  reason: collision with root package name */
        private final TextStyle f35283k;

        /* renamed from: l  reason: collision with root package name */
        private final PopupInfo f35284l;

        /* renamed from: m  reason: collision with root package name */
        private final int f35285m;

        /* renamed from: n  reason: collision with root package name */
        private final boolean f35286n;

        /* renamed from: o  reason: collision with root package name */
        private final boolean f35287o;

        /* renamed from: p  reason: collision with root package name */
        private final boolean f35288p;

        /* renamed from: q  reason: collision with root package name */
        private final Color f35289q;

        /* renamed from: r  reason: collision with root package name */
        private final Color f35290r;

        /* renamed from: s  reason: collision with root package name */
        private final Float f35291s;

        public /* synthetic */ Model(String str, Text text, int i8, Color color, Text text2, int i9, Color color2, Color color3, Text text3, ChevronState chevronState, TextStyle textStyle, PopupInfo popupInfo, int i10, boolean z7, boolean z8, boolean z9, Color color4, Color color5, Float f8, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, text, i8, color, text2, i9, color2, color3, text3, (i11 & 512) != 0 ? null : chevronState, (i11 & Spliterator.IMMUTABLE) != 0 ? TextStyle.NORMAL : textStyle, (i11 & 2048) != 0 ? null : popupInfo, i10, (i11 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? true : z7, (i11 & 16384) != 0 ? false : z8, (32768 & i11) != 0 ? false : z9, (65536 & i11) != 0 ? null : color4, (131072 & i11) != 0 ? null : color5, (i11 & 262144) != 0 ? null : f8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f35289q;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f35286n;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35274b, model.f35274b) && this.f35275c == model.f35275c && Intrinsics.a(this.f35276d, model.f35276d) && Intrinsics.a(this.f35277e, model.f35277e) && this.f35278f == model.f35278f && Intrinsics.a(this.f35279g, model.f35279g) && Intrinsics.a(this.f35280h, model.f35280h) && Intrinsics.a(this.f35281i, model.f35281i) && this.f35282j == model.f35282j && this.f35283k == model.f35283k && Intrinsics.a(this.f35284l, model.f35284l) && getDepth() == model.getDepth() && e() == model.e() && j() == model.j() && k() == model.k() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Intrinsics.a(i(), model.i());
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f35290r;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DepthModel
        public int getDepth() {
            return this.f35285m;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((((((((((((m().hashCode() * 31) + this.f35274b.hashCode()) * 31) + this.f35275c) * 31) + this.f35276d.hashCode()) * 31) + this.f35277e.hashCode()) * 31) + this.f35278f) * 31) + this.f35279g.hashCode()) * 31) + this.f35280h.hashCode()) * 31;
            Text text = this.f35281i;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            ChevronState chevronState = this.f35282j;
            int hashCode3 = (((hashCode2 + (chevronState == null ? 0 : chevronState.hashCode())) * 31) + this.f35283k.hashCode()) * 31;
            PopupInfo popupInfo = this.f35284l;
            int hashCode4 = (((hashCode3 + (popupInfo == null ? 0 : popupInfo.hashCode())) * 31) + getDepth()) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            int i9 = (hashCode4 + i8) * 31;
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
            return this.f35291s;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f35287o;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f35288p;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public Object l(ListModel oldModel) {
            Text text;
            Color color;
            boolean z7;
            Text text2;
            Color color2;
            boolean z8;
            Integer num;
            boolean z9;
            ChevronState chevronState;
            boolean z10;
            TextStyle textStyle;
            Boolean bool;
            PopupInfo popupInfo;
            Color color3;
            Intrinsics.f(oldModel, "oldModel");
            if (!(oldModel instanceof Model)) {
                return null;
            }
            Text text3 = this.f35274b;
            Model model = (Model) oldModel;
            if (!Intrinsics.a(text3, model.f35274b)) {
                text = text3;
            } else {
                text = null;
            }
            Color color4 = this.f35276d;
            if (!Intrinsics.a(color4, model.f35276d)) {
                color = color4;
            } else {
                color = null;
            }
            Integer valueOf = Integer.valueOf(this.f35275c);
            boolean z11 = false;
            if (valueOf.intValue() != model.f35275c) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                valueOf = null;
            }
            Text text4 = this.f35277e;
            if (!Intrinsics.a(text4, model.f35277e)) {
                text2 = text4;
            } else {
                text2 = null;
            }
            Color color5 = this.f35279g;
            if (!Intrinsics.a(color5, model.f35279g)) {
                color2 = color5;
            } else {
                color2 = null;
            }
            Integer valueOf2 = Integer.valueOf(this.f35278f);
            if (valueOf2.intValue() != model.f35278f) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                num = valueOf2;
            } else {
                num = null;
            }
            ChevronState chevronState2 = this.f35282j;
            if (chevronState2 != model.f35282j) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9) {
                chevronState = chevronState2;
            } else {
                chevronState = null;
            }
            TextStyle textStyle2 = this.f35283k;
            if (textStyle2 != model.f35283k) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                textStyle = textStyle2;
            } else {
                textStyle = null;
            }
            if (!Intrinsics.a(this.f35284l, model.f35284l)) {
                if (model.f35284l == null && this.f35284l != null) {
                    z11 = true;
                }
                bool = Boolean.valueOf(z11);
            } else {
                bool = null;
            }
            PopupInfo popupInfo2 = this.f35284l;
            if (!Intrinsics.a(popupInfo2, model.f35284l)) {
                popupInfo = popupInfo2;
            } else {
                popupInfo = null;
            }
            Color color6 = this.f35280h;
            if (!Intrinsics.a(color6, model.f35280h)) {
                color3 = color6;
            } else {
                color3 = null;
            }
            return new Payload(text, valueOf, color, text2, num, color2, chevronState, textStyle, bool, popupInfo, color3);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35273a;
        }

        public final Color n() {
            return this.f35280h;
        }

        public final ChevronState o() {
            return this.f35282j;
        }

        public final PopupInfo p() {
            return this.f35284l;
        }

        public final Text q() {
            return this.f35274b;
        }

        public final Color r() {
            return this.f35276d;
        }

        public final int s() {
            return this.f35275c;
        }

        public final Text t() {
            return this.f35277e;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f35274b;
            int i8 = this.f35275c;
            Color color = this.f35276d;
            Text text2 = this.f35277e;
            int i9 = this.f35278f;
            Color color2 = this.f35279g;
            Color color3 = this.f35280h;
            Text text3 = this.f35281i;
            ChevronState chevronState = this.f35282j;
            TextStyle textStyle = this.f35283k;
            PopupInfo popupInfo = this.f35284l;
            int depth = getDepth();
            boolean e8 = e();
            boolean j8 = j();
            boolean k8 = k();
            Color d8 = d();
            Color f8 = f();
            Float i10 = i();
            return "Model(listId=" + m8 + ", titleText=" + text + ", titleTextSizeRes=" + i8 + ", titleTextColor=" + color + ", valueText=" + text2 + ", valueTextSizeRes=" + i9 + ", valueTextColor=" + color2 + ", backgroundColor=" + color3 + ", warningText=" + text3 + ", chevronState=" + chevronState + ", valueTextStyle=" + textStyle + ", popupInfo=" + popupInfo + ", depth=" + depth + ", isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i10 + ")";
        }

        public final Color u() {
            return this.f35279g;
        }

        public final int v() {
            return this.f35278f;
        }

        public final TextStyle w() {
            return this.f35283k;
        }

        public final Text x() {
            return this.f35281i;
        }

        public Model(String listId, Text titleText, int i8, Color titleTextColor, Text valueText, int i9, Color valueTextColor, Color backgroundColor, Text text, ChevronState chevronState, TextStyle valueTextStyle, PopupInfo popupInfo, int i10, boolean z7, boolean z8, boolean z9, Color color, Color color2, Float f8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(titleText, "titleText");
            Intrinsics.f(titleTextColor, "titleTextColor");
            Intrinsics.f(valueText, "valueText");
            Intrinsics.f(valueTextColor, "valueTextColor");
            Intrinsics.f(backgroundColor, "backgroundColor");
            Intrinsics.f(valueTextStyle, "valueTextStyle");
            this.f35273a = listId;
            this.f35274b = titleText;
            this.f35275c = i8;
            this.f35276d = titleTextColor;
            this.f35277e = valueText;
            this.f35278f = i9;
            this.f35279g = valueTextColor;
            this.f35280h = backgroundColor;
            this.f35281i = text;
            this.f35282j = chevronState;
            this.f35283k = valueTextStyle;
            this.f35284l = popupInfo;
            this.f35285m = i10;
            this.f35286n = z7;
            this.f35287o = z8;
            this.f35288p = z9;
            this.f35289q = color;
            this.f35290r = color2;
            this.f35291s = f8;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GenericItemDelegate(Function1<? super Model, Unit> onItemClickListener, Function1<? super PopupInfo, Unit> function1) {
        Intrinsics.f(onItemClickListener, "onItemClickListener");
        this.f35266b = onItemClickListener;
        this.f35267c = function1;
        this.f35268d = R$layout.delegate_generic_item;
    }

    /* compiled from: GenericItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class PopupInfo {

        /* renamed from: a  reason: collision with root package name */
        private final String f35303a;

        /* renamed from: b  reason: collision with root package name */
        private final String f35304b;

        /* renamed from: c  reason: collision with root package name */
        private final int f35305c;

        /* renamed from: d  reason: collision with root package name */
        private final CharSequence f35306d;

        /* renamed from: e  reason: collision with root package name */
        private final String f35307e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f35308f;

        public PopupInfo(String title, String subtitle, int i8, CharSequence content, String str, boolean z7) {
            Intrinsics.f(title, "title");
            Intrinsics.f(subtitle, "subtitle");
            Intrinsics.f(content, "content");
            this.f35303a = title;
            this.f35304b = subtitle;
            this.f35305c = i8;
            this.f35306d = content;
            this.f35307e = str;
            this.f35308f = z7;
        }

        public final CharSequence a() {
            return this.f35306d;
        }

        public final boolean b() {
            return this.f35308f;
        }

        public final int c() {
            return this.f35305c;
        }

        public final String d() {
            return this.f35304b;
        }

        public final String e() {
            return this.f35303a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PopupInfo) {
                PopupInfo popupInfo = (PopupInfo) obj;
                return Intrinsics.a(this.f35303a, popupInfo.f35303a) && Intrinsics.a(this.f35304b, popupInfo.f35304b) && this.f35305c == popupInfo.f35305c && Intrinsics.a(this.f35306d, popupInfo.f35306d) && Intrinsics.a(this.f35307e, popupInfo.f35307e) && this.f35308f == popupInfo.f35308f;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.f35303a.hashCode() * 31) + this.f35304b.hashCode()) * 31) + this.f35305c) * 31) + this.f35306d.hashCode()) * 31;
            String str = this.f35307e;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            boolean z7 = this.f35308f;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode2 + i8;
        }

        public String toString() {
            String str = this.f35303a;
            String str2 = this.f35304b;
            int i8 = this.f35305c;
            CharSequence charSequence = this.f35306d;
            String str3 = this.f35307e;
            boolean z7 = this.f35308f;
            return "PopupInfo(title=" + str + ", subtitle=" + str2 + ", subTitleColorRes=" + i8 + ", content=" + ((Object) charSequence) + ", dismissText=" + str3 + ", copyable=" + z7 + ")";
        }

        public /* synthetic */ PopupInfo(String str, String str2, int i8, CharSequence charSequence, String str3, boolean z7, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i8, charSequence, (i9 & 16) != 0 ? null : str3, z7);
        }
    }

    /* compiled from: GenericItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Payload {

        /* renamed from: a  reason: collision with root package name */
        private final Text f35292a;

        /* renamed from: b  reason: collision with root package name */
        private final Integer f35293b;

        /* renamed from: c  reason: collision with root package name */
        private final Color f35294c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f35295d;

        /* renamed from: e  reason: collision with root package name */
        private final Integer f35296e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f35297f;

        /* renamed from: g  reason: collision with root package name */
        private final ChevronState f35298g;

        /* renamed from: h  reason: collision with root package name */
        private final TextStyle f35299h;

        /* renamed from: i  reason: collision with root package name */
        private final Boolean f35300i;

        /* renamed from: j  reason: collision with root package name */
        private final PopupInfo f35301j;

        /* renamed from: k  reason: collision with root package name */
        private final Color f35302k;

        public Payload() {
            this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }

        public Payload(Text text, Integer num, Color color, Text text2, Integer num2, Color color2, ChevronState chevronState, TextStyle textStyle, Boolean bool, PopupInfo popupInfo, Color color3) {
            this.f35292a = text;
            this.f35293b = num;
            this.f35294c = color;
            this.f35295d = text2;
            this.f35296e = num2;
            this.f35297f = color2;
            this.f35298g = chevronState;
            this.f35299h = textStyle;
            this.f35300i = bool;
            this.f35301j = popupInfo;
            this.f35302k = color3;
        }

        public final Color a() {
            return this.f35302k;
        }

        public final ChevronState b() {
            return this.f35298g;
        }

        public final PopupInfo c() {
            return this.f35301j;
        }

        public final Boolean d() {
            return this.f35300i;
        }

        public final Text e() {
            return this.f35292a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Payload) {
                Payload payload = (Payload) obj;
                return Intrinsics.a(this.f35292a, payload.f35292a) && Intrinsics.a(this.f35293b, payload.f35293b) && Intrinsics.a(this.f35294c, payload.f35294c) && Intrinsics.a(this.f35295d, payload.f35295d) && Intrinsics.a(this.f35296e, payload.f35296e) && Intrinsics.a(this.f35297f, payload.f35297f) && this.f35298g == payload.f35298g && this.f35299h == payload.f35299h && Intrinsics.a(this.f35300i, payload.f35300i) && Intrinsics.a(this.f35301j, payload.f35301j) && Intrinsics.a(this.f35302k, payload.f35302k);
            }
            return false;
        }

        public final Color f() {
            return this.f35294c;
        }

        public final Integer g() {
            return this.f35293b;
        }

        public final Text h() {
            return this.f35295d;
        }

        public int hashCode() {
            Text text = this.f35292a;
            int hashCode = (text == null ? 0 : text.hashCode()) * 31;
            Integer num = this.f35293b;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Color color = this.f35294c;
            int hashCode3 = (hashCode2 + (color == null ? 0 : color.hashCode())) * 31;
            Text text2 = this.f35295d;
            int hashCode4 = (hashCode3 + (text2 == null ? 0 : text2.hashCode())) * 31;
            Integer num2 = this.f35296e;
            int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Color color2 = this.f35297f;
            int hashCode6 = (hashCode5 + (color2 == null ? 0 : color2.hashCode())) * 31;
            ChevronState chevronState = this.f35298g;
            int hashCode7 = (hashCode6 + (chevronState == null ? 0 : chevronState.hashCode())) * 31;
            TextStyle textStyle = this.f35299h;
            int hashCode8 = (hashCode7 + (textStyle == null ? 0 : textStyle.hashCode())) * 31;
            Boolean bool = this.f35300i;
            int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
            PopupInfo popupInfo = this.f35301j;
            int hashCode10 = (hashCode9 + (popupInfo == null ? 0 : popupInfo.hashCode())) * 31;
            Color color3 = this.f35302k;
            return hashCode10 + (color3 != null ? color3.hashCode() : 0);
        }

        public final Color i() {
            return this.f35297f;
        }

        public final Integer j() {
            return this.f35296e;
        }

        public final TextStyle k() {
            return this.f35299h;
        }

        public String toString() {
            Text text = this.f35292a;
            Integer num = this.f35293b;
            Color color = this.f35294c;
            Text text2 = this.f35295d;
            Integer num2 = this.f35296e;
            Color color2 = this.f35297f;
            ChevronState chevronState = this.f35298g;
            TextStyle textStyle = this.f35299h;
            Boolean bool = this.f35300i;
            PopupInfo popupInfo = this.f35301j;
            Color color3 = this.f35302k;
            return "Payload(titleText=" + text + ", titleTextSizeRes=" + num + ", titleTextColor=" + color + ", valueText=" + text2 + ", valueTextSizeRes=" + num2 + ", valueTextColor=" + color2 + ", chevronState=" + chevronState + ", valueTextStyle=" + textStyle + ", shouldShowPopupInfo=" + bool + ", popupInfo=" + popupInfo + ", backgroundColor=" + color3 + ")";
        }

        public /* synthetic */ Payload(Text text, Integer num, Color color, Text text2, Integer num2, Color color2, ChevronState chevronState, TextStyle textStyle, Boolean bool, PopupInfo popupInfo, Color color3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : text, (i8 & 2) != 0 ? null : num, (i8 & 4) != 0 ? null : color, (i8 & 8) != 0 ? null : text2, (i8 & 16) != 0 ? null : num2, (i8 & 32) != 0 ? null : color2, (i8 & 64) != 0 ? null : chevronState, (i8 & 128) != 0 ? null : textStyle, (i8 & Spliterator.NONNULL) != 0 ? null : bool, (i8 & 512) != 0 ? null : popupInfo, (i8 & Spliterator.IMMUTABLE) == 0 ? color3 : null);
        }
    }
}
