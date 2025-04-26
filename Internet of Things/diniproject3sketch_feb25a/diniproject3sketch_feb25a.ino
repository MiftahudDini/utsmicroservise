#define LDR_PIN A0    // LDR sensor connected to A0
#define TEMP_PIN A1   // LM35 temperature sensor connected to A1
#define MOTOR_PIN 2  // Motor connected to pin 2
#define SPEAKER_PIN 3 // Speaker (buzzer) connected to pin 3

unsigned long previousMillis = 0;
const long interval = 500; // Interval baca sensor setiap 500ms

void setup() {
    Serial.begin(9600); // Start serial communication
    pinMode(MOTOR_PIN, OUTPUT);
    pinMode(SPEAKER_PIN, OUTPUT);
}

void loop() {
    unsigned long currentMillis = millis();

    if (currentMillis - previousMillis >= interval) {
        previousMillis = currentMillis;

        //Membaca nilai suhu dari LM35
        int tempValue = analogRead(TEMP_PIN);
        float temperature = (tempValue * 5.0 / 1023.0) * 100.0; // Konversi ke Celcius

        //Membaca nilai cahaya dari LDR dan mengonversi ke lux
        int ldrValue = analogRead(LDR_PIN);
        float lux = map(ldrValue, 0, 1023, 0, 1000); // Konversi ke lux secara kasar

        //Menampilkan nilai sensor di Serial Monitor
        Serial.print("LDR (Lux): ");
        Serial.print(lux);
        Serial.print(" | Temperature (C): ");
        Serial.println(temperature);

        //Kondisi Kebakaran: Suhu tinggi atau cahaya dari api
        if (temperature >= 50 || lux >= 800) {
            digitalWrite(MOTOR_PIN, HIGH);  //  Nyalakan motor (misalnya kipas atau ventilasi)
            tone(SPEAKER_PIN, 1000);        //  Speaker berbunyi (nada 1 kHz)

            Serial.println(" ALERT: Kebakaran Terdeteksi! Motor dan Alarm AKTIF!");
        } else {
            digitalWrite(MOTOR_PIN, LOW);   // Matikan motor
            noTone(SPEAKER_PIN);            // Matikan alarm

            Serial.println("Normal: Tidak ada kebakaran.");
        }
    }
}
