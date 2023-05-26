package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite.Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode = 0;

    @Deprecated
    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        Builder.a(iterable, (List) collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkByteStringIsUtf8(ByteString byteString) throws IllegalArgumentException {
        if (byteString.y()) {
            return;
        }
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSerializedSize(Schema schema) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize == -1) {
            int d8 = schema.d(this);
            setMemoizedSerializedSize(d8);
            return d8;
        }
        return memoizedSerializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    void setMemoizedSerializedSize(int i8) {
        throw new UnsupportedOperationException();
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream g02 = CodedOutputStream.g0(bArr);
            writeTo(g02);
            g02.d();
            return bArr;
        } catch (IOException e8) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e8);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        try {
            ByteString.CodedBuilder A = ByteString.A(getSerializedSize());
            writeTo(A.b());
            return A.a();
        } catch (IOException e8) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e8);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream f02 = CodedOutputStream.f0(outputStream, CodedOutputStream.J(CodedOutputStream.X(serializedSize) + serializedSize));
        f02.Y0(serializedSize);
        writeTo(f02);
        f02.c0();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream f02 = CodedOutputStream.f0(outputStream, CodedOutputStream.J(getSerializedSize()));
        writeTo(f02);
        f02.c0();
    }

    /* loaded from: classes3.dex */
    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
        protected static <T> void a(Iterable<T> iterable, List<? super T> list) {
            Internal.a(iterable);
            if (iterable instanceof LazyStringList) {
                List<?> e8 = ((LazyStringList) iterable).e();
                LazyStringList lazyStringList = (LazyStringList) list;
                int size = list.size();
                for (Object obj : e8) {
                    if (obj == null) {
                        String str = "Element at index " + (lazyStringList.size() - size) + " is null.";
                        for (int size2 = lazyStringList.size() - 1; size2 >= size; size2--) {
                            lazyStringList.remove(size2);
                        }
                        throw new NullPointerException(str);
                    } else if (obj instanceof ByteString) {
                        lazyStringList.t((ByteString) obj);
                    } else {
                        lazyStringList.add((String) obj);
                    }
                }
            } else if (iterable instanceof PrimitiveNonBoxingCollection) {
                list.addAll((Collection) iterable);
            } else {
                b(iterable, list);
            }
        }

        private static <T> void b(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T t7 : iterable) {
                if (t7 == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(t7);
            }
        }

        private String d(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException j(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        @Override // 
        /* renamed from: c */
        public abstract BuilderType clone();

        protected abstract BuilderType e(MessageType messagetype);

        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: f */
        public BuilderType F(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            try {
                CodedInputStream B = byteString.B();
                y(B, extensionRegistryLite);
                B.a(0);
                return this;
            } catch (InvalidProtocolBufferException e8) {
                throw e8;
            } catch (IOException e9) {
                throw new RuntimeException(d("ByteString"), e9);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: h */
        public abstract BuilderType y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: i */
        public BuilderType w(MessageLite messageLite) {
            if (getDefaultInstanceForType().getClass().isInstance(messageLite)) {
                return (BuilderType) e((AbstractMessageLite) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class LimitedInputStream extends FilterInputStream {

            /* renamed from: f  reason: collision with root package name */
            private int f17152f;

            /* JADX INFO: Access modifiers changed from: package-private */
            public LimitedInputStream(InputStream inputStream, int i8) {
                super(inputStream);
                this.f17152f = i8;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f17152f);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f17152f <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f17152f--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j8) throws IOException {
                int skip = (int) super.skip(Math.min(j8, this.f17152f));
                if (skip >= 0) {
                    this.f17152f -= skip;
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i8, int i9) throws IOException {
                int i10 = this.f17152f;
                if (i10 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i8, Math.min(i9, i10));
                if (read >= 0) {
                    this.f17152f -= read;
                }
                return read;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        Builder.a(iterable, list);
    }
}
