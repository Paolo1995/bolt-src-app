package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.text.EmojiSpan;
import com.google.android.gms.common.api.Api;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Background;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.entity.ChatMessageTranslation;
import eu.bolt.chat.chatcore.entity.ChatMessageType;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.chat.chatcore.entity.TranslationAttribution;
import eu.bolt.driver.chat.R$attr;
import eu.bolt.driver.chat.R$dimen;
import eu.bolt.driver.chat.R$drawable;
import eu.bolt.driver.chat.R$raw;
import eu.bolt.driver.chat.R$string;
import eu.bolt.driver.chat.R$style;
import eu.bolt.driver.chat.ui.message.list.ChatMessageDelegate;
import eu.bolt.driver.chat.ui.message.list.ChatNewMessageDelimiterDelegate;
import eu.bolt.driver.chat.ui.message.list.ChatQuickReplyDelegate;
import eu.bolt.driver.chat.ui.message.list.ChatTerminalMessageDelegate;
import eu.bolt.driver.chat.ui.message.list.ChatTranslatedMessageDelegate;
import eu.bolt.driver.core.util.DateTimeFormatter;
import eu.bolt.driver.core.util.StringUtilsKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageMapper.kt */
/* loaded from: classes5.dex */
public final class MessageMapper {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f40699c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DateTimeFormatter f40700a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, ChatMessageStatus> f40701b;

    /* compiled from: MessageMapper.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MessageMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40702a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f40703b;

        static {
            int[] iArr = new int[ChatMessageType.values().length];
            try {
                iArr[ChatMessageType.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatMessageType.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f40702a = iArr;
            int[] iArr2 = new int[ChatMessageDelegate.Direction.values().length];
            try {
                iArr2[ChatMessageDelegate.Direction.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            f40703b = iArr2;
        }
    }

    @Inject
    public MessageMapper(DateTimeFormatter dateTimeFormatter) {
        Intrinsics.f(dateTimeFormatter, "dateTimeFormatter");
        this.f40700a = dateTimeFormatter;
        this.f40701b = new LinkedHashMap();
    }

    private final Image a(TranslationAttribution translationAttribution) {
        String a8;
        if (translationAttribution != null && (a8 = translationAttribution.a()) != null) {
            return new Image.Url(a8);
        }
        return null;
    }

    private final Text b(TranslationAttribution translationAttribution) {
        String str;
        List e8;
        if (translationAttribution != null) {
            str = translationAttribution.b();
        } else {
            str = null;
        }
        if (str != null) {
            int i8 = R$string.chat_translated_by_provider;
            e8 = CollectionsKt__CollectionsJVMKt.e(str);
            return new Text.Resource(i8, e8);
        }
        return new Text.Resource(R$string.chat_translated_automatically, null, 2, null);
    }

    private final ChatMessageDelegate.StatusIcon c(ChatMessageEntity chatMessageEntity) {
        if (Intrinsics.a(this.f40701b.get(chatMessageEntity.d()), ChatMessageStatus.DeliveredToBackend.f38163b)) {
            return new ChatMessageDelegate.StatusIcon.Animation(R$raw.status_seen, 0, new Color.Attr(R$attr.accentGreen));
        }
        return new ChatMessageDelegate.StatusIcon.Static(R$drawable.ic_chat_status_double_check, new Color.Attr(R$attr.accentGreen));
    }

    private final boolean d(String str) {
        boolean z7;
        if (str != null && str.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            return false;
        }
        CharSequence o8 = EmojiCompat.a().o(str, 0, str.length() - 1, Api.BaseClientBuilder.API_PRIORITY_OTHER, 1);
        if (!(o8 instanceof Spannable)) {
            return false;
        }
        EmojiSpan[] emojis = (EmojiSpan[]) ((Spannable) o8).getSpans(0, o8.length() - 1, EmojiSpan.class);
        Intrinsics.e(emojis, "emojis");
        int i8 = 0;
        for (EmojiSpan emojiSpan : emojis) {
            Spannable spannable = (Spannable) o8;
            i8 += spannable.getSpanStart(emojiSpan) + spannable.getSpanEnd(emojiSpan);
        }
        if (emojis.length == 1 && o8.length() - i8 == 0) {
            return true;
        }
        return false;
    }

    private final ListModel e(ChatMessageEntity chatMessageEntity, Context context) {
        int i8 = WhenMappings.f40702a[chatMessageEntity.m().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                return null;
            }
            return h(chatMessageEntity);
        }
        return k(chatMessageEntity, context);
    }

    private final InfoBlockDelegate.Model h(ChatMessageEntity chatMessageEntity) {
        Text.Value value;
        CharSequence a8;
        String str = "ServiceMessage" + chatMessageEntity.hashCode();
        String j8 = chatMessageEntity.j();
        if (j8 != null && (a8 = StringUtilsKt.a(j8)) != null) {
            value = new Text.Value(a8);
        } else {
            value = null;
        }
        Integer valueOf = Integer.valueOf(R$style.f40407a);
        int i8 = R$attr.infoBlockTextWarning;
        return new InfoBlockDelegate.Model(str, value, valueOf, new Color.Attr(i8), new Color.Attr(i8), null, null, null, new Background.Attr(R$attr.f40399h), new Color.Attr(R$attr.infoBlockBackgroundTintWarning), null, null, Dimens.c(16), Dimens.c(16), new Margins(Dimens.c(16), Dimens.c(12), Dimens.c(16), Dimens.c(12)), 3296, null);
    }

    private final ChatMessageDelegate.Model i(ChatMessageEntity chatMessageEntity, Context context) {
        ChatMessageDelegate.Direction direction;
        int i8;
        boolean a8;
        boolean a9;
        ChatMessageDelegate.StatusIcon c8;
        int i9;
        Color.Attr attr;
        if (chatMessageEntity.n()) {
            direction = ChatMessageDelegate.Direction.OUT;
        } else {
            direction = ChatMessageDelegate.Direction.IN;
        }
        ChatMessageDelegate.Direction direction2 = direction;
        Resources resources = context.getResources();
        if (d(chatMessageEntity.j())) {
            i8 = R$dimen.text_size_24;
        } else {
            i8 = R$dimen.text_size_16;
        }
        float dimension = resources.getDimension(i8);
        ChatMessageStatus i10 = chatMessageEntity.i();
        if (i10 instanceof ChatMessageStatus.Sending) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(i10, ChatMessageStatus.SendingError.f38167b);
        }
        if (a8) {
            a9 = true;
        } else {
            a9 = Intrinsics.a(i10, ChatMessageStatus.PreliminaryDeliveredToBackend.f38164b);
        }
        if (a9) {
            c8 = new ChatMessageDelegate.StatusIcon.Animation(R$raw.status_loading, -1, new Color.Attr(R$attr.f40397d));
        } else if (i10 instanceof ChatMessageStatus.DeliveredToBackend) {
            c8 = new ChatMessageDelegate.StatusIcon.Static(R$drawable.ic_chat_status_check, new Color.Attr(R$attr.f40397d));
        } else if (i10 instanceof ChatMessageStatus.SeenByRecipient) {
            c8 = c(chatMessageEntity);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ChatMessageDelegate.StatusIcon statusIcon = c8;
        this.f40701b.put(chatMessageEntity.d(), chatMessageEntity.i());
        String d8 = chatMessageEntity.d();
        String j8 = chatMessageEntity.j();
        Color.Attr attr2 = new Color.Attr(R$attr.f40397d);
        int[] iArr = WhenMappings.f40703b;
        if (iArr[direction2.ordinal()] == 1) {
            i9 = R$drawable.chat_message_in_back;
        } else {
            i9 = R$drawable.chat_message_out_back;
        }
        if (iArr[direction2.ordinal()] == 1) {
            attr = new Color.Attr(R$attr.f40398e);
        } else {
            attr = new Color.Attr(R$attr.backAccent);
        }
        Color.Attr attr3 = attr;
        ChatMessageStatus i11 = chatMessageEntity.i();
        String str = "";
        if (!Intrinsics.a(i11, ChatMessageStatus.Sending.f38166b) && !Intrinsics.a(i11, ChatMessageStatus.SendingError.f38167b)) {
            str = this.f40700a.c(chatMessageEntity.c());
        }
        return new ChatMessageDelegate.Model(d8, j8, dimension, str, statusIcon, Integer.valueOf(i9), attr3, attr2, direction2, chatMessageEntity);
    }

    private final ListModel k(ChatMessageEntity chatMessageEntity, Context context) {
        if (chatMessageEntity.l() != null) {
            return l(chatMessageEntity);
        }
        return i(chatMessageEntity, context);
    }

    private final ChatTranslatedMessageDelegate.Model l(ChatMessageEntity chatMessageEntity) {
        ChatMessageTranslation l8;
        String j8 = chatMessageEntity.j();
        if (j8 == null || (l8 = chatMessageEntity.l()) == null) {
            return null;
        }
        return new ChatTranslatedMessageDelegate.Model(chatMessageEntity.d(), new Text.Value(j8), new Text.Value(l8.b()), new Text.Value(this.f40700a.c(chatMessageEntity.c())), b(l8.a()), a(l8.a()), chatMessageEntity);
    }

    public final List<ListModel> f(List<ChatMessageEntity> messages, String str, Context context) {
        ChatNewMessageDelimiterDelegate.Model model;
        List p8;
        Intrinsics.f(messages, "messages");
        Intrinsics.f(context, "context");
        ArrayList arrayList = new ArrayList();
        for (ChatMessageEntity chatMessageEntity : messages) {
            ListModel e8 = e(chatMessageEntity, context);
            if (Intrinsics.a(chatMessageEntity.d(), str) && e8 != null) {
                String string = context.getString(R$string.chat_delimiter_text);
                Intrinsics.e(string, "context.getString(R.string.chat_delimiter_text)");
                Locale locale = Locale.getDefault();
                Intrinsics.e(locale, "getDefault()");
                String upperCase = string.toUpperCase(locale);
                Intrinsics.e(upperCase, "this as java.lang.String).toUpperCase(locale)");
                model = new ChatNewMessageDelimiterDelegate.Model("ID_NEW_MESSAGE_DELIMITER", upperCase);
            } else {
                model = null;
            }
            p8 = CollectionsKt__CollectionsKt.p(model, e8);
            CollectionsKt__MutableCollectionsKt.A(arrayList, p8);
        }
        return arrayList;
    }

    public final List<ChatQuickReplyDelegate.Model> g(List<QuickReplyEntity> list) {
        int v7;
        Intrinsics.f(list, "list");
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (QuickReplyEntity quickReplyEntity : list) {
            arrayList.add(new ChatQuickReplyDelegate.Model(quickReplyEntity.a(), quickReplyEntity.b(), quickReplyEntity));
        }
        return arrayList;
    }

    public final ChatTerminalMessageDelegate.Model j(TerminationInfo terminationInfo, Context context) {
        String d8;
        Intrinsics.f(terminationInfo, "terminationInfo");
        Intrinsics.f(context, "context");
        boolean a8 = Intrinsics.a(terminationInfo.e(), "finished");
        String e8 = terminationInfo.e();
        if (Intrinsics.a(e8, "finished")) {
            d8 = context.getString(R$string.chat_terminal_finished);
        } else if (Intrinsics.a(e8, "aborted")) {
            d8 = context.getString(R$string.chat_terminal_aborted);
        } else {
            d8 = terminationInfo.d();
        }
        String str = d8;
        Intrinsics.e(str, "when (terminationInfo.st…ionInfo.message\n        }");
        if (a8) {
            int i8 = R$drawable.ic_chat_terminal_check;
            int i9 = R$attr.accentGreen;
            Color.Attr attr = new Color.Attr(i9);
            Color.Attr attr2 = new Color.Attr(i9);
            int i10 = R$drawable.chat_message_terminal_success_back;
            return new ChatTerminalMessageDelegate.Model("terminal", str, i8, attr, Integer.valueOf(i10), new Color.Attr(i9), attr2);
        }
        int i11 = R$drawable.ic_common_alert;
        int i12 = R$attr.contentCritical;
        Color.Attr attr3 = new Color.Attr(i12);
        Color.Attr attr4 = new Color.Attr(i12);
        int i13 = R$drawable.chat_message_terminal_alert_back;
        return new ChatTerminalMessageDelegate.Model("terminal", str, i11, attr3, Integer.valueOf(i13), new Color.Attr(i12), attr4);
    }
}
