package ee.mtakso.driver.ui.screens.home.v2.subpage.activity;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.driver.DriverActivityData;
import ee.mtakso.driver.network.client.driver.DriverCancels;
import ee.mtakso.driver.network.client.driver.DriverHours;
import ee.mtakso.driver.network.client.driver.DriverRides;
import ee.mtakso.driver.network.client.driver.HoursPeriodData;
import ee.mtakso.driver.network.client.driver.HoursSubPeriodData;
import ee.mtakso.driver.network.client.driver.RidesPeriodData;
import ee.mtakso.driver.network.client.driver.RidesSubPeriodData;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.cancels.CancelsFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.hours.HoursFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides.RidesFragment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ActivityPagerAdapter.kt */
/* loaded from: classes3.dex */
public final class ActivityPagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29615a;

    /* renamed from: b  reason: collision with root package name */
    private final DateTimeConverter f29616b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29617c;

    /* renamed from: d  reason: collision with root package name */
    private ActivityMode f29618d;

    /* renamed from: e  reason: collision with root package name */
    private DriverActivityData f29619e;

    /* renamed from: f  reason: collision with root package name */
    private DriverActivityData f29620f;

    /* renamed from: g  reason: collision with root package name */
    private int f29621g;

    /* compiled from: ActivityPagerAdapter.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29622a;

        static {
            int[] iArr = new int[ActivityMode.values().length];
            try {
                iArr[ActivityMode.HOURS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActivityMode.RIDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActivityMode.CANCELS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29622a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityPagerAdapter(FragmentManager fragmentManager, Context context, DateTimeConverter dateTimeConverter) {
        super(fragmentManager, 1);
        Intrinsics.f(fragmentManager, "fragmentManager");
        Intrinsics.f(context, "context");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        this.f29615a = context;
        this.f29616b = dateTimeConverter;
        this.f29617c = "dd.MM";
    }

    private final String a(HoursPeriodData hoursPeriodData) {
        String str;
        List<HoursSubPeriodData> a8;
        HoursSubPeriodData hoursSubPeriodData;
        List<HoursSubPeriodData> a9;
        HoursSubPeriodData hoursSubPeriodData2;
        SimpleDateFormat c8 = this.f29616b.c(this.f29617c);
        String str2 = null;
        if (hoursPeriodData != null && (a9 = hoursPeriodData.a()) != null && (hoursSubPeriodData2 = a9.get(0)) != null) {
            str = hoursSubPeriodData2.b();
        } else {
            str = null;
        }
        Date d8 = d(str);
        if (hoursPeriodData != null && (a8 = hoursPeriodData.a()) != null && (hoursSubPeriodData = a8.get(hoursPeriodData.a().size() - 1)) != null) {
            str2 = hoursSubPeriodData.b();
        }
        Date d9 = d(str2);
        return c8.format(d8) + "-" + c8.format(d9);
    }

    private final String b(RidesPeriodData ridesPeriodData) {
        String str;
        List<RidesSubPeriodData> b8;
        RidesSubPeriodData ridesSubPeriodData;
        List<RidesSubPeriodData> b9;
        RidesSubPeriodData ridesSubPeriodData2;
        SimpleDateFormat c8 = this.f29616b.c(this.f29617c);
        String str2 = null;
        if (ridesPeriodData != null && (b9 = ridesPeriodData.b()) != null && (ridesSubPeriodData2 = b9.get(0)) != null) {
            str = ridesSubPeriodData2.b();
        } else {
            str = null;
        }
        Date d8 = d(str);
        if (ridesPeriodData != null && (b8 = ridesPeriodData.b()) != null && (ridesSubPeriodData = b8.get(ridesPeriodData.b().size() - 1)) != null) {
            str2 = ridesSubPeriodData.b();
        }
        Date d9 = d(str2);
        return c8.format(d8) + "-" + c8.format(d9);
    }

    private final String c(int i8) {
        HoursPeriodData hoursPeriodData;
        DriverHours b8;
        List<HoursPeriodData> b9;
        if (h(i8)) {
            String string = this.f29615a.getString(R.string.current_week);
            Intrinsics.e(string, "{\n                contex…rrent_week)\n            }");
            return string;
        } else if (i(i8)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            Locale locale = Locale.ENGLISH;
            String string2 = this.f29615a.getString(R.string.past_x_months);
            Intrinsics.e(string2, "context.getString(R.string.past_x_months)");
            String format = String.format(locale, string2, Arrays.copyOf(new Object[]{Integer.valueOf(this.f29621g)}, 1));
            Intrinsics.e(format, "format(locale, format, *args)");
            return format;
        } else {
            DriverActivityData driverActivityData = this.f29619e;
            if (driverActivityData != null && (b8 = driverActivityData.b()) != null && (b9 = b8.b()) != null) {
                hoursPeriodData = b9.get(i8);
            } else {
                hoursPeriodData = null;
            }
            return a(hoursPeriodData);
        }
    }

    private final Date d(String str) {
        Date parse;
        Date date = new Date(0L);
        if (str == null) {
            return date;
        }
        try {
            try {
                parse = this.f29616b.c("yyyy-MM-dd").parse(str);
                if (parse == null) {
                    return date;
                }
            } catch (ParseException unused) {
                parse = this.f29616b.c("yyyy-MM").parse(str);
                if (parse == null) {
                    return date;
                }
            }
            return parse;
        } catch (ParseException e8) {
            e8.printStackTrace();
            return date;
        }
    }

    private final HoursFragment e(int i8) {
        DriverHours b8;
        List<HoursPeriodData> b9;
        DriverHours b10;
        List<HoursPeriodData> b11;
        HoursPeriodData hoursPeriodData = null;
        if (i(i8)) {
            DriverActivityData driverActivityData = this.f29620f;
            if (driverActivityData != null && (b10 = driverActivityData.b()) != null && (b11 = b10.b()) != null) {
                hoursPeriodData = (HoursPeriodData) CollectionsKt___CollectionsKt.Y(b11);
            }
            HoursFragment I = HoursFragment.I(hoursPeriodData, true);
            Intrinsics.e(I, "{\n            HoursFragm…OrNull(), true)\n        }");
            return I;
        }
        DriverActivityData driverActivityData2 = this.f29619e;
        if (driverActivityData2 != null && (b8 = driverActivityData2.b()) != null && (b9 = b8.b()) != null) {
            hoursPeriodData = b9.get(i8);
        }
        HoursFragment I2 = HoursFragment.I(hoursPeriodData, false);
        Intrinsics.e(I2, "{\n            HoursFragm…sition), false)\n        }");
        return I2;
    }

    private final RidesFragment g(int i8) {
        DriverRides c8;
        List<RidesPeriodData> a8;
        DriverRides c9;
        List<RidesPeriodData> a9;
        RidesPeriodData ridesPeriodData = null;
        if (i(i8)) {
            DriverActivityData driverActivityData = this.f29620f;
            if (driverActivityData != null && (c9 = driverActivityData.c()) != null && (a9 = c9.a()) != null) {
                ridesPeriodData = (RidesPeriodData) CollectionsKt___CollectionsKt.Y(a9);
            }
            RidesFragment J = RidesFragment.J(ridesPeriodData, true);
            Intrinsics.e(J, "{\n            RidesFragm…OrNull(), true)\n        }");
            return J;
        }
        DriverActivityData driverActivityData2 = this.f29619e;
        if (driverActivityData2 != null && (c8 = driverActivityData2.c()) != null && (a8 = c8.a()) != null) {
            ridesPeriodData = a8.get(i8);
        }
        RidesFragment J2 = RidesFragment.J(ridesPeriodData, false);
        Intrinsics.e(J2, "{\n            RidesFragm…sition), false)\n        }");
        return J2;
    }

    private final boolean h(int i8) {
        if (i8 == getCount() - 2) {
            return true;
        }
        return false;
    }

    private final boolean i(int i8) {
        if (i8 == getCount() - 1) {
            return true;
        }
        return false;
    }

    private final String j(int i8) {
        RidesPeriodData ridesPeriodData;
        DriverRides c8;
        List<RidesPeriodData> a8;
        if (h(i8)) {
            return this.f29615a.getString(R.string.current_week);
        }
        if (i(i8)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            Locale locale = Locale.ENGLISH;
            String string = this.f29615a.getString(R.string.past_x_months);
            Intrinsics.e(string, "context.getString(R.string.past_x_months)");
            String format = String.format(locale, string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f29621g)}, 1));
            Intrinsics.e(format, "format(locale, format, *args)");
            return format;
        }
        DriverActivityData driverActivityData = this.f29619e;
        if (driverActivityData != null && (c8 = driverActivityData.c()) != null && (a8 = c8.a()) != null) {
            ridesPeriodData = a8.get(i8);
        } else {
            ridesPeriodData = null;
        }
        return b(ridesPeriodData);
    }

    public final ActivityMode f() {
        return this.f29618d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int i8;
        int size;
        DriverActivityData driverActivityData = this.f29619e;
        if (driverActivityData == null) {
            return 0;
        }
        ActivityMode activityMode = this.f29618d;
        if (activityMode == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f29622a[activityMode.ordinal()];
        }
        if (i8 == -1) {
            return 0;
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return 1;
                }
                throw new NoWhenBranchMatchedException();
            }
            size = driverActivityData.c().a().size();
        } else {
            size = driverActivityData.b().b().size();
        }
        return size + 1;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i8) {
        int i9;
        DriverCancels driverCancels;
        ActivityMode activityMode = this.f29618d;
        if (activityMode == null) {
            i9 = -1;
        } else {
            i9 = WhenMappings.f29622a[activityMode.ordinal()];
        }
        if (i9 != -1) {
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 == 3) {
                        DriverActivityData driverActivityData = this.f29619e;
                        if (driverActivityData != null) {
                            driverCancels = driverActivityData.a();
                        } else {
                            driverCancels = null;
                        }
                        CancelsFragment G = CancelsFragment.G(driverCancels);
                        Intrinsics.e(G, "newInstance(weeklyData?.driverCancels)");
                        return G;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return g(i8);
            }
            return e(i8);
        }
        throw new IllegalStateException("Pager mode is NULL");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object any) {
        Intrinsics.f(any, "any");
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i8) {
        int i9;
        Integer num;
        DriverCancels a8;
        ActivityMode activityMode = this.f29618d;
        if (activityMode == null) {
            i9 = -1;
        } else {
            i9 = WhenMappings.f29622a[activityMode.ordinal()];
        }
        if (i9 != -1) {
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 == 3) {
                        Context context = this.f29615a;
                        Object[] objArr = new Object[1];
                        DriverActivityData driverActivityData = this.f29619e;
                        if (driverActivityData != null && (a8 = driverActivityData.a()) != null) {
                            num = Integer.valueOf(a8.e());
                        } else {
                            num = null;
                        }
                        objArr[0] = num;
                        return context.getString(R.string.driver_activity_cancels_title, objArr);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return j(i8);
            }
            return c(i8);
        }
        return "";
    }

    public final void k(ActivityMode activityMode) {
        if (activityMode == this.f29618d) {
            return;
        }
        this.f29618d = activityMode;
        notifyDataSetChanged();
    }

    public final void l(DriverActivityData driverActivityData) {
        this.f29620f = driverActivityData;
        notifyDataSetChanged();
    }

    public final void m(DriverActivityData driverActivityData) {
        int i8;
        DriverHours b8;
        this.f29619e = driverActivityData;
        if (driverActivityData != null && (b8 = driverActivityData.b()) != null) {
            i8 = b8.a();
        } else {
            i8 = 0;
        }
        this.f29621g = i8;
        notifyDataSetChanged();
    }
}
