package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ManifestSchemaFactory implements SchemaFactory {

    /* renamed from: b  reason: collision with root package name */
    private static final MessageInfoFactory f17500b = new MessageInfoFactory() { // from class: com.google.protobuf.ManifestSchemaFactory.1
        @Override // com.google.protobuf.MessageInfoFactory
        public MessageInfo a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public boolean b(Class<?> cls) {
            return false;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final MessageInfoFactory f17501a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class CompositeMessageInfoFactory implements MessageInfoFactory {

        /* renamed from: a  reason: collision with root package name */
        private MessageInfoFactory[] f17502a;

        CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.f17502a = messageInfoFactoryArr;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public MessageInfo a(Class<?> cls) {
            MessageInfoFactory[] messageInfoFactoryArr;
            for (MessageInfoFactory messageInfoFactory : this.f17502a) {
                if (messageInfoFactory.b(cls)) {
                    return messageInfoFactory.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public boolean b(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.f17502a) {
                if (messageInfoFactory.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public ManifestSchemaFactory() {
        this(b());
    }

    private static MessageInfoFactory b() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.c(), c());
    }

    private static MessageInfoFactory c() {
        try {
            return (MessageInfoFactory) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f17500b;
        }
    }

    private static boolean d(MessageInfo messageInfo) {
        if (messageInfo.c() == ProtoSyntax.PROTO2) {
            return true;
        }
        return false;
    }

    private static <T> Schema<T> e(Class<T> cls, MessageInfo messageInfo) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (d(messageInfo)) {
                return MessageSchema.P(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.M(), ExtensionSchemas.b(), MapFieldSchemas.b());
            }
            return MessageSchema.P(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.M(), null, MapFieldSchemas.b());
        } else if (d(messageInfo)) {
            return MessageSchema.P(cls, messageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.H(), ExtensionSchemas.a(), MapFieldSchemas.a());
        } else {
            return MessageSchema.P(cls, messageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.I(), null, MapFieldSchemas.a());
        }
    }

    @Override // com.google.protobuf.SchemaFactory
    public <T> Schema<T> a(Class<T> cls) {
        SchemaUtil.J(cls);
        MessageInfo a8 = this.f17501a.a(cls);
        if (a8.a()) {
            if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                return MessageSetSchema.k(SchemaUtil.M(), ExtensionSchemas.b(), a8.b());
            }
            return MessageSetSchema.k(SchemaUtil.H(), ExtensionSchemas.a(), a8.b());
        }
        return e(cls, a8);
    }

    private ManifestSchemaFactory(MessageInfoFactory messageInfoFactory) {
        this.f17501a = (MessageInfoFactory) Internal.b(messageInfoFactory, "messageInfoFactory");
    }
}
