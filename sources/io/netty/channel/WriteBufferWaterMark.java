package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes5.dex */
public final class WriteBufferWaterMark {
    public static final WriteBufferWaterMark DEFAULT = new WriteBufferWaterMark(32768, 65536, false);
    private final int high;
    private final int low;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteBufferWaterMark(int i8, int i9, boolean z7) {
        if (z7) {
            ObjectUtil.checkPositiveOrZero(i8, "low");
            if (i9 < i8) {
                throw new IllegalArgumentException("write buffer's high water mark cannot be less than  low water mark (" + i8 + "): " + i9);
            }
        }
        this.low = i8;
        this.high = i9;
    }

    public int high() {
        return this.high;
    }

    public int low() {
        return this.low;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(55);
        sb.append("WriteBufferWaterMark(low: ");
        sb.append(this.low);
        sb.append(", high: ");
        sb.append(this.high);
        sb.append(")");
        return sb.toString();
    }
}
