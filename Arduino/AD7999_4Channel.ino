// Distributed with a free-will license.
// Use it any way you want, profit or free, provided it fits in the licenses of its associated works.
// AD7999
// This code is designed to work with the AD7999_I2CADC I2C Mini Module available from ControlEverything.com.
// https://www.controleverything.com/content/Analog-Digital-Converters?sku=AD7999_I2CADC#tabs-0-product_tabset-2

#include<Wire.h>

// AD7999 I2C address is 0x29(41)
#define Addr 0x29

void setup()
{
  // Initialise I2C communication as MASTER
  Wire.begin();
  // Initialise serial communication, set baud rate = 9600
  Serial.begin(9600);
}

void loop()
{
  unsigned int data[2];
  // Start I2C Transmission
  Wire.beginTransmission(Addr);
  // Select configuration register, channel 1 enabled
  Wire.write(0x10);
  // Stop I2C Transmission
  Wire.endTransmission();
  delay(300);

  // Start I2C Transmission
  Wire.beginTransmission(Addr);
  // Stop I2C Transmission
  Wire.endTransmission();

  // Request 2 bytes of data
  Wire.requestFrom(Addr, 2);

  // Read 2 bytes of data
  // raw_adc msb, raw_adc lsb
  if (Wire.available() == 2)
  {
    data[0] = Wire.read();
    data[1] = Wire.read();
  }
  delay(300);

  // Convert the data
  int raw_adc = (((data[0] & 0x0F) * 256) + (data[1] & 0xF0)) / 16 ;

  // Output data to serial monitor
  Serial.print("Digital value of Analog input on Channel 1: ");
  Serial.println(raw_adc);
  delay(500);

  // Start I2C Transmission
  Wire.beginTransmission(Addr);
  // Select configuration register, channel 2 enabled
  Wire.write(0x20);
  // Stop I2C Transmission
  Wire.endTransmission();
  delay(300);

  // Start I2C Transmission
  Wire.beginTransmission(Addr);
  // Stop I2C Transmission
  Wire.endTransmission();

  // Request 2 bytes of data
  Wire.requestFrom(Addr, 2);

  // Read 2 bytes of data
  // raw_adc msb, raw_adc lsb
  if (Wire.available() == 2)
  {
    data[0] = Wire.read();
    data[1] = Wire.read();
  }
  delay(300);

  // Convert the data
  raw_adc = (((data[0] & 0x0F) * 256) + (data[1] & 0xF0)) / 16 ;

  // Output data to serial monitor
  Serial.print("Digital value of Analog input on Channel 2: ");
  Serial.println(raw_adc);
  delay(500);

  // Start I2C Transmission
  Wire.beginTransmission(Addr);
  // Select configuration register, channel 3 enabled
  Wire.write(0x40);
  // Stop I2C Transmission
  Wire.endTransmission();
  delay(300);

  // Start I2C Transmission
  Wire.beginTransmission(Addr);
  // Stop I2C Transmission
  Wire.endTransmission();

  // Request 2 bytes of data
  Wire.requestFrom(Addr, 2);

  // Read 2 bytes of data
  // raw_adc msb, raw_adc lsb
  if (Wire.available() == 2)
  {
    data[0] = Wire.read();
    data[1] = Wire.read();
  }
  delay(300);

  // Convert the data
  raw_adc = (((data[0] & 0x0F) * 256) + (data[1] & 0xF0)) / 16 ;

  // Output data to serial monitor
  Serial.print("Digital value of Analog input on Channel 3: ");
  Serial.println(raw_adc);
  delay(500);

  // Start I2C Transmission
  Wire.beginTransmission(Addr);
  // Select configuration register, channel 4 enabled
  Wire.write(0x80);
  // Stop I2C Transmission
  Wire.endTransmission();
  delay(300);

  // Start I2C Transmission
  Wire.beginTransmission(Addr);
  // Stop I2C Transmission
  Wire.endTransmission();

  // Request 2 bytes of data
  Wire.requestFrom(Addr, 2);

  // Read 2 bytes of data
  // raw_adc msb, raw_adc lsb
  if (Wire.available() == 2)
  {
    data[0] = Wire.read();
    data[1] = Wire.read();
  }
  delay(300);

  // Convert the data
  raw_adc = (((data[0] & 0x0F) * 256) + (data[1] & 0xF0)) / 16 ;

  // Output data to serial monitor
  Serial.print("Digital value of Analog input on Channel 4: ");
  Serial.println(raw_adc);
  delay(500);
}

