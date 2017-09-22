package com.vladimirdanielyan.customviews.utilities;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

/**
 * Created by vlad on 8/11/17.
 * The Utility To Convert Images Into String Or Another Format
 */

public class ImageConverter {

    // TAG variable for logging
    private static final String TAG = ImageConverter.class.getSimpleName();

    /**
     * The Method Is Converting Image Resource Into Bitmap
     * @param res - Resource Object: In activity getResources() returns the object
     * @param resourceId - resource id: Example R.drawable.icon
     * @return - returns Bitmap Object
     */

    public static Bitmap toBitmap(Resources res, int resourceId) {

        // Decoding And Returning resource file as bitmap object
        return BitmapFactory.decodeResource(res, resourceId);
    }


    /**
     * The Method Is Converting Decoded String Into Bitmap
     * @param encodedString - decoded string
     * @return - bitmap format of the decoded string
     */

    public static Bitmap toBitmap(String encodedString) {
        try {

            // Converting String Into Byte Array
            byte [] encodeByte=Base64.decode(encodedString,Base64.DEFAULT);

            // Returning Bitmap Format Of The String
            return BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch(Exception e) {

            // Logging Error Message
            Log.e(TAG, e.getMessage());
            return null;
        }
    }


    /**
     * The Method Is Converting Bitmap Into String
     * @param imageBitmapObject - Image's Bitmap Format Of File
     * @return - String Format Of The Bitmap
     */

    public static String toString(Bitmap imageBitmapObject) {

        // Reading Bitmap
        ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
        imageBitmapObject.compress(Bitmap.CompressFormat.PNG, 100, bYtE);
        imageBitmapObject.recycle();

        // Converting Bitmap Into Byte Array
        byte[] byteArray = bYtE.toByteArray();

        // Returning String Format Of The Bitmap
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }


    /**
     * The Method Is Converting Image Resource Into String
     * @param res - Resource Object: In activity getResources() returns the object
     * @param resourceId - resource id: Example R.drawable.icon
     * @return - returns Bitmap Object
     */

    public static String toString(Resources res, int resourceId) {

        // Getting Image Bitmap Format Of The Image Resource Retuning Its String Format
        return toString(toBitmap(res, resourceId));
    }
}
