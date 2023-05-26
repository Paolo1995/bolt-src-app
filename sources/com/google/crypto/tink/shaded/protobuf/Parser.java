package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public interface Parser<MessageType> {
    MessageType a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType b(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;
}
