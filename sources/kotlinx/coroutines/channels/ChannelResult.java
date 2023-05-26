package kotlinx.coroutines.channels;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Channel.kt */
/* loaded from: classes5.dex */
public final class ChannelResult<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f51406b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final Failed f51407c = new Failed();

    /* renamed from: a  reason: collision with root package name */
    private final Object f51408a;

    /* compiled from: Channel.kt */
    /* loaded from: classes5.dex */
    public static final class Closed extends Failed {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f51409a;

        public Closed(Throwable th) {
            this.f51409a = th;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof Closed) && Intrinsics.a(this.f51409a, ((Closed) obj).f51409a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Throwable th = this.f51409a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public String toString() {
            return "Closed(" + this.f51409a + ')';
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <E> Object a(Throwable th) {
            return ChannelResult.c(new Closed(th));
        }

        public final <E> Object b() {
            return ChannelResult.c(ChannelResult.f51407c);
        }

        public final <E> Object c(E e8) {
            return ChannelResult.c(e8);
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes5.dex */
    public static class Failed {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ ChannelResult(Object obj) {
        this.f51408a = obj;
    }

    public static final /* synthetic */ ChannelResult b(Object obj) {
        return new ChannelResult(obj);
    }

    public static <T> Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && Intrinsics.a(obj, ((ChannelResult) obj2).l());
    }

    public static final Throwable e(Object obj) {
        Closed closed;
        if (obj instanceof Closed) {
            closed = (Closed) obj;
        } else {
            closed = null;
        }
        if (closed == null) {
            return null;
        }
        return closed.f51409a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T f(Object obj) {
        if (obj instanceof Failed) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T g(Object obj) {
        Throwable th;
        if (!(obj instanceof Failed)) {
            return obj;
        }
        if ((obj instanceof Closed) && (th = ((Closed) obj).f51409a) != null) {
            throw th;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
    }

    public static int h(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean i(Object obj) {
        return obj instanceof Closed;
    }

    public static final boolean j(Object obj) {
        return !(obj instanceof Failed);
    }

    public static String k(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f51408a, obj);
    }

    public int hashCode() {
        return h(this.f51408a);
    }

    public final /* synthetic */ Object l() {
        return this.f51408a;
    }

    public String toString() {
        return k(this.f51408a);
    }
}
