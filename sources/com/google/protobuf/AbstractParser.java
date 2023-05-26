package com.google.protobuf;

import com.google.protobuf.MessageLite;

/* loaded from: classes3.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final ExtensionRegistryLite f17153a = ExtensionRegistryLite.b();

    private MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype != null && !messagetype.isInitialized()) {
            throw d(messagetype).a().k(messagetype);
        }
        return messagetype;
    }

    private UninitializedMessageException d(MessageType messagetype) {
        if (messagetype instanceof AbstractMessageLite) {
            return ((AbstractMessageLite) messagetype).newUninitializedMessageException();
        }
        return new UninitializedMessageException(messagetype);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: e */
    public MessageType a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return c(f(byteString, extensionRegistryLite));
    }

    public MessageType f(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            CodedInputStream B = byteString.B();
            MessageType messagetype = (MessageType) b(B, extensionRegistryLite);
            try {
                B.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e8) {
                throw e8.k(messagetype);
            }
        } catch (InvalidProtocolBufferException e9) {
            throw e9;
        }
    }
}
