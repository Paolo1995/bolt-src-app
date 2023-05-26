package io.netty.channel;

import io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import j$.util.Spliterator;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class AdaptiveRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {
    @Deprecated
    public static final AdaptiveRecvByteBufAllocator DEFAULT;
    private static final int[] SIZE_TABLE;
    private final int initial;
    private final int maxIndex;
    private final int minIndex;

    /* loaded from: classes5.dex */
    private final class HandleImpl extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle {
        private boolean decreaseNow;
        private int index;
        private final int maxIndex;
        private final int minIndex;
        private int nextReceiveBufferSize;

        HandleImpl(int i8, int i9, int i10) {
            super();
            this.minIndex = i8;
            this.maxIndex = i9;
            this.index = AdaptiveRecvByteBufAllocator.getSizeTableIndex(i10);
            this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
        }

        private void record(int i8) {
            if (i8 <= AdaptiveRecvByteBufAllocator.SIZE_TABLE[Math.max(0, this.index - 1)]) {
                if (this.decreaseNow) {
                    this.index = Math.max(this.index - 1, this.minIndex);
                    this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                    this.decreaseNow = false;
                    return;
                }
                this.decreaseNow = true;
            } else if (i8 >= this.nextReceiveBufferSize) {
                this.index = Math.min(this.index + 4, this.maxIndex);
                this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                this.decreaseNow = false;
            }
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return this.nextReceiveBufferSize;
        }

        @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int i8) {
            if (i8 == attemptedBytesRead()) {
                record(i8);
            }
            super.lastBytesRead(i8);
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
            record(totalBytesRead());
        }
    }

    static {
        int i8;
        ArrayList arrayList = new ArrayList();
        int i9 = 16;
        while (true) {
            if (i9 >= 512) {
                break;
            }
            arrayList.add(Integer.valueOf(i9));
            i9 += 16;
        }
        for (i8 = 512; i8 > 0; i8 <<= 1) {
            arrayList.add(Integer.valueOf(i8));
        }
        SIZE_TABLE = new int[arrayList.size()];
        int i10 = 0;
        while (true) {
            int[] iArr = SIZE_TABLE;
            if (i10 < iArr.length) {
                iArr[i10] = ((Integer) arrayList.get(i10)).intValue();
                i10++;
            } else {
                DEFAULT = new AdaptiveRecvByteBufAllocator();
                return;
            }
        }
    }

    public AdaptiveRecvByteBufAllocator() {
        this(64, Spliterator.IMMUTABLE, 65536);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSizeTableIndex(int i8) {
        int length = SIZE_TABLE.length - 1;
        int i9 = 0;
        while (length >= i9) {
            if (length == i9) {
                return length;
            }
            int i10 = (i9 + length) >>> 1;
            int[] iArr = SIZE_TABLE;
            int i11 = iArr[i10];
            int i12 = i10 + 1;
            if (i8 > iArr[i12]) {
                i9 = i12;
            } else if (i8 < i11) {
                length = i10 - 1;
            } else if (i8 == i11) {
                return i10;
            } else {
                return i12;
            }
        }
        return i9;
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl(this.minIndex, this.maxIndex, this.initial);
    }

    public AdaptiveRecvByteBufAllocator(int i8, int i9, int i10) {
        ObjectUtil.checkPositive(i8, "minimum");
        if (i9 < i8) {
            throw new IllegalArgumentException("initial: " + i9);
        } else if (i10 >= i9) {
            int sizeTableIndex = getSizeTableIndex(i8);
            int[] iArr = SIZE_TABLE;
            if (iArr[sizeTableIndex] < i8) {
                this.minIndex = sizeTableIndex + 1;
            } else {
                this.minIndex = sizeTableIndex;
            }
            int sizeTableIndex2 = getSizeTableIndex(i10);
            if (iArr[sizeTableIndex2] > i10) {
                this.maxIndex = sizeTableIndex2 - 1;
            } else {
                this.maxIndex = sizeTableIndex2;
            }
            this.initial = i9;
        } else {
            throw new IllegalArgumentException("maximum: " + i10);
        }
    }
}
