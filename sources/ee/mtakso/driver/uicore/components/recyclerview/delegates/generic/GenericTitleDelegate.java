package ee.mtakso.driver.uicore.components.recyclerview.delegates.generic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DepthModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import j$.util.Spliterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenericTitleDelegate.kt */
/* loaded from: classes5.dex */
public final class GenericTitleDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f35318b = R$layout.delegate_generic_title;

    /* compiled from: GenericTitleDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DepthModel, DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f35319a;

        /* renamed from: b  reason: collision with root package name */
        private final int f35320b;

        /* renamed from: c  reason: collision with root package name */
        private final CharSequence f35321c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f35322d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f35323e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f35324f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f35325g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f35326h;

        /* renamed from: i  reason: collision with root package name */
        private final Color f35327i;

        /* renamed from: j  reason: collision with root package name */
        private final Float f35328j;

        public /* synthetic */ Model(String str, int i8, CharSequence charSequence, Color color, boolean z7, boolean z8, boolean z9, Color color2, Color color3, Float f8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i8, charSequence, (i9 & 8) != 0 ? null : color, (i9 & 16) != 0 ? true : z7, (i9 & 32) != 0 ? false : z8, (i9 & 64) != 0 ? true : z9, (i9 & 128) != 0 ? null : color2, (i9 & Spliterator.NONNULL) != 0 ? null : color3, (i9 & 512) != 0 ? null : f8);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f35326h;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f35323e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && getDepth() == model.getDepth() && Intrinsics.a(this.f35321c, model.f35321c) && Intrinsics.a(this.f35322d, model.f35322d) && e() == model.e() && j() == model.j() && k() == model.k() && Intrinsics.a(d(), model.d()) && Intrinsics.a(f(), model.f()) && Intrinsics.a(i(), model.i());
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f35327i;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DepthModel
        public int getDepth() {
            return this.f35320b;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((m().hashCode() * 31) + getDepth()) * 31) + this.f35321c.hashCode()) * 31;
            Color color = this.f35322d;
            int hashCode2 = (hashCode + (color == null ? 0 : color.hashCode())) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            int i9 = (hashCode2 + i8) * 31;
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
            return this.f35328j;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f35324f;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f35325g;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f35319a;
        }

        public final Color n() {
            return this.f35322d;
        }

        public final CharSequence o() {
            return this.f35321c;
        }

        public String toString() {
            String m8 = m();
            int depth = getDepth();
            CharSequence charSequence = this.f35321c;
            Color color = this.f35322d;
            boolean e8 = e();
            boolean j8 = j();
            boolean k8 = k();
            Color d8 = d();
            Color f8 = f();
            Float i8 = i();
            return "Model(listId=" + m8 + ", depth=" + depth + ", text=" + ((Object) charSequence) + ", backgroundColor=" + color + ", isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ")";
        }

        public Model(String listId, int i8, CharSequence text, Color color, boolean z7, boolean z8, boolean z9, Color color2, Color color3, Float f8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(text, "text");
            this.f35319a = listId;
            this.f35320b = i8;
            this.f35321c = text;
            this.f35322d = color;
            this.f35323e = z7;
            this.f35324f = z8;
            this.f35325g = z9;
            this.f35326h = color2;
            this.f35327i = color3;
            this.f35328j = f8;
        }
    }

    /* compiled from: GenericTitleDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final AppCompatTextView f35329u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            this.f35329u = (AppCompatTextView) itemView.findViewById(R$id.D0);
        }

        public final AppCompatTextView O() {
            return this.f35329u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f35318b;
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
        View v7 = inflater.inflate(R$layout.delegate_generic_title, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.O().setText(model.o());
        Color n8 = model.n();
        if (n8 != null) {
            View view = holder.f7332a;
            Context context = view.getContext();
            Intrinsics.e(context, "itemView.context");
            view.setBackgroundColor(ColorKt.a(n8, context));
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
