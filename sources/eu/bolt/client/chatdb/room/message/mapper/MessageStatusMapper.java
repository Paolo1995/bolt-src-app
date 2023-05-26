package eu.bolt.client.chatdb.room.message.mapper;

import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.client.chatdb.room.message.MessageStatusDBModel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageStatusMapper.kt */
/* loaded from: classes5.dex */
public final class MessageStatusMapper {

    /* compiled from: MessageStatusMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39890a;

        static {
            int[] iArr = new int[MessageStatusDBModel.values().length];
            try {
                iArr[MessageStatusDBModel.SENDING_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageStatusDBModel.SENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageStatusDBModel.PRELIMINARY_DELIVERED_TO_BACKEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageStatusDBModel.DELIVERED_TO_BACKEND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessageStatusDBModel.DELIVERED_TO_RECIPIENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MessageStatusDBModel.LOCAL_SEEN_BY_RECIPIENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MessageStatusDBModel.SEEN_BY_RECIPIENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f39890a = iArr;
        }
    }

    public final ChatMessageStatus a(MessageStatusDBModel status) {
        Intrinsics.f(status, "status");
        switch (WhenMappings.f39890a[status.ordinal()]) {
            case 1:
                return ChatMessageStatus.SendingError.f38167b;
            case 2:
                return ChatMessageStatus.Sending.f38166b;
            case 3:
                return ChatMessageStatus.PreliminaryDeliveredToBackend.f38164b;
            case 4:
                return ChatMessageStatus.DeliveredToBackend.f38163b;
            case 5:
                throw new NotImplementedError("DELIVERED_TO_RECIPIENT not yet supported");
            case 6:
                return new ChatMessageStatus.SeenByRecipient(false);
            case 7:
                return new ChatMessageStatus.SeenByRecipient(true);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final MessageStatusDBModel b(ChatMessageStatus status) {
        Intrinsics.f(status, "status");
        if (status instanceof ChatMessageStatus.SendingError) {
            return MessageStatusDBModel.SENDING_ERROR;
        }
        if (status instanceof ChatMessageStatus.Sending) {
            return MessageStatusDBModel.SENDING;
        }
        if (status instanceof ChatMessageStatus.PreliminaryDeliveredToBackend) {
            return MessageStatusDBModel.PRELIMINARY_DELIVERED_TO_BACKEND;
        }
        if (status instanceof ChatMessageStatus.DeliveredToBackend) {
            return MessageStatusDBModel.DELIVERED_TO_BACKEND;
        }
        if (status instanceof ChatMessageStatus.SeenByRecipient) {
            if (((ChatMessageStatus.SeenByRecipient) status).a()) {
                return MessageStatusDBModel.SEEN_BY_RECIPIENT;
            }
            return MessageStatusDBModel.LOCAL_SEEN_BY_RECIPIENT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
