package com.google.protobuf;

/* loaded from: classes3.dex */
class GeneratedMessageInfoFactory implements MessageInfoFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final GeneratedMessageInfoFactory f17417a = new GeneratedMessageInfoFactory();

    private GeneratedMessageInfoFactory() {
    }

    public static GeneratedMessageInfoFactory c() {
        return f17417a;
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo a(Class<?> cls) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            try {
                return (MessageInfo) GeneratedMessageLite.getDefaultInstance(cls.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
            } catch (Exception e8) {
                throw new RuntimeException("Unable to get message info for " + cls.getName(), e8);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public boolean b(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }
}
