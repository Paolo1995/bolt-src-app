package ee.mtakso.driver.uicore.components.recyclerview.delegates.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ItemOptionTextDelegate.kt */
/* loaded from: classes5.dex */
public final class ItemOptionTextDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f35354b = R$layout.delegate_item_option_text;

    /* compiled from: ItemOptionTextDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f35361u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f35362v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f35362v = new LinkedHashMap();
            this.f35361u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f35362v;
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
            return this.f35361u;
        }
    }

    /* compiled from: ItemOptionTextDelegate.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35363a;

        static {
            int[] iArr = new int[ItemStyle.values().length];
            try {
                iArr[ItemStyle.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemStyle.ENCLOSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f35363a = iArr;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35354b;
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
        View inflate = inflater.inflate(R$layout.delegate_item_option_text, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…tion_text, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        int c8;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        int i8 = R$id.D0;
        ((TextView) holder.O(i8)).setText(model.o());
        Integer p8 = model.p();
        if (p8 != null) {
            TextViewCompat.o((TextView) holder.O(i8), p8.intValue());
        }
        TextView textView = (TextView) holder.O(i8);
        Intrinsics.e(textView, "holder.title");
        TextViewExtKt.i(textView, model.q());
        int i9 = WhenMappings.f35363a[model.n().ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                c8 = Dimens.c(24);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            c8 = Dimens.c(2);
        }
        ViewGroup.LayoutParams layoutParams = ((TextView) holder.O(i8)).getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = c8;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: ItemOptionTextDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35355a;

        /* renamed from: b  reason: collision with root package name */
        private final String f35356b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f35357c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f35358d;

        /* renamed from: e  reason: collision with root package name */
        private final ItemStyle f35359e;

        /* renamed from: f  reason: collision with root package name */
        private final DividerModel f35360f;

        public /* synthetic */ Model(String str, String str2, Integer num, Color color, ItemStyle itemStyle, DividerModel dividerModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i8 & 4) != 0 ? null : num, (i8 & 8) != 0 ? null : color, (i8 & 16) != 0 ? ItemStyle.SIMPLE : itemStyle, (i8 & 32) != 0 ? NoDivider.f34829a : dividerModel);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f35360f.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f35360f.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35356b, model.f35356b) && Intrinsics.a(this.f35357c, model.f35357c) && Intrinsics.a(this.f35358d, model.f35358d) && this.f35359e == model.f35359e && Intrinsics.a(this.f35360f, model.f35360f);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f35360f.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((m().hashCode() * 31) + this.f35356b.hashCode()) * 31;
            Integer num = this.f35357c;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Color color = this.f35358d;
            return ((((hashCode2 + (color != null ? color.hashCode() : 0)) * 31) + this.f35359e.hashCode()) * 31) + this.f35360f.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f35360f.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f35360f.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f35360f.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35355a;
        }

        public final ItemStyle n() {
            return this.f35359e;
        }

        public final String o() {
            return this.f35356b;
        }

        public final Integer p() {
            return this.f35357c;
        }

        public final Color q() {
            return this.f35358d;
        }

        public String toString() {
            String m8 = m();
            String str = this.f35356b;
            Integer num = this.f35357c;
            Color color = this.f35358d;
            ItemStyle itemStyle = this.f35359e;
            DividerModel dividerModel = this.f35360f;
            return "Model(listId=" + m8 + ", text=" + str + ", textAppearance=" + num + ", textColor=" + color + ", style=" + itemStyle + ", divider=" + dividerModel + ")";
        }

        public Model(String listId, String text, Integer num, Color color, ItemStyle style, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(text, "text");
            Intrinsics.f(style, "style");
            Intrinsics.f(divider, "divider");
            this.f35355a = listId;
            this.f35356b = text;
            this.f35357c = num;
            this.f35358d = color;
            this.f35359e = style;
            this.f35360f = divider;
        }
    }
}
