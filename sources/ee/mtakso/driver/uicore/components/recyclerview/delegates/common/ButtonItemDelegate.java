package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import j$.util.Spliterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ButtonItemDelegate.kt */
/* loaded from: classes5.dex */
public final class ButtonItemDelegate<T> extends DiffAdapterDelegate<ViewHolder, Model<T>> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model<T>, Unit> f34919b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34920c;

    /* compiled from: ButtonItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final RoundButton f34940u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            RoundButton roundButton = (RoundButton) itemView.findViewById(R$id.f34593e);
            Intrinsics.d(roundButton, "null cannot be cast to non-null type ee.mtakso.driver.uikit.widgets.RoundButton");
            this.f34940u = roundButton;
        }

        public final RoundButton O() {
            return this.f34940u;
        }
    }

    public ButtonItemDelegate() {
        this(null, 1, null);
    }

    public /* synthetic */ ButtonItemDelegate(Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new Function1<Model<T>, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate.1
            public final void b(Model<T> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b((Model) obj);
                return Unit.f50853a;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ButtonItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f34919b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34920c;
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
        CharSequence charSequence;
        int i8;
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        RoundButton O = holder.O();
        Text w7 = model.w();
        if (w7 != null) {
            Context context = O.getContext();
            Intrinsics.e(context, "context");
            charSequence = TextKt.a(w7, context);
        } else {
            charSequence = null;
        }
        O.setText(charSequence);
        UiKitRoundButtonTypeKt.a(O, model.u());
        UiKitRoundButtonTypeKt.b(O, model.v());
        Integer p8 = model.p();
        if (p8 != null) {
            O.b(p8.intValue());
        }
        O.setIconTint(model.q());
        O.setTag(model.t());
        O.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ButtonItemDelegate.u(ButtonItemDelegate.this, model, view);
            }
        });
        ViewGroup.LayoutParams layoutParams = O.getLayoutParams();
        if (model.x()) {
            i8 = -1;
        } else {
            i8 = -2;
        }
        layoutParams.width = i8;
        Integer s7 = model.s();
        if (s7 != null) {
            O.setMaxWidthConstraint(s7.intValue());
        }
        Margins r7 = model.r();
        if (r7 != null) {
            ViewGroup.LayoutParams layoutParams2 = O.getLayoutParams();
            Intrinsics.d(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams.leftMargin = r7.b();
            marginLayoutParams.topMargin = r7.d();
            marginLayoutParams.rightMargin = r7.c();
            marginLayoutParams.bottomMargin = r7.a();
        }
        Boolean o8 = model.o();
        if (o8 != null) {
            z7 = o8.booleanValue();
        } else {
            z7 = true;
        }
        O.setEnabled(z7);
        Color n8 = model.n();
        if (n8 != null) {
            View view = holder.f7332a;
            Context context2 = view.getContext();
            Intrinsics.e(context2, "holder.itemView.context");
            view.setBackgroundColor(ColorKt.a(n8, context2));
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ButtonItemDelegate(Function1<? super Model<T>, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f34919b = onClick;
        this.f34920c = R$layout.delegate_button;
    }

    /* compiled from: ButtonItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model<T> extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34922a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f34923b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f34924c;

        /* renamed from: d  reason: collision with root package name */
        private final Integer f34925d;

        /* renamed from: e  reason: collision with root package name */
        private final UiKitRoundButtonSize f34926e;

        /* renamed from: f  reason: collision with root package name */
        private final UiKitRoundButtonType f34927f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f34928g;

        /* renamed from: h  reason: collision with root package name */
        private final Boolean f34929h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f34930i;

        /* renamed from: j  reason: collision with root package name */
        private final Integer f34931j;

        /* renamed from: k  reason: collision with root package name */
        private final Margins f34932k;

        /* renamed from: l  reason: collision with root package name */
        private final T f34933l;

        /* renamed from: m  reason: collision with root package name */
        private final boolean f34934m;

        /* renamed from: n  reason: collision with root package name */
        private final Color f34935n;

        /* renamed from: o  reason: collision with root package name */
        private final Color f34936o;

        /* renamed from: p  reason: collision with root package name */
        private final float f34937p;

        /* renamed from: q  reason: collision with root package name */
        private final boolean f34938q;

        /* renamed from: r  reason: collision with root package name */
        private final boolean f34939r;

        public /* synthetic */ Model(String str, Text text, Integer num, Integer num2, UiKitRoundButtonSize uiKitRoundButtonSize, UiKitRoundButtonType uiKitRoundButtonType, Color color, Boolean bool, boolean z7, Integer num3, Margins margins, Object obj, boolean z8, Color color2, Color color3, float f8, boolean z9, boolean z10, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : text, (i8 & 4) != 0 ? null : num, (i8 & 8) != 0 ? null : num2, (i8 & 16) != 0 ? UiKitRoundButtonSize.f36156j : uiKitRoundButtonSize, uiKitRoundButtonType, (i8 & 64) != 0 ? null : color, (i8 & 128) != 0 ? null : bool, (i8 & Spliterator.NONNULL) != 0 ? false : z7, (i8 & 512) != 0 ? null : num3, (i8 & Spliterator.IMMUTABLE) != 0 ? null : margins, (i8 & 2048) != 0 ? null : obj, (i8 & 4096) != 0 ? true : z8, (i8 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? new Color.Res(R$color.neutral200) : color2, (i8 & 16384) != 0 ? null : color3, (32768 & i8) != 0 ? Dimens.c(1.0f) : f8, (65536 & i8) != 0 ? false : z9, (i8 & 131072) != 0 ? false : z10);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f34935n;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f34934m;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f34923b, model.f34923b) && Intrinsics.a(this.f34924c, model.f34924c) && Intrinsics.a(this.f34925d, model.f34925d) && this.f34926e == model.f34926e && this.f34927f == model.f34927f && Intrinsics.a(this.f34928g, model.f34928g) && Intrinsics.a(this.f34929h, model.f34929h) && this.f34930i == model.f34930i && Intrinsics.a(this.f34931j, model.f34931j) && Intrinsics.a(this.f34932k, model.f34932k) && Intrinsics.a(this.f34933l, model.f34933l) && e() == model.e() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Float.compare(i().floatValue(), model.i().floatValue()) == 0 && j() == model.j() && k() == model.k();
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f34936o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f34923b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Integer num = this.f34924c;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.f34925d;
            int hashCode4 = (((((hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.f34926e.hashCode()) * 31) + this.f34927f.hashCode()) * 31;
            Color color = this.f34928g;
            int hashCode5 = (hashCode4 + (color == null ? 0 : color.hashCode())) * 31;
            Boolean bool = this.f34929h;
            int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
            boolean z7 = this.f34930i;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode6 + i8) * 31;
            Integer num3 = this.f34931j;
            int hashCode7 = (i9 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Margins margins = this.f34932k;
            int hashCode8 = (hashCode7 + (margins == null ? 0 : margins.hashCode())) * 31;
            T t7 = this.f34933l;
            int hashCode9 = (hashCode8 + (t7 == null ? 0 : t7.hashCode())) * 31;
            boolean e8 = e();
            int i10 = e8;
            if (e8 != 0) {
                i10 = 1;
            }
            int hashCode10 = (((((((hashCode9 + i10) * 31) + (d() == null ? 0 : d().hashCode())) * 31) + (f() != null ? f().hashCode() : 0)) * 31) + i().hashCode()) * 31;
            boolean j8 = j();
            int i11 = j8;
            if (j8 != 0) {
                i11 = 1;
            }
            int i12 = (hashCode10 + i11) * 31;
            boolean k8 = k();
            return i12 + (k8 ? 1 : k8 ? 1 : 0);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return Float.valueOf(this.f34937p);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f34938q;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f34939r;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34922a;
        }

        public final Color n() {
            return this.f34928g;
        }

        public final Boolean o() {
            return this.f34929h;
        }

        public final Integer p() {
            return this.f34924c;
        }

        public final Integer q() {
            return this.f34925d;
        }

        public final Margins r() {
            return this.f34932k;
        }

        public final Integer s() {
            return this.f34931j;
        }

        public final T t() {
            return this.f34933l;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f34923b;
            Integer num = this.f34924c;
            Integer num2 = this.f34925d;
            UiKitRoundButtonSize uiKitRoundButtonSize = this.f34926e;
            UiKitRoundButtonType uiKitRoundButtonType = this.f34927f;
            Color color = this.f34928g;
            Boolean bool = this.f34929h;
            boolean z7 = this.f34930i;
            Integer num3 = this.f34931j;
            Margins margins = this.f34932k;
            T t7 = this.f34933l;
            boolean e8 = e();
            Color d8 = d();
            Color f8 = f();
            Float i8 = i();
            boolean j8 = j();
            boolean k8 = k();
            return "Model(listId=" + m8 + ", text=" + text + ", icon=" + num + ", iconTint=" + num2 + ", roundButtonUiKitSize=" + uiKitRoundButtonSize + ", roundButtonUiKitType=" + uiKitRoundButtonType + ", background=" + color + ", enabled=" + bool + ", isFullWidth=" + z7 + ", maxWidth=" + num3 + ", margins=" + margins + ", payload=" + t7 + ", isDividerEnabled=" + e8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ")";
        }

        public final UiKitRoundButtonSize u() {
            return this.f34926e;
        }

        public final UiKitRoundButtonType v() {
            return this.f34927f;
        }

        public final Text w() {
            return this.f34923b;
        }

        public final boolean x() {
            return this.f34930i;
        }

        public Model(String listId, Text text, Integer num, Integer num2, UiKitRoundButtonSize roundButtonUiKitSize, UiKitRoundButtonType roundButtonUiKitType, Color color, Boolean bool, boolean z7, Integer num3, Margins margins, T t7, boolean z8, Color color2, Color color3, float f8, boolean z9, boolean z10) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(roundButtonUiKitSize, "roundButtonUiKitSize");
            Intrinsics.f(roundButtonUiKitType, "roundButtonUiKitType");
            this.f34922a = listId;
            this.f34923b = text;
            this.f34924c = num;
            this.f34925d = num2;
            this.f34926e = roundButtonUiKitSize;
            this.f34927f = roundButtonUiKitType;
            this.f34928g = color;
            this.f34929h = bool;
            this.f34930i = z7;
            this.f34931j = num3;
            this.f34932k = margins;
            this.f34933l = t7;
            this.f34934m = z8;
            this.f34935n = color2;
            this.f34936o = color3;
            this.f34937p = f8;
            this.f34938q = z9;
            this.f34939r = z10;
        }
    }
}
