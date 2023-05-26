package ee.mtakso.driver.log;

import eu.bolt.kalev.Kalevipoeg;
import eu.bolt.kalev.LogEntry;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogManager.kt */
/* loaded from: classes3.dex */
final class CompositePoeg implements Kalevipoeg {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<Kalevipoeg> f21000a = new CopyOnWriteArrayList<>();

    @Override // eu.bolt.kalev.Kalevipoeg
    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
        for (Kalevipoeg kalevipoeg : this.f21000a) {
            kalevipoeg.a(entry);
        }
    }

    public final void b(Kalevipoeg consumer) {
        Intrinsics.f(consumer, "consumer");
        this.f21000a.add(consumer);
    }

    public final void c() {
        this.f21000a.clear();
    }
}
