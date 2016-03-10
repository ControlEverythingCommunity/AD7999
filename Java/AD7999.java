// Distributed with a free-will license.
// Use it any way you want, profit or free, provided it fits in the licenses of its associated works.
// AD7999
// This code is designed to work with the AD7999_I2CADC I2C Mini Module available from ControlEverything.com.
// https://www.controleverything.com/content/Analog-Digital-Converters?sku=AD7999_I2CADC#tabs-0-product_tabset-2

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;

public class AD7999
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
		byte[] data = new byte[2];
		device.read(data, 0, 2);
		
		// Convert the data to 8-bits
		int raw_adc = (((data[0] & 0x0F) * 256) + (data[1] & 0xF0)) / 16;

		// Output data to screen
		System.out.printf("Digital value of analog input : %d %n", raw_adc);
	}
}
