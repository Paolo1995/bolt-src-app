package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class HardwareConfigState {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f10464g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10465h;

    /* renamed from: i  reason: collision with root package name */
    private static final File f10466i;

    /* renamed from: j  reason: collision with root package name */
    private static volatile HardwareConfigState f10467j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile int f10468k;

    /* renamed from: b  reason: collision with root package name */
    private final int f10470b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10471c;

    /* renamed from: d  reason: collision with root package name */
    private int f10472d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10473e = true;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f10474f = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f10469a = f();

    static {
        boolean z7;
        int i8 = Build.VERSION.SDK_INT;
        boolean z8 = true;
        if (i8 < 29) {
            z7 = true;
        } else {
            z7 = false;
        }
        f10464g = z7;
        if (i8 < 26) {
            z8 = false;
        }
        f10465h = z8;
        f10466i = new File("/proc/self/fd");
        f10468k = -1;
    }

    HardwareConfigState() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f10470b = 20000;
            this.f10471c = 0;
            return;
        }
        this.f10470b = 700;
        this.f10471c = 128;
    }

    private boolean a() {
        if (f10464g && !this.f10474f.get()) {
            return true;
        }
        return false;
    }

    public static HardwareConfigState b() {
        if (f10467j == null) {
            synchronized (HardwareConfigState.class) {
                if (f10467j == null) {
                    f10467j = new HardwareConfigState();
                }
            }
        }
        return f10467j;
    }

    private int c() {
        if (f10468k != -1) {
            return f10468k;
        }
        return this.f10470b;
    }

    private synchronized boolean d() {
        boolean z7 = true;
        int i8 = this.f10472d + 1;
        this.f10472d = i8;
        if (i8 >= 50) {
            this.f10472d = 0;
            int length = f10466i.list().length;
            long c8 = c();
            if (length >= c8) {
                z7 = false;
            }
            this.f10473e = z7;
            if (!z7 && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + c8);
            }
        }
        return this.f10473e;
    }

    private static boolean f() {
        if (!g() && !h()) {
            return true;
        }
        return false;
    }

    private static boolean g() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        for (String str : Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play")) {
            if (Build.MODEL.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean h() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
    }

    public boolean e(int i8, int i9, boolean z7, boolean z8) {
        if (!z7) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        } else if (!this.f10469a) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        } else if (!f10465h) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        } else if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        } else if (z8) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        } else {
            int i10 = this.f10471c;
            if (i8 < i10) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
                }
                return false;
            } else if (i9 < i10) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
                }
                return false;
            } else if (!d()) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                }
                return false;
            } else {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean i(int i8, int i9, BitmapFactory.Options options, boolean z7, boolean z8) {
        boolean e8 = e(i8, i9, z7, z8);
        if (e8) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return e8;
    }
}
