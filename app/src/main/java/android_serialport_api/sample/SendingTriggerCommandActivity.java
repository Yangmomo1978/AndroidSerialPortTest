/*
 * Copyright 2011 Cedric Priscal
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package android_serialport_api.sample;

import java.io.IOException;
import java.math.BigInteger;

import android.os.Bundle;
import android.util.Log;

public class SendingTriggerCommandActivity extends SerialPortActivity {

	private static final String TAG =SendingTriggerCommandActivity.class.getSimpleName() ;
	SendingThread mSendingThread;
	byte[] mBuffer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sending01010101);
		//mBuffer = new byte[1024];
		//Arrays.fill(mBuffer, (byte) 0x55);

	}

	@Override
	protected void onStart() {
		super.onStart();
		//to start the aimer on
		//SYN M CR scnaim2.

		mBuffer=new byte[] { (byte)0x16, 0x4D, 0x0D, 0x73,0x63,0x6E,0x61,0x69,0x6D,0x32,0x2E};//try for small character


		//SYN M CR SCNAIM2.
		//mBuffer=new byte[]{(byte)0x16, 0x4D, 0x0D,0x53,0x43,0x4E,0x41,0x49,0x4D,0x32,0x2E}; //capital character

		//String command="SYNMCRSCNAIM2";
		//mBuffer=command.getBytes();

		if (mSerialPort != null) {
			mSendingThread = new SendingThread();
			mSendingThread.start();
		}
	}

	@Override
	protected void onDataReceived(byte[] buffer, int size) {
		// ignore incoming data
		Log.d(TAG,buffer.toString());
	}

	private class SendingThread extends Thread {
		@Override
		public void run() {
			while (!isInterrupted()) {
				try {
					if (mOutputStream != null) {
						mOutputStream.write(mBuffer,0,mBuffer.length);
						mOutputStream.flush();
						mOutputStream.close();
					} else {
						return;
					}
				} catch (IOException e) {
					e.printStackTrace();
					return;
				}
			}
		}
	}
}
