package ee.mtakso.driver.log;

import ee.mtakso.driver.service.modules.reporters.WrongStateReporter;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.kalev.Kalevipoeg;
import eu.bolt.kalev.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StateConsumer.kt */
/* loaded from: classes3.dex */
public final class StateConsumer implements Kalevipoeg {

    /* renamed from: a  reason: collision with root package name */
    private final WrongStateReporter f21034a;

    public StateConsumer(WrongStateReporter reporter) {
        Intrinsics.f(reporter, "reporter");
        this.f21034a = reporter;
    }

    @Override // eu.bolt.kalev.Kalevipoeg
    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
        Throwable g8 = entry.g();
        if (g8 == null) {
            return;
        }
        if (ApiExceptionUtils.m(g8, 416)) {
            this.f21034a.e();
        }
        if (ApiExceptionUtils.m(g8, 415)) {
            this.f21034a.g();
        }
    }
}
