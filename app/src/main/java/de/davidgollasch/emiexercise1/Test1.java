package de.davidgollasch.emiexercise1;

import java.text.NumberFormat;

import static java.lang.System.*;

/**
 * Created by Martin on 24.10.2016.
 */

final class Test1 {
    /*public void test1_0Strength() throws Exception {
        boolean result = false;
        String msg = "test1_0Strength()";
        getBassBoost(0);
        try {
            if (mBassBoost.getStrengthSupported()) {
                mBassBoost.setStrength((short)TEST_STRENGTH);
                short strength = mBassBoost.getRoundedStrength();
                // allow 10% difference between set strength and rounded strength
                assertTrue(msg +": got incorrect strength",
                        ((float)strength > (float)TEST_STRENGTH * 0.9f) &&
                                ((float)strength < (float)TEST_STRENGTH * 1.1f));
            } else {
                short strength = mBassBoost.getRoundedStrength();
                assertTrue(msg +": got incorrect strength", strength >= 0 && strength <= 1000);
            }
            result = true;
        } catch (IllegalArgumentException e) {
            msg = msg.concat(": Bad parameter value");
            loge(msg, "Bad parameter value");
        } catch (UnsupportedOperationException e) {
            msg = msg.concat(": get parameter() rejected");
            loge(msg, "get parameter() rejected");
        } catch (IllegalStateException e) {
            msg = msg.concat("get parameter() called in wrong state");
            loge(msg, "get parameter() called in wrong state");
        } finally {
            releaseBassBoost();
        }
        assertTrue(msg, result);
    }

    //Test case 1.1: test properties
    @LargeTest
    public void test1_1Properties() throws Exception {
        boolean result = false;
        String msg = "test1_1Properties()";
        getBassBoost(0);
        try {
            BassBoost.Settings settings = mBassBoost.getProperties();
            String str = settings.toString();
            settings = new BassBoost.Settings(str);
            mBassBoost.setProperties(settings);
            result = true;
        } catch (IllegalArgumentException e) {
            msg = msg.concat(": Bad parameter value");
            loge(msg, "Bad parameter value");
        } catch (UnsupportedOperationException e) {
            msg = msg.concat(": get parameter() rejected");
            loge(msg, "get parameter() rejected");
        } catch (IllegalStateException e) {
            msg = msg.concat("get parameter() called in wrong state");
            loge(msg, "get parameter() called in wrong state");
        } finally {
            releaseBassBoost();
        }
        assertTrue(msg, result);
    }

    //-----------------------------------------------------------------
    // private methods
    //----------------------------------

    private void getBassBoost(int session) {
        if (mBassBoost == null || session != mSession) {
            if (session != mSession && mBassBoost != null) {
                mBassBoost.release();
                mBassBoost = null;
            }
            try {
                mBassBoost = new BassBoost(0, session);
                mSession = session;
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "getBassBoost() BassBoost not found exception: "+e);
            } catch (UnsupportedOperationException e) {
                Log.e(TAG, "getBassBoost() Effect library not loaded exception: "+e);
            }
        }
        assertNotNull("could not create mBassBoost", mBassBoost);
    }

    private void releaseBassBoost() {
        if (mBassBoost != null) {
            mBassBoost.release();
            mBassBoost = null;
        }
    }
*/
}


