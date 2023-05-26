package com.google.protobuf;

/* loaded from: classes3.dex */
public interface Parser<MessageType> {
    MessageType a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;
}
