package eu.bolt.client.chatdb.room.message.mapper;

import eu.bolt.chat.chatcore.entity.ChatMessageType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageTypeMapper.kt */
/* loaded from: classes5.dex */
public final class MessageTypeMapper {

    /* compiled from: MessageTypeMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39892a;

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
            f39892a = iArr;
        }
    }

    public final int a(ChatMessageType messageType) {
        Intrinsics.f(messageType, "messageType");
        int i8 = WhenMappings.f39892a[messageType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return 2;
            }
            throw new NoWhenBranchMatchedException();
        }
        return 1;
    }

    public final ChatMessageType b(int i8) {
        if (i8 == 2) {
            return ChatMessageType.SERVICE;
        }
        return ChatMessageType.TEXT;
    }
}
