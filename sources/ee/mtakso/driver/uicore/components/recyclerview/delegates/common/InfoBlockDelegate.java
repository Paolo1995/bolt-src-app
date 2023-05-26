package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Background;
import ee.mtakso.driver.uikit.utils.BackgroundKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.ImageViewExtKt;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import j$.util.Spliterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfoBlockDelegate.kt */
/* loaded from: classes5.dex */
public final class InfoBlockDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f34964b = R$layout.delegate_infoblock_item;

    /* compiled from: InfoBlockDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final ImageView f34980u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f34981v;

        /* renamed from: w  reason: collision with root package name */
        private final TextView f34982w;

        /* renamed from: x  reason: collision with root package name */
        private final FrameLayout f34983x;

        /* renamed from: y  reason: collision with root package name */
        private final ConstraintLayout f34984y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            ImageView imageView = (ImageView) itemView.findViewById(R$id.C);
            Intrinsics.d(imageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f34980u = imageView;
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.F0);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f34981v = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.f34592a0);
            Intrinsics.d(appCompatTextView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f34982w = appCompatTextView2;
            this.f34983x = (FrameLayout) itemView.findViewById(R$id.viewRoot);
            this.f34984y = (ConstraintLayout) itemView.findViewById(R$id.Z);
        }

        public final ImageView O() {
            return this.f34980u;
        }

        public final ConstraintLayout P() {
            return this.f34984y;
        }

        public final FrameLayout Q() {
            return this.f34983x;
        }

        public final TextView R() {
            return this.f34982w;
        }

        public final TextView S() {
            return this.f34981v;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34964b;
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
        CharSequence charSequence;
        boolean z7;
        CharSequence charSequence2;
        boolean z8;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Text x7 = model.x();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (x7 != null) {
            Context context = holder.S().getContext();
            Intrinsics.e(context, "titleView.context");
            charSequence = TextKt.a(x7, context);
        } else {
            charSequence = null;
        }
        TextView S = holder.S();
        boolean z9 = true;
        if (charSequence != null && charSequence.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(S, z7, 0, 2, null);
        holder.S().setText(charSequence);
        Integer z10 = model.z();
        if (z10 != null) {
            TextViewCompat.o(holder.S(), z10.intValue());
        }
        TextViewExtKt.i(holder.S(), model.A());
        TextViewExtKt.e(holder.S(), model.y());
        holder.S().setMovementMethod(new LinkMovementMethod());
        Text v7 = model.v();
        if (v7 != null) {
            Context context2 = holder.S().getContext();
            Intrinsics.e(context2, "titleView.context");
            charSequence2 = TextKt.a(v7, context2);
        } else {
            charSequence2 = null;
        }
        TextView R = holder.R();
        if (charSequence2 != null && charSequence2.length() > 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.e(R, z8, 0, 2, null);
        holder.R().setText(charSequence2);
        TextViewExtKt.i(holder.R(), model.w());
        holder.R().setMovementMethod(new LinkMovementMethod());
        ImageView O = holder.O();
        if (model.q() == null) {
            z9 = false;
        }
        ViewExtKt.e(O, z9, 0, 2, null);
        Image q8 = model.q();
        if (q8 != null) {
            ImageKt.b(q8, holder.O(), null, 2, null);
        }
        ImageViewExtKt.a(holder.O(), model.r());
        FrameLayout messageRoot = holder.Q();
        Intrinsics.e(messageRoot, "messageRoot");
        ee.mtakso.driver.uikit.utils.ViewExtKt.a(messageRoot, model.n());
        Background o8 = model.o();
        ConstraintLayout messageBody = holder.P();
        Intrinsics.e(messageBody, "messageBody");
        BackgroundKt.b(o8, messageBody);
        ConstraintLayout messageBody2 = holder.P();
        Intrinsics.e(messageBody2, "messageBody");
        ee.mtakso.driver.uikit.utils.ViewExtKt.b(messageBody2, model.p());
        ConstraintLayout P = holder.P();
        ViewGroup.LayoutParams layoutParams = holder.P().getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart(model.s());
            marginLayoutParams.setMarginEnd(model.t());
            marginLayoutParams2 = marginLayoutParams;
        }
        P.setLayoutParams(marginLayoutParams2);
        if (model.u() != null) {
            ConstraintLayout messageBody3 = holder.P();
            Intrinsics.e(messageBody3, "messageBody");
            messageBody3.setPaddingRelative(model.u().b(), model.u().d(), model.u().c(), model.u().a());
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: InfoBlockDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34965a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f34966b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f34967c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f34968d;

        /* renamed from: e  reason: collision with root package name */
        private final Color f34969e;

        /* renamed from: f  reason: collision with root package name */
        private final Text f34970f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f34971g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f34972h;

        /* renamed from: i  reason: collision with root package name */
        private final Background f34973i;

        /* renamed from: j  reason: collision with root package name */
        private final Color f34974j;

        /* renamed from: k  reason: collision with root package name */
        private final Image f34975k;

        /* renamed from: l  reason: collision with root package name */
        private final Color f34976l;

        /* renamed from: m  reason: collision with root package name */
        private final int f34977m;

        /* renamed from: n  reason: collision with root package name */
        private final int f34978n;

        /* renamed from: o  reason: collision with root package name */
        private final Margins f34979o;

        public /* synthetic */ Model(String str, Text text, Integer num, Color color, Color color2, Text text2, Color color3, Color color4, Background background, Color color5, Image image, Color color6, int i8, int i9, Margins margins, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i10 & 2) != 0 ? null : text, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : color, (i10 & 16) != 0 ? null : color2, (i10 & 32) != 0 ? null : text2, (i10 & 64) != 0 ? null : color3, (i10 & 128) != 0 ? null : color4, (i10 & Spliterator.NONNULL) != 0 ? new Background.Attr(R$attr.f34583o) : background, (i10 & 512) != 0 ? null : color5, (i10 & Spliterator.IMMUTABLE) != 0 ? null : image, (i10 & 2048) != 0 ? null : color6, (i10 & 4096) != 0 ? 0 : i8, (i10 & FragmentTransaction.TRANSIT_EXIT_MASK) == 0 ? i9 : 0, (i10 & 16384) == 0 ? margins : null);
        }

        public final Color A() {
            return this.f34968d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f34966b, model.f34966b) && Intrinsics.a(this.f34967c, model.f34967c) && Intrinsics.a(this.f34968d, model.f34968d) && Intrinsics.a(this.f34969e, model.f34969e) && Intrinsics.a(this.f34970f, model.f34970f) && Intrinsics.a(this.f34971g, model.f34971g) && Intrinsics.a(this.f34972h, model.f34972h) && Intrinsics.a(this.f34973i, model.f34973i) && Intrinsics.a(this.f34974j, model.f34974j) && Intrinsics.a(this.f34975k, model.f34975k) && Intrinsics.a(this.f34976l, model.f34976l) && this.f34977m == model.f34977m && this.f34978n == model.f34978n && Intrinsics.a(this.f34979o, model.f34979o);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f34966b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Integer num = this.f34967c;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Color color = this.f34968d;
            int hashCode4 = (hashCode3 + (color == null ? 0 : color.hashCode())) * 31;
            Color color2 = this.f34969e;
            int hashCode5 = (hashCode4 + (color2 == null ? 0 : color2.hashCode())) * 31;
            Text text2 = this.f34970f;
            int hashCode6 = (hashCode5 + (text2 == null ? 0 : text2.hashCode())) * 31;
            Color color3 = this.f34971g;
            int hashCode7 = (hashCode6 + (color3 == null ? 0 : color3.hashCode())) * 31;
            Color color4 = this.f34972h;
            int hashCode8 = (((hashCode7 + (color4 == null ? 0 : color4.hashCode())) * 31) + this.f34973i.hashCode()) * 31;
            Color color5 = this.f34974j;
            int hashCode9 = (hashCode8 + (color5 == null ? 0 : color5.hashCode())) * 31;
            Image image = this.f34975k;
            int hashCode10 = (hashCode9 + (image == null ? 0 : image.hashCode())) * 31;
            Color color6 = this.f34976l;
            int hashCode11 = (((((hashCode10 + (color6 == null ? 0 : color6.hashCode())) * 31) + this.f34977m) * 31) + this.f34978n) * 31;
            Margins margins = this.f34979o;
            return hashCode11 + (margins != null ? margins.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34965a;
        }

        public final Color n() {
            return this.f34972h;
        }

        public final Background o() {
            return this.f34973i;
        }

        public final Color p() {
            return this.f34974j;
        }

        public final Image q() {
            return this.f34975k;
        }

        public final Color r() {
            return this.f34976l;
        }

        public final int s() {
            return this.f34977m;
        }

        public final int t() {
            return this.f34978n;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f34966b;
            Integer num = this.f34967c;
            Color color = this.f34968d;
            Color color2 = this.f34969e;
            Text text2 = this.f34970f;
            Color color3 = this.f34971g;
            Color color4 = this.f34972h;
            Background background = this.f34973i;
            Color color5 = this.f34974j;
            Image image = this.f34975k;
            Color color6 = this.f34976l;
            int i8 = this.f34977m;
            int i9 = this.f34978n;
            Margins margins = this.f34979o;
            return "Model(listId=" + m8 + ", title=" + text + ", titleTextAppearance=" + num + ", titleTextColor=" + color + ", titleLinkColor=" + color2 + ", text=" + text2 + ", textColor=" + color3 + ", backgroundColor=" + color4 + ", blockBackground=" + background + ", blockBackgroundTint=" + color5 + ", icon=" + image + ", iconTintColor=" + color6 + ", marginStart=" + i8 + ", margingEnd=" + i9 + ", paddings=" + margins + ")";
        }

        public final Margins u() {
            return this.f34979o;
        }

        public final Text v() {
            return this.f34970f;
        }

        public final Color w() {
            return this.f34971g;
        }

        public final Text x() {
            return this.f34966b;
        }

        public final Color y() {
            return this.f34969e;
        }

        public final Integer z() {
            return this.f34967c;
        }

        public Model(String listId, Text text, Integer num, Color color, Color color2, Text text2, Color color3, Color color4, Background blockBackground, Color color5, Image image, Color color6, int i8, int i9, Margins margins) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(blockBackground, "blockBackground");
            this.f34965a = listId;
            this.f34966b = text;
            this.f34967c = num;
            this.f34968d = color;
            this.f34969e = color2;
            this.f34970f = text2;
            this.f34971g = color3;
            this.f34972h = color4;
            this.f34973i = blockBackground;
            this.f34974j = color5;
            this.f34975k = image;
            this.f34976l = color6;
            this.f34977m = i8;
            this.f34978n = i9;
            this.f34979o = margins;
        }
    }
}
