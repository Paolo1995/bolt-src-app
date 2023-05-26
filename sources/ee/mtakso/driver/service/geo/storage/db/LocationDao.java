package ee.mtakso.driver.service.geo.storage.db;

import ee.mtakso.driver.service.geo.storage.LocationEntity;
import java.util.List;

/* compiled from: LocationDao.kt */
/* loaded from: classes3.dex */
public interface LocationDao {
    void a();

    List<LocationEntity> b(long j8, long j9, String str);

    void c(List<LocationEntity> list);

    List<LocationEntity> d(long j8, long j9, String str, int i8);

    void e(LocationEntity locationEntity);
}
