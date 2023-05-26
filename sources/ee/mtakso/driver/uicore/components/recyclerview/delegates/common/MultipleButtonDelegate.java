package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayout;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Padding;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import j$.util.Spliterator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultipleButtonDelegate.kt */
/* loaded from: classes5.dex */
public final class MultipleButtonDelegate<T> extends DiffAdapterDelegate<ViewHolder, Model<T>> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<ButtonModel<T>, Unit> f35013b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35014c;

    /* compiled from: MultipleButtonDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final FlexboxLayout f35032u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            FlexboxLayout flexboxLayout = (FlexboxLayout) itemView.findViewById(R$id.buttonFlexBox);
            Intrinsics.d(flexboxLayout, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayout");
            this.f35032u = flexboxLayout;
        }

        public final FlexboxLayout O() {
            return this.f35032u;
        }
    }

    public MultipleButtonDelegate() {
        this(null, 1, null);
    }

    public /* synthetic */ MultipleButtonDelegate(Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new Function1<ButtonModel<T>, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.MultipleButtonDelegate.1
            public final void b(ButtonModel<T> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b((ButtonModel) obj);
                return Unit.f50853a;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MultipleButtonDelegate this$0, ButtonModel buttonModel, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(buttonModel, "$buttonModel");
        this$0.f35013b.invoke(buttonModel);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35014c;
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
    public void g(ViewHolder holder, Model<T> model) {
        CharSequence charSequence;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Iterator<T> it = model.n().iterator();
        while (it.hasNext()) {
            final ButtonModel buttonModel = (ButtonModel) it.next();
            View inflate = LayoutInflater.from(holder.O().getContext()).inflate(R$layout.delagate_item_button_icon_labeled, (ViewGroup) holder.O(), false);
            Intrinsics.d(inflate, "null cannot be cast to non-null type ee.mtakso.driver.uikit.widgets.RoundButton");
            RoundButton roundButton = (RoundButton) inflate;
            Text j8 = buttonModel.j();
            if (j8 != null) {
                Context context = roundButton.getContext();
                Intrinsics.e(context, "context");
                charSequence = TextKt.a(j8, context);
            } else {
                charSequence = null;
            }
            roundButton.setText(charSequence);
            Integer a8 = buttonModel.a();
            if (a8 != null) {
                roundButton.b(a8.intValue());
            }
            Integer d8 = buttonModel.d();
            if (d8 != null) {
                roundButton.setImageSize(d8.intValue());
            }
            Padding c8 = buttonModel.c();
            if (c8 != null) {
                roundButton.setImagePadding(c8);
            }
            UiKitRoundButtonTypeKt.a(roundButton, buttonModel.h());
            UiKitRoundButtonTypeKt.b(roundButton, buttonModel.i());
            roundButton.setIconTint(buttonModel.b());
            Integer k8 = buttonModel.k();
            if (k8 != null) {
                roundButton.setTextAppearance(k8.intValue());
            }
            Color l8 = buttonModel.l();
            if (l8 != null) {
                Context context2 = roundButton.getContext();
                Intrinsics.e(context2, "context");
                roundButton.setTextColor(ColorKt.a(l8, context2));
            }
            Integer f8 = buttonModel.f();
            if (f8 != null) {
                roundButton.setMaxWidthConstraint(f8.intValue());
            }
            roundButton.setTag(buttonModel.g());
            roundButton.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MultipleButtonDelegate.u(MultipleButtonDelegate.this, buttonModel, view);
                }
            });
            Margins e8 = buttonModel.e();
            if (e8 != null) {
                ViewGroup.LayoutParams layoutParams = roundButton.getLayoutParams();
                Intrinsics.d(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = e8.b();
                marginLayoutParams.topMargin = e8.d();
                marginLayoutParams.rightMargin = e8.c();
                marginLayoutParams.bottomMargin = e8.a();
            }
            holder.O().addView(roundButton);
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: MultipleButtonDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model<T> extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35029a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ButtonModel<T>> f35030b;

        /* renamed from: c  reason: collision with root package name */
        private final DividerModel f35031c;

        public /* synthetic */ Model(String str, List list, DividerModel dividerModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, (i8 & 4) != 0 ? NoDivider.f34829a : dividerModel);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35030b, model.f35030b) && Intrinsics.a(this.f35031c, model.f35031c);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (((m().hashCode() * 31) + this.f35030b.hashCode()) * 31) + this.f35031c.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35029a;
        }

        public final List<ButtonModel<T>> n() {
            return this.f35030b;
        }

        public String toString() {
            String m8 = m();
            List<ButtonModel<T>> list = this.f35030b;
            DividerModel dividerModel = this.f35031c;
            return "Model(listId=" + m8 + ", buttons=" + list + ", divider=" + dividerModel + ")";
        }

        public Model(String listId, List<ButtonModel<T>> buttons, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(buttons, "buttons");
            Intrinsics.f(divider, "divider");
            this.f35029a = listId;
            this.f35030b = buttons;
            this.f35031c = divider;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultipleButtonDelegate(Function1<? super ButtonModel<T>, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f35013b = onClick;
        this.f35014c = R$layout.delegate_mulitple_button_item;
    }

    /* compiled from: MultipleButtonDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ButtonModel<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Text f35016a;

        /* renamed from: b  reason: collision with root package name */
        private final Color f35017b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f35018c;

        /* renamed from: d  reason: collision with root package name */
        private final Integer f35019d;

        /* renamed from: e  reason: collision with root package name */
        private final UiKitRoundButtonSize f35020e;

        /* renamed from: f  reason: collision with root package name */
        private final UiKitRoundButtonType f35021f;

        /* renamed from: g  reason: collision with root package name */
        private final Integer f35022g;

        /* renamed from: h  reason: collision with root package name */
        private final Integer f35023h;

        /* renamed from: i  reason: collision with root package name */
        private final Color f35024i;

        /* renamed from: j  reason: collision with root package name */
        private final Margins f35025j;

        /* renamed from: k  reason: collision with root package name */
        private final Integer f35026k;

        /* renamed from: l  reason: collision with root package name */
        private final Padding f35027l;

        /* renamed from: m  reason: collision with root package name */
        private final T f35028m;

        public ButtonModel(Text text, Color color, Integer num, Integer num2, UiKitRoundButtonSize roundButtonUiKitSize, UiKitRoundButtonType roundButtonUiKitType, Integer num3, Integer num4, Color background, Margins margins, Integer num5, Padding padding, T t7) {
            Intrinsics.f(roundButtonUiKitSize, "roundButtonUiKitSize");
            Intrinsics.f(roundButtonUiKitType, "roundButtonUiKitType");
            Intrinsics.f(background, "background");
            this.f35016a = text;
            this.f35017b = color;
            this.f35018c = num;
            this.f35019d = num2;
            this.f35020e = roundButtonUiKitSize;
            this.f35021f = roundButtonUiKitType;
            this.f35022g = num3;
            this.f35023h = num4;
            this.f35024i = background;
            this.f35025j = margins;
            this.f35026k = num5;
            this.f35027l = padding;
            this.f35028m = t7;
        }

        public final Integer a() {
            return this.f35018c;
        }

        public final Integer b() {
            return this.f35019d;
        }

        public final Padding c() {
            return this.f35027l;
        }

        public final Integer d() {
            return this.f35026k;
        }

        public final Margins e() {
            return this.f35025j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ButtonModel) {
                ButtonModel buttonModel = (ButtonModel) obj;
                return Intrinsics.a(this.f35016a, buttonModel.f35016a) && Intrinsics.a(this.f35017b, buttonModel.f35017b) && Intrinsics.a(this.f35018c, buttonModel.f35018c) && Intrinsics.a(this.f35019d, buttonModel.f35019d) && this.f35020e == buttonModel.f35020e && this.f35021f == buttonModel.f35021f && Intrinsics.a(this.f35022g, buttonModel.f35022g) && Intrinsics.a(this.f35023h, buttonModel.f35023h) && Intrinsics.a(this.f35024i, buttonModel.f35024i) && Intrinsics.a(this.f35025j, buttonModel.f35025j) && Intrinsics.a(this.f35026k, buttonModel.f35026k) && Intrinsics.a(this.f35027l, buttonModel.f35027l) && Intrinsics.a(this.f35028m, buttonModel.f35028m);
            }
            return false;
        }

        public final Integer f() {
            return this.f35023h;
        }

        public final T g() {
            return this.f35028m;
        }

        public final UiKitRoundButtonSize h() {
            return this.f35020e;
        }

        public int hashCode() {
            Text text = this.f35016a;
            int hashCode = (text == null ? 0 : text.hashCode()) * 31;
            Color color = this.f35017b;
            int hashCode2 = (hashCode + (color == null ? 0 : color.hashCode())) * 31;
            Integer num = this.f35018c;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.f35019d;
            int hashCode4 = (((((hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.f35020e.hashCode()) * 31) + this.f35021f.hashCode()) * 31;
            Integer num3 = this.f35022g;
            int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.f35023h;
            int hashCode6 = (((hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31) + this.f35024i.hashCode()) * 31;
            Margins margins = this.f35025j;
            int hashCode7 = (hashCode6 + (margins == null ? 0 : margins.hashCode())) * 31;
            Integer num5 = this.f35026k;
            int hashCode8 = (hashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Padding padding = this.f35027l;
            int hashCode9 = (hashCode8 + (padding == null ? 0 : padding.hashCode())) * 31;
            T t7 = this.f35028m;
            return hashCode9 + (t7 != null ? t7.hashCode() : 0);
        }

        public final UiKitRoundButtonType i() {
            return this.f35021f;
        }

        public final Text j() {
            return this.f35016a;
        }

        public final Integer k() {
            return this.f35022g;
        }

        public final Color l() {
            return this.f35017b;
        }

        public String toString() {
            Text text = this.f35016a;
            Color color = this.f35017b;
            Integer num = this.f35018c;
            Integer num2 = this.f35019d;
            UiKitRoundButtonSize uiKitRoundButtonSize = this.f35020e;
            UiKitRoundButtonType uiKitRoundButtonType = this.f35021f;
            Integer num3 = this.f35022g;
            Integer num4 = this.f35023h;
            Color color2 = this.f35024i;
            Margins margins = this.f35025j;
            Integer num5 = this.f35026k;
            Padding padding = this.f35027l;
            T t7 = this.f35028m;
            return "ButtonModel(text=" + text + ", textColor=" + color + ", icon=" + num + ", iconTint=" + num2 + ", roundButtonUiKitSize=" + uiKitRoundButtonSize + ", roundButtonUiKitType=" + uiKitRoundButtonType + ", textAppearance=" + num3 + ", maxWidth=" + num4 + ", background=" + color2 + ", margins=" + margins + ", imageSize=" + num5 + ", imagePadding=" + padding + ", payload=" + t7 + ")";
        }

        public /* synthetic */ ButtonModel(Text text, Color color, Integer num, Integer num2, UiKitRoundButtonSize uiKitRoundButtonSize, UiKitRoundButtonType uiKitRoundButtonType, Integer num3, Integer num4, Color color2, Margins margins, Integer num5, Padding padding, Object obj, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : text, (i8 & 2) != 0 ? null : color, (i8 & 4) != 0 ? null : num, (i8 & 8) != 0 ? null : num2, (i8 & 16) != 0 ? UiKitRoundButtonSize.f36156j : uiKitRoundButtonSize, uiKitRoundButtonType, (i8 & 64) != 0 ? null : num3, (i8 & 128) != 0 ? null : num4, (i8 & Spliterator.NONNULL) != 0 ? new Color.Attr(R$attr.f34574d) : color2, (i8 & 512) != 0 ? null : margins, (i8 & Spliterator.IMMUTABLE) != 0 ? null : num5, padding, (i8 & 4096) != 0 ? null : obj);
        }
    }
}
