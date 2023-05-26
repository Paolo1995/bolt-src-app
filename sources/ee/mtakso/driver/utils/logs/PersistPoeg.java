package ee.mtakso.driver.utils.logs;

import eu.bolt.kalev.Kalevipoeg;
import eu.bolt.kalev.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistPoeg.kt */
/* loaded from: classes5.dex */
public final class PersistPoeg implements Kalevipoeg {
    @Override // eu.bolt.kalev.Kalevipoeg
    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
    }
}
