package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MessageLite;

/* loaded from: classes.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final ExtensionRegistryLite f14970a = ExtensionRegistryLite.b();

    private MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype != null && !messagetype.isInitialized()) {
            throw d(messagetype).a().i(messagetype);
        }
        return messagetype;
    }

    private UninitializedMessageException d(MessageType messagetype) {
        if (messagetype instanceof AbstractMessageLite) {
            return ((AbstractMessageLite) messagetype).f();
        }
        return new UninitializedMessageException(messagetype);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    /* renamed from: e */
    public MessageType b(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return c(f(byteString, extensionRegistryLite));
    }

    public MessageType f(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            CodedInputStream u7 = byteString.u();
            MessageType messagetype = (MessageType) a(u7, extensionRegistryLite);
            try {
                u7.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e8) {
                throw e8.i(messagetype);
            }
        } catch (InvalidProtocolBufferException e9) {
            throw e9;
        }
    }
}
