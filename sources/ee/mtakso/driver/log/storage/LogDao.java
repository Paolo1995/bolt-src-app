package ee.mtakso.driver.log.storage;

import java.util.List;

/* compiled from: LogDao.kt */
/* loaded from: classes3.dex */
public interface LogDao {
    List<Long> a(List<LogEntity> list);

    void b(List<ApplogSync> list);

    void c(List<BigQuerySync> list);

    List<LogEntity> d(String str);

    List<LogEntity> e();

    List<LogEntity> f(String str);

    List<LogEntity> g(String str, long j8, int i8);

    List<LogEntity> h(String str);

    List<LogEntity> i(String str, long j8);

    void j(List<BigQuerySync> list);

    List<LogEntity> k();

    List<LogEntity> l(String str);

    void m(List<ApplogSync> list);
}
