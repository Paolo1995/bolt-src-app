package eu.bolt.driver.chat.ui.message.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.ImageViewExtKt;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.driver.chat.R$id;
import eu.bolt.driver.chat.ui.message.list.ChatMessageDelegate;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageDelegate.kt */
/* loaded from: classes5.dex */
public abstract class ChatMessageDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f40509b;

    /* compiled from: ChatMessageDelegate.kt */
    /* loaded from: classes5.dex */
    public enum Direction {
        IN,
        OUT
    }

    /* compiled from: ChatMessageDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel implements MessageModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f40513a;

        /* renamed from: b  reason: collision with root package name */
        private final String f40514b;

        /* renamed from: c  reason: collision with root package name */
        private final float f40515c;

        /* renamed from: d  reason: collision with root package name */
        private final String f40516d;

        /* renamed from: e  reason: collision with root package name */
        private final StatusIcon f40517e;

        /* renamed from: f  reason: collision with root package name */
        private final Integer f40518f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f40519g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f40520h;

        /* renamed from: i  reason: collision with root package name */
        private final Direction f40521i;

        /* renamed from: j  reason: collision with root package name */
        private final ChatMessageEntity f40522j;

        public Model(String listId, String str, float f8, String str2, StatusIcon statusIcon, Integer num, Color color, Color statusTextColor, Direction direction, ChatMessageEntity message) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(statusIcon, "statusIcon");
            Intrinsics.f(statusTextColor, "statusTextColor");
            Intrinsics.f(direction, "direction");
            Intrinsics.f(message, "message");
            this.f40513a = listId;
            this.f40514b = str;
            this.f40515c = f8;
            this.f40516d = str2;
            this.f40517e = statusIcon;
            this.f40518f = num;
            this.f40519g = color;
            this.f40520h = statusTextColor;
            this.f40521i = direction;
            this.f40522j = message;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f40514b, model.f40514b) && Float.compare(this.f40515c, model.f40515c) == 0 && Intrinsics.a(this.f40516d, model.f40516d) && Intrinsics.a(this.f40517e, model.f40517e) && Intrinsics.a(this.f40518f, model.f40518f) && Intrinsics.a(this.f40519g, model.f40519g) && Intrinsics.a(this.f40520h, model.f40520h) && this.f40521i == model.f40521i && Intrinsics.a(getMessage(), model.getMessage());
            }
            return false;
        }

        @Override // eu.bolt.driver.chat.ui.message.list.MessageModel
        public ChatMessageEntity getMessage() {
            return this.f40522j;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            String str = this.f40514b;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Float.floatToIntBits(this.f40515c)) * 31;
            String str2 = this.f40516d;
            int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f40517e.hashCode()) * 31;
            Integer num = this.f40518f;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            Color color = this.f40519g;
            return ((((((hashCode4 + (color != null ? color.hashCode() : 0)) * 31) + this.f40520h.hashCode()) * 31) + this.f40521i.hashCode()) * 31) + getMessage().hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f40513a;
        }

        public final Integer n() {
            return this.f40518f;
        }

        public final Color o() {
            return this.f40519g;
        }

        public final Direction p() {
            return this.f40521i;
        }

        public final StatusIcon q() {
            return this.f40517e;
        }

        public final String r() {
            return this.f40516d;
        }

        public final Color s() {
            return this.f40520h;
        }

        public final String t() {
            return this.f40514b;
        }

        public String toString() {
            String m8 = m();
            String str = this.f40514b;
            float f8 = this.f40515c;
            String str2 = this.f40516d;
            StatusIcon statusIcon = this.f40517e;
            Integer num = this.f40518f;
            Color color = this.f40519g;
            Color color2 = this.f40520h;
            Direction direction = this.f40521i;
            ChatMessageEntity message = getMessage();
            return "Model(listId=" + m8 + ", text=" + str + ", textSize=" + f8 + ", statusText=" + str2 + ", statusIcon=" + statusIcon + ", background=" + num + ", backgroundTint=" + color + ", statusTextColor=" + color2 + ", direction=" + direction + ", message=" + message + ")";
        }

        public final float u() {
            return this.f40515c;
        }
    }

    /* compiled from: ChatMessageDelegate.kt */
    /* loaded from: classes5.dex */
    public static abstract class StatusIcon {

        /* compiled from: ChatMessageDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Animation extends StatusIcon {

            /* renamed from: a  reason: collision with root package name */
            private final int f40523a;

            /* renamed from: b  reason: collision with root package name */
            private final int f40524b;

            /* renamed from: c  reason: collision with root package name */
            private final Color f40525c;

            public Animation(int i8, int i9, Color color) {
                super(null);
                this.f40523a = i8;
                this.f40524b = i9;
                this.f40525c = color;
            }

            public final int a() {
                return this.f40523a;
            }

            public final int b() {
                return this.f40524b;
            }

            public final Color c() {
                return this.f40525c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Animation) {
                    Animation animation = (Animation) obj;
                    return this.f40523a == animation.f40523a && this.f40524b == animation.f40524b && Intrinsics.a(this.f40525c, animation.f40525c);
                }
                return false;
            }

            public int hashCode() {
                int i8 = ((this.f40523a * 31) + this.f40524b) * 31;
                Color color = this.f40525c;
                return i8 + (color == null ? 0 : color.hashCode());
            }

            public String toString() {
                int i8 = this.f40523a;
                int i9 = this.f40524b;
                Color color = this.f40525c;
                return "Animation(lottieResourceId=" + i8 + ", repeatCount=" + i9 + ", statusIconTint=" + color + ")";
            }
        }

        /* compiled from: ChatMessageDelegate.kt */
        /* loaded from: classes5.dex */
        public static final class Static extends StatusIcon {

            /* renamed from: a  reason: collision with root package name */
            private final int f40526a;

            /* renamed from: b  reason: collision with root package name */
            private final Color f40527b;

            public Static(int i8, Color color) {
                super(null);
                this.f40526a = i8;
                this.f40527b = color;
            }

            public final int a() {
                return this.f40526a;
            }

            public final Color b() {
                return this.f40527b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Static) {
                    Static r52 = (Static) obj;
                    return this.f40526a == r52.f40526a && Intrinsics.a(this.f40527b, r52.f40527b);
                }
                return false;
            }

            public int hashCode() {
                int i8 = this.f40526a * 31;
                Color color = this.f40527b;
                return i8 + (color == null ? 0 : color.hashCode());
            }

            public String toString() {
                int i8 = this.f40526a;
                Color color = this.f40527b;
                return "Static(resourceId=" + i8 + ", statusIconTint=" + color + ")";
            }
        }

        private StatusIcon() {
        }

        public /* synthetic */ StatusIcon(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatMessageDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f40528u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f40529v;

        /* renamed from: w  reason: collision with root package name */
        private final LottieAnimationView f40530w;

        /* renamed from: x  reason: collision with root package name */
        private final ConstraintLayout f40531x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) itemView.findViewById(R$id.f40405u);
            Intrinsics.d(appCompatTextView, "null cannot be cast to non-null type android.widget.TextView");
            this.f40528u = appCompatTextView;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) itemView.findViewById(R$id.A);
            Intrinsics.d(appCompatTextView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f40529v = appCompatTextView2;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) itemView.findViewById(R$id.f40402m);
            Intrinsics.d(lottieAnimationView, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            this.f40530w = lottieAnimationView;
            this.f40531x = (ConstraintLayout) itemView.findViewById(R$id.f40404q);
        }

        public final ConstraintLayout O() {
            return this.f40531x;
        }

        public final LottieAnimationView P() {
            return this.f40530w;
        }

        public final TextView Q() {
            return this.f40529v;
        }

        public final TextView R() {
            return this.f40528u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatMessageDelegate(Function1<? super Model, Unit> onMessageLongClick) {
        Intrinsics.f(onMessageLongClick, "onMessageLongClick");
        this.f40509b = onMessageLongClick;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(ChatMessageDelegate this$0, ViewHolder viewHolder, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(viewHolder, "$viewHolder");
        this$0.f40509b.invoke(this$0.d(viewHolder));
        return true;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public RecyclerView.ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View itemView = inflater.inflate(e(), parent, false);
        Intrinsics.e(itemView, "itemView");
        final ViewHolder viewHolder = new ViewHolder(itemView);
        itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: w6.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean v7;
                v7 = ChatMessageDelegate.v(ChatMessageDelegate.this, viewHolder, view);
                return v7;
            }
        });
        return viewHolder;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, Model model) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.R().getContext();
        holder.R().setTextSize(0, model.u());
        TextView R = holder.R();
        String t7 = model.t();
        if (t7 == null) {
            t7 = "";
        }
        R.setText(t7);
        holder.Q().setText(model.r());
        TextView Q = holder.Q();
        Color s7 = model.s();
        Intrinsics.e(context, "context");
        Q.setTextColor(ColorKt.a(s7, context));
        StatusIcon q8 = model.q();
        if (q8 instanceof StatusIcon.Static) {
            holder.P().l();
            holder.P().setImageResource(((StatusIcon.Static) model.q()).a());
            ImageViewExtKt.a(holder.P(), ((StatusIcon.Static) model.q()).b());
        } else if (q8 instanceof StatusIcon.Animation) {
            ImageViewExtKt.a(holder.P(), ((StatusIcon.Animation) model.q()).c());
            holder.P().setAnimation(((StatusIcon.Animation) model.q()).a());
            holder.P().setRepeatCount(((StatusIcon.Animation) model.q()).b());
            holder.P().x();
        }
        TextView Q2 = holder.Q();
        if (model.r() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(Q2, z7, 0, 2, null);
        Integer n8 = model.n();
        if (n8 != null) {
            holder.O().setBackgroundResource(n8.intValue());
        }
        ConstraintLayout messageBody = holder.O();
        Intrinsics.e(messageBody, "messageBody");
        ee.mtakso.driver.uikit.utils.ViewExtKt.b(messageBody, model.o());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
