package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadWriteBufferState.kt */
/* loaded from: classes5.dex */
public abstract class ReadWriteBufferState {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f47439a;

    /* renamed from: b  reason: collision with root package name */
    public final RingBufferCapacity f47440b;

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes5.dex */
    public static final class IdleEmpty extends ReadWriteBufferState {

        /* renamed from: c  reason: collision with root package name */
        public static final IdleEmpty f47441c = new IdleEmpty();

        private IdleEmpty() {
            super(ReadWriteBufferStateKt.a(), ReadWriteBufferStateKt.b(), null);
        }

        public String toString() {
            return "IDLE(empty)";
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes5.dex */
    public static final class IdleNonEmpty extends ReadWriteBufferState {

        /* renamed from: c  reason: collision with root package name */
        private final Initial f47442c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IdleNonEmpty(Initial initial) {
            super(initial.f47439a, initial.f47440b, null);
            Intrinsics.f(initial, "initial");
            this.f47442c = initial;
        }

        public final Initial g() {
            return this.f47442c;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        /* renamed from: h */
        public Reading c() {
            return this.f47442c.h();
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        /* renamed from: i */
        public Writing d() {
            return this.f47442c.j();
        }

        public String toString() {
            return "IDLE(with buffer)";
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes5.dex */
    public static final class Initial extends ReadWriteBufferState {

        /* renamed from: c  reason: collision with root package name */
        private final ByteBuffer f47443c;

        /* renamed from: d  reason: collision with root package name */
        private final ByteBuffer f47444d;

        /* renamed from: e  reason: collision with root package name */
        private final IdleNonEmpty f47445e;

        /* renamed from: f  reason: collision with root package name */
        private final Reading f47446f;

        /* renamed from: g  reason: collision with root package name */
        private final Writing f47447g;

        /* renamed from: h  reason: collision with root package name */
        private final ReadingWriting f47448h;

        public /* synthetic */ Initial(ByteBuffer byteBuffer, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(byteBuffer, (i9 & 2) != 0 ? 8 : i8);
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public ByteBuffer a() {
            return this.f47444d;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public ByteBuffer b() {
            return this.f47443c;
        }

        public final IdleNonEmpty g() {
            return this.f47445e;
        }

        public final Reading h() {
            return this.f47446f;
        }

        public final ReadingWriting i() {
            return this.f47448h;
        }

        public final Writing j() {
            return this.f47447g;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        /* renamed from: k */
        public Reading c() {
            return this.f47446f;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        /* renamed from: l */
        public Writing d() {
            return this.f47447g;
        }

        public String toString() {
            return "Initial";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Initial(ByteBuffer backingBuffer, int i8) {
            super(backingBuffer, new RingBufferCapacity(backingBuffer.capacity() - i8), null);
            Intrinsics.f(backingBuffer, "backingBuffer");
            if (backingBuffer.position() == 0) {
                if (backingBuffer.limit() == backingBuffer.capacity()) {
                    ByteBuffer duplicate = backingBuffer.duplicate();
                    Intrinsics.e(duplicate, "backingBuffer.duplicate()");
                    this.f47443c = duplicate;
                    ByteBuffer duplicate2 = backingBuffer.duplicate();
                    Intrinsics.e(duplicate2, "backingBuffer.duplicate()");
                    this.f47444d = duplicate2;
                    this.f47445e = new IdleNonEmpty(this);
                    this.f47446f = new Reading(this);
                    this.f47447g = new Writing(this);
                    this.f47448h = new ReadingWriting(this);
                    return;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes5.dex */
    public static final class Reading extends ReadWriteBufferState {

        /* renamed from: c  reason: collision with root package name */
        private final Initial f47449c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Reading(Initial initial) {
            super(initial.f47439a, initial.f47440b, null);
            Intrinsics.f(initial, "initial");
            this.f47449c = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public ByteBuffer a() {
            return this.f47449c.a();
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        /* renamed from: g */
        public ReadingWriting d() {
            return this.f47449c.i();
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        /* renamed from: h */
        public IdleNonEmpty e() {
            return this.f47449c.g();
        }

        public String toString() {
            return "Reading";
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes5.dex */
    public static final class ReadingWriting extends ReadWriteBufferState {

        /* renamed from: c  reason: collision with root package name */
        private final Initial f47450c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReadingWriting(Initial initial) {
            super(initial.f47439a, initial.f47440b, null);
            Intrinsics.f(initial, "initial");
            this.f47450c = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public ByteBuffer a() {
            return this.f47450c.a();
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public ByteBuffer b() {
            return this.f47450c.b();
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        /* renamed from: g */
        public Writing e() {
            return this.f47450c.j();
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        /* renamed from: h */
        public Reading f() {
            return this.f47450c.h();
        }

        public String toString() {
            return "Reading+Writing";
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes5.dex */
    public static final class Terminated extends ReadWriteBufferState {

        /* renamed from: c  reason: collision with root package name */
        public static final Terminated f47451c = new Terminated();

        private Terminated() {
            super(ReadWriteBufferStateKt.a(), ReadWriteBufferStateKt.b(), null);
        }

        public String toString() {
            return "Terminated";
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes5.dex */
    public static final class Writing extends ReadWriteBufferState {

        /* renamed from: c  reason: collision with root package name */
        private final Initial f47452c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Writing(Initial initial) {
            super(initial.f47439a, initial.f47440b, null);
            Intrinsics.f(initial, "initial");
            this.f47452c = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public ByteBuffer b() {
            return this.f47452c.b();
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        /* renamed from: g */
        public ReadingWriting c() {
            return this.f47452c.i();
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        /* renamed from: h */
        public IdleNonEmpty f() {
            return this.f47452c.g();
        }

        public String toString() {
            return "Writing";
        }
    }

    private ReadWriteBufferState(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity) {
        this.f47439a = byteBuffer;
        this.f47440b = ringBufferCapacity;
    }

    public /* synthetic */ ReadWriteBufferState(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer, ringBufferCapacity);
    }

    public ByteBuffer a() {
        throw new IllegalStateException(("read buffer is not available in state " + this).toString());
    }

    public ByteBuffer b() {
        throw new IllegalStateException(("write buffer is not available in state " + this).toString());
    }

    public ReadWriteBufferState c() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent reading is not supported").toString());
    }

    public ReadWriteBufferState d() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent writing is not supported").toString());
    }

    public ReadWriteBufferState e() {
        throw new IllegalStateException(("Unable to stop reading in state " + this).toString());
    }

    public ReadWriteBufferState f() {
        throw new IllegalStateException(("Unable to stop writing in state " + this).toString());
    }
}
