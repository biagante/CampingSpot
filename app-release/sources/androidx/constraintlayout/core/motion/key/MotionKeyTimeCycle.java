package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

public class MotionKeyTimeCycle extends MotionKey {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private float mAlpha = Float.NaN;
    private int mCurveFit = -1;
    private String mCustomWaveShape = null;
    private float mElevation = Float.NaN;
    private float mProgress = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private String mTransitionEasing;
    private float mTransitionPathRotate = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mWavePeriod = Float.NaN;
    private int mWaveShape = 0;

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    public MotionKeyTimeCycle() {
        this.mType = 3;
        this.mCustom = new HashMap();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        if (r1.equals("translationX") != false) goto L_0x00cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addTimeValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r11) {
        /*
            r10 = this;
            java.util.Set r0 = r11.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0201
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r11.get(r1)
            r3 = r2
            androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet r3 = (androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet) r3
            if (r3 != 0) goto L_0x001e
            goto L_0x0008
        L_0x001e:
            java.lang.String r2 = "CUSTOM"
            boolean r2 = r1.startsWith(r2)
            r4 = 7
            if (r2 == 0) goto L_0x0045
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap r2 = r10.mCustom
            java.lang.Object r1 = r2.get(r1)
            r6 = r1
            androidx.constraintlayout.core.motion.CustomVariable r6 = (androidx.constraintlayout.core.motion.CustomVariable) r6
            if (r6 == 0) goto L_0x0008
            r4 = r3
            androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet$CustomVarSet r4 = (androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet.CustomVarSet) r4
            int r5 = r10.mFramePosition
            float r7 = r10.mWavePeriod
            int r8 = r10.mWaveShape
            float r9 = r10.mWaveOffset
            r4.setPoint((int) r5, (androidx.constraintlayout.core.motion.CustomVariable) r6, (float) r7, (int) r8, (float) r9)
            goto L_0x0008
        L_0x0045:
            r2 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00c2;
                case -1249320805: goto L_0x00b8;
                case -1249320804: goto L_0x00ae;
                case -1225497657: goto L_0x00a5;
                case -1225497656: goto L_0x009a;
                case -1225497655: goto L_0x008f;
                case -1001078227: goto L_0x0084;
                case -908189618: goto L_0x007a;
                case -908189617: goto L_0x0070;
                case -4379043: goto L_0x0065;
                case 92909918: goto L_0x005a;
                case 803192288: goto L_0x004f;
                default: goto L_0x004d;
            }
        L_0x004d:
            goto L_0x00cc
        L_0x004f:
            java.lang.String r4 = "pathRotate"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 4
            goto L_0x00cd
        L_0x005a:
            java.lang.String r4 = "alpha"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 0
            goto L_0x00cd
        L_0x0065:
            java.lang.String r4 = "elevation"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 10
            goto L_0x00cd
        L_0x0070:
            java.lang.String r4 = "scaleY"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 6
            goto L_0x00cd
        L_0x007a:
            java.lang.String r4 = "scaleX"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 5
            goto L_0x00cd
        L_0x0084:
            java.lang.String r4 = "progress"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 11
            goto L_0x00cd
        L_0x008f:
            java.lang.String r4 = "translationZ"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 9
            goto L_0x00cd
        L_0x009a:
            java.lang.String r4 = "translationY"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 8
            goto L_0x00cd
        L_0x00a5:
            java.lang.String r5 = "translationX"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00cc
            goto L_0x00cd
        L_0x00ae:
            java.lang.String r4 = "rotationZ"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 3
            goto L_0x00cd
        L_0x00b8:
            java.lang.String r4 = "rotationY"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 2
            goto L_0x00cd
        L_0x00c2:
            java.lang.String r4 = "rotationX"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00cc
            r4 = 1
            goto L_0x00cd
        L_0x00cc:
            r4 = -1
        L_0x00cd:
            switch(r4) {
                case 0: goto L_0x01ea;
                case 1: goto L_0x01d3;
                case 2: goto L_0x01bc;
                case 3: goto L_0x01a5;
                case 4: goto L_0x018e;
                case 5: goto L_0x0177;
                case 6: goto L_0x0160;
                case 7: goto L_0x0149;
                case 8: goto L_0x0132;
                case 9: goto L_0x011b;
                case 10: goto L_0x0104;
                case 11: goto L_0x00ed;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "UNKNOWN addValues \""
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "KeyTimeCycles"
            androidx.constraintlayout.core.motion.utils.Utils.loge(r2, r1)
            goto L_0x0008
        L_0x00ed:
            float r1 = r10.mProgress
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mProgress
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0104:
            float r1 = r10.mTranslationZ
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mTranslationZ
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x011b:
            float r1 = r10.mTranslationZ
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mTranslationZ
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0132:
            float r1 = r10.mTranslationY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mTranslationY
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0149:
            float r1 = r10.mTranslationX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mTranslationX
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0160:
            float r1 = r10.mScaleY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mScaleY
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0177:
            float r1 = r10.mScaleX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mScaleX
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x018e:
            float r1 = r10.mTransitionPathRotate
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mTransitionPathRotate
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01a5:
            float r1 = r10.mRotation
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mRotation
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01bc:
            float r1 = r10.mRotationY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mRotationY
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01d3:
            float r1 = r10.mRotationX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mRotationX
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x01ea:
            float r1 = r10.mAlpha
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.mFramePosition
            float r5 = r10.mAlpha
            float r6 = r10.mWavePeriod
            int r7 = r10.mWaveShape
            float r8 = r10.mWaveOffset
            r3.setPoint(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0201:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle.addTimeValues(java.util.HashMap):void");
    }

    public boolean setValue(int i, int i2) {
        if (i == 100) {
            this.mFramePosition = i2;
            return true;
        } else if (i != 421) {
            return super.setValue(i, i2);
        } else {
            this.mWaveShape = i2;
            return true;
        }
    }

    public boolean setValue(int i, float f) {
        if (i == 315) {
            this.mProgress = toFloat(Float.valueOf(f));
            return true;
        } else if (i == 401) {
            this.mCurveFit = toInt(Float.valueOf(f));
            return true;
        } else if (i == 403) {
            this.mAlpha = f;
            return true;
        } else if (i == 416) {
            this.mTransitionPathRotate = toFloat(Float.valueOf(f));
            return true;
        } else if (i == 423) {
            this.mWavePeriod = toFloat(Float.valueOf(f));
            return true;
        } else if (i != 424) {
            switch (i) {
                case 304:
                    this.mTranslationX = toFloat(Float.valueOf(f));
                    return true;
                case 305:
                    this.mTranslationY = toFloat(Float.valueOf(f));
                    return true;
                case 306:
                    this.mTranslationZ = toFloat(Float.valueOf(f));
                    return true;
                case 307:
                    this.mElevation = toFloat(Float.valueOf(f));
                    return true;
                case 308:
                    this.mRotationX = toFloat(Float.valueOf(f));
                    return true;
                case 309:
                    this.mRotationY = toFloat(Float.valueOf(f));
                    return true;
                case 310:
                    this.mRotation = toFloat(Float.valueOf(f));
                    return true;
                case 311:
                    this.mScaleX = toFloat(Float.valueOf(f));
                    return true;
                case 312:
                    this.mScaleY = toFloat(Float.valueOf(f));
                    return true;
                default:
                    return super.setValue(i, f);
            }
        } else {
            this.mWaveOffset = toFloat(Float.valueOf(f));
            return true;
        }
    }

    public boolean setValue(int i, String str) {
        if (i == 420) {
            this.mTransitionEasing = str;
            return true;
        } else if (i != 421) {
            return super.setValue(i, str);
        } else {
            this.mWaveShape = 7;
            this.mCustomWaveShape = str;
            return true;
        }
    }

    public boolean setValue(int i, boolean z) {
        return super.setValue(i, z);
    }

    public MotionKeyTimeCycle copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyTimeCycle motionKeyTimeCycle = (MotionKeyTimeCycle) motionKey;
        this.mTransitionEasing = motionKeyTimeCycle.mTransitionEasing;
        this.mCurveFit = motionKeyTimeCycle.mCurveFit;
        this.mWaveShape = motionKeyTimeCycle.mWaveShape;
        this.mWavePeriod = motionKeyTimeCycle.mWavePeriod;
        this.mWaveOffset = motionKeyTimeCycle.mWaveOffset;
        this.mProgress = motionKeyTimeCycle.mProgress;
        this.mAlpha = motionKeyTimeCycle.mAlpha;
        this.mElevation = motionKeyTimeCycle.mElevation;
        this.mRotation = motionKeyTimeCycle.mRotation;
        this.mTransitionPathRotate = motionKeyTimeCycle.mTransitionPathRotate;
        this.mRotationX = motionKeyTimeCycle.mRotationX;
        this.mRotationY = motionKeyTimeCycle.mRotationY;
        this.mScaleX = motionKeyTimeCycle.mScaleX;
        this.mScaleY = motionKeyTimeCycle.mScaleY;
        this.mTranslationX = motionKeyTimeCycle.mTranslationX;
        this.mTranslationY = motionKeyTimeCycle.mTranslationY;
        this.mTranslationZ = motionKeyTimeCycle.mTranslationZ;
        return this;
    }

    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (this.mCustom.size() > 0) {
            for (String str : this.mCustom.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public MotionKey clone() {
        return new MotionKeyTimeCycle().copy((MotionKey) this);
    }

    public int getId(String str) {
        return TypedValues.CycleType.CC.getId(str);
    }
}
