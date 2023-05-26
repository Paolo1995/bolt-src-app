package ee.mtakso.driver.uicore.components.recyclerview.delegates.list;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DepthModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemOneLineDelegate;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.ImageViewExtKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import j$.util.Spliterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ItemOneLineDelegate.kt */
/* loaded from: classes5.dex */
public final class ItemOneLineDelegate<T> extends DiffAdapterDelegate<ViewHolder, Model<T>> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<T, Unit> f35330b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35331c;

    /* compiled from: ItemOneLineDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f35352u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f35353v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f35353v = new LinkedHashMap();
            this.f35352u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f35353v;
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
            return this.f35352u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemOneLineDelegate(Function1<? super T, Unit> onClicked) {
        Intrinsics.f(onClicked, "onClicked");
        this.f35330b = onClicked;
        this.f35331c = R$layout.delegate_item_one_line;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void u(ItemOneLineDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35330b.invoke(model.v());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35331c;
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
        View inflate = inflater.inflate(R$layout.delegate_item_one_line, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…_one_line, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model<T> model) {
        boolean z7;
        boolean z8;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.f7332a.getContext();
        int i8 = R$id.C;
        ImageView imageView = (ImageView) holder.O(i8);
        Intrinsics.e(imageView, "holder.icon");
        boolean z9 = true;
        if (model.p() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ColorStateList colorStateList = null;
        ViewExtKt.e(imageView, z7, 0, 2, null);
        Image p8 = model.p();
        if (p8 != null) {
            ImageView imageView2 = (ImageView) holder.O(i8);
            Intrinsics.e(imageView2, "holder.icon");
            ImageKt.b(p8, imageView2, null, 2, null);
        }
        ImageView imageView3 = (ImageView) holder.O(i8);
        Intrinsics.e(imageView3, "holder.icon");
        ImageViewExtKt.a(imageView3, model.q());
        int i9 = R$id.D0;
        TextView textView = (TextView) holder.O(i9);
        Intrinsics.e(textView, "holder.title");
        TextViewExtKt.h(textView, model.B());
        Integer C = model.C();
        if (C != null) {
            TextViewCompat.o((TextView) holder.O(i9), C.intValue());
        }
        TextView textView2 = (TextView) holder.O(i9);
        Intrinsics.e(textView2, "holder.title");
        TextViewExtKt.i(textView2, model.D());
        TextView textView3 = (TextView) holder.O(i9);
        Intrinsics.e(textView3, "holder.title");
        ee.mtakso.driver.uikit.utils.ViewExtKt.f(textView3, null, Integer.valueOf(model.u()), null, Integer.valueOf(model.t()), 5, null);
        int i10 = R$id.infoIcon;
        ImageView imageView4 = (ImageView) holder.O(i10);
        Intrinsics.e(imageView4, "holder.infoIcon");
        ViewExtKt.e(imageView4, model.s(), 0, 2, null);
        ImageView imageView5 = (ImageView) holder.O(i10);
        Intrinsics.e(imageView5, "holder.infoIcon");
        ImageViewExtKt.a(imageView5, model.r());
        int i11 = R$id.secondaryText;
        TextView textView4 = (TextView) holder.O(i11);
        Intrinsics.e(textView4, "holder.secondaryText");
        if (model.y() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.e(textView4, z8, 0, 2, null);
        TextView textView5 = (TextView) holder.O(i11);
        Intrinsics.e(textView5, "holder.secondaryText");
        TextViewExtKt.h(textView5, model.y());
        Integer z10 = model.z();
        if (z10 != null) {
            TextViewCompat.o((TextView) holder.O(i11), z10.intValue());
        }
        int i12 = R$id.f34596i0;
        ImageView imageView6 = (ImageView) holder.O(i12);
        Intrinsics.e(imageView6, "holder.secondaryIcon");
        if (model.w() == null) {
            z9 = false;
        }
        ViewExtKt.e(imageView6, z9, 0, 2, null);
        Image w7 = model.w();
        if (w7 != null) {
            ImageView imageView7 = (ImageView) holder.O(i12);
            Intrinsics.e(imageView7, "holder.secondaryIcon");
            ImageKt.b(w7, imageView7, null, 2, null);
        }
        ImageView imageView8 = (ImageView) holder.O(i12);
        Color x7 = model.x();
        if (x7 != null) {
            Intrinsics.e(context, "context");
            colorStateList = ColorKt.b(x7, context);
        }
        ImageViewCompat.c(imageView8, colorStateList);
        TextView textView6 = (TextView) holder.O(i11);
        Intrinsics.e(textView6, "holder.secondaryText");
        TextViewExtKt.i(textView6, model.A());
        if (model.v() != null) {
            holder.P().setOnClickListener(new View.OnClickListener() { // from class: u5.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ItemOneLineDelegate.u(ItemOneLineDelegate.this, model, view);
                }
            });
        }
        holder.P().setClickable(model.o());
        if (model.n() != null) {
            RippleProvider rippleProvider = RippleProvider.f35730a;
            View P = holder.P();
            Color n8 = model.n();
            Context context2 = holder.P().getContext();
            Intrinsics.e(context2, "holder.containerView.context");
            int a8 = ColorKt.a(n8, context2);
            Context context3 = holder.P().getContext();
            Intrinsics.e(context3, "holder.containerView.context");
            rippleProvider.a(P, a8, ContextUtilsKt.b(context3, R$attr.f34579i));
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: ItemOneLineDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model<T> extends ListModel implements DividerModel, DepthModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35332a;

        /* renamed from: b  reason: collision with root package name */
        private final Image f35333b;

        /* renamed from: c  reason: collision with root package name */
        private final Color f35334c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f35335d;

        /* renamed from: e  reason: collision with root package name */
        private final Integer f35336e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f35337f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f35338g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f35339h;

        /* renamed from: i  reason: collision with root package name */
        private final Image f35340i;

        /* renamed from: j  reason: collision with root package name */
        private final Color f35341j;

        /* renamed from: k  reason: collision with root package name */
        private final Text f35342k;

        /* renamed from: l  reason: collision with root package name */
        private final Integer f35343l;

        /* renamed from: m  reason: collision with root package name */
        private final Color f35344m;

        /* renamed from: n  reason: collision with root package name */
        private final Color f35345n;

        /* renamed from: o  reason: collision with root package name */
        private final int f35346o;

        /* renamed from: p  reason: collision with root package name */
        private final int f35347p;

        /* renamed from: q  reason: collision with root package name */
        private final boolean f35348q;

        /* renamed from: r  reason: collision with root package name */
        private final T f35349r;

        /* renamed from: s  reason: collision with root package name */
        private final DividerModel f35350s;

        /* renamed from: t  reason: collision with root package name */
        private final int f35351t;

        public /* synthetic */ Model(String str, Image image, Color color, Text text, Integer num, Color color2, boolean z7, Color color3, Image image2, Color color4, Text text2, Integer num2, Color color5, Color color6, int i8, int i9, boolean z8, Object obj, DividerModel dividerModel, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i11 & 2) != 0 ? null : image, (i11 & 4) != 0 ? null : color, text, (i11 & 16) != 0 ? null : num, (i11 & 32) != 0 ? null : color2, (i11 & 64) != 0 ? false : z7, (i11 & 128) != 0 ? null : color3, (i11 & Spliterator.NONNULL) != 0 ? null : image2, (i11 & 512) != 0 ? null : color4, (i11 & Spliterator.IMMUTABLE) != 0 ? null : text2, (i11 & 2048) != 0 ? null : num2, (i11 & 4096) != 0 ? null : color5, (i11 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? null : color6, (i11 & 16384) != 0 ? Dimens.c(16) : i8, (32768 & i11) != 0 ? Dimens.c(16) : i9, (65536 & i11) != 0 ? true : z8, (131072 & i11) != 0 ? null : obj, (262144 & i11) != 0 ? NoDivider.f34829a : dividerModel, (i11 & 524288) != 0 ? 0 : i10);
        }

        public final Color A() {
            return this.f35344m;
        }

        public final Text B() {
            return this.f35335d;
        }

        public final Integer C() {
            return this.f35336e;
        }

        public final Color D() {
            return this.f35337f;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f35350s.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f35350s.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f35333b, model.f35333b) && Intrinsics.a(this.f35334c, model.f35334c) && Intrinsics.a(this.f35335d, model.f35335d) && Intrinsics.a(this.f35336e, model.f35336e) && Intrinsics.a(this.f35337f, model.f35337f) && this.f35338g == model.f35338g && Intrinsics.a(this.f35339h, model.f35339h) && Intrinsics.a(this.f35340i, model.f35340i) && Intrinsics.a(this.f35341j, model.f35341j) && Intrinsics.a(this.f35342k, model.f35342k) && Intrinsics.a(this.f35343l, model.f35343l) && Intrinsics.a(this.f35344m, model.f35344m) && Intrinsics.a(this.f35345n, model.f35345n) && this.f35346o == model.f35346o && this.f35347p == model.f35347p && this.f35348q == model.f35348q && Intrinsics.a(this.f35349r, model.f35349r) && Intrinsics.a(this.f35350s, model.f35350s) && getDepth() == model.getDepth();
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f35350s.f();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DepthModel
        public int getDepth() {
            return this.f35351t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Image image = this.f35333b;
            int hashCode2 = (hashCode + (image == null ? 0 : image.hashCode())) * 31;
            Color color = this.f35334c;
            int hashCode3 = (hashCode2 + (color == null ? 0 : color.hashCode())) * 31;
            Text text = this.f35335d;
            int hashCode4 = (hashCode3 + (text == null ? 0 : text.hashCode())) * 31;
            Integer num = this.f35336e;
            int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
            Color color2 = this.f35337f;
            int hashCode6 = (hashCode5 + (color2 == null ? 0 : color2.hashCode())) * 31;
            boolean z7 = this.f35338g;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode6 + i8) * 31;
            Color color3 = this.f35339h;
            int hashCode7 = (i9 + (color3 == null ? 0 : color3.hashCode())) * 31;
            Image image2 = this.f35340i;
            int hashCode8 = (hashCode7 + (image2 == null ? 0 : image2.hashCode())) * 31;
            Color color4 = this.f35341j;
            int hashCode9 = (hashCode8 + (color4 == null ? 0 : color4.hashCode())) * 31;
            Text text2 = this.f35342k;
            int hashCode10 = (hashCode9 + (text2 == null ? 0 : text2.hashCode())) * 31;
            Integer num2 = this.f35343l;
            int hashCode11 = (hashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Color color5 = this.f35344m;
            int hashCode12 = (hashCode11 + (color5 == null ? 0 : color5.hashCode())) * 31;
            Color color6 = this.f35345n;
            int hashCode13 = (((((hashCode12 + (color6 == null ? 0 : color6.hashCode())) * 31) + this.f35346o) * 31) + this.f35347p) * 31;
            boolean z8 = this.f35348q;
            int i10 = (hashCode13 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
            T t7 = this.f35349r;
            return ((((i10 + (t7 != null ? t7.hashCode() : 0)) * 31) + this.f35350s.hashCode()) * 31) + getDepth();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f35350s.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f35350s.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f35350s.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35332a;
        }

        public final Color n() {
            return this.f35345n;
        }

        public final boolean o() {
            return this.f35348q;
        }

        public final Image p() {
            return this.f35333b;
        }

        public final Color q() {
            return this.f35334c;
        }

        public final Color r() {
            return this.f35339h;
        }

        public final boolean s() {
            return this.f35338g;
        }

        public final int t() {
            return this.f35347p;
        }

        public String toString() {
            String m8 = m();
            Image image = this.f35333b;
            Color color = this.f35334c;
            Text text = this.f35335d;
            Integer num = this.f35336e;
            Color color2 = this.f35337f;
            boolean z7 = this.f35338g;
            Color color3 = this.f35339h;
            Image image2 = this.f35340i;
            Color color4 = this.f35341j;
            Text text2 = this.f35342k;
            Integer num2 = this.f35343l;
            Color color5 = this.f35344m;
            Color color6 = this.f35345n;
            int i8 = this.f35346o;
            int i9 = this.f35347p;
            boolean z8 = this.f35348q;
            T t7 = this.f35349r;
            DividerModel dividerModel = this.f35350s;
            int depth = getDepth();
            return "Model(listId=" + m8 + ", icon=" + image + ", iconTint=" + color + ", text=" + text + ", textAppearance=" + num + ", textColor=" + color2 + ", infoIconVisible=" + z7 + ", infoIconTint=" + color3 + ", secondaryIcon=" + image2 + ", secondaryIconTint=" + color4 + ", secondaryText=" + text2 + ", secondaryTextAppearance=" + num2 + ", secondaryTextColor=" + color5 + ", backgroundColor=" + color6 + ", paddingTop=" + i8 + ", paddingBottom=" + i9 + ", clickable=" + z8 + ", payload=" + t7 + ", divider=" + dividerModel + ", depth=" + depth + ")";
        }

        public final int u() {
            return this.f35346o;
        }

        public final T v() {
            return this.f35349r;
        }

        public final Image w() {
            return this.f35340i;
        }

        public final Color x() {
            return this.f35341j;
        }

        public final Text y() {
            return this.f35342k;
        }

        public final Integer z() {
            return this.f35343l;
        }

        public Model(String listId, Image image, Color color, Text text, Integer num, Color color2, boolean z7, Color color3, Image image2, Color color4, Text text2, Integer num2, Color color5, Color color6, int i8, int i9, boolean z8, T t7, DividerModel divider, int i10) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(divider, "divider");
            this.f35332a = listId;
            this.f35333b = image;
            this.f35334c = color;
            this.f35335d = text;
            this.f35336e = num;
            this.f35337f = color2;
            this.f35338g = z7;
            this.f35339h = color3;
            this.f35340i = image2;
            this.f35341j = color4;
            this.f35342k = text2;
            this.f35343l = num2;
            this.f35344m = color5;
            this.f35345n = color6;
            this.f35346o = i8;
            this.f35347p = i9;
            this.f35348q = z8;
            this.f35349r = t7;
            this.f35350s = divider;
            this.f35351t = i10;
        }
    }
}
