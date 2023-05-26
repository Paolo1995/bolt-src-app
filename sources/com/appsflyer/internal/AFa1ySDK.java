package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class AFa1ySDK {
    private static int AFInAppEventParameterName = 0;
    private static char[] AFInAppEventType = null;
    private static int AFKeystoreWrapper = 1;
    private static long valueOf;
    private static long values;

    static {
        AFInAppEventType();
        View.resolveSizeAndState(0, 0, 0);
        ViewConfiguration.getLongPressTimeout();
        Color.alpha(0);
        ViewConfiguration.getTapTimeout();
        Color.blue(0);
        TextUtils.lastIndexOf("", '0');
        Process.myTid();
        TypedValue.complexToFloat(0);
        TextUtils.indexOf((CharSequence) "", '0');
        TextUtils.indexOf((CharSequence) "", '0', 0, 0);
        TextUtils.indexOf((CharSequence) "", '0', 0);
        KeyEvent.keyCodeFromString("");
        ViewConfiguration.getScrollFriction();
        TextUtils.indexOf((CharSequence) "", '0', 0, 0);
        ViewConfiguration.getDoubleTapTimeout();
        AudioTrack.getMaxVolume();
        AndroidCharacter.getMirror('0');
        int i8 = AFInAppEventParameterName + 105;
        AFKeystoreWrapper = i8 % 128;
        int i9 = i8 % 2;
    }

    private static String AFInAppEventParameterName(String str) {
        int i8 = AFKeystoreWrapper + 75;
        AFInAppEventParameterName = i8 % 128;
        int i9 = i8 % 2;
        Object[] objArr = new Object[1];
        AFInAppEventType((char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 60565), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 107, KeyEvent.getDeadChar(0, 0) + 1, objArr);
        if ((!str.contains(((String) objArr[0]).intern()) ? 'I' : (char) 27) != 'I') {
            Object[] objArr2 = new Object[1];
            values("\uf2e6\uf2ba铰鏸揄ﲛ", ViewConfiguration.getFadingEdgeLength() >> 16, objArr2);
            String[] split = str.split(((String) objArr2[0]).intern());
            int length = split.length;
            StringBuilder sb = new StringBuilder();
            int i10 = length - 1;
            sb.append(split[i10]);
            Object[] objArr3 = new Object[1];
            AFInAppEventType((char) (((Process.getThreadPriority(0) + 20) >> 6) + 60565), ExpandableListView.getPackedPositionType(0L) + 107, -TextUtils.lastIndexOf("", '0'), objArr3);
            sb.append(((String) objArr3[0]).intern());
            int i11 = AFKeystoreWrapper + 95;
            AFInAppEventParameterName = i11 % 128;
            int i12 = i11 % 2;
            int i13 = 1;
            while (true) {
                if ((i13 < i10 ? 'C' : '\b') != 'C') {
                    sb.append(split[0]);
                    return sb.toString();
                }
                sb.append(split[i13]);
                Object[] objArr4 = new Object[1];
                AFInAppEventType((char) (60565 - (ViewConfiguration.getEdgeSlop() >> 16)), 107 - (ViewConfiguration.getLongPressTimeout() >> 16), 1 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr4);
                sb.append(((String) objArr4[0]).intern());
                i13++;
            }
        } else {
            int i14 = AFInAppEventParameterName + 107;
            AFKeystoreWrapper = i14 % 128;
            if (i14 % 2 == 0) {
                int i15 = 6 / 0;
                return str;
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String AFInAppEventType(Context context, long j8) {
        String intern;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        Object[] objArr = new Object[1];
        values("咐哱ꖝꋕ⏀ⷨ绋毋䡧脂ी䳯淔\ue2e6擐「Ĩ\ufe53䞻ᖟ⚉\udb7dꌸ良\uda04㒮뻴\udac9ｯဍ驥뾄鳙淵\uf5d5ꌶ뀵䥁", (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1, objArr);
        if (!(!AFInAppEventType(((String) objArr[0]).intern()))) {
            int i8 = AFKeystoreWrapper + 63;
            AFInAppEventParameterName = i8 % 128;
            int i9 = i8 % 2;
            Object[] objArr2 = new Object[1];
            values("젻젊㭿ъ窫", '0' - AndroidCharacter.getMirror('0'), objArr2);
            intern = ((String) objArr2[0]).intern();
            int i10 = AFKeystoreWrapper + 9;
            AFInAppEventParameterName = i10 % 128;
            int i11 = i10 % 2;
        } else {
            Object[] objArr3 = new Object[1];
            values("쨰쨀亷ᖮ폷", (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr3);
            intern = ((String) objArr3[0]).intern();
        }
        sb2.append(intern);
        sb.append(AFInAppEventParameterName(context, sb2));
        try {
            long j9 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            Object[] objArr4 = new Object[1];
            AFInAppEventType((char) (ViewConfiguration.getJumpTapTimeout() >> 16), 1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), TextUtils.getCapsMode("", 0, 0) + 18, objArr4);
            sb.append(new SimpleDateFormat(((String) objArr4[0]).intern(), Locale.US).format(new Date(j9)));
            int i12 = AFInAppEventParameterName + 7;
            AFKeystoreWrapper = i12 % 128;
            if (i12 % 2 != 0) {
                sb.append(j8);
                AFKeystoreWrapper(sb3);
                return AFKeystoreWrapper(valueOf(valueOf(valueOf(sb.toString()), sb2.toString(), 17), sb3.toString(), 27), Long.valueOf(j8));
            }
            sb.append(j8);
            AFKeystoreWrapper(sb3);
            return AFKeystoreWrapper(valueOf(valueOf(valueOf(sb.toString()), sb2.toString(), 95), sb3.toString(), 22), Long.valueOf(j8));
        } catch (PackageManager.NameNotFoundException e8) {
            Object[] objArr5 = new Object[1];
            values("嬽孚黈馋삙캡킻얊䟍멐\uea1e\ue2da扞\ud9a8螈鸹໘악ꓣ믠⤰\ue068䀕圇햪\u0fe1巽璷\uf0c2⭈礫ᇝ", ViewConfiguration.getLongPressTimeout() >> 16, objArr5);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e8);
            Object[] objArr6 = new Object[1];
            AFInAppEventType((char) (45597 - (ViewConfiguration.getPressedStateDuration() >> 16)), 18 - ((Process.getThreadPriority(0) + 20) >> 6), (ViewConfiguration.getLongPressTimeout() >> 16) + 32, objArr6);
            return ((String) objArr6[0]).intern();
        }
    }

    static void AFInAppEventType() {
        values = 1997584226170046246L;
        AFInAppEventType = new char[]{'y', 11743, 23349, 34955, 46773, 58483, 4521, 16295, 27988, 39602, 51235, 63082, 9088, 20739, 32633, 44233, 55827, 2140, 45695, 40922, 59699, 14986, 1252, 22086, 41929, 36258, 57108, 10415, 31316, 17420, 37300, 58129, 52528, 7828, 26697, 47741, 34693, 53546, 8913, 3302, 24173, 43975, 62953, 50962, 4336, 25337, 19463, 39395, 60248, 13622, 'i', 11733, 23311, 34974, 46841, 58445, 4503, 16298, 27933, 39670, 51218, 63053, 9148, 20814, 32626, 44245, 55829, 2152, 13768, 26933, 17564, 12924, 57812, 57251, 36099, 30932, 22256, 1036, 62435, 41306, 40722, 19179, 14427, 5682, 50571, 45850, 24833, 23709, 2664, 63967, 55205, 34146, 6688, 14217, 16745, 37569, 44214, 65046, 3009, 9701, 30495, 33010, 53833, 60493, 14812, 19293, 25916, 60603, 61858, 56335, 43762, 31067, 18302, 5535, 57411, 52844, 40076, 27507, 14788, 1934, 53865, 41172, '.', 11660, 23395, 34990, 46827, 58388, 4556, 16292, 27930, 39679, 'F', 11719, 23333, 34974, 46845, 58458, 4548, 16382, 27999, 39670, 51227, 63047, 9148, 20814, 32631, 44251, 55811, 2158, 13769, 25458, 37000, 48895, 60464, 6530, 60393, 50788, 45187, 25403, 23897, 4071, 64059, 54349, 34527, 28932, 9141, 7661, 51218, 47792, 38103, 18303, 12708, 'F', 11719, 23333, 34974, 46845, 58458, 4548, 16382, 27999, 39670, 51227, 63047, 9148, 20814, 32631, 44251, 55811, 2158, 13769, 25458, 37000, 48895, 60464, 6530, 18352, 30017, 41653, 53494, 65088, 11246, 22801, 34658, 46243, 57859, 4220, 15814, 27441, 39057, 50890, 62576, 8656, 'P', 11719, 23343, 34969, 46841, 58457, 4481, 16332, 27970, 39609, 51217, 63087, 9129, 20736, 32637, 44252, 55813, 2165, 13784, 25458, 37014, 48881, 60464, 6602, 18422, 30041, 41641, 53484, 65100};
        valueOf = -292703458466845274L;
    }

    private static String AFKeystoreWrapper(String str, Long l8) {
        long j8 = 0;
        if (str != null) {
            int i8 = AFKeystoreWrapper;
            int i9 = i8 + 87;
            AFInAppEventParameterName = i9 % 128;
            int i10 = i9 % 2;
            if ((l8 != null ? (char) 0 : 'V') != 'V') {
                int i11 = i8 + 47;
                AFInAppEventParameterName = i11 % 128;
                int i12 = i11 % 2;
                if (str.length() == 32) {
                    StringBuilder sb = new StringBuilder(str);
                    String obj = l8.toString();
                    int i13 = 0;
                    int i14 = 0;
                    while (i13 < obj.length()) {
                        i14 += Character.getNumericValue(obj.charAt(i13));
                        i13++;
                        int i15 = AFKeystoreWrapper + 15;
                        AFInAppEventParameterName = i15 % 128;
                        int i16 = i15 % 2;
                    }
                    String hexString = Integer.toHexString(i14);
                    sb.replace(7, hexString.length() + 7, hexString);
                    int i17 = 0;
                    while (true) {
                        if (i17 >= sb.length()) {
                            break;
                        }
                        j8 += Character.getNumericValue(sb.charAt(i17));
                        i17++;
                    }
                    while (j8 > 100) {
                        j8 %= 100;
                    }
                    sb.insert(23, (int) j8);
                    if (j8 < 10) {
                        int i18 = AFKeystoreWrapper + 21;
                        AFInAppEventParameterName = i18 % 128;
                        int i19 = i18 % 2;
                        Object[] objArr = new Object[1];
                        values("쨰쨀亷ᖮ폷", ViewConfiguration.getMinimumFlingVelocity() >> 16, objArr);
                        sb.insert(23, ((String) objArr[0]).intern());
                    }
                    return sb.toString();
                }
            }
        }
        Object[] objArr2 = new Object[1];
        AFInAppEventType((char) (45598 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 32, objArr2);
        return ((String) objArr2[0]).intern();
    }

    private static String valueOf(String str, String str2, int i8) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i8, values(str2).charAt(0));
        String obj = sb.toString();
        int i9 = AFKeystoreWrapper + 49;
        AFInAppEventParameterName = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
        return obj;
    }

    private static String values(String str) {
        int parseInt;
        int i8;
        int i9 = AFInAppEventParameterName + 47;
        AFKeystoreWrapper = i9 % 128;
        if (!(i9 % 2 != 0)) {
            parseInt = Integer.parseInt(str, 2);
            i8 = 43;
        } else {
            parseInt = Integer.parseInt(str, 2);
            i8 = 16;
        }
        String num = Integer.toString(parseInt, i8);
        int i10 = AFKeystoreWrapper + 57;
        AFInAppEventParameterName = i10 % 128;
        int i11 = i10 % 2;
        return num;
    }

    private static String valueOf(String str) {
        int i8 = AFInAppEventParameterName + 21;
        AFKeystoreWrapper = i8 % 128;
        int i9 = i8 % 2;
        String values2 = AFb1ySDK.values(AFb1ySDK.AFInAppEventParameterName(str));
        int i10 = AFInAppEventParameterName + 31;
        AFKeystoreWrapper = i10 % 128;
        int i11 = i10 % 2;
        return values2;
    }

    private static String values(Context context) {
        Properties properties = System.getProperties();
        Object[] objArr = new Object[1];
        AFInAppEventType((char) (View.resolveSizeAndState(0, 0, 0) + 61896), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 107, 15 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr);
        String str = null;
        if ((properties.containsKey(((String) objArr[0]).intern()) ? 'C' : (char) 22) != 22) {
            int i8 = AFInAppEventParameterName + 43;
            AFKeystoreWrapper = i8 % 128;
            int i9 = i8 % 2;
            try {
                String path = context.getCacheDir().getPath();
                Object[] objArr2 = new Object[1];
                values("詐詿\ue215\ue550脕輸\ue847ﵖ隠욋", (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1, objArr2);
                String replace = path.replace(((String) objArr2[0]).intern(), "");
                Object[] objArr3 = new Object[1];
                AFInAppEventType((char) ((-1) - MotionEvent.axisFromString("")), (ViewConfiguration.getWindowTouchSlop() >> 8) + 122, Gravity.getAbsoluteGravity(0, 0) + 10, objArr3);
                Matcher matcher = Pattern.compile(((String) objArr3[0]).intern()).matcher(replace);
                if ((matcher.find() ? 'b' : '7') == 'b') {
                    str = matcher.group(1);
                }
                int i10 = AFKeystoreWrapper + 31;
                AFInAppEventParameterName = i10 % 128;
                int i11 = i10 % 2;
            } catch (Exception e8) {
                Object[] objArr4 = new Object[1];
                AFInAppEventType((char) (TextUtils.lastIndexOf("", '0', 0) + 1), Process.getGidForName("") + 133, (ViewConfiguration.getScrollBarSize() >> 8) + 24, objArr4);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr4[0]).intern(), e8);
                AFb1sSDK afErrorLogForExcManagerOnly = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly();
                Object[] objArr5 = new Object[1];
                AFInAppEventType((char) (60331 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 156 - Color.red(0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 16, objArr5);
                String intern = ((String) objArr5[0]).intern();
                StringBuilder sb = new StringBuilder();
                Object[] objArr6 = new Object[1];
                AFInAppEventType((char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 173, 42 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr6);
                sb.append(((String) objArr6[0]).intern());
                sb.append(e8);
                afErrorLogForExcManagerOnly.valueOf(intern, sb.toString());
            }
        }
        return str;
    }

    private static String valueOf(Context context) {
        int i8 = AFInAppEventParameterName + 1;
        AFKeystoreWrapper = i8 % 128;
        int i9 = i8 % 2;
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            int i10 = AFInAppEventParameterName + 11;
            AFKeystoreWrapper = i10 % 128;
            int i11 = i10 % 2;
            return str;
        } catch (PackageManager.NameNotFoundException e8) {
            Object[] objArr = new Object[1];
            AFInAppEventType((char) Drawable.resolveOpacity(0, 0), TextUtils.lastIndexOf("", '0', 0) + 215, 28 - MotionEvent.axisFromString(""), objArr);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr[0]).intern(), e8);
            return null;
        }
    }

    private static String AFInAppEventParameterName(Context context, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        String packageName = context.getPackageName();
        String AFInAppEventParameterName2 = AFInAppEventParameterName(packageName);
        Object[] objArr = new Object[1];
        values("젻젊㭿ъ窫", (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1, objArr);
        sb.append(((String) objArr[0]).intern());
        sb2.append(AFInAppEventParameterName2);
        if (values(context) == null) {
            int i8 = AFKeystoreWrapper + 35;
            AFInAppEventParameterName = i8 % 128;
            int i9 = i8 % 2;
            Object[] objArr2 = new Object[1];
            values("쨰쨀亷ᖮ폷", View.MeasureSpec.getSize(0), objArr2);
            sb.append(((String) objArr2[0]).intern());
            sb2.append(packageName);
            int i10 = AFInAppEventParameterName + 121;
            AFKeystoreWrapper = i10 % 128;
            int i11 = i10 % 2;
        } else {
            Object[] objArr3 = new Object[1];
            values("젻젊㭿ъ窫", Gravity.getAbsoluteGravity(0, 0), objArr3);
            sb.append(((String) objArr3[0]).intern());
            sb2.append(packageName);
        }
        String valueOf2 = valueOf(context);
        if (valueOf2 == null) {
            int i12 = AFInAppEventParameterName + 11;
            AFKeystoreWrapper = i12 % 128;
            int i13 = i12 % 2;
            Object[] objArr4 = new Object[1];
            values("쨰쨀亷ᖮ폷", View.combineMeasuredStates(0, 0), objArr4);
            sb.append(((String) objArr4[0]).intern());
            sb2.append(packageName);
            int i14 = AFInAppEventParameterName + 3;
            AFKeystoreWrapper = i14 % 128;
            int i15 = i14 % 2;
        } else {
            Object[] objArr5 = new Object[1];
            values("젻젊㭿ъ窫", (-1) - TextUtils.lastIndexOf("", '0', 0), objArr5);
            sb.append(((String) objArr5[0]).intern());
            sb2.append(valueOf2);
        }
        sb2.append(Boolean.TRUE.toString());
        return sb2.toString();
    }

    /* loaded from: classes.dex */
    public static class AFa1xSDK extends HashMap<String, Object> {
        private static char[] AFInAppEventType = null;
        private static int AFKeystoreWrapper = 0;
        private static int AFLogger = 1;
        private static int values;
        private final Context AFInAppEventParameterName;
        private final Map<String, Object> valueOf;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.appsflyer.internal.AFa1ySDK$AFa1xSDK$AFa1ySDK  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0007AFa1ySDK {
            private static short[] AFInAppEventParameterName = null;
            private static int AFInAppEventType = 1580374223;
            private static int AFKeystoreWrapper = 1185622814;
            private static int afErrorLog = 0;
            private static int afInfoLog = 1;
            private static byte[] valueOf = {-82};
            private static int values = 83;

            C0007AFa1ySDK() {
            }

            @NonNull
            static String AFInAppEventParameterName(String str) throws Exception {
                int i8 = afErrorLog + 101;
                afInfoLog = i8 % 128;
                char c8 = i8 % 2 == 0 ? '5' : '/';
                byte[] AFKeystoreWrapper2 = AFKeystoreWrapper(str);
                if (c8 != '/') {
                    int i9 = 3 / 0;
                    return AFInAppEventParameterName(AFInAppEventType(AFKeystoreWrapper2));
                }
                return AFInAppEventParameterName(AFInAppEventType(AFKeystoreWrapper2));
            }

            private static byte[] AFInAppEventType(@NonNull byte[] bArr) throws Exception {
                char c8;
                int i8;
                boolean z7;
                int i9 = afErrorLog + 81;
                afInfoLog = i9 % 128;
                if (i9 % 2 == 0) {
                    c8 = 'O';
                } else {
                    c8 = '<';
                }
                boolean z8 = true;
                if (c8 != 'O') {
                    i8 = 0;
                } else {
                    i8 = 1;
                }
                while (true) {
                    if (i8 < bArr.length) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    if (z7) {
                        break;
                    }
                    bArr[i8] = (byte) (bArr[i8] ^ ((i8 % 2) + 42));
                    i8++;
                }
                int i10 = afInfoLog + 123;
                afErrorLog = i10 % 128;
                if (i10 % 2 == 0) {
                    z8 = false;
                }
                if (z8) {
                    int i11 = 32 / 0;
                    return bArr;
                }
                return bArr;
            }

            @NonNull
            private static byte[] AFKeystoreWrapper(@NonNull String str) throws Exception {
                char c8;
                int i8 = afErrorLog + 95;
                afInfoLog = i8 % 128;
                int i9 = i8 % 2;
                byte[] bytes = str.getBytes();
                int i10 = afErrorLog + 3;
                afInfoLog = i10 % 128;
                if (i10 % 2 == 0) {
                    c8 = '_';
                } else {
                    c8 = 26;
                }
                if (c8 != '_') {
                    return bytes;
                }
                throw null;
            }

            private static void values(int i8, int i9, byte b8, int i10, short s7, Object[] objArr) {
                boolean z7;
                String obj;
                int i11;
                synchronized (AFg1qSDK.valueOf) {
                    StringBuilder sb = new StringBuilder();
                    int i12 = values;
                    int i13 = i10 + i12;
                    if (i13 == -1) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        byte[] bArr = valueOf;
                        if (bArr != null) {
                            i13 = (byte) (bArr[AFInAppEventType + i8] + i12);
                        } else {
                            i13 = (short) (AFInAppEventParameterName[AFInAppEventType + i8] + i12);
                        }
                    }
                    if (i13 > 0) {
                        int i14 = ((i8 + i13) - 2) + AFInAppEventType;
                        if (z7) {
                            i11 = 1;
                        } else {
                            i11 = 0;
                        }
                        AFg1qSDK.values = i14 + i11;
                        char c8 = (char) (i9 + AFKeystoreWrapper);
                        AFg1qSDK.AFKeystoreWrapper = c8;
                        sb.append(c8);
                        AFg1qSDK.AFInAppEventType = AFg1qSDK.AFKeystoreWrapper;
                        AFg1qSDK.AFInAppEventParameterName = 1;
                        while (AFg1qSDK.AFInAppEventParameterName < i13) {
                            byte[] bArr2 = valueOf;
                            if (bArr2 != null) {
                                int i15 = AFg1qSDK.values;
                                AFg1qSDK.values = i15 - 1;
                                AFg1qSDK.AFKeystoreWrapper = (char) (AFg1qSDK.AFInAppEventType + (((byte) (bArr2[i15] + s7)) ^ b8));
                            } else {
                                short[] sArr = AFInAppEventParameterName;
                                int i16 = AFg1qSDK.values;
                                AFg1qSDK.values = i16 - 1;
                                AFg1qSDK.AFKeystoreWrapper = (char) (AFg1qSDK.AFInAppEventType + (((short) (sArr[i16] + s7)) ^ b8));
                            }
                            sb.append(AFg1qSDK.AFKeystoreWrapper);
                            AFg1qSDK.AFInAppEventType = AFg1qSDK.AFKeystoreWrapper;
                            AFg1qSDK.AFInAppEventParameterName++;
                        }
                    }
                    obj = sb.toString();
                }
                objArr[0] = obj;
            }

            @NonNull
            private static String AFInAppEventParameterName(@NonNull byte[] bArr) throws Exception {
                StringBuilder sb = new StringBuilder();
                int length = bArr.length;
                int i8 = 0;
                while (i8 < length) {
                    String hexString = Integer.toHexString(bArr[i8]);
                    if (hexString.length() == 1) {
                        StringBuilder sb2 = new StringBuilder();
                        Object[] objArr = new Object[1];
                        values((-1580374223) - ExpandableListView.getPackedPositionType(0L), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) - 1185622766, (byte) ((-107) - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), (-84) - (ViewConfiguration.getLongPressTimeout() >> 16), (short) ((-44) - TextUtils.indexOf("", "")), objArr);
                        sb2.append(((String) objArr[0]).intern());
                        sb2.append(hexString);
                        hexString = sb2.toString();
                        int i9 = afInfoLog + 89;
                        afErrorLog = i9 % 128;
                        int i10 = i9 % 2;
                    }
                    sb.append(hexString);
                    i8++;
                    int i11 = afInfoLog + 53;
                    afErrorLog = i11 % 128;
                    int i12 = i11 % 2;
                }
                return sb.toString();
            }
        }

        static {
            AFInAppEventType();
            ViewConfiguration.getKeyRepeatTimeout();
            View.MeasureSpec.getSize(0);
            PointF.length(0.0f, 0.0f);
            ViewConfiguration.getTouchSlop();
            Process.getGidForName("");
            ViewConfiguration.getJumpTapTimeout();
            TextUtils.getCapsMode("", 0, 0);
            KeyEvent.getMaxKeyCode();
            KeyEvent.keyCodeFromString("");
            ViewConfiguration.getTapTimeout();
            View.resolveSize(0, 0);
            ViewConfiguration.getWindowTouchSlop();
            int i8 = AFLogger + 53;
            AFKeystoreWrapper = i8 % 128;
            int i9 = i8 % 2;
        }

        public AFa1xSDK(Map<String, Object> map, Context context) {
            this.valueOf = map;
            this.AFInAppEventParameterName = context;
            put(AFInAppEventParameterName(), valueOf());
        }

        @NonNull
        private String AFInAppEventParameterName() {
            String str;
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                Map<String, Object> map = this.valueOf;
                Object[] objArr = new Object[1];
                AFInAppEventParameterName(null, true, new int[]{0, 12, 26, 1}, objArr);
                String obj = map.get(((String) objArr[0]).intern()).toString();
                Map<String, Object> map2 = this.valueOf;
                Object[] objArr2 = new Object[1];
                AFKeystoreWrapper(((Process.getThreadPriority(0) + 20) >> 6) + 135, KeyEvent.keyCodeFromString("") + 5, 5 - Color.red(0), true, "�\u0007\ufffa\u000b\ufffb", objArr2);
                String obj2 = map2.get(((String) objArr2[0]).intern()).toString();
                if ((obj2 == null ? (char) 14 : 'B') != 'B') {
                    int i8 = AFKeystoreWrapper + 19;
                    AFLogger = i8 % 128;
                    if (i8 % 2 != 0) {
                        Object[] objArr3 = new Object[1];
                        AFInAppEventParameterName("\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000", false, new int[]{12, 8, 0, 3}, objArr3);
                        str = (String) objArr3[0];
                    } else {
                        Object[] objArr4 = new Object[1];
                        AFInAppEventParameterName("\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000", false, new int[]{12, 8, 0, 3}, objArr4);
                        str = (String) objArr4[0];
                    }
                    obj2 = str.intern();
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder AFKeystoreWrapper2 = AFKeystoreWrapper(num, obj2, sb.toString());
                int length = AFKeystoreWrapper2.length();
                if (length <= 4) {
                    while (true) {
                        if ((length < 4 ? (char) 11 : '%') == '%') {
                            break;
                        }
                        length++;
                        AFKeystoreWrapper2.append('1');
                        int i9 = AFKeystoreWrapper + 119;
                        AFLogger = i9 % 128;
                        int i10 = i9 % 2;
                    }
                } else {
                    int i11 = AFKeystoreWrapper + 69;
                    AFLogger = i11 % 128;
                    if (i11 % 2 == 0) {
                        AFKeystoreWrapper2.delete(3, length);
                    } else {
                        AFKeystoreWrapper2.delete(4, length);
                    }
                }
                Object[] objArr5 = new Object[1];
                AFKeystoreWrapper((ViewConfiguration.getLongPressTimeout() >> 16) + 135, 3 - View.MeasureSpec.getSize(0), 2 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), false, "\ufffe\uffff\u0004", objArr5);
                AFKeystoreWrapper2.insert(0, ((String) objArr5[0]).intern());
                return AFKeystoreWrapper2.toString();
            } catch (Exception e8) {
                Object[] objArr6 = new Object[1];
                AFInAppEventParameterName("\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000", false, new int[]{20, 40, 0, 0}, objArr6);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr6[0]).intern(), e8);
                StringBuilder sb2 = new StringBuilder();
                Object[] objArr7 = new Object[1];
                AFInAppEventParameterName("\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001", true, new int[]{60, 42, 0, 42}, objArr7);
                sb2.append(((String) objArr7[0]).intern());
                sb2.append(e8);
                AFLogger.afRDLog(sb2.toString());
                Object[] objArr8 = new Object[1];
                AFKeystoreWrapper(((byte) KeyEvent.getModifierMetaStateMask()) + 109, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 6, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 3, false, "￭￭￭￭\u001f\u0019\u001a", objArr8);
                return ((String) objArr8[0]).intern();
            }
        }

        static void AFInAppEventType() {
            AFInAppEventType = new char[]{'{', 138, 135, '{', 142, 141, 127, 135, 131, 142, 'y', 128, ' ', 'G', 'I', 'I', 'N', 'W', 'P', 'J', 16, 'C', 'f', 'l', 'e', 'D', '>', 'X', 'o', 'L', 'C', 'c', 'e', 'j', 'h', 'd', 'B', 'C', 'f', 'i', 'i', 'k', 'i', 'j', 'n', 'k', 'j', 'C', 'E', 'h', 'e', 'C', 'E', 'h', 'o', 'L', 'K', 'p', 'n', 'n', 16, '-', 'T', 'n', 'l', 'n', 'r', 'j', 'd', 'm', 'n', 'B', 'D', 'n', 'n', 'p', 'K', 'L', 'o', 'h', 'E', 'C', 'e', 'h', 'E', 'C', 'j', 'k', 'n', 'j', 'i', 'k', 'i', 'i', 'f', 'C', 'B', 'd', 'h', 'j', 'e', 'c', 22, 'O', 'j', 'H', ',', ':', 'p', 'f', 'k', 'K', 'C', 'e', 'h', 'E', 'C', 'j', 'k', 'n', 'j', 'i', 'k', 'i', 'i', 'f', 'C', 'B', 'd', 'h', 'j', 'e', 'c', 'C', 'B', 'm', 'p', 'f', '[', 'D', 'D', 'e', 'l', 'f', 'f', '3', 'j', 'k', 'n', 'j', 'i', 'k', 'i', 'i', 'f', 'C', 'B', 'd', 'h', 'j', 'e', 'c', 'C', '-', 'T', 'n', 'l', 'n', 'r', 'j', 'd', 'm', 'n', 'B', 'D', 'n', 'n', 'p', 'K', 'B', 'm', 'p', 'f', 'k', 'K', 'C', 'e', 'h', 'E', ':', 'l', 'i', 'n', 'j', 'k', 'i', 'j', 't', 's', 'k', 27, 'W', 'X', 147, 288, 285, 292, 293, 292, 135, 233, 'Q', 178, 185, 179, 185, 189, 189, 191, 184, 143, 143, 186, 189, 179, 168, 145, '3', 'K', 'P', 'P', 'P', 'Q', 'P', 'P', 'P', 'Q', '2', 'J', 'e', 'n', 'j', 'g'};
            values = 32;
        }

        private static StringBuilder AFKeystoreWrapper(@NonNull String... strArr) throws Exception {
            int charAt;
            ArrayList arrayList = new ArrayList();
            int length = strArr.length;
            int i8 = 0;
            while (true) {
                if (i8 >= 3) {
                    break;
                }
                int i9 = AFKeystoreWrapper + 79;
                AFLogger = i9 % 128;
                if (!(i9 % 2 != 0)) {
                    arrayList.add(Integer.valueOf(strArr[i8].length()));
                    i8 += 38;
                } else {
                    arrayList.add(Integer.valueOf(strArr[i8].length()));
                    i8++;
                }
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < intValue; i10++) {
                Integer num = null;
                for (int i11 = 0; i11 < 3; i11++) {
                    int i12 = AFKeystoreWrapper + 95;
                    AFLogger = i12 % 128;
                    if (i12 % 2 == 0) {
                        charAt = strArr[i11].charAt(i10);
                        int i13 = 82 / 0;
                        if ((num == null ? '.' : '=') != '=') {
                            num = Integer.valueOf(charAt);
                        }
                        charAt ^= num.intValue();
                        num = Integer.valueOf(charAt);
                    } else {
                        charAt = strArr[i11].charAt(i10);
                        if (num == null) {
                            num = Integer.valueOf(charAt);
                        }
                        charAt ^= num.intValue();
                        num = Integer.valueOf(charAt);
                    }
                }
                sb.append(Integer.toHexString(num.intValue()));
            }
            return sb;
        }

        private String valueOf() {
            String obj;
            boolean z7;
            int i8;
            boolean z8;
            try {
                Map<String, Object> map = this.valueOf;
                Object[] objArr = new Object[1];
                AFInAppEventParameterName(null, true, new int[]{0, 12, 26, 1}, objArr);
                String obj2 = map.get(((String) objArr[0]).intern()).toString();
                Map<String, Object> map2 = this.valueOf;
                Object[] objArr2 = new Object[1];
                AFKeystoreWrapper(134 - Color.alpha(0), TextUtils.lastIndexOf("", '0', 0, 0) + 16, View.getDefaultSize(0, 0) + 9, false, "\ufffb\u000f\b�\u0002\uffde\ufffb\u000e\uffff\u0000\u0003\f\r\u000e￦", objArr2);
                String obj3 = map2.get(((String) objArr2[0]).intern()).toString();
                Object[] objArr3 = new Object[1];
                AFKeystoreWrapper(80 - View.resolveSize(0, 0), 6 - (Process.myPid() >> 22), View.combineMeasuredStates(0, 0) + 2, true, "\ufffe\u0006\u0002\ufffe\u0000\u0001", objArr3);
                String intern = ((String) objArr3[0]).intern();
                Object[] objArr4 = new Object[1];
                AFInAppEventParameterName("\u0001\u0001\u0001\u0001\u0000", false, new int[]{102, 5, 0, 0}, objArr4);
                String replaceAll = intern.replaceAll(((String) objArr4[0]).intern(), "");
                StringBuilder sb = new StringBuilder();
                sb.append(obj2);
                sb.append(obj3);
                sb.append(replaceAll);
                String AFInAppEventParameterName = AFb1ySDK.AFInAppEventParameterName(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(AFInAppEventParameterName.substring(0, 16));
                obj = sb2.toString();
                int i9 = AFLogger + 123;
                AFKeystoreWrapper = i9 % 128;
                int i10 = i9 % 2;
            } catch (Exception e8) {
                Object[] objArr5 = new Object[1];
                AFInAppEventParameterName("\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0000", true, new int[]{107, 38, 0, 37}, objArr5);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e8);
                StringBuilder sb3 = new StringBuilder();
                Object[] objArr6 = new Object[1];
                AFInAppEventParameterName("\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001", true, new int[]{145, 44, 0, 17}, objArr6);
                sb3.append(((String) objArr6[0]).intern());
                sb3.append(e8);
                AFLogger.afRDLog(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                Object[] objArr7 = new Object[1];
                AFKeystoreWrapper((ViewConfiguration.getPressedStateDuration() >> 16) + 104, KeyEvent.keyCodeFromString("") + 18, TextUtils.indexOf("", "", 0, 0) + 16, false, "\u001a\u001d\u0019\u001d￨￭￬￨\u001c\ufff1￩\u001e￪￨￩\ufff0\u001a\u0019", objArr7);
                sb4.append(((String) objArr7[0]).intern());
                obj = sb4.toString();
            }
            String str = obj;
            try {
                Context context = this.AFInAppEventParameterName;
                Object[] objArr8 = new Object[1];
                AFKeystoreWrapper(120 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 37 - Color.green(0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 31, true, "￪\u0006\u0000\ufff9￬\ufffb\ufffb￨￩ￕ\u0015\u0016\u0010\u001b\n\bￕ\u001b\u0015\f\u001b\u0015\u0010ￕ\u000b\u0010\u0016\u0019\u000b\u0015\b￫￬￮\ufff5￨\uffef", objArr8);
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter(((String) objArr8[0]).intern()));
                if (registerReceiver != null) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                int i11 = -2700;
                if (!z7) {
                    int i12 = AFKeystoreWrapper + 15;
                    AFLogger = i12 % 128;
                    int i13 = i12 % 2;
                    Object[] objArr9 = new Object[1];
                    AFInAppEventParameterName("\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001", false, new int[]{189, 11, 0, 0}, objArr9);
                    i11 = registerReceiver.getIntExtra(((String) objArr9[0]).intern(), -2700);
                }
                String str2 = this.AFInAppEventParameterName.getApplicationInfo().nativeLibraryDir;
                if (str2 != null) {
                    int i14 = AFLogger + 97;
                    AFKeystoreWrapper = i14 % 128;
                    int i15 = i14 % 2;
                    Object[] objArr10 = new Object[1];
                    AFInAppEventParameterName("\u0000\u0000\u0000", false, new int[]{200, 3, 0, 1}, objArr10);
                    if (str2.contains(((String) objArr10[0]).intern())) {
                        z8 = false;
                    } else {
                        z8 = true;
                    }
                    if (!z8) {
                        int i16 = AFLogger + 21;
                        AFKeystoreWrapper = i16 % 128;
                        int i17 = i16 % 2;
                        i8 = 1;
                        Context context2 = this.AFInAppEventParameterName;
                        Object[] objArr11 = new Object[1];
                        AFInAppEventParameterName("\u0001\u0000\u0001\u0001\u0000\u0001", false, new int[]{203, 6, 180, 0}, objArr11);
                        int size = ((SensorManager) context2.getSystemService(((String) objArr11[0]).intern())).getSensorList(-1).size();
                        StringBuilder sb5 = new StringBuilder();
                        Object[] objArr12 = new Object[1];
                        AFKeystoreWrapper(130 - (ViewConfiguration.getJumpTapTimeout() >> 16), 1 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.getTrimmedLength("") + 1, true, "\u0000", objArr12);
                        sb5.append(((String) objArr12[0]).intern());
                        sb5.append(i11);
                        Object[] objArr13 = new Object[1];
                        AFKeystoreWrapper(((Process.getThreadPriority(0) + 20) >> 6) + 111, 3 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), Color.green(0) + 2, false, "ￗ)", objArr13);
                        sb5.append(((String) objArr13[0]).intern());
                        sb5.append(i8);
                        Object[] objArr14 = new Object[1];
                        AFKeystoreWrapper(TextUtils.lastIndexOf("", '0', 0, 0) + 109, View.MeasureSpec.getSize(0) + 2, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), false, "'ￚ", objArr14);
                        sb5.append(((String) objArr14[0]).intern());
                        sb5.append(size);
                        Object[] objArr15 = new Object[1];
                        AFInAppEventParameterName("\u0000\u0000", true, new int[]{209, 2, 158, 0}, objArr15);
                        sb5.append(((String) objArr15[0]).intern());
                        sb5.append(this.valueOf.size());
                        String obj4 = sb5.toString();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(str);
                        sb6.append(C0007AFa1ySDK.AFInAppEventParameterName(obj4));
                        return sb6.toString();
                    }
                }
                i8 = 0;
                Context context22 = this.AFInAppEventParameterName;
                Object[] objArr112 = new Object[1];
                AFInAppEventParameterName("\u0001\u0000\u0001\u0001\u0000\u0001", false, new int[]{203, 6, 180, 0}, objArr112);
                int size2 = ((SensorManager) context22.getSystemService(((String) objArr112[0]).intern())).getSensorList(-1).size();
                StringBuilder sb52 = new StringBuilder();
                Object[] objArr122 = new Object[1];
                AFKeystoreWrapper(130 - (ViewConfiguration.getJumpTapTimeout() >> 16), 1 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.getTrimmedLength("") + 1, true, "\u0000", objArr122);
                sb52.append(((String) objArr122[0]).intern());
                sb52.append(i11);
                Object[] objArr132 = new Object[1];
                AFKeystoreWrapper(((Process.getThreadPriority(0) + 20) >> 6) + 111, 3 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), Color.green(0) + 2, false, "ￗ)", objArr132);
                sb52.append(((String) objArr132[0]).intern());
                sb52.append(i8);
                Object[] objArr142 = new Object[1];
                AFKeystoreWrapper(TextUtils.lastIndexOf("", '0', 0, 0) + 109, View.MeasureSpec.getSize(0) + 2, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), false, "'ￚ", objArr142);
                sb52.append(((String) objArr142[0]).intern());
                sb52.append(size2);
                Object[] objArr152 = new Object[1];
                AFInAppEventParameterName("\u0000\u0000", true, new int[]{209, 2, 158, 0}, objArr152);
                sb52.append(((String) objArr152[0]).intern());
                sb52.append(this.valueOf.size());
                String obj42 = sb52.toString();
                StringBuilder sb62 = new StringBuilder();
                sb62.append(str);
                sb62.append(C0007AFa1ySDK.AFInAppEventParameterName(obj42));
                return sb62.toString();
            } catch (Exception e9) {
                Object[] objArr16 = new Object[1];
                AFInAppEventParameterName("\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000", true, new int[]{211, 16, 77, 4}, objArr16);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr16[0]).intern(), e9);
                StringBuilder sb7 = new StringBuilder();
                Object[] objArr17 = new Object[1];
                AFInAppEventParameterName("\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001", true, new int[]{145, 44, 0, 17}, objArr17);
                sb7.append(((String) objArr17[0]).intern());
                sb7.append(e9);
                AFLogger.afRDLog(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str);
                Object[] objArr18 = new Object[1];
                AFInAppEventParameterName("\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000", false, new int[]{227, 16, 0, 0}, objArr18);
                sb8.append(((String) objArr18[0]).intern());
                return sb8.toString();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
            r12 = r12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void AFInAppEventParameterName(java.lang.String r12, boolean r13, int[] r14, java.lang.Object[] r15) {
            /*
                if (r12 == 0) goto L8
                java.lang.String r0 = "ISO-8859-1"
                byte[] r12 = r12.getBytes(r0)
            L8:
                byte[] r12 = (byte[]) r12
                java.lang.Object r0 = com.appsflyer.internal.AFg1sSDK.values
                monitor-enter(r0)
                r1 = 0
                r2 = r14[r1]     // Catch: java.lang.Throwable -> L8b
                r3 = 1
                r4 = r14[r3]     // Catch: java.lang.Throwable -> L8b
                r5 = 2
                r6 = r14[r5]     // Catch: java.lang.Throwable -> L8b
                r7 = 3
                r7 = r14[r7]     // Catch: java.lang.Throwable -> L8b
                char[] r8 = com.appsflyer.internal.AFa1ySDK.AFa1xSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L8b
                char[] r9 = new char[r4]     // Catch: java.lang.Throwable -> L8b
                java.lang.System.arraycopy(r8, r2, r9, r1, r4)     // Catch: java.lang.Throwable -> L8b
                if (r12 == 0) goto L47
                char[] r2 = new char[r4]     // Catch: java.lang.Throwable -> L8b
                com.appsflyer.internal.AFg1sSDK.valueOf = r1     // Catch: java.lang.Throwable -> L8b
                r8 = 0
            L27:
                int r10 = com.appsflyer.internal.AFg1sSDK.valueOf     // Catch: java.lang.Throwable -> L8b
                if (r10 >= r4) goto L46
                r11 = r12[r10]     // Catch: java.lang.Throwable -> L8b
                if (r11 != r3) goto L38
                char r11 = r9[r10]     // Catch: java.lang.Throwable -> L8b
                int r11 = r11 << r3
                int r11 = r11 + r3
                int r11 = r11 - r8
                char r8 = (char) r11     // Catch: java.lang.Throwable -> L8b
                r2[r10] = r8     // Catch: java.lang.Throwable -> L8b
                goto L3f
            L38:
                char r11 = r9[r10]     // Catch: java.lang.Throwable -> L8b
                int r11 = r11 << r3
                int r11 = r11 - r8
                char r8 = (char) r11     // Catch: java.lang.Throwable -> L8b
                r2[r10] = r8     // Catch: java.lang.Throwable -> L8b
            L3f:
                char r8 = r2[r10]     // Catch: java.lang.Throwable -> L8b
                int r10 = r10 + 1
                com.appsflyer.internal.AFg1sSDK.valueOf = r10     // Catch: java.lang.Throwable -> L8b
                goto L27
            L46:
                r9 = r2
            L47:
                if (r7 <= 0) goto L56
                char[] r12 = new char[r4]     // Catch: java.lang.Throwable -> L8b
                java.lang.System.arraycopy(r9, r1, r12, r1, r4)     // Catch: java.lang.Throwable -> L8b
                int r2 = r4 - r7
                java.lang.System.arraycopy(r12, r1, r9, r2, r7)     // Catch: java.lang.Throwable -> L8b
                java.lang.System.arraycopy(r12, r7, r9, r1, r2)     // Catch: java.lang.Throwable -> L8b
            L56:
                if (r13 == 0) goto L6d
                char[] r12 = new char[r4]     // Catch: java.lang.Throwable -> L8b
                com.appsflyer.internal.AFg1sSDK.valueOf = r1     // Catch: java.lang.Throwable -> L8b
            L5c:
                int r13 = com.appsflyer.internal.AFg1sSDK.valueOf     // Catch: java.lang.Throwable -> L8b
                if (r13 >= r4) goto L6c
                int r2 = r4 - r13
                int r2 = r2 - r3
                char r2 = r9[r2]     // Catch: java.lang.Throwable -> L8b
                r12[r13] = r2     // Catch: java.lang.Throwable -> L8b
                int r13 = r13 + 1
                com.appsflyer.internal.AFg1sSDK.valueOf = r13     // Catch: java.lang.Throwable -> L8b
                goto L5c
            L6c:
                r9 = r12
            L6d:
                if (r6 <= 0) goto L82
                com.appsflyer.internal.AFg1sSDK.valueOf = r1     // Catch: java.lang.Throwable -> L8b
            L71:
                int r12 = com.appsflyer.internal.AFg1sSDK.valueOf     // Catch: java.lang.Throwable -> L8b
                if (r12 >= r4) goto L82
                char r13 = r9[r12]     // Catch: java.lang.Throwable -> L8b
                r2 = r14[r5]     // Catch: java.lang.Throwable -> L8b
                int r13 = r13 - r2
                char r13 = (char) r13     // Catch: java.lang.Throwable -> L8b
                r9[r12] = r13     // Catch: java.lang.Throwable -> L8b
                int r12 = r12 + 1
                com.appsflyer.internal.AFg1sSDK.valueOf = r12     // Catch: java.lang.Throwable -> L8b
                goto L71
            L82:
                java.lang.String r12 = new java.lang.String     // Catch: java.lang.Throwable -> L8b
                r12.<init>(r9)     // Catch: java.lang.Throwable -> L8b
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
                r15[r1] = r12
                return
            L8b:
                r12 = move-exception
                monitor-exit(r0)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.AFa1xSDK.AFInAppEventParameterName(java.lang.String, boolean, int[], java.lang.Object[]):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
            r10 = r10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void AFKeystoreWrapper(int r6, int r7, int r8, boolean r9, java.lang.String r10, java.lang.Object[] r11) {
            /*
                if (r10 == 0) goto L6
                char[] r10 = r10.toCharArray()
            L6:
                char[] r10 = (char[]) r10
                java.lang.Object r0 = com.appsflyer.internal.AFg1pSDK.values
                monitor-enter(r0)
                char[] r1 = new char[r7]     // Catch: java.lang.Throwable -> L67
                r2 = 0
                com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r2     // Catch: java.lang.Throwable -> L67
            L10:
                int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L67
                if (r3 >= r7) goto L2f
                char r3 = r10[r3]     // Catch: java.lang.Throwable -> L67
                com.appsflyer.internal.AFg1pSDK.AFKeystoreWrapper = r3     // Catch: java.lang.Throwable -> L67
                int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L67
                int r4 = com.appsflyer.internal.AFg1pSDK.AFKeystoreWrapper     // Catch: java.lang.Throwable -> L67
                int r4 = r4 + r6
                char r4 = (char) r4     // Catch: java.lang.Throwable -> L67
                r1[r3] = r4     // Catch: java.lang.Throwable -> L67
                int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L67
                char r4 = r1[r3]     // Catch: java.lang.Throwable -> L67
                int r5 = com.appsflyer.internal.AFa1ySDK.AFa1xSDK.values     // Catch: java.lang.Throwable -> L67
                int r4 = r4 - r5
                char r4 = (char) r4     // Catch: java.lang.Throwable -> L67
                r1[r3] = r4     // Catch: java.lang.Throwable -> L67
                int r3 = r3 + 1
                com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r3     // Catch: java.lang.Throwable -> L67
                goto L10
            L2f:
                if (r8 <= 0) goto L46
                com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName = r8     // Catch: java.lang.Throwable -> L67
                char[] r6 = new char[r7]     // Catch: java.lang.Throwable -> L67
                java.lang.System.arraycopy(r1, r2, r6, r2, r7)     // Catch: java.lang.Throwable -> L67
                int r8 = com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName     // Catch: java.lang.Throwable -> L67
                int r10 = r7 - r8
                java.lang.System.arraycopy(r6, r2, r1, r10, r8)     // Catch: java.lang.Throwable -> L67
                int r8 = com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName     // Catch: java.lang.Throwable -> L67
                int r10 = r7 - r8
                java.lang.System.arraycopy(r6, r8, r1, r2, r10)     // Catch: java.lang.Throwable -> L67
            L46:
                if (r9 == 0) goto L5e
                char[] r6 = new char[r7]     // Catch: java.lang.Throwable -> L67
                com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r2     // Catch: java.lang.Throwable -> L67
            L4c:
                int r8 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L67
                if (r8 >= r7) goto L5d
                int r9 = r7 - r8
                int r9 = r9 + (-1)
                char r9 = r1[r9]     // Catch: java.lang.Throwable -> L67
                r6[r8] = r9     // Catch: java.lang.Throwable -> L67
                int r8 = r8 + 1
                com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r8     // Catch: java.lang.Throwable -> L67
                goto L4c
            L5d:
                r1 = r6
            L5e:
                java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L67
                r6.<init>(r1)     // Catch: java.lang.Throwable -> L67
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L67
                r11[r2] = r6
                return
            L67:
                r6 = move-exception
                monitor-exit(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.AFa1xSDK.AFKeystoreWrapper(int, int, int, boolean, java.lang.String, java.lang.Object[]):void");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void AFKeystoreWrapper(java.lang.StringBuilder r11) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.AFKeystoreWrapper(java.lang.StringBuilder):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r8 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void values(java.lang.String r8, int r9, java.lang.Object[] r10) {
        /*
            if (r8 == 0) goto L6
            char[] r8 = r8.toCharArray()
        L6:
            char[] r8 = (char[]) r8
            java.lang.Object r0 = com.appsflyer.internal.AFf1aSDK.values
            monitor-enter(r0)
            long r1 = com.appsflyer.internal.AFa1ySDK.values     // Catch: java.lang.Throwable -> L46
            char[] r8 = com.appsflyer.internal.AFf1aSDK.values(r1, r8, r9)     // Catch: java.lang.Throwable -> L46
            r9 = 4
            com.appsflyer.internal.AFf1aSDK.AFKeystoreWrapper = r9     // Catch: java.lang.Throwable -> L46
        L14:
            int r1 = com.appsflyer.internal.AFf1aSDK.AFKeystoreWrapper     // Catch: java.lang.Throwable -> L46
            int r2 = r8.length     // Catch: java.lang.Throwable -> L46
            if (r1 >= r2) goto L3a
            int r1 = r1 + (-4)
            com.appsflyer.internal.AFf1aSDK.AFInAppEventType = r1     // Catch: java.lang.Throwable -> L46
            int r1 = com.appsflyer.internal.AFf1aSDK.AFKeystoreWrapper     // Catch: java.lang.Throwable -> L46
            char r2 = r8[r1]     // Catch: java.lang.Throwable -> L46
            int r3 = r1 % 4
            char r3 = r8[r3]     // Catch: java.lang.Throwable -> L46
            r2 = r2 ^ r3
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L46
            int r4 = com.appsflyer.internal.AFf1aSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L46
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L46
            long r6 = com.appsflyer.internal.AFa1ySDK.values     // Catch: java.lang.Throwable -> L46
            long r4 = r4 * r6
            long r2 = r2 ^ r4
            int r3 = (int) r2     // Catch: java.lang.Throwable -> L46
            char r2 = (char) r3     // Catch: java.lang.Throwable -> L46
            r8[r1] = r2     // Catch: java.lang.Throwable -> L46
            int r1 = com.appsflyer.internal.AFf1aSDK.AFKeystoreWrapper     // Catch: java.lang.Throwable -> L46
            int r1 = r1 + 1
            com.appsflyer.internal.AFf1aSDK.AFKeystoreWrapper = r1     // Catch: java.lang.Throwable -> L46
            goto L14
        L3a:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L46
            int r2 = r8.length     // Catch: java.lang.Throwable -> L46
            int r2 = r2 - r9
            r1.<init>(r8, r9, r2)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L46
            r8 = 0
            r10[r8] = r1
            return
        L46:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.values(java.lang.String, int, java.lang.Object[]):void");
    }

    private static boolean AFInAppEventType(String str) {
        int i8 = AFKeystoreWrapper + 25;
        AFInAppEventParameterName = i8 % 128;
        try {
            if (i8 % 2 != 0) {
                Class.forName(str);
                return false;
            }
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e8) {
            Object[] objArr = new Object[1];
            AFInAppEventType((char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 50 - (ViewConfiguration.getJumpTapTimeout() >> 16), 18 - TextUtils.lastIndexOf("", '0', 0, 0), objArr);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr[0]).intern(), e8);
            return false;
        }
    }

    private static void AFInAppEventType(char c8, int i8, int i9, Object[] objArr) {
        String str;
        synchronized (AFg1oSDK.AFInAppEventType) {
            char[] cArr = new char[i9];
            AFg1oSDK.AFKeystoreWrapper = 0;
            while (true) {
                int i10 = AFg1oSDK.AFKeystoreWrapper;
                if (i10 < i9) {
                    cArr[i10] = (char) ((AFInAppEventType[i8 + i10] ^ (i10 * valueOf)) ^ c8);
                    AFg1oSDK.AFKeystoreWrapper = i10 + 1;
                } else {
                    str = new String(cArr);
                }
            }
        }
        objArr[0] = str;
    }
}
