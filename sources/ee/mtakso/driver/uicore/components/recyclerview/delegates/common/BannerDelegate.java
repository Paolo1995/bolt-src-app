package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$drawable;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.BannerDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BannerDelegate.kt */
/* loaded from: classes5.dex */
public class BannerDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f34908b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34909c;

    /* compiled from: BannerDelegate.kt */
    /* loaded from: classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f34916u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f34917v;

        /* renamed from: w  reason: collision with root package name */
        private final ImageView f34918w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.D0);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f34916u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.Y);
            Intrinsics.d(appCompatTextView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f34917v = appCompatTextView2;
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R$id.chevron);
            Intrinsics.d(appCompatImageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f34918w = appCompatImageView;
        }

        public final TextView O() {
            return this.f34916u;
        }

        public final ImageView P() {
            return this.f34918w;
        }

        public final TextView Q() {
            return this.f34917v;
        }
    }

    public /* synthetic */ BannerDelegate(Function1 function1, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i9 & 2) != 0 ? R$layout.delegate_banner : i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Model model, BannerDelegate this$0, View view) {
        Intrinsics.f(model, "$model");
        Intrinsics.f(this$0, "this$0");
        if (model.q()) {
            this$0.f34908b.invoke(model);
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34909c;
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
    public void g(ViewHolder holder, final Model model) {
        boolean z7;
        boolean z8;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextView O = holder.O();
        boolean z9 = true;
        int i8 = 0;
        if (model.n() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(O, z7, 0, 2, null);
        TextView O2 = holder.O();
        CharSequence n8 = model.n();
        CharSequence charSequence = "";
        if (n8 == null) {
            n8 = "";
        }
        O2.setText(n8);
        TextView Q = holder.Q();
        if (model.p() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.e(Q, z8, 0, 2, null);
        TextView Q2 = holder.Q();
        CharSequence p8 = model.p();
        if (p8 != null) {
            charSequence = p8;
        }
        Q2.setText(charSequence);
        ImageView P = holder.P();
        if (model.o() == null) {
            z9 = false;
        }
        ViewExtKt.e(P, z9, 0, 2, null);
        if (model.o() != null) {
            holder.P().setImageResource(model.o().intValue());
        }
        View view = holder.f7332a;
        if (!model.q()) {
            i8 = 4;
        }
        view.setVisibility(i8);
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BannerDelegate.u(BannerDelegate.Model.this, this, view2);
            }
        });
        RippleProvider rippleProvider = RippleProvider.f35730a;
        View itemView = holder.f7332a;
        Intrinsics.e(itemView, "itemView");
        int color = ContextCompat.getColor(holder.f7332a.getContext(), R$color.purple500);
        int color2 = ContextCompat.getColor(holder.f7332a.getContext(), R$color.purple900);
        float c8 = Dimens.c(4.0f);
        Paint.Style style = Paint.Style.FILL;
        itemView.setBackground(rippleProvider.d(color, color2, new RippleProvider.CornerRadiuses(c8, c8, c8, c8), Dimens.c(2.0f), Paint.Style.FILL));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: BannerDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34910a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f34911b;

        /* renamed from: c  reason: collision with root package name */
        private final CharSequence f34912c;

        /* renamed from: d  reason: collision with root package name */
        private final Integer f34913d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f34914e;

        /* renamed from: f  reason: collision with root package name */
        private final DividerModel f34915f;

        public /* synthetic */ Model(String str, CharSequence charSequence, CharSequence charSequence2, Integer num, boolean z7, DividerModel dividerModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : charSequence, (i8 & 4) == 0 ? charSequence2 : null, (i8 & 8) != 0 ? Integer.valueOf(R$drawable.ic_chevron_right) : num, (i8 & 16) != 0 ? true : z7, (i8 & 32) != 0 ? NoDivider.f34829a : dividerModel);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f34915f.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f34915f.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f34911b, model.f34911b) && Intrinsics.a(this.f34912c, model.f34912c) && Intrinsics.a(this.f34913d, model.f34913d) && this.f34914e == model.f34914e && Intrinsics.a(this.f34915f, model.f34915f);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f34915f.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            CharSequence charSequence = this.f34911b;
            int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            CharSequence charSequence2 = this.f34912c;
            int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            Integer num = this.f34913d;
            int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
            boolean z7 = this.f34914e;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return ((hashCode4 + i8) * 31) + this.f34915f.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f34915f.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f34915f.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f34915f.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34910a;
        }

        public final CharSequence n() {
            return this.f34911b;
        }

        public final Integer o() {
            return this.f34913d;
        }

        public final CharSequence p() {
            return this.f34912c;
        }

        public final boolean q() {
            return this.f34914e;
        }

        public String toString() {
            String m8 = m();
            CharSequence charSequence = this.f34911b;
            CharSequence charSequence2 = this.f34912c;
            Integer num = this.f34913d;
            boolean z7 = this.f34914e;
            DividerModel dividerModel = this.f34915f;
            return "Model(listId=" + m8 + ", keyText=" + ((Object) charSequence) + ", valueText=" + ((Object) charSequence2) + ", rightIcon=" + num + ", visible=" + z7 + ", dividerModel=" + dividerModel + ")";
        }

        public Model(String listId, CharSequence charSequence, CharSequence charSequence2, Integer num, boolean z7, DividerModel dividerModel) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(dividerModel, "dividerModel");
            this.f34910a = listId;
            this.f34911b = charSequence;
            this.f34912c = charSequence2;
            this.f34913d = num;
            this.f34914e = z7;
            this.f34915f = dividerModel;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BannerDelegate(Function1<? super Model, Unit> onInfoClick, int i8) {
        Intrinsics.f(onInfoClick, "onInfoClick");
        this.f34908b = onInfoClick;
        this.f34909c = i8;
    }
}
