/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.motorola.usb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.Context;

import android.util.Log;

public class MassStorageSwitchReceiver extends BroadcastReceiver {
	
    private static final String TAG = "OutgoingCallNotifyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG,"MassStorageSwitchReceiver");
    	if(intent.getAction().equals(UsbService.ACTION_MASS_STORAGE_SWICTH_BUTTON)) {
            int currentUsbModeIndex = UsbSettings.readCurrentMode(context);
            currentUsbModeIndex = 
                currentUsbModeIndex == UsbService.USB_MODE_MSC ? UsbService.USB_MODE_NONE : UsbService.USB_MODE_MSC;
    	    Intent myIntent = new Intent(UsbService.ACTION_MODE_SWITCH_FROM_UI);
            myIntent.putExtra(UsbService.EXTRA_MODE_SWITCH_MODE, currentUsbModeIndex);
            context.sendBroadcast(myIntent);
    	}
        
        
    }
}
