package io.netty.handler.codec;

/* loaded from: classes5.dex */
public class UnsupportedMessageTypeException extends CodecException {
    public UnsupportedMessageTypeException(Object obj, Class<?>... clsArr) {
        super(message(obj == null ? "null" : obj.getClass().getName(), clsArr));
    }

    private static String message(String str, Class<?>... clsArr) {
        Class<?> cls;
        StringBuilder sb = new StringBuilder(str);
        if (clsArr != null && clsArr.length > 0) {
            sb.append(" (expected: ");
            sb.append(clsArr[0].getName());
            for (int i8 = 1; i8 < clsArr.length && (cls = clsArr[i8]) != null; i8++) {
                sb.append(", ");
                sb.append(cls.getName());
            }
            sb.append(')');
        }
        return sb.toString();
    }

    public UnsupportedMessageTypeException() {
    }
}
