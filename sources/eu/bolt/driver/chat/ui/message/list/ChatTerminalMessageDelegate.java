package eu.bolt.driver.chat.ui.message.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.ImageViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.driver.chat.R$id;
import eu.bolt.driver.chat.R$layout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatTerminalMessageDelegate.kt */
/* loaded from: classes5.dex */
public final class ChatTerminalMessageDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f40544b = R$layout.delegate_chat_teminal_item;

    /* compiled from: ChatTerminalMessageDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f40545a;

        /* renamed from: b  reason: collision with root package name */
        private final String f40546b;

        /* renamed from: c  reason: collision with root package name */
        private final int f40547c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f40548d;

        /* renamed from: e  reason: collision with root package name */
        private final Integer f40549e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f40550f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f40551g;

        public Model(String listId, String str, int i8, Color iconTint, Integer num, Color color, Color textColor) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(iconTint, "iconTint");
            Intrinsics.f(textColor, "textColor");
            this.f40545a = listId;
            this.f40546b = str;
            this.f40547c = i8;
            this.f40548d = iconTint;
            this.f40549e = num;
            this.f40550f = color;
            this.f40551g = textColor;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f40546b, model.f40546b) && this.f40547c == model.f40547c && Intrinsics.a(this.f40548d, model.f40548d) && Intrinsics.a(this.f40549e, model.f40549e) && Intrinsics.a(this.f40550f, model.f40550f) && Intrinsics.a(this.f40551g, model.f40551g);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            String str = this.f40546b;
            int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f40547c) * 31) + this.f40548d.hashCode()) * 31;
            Integer num = this.f40549e;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Color color = this.f40550f;
            return ((hashCode3 + (color != null ? color.hashCode() : 0)) * 31) + this.f40551g.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f40545a;
        }

        public final Integer n() {
            return this.f40549e;
        }

        public final Color o() {
            return this.f40550f;
        }

        public final Color p() {
            return this.f40548d;
        }

        public final int q() {
            return this.f40547c;
        }

        public final String r() {
            return this.f40546b;
        }

        public final Color s() {
            return this.f40551g;
        }

        public String toString() {
            String m8 = m();
            String str = this.f40546b;
            int i8 = this.f40547c;
            Color color = this.f40548d;
            Integer num = this.f40549e;
            Color color2 = this.f40550f;
            Color color3 = this.f40551g;
            return "Model(listId=" + m8 + ", text=" + str + ", statusIcon=" + i8 + ", iconTint=" + color + ", background=" + num + ", backgroundColor=" + color2 + ", textColor=" + color3 + ")";
        }
    }

    /* compiled from: ChatTerminalMessageDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f40552u;

        /* renamed from: v  reason: collision with root package name */
        private final ImageView f40553v;

        /* renamed from: w  reason: collision with root package name */
        private final LinearLayout f40554w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.f40405u);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f40552u = appCompatTextView;
            ImageView imageView = (ImageView) itemView.findViewById(R$id.f40402m);
            Intrinsics.d(imageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f40553v = imageView;
            this.f40554w = (LinearLayout) itemView.findViewById(R$id.f40404q);
        }

        public final LinearLayout O() {
            return this.f40554w;
        }

        public final ImageView P() {
            return this.f40553v;
        }

        public final TextView Q() {
            return this.f40552u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f40544b;
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
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.Q().getContext();
        TextView Q = holder.Q();
        String r7 = model.r();
        if (r7 == null) {
            r7 = "";
        }
        Q.setText(r7);
        TextView Q2 = holder.Q();
        Color s7 = model.s();
        Intrinsics.e(context, "context");
        Q2.setTextColor(ColorKt.a(s7, context));
        holder.P().setImageResource(model.q());
        ImageViewExtKt.a(holder.P(), model.p());
        Integer n8 = model.n();
        if (n8 != null) {
            holder.O().setBackgroundResource(n8.intValue());
        }
        LinearLayout messageBody = holder.O();
        Intrinsics.e(messageBody, "messageBody");
        ViewExtKt.b(messageBody, model.o());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
