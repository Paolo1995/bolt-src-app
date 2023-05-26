package timber.log;

import j$.util.Spliterator;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Timber.kt */
/* loaded from: classes4.dex */
public final class Timber {

    /* renamed from: a  reason: collision with root package name */
    public static final Forest f53064a = new Forest(null);

    /* renamed from: b  reason: collision with root package name */
    private static final ArrayList<Tree> f53065b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private static volatile Tree[] f53066c = new Tree[0];

    /* compiled from: Timber.kt */
    /* loaded from: classes4.dex */
    public static final class Forest extends Tree {
        private Forest() {
        }

        public /* synthetic */ Forest(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // timber.log.Timber.Tree
        public void a(String str, Object... args) {
            Intrinsics.f(args, "args");
            for (Tree tree : Timber.f53066c) {
                tree.a(str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        public void b(Throwable th) {
            for (Tree tree : Timber.f53066c) {
                tree.b(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public void c(Throwable th, String str, Object... args) {
            Intrinsics.f(args, "args");
            for (Tree tree : Timber.f53066c) {
                tree.c(th, str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        public void h(String str, Object... args) {
            Intrinsics.f(args, "args");
            for (Tree tree : Timber.f53066c) {
                tree.h(str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        protected void k(int i8, String str, String message, Throwable th) {
            Intrinsics.f(message, "message");
            throw new AssertionError();
        }

        @Override // timber.log.Timber.Tree
        public void m(String str, Object... args) {
            Intrinsics.f(args, "args");
            for (Tree tree : Timber.f53066c) {
                tree.m(str, Arrays.copyOf(args, args.length));
            }
        }

        @Override // timber.log.Timber.Tree
        public void n(Throwable th, String str, Object... args) {
            Intrinsics.f(args, "args");
            for (Tree tree : Timber.f53066c) {
                tree.n(th, str, Arrays.copyOf(args, args.length));
            }
        }

        public final Tree o(String tag) {
            Intrinsics.f(tag, "tag");
            Tree[] treeArr = Timber.f53066c;
            int length = treeArr.length;
            int i8 = 0;
            while (i8 < length) {
                Tree tree = treeArr[i8];
                i8++;
                tree.e().set(tag);
            }
            return this;
        }
    }

    /* compiled from: Timber.kt */
    /* loaded from: classes4.dex */
    public static abstract class Tree {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadLocal<String> f53067a = new ThreadLocal<>();

        private final String f(Throwable th) {
            StringWriter stringWriter = new StringWriter(Spliterator.NONNULL);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String stringWriter2 = stringWriter.toString();
            Intrinsics.e(stringWriter2, "sw.toString()");
            return stringWriter2;
        }

        private final void l(int i8, Throwable th, String str, Object... objArr) {
            boolean z7;
            String g8 = g();
            if (!j(g8, i8)) {
                return;
            }
            boolean z8 = false;
            if (str != null && str.length() != 0) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                if (th == null) {
                    return;
                }
                str = f(th);
            } else {
                if (objArr.length == 0) {
                    z8 = true;
                }
                if (!z8) {
                    str = d(str, objArr);
                }
                if (th != null) {
                    str = ((Object) str) + '\n' + f(th);
                }
            }
            k(i8, g8, str, th);
        }

        public void a(String str, Object... args) {
            Intrinsics.f(args, "args");
            l(6, null, str, Arrays.copyOf(args, args.length));
        }

        public void b(Throwable th) {
            l(6, th, null, new Object[0]);
        }

        public void c(Throwable th, String str, Object... args) {
            Intrinsics.f(args, "args");
            l(6, th, str, Arrays.copyOf(args, args.length));
        }

        protected String d(String message, Object[] args) {
            Intrinsics.f(message, "message");
            Intrinsics.f(args, "args");
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format = String.format(message, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.e(format, "java.lang.String.format(this, *args)");
            return format;
        }

        public final /* synthetic */ ThreadLocal e() {
            return this.f53067a;
        }

        public /* synthetic */ String g() {
            String str = this.f53067a.get();
            if (str != null) {
                this.f53067a.remove();
            }
            return str;
        }

        public void h(String str, Object... args) {
            Intrinsics.f(args, "args");
            l(4, null, str, Arrays.copyOf(args, args.length));
        }

        protected boolean i(int i8) {
            return true;
        }

        protected boolean j(String str, int i8) {
            return i(i8);
        }

        protected abstract void k(int i8, String str, String str2, Throwable th);

        public void m(String str, Object... args) {
            Intrinsics.f(args, "args");
            l(5, null, str, Arrays.copyOf(args, args.length));
        }

        public void n(Throwable th, String str, Object... args) {
            Intrinsics.f(args, "args");
            l(5, th, str, Arrays.copyOf(args, args.length));
        }
    }

    private Timber() {
        throw new AssertionError();
    }

    public static void b(String str, Object... objArr) {
        f53064a.a(str, objArr);
    }

    public static void c(Throwable th) {
        f53064a.b(th);
    }

    public static void d(String str, Object... objArr) {
        f53064a.m(str, objArr);
    }
}
