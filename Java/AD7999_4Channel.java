// Distributed with a free-will license.
// Use it any way you want, profit or free, provided it fits in the licenses of its associated works.
// AD7999
// This code is designed to work with the AD7999_I2CADC I2C Mini Module available from ControlEverything.com.
// https://www.controleverything.com/content/Analog-Digital-Converters?sku=AD7999_I2CADC#tabs-0-product_tabset-2

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;

public class AD7999_4Channel
{
	public static void main(String args[]) throws Exception
	{
		// Create I2CBus
		I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);
		// Get I2C device, AD7999 I2C address is 0x29(41)
		I2CDevice device = bus.getDevice(0x29);

		// Send configuration command
		// Channel-1, filter enabled
		device.write((byte)0x10);
		Thread.sleep(500);

		// Read 2 bytes of data
		// raw_adc msb, raw_adc lsb
		byte[] data1 = new byte[2];
		device.read(data1, 0, 2);
		
		// Convert the data to 8-bits
		int raw_adc1 = (((data1[0] & 0x0F) * 256) + (data1[1] & 0xF0)) / 16;

		// Output data to screen
		System.out.printf("Digital value of analog input on Channel-1: %d %n", raw_adc1);

		// Send configuration command
		// Channel-2, filter enabled
		device.write((byte)0x20);
		Thread.sleep(500);

		// Read 2 bytes of data
		// raw_adc msb, raw_adc lsb
		byte[] data2 = new byte[2];
		device.read(data2, 0, 2);
		
		// Convert the data to 8-bits
		int raw_adc2 = (((data2[0] & 0x0F) * 256) + (data2[1] & 0xF0)) / 16;

		// Output data to screen
		System.out.printf("Digital value of analog input on Channel-2: %d %n", raw_adc2);

		// Send configuration command
		// Channel-3, filter enabled
		device.write((byte)0x40);
		Thread.sleep(500);

		// Read 2 bytes of data
		// raw_adc msb, raw_adc lsb
		byte[] data3 = new byte[2];
		device.read(data3, 0, 2);
		
		// Convert the data to 8-bits
		int raw_adc3 = (((data3[0] & 0x0F) * 256) + (data3[1] & 0xF0)) / 16;

		// Output data to screen
		System.out.printf("Digital value of analog input on Channel-3: %d %n", raw_adc3);

		// Send configuration command
		// Channel-4, filter enabled
		device.write((byte)0x80);
		Thread.sleep(500);

		// Read 2 bytes of data
		// raw_adc msb, raw_adc lsb
		byte[] data4 = new byte[2];
		device.read(data4, 0, 2);
		
		// Convert the data to 8-bits
		int raw_adc4 = (((data4[0] & 0x0F) * 256) + (data4[1] & 0xF0)) / 16;

		// Output data to screen
		System.out.printf("Digital value of analog input on Channel-4: %d %n", raw_adc4);
	}
}
