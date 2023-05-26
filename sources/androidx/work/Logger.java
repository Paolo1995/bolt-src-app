package androidx.work;

import android.util.Log;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static Logger f8290a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final int f8291b = 20;

    /* loaded from: classes.dex */
    public static class LogcatLogger extends Logger {

        /* renamed from: c  reason: collision with root package name */
        private int f8292c;

        public LogcatLogger(int i8) {
            super(i8);
            this.f8292c = i8;
        }

        @Override // androidx.work.Logger
        public void a(String str, String str2, Throwable... thArr) {
            if (this.f8292c <= 3) {
                if (thArr != null && thArr.length >= 1) {
                    Log.d(str, str2, thArr[0]);
                } else {
                    Log.d(str, str2);
                }
            }
        }

        @Override // androidx.work.Logger
        public void b(String str, String str2, Throwable... thArr) {
            if (this.f8292c <= 6) {
                if (thArr != null && thArr.length >= 1) {
                    Log.e(str, str2, thArr[0]);
                } else {
                    Log.e(str, str2);
                }
            }
        }

        @Override // androidx.work.Logger
        public void d(String str, String str2, Throwable... thArr) {
            if (this.f8292c <= 4) {
                if (thArr != null && thArr.length >= 1) {
                    Log.i(str, str2, thArr[0]);
                } else {
                    Log.i(str, str2);
                }
            }
        }

        @Override // androidx.work.Logger
        public void g(String str, String str2, Throwable... thArr) {
            if (this.f8292c <= 2) {
                if (thArr != null && thArr.length >= 1) {
                    Log.v(str, str2, thArr[0]);
                } else {
                    Log.v(str, str2);
                }
            }
        }

        @Override // androidx.work.Logger
        public void h(String str, String str2, Throwable... thArr) {
            if (this.f8292c <= 5) {
                if (thArr != null && thArr.length >= 1) {
                    Log.w(str, str2, thArr[0]);
                } else {
                    Log.w(str, str2);
                }
            }
        }
    }

    public Logger(int i8) {
    }

    public static synchronized Logger c() {
        Logger logger;
        synchronized (Logger.class) {
            if (f8290a == null) {
                f8290a = new LogcatLogger(3);
            }
            logger = f8290a;
        }
        return logger;
    }

    public static synchronized void e(Logger logger) {
        synchronized (Logger.class) {
            f8290a = logger;
        }
    }

    public static String f(@NonNull String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i8 = f8291b;
        if (length >= i8) {
            sb.append(str.substring(0, i8));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void g(String str, String str2, Throwable... thArr);

    public abstract void h(String str, String str2, Throwable... thArr);
}
