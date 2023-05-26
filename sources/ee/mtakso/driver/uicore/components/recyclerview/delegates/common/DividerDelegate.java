package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DividerDelegate.kt */
/* loaded from: classes5.dex */
public final class DividerDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f34941b = R$layout.delegate_divider_item;

    /* compiled from: DividerDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f34949u;

        /* renamed from: v  reason: collision with root package name */
        private final View f34950v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            View findViewById = itemView.findViewById(R$id.foregroundView);
            Intrinsics.e(findViewById, "itemView.foregroundView");
            this.f34949u = findViewById;
            FrameLayout frameLayout = (FrameLayout) itemView.findViewById(R$id.backgroundView);
            Intrinsics.e(frameLayout, "itemView.backgroundView");
            this.f34950v = frameLayout;
        }

        public final View O() {
            return this.f34950v;
        }

        public final View P() {
            return this.f34949u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34941b;
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
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Unit unit;
        Unit unit2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.P().getContext();
        Color n8 = model.n();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (n8 != null) {
            Intrinsics.e(context, "context");
            holder.O().setBackgroundColor(ColorKt.a(n8, context));
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            holder.O().setBackground(null);
        }
        Color o8 = model.o();
        if (o8 != null) {
            Intrinsics.e(context, "context");
            holder.P().setBackgroundColor(ColorKt.a(o8, context));
            unit2 = Unit.f50853a;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            holder.P().setBackground(null);
        }
        View P = holder.P();
        ViewGroup.LayoutParams layoutParams = holder.P().getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart(model.q());
            marginLayoutParams.setMarginEnd(model.r());
            marginLayoutParams.height = model.p();
            marginLayoutParams.width = model.s();
            marginLayoutParams2 = marginLayoutParams;
        }
        P.setLayoutParams(marginLayoutParams2);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: DividerDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34942a;

        /* renamed from: b  reason: collision with root package name */
        private final int f34943b;

        /* renamed from: c  reason: collision with root package name */
        private final int f34944c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f34945d;

        /* renamed from: e  reason: collision with root package name */
        private final Color f34946e;

        /* renamed from: f  reason: collision with root package name */
        private final int f34947f;

        /* renamed from: g  reason: collision with root package name */
        private final int f34948g;

        public /* synthetic */ Model(String str, int i8, int i9, Color color, Color color2, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i12 & 2) != 0 ? Dimens.c(24) : i8, (i12 & 4) != 0 ? -2 : i9, (i12 & 8) != 0 ? null : color, (i12 & 16) == 0 ? color2 : null, (i12 & 32) != 0 ? 0 : i10, (i12 & 64) == 0 ? i11 : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && this.f34943b == model.f34943b && this.f34944c == model.f34944c && Intrinsics.a(this.f34945d, model.f34945d) && Intrinsics.a(this.f34946e, model.f34946e) && this.f34947f == model.f34947f && this.f34948g == model.f34948g;
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((m().hashCode() * 31) + this.f34943b) * 31) + this.f34944c) * 31;
            Color color = this.f34945d;
            int hashCode2 = (hashCode + (color == null ? 0 : color.hashCode())) * 31;
            Color color2 = this.f34946e;
            return ((((hashCode2 + (color2 != null ? color2.hashCode() : 0)) * 31) + this.f34947f) * 31) + this.f34948g;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34942a;
        }

        public final Color n() {
            return this.f34946e;
        }

        public final Color o() {
            return this.f34945d;
        }

        public final int p() {
            return this.f34943b;
        }

        public final int q() {
            return this.f34947f;
        }

        public final int r() {
            return this.f34948g;
        }

        public final int s() {
            return this.f34944c;
        }

        public String toString() {
            String m8 = m();
            int i8 = this.f34943b;
            int i9 = this.f34944c;
            Color color = this.f34945d;
            Color color2 = this.f34946e;
            int i10 = this.f34947f;
            int i11 = this.f34948g;
            return "Model(listId=" + m8 + ", height=" + i8 + ", width=" + i9 + ", foregroundColor=" + color + ", backgroundColor=" + color2 + ", marginStart=" + i10 + ", margingEnd=" + i11 + ")";
        }

        public Model(String listId, int i8, int i9, Color color, Color color2, int i10, int i11) {
            Intrinsics.f(listId, "listId");
            this.f34942a = listId;
            this.f34943b = i8;
            this.f34944c = i9;
            this.f34945d = color;
            this.f34946e = color2;
            this.f34947f = i10;
            this.f34948g = i11;
        }
    }
}
