package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode = 0;

    /* loaded from: classes.dex */
    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException f(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        @Override // 
        /* renamed from: c */
        public abstract BuilderType clone();

        protected abstract BuilderType d(MessageType messagetype);

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        /* renamed from: e */
        public BuilderType I(MessageLite messageLite) {
            if (getDefaultInstanceForType().getClass().isInstance(messageLite)) {
                return (BuilderType) d((AbstractMessageLite) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    private String e(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public byte[] a() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream d02 = CodedOutputStream.d0(bArr);
            b(d02);
            d02.c();
            return bArr;
        } catch (IOException e8) {
            throw new RuntimeException(e("byte array"), e8);
        }
    }

    int c() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(Schema schema) {
        int c8 = c();
        if (c8 == -1) {
            int d8 = schema.d(this);
            h(d8);
            return d8;
        }
        return c8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException f() {
        return new UninitializedMessageException(this);
    }

    void h(int i8) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public ByteString toByteString() {
        try {
            ByteString.CodedBuilder s7 = ByteString.s(getSerializedSize());
            b(s7.b());
            return s7.a();
        } catch (IOException e8) {
            throw new RuntimeException(e("ByteString"), e8);
        }
    }
}
