package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
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
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import j$.util.Spliterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MenuToggleDelegate.kt */
/* loaded from: classes5.dex */
public final class MenuToggleDelegate<T> extends DiffAdapterDelegate<ViewHolder, Model<T>> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model<T>, Unit> f34993b;

    /* renamed from: c  reason: collision with root package name */
    private final Function2<Model<T>, Boolean, Unit> f34994c;

    /* renamed from: d  reason: collision with root package name */
    private final int f34995d;

    /* compiled from: MenuToggleDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f35008u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f35009v;

        /* renamed from: w  reason: collision with root package name */
        private final ImageView f35010w;

        /* renamed from: x  reason: collision with root package name */
        private final SwitchCompat f35011x;

        /* renamed from: y  reason: collision with root package name */
        private final View f35012y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.R);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f35008u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.valueText);
            Intrinsics.d(appCompatTextView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f35009v = appCompatTextView2;
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R$id.leftIcon);
            Intrinsics.d(appCompatImageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f35010w = appCompatImageView;
            SwitchCompat switchCompat = (SwitchCompat) itemView.findViewById(R$id.toggle);
            Intrinsics.d(switchCompat, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
            this.f35011x = switchCompat;
            ConstraintLayout constraintLayout = (ConstraintLayout) itemView.findViewById(R$id.viewRoot);
            Intrinsics.d(constraintLayout, "null cannot be cast to non-null type android.view.View");
            this.f35012y = constraintLayout;
        }

        public final TextView O() {
            return this.f35008u;
        }

        public final ImageView P() {
            return this.f35010w;
        }

        public final View Q() {
            return this.f35012y;
        }

        public final SwitchCompat R() {
            return this.f35011x;
        }

        public final TextView S() {
            return this.f35009v;
        }
    }

    public MenuToggleDelegate() {
        this(null, null, 3, null);
    }

    public /* synthetic */ MenuToggleDelegate(Function1 function1, Function2 function2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new Function1<Model<T>, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.MenuToggleDelegate.1
            public final void b(Model<T> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b((Model) obj);
                return Unit.f50853a;
            }
        } : function1, (i8 & 2) != 0 ? new Function2<Model<T>, Boolean, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.MenuToggleDelegate.2
            public final void b(Model<T> model, boolean z7) {
                Intrinsics.f(model, "model");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(Object obj, Boolean bool) {
                b((Model) obj, bool.booleanValue());
                return Unit.f50853a;
            }
        } : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(MenuToggleDelegate this$0, Model model, CompoundButton compoundButton, boolean z7) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f34994c.s(model, Boolean.valueOf(z7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(MenuToggleDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f34993b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34995d;
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
    public void g(ViewHolder holder, final Model<T> model) {
        boolean z7;
        boolean z8;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextView O = holder.O();
        boolean z9 = true;
        if (model.o() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(O, z7, 0, 2, null);
        TextView O2 = holder.O();
        CharSequence o8 = model.o();
        CharSequence charSequence = "";
        if (o8 == null) {
            o8 = "";
        }
        O2.setText(o8);
        TextViewExtKt.i(holder.O(), model.p());
        TextView S = holder.S();
        if (model.r() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.e(S, z8, 0, 2, null);
        TextView S2 = holder.S();
        CharSequence r7 = model.r();
        if (r7 != null) {
            charSequence = r7;
        }
        S2.setText(charSequence);
        TextViewExtKt.i(holder.S(), model.s());
        ImageView P = holder.P();
        if (model.q() == null) {
            z9 = false;
        }
        ViewExtKt.e(P, z9, 0, 2, null);
        if (model.q() != null) {
            holder.P().setImageResource(model.q().intValue());
        }
        holder.R().setOnCheckedChangeListener(null);
        holder.R().setChecked(model.t());
        holder.R().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                MenuToggleDelegate.v(MenuToggleDelegate.this, model, compoundButton, z10);
            }
        });
        holder.Q().setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuToggleDelegate.w(MenuToggleDelegate.this, model, view);
            }
        });
        Color n8 = model.n();
        Context context = holder.Q().getContext();
        Intrinsics.e(context, "messageRoot.context");
        int a8 = ColorKt.a(n8, context);
        holder.Q().setBackgroundColor(a8);
        RippleProvider.b(RippleProvider.f35730a, holder.Q(), a8, 0, 2, null);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: x */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: MenuToggleDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model<T> extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34998a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f34999b;

        /* renamed from: c  reason: collision with root package name */
        private final Color f35000c;

        /* renamed from: d  reason: collision with root package name */
        private final CharSequence f35001d;

        /* renamed from: e  reason: collision with root package name */
        private final Color f35002e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f35003f;

        /* renamed from: g  reason: collision with root package name */
        private final Integer f35004g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f35005h;

        /* renamed from: i  reason: collision with root package name */
        private final T f35006i;

        /* renamed from: j  reason: collision with root package name */
        private final DividerModel f35007j;

        public /* synthetic */ Model(String str, CharSequence charSequence, Color color, CharSequence charSequence2, Color color2, boolean z7, Integer num, Color color3, Object obj, DividerModel dividerModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : charSequence, (i8 & 4) != 0 ? null : color, (i8 & 8) != 0 ? null : charSequence2, (i8 & 16) != 0 ? null : color2, z7, (i8 & 64) != 0 ? null : num, (i8 & 128) != 0 ? new Color.Res(R$color.f34587l) : color3, (i8 & Spliterator.NONNULL) != 0 ? null : obj, dividerModel);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f35007j.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f35007j.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f34999b, model.f34999b) && Intrinsics.a(this.f35000c, model.f35000c) && Intrinsics.a(this.f35001d, model.f35001d) && Intrinsics.a(this.f35002e, model.f35002e) && this.f35003f == model.f35003f && Intrinsics.a(this.f35004g, model.f35004g) && Intrinsics.a(this.f35005h, model.f35005h) && Intrinsics.a(this.f35006i, model.f35006i) && Intrinsics.a(this.f35007j, model.f35007j);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f35007j.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            CharSequence charSequence = this.f34999b;
            int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            Color color = this.f35000c;
            int hashCode3 = (hashCode2 + (color == null ? 0 : color.hashCode())) * 31;
            CharSequence charSequence2 = this.f35001d;
            int hashCode4 = (hashCode3 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            Color color2 = this.f35002e;
            int hashCode5 = (hashCode4 + (color2 == null ? 0 : color2.hashCode())) * 31;
            boolean z7 = this.f35003f;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode5 + i8) * 31;
            Integer num = this.f35004g;
            int hashCode6 = (((i9 + (num == null ? 0 : num.hashCode())) * 31) + this.f35005h.hashCode()) * 31;
            T t7 = this.f35006i;
            return ((hashCode6 + (t7 != null ? t7.hashCode() : 0)) * 31) + this.f35007j.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f35007j.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f35007j.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f35007j.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34998a;
        }

        public final Color n() {
            return this.f35005h;
        }

        public final CharSequence o() {
            return this.f34999b;
        }

        public final Color p() {
            return this.f35000c;
        }

        public final Integer q() {
            return this.f35004g;
        }

        public final CharSequence r() {
            return this.f35001d;
        }

        public final Color s() {
            return this.f35002e;
        }

        public final boolean t() {
            return this.f35003f;
        }

        public String toString() {
            String m8 = m();
            CharSequence charSequence = this.f34999b;
            Color color = this.f35000c;
            CharSequence charSequence2 = this.f35001d;
            Color color2 = this.f35002e;
            boolean z7 = this.f35003f;
            Integer num = this.f35004g;
            Color color3 = this.f35005h;
            T t7 = this.f35006i;
            DividerModel dividerModel = this.f35007j;
            return "Model(listId=" + m8 + ", keyText=" + ((Object) charSequence) + ", keyTextColor=" + color + ", valueText=" + ((Object) charSequence2) + ", valueTextColor=" + color2 + ", isChecked=" + z7 + ", leftIcon=" + num + ", backgroundColor=" + color3 + ", payload=" + t7 + ", divider=" + dividerModel + ")";
        }

        public Model(String listId, CharSequence charSequence, Color color, CharSequence charSequence2, Color color2, boolean z7, Integer num, Color backgroundColor, T t7, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(backgroundColor, "backgroundColor");
            Intrinsics.f(divider, "divider");
            this.f34998a = listId;
            this.f34999b = charSequence;
            this.f35000c = color;
            this.f35001d = charSequence2;
            this.f35002e = color2;
            this.f35003f = z7;
            this.f35004g = num;
            this.f35005h = backgroundColor;
            this.f35006i = t7;
            this.f35007j = divider;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuToggleDelegate(Function1<? super Model<T>, Unit> onInfoClick, Function2<? super Model<T>, ? super Boolean, Unit> onToggled) {
        Intrinsics.f(onInfoClick, "onInfoClick");
        Intrinsics.f(onToggled, "onToggled");
        this.f34993b = onInfoClick;
        this.f34994c = onToggled;
        this.f34995d = R$layout.delegate_menu_toggle;
    }
}
