package eu.bolt.driver.chat.ui.message.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.driver.chat.R$id;
import eu.bolt.driver.chat.R$layout;
import eu.bolt.driver.chat.ui.message.list.ChatTranslatedMessageDelegate;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatTranslatedMessageDelegate.kt */
/* loaded from: classes5.dex */
public final class ChatTranslatedMessageDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f40555b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40556c;

    /* compiled from: ChatTranslatedMessageDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements MessageModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f40557a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f40558b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f40559c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f40560d;

        /* renamed from: e  reason: collision with root package name */
        private final Text f40561e;

        /* renamed from: f  reason: collision with root package name */
        private final Image f40562f;

        /* renamed from: g  reason: collision with root package name */
        private final ChatMessageEntity f40563g;

        public Model(String listId, Text originalText, Text translatedText, Text messageDate, Text attributionText, Image image, ChatMessageEntity message) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(originalText, "originalText");
            Intrinsics.f(translatedText, "translatedText");
            Intrinsics.f(messageDate, "messageDate");
            Intrinsics.f(attributionText, "attributionText");
            Intrinsics.f(message, "message");
            this.f40557a = listId;
            this.f40558b = originalText;
            this.f40559c = translatedText;
            this.f40560d = messageDate;
            this.f40561e = attributionText;
            this.f40562f = image;
            this.f40563g = message;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f40558b, model.f40558b) && Intrinsics.a(this.f40559c, model.f40559c) && Intrinsics.a(this.f40560d, model.f40560d) && Intrinsics.a(this.f40561e, model.f40561e) && Intrinsics.a(this.f40562f, model.f40562f) && Intrinsics.a(getMessage(), model.getMessage());
            }
            return false;
        }

        @Override // eu.bolt.driver.chat.ui.message.list.MessageModel
        public ChatMessageEntity getMessage() {
            return this.f40563g;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((((((m().hashCode() * 31) + this.f40558b.hashCode()) * 31) + this.f40559c.hashCode()) * 31) + this.f40560d.hashCode()) * 31) + this.f40561e.hashCode()) * 31;
            Image image = this.f40562f;
            return ((hashCode + (image == null ? 0 : image.hashCode())) * 31) + getMessage().hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f40557a;
        }

        public final Image n() {
            return this.f40562f;
        }

        public final Text o() {
            return this.f40561e;
        }

        public final Text p() {
            return this.f40560d;
        }

        public final Text q() {
            return this.f40558b;
        }

        public final Text r() {
            return this.f40559c;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f40558b;
            Text text2 = this.f40559c;
            Text text3 = this.f40560d;
            Text text4 = this.f40561e;
            Image image = this.f40562f;
            ChatMessageEntity message = getMessage();
            return "Model(listId=" + m8 + ", originalText=" + text + ", translatedText=" + text2 + ", messageDate=" + text3 + ", attributionText=" + text4 + ", attributionLogo=" + image + ", message=" + message + ")";
        }
    }

    /* compiled from: ChatTranslatedMessageDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f40564u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f40565v;

        /* renamed from: w  reason: collision with root package name */
        private final TextView f40566w;

        /* renamed from: x  reason: collision with root package name */
        private final TextView f40567x;

        /* renamed from: y  reason: collision with root package name */
        private final ImageView f40568y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.originalMessageText);
            Intrinsics.e(appCompatTextView, "itemView.originalMessageText");
            this.f40564u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.translatedMessageText);
            Intrinsics.e(appCompatTextView2, "itemView.translatedMessageText");
            this.f40565v = appCompatTextView2;
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) itemView.findViewById(R$id.messageDate);
            Intrinsics.e(appCompatTextView3, "itemView.messageDate");
            this.f40566w = appCompatTextView3;
            AppCompatTextView appCompatTextView4 = (AppCompatTextView) itemView.findViewById(R$id.attributionText);
            Intrinsics.e(appCompatTextView4, "itemView.attributionText");
            this.f40567x = appCompatTextView4;
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R$id.attributionLogo);
            Intrinsics.e(appCompatImageView, "itemView.attributionLogo");
            this.f40568y = appCompatImageView;
        }

        public final ImageView O() {
            return this.f40568y;
        }

        public final TextView P() {
            return this.f40567x;
        }

        public final TextView Q() {
            return this.f40566w;
        }

        public final TextView R() {
            return this.f40564u;
        }

        public final TextView S() {
            return this.f40565v;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatTranslatedMessageDelegate(Function1<? super Model, Unit> onMessageLongClick) {
        Intrinsics.f(onMessageLongClick, "onMessageLongClick");
        this.f40555b = onMessageLongClick;
        this.f40556c = R$layout.delegate_chat_translated_item;
    }

    private final void t(ViewHolder viewHolder, Image image) {
        ViewExtKt.d(viewHolder.O(), true, 0, 2, null);
        ViewExtKt.d(viewHolder.P(), false, 0, 2, null);
        ImageKt.b(image, viewHolder.O(), null, 2, null);
    }

    private final void u(ViewHolder viewHolder, Text text) {
        ViewExtKt.d(viewHolder.P(), true, 0, 2, null);
        ViewExtKt.d(viewHolder.O(), false, 0, 2, null);
        TextViewExtKt.h(viewHolder.P(), text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x(ChatTranslatedMessageDelegate this$0, ViewHolder viewHolder, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(viewHolder, "$viewHolder");
        this$0.f40555b.invoke(this$0.d(viewHolder));
        return true;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f40556c;
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
        View itemView = inflater.inflate(e(), parent, false);
        Intrinsics.e(itemView, "itemView");
        final ViewHolder viewHolder = new ViewHolder(itemView);
        itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: w6.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean x7;
                x7 = ChatTranslatedMessageDelegate.x(ChatTranslatedMessageDelegate.this, viewHolder, view);
                return x7;
            }
        });
        return viewHolder;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        TextViewExtKt.h(holder.R(), model.q());
        TextViewExtKt.h(holder.S(), model.r());
        TextViewExtKt.h(holder.Q(), model.p());
        if (model.n() != null) {
            t(holder, model.n());
        } else {
            u(holder, model.o());
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: w */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
