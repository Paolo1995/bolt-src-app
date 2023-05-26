package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.c();
    protected int memoizedSerializedSize = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17418a;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            f17418a = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17418a[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* renamed from: f  reason: collision with root package name */
        private final MessageType f17419f;

        /* renamed from: g  reason: collision with root package name */
        protected MessageType f17420g;

        /* renamed from: h  reason: collision with root package name */
        protected boolean f17421h = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(MessageType messagetype) {
            this.f17419f = messagetype;
            this.f17420g = (MessageType) messagetype.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        private void t(MessageType messagetype, MessageType messagetype2) {
            Protobuf.a().e(messagetype).a(messagetype, messagetype2);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.f17420g, false);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: k */
        public final MessageType build() {
            MessageType g8 = g();
            if (g8.isInitialized()) {
                return g8;
            }
            throw AbstractMessageLite.Builder.j(g8);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: l */
        public MessageType g() {
            if (this.f17421h) {
                return this.f17420g;
            }
            this.f17420g.makeImmutable();
            this.f17421h = true;
            return this.f17420g;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: m */
        public BuilderType clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.s(g());
            return buildertype;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void n() {
            if (this.f17421h) {
                o();
                this.f17421h = false;
            }
        }

        protected void o() {
            MessageType messagetype = (MessageType) this.f17420g.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            t(messagetype, this.f17420g);
            this.f17420g = messagetype;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: p */
        public MessageType getDefaultInstanceForType() {
            return this.f17419f;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: q */
        public BuilderType e(MessageType messagetype) {
            return s(messagetype);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: r */
        public BuilderType y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            n();
            try {
                Protobuf.a().e(this.f17420g).g(this.f17420g, CodedInputStreamReader.Q(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e8) {
                if (e8.getCause() instanceof IOException) {
                    throw ((IOException) e8.getCause());
                }
                throw e8;
            }
        }

        public BuilderType s(MessageType messagetype) {
            n();
            t(this.f17420g, messagetype);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f17422b;

        public DefaultInstanceBasedParser(T t7) {
            this.f17422b = t7;
        }

        @Override // com.google.protobuf.Parser
        /* renamed from: g */
        public T b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.parsePartialFrom(this.f17422b, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements MessageLiteOrBuilder {
        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableBuilder(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        protected void o() {
            super.o();
            MessageType messagetype = this.f17420g;
            ((ExtendableMessage) messagetype).extensions = ((ExtendableMessage) messagetype).extensions.clone();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: u */
        public final MessageType l() {
            if (this.f17421h) {
                return (MessageType) this.f17420g;
            }
            ((ExtendableMessage) this.f17420g).extensions.x();
            return (MessageType) super.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {

        /* renamed from: f  reason: collision with root package name */
        final Internal.EnumLiteMap<?> f17427f;

        /* renamed from: g  reason: collision with root package name */
        final int f17428g;

        /* renamed from: h  reason: collision with root package name */
        final WireFormat.FieldType f17429h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f17430i;

        /* renamed from: j  reason: collision with root package name */
        final boolean f17431j;

        ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i8, WireFormat.FieldType fieldType, boolean z7, boolean z8) {
            this.f17427f = enumLiteMap;
            this.f17428g = i8;
            this.f17429h = fieldType;
            this.f17430i = z7;
            this.f17431j = z8;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.f17428g - extensionDescriptor.f17428g;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean b() {
            return this.f17430i;
        }

        public Internal.EnumLiteMap<?> c() {
            return this.f17427f;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType d() {
            return this.f17429h;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType g() {
            return this.f17429h.a();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.f17428g;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean i() {
            return this.f17431j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder n(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).s((GeneratedMessageLite) messageLite);
        }
    }

    /* loaded from: classes3.dex */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final ContainingType f17432a;

        /* renamed from: b  reason: collision with root package name */
        final Type f17433b;

        /* renamed from: c  reason: collision with root package name */
        final MessageLite f17434c;

        /* renamed from: d  reason: collision with root package name */
        final ExtensionDescriptor f17435d;

        GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype != null) {
                if (extensionDescriptor.d() == WireFormat.FieldType.f17682r && messageLite == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.f17432a = containingtype;
                this.f17433b = type;
                this.f17434c = messageLite;
                this.f17435d = extensionDescriptor;
                return;
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        Object b(Object obj) {
            if (this.f17435d.b()) {
                if (this.f17435d.g() == WireFormat.JavaType.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : (List) obj) {
                        arrayList.add(h(obj2));
                    }
                    return arrayList;
                }
                return obj;
            }
            return h(obj);
        }

        public ContainingType c() {
            return this.f17432a;
        }

        public WireFormat.FieldType d() {
            return this.f17435d.d();
        }

        public MessageLite e() {
            return this.f17434c;
        }

        public int f() {
            return this.f17435d.getNumber();
        }

        public boolean g() {
            return this.f17435d.f17430i;
        }

        Object h(Object obj) {
            if (this.f17435d.g() == WireFormat.JavaType.ENUM) {
                return this.f17435d.f17427f.a(((Integer) obj).intValue());
            }
            return obj;
        }

        Object i(Object obj) {
            if (this.f17435d.g() == WireFormat.JavaType.ENUM) {
                return Integer.valueOf(((Internal.EnumLite) obj).getNumber());
            }
            return obj;
        }
    }

    /* loaded from: classes3.dex */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> extensionLite) {
        if (extensionLite.a()) {
            return (GeneratedExtension) extensionLite;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t7) throws InvalidProtocolBufferException {
        if (t7 != null && !t7.isInitialized()) {
            throw t7.newUninitializedMessageException().a().k(t7);
        }
        return t7;
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.i();
    }

    protected static Internal.FloatList emptyFloatList() {
        return FloatArrayList.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.IntList emptyIntList() {
        return IntArrayList.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.LongList emptyLongList() {
        return LongArrayList.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.f();
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == UnknownFieldSetLite.c()) {
            this.unknownFields = UnknownFieldSetLite.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
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
            generatedMessageLite = (T) ((GeneratedMessageLite) UnsafeUtil.l(cls)).getDefaultInstanceForType();
            if (generatedMessageLite != null) {
                defaultInstanceMap.put(cls, generatedMessageLite);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) generatedMessageLite;
    }

    static java.lang.reflect.Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object invokeOrDie(java.lang.reflect.Method method, Object obj, Object... objArr) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$IntList] */
    public static Internal.IntList mutableCopy(Internal.IntList intList) {
        int size = intList.size();
        return intList.a(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object newMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i8, WireFormat.FieldType fieldType, boolean z7, Class cls) {
        return new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i8, fieldType, true, z7), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i8, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension<>(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i8, fieldType, false, false), cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t7, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t7, inputStream, ExtensionRegistryLite.b()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t7, ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t7, CodedInputStream.k(byteBuffer), extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T t7, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream h8 = CodedInputStream.h(new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.D(read, inputStream)));
            T t8 = (T) parsePartialFrom(t7, h8, extensionRegistryLite);
            try {
                h8.a(0);
                return t8;
            } catch (InvalidProtocolBufferException e8) {
                throw e8.k(t8);
            }
        } catch (InvalidProtocolBufferException e9) {
            if (e9.a()) {
                throw new InvalidProtocolBufferException(e9);
            }
            throw e9;
        } catch (IOException e10) {
            throw new InvalidProtocolBufferException(e10);
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t7, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t8 = (T) t7.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Schema e8 = Protobuf.a().e(t8);
            e8.g(t8, CodedInputStreamReader.Q(codedInputStream), extensionRegistryLite);
            e8.b(t8);
            return t8;
        } catch (InvalidProtocolBufferException e9) {
            e = e9;
            if (e.a()) {
                e = new InvalidProtocolBufferException(e);
            }
            throw e.k(t8);
        } catch (UninitializedMessageException e10) {
            throw e10.a().k(t8);
        } catch (IOException e11) {
            if (e11.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e11.getCause());
            }
            throw new InvalidProtocolBufferException(e11).k(t8);
        } catch (RuntimeException e12) {
            if (e12.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e12.getCause());
            }
            throw e12;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t7) {
        defaultInstanceMap.put(cls, t7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, null);
    }

    protected abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Protobuf.a().e(this).equals(this, (GeneratedMessageLite) obj);
    }

    @Override // com.google.protobuf.AbstractMessageLite
    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    @Override // com.google.protobuf.MessageLite
    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = Protobuf.a().e(this).d(this);
        }
        return this.memoizedSerializedSize;
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

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    protected void makeImmutable() {
        Protobuf.a().e(this).b(this);
    }

    protected void mergeLengthDelimitedField(int i8, ByteString byteString) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.k(i8, byteString);
    }

    protected final void mergeUnknownFields(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.m(this.unknownFields, unknownFieldSetLite);
    }

    protected void mergeVarintField(int i8, int i9) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.l(i8, i9);
    }

    protected boolean parseUnknownField(int i8, CodedInputStream codedInputStream) throws IOException {
        if (WireFormat.b(i8) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.i(i8, codedInputStream);
    }

    @Override // com.google.protobuf.AbstractMessageLite
    void setMemoizedSerializedSize(int i8) {
        this.memoizedSerializedSize = i8;
    }

    public String toString() {
        return MessageLiteToString.e(this, super.toString());
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Protobuf.a().e(this).f(this, CodedOutputStreamWriter.P(codedOutputStream));
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t7, boolean z7) {
        byte byteValue = ((Byte) t7.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c8 = Protobuf.a().e(t7).c(t7);
        if (z7) {
            t7.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, c8 ? t7 : null);
        }
        return c8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return (BuilderType) createBuilder().s(messagetype);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.protobuf.MessageLite
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    @Override // com.google.protobuf.MessageLite
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
        buildertype.s(this);
        return buildertype;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$LongList] */
    public static Internal.LongList mutableCopy(Internal.LongList longList) {
        int size = longList.size();
        return longList.a(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t7, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (T) parseFrom(t7, byteBuffer, ExtensionRegistryLite.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t7, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t7, inputStream, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t7, ByteString byteString) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t7, byteString, ExtensionRegistryLite.b()));
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements MessageLiteOrBuilder {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.h();

        /* loaded from: classes3.dex */
        protected class ExtensionWriter {

            /* renamed from: a  reason: collision with root package name */
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> f17423a;

            /* renamed from: b  reason: collision with root package name */
            private Map.Entry<ExtensionDescriptor, Object> f17424b;

            /* renamed from: c  reason: collision with root package name */
            private final boolean f17425c;

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z7, AnonymousClass1 anonymousClass1) {
                this(z7);
            }

            private ExtensionWriter(boolean z7) {
                Iterator<Map.Entry<ExtensionDescriptor, Object>> w7 = ExtendableMessage.this.extensions.w();
                this.f17423a = w7;
                if (w7.hasNext()) {
                    this.f17424b = w7.next();
                }
                this.f17425c = z7;
            }
        }

        private void eagerlyMergeMessageSetExtension(CodedInputStream codedInputStream, GeneratedExtension<?, ?> generatedExtension, ExtensionRegistryLite extensionRegistryLite, int i8) throws IOException {
            parseExtension(codedInputStream, extensionRegistryLite, generatedExtension, WireFormat.c(i8, 2), i8);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, GeneratedExtension<?, ?> generatedExtension) throws IOException {
            MessageLite.Builder builder;
            MessageLite messageLite = (MessageLite) this.extensions.i(generatedExtension.f17435d);
            if (messageLite != null) {
                builder = messageLite.toBuilder();
            } else {
                builder = null;
            }
            if (builder == null) {
                builder = generatedExtension.e().newBuilderForType();
            }
            builder.F(byteString, extensionRegistryLite);
            ensureExtensionsAreMutable().C(generatedExtension.f17435d, generatedExtension.i(builder.build()));
        }

        private <MessageType extends MessageLite> void mergeMessageSetExtensionFromCodedStream(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i8 = 0;
            ByteString byteString = null;
            GeneratedExtension<?, ?> generatedExtension = null;
            while (true) {
                int K = codedInputStream.K();
                if (K == 0) {
                    break;
                } else if (K == WireFormat.f17669c) {
                    i8 = codedInputStream.L();
                    if (i8 != 0) {
                        generatedExtension = extensionRegistryLite.a(messagetype, i8);
                    }
                } else if (K == WireFormat.f17670d) {
                    if (i8 != 0 && generatedExtension != null) {
                        eagerlyMergeMessageSetExtension(codedInputStream, generatedExtension, extensionRegistryLite, i8);
                        byteString = null;
                    } else {
                        byteString = codedInputStream.s();
                    }
                } else if (!codedInputStream.N(K)) {
                    break;
                }
            }
            codedInputStream.a(WireFormat.f17668b);
            if (byteString != null && i8 != 0) {
                if (generatedExtension != null) {
                    mergeMessageSetExtensionFromBytes(byteString, extensionRegistryLite, generatedExtension);
                } else {
                    mergeLengthDelimitedField(i8, byteString);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean parseExtension(com.google.protobuf.CodedInputStream r6, com.google.protobuf.ExtensionRegistryLite r7, com.google.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r8, int r9, int r10) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 291
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.ExtendableMessage.parseExtension(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite, com.google.protobuf.GeneratedMessageLite$GeneratedExtension, int, int):boolean");
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.c() == getDefaultInstanceForType()) {
                return;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            if (this.extensions.r()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.s();
        }

        protected int extensionsSerializedSize() {
            return this.extensions.n();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.j();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            Object i8 = this.extensions.i(checkIsLite.f17435d);
            if (i8 == null) {
                return checkIsLite.f17433b;
            }
            return (Type) checkIsLite.b(i8);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            return this.extensions.m(checkIsLite.f17435d);
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            return this.extensions.p(checkIsLite.f17435d);
        }

        protected final void mergeExtensionFields(MessageType messagetype) {
            if (this.extensions.r()) {
                this.extensions = this.extensions.clone();
            }
            this.extensions.y(messagetype.extensions);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        protected <MessageType extends MessageLite> boolean parseUnknownField(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i8) throws IOException {
            int a8 = WireFormat.a(i8);
            return parseExtension(codedInputStream, extensionRegistryLite, extensionRegistryLite.a(messagetype, a8), i8, a8);
        }

        protected <MessageType extends MessageLite> boolean parseUnknownFieldAsMessageSet(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i8) throws IOException {
            if (i8 == WireFormat.f17667a) {
                mergeMessageSetExtensionFromCodedStream(messagetype, codedInputStream, extensionRegistryLite);
                return true;
            } else if (WireFormat.b(i8) == 2) {
                return parseUnknownField(messagetype, codedInputStream, extensionRegistryLite, i8);
            } else {
                return codedInputStream.N(i8);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i8) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            return (Type) checkIsLite.h(this.extensions.l(checkIsLite.f17435d, i8));
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$FloatList] */
    protected static Internal.FloatList mutableCopy(Internal.FloatList floatList) {
        int size = floatList.size();
        return floatList.a(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t7, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t7, byteString, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$DoubleList] */
    public static Internal.DoubleList mutableCopy(Internal.DoubleList doubleList) {
        int size = doubleList.size();
        return doubleList.a(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t7, byte[] bArr) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t7, bArr, 0, bArr.length, ExtensionRegistryLite.b()));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$BooleanList] */
    protected static Internal.BooleanList mutableCopy(Internal.BooleanList booleanList) {
        int size = booleanList.size();
        return booleanList.a(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t7, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t7, bArr, 0, bArr.length, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.a(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t7, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t7, CodedInputStream.h(inputStream), ExtensionRegistryLite.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t7, byte[] bArr, int i8, int i9, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t8 = (T) t7.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Schema e8 = Protobuf.a().e(t8);
            e8.h(t8, bArr, i8, i8 + i9, new ArrayDecoders.Registers(extensionRegistryLite));
            e8.b(t8);
            if (t8.memoizedHashCode == 0) {
                return t8;
            }
            throw new RuntimeException();
        } catch (InvalidProtocolBufferException e9) {
            e = e9;
            if (e.a()) {
                e = new InvalidProtocolBufferException(e);
            }
            throw e.k(t8);
        } catch (UninitializedMessageException e10) {
            throw e10.a().k(t8);
        } catch (IOException e11) {
            if (e11.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e11.getCause());
            }
            throw new InvalidProtocolBufferException(e11).k(t8);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.m().k(t8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t7, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t7, CodedInputStream.h(inputStream), extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t7, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (T) parseFrom(t7, codedInputStream, ExtensionRegistryLite.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t7, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t7, codedInputStream, extensionRegistryLite));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t7, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (T) parsePartialFrom(t7, codedInputStream, ExtensionRegistryLite.b());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t7, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream B = byteString.B();
        T t8 = (T) parsePartialFrom(t7, B, extensionRegistryLite);
        try {
            B.a(0);
            return t8;
        } catch (InvalidProtocolBufferException e8) {
            throw e8.k(t8);
        }
    }
}
