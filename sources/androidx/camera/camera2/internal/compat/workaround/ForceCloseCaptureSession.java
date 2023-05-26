package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class ForceCloseCaptureSession {

    /* renamed from: a  reason: collision with root package name */
    private final CaptureSessionOnClosedNotCalledQuirk f2895a;

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface OnConfigured {
        void a(@NonNull SynchronizedCaptureSession synchronizedCaptureSession);
    }

    public ForceCloseCaptureSession(@NonNull Quirks quirks) {
        this.f2895a = (CaptureSessionOnClosedNotCalledQuirk) quirks.b(CaptureSessionOnClosedNotCalledQuirk.class);
    }

    private void a(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.b().o(synchronizedCaptureSession);
        }
    }

    private void b(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.b().p(synchronizedCaptureSession);
        }
    }

    public void c(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull List<SynchronizedCaptureSession> list, @NonNull List<SynchronizedCaptureSession> list2, @NonNull OnConfigured onConfigured) {
        SynchronizedCaptureSession next;
        SynchronizedCaptureSession next2;
        if (d()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it = list.iterator();
            while (it.hasNext() && (next2 = it.next()) != synchronizedCaptureSession) {
                linkedHashSet.add(next2);
            }
            b(linkedHashSet);
        }
        onConfigured.a(synchronizedCaptureSession);
        if (d()) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it2 = list2.iterator();
            while (it2.hasNext() && (next = it2.next()) != synchronizedCaptureSession) {
                linkedHashSet2.add(next);
            }
            a(linkedHashSet2);
        }
    }

    public boolean d() {
        if (this.f2895a != null) {
            return true;
        }
        return false;
    }
}
