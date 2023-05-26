package eu.bolt.driver.chat.ui.message.list;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.LocaleExtKt;
import eu.bolt.driver.chat.R$attr;
import eu.bolt.driver.chat.R$id;
import eu.bolt.driver.chat.R$layout;
import eu.bolt.driver.chat.ui.message.list.ChatQuickReplyDelegate;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatQuickReplyDelegate.kt */
/* loaded from: classes5.dex */
public final class ChatQuickReplyDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f40538b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40539c;

    /* compiled from: ChatQuickReplyDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f40540a;

        /* renamed from: b  reason: collision with root package name */
        private final String f40541b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f40542c;

        public Model(String listId, String str, Object obj) {
            Intrinsics.f(listId, "listId");
            this.f40540a = listId;
            this.f40541b = str;
            this.f40542c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f40541b, model.f40541b) && Intrinsics.a(this.f40542c, model.f40542c);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            String str = this.f40541b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Object obj = this.f40542c;
            return hashCode2 + (obj != null ? obj.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f40540a;
        }

        public final Object n() {
            return this.f40542c;
        }

        public final String o() {
            return this.f40541b;
        }

        public String toString() {
            String m8 = m();
            String str = this.f40541b;
            Object obj = this.f40542c;
            return "Model(listId=" + m8 + ", text=" + str + ", payload=" + obj + ")";
        }
    }

    /* compiled from: ChatQuickReplyDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f40543u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.f40405u);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f40543u = appCompatTextView;
        }

        public final TextView O() {
            return this.f40543u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatQuickReplyDelegate(Function1<? super Model, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f40538b = onClick;
        this.f40539c = R$layout.delegate_chat_quick_reply_item;
    }

    private final RippleProvider.CornerRadiuses t() {
        Locale locale = Locale.getDefault();
        Intrinsics.e(locale, "getDefault()");
        if (LocaleExtKt.b(locale)) {
            return new RippleProvider.CornerRadiuses(Dimens.c(16.0f), Dimens.c(16.0f), Dimens.c(2.0f), Dimens.c(16.0f));
        }
        return new RippleProvider.CornerRadiuses(Dimens.c(16.0f), Dimens.c(16.0f), Dimens.c(16.0f), Dimens.c(2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ChatQuickReplyDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f40538b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f40539c;
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
        View v7 = inflater.inflate(R$layout.delegate_chat_quick_reply_item, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextView O = holder.O();
        String o8 = model.o();
        if (o8 == null) {
            o8 = "";
        }
        O.setText(o8);
        holder.O().setOnClickListener(new View.OnClickListener() { // from class: w6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatQuickReplyDelegate.v(ChatQuickReplyDelegate.this, model, view);
            }
        });
        RippleProvider rippleProvider = RippleProvider.f35730a;
        TextView O2 = holder.O();
        int i8 = R$attr.dynamicPurple01;
        Color.Attr attr = new Color.Attr(i8);
        Context context = holder.O().getContext();
        Intrinsics.e(context, "textView.context");
        int a8 = ColorKt.a(attr, context);
        Color.Attr attr2 = new Color.Attr(i8);
        Context context2 = holder.O().getContext();
        Intrinsics.e(context2, "textView.context");
        O2.setBackground(rippleProvider.d(a8, ColorKt.a(attr2, context2), t(), Dimens.c(2.0f), Paint.Style.STROKE));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: w */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
