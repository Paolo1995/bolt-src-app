package eu.bolt.client.chatdb.room.message.mapper;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.entity.ChatMessageTranslation;
import eu.bolt.chat.chatcore.entity.ChatMessageType;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.client.chatdb.room.message.MessageDBModel;
import eu.bolt.client.chatdb.room.message.MessageStatusDBModel;
import eu.bolt.client.chatdb.room.message.translation.TranslationDBModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageMapper.kt */
/* loaded from: classes5.dex */
public final class MessageMapper {

    /* renamed from: a  reason: collision with root package name */
    private final TranslationMapper f39882a;

    /* renamed from: b  reason: collision with root package name */
    private final MessageStatusMapper f39883b;

    /* renamed from: c  reason: collision with root package name */
    private final MessageTypeMapper f39884c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfoProvider f39885d;

    @Inject
    public MessageMapper(TranslationMapper translationMapper, MessageStatusMapper messageStatusMapper, MessageTypeMapper messageTypeMapper, UserInfoProvider userInfoProvider) {
        Intrinsics.f(translationMapper, "translationMapper");
        Intrinsics.f(messageStatusMapper, "messageStatusMapper");
        Intrinsics.f(messageTypeMapper, "messageTypeMapper");
        Intrinsics.f(userInfoProvider, "userInfoProvider");
        this.f39882a = translationMapper;
        this.f39883b = messageStatusMapper;
        this.f39884c = messageTypeMapper;
        this.f39885d = userInfoProvider;
    }

    public final ChatMessageEntity a(MessageDBModel message) {
        List k8;
        ChatMessageTranslation chatMessageTranslation;
        Intrinsics.f(message, "message");
        String f8 = message.f();
        String d8 = message.d();
        k8 = CollectionsKt__CollectionsKt.k();
        ChatMessageType b8 = this.f39884c.b(message.n());
        String l8 = message.l();
        String i8 = message.i();
        String j8 = message.j();
        String g8 = message.g();
        long e8 = message.e();
        ChatMessageStatus a8 = this.f39883b.a(message.k());
        boolean a9 = Intrinsics.a(this.f39885d.k(), message.i());
        int h8 = message.h();
        boolean o8 = message.o();
        TranslationDBModel m8 = message.m();
        if (m8 != null) {
            chatMessageTranslation = this.f39882a.a(m8);
        } else {
            chatMessageTranslation = null;
        }
        return new ChatMessageEntity(f8, d8, b8, k8, l8, g8, i8, j8, e8, a8, a9, h8, o8, chatMessageTranslation);
    }

    public final MessageDBModel b(ChatMessageEntity message) {
        TranslationDBModel translationDBModel;
        Intrinsics.f(message, "message");
        String d8 = message.d();
        String b8 = message.b();
        int a8 = this.f39884c.a(message.m());
        String j8 = message.j();
        String g8 = message.g();
        String h8 = message.h();
        long c8 = message.c();
        MessageStatusDBModel b9 = this.f39883b.b(message.i());
        boolean o8 = message.o();
        ChatMessageTranslation l8 = message.l();
        if (l8 != null) {
            translationDBModel = this.f39882a.b(l8);
        } else {
            translationDBModel = null;
        }
        return new MessageDBModel(d8, b8, a8, null, j8, g8, h8, null, c8, b9, 0, o8, translationDBModel, 1152, null);
    }
}
