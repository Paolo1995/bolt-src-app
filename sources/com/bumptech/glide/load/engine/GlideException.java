package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class GlideException extends Exception {

    /* renamed from: l  reason: collision with root package name */
    private static final StackTraceElement[] f10144l = new StackTraceElement[0];

    /* renamed from: f  reason: collision with root package name */
    private final List<Throwable> f10145f;

    /* renamed from: g  reason: collision with root package name */
    private Key f10146g;

    /* renamed from: h  reason: collision with root package name */
    private DataSource f10147h;

    /* renamed from: i  reason: collision with root package name */
    private Class<?> f10148i;

    /* renamed from: j  reason: collision with root package name */
    private String f10149j;

    /* renamed from: k  reason: collision with root package name */
    private Exception f10150k;

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable th2 : ((GlideException) th).e()) {
                a(th2, list);
            }
            return;
        }
        list.add(th);
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e8) {
            throw new RuntimeException(e8);
        }
    }

    private static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8 + 1;
            appendable.append("Cause (").append(String.valueOf(i9)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i8);
            if (th instanceof GlideException) {
                ((GlideException) th).h(appendable);
            } else {
                d(th, appendable);
            }
            i8 = i9;
        }
    }

    private static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void h(Appendable appendable) {
        d(this, appendable);
        b(e(), new IndentedAppendable(appendable));
    }

    public List<Throwable> e() {
        return this.f10145f;
    }

    public List<Throwable> f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public void g(String str) {
        List<Throwable> f8 = f();
        int size = f8.size();
        int i8 = 0;
        while (i8 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i9 = i8 + 1;
            sb.append(i9);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), f8.get(i8));
            i8 = i9;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f10149j);
        String str3 = "";
        if (this.f10148i == null) {
            str = "";
        } else {
            str = ", " + this.f10148i;
        }
        sb.append(str);
        if (this.f10147h == null) {
            str2 = "";
        } else {
            str2 = ", " + this.f10147h;
        }
        sb.append(str2);
        if (this.f10146g != null) {
            str3 = ", " + this.f10146g;
        }
        sb.append(str3);
        List<Throwable> f8 = f();
        if (f8.isEmpty()) {
            return sb.toString();
        }
        if (f8.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(f8.size());
            sb.append(" root causes:");
        }
        for (Throwable th : f8) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Key key, DataSource dataSource) {
        j(key, dataSource, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Key key, DataSource dataSource, Class<?> cls) {
        this.f10146g = key;
        this.f10147h = dataSource;
        this.f10148i = cls;
    }

    public void k(Exception exc) {
        this.f10150k = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.f10149j = str;
        setStackTrace(f10144l);
        this.f10145f = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class IndentedAppendable implements Appendable {

        /* renamed from: f  reason: collision with root package name */
        private final Appendable f10151f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f10152g = true;

        IndentedAppendable(Appendable appendable) {
            this.f10151f = appendable;
        }

        @NonNull
        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c8) throws IOException {
            if (this.f10152g) {
                this.f10152g = false;
                this.f10151f.append("  ");
            }
            this.f10152g = c8 == '\n';
            this.f10151f.append(c8);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a8 = a(charSequence);
            return append(a8, 0, a8.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i8, int i9) throws IOException {
            CharSequence a8 = a(charSequence);
            boolean z7 = false;
            if (this.f10152g) {
                this.f10152g = false;
                this.f10151f.append("  ");
            }
            if (a8.length() > 0 && a8.charAt(i9 - 1) == '\n') {
                z7 = true;
            }
            this.f10152g = z7;
            this.f10151f.append(a8, i8, i9);
            return this;
        }
    }
}
