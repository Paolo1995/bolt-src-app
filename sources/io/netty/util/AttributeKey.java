package io.netty.util;

/* loaded from: classes5.dex */
public final class AttributeKey<T> extends AbstractConstant<AttributeKey<T>> {
    private static final ConstantPool<AttributeKey<Object>> pool = new ConstantPool<AttributeKey<Object>>() { // from class: io.netty.util.AttributeKey.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.ConstantPool
        public AttributeKey<Object> newConstant(int i8, String str) {
            return new AttributeKey<>(i8, str);
        }
    };

    private AttributeKey(int i8, String str) {
        super(i8, str);
    }
}
