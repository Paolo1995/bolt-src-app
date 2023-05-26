package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;
import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.e();
    protected int memoizedSerializedSize = -1;

    /* loaded from: classes.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* renamed from: f  reason: collision with root package name */
        private final MessageType f15093f;

        /* renamed from: g  reason: collision with root package name */
        protected MessageType f15094g;

        /* renamed from: h  reason: collision with root package name */
        protected boolean f15095h = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(MessageType messagetype) {
            this.f15093f = messagetype;
            this.f15094g = (MessageType) messagetype.l(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        private void p(MessageType messagetype, MessageType messagetype2) {
            Protobuf.a().e(messagetype).a(messagetype, messagetype2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        /* renamed from: h */
        public final MessageType build() {
            MessageType g8 = g();
            if (g8.isInitialized()) {
                return g8;
            }
            throw AbstractMessageLite.Builder.f(g8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        /* renamed from: i */
        public MessageType g() {
            if (this.f15095h) {
                return this.f15094g;
            }
            this.f15094g.t();
            this.f15095h = true;
            return this.f15094g;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        /* renamed from: j */
        public BuilderType clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.o(g());
            return buildertype;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void k() {
            if (this.f15095h) {
                l();
                this.f15095h = false;
            }
        }

        protected void l() {
            MessageType messagetype = (MessageType) this.f15094g.l(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            p(messagetype, this.f15094g);
            this.f15094g = messagetype;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        /* renamed from: m */
        public MessageType getDefaultInstanceForType() {
            return this.f15093f;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        /* renamed from: n */
        public BuilderType d(MessageType messagetype) {
            return o(messagetype);
        }

        public BuilderType o(MessageType messagetype) {
            k();
            p(this.f15094g, messagetype);
            return this;
        }
    }

    /* loaded from: classes.dex */
    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f15096b;

        public DefaultInstanceBasedParser(T t7) {
            this.f15096b = t7;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Parser
        /* renamed from: g */
        public T a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.A(this.f15096b, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements MessageLiteOrBuilder {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.h();

        /* JADX INFO: Access modifiers changed from: package-private */
        public FieldSet<ExtensionDescriptor> E() {
            if (this.extensions.n()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }
    }

    /* loaded from: classes.dex */
    static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {

        /* renamed from: f  reason: collision with root package name */
        final Internal.EnumLiteMap<?> f15097f;

        /* renamed from: g  reason: collision with root package name */
        final int f15098g;

        /* renamed from: h  reason: collision with root package name */
        final WireFormat.FieldType f15099h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f15100i;

        /* renamed from: j  reason: collision with root package name */
        final boolean f15101j;

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.f15098g - extensionDescriptor.f15098g;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public boolean b() {
            return this.f15100i;
        }

        public Internal.EnumLiteMap<?> c() {
            return this.f15097f;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType d() {
            return this.f15099h;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType g() {
            return this.f15099h.a();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.f15098g;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public boolean i() {
            return this.f15101j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder o(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).o((GeneratedMessageLite) messageLite);
        }
    }

    /* loaded from: classes.dex */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final MessageLite f15102a;

        /* renamed from: b  reason: collision with root package name */
        final ExtensionDescriptor f15103b;

        public WireFormat.FieldType a() {
            return this.f15103b.d();
        }

        public MessageLite b() {
            return this.f15102a;
        }

        public int c() {
            return this.f15103b.getNumber();
        }

        public boolean d() {
            return this.f15103b.f15100i;
        }
    }

    /* loaded from: classes.dex */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    static <T extends GeneratedMessageLite<T, ?>> T A(T t7, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t8 = (T) t7.l(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Schema e8 = Protobuf.a().e(t8);
            e8.g(t8, CodedInputStreamReader.Q(codedInputStream), extensionRegistryLite);
            e8.b(t8);
            return t8;
        } catch (IOException e9) {
            if (e9.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e9.getCause());
            }
            throw new InvalidProtocolBufferException(e9.getMessage()).i(t8);
        } catch (RuntimeException e10) {
            if (e10.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e10.getCause());
            }
            throw e10;
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T B(T t7, byte[] bArr, int i8, int i9, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t8 = (T) t7.l(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Schema e8 = Protobuf.a().e(t8);
            e8.f(t8, bArr, i8, i8 + i9, new ArrayDecoders.Registers(extensionRegistryLite));
            e8.b(t8);
            if (t8.memoizedHashCode == 0) {
                return t8;
            }
            throw new RuntimeException();
        } catch (IOException e9) {
            if (e9.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e9.getCause());
            }
            throw new InvalidProtocolBufferException(e9.getMessage()).i(t8);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.j().i(t8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<?, ?>> void C(Class<T> cls, T t7) {
        defaultInstanceMap.put(cls, t7);
    }

    private static <T extends GeneratedMessageLite<T, ?>> T j(T t7) throws InvalidProtocolBufferException {
        if (t7 != null && !t7.isInitialized()) {
            throw t7.f().a().i(t7);
        }
        return t7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> o() {
        return ProtobufArrayList.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends GeneratedMessageLite<?, ?>> T p(Class<T> cls) {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e8) {
                throw new IllegalStateException("Class initialization cannot fail.", e8);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) UnsafeUtil.i(cls)).getDefaultInstanceForType();
            if (generatedMessageLite != null) {
                defaultInstanceMap.put(cls, generatedMessageLite);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) generatedMessageLite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object r(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e8);
        } catch (InvocationTargetException e9) {
            Throwable cause = e9.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean s(T t7, boolean z7) {
        Object obj;
        byte byteValue = ((Byte) t7.l(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c8 = Protobuf.a().e(t7).c(t7);
        if (z7) {
            MethodToInvoke methodToInvoke = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
            if (c8) {
                obj = t7;
            } else {
                obj = null;
            }
            t7.m(methodToInvoke, obj);
        }
        return c8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> u(Internal.ProtobufList<E> protobufList) {
        int i8;
        int size = protobufList.size();
        if (size == 0) {
            i8 = 10;
        } else {
            i8 = size * 2;
        }
        return protobufList.a(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object w(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T x(T t7, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) j(z(t7, byteString, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T y(T t7, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) j(B(t7, bArr, 0, bArr.length, extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T z(T t7, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            CodedInputStream u7 = byteString.u();
            T t8 = (T) A(t7, u7, extensionRegistryLite);
            try {
                u7.a(0);
                return t8;
            } catch (InvalidProtocolBufferException e8) {
                throw e8.i(t8);
            }
        } catch (InvalidProtocolBufferException e9) {
            throw e9;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    /* renamed from: D */
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) l(MethodToInvoke.NEW_BUILDER);
        buildertype.o(this);
        return buildertype;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        Protobuf.a().e(this).h(this, CodedOutputStreamWriter.P(codedOutputStream));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite
    int c() {
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return Protobuf.a().e(this).equals(this, (GeneratedMessageLite) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final Parser<MessageType> getParserForType() {
        return (Parser) l(MethodToInvoke.GET_PARSER);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = Protobuf.a().e(this).d(this);
        }
        return this.memoizedSerializedSize;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite
    void h(int i8) {
        this.memoizedSerializedSize = i8;
    }

    public int hashCode() {
        int i8 = this.memoizedHashCode;
        if (i8 != 0) {
            return i8;
        }
        int hashCode = Protobuf.a().e(this).hashCode(this);
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object i() throws Exception {
        return l(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return s(this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType k() {
        return (BuilderType) l(MethodToInvoke.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object l(MethodToInvoke methodToInvoke) {
        return n(methodToInvoke, null, null);
    }

    protected Object m(MethodToInvoke methodToInvoke, Object obj) {
        return n(methodToInvoke, obj, null);
    }

    protected abstract Object n(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    /* renamed from: q */
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) l(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    protected void t() {
        Protobuf.a().e(this).b(this);
    }

    public String toString() {
        return MessageLiteToString.e(this, super.toString());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    /* renamed from: v */
    public final BuilderType newBuilderForType() {
        return (BuilderType) l(MethodToInvoke.NEW_BUILDER);
    }
}
