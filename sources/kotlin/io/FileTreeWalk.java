package kotlin.io;

import com.google.android.gms.common.api.Api;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: FileTreeWalk.kt */
/* loaded from: classes5.dex */
public final class FileTreeWalk implements Sequence<File> {

    /* renamed from: a  reason: collision with root package name */
    private final File f50947a;

    /* renamed from: b  reason: collision with root package name */
    private final FileWalkDirection f50948b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<File, Boolean> f50949c;

    /* renamed from: d  reason: collision with root package name */
    private final Function1<File, Unit> f50950d;

    /* renamed from: e  reason: collision with root package name */
    private final Function2<File, IOException, Unit> f50951e;

    /* renamed from: f  reason: collision with root package name */
    private final int f50952f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileTreeWalk.kt */
    /* loaded from: classes5.dex */
    public static abstract class DirectoryState extends WalkState {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectoryState(File rootDir) {
            super(rootDir);
            Intrinsics.f(rootDir, "rootDir");
        }
    }

    /* compiled from: FileTreeWalk.kt */
    /* loaded from: classes5.dex */
    private final class FileTreeWalkIterator extends AbstractIterator<File> {

        /* renamed from: h  reason: collision with root package name */
        private final ArrayDeque<WalkState> f50953h;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: FileTreeWalk.kt */
        /* loaded from: classes5.dex */
        public final class BottomUpDirectoryState extends DirectoryState {

            /* renamed from: b  reason: collision with root package name */
            private boolean f50955b;

            /* renamed from: c  reason: collision with root package name */
            private File[] f50956c;

            /* renamed from: d  reason: collision with root package name */
            private int f50957d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f50958e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f50959f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BottomUpDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.f(rootDir, "rootDir");
                this.f50959f = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File b() {
                if (!this.f50958e && this.f50956c == null) {
                    Function1 function1 = FileTreeWalk.this.f50949c;
                    boolean z7 = false;
                    if (function1 != null && !((Boolean) function1.invoke(a())).booleanValue()) {
                        z7 = true;
                    }
                    if (z7) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.f50956c = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = FileTreeWalk.this.f50951e;
                        if (function2 != null) {
                            function2.s(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f50958e = true;
                    }
                }
                File[] fileArr = this.f50956c;
                if (fileArr != null) {
                    int i8 = this.f50957d;
                    Intrinsics.c(fileArr);
                    if (i8 < fileArr.length) {
                        File[] fileArr2 = this.f50956c;
                        Intrinsics.c(fileArr2);
                        int i9 = this.f50957d;
                        this.f50957d = i9 + 1;
                        return fileArr2[i9];
                    }
                }
                if (this.f50955b) {
                    Function1 function12 = FileTreeWalk.this.f50950d;
                    if (function12 != null) {
                        function12.invoke(a());
                    }
                    return null;
                }
                this.f50955b = true;
                return a();
            }
        }

        /* compiled from: FileTreeWalk.kt */
        /* loaded from: classes5.dex */
        private final class SingleFileState extends WalkState {

            /* renamed from: b  reason: collision with root package name */
            private boolean f50960b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f50961c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SingleFileState(FileTreeWalkIterator fileTreeWalkIterator, File rootFile) {
                super(rootFile);
                Intrinsics.f(rootFile, "rootFile");
                this.f50961c = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File b() {
                if (this.f50960b) {
                    return null;
                }
                this.f50960b = true;
                return a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: FileTreeWalk.kt */
        /* loaded from: classes5.dex */
        public final class TopDownDirectoryState extends DirectoryState {

            /* renamed from: b  reason: collision with root package name */
            private boolean f50962b;

            /* renamed from: c  reason: collision with root package name */
            private File[] f50963c;

            /* renamed from: d  reason: collision with root package name */
            private int f50964d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f50965e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TopDownDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.f(rootDir, "rootDir");
                this.f50965e = fileTreeWalkIterator;
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
                if (r0.length == 0) goto L32;
             */
            @Override // kotlin.io.FileTreeWalk.WalkState
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f50962b
                    r1 = 0
                    if (r0 != 0) goto L2c
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f50965e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.d(r0)
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L22
                    java.io.File r4 = r10.a()
                    java.lang.Object r0 = r0.invoke(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L22
                    r2 = 1
                L22:
                    if (r2 == 0) goto L25
                    return r1
                L25:
                    r10.f50962b = r3
                    java.io.File r0 = r10.a()
                    return r0
                L2c:
                    java.io.File[] r0 = r10.f50963c
                    if (r0 == 0) goto L4b
                    int r2 = r10.f50964d
                    kotlin.jvm.internal.Intrinsics.c(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L39
                    goto L4b
                L39:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f50965e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.f(r0)
                    if (r0 == 0) goto L4a
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L4a:
                    return r1
                L4b:
                    java.io.File[] r0 = r10.f50963c
                    if (r0 != 0) goto L97
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f50963c = r0
                    if (r0 != 0) goto L7b
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f50965e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function2 r0 = kotlin.io.FileTreeWalk.e(r0)
                    if (r0 == 0) goto L7b
                    java.io.File r2 = r10.a()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.a()
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.s(r2, r9)
                L7b:
                    java.io.File[] r0 = r10.f50963c
                    if (r0 == 0) goto L85
                    kotlin.jvm.internal.Intrinsics.c(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L97
                L85:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f50965e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.f(r0)
                    if (r0 == 0) goto L96
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L96:
                    return r1
                L97:
                    java.io.File[] r0 = r10.f50963c
                    kotlin.jvm.internal.Intrinsics.c(r0)
                    int r1 = r10.f50964d
                    int r2 = r1 + 1
                    r10.f50964d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState.b():java.io.File");
            }
        }

        /* compiled from: FileTreeWalk.kt */
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f50966a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f50966a = iArr;
            }
        }

        public FileTreeWalkIterator() {
            ArrayDeque<WalkState> arrayDeque = new ArrayDeque<>();
            this.f50953h = arrayDeque;
            if (FileTreeWalk.this.f50947a.isDirectory()) {
                arrayDeque.push(g(FileTreeWalk.this.f50947a));
            } else if (FileTreeWalk.this.f50947a.isFile()) {
                arrayDeque.push(new SingleFileState(this, FileTreeWalk.this.f50947a));
            } else {
                c();
            }
        }

        private final DirectoryState g(File file) {
            int i8 = WhenMappings.f50966a[FileTreeWalk.this.f50948b.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    return new BottomUpDirectoryState(this, file);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new TopDownDirectoryState(this, file);
        }

        private final File h() {
            File b8;
            while (true) {
                WalkState peek = this.f50953h.peek();
                if (peek == null) {
                    return null;
                }
                b8 = peek.b();
                if (b8 == null) {
                    this.f50953h.pop();
                } else if (Intrinsics.a(b8, peek.a()) || !b8.isDirectory() || this.f50953h.size() >= FileTreeWalk.this.f50952f) {
                    break;
                } else {
                    this.f50953h.push(g(b8));
                }
            }
            return b8;
        }

        @Override // kotlin.collections.AbstractIterator
        protected void b() {
            File h8 = h();
            if (h8 != null) {
                d(h8);
            } else {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileTreeWalk.kt */
    /* loaded from: classes5.dex */
    public static abstract class WalkState {

        /* renamed from: a  reason: collision with root package name */
        private final File f50967a;

        public WalkState(File root) {
            Intrinsics.f(root, "root");
            this.f50967a = root;
        }

        public final File a() {
            return this.f50967a;
        }

        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1<? super File, Boolean> function1, Function1<? super File, Unit> function12, Function2<? super File, ? super IOException, Unit> function2, int i8) {
        this.f50947a = file;
        this.f50948b = fileWalkDirection;
        this.f50949c = function1;
        this.f50950d = function12;
        this.f50951e = function2;
        this.f50952f = i8;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator();
    }

    /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i9 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function12, function2, (i9 & 32) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(File start, FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        Intrinsics.f(start, "start");
        Intrinsics.f(direction, "direction");
    }
}
