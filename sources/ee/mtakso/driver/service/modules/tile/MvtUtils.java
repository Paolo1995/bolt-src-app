package ee.mtakso.driver.service.modules.tile;

import android.graphics.Path;
import android.graphics.Point;
import eu.bolt.driver.maps.tile.mvt.MvtCommand;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MvtUtils.kt */
/* loaded from: classes3.dex */
public final class MvtUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final MvtUtils f25351a = new MvtUtils();

    private MvtUtils() {
    }

    public final Path a(Iterable<MvtCommand> commands, float f8, float f9) {
        Intrinsics.f(commands, "commands");
        Path path = new Path();
        for (MvtCommand mvtCommand : commands) {
            int a8 = mvtCommand.a();
            if (a8 != 1) {
                if (a8 != 2) {
                    if (a8 != 7) {
                        String str = "Unsupported command (" + mvtCommand + ")";
                        Kalev.c(new IllegalArgumentException(str), str);
                    } else {
                        path.close();
                    }
                } else {
                    path.lineTo(mvtCommand.b() * f8, mvtCommand.c() * f9);
                }
            } else {
                path.moveTo(mvtCommand.b() * f8, mvtCommand.c() * f9);
            }
        }
        return path;
    }

    public final Point b(Iterable<MvtCommand> commands, float f8, float f9) {
        Intrinsics.f(commands, "commands");
        for (MvtCommand mvtCommand : commands) {
            if (mvtCommand.a() == 1) {
                return new Point((int) (mvtCommand.b() * f8), (int) (mvtCommand.c() * f9));
            }
            String str = "Unsupported command (" + mvtCommand + ")";
            Kalev.c(new IllegalArgumentException(str), str);
        }
        return null;
    }
}
