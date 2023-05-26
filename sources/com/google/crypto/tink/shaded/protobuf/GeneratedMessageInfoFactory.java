package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
class GeneratedMessageInfoFactory implements MessageInfoFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final GeneratedMessageInfoFactory f15092a = new GeneratedMessageInfoFactory();

    private GeneratedMessageInfoFactory() {
    }

    public static GeneratedMessageInfoFactory c() {
        return f15092a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
    public MessageInfo a(Class<?> cls) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            try {
                return (MessageInfo) GeneratedMessageLite.p(cls.asSubclass(GeneratedMessageLite.class)).i();
            } catch (Exception e8) {
                throw new RuntimeException("Unable to get message info for " + cls.getName(), e8);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
    public boolean b(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }
}
