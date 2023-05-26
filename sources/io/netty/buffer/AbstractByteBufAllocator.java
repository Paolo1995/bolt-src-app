package io.netty.buffer;

import com.google.android.gms.common.api.Api;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;

/* loaded from: classes5.dex */
public abstract class AbstractByteBufAllocator implements ByteBufAllocator {
    private final boolean directByDefault;
    private final ByteBuf emptyBuf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.AbstractByteBufAllocator$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$util$ResourceLeakDetector$Level;

        static {
            int[] iArr = new int[ResourceLeakDetector.Level.values().length];
            $SwitchMap$io$netty$util$ResourceLeakDetector$Level = iArr;
            try {
                iArr[ResourceLeakDetector.Level.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.ADVANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.PARANOID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        ResourceLeakDetector.addExclusions(AbstractByteBufAllocator.class, "toLeakAwareBuffer");
    }

    protected AbstractByteBufAllocator() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ByteBuf toLeakAwareBuffer(ByteBuf byteBuf) {
        ByteBuf simpleLeakAwareByteBuf;
        ResourceLeakTracker<ByteBuf> track;
        int i8 = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i8 == 1) {
            ResourceLeakTracker<ByteBuf> track2 = AbstractByteBuf.leakDetector.track(byteBuf);
            if (track2 == null) {
                return byteBuf;
            }
            simpleLeakAwareByteBuf = new SimpleLeakAwareByteBuf(byteBuf, track2);
        } else if ((i8 != 2 && i8 != 3) || (track = AbstractByteBuf.leakDetector.track(byteBuf)) == null) {
            return byteBuf;
        } else {
            simpleLeakAwareByteBuf = new AdvancedLeakAwareByteBuf(byteBuf, track);
        }
        return simpleLeakAwareByteBuf;
    }

    private static void validate(int i8, int i9) {
        ObjectUtil.checkPositiveOrZero(i8, "initialCapacity");
        if (i8 <= i9) {
            return;
        }
        throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i8), Integer.valueOf(i9)));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i8) {
        if (this.directByDefault) {
            return directBuffer(i8);
        }
        return heapBuffer(i8);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int i8, int i9) {
        ObjectUtil.checkPositiveOrZero(i8, "minNewCapacity");
        if (i8 <= i9) {
            if (i8 == 4194304) {
                return 4194304;
            }
            if (i8 > 4194304) {
                int i10 = (i8 / 4194304) * 4194304;
                if (i10 <= i9 - 4194304) {
                    return i10 + 4194304;
                }
                return i9;
            }
            int i11 = 64;
            while (i11 < i8) {
                i11 <<= 1;
            }
            return Math.min(i11, i9);
        }
        throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i8), Integer.valueOf(i9)));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int i8) {
        if (this.directByDefault) {
            return compositeDirectBuffer(i8);
        }
        return compositeHeapBuffer(i8);
    }

    public CompositeByteBuf compositeDirectBuffer(int i8) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, true, i8));
    }

    public CompositeByteBuf compositeHeapBuffer(int i8) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, false, i8));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i8) {
        return directBuffer(i8, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i8) {
        return heapBuffer(i8, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i8) {
        if (!PlatformDependent.hasUnsafe() && !isDirectBufferPooled()) {
            return heapBuffer(i8);
        }
        return directBuffer(i8);
    }

    protected abstract ByteBuf newDirectBuffer(int i8, int i9);

    protected abstract ByteBuf newHeapBuffer(int i8, int i9);

    public String toString() {
        return StringUtil.simpleClassName(this) + "(directByDefault: " + this.directByDefault + ')';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractByteBufAllocator(boolean z7) {
        this.directByDefault = z7 && PlatformDependent.hasUnsafe();
        this.emptyBuf = new EmptyByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i8, int i9) {
        if (i8 == 0 && i9 == 0) {
            return this.emptyBuf;
        }
        validate(i8, i9);
        return newDirectBuffer(i8, i9);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i8, int i9) {
        if (i8 == 0 && i9 == 0) {
            return this.emptyBuf;
        }
        validate(i8, i9);
        return newHeapBuffer(i8, i9);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i8, int i9) {
        if (this.directByDefault) {
            return directBuffer(i8, i9);
        }
        return heapBuffer(i8, i9);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i8, int i9) {
        if (!PlatformDependent.hasUnsafe() && !isDirectBufferPooled()) {
            return heapBuffer(i8, i9);
        }
        return directBuffer(i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf compositeByteBuf) {
        CompositeByteBuf simpleLeakAwareCompositeByteBuf;
        ResourceLeakTracker<ByteBuf> track;
        int i8 = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i8 == 1) {
            ResourceLeakTracker<ByteBuf> track2 = AbstractByteBuf.leakDetector.track(compositeByteBuf);
            if (track2 == null) {
                return compositeByteBuf;
            }
            simpleLeakAwareCompositeByteBuf = new SimpleLeakAwareCompositeByteBuf(compositeByteBuf, track2);
        } else if ((i8 != 2 && i8 != 3) || (track = AbstractByteBuf.leakDetector.track(compositeByteBuf)) == null) {
            return compositeByteBuf;
        } else {
            simpleLeakAwareCompositeByteBuf = new AdvancedLeakAwareCompositeByteBuf(compositeByteBuf, track);
        }
        return simpleLeakAwareCompositeByteBuf;
    }
}
