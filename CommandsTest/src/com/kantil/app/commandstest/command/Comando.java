package com.kantil.app.commandstest.command;

public enum Comando {

	Code0100("0100", 4, "PIDs supported [01 - 20]"), Code0101(
			"0101",
			4,
			"Monitor status since DTCs cleared."), Code0102(
			"0102", 2, "Freeze DTC"), Code0103("0103", 2, "Fuel system status"), Code0104(
			"0104", 1, "Calculated engine load value", 0, 100, "%", "A*100/255"), Code0105(
			"0105", 1, "Engine coolant temperature", -40, 215, "°C", "A-40"), Code0106(
			"0106", 1, "Short term fuel % trim—Bank 1", -100, 99.22, "%",
			"(A-128)*100/128"), Code0107("0107", 1,
			"Long term fuel % trim—Bank 1", -100, 99.22, "%", "(A-128)*100/128"), Code0108(
			"0108", 1, "Short term fuel % trim—Bank 2", -100, 99.22, "%",
			"(A-128)*100/128"), Code0109("0109", 1,
			"Long term fuel % trim—Bank 2", -100, 99.22, "%", "(A-128)*100/128"), Code010A(
			"010A", 1, "Fuel pressure", 0, 765, "kPa (gauge)", "A*3"), Code010B(
			"010B", 1, "Intake manifold absolute pressure", 0, 255,
			"kPa (absolute)", "A"), Code010C("010C", 2, "Engine RPM", 0,
			16383.75, "rpm", "((A*256)+B)/4"), Code010D("010D", 1,
			"Vehicle speed", 0, 255, "km/h", "A"), Code010E("010E", 1,
			"Timing advance", -64, 63.5, "° relative to #1 cylinder",
			"(A-128)/2"), Code010F("010F", 1, "Intake air temperature", -40,
			215, "°C", "A-40"), Code0110("0110", 2, "MAF air flow rate", 0,
			655.35, "grams/sec", "((A*256)+B)/100"), Code0111("0111", 1,
			"Throttle position", 0, 100, "%", "A*100/255"), Code0112("0112", 1,
			"Commanded secondary air status"), Code0113("0113", 1,
			"Oxygen sensors present"), Code0114A("0114", 2,
			"Bank 1, Sensor 1:Oxygen sensor voltage", 0, 1.275, "Volts",
			"A/200"), Code0114B("0114", 2,
			"Bank 1, Sensor 1:Short term fuel trim", -100, 99.2, "%",
			"(B-128) * 100/128 (if B==$FF, sensor is not used in trim calc)"), Code0115A(
			"0114", 2, "Bank 1, Sensor 2:Oxygen sensor voltage", 0, 1.275,
			"Volts", "A/200"), Code0115B("0114", 2,
			"Bank 1, Sensor 2:Short term fuel trim", -100, 99.2, "%",
			"(B-128) * 100/128 (if B==$FF, sensor is not used in trim calc)"), Code0116A(
			"0114", 2, "Bank 1, Sensor 3:Oxygen sensor voltage", 0, 1.275,
			"Volts", "A/200"), Code0116B("0114", 2,
			"Bank 1, Sensor 3:Short term fuel trim", -100, 99.2, "%",
			"(B-128) * 100/128 (if B==$FF, sensor is not used in trim calc)"), Code0117A(
			"0114", 2, "Bank 1, Sensor 4:Oxygen sensor voltage", 0, 1.275,
			"Volts", "A/200"), Code0117B("0114", 2,
			"Bank 1, Sensor 4:Short term fuel trim", -100, 99.2, "%",
			"(B-128) * 100/128 (if B==$FF, sensor is not used in trim calc)"), Code0118A(
			"0114", 2, "Bank 1, Sensor 5:Oxygen sensor voltage", 0, 1.275,
			"Volts", "A/200"), Code0118B("0114", 2,
			"Bank 1, Sensor 5:Short term fuel trim", -100, 99.2, "%",
			"(B-128) * 100/128 (if B==$FF, sensor is not used in trim calc)"), Code0119A(
			"0114", 2, "Bank 1, Sensor 6:Oxygen sensor voltage", 0, 1.275,
			"Volts", "A/200"), Code0119B("0114", 2,
			"Bank 1, Sensor 6:Short term fuel trim", -100, 99.2, "%",
			"(B-128) * 100/128 (if B==$FF, sensor is not used in trim calc)"), Code011AA(
			"0114", 2, "Bank 1, Sensor 7:Oxygen sensor voltage", 0, 1.275,
			"Volts", "A/200"), Code011AB("0114", 2,
			"Bank 1, Sensor 7:Short term fuel trim", -100, 99.2, "%",
			"(B-128) * 100/128 (if B==$FF, sensor is not used in trim calc)"), Code011BA(
			"0114", 2, "Bank 1, Sensor 8:Oxygen sensor voltage", 0, 1.275,
			"Volts", "A/200"), Code011BB("0114", 2,
			"Bank 1, Sensor 8:Short term fuel trim", -100, 99.2, "%",
			"(B-128) * 100/128 (if B==$FF, sensor is not used in trim calc)"), Code011C(
			"011C", 1, "OBD standards this vehicle conforms to"), Code011D(
			"011D", 1, "Oxygen sensors present"), Code011E("011E", 1,
			"Auxiliary input status"), Code011F("011F", 2,
			"Run time since engine start", 0, 65535, "seconds", "(A*256)+B"), Code0120(
			"0120", 4, "PIDs supported [21 - 40]"), Code0121("0121", 2,
			"Distance traveled with malfunction indicator lamp (MIL) on", 0,
			65535, "km", "(A*256)+B"), Code0122("0122", 2,
			"Fuel Rail Pressure (relative to manifold vacuum)", 0, 5177.265,
			"kPa", "((A*256)+B) * 0.079"), Code0123("0123", 2,
			"Fuel Rail Pressure (diesel, or gasoline direct inject)", 0,
			655350, "kPa (gauge)", "((A*256)+B) * 10"), Code0124A("0124", 4,
			"O2S1_WR_lambda(1):Equivalence Ratio", 0, 1.999, "N/A",
			"((A*256)+B)*2/65535"), Code0124B("0124", 4,
			"O2S1_WR_lambda(1):Voltage", 0, 7.999, "V", "((C*256)+D)*8/65535"), Code0125A(
			"0125", 4, "O2S2_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)*2/65535"), Code0125B("0125", 4,
			"O2S2_WR_lambda(1):Voltage", 0, 8, "V", "((C*256)+D)*8/65535"), Code0126A(
			"0126", 4, "O2S3_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)*2/65535"), Code0126B("0126", 4,
			"O2S3_WR_lambda(1):Voltage", 0, 8, "V", "((C*256)+D)*8/65535"), Code0127A(
			"0127", 4, "O2S4_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)*2/65535"), Code0127B("0127", 4,
			"O2S4_WR_lambda(1):Voltage", 0, 8, "V", "((C*256)+D)*8/65535"), Code0128A(
			"0128", 4, "O2S5_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)*2/65535"), Code0128B("0128", 4,
			"O2S5_WR_lambda(1):Voltage", 0, 8, "V", "((C*256)+D)*8/65535"), Code0129A(
			"0129", 4, "O2S6_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)*2/65535"), Code0129B("0129", 4,
			"O2S6_WR_lambda(1):Voltage", 0, 8, "V", "((C*256)+D)*8/65535"), Code012AA(
			"012A", 4, "O2S7_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)*2/65535"), Code012AB("012A", 4,
			"O2S7_WR_lambda(1):Voltage", 0, 8, "V", "((C*256)+D)*8/65535"), Code012BA(
			"012B", 4, "O2S8_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)*2/65535"), Code012BB("012B", 4,
			"O2S8_WR_lambda(1):Voltage", 0, 8, "V", "((C*256)+D)*8/65535"), Code012C(
			"012C", 1, "Commanded EGR", 0, 100, "%", "A*100/255"), Code012D(
			"012D", 1, "EGR Error", -100, 99.22, "%", "(A-128) * 100/128"), Code012E(
			"012E", 1, "Commanded evaporative purge", 0, 100, "%", "A*100/255"), Code012F(
			"012F", 1, "Fuel Level Input", 0, 100, "%", "A*100/255"), Code0130(
			"0130", 1, "# of warm-ups since codes cleared", 0, 255, "N/A", "A"), Code0131(
			"0131", 2, "Distance traveled since codes cleared", 0, 65535, "km",
			"(A*256)+B"), Code0132("0132", 2, "Evap. System Vapor Pressure",
			-8192, 8192, "Pa",
			"((A*256)+B)/4 (A and B are two's complement signed)"), Code0133(
			"0133", 1, "Barometric pressure", 0, 255, "kPa (Absolute)", "A"), Code0134A(
			"0134", 4, "O2S1_WR_lambda(1):Equivalence Ratio", 0, 1.999, "N/A",
			"((A*256)+B)/32768"), Code0134B("0134", 4,
			"O2S1_WR_lambda(1):Current", -128, 127.99, "mA",
			"((C*256)+D)/256-128"), Code0135A("0135", 4,
			"O2S2_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)/32768"), Code0135B("0135", 4,
			"O2S2_WR_lambda(1):Current", -128, 128, "mA", "((C*256)+D)/256-128"), Code0136A(
			"0136", 4, "O2S3_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)/32768"), Code0136B("0136", 4,
			"O2S3_WR_lambda(1):Current", -128, 128, "mA", "((C*256)+D)/256-128"), Code0137A(
			"0137", 4, "O2S4_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)/32768"), Code0137B("0137", 4,
			"O2S4_WR_lambda(1):Current", -128, 128, "mA", "((C*256)+D)/256-128"), Code0138A(
			"0138", 4, "O2S5_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)/32768"), Code0138B("0138", 4,
			"O2S5_WR_lambda(1):Current", -128, 128, "mA", "((C*256)+D)/256-128"), Code0139A(
			"0139", 4, "O2S6_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)/32768"), Code0139B("0139", 4,
			"O2S6_WR_lambda(1):Current", -128, 128, "mA", "((C*256)+D)/256-128"), Code013AA(
			"013A", 4, "O2S7_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)/32768"), Code013AB("013A", 4,
			"O2S7_WR_lambda(1):Current", -128, 128, "mA", "((C*256)+D)/256-128"), Code013BA(
			"013B", 4, "O2S8_WR_lambda(1):Equivalence Ratio", 0, 2, "N/A",
			"((A*256)+B)/32768"), Code013BB("013B", 4,
			"O2S8_WR_lambda(1):Current", -128, 128, "mA", "((C*256)+D)/256-128"), Code013C(
			"013C", 2, "Catalyst Temperature,Bank 1, Sensor 1", -40, 6513.5,
			"°C", "((A*256)+B)/10 - 40"), Code013D("013D", 2,
			"Catalyst Temperature,Bank 2, Sensor 1", -40, 6513.5, "°C",
			"((A*256)+B)/10 - 40"), Code013E("013E", 2,
			"Catalyst Temperature,Bank 1, Sensor 2", -40, 6513.5, "°C",
			"((A*256)+B)/10 - 40"), Code013F("013F", 2,
			"Catalyst Temperature,Bank 2, Sensor 2", -40, 6513.5, "°C",
			"((A*256)+B)/10 - 40"), Code0140("0140", 4,
			"PIDs supported [41 - 60]"), Code0141("0141", 4,
			"Monitor status this drive cycle"), Code0142("0142", 2,
			"Control module voltage", 0, 65.535, "V", "((A*256)+B)/1000"), Code0143(
			"0143", 2, "Absolute load value", 0, 25700, "%",
			"((A*256)+B)*100/255"), Code0144("0144", 2,
			"Command equivalence ratio", 0, 2, "N/A", "((A*256)+B)/32768"), Code0145(
			"0145", 1, "Relative throttle position", 0, 100, "%", "A*100/255"), Code0146(
			"0146", 1, "Ambient air temperature", -40, 215, "°C", "A-40"), Code0147(
			"0147", 1, "Absolute throttle position B", 0, 100, "%", "A*100/255"), Code0148(
			"0148", 1, "Absolute throttle position C", 0, 100, "%", "A*100/255"), Code0149(
			"0149", 1, "Accelerator pedal position D", 0, 100, "%", "A*100/255"), Code014A(
			"014A", 1, "Accelerator pedal position E", 0, 100, "%", "A*100/255"), Code014B(
			"014B", 1, "Accelerator pedal position F", 0, 100, "%", "A*100/255"), Code014C(
			"014C", 1, "Commanded throttle actuator", 0, 100, "%", "A*100/255"), Code014D(
			"014D", 2, "Time run with MIL on", 0, 65535, "minutes", "(A*256)+B"), Code014E(
			"014E", 2, "Time since trouble codes cleared", 0, 65535, "minutes",
			"(A*256)+B"), Code014F(
			"014F",
			4,
			"Maximum value for equivalence ratio, oxygen sensor voltage, oxygen sensor current, and intake manifold absolute pressure",
			0, 255, "N/A,V, mA, kPa", "A, B, C, D*10"), Code0150("0150", 4,
			"Maximum value for air flow rate from mass air flow sensor", 0,
			2550, "g/s", "A*10, B, C, and D are reserved for future use"), Code0151(
			"0151", 1, "Fuel Type"), Code0152("0152", 1, "Ethanol fuel %", 0,
			100, "%", "A*100/255"), Code0153("0153", 2,
			"Absolute Evap system Vapor Pressure", 0, 327.675, "kPa",
			"((A*256)+B)/200"), Code0154("0154", 2,
			"Evap system vapor pressure", -32767, 32768, "Pa",
			"((A*256)+B)-32767"), Code0155("0155", 2,
			"Short term secondary oxygen sensor trim bank 1 and bank 3", -100,
			99.22, "%", "(A-128)*100/128 (B-128)*100/128"), Code0156("0156", 2,
			"Long term secondary oxygen sensor trim bank 1 and bank 3", -100,
			99.22, "%", "(A-128)*100/128 (B-128)*100/128"), Code0157("0157", 2,
			"Short term secondary oxygen sensor trim bank 2 and bank 4", -100,
			99.22, "%", "(A-128)*100/128 (B-128)*100/128"), Code0158("0158", 2,
			"Long term secondary oxygen sensor trim bank 2 and bank 4", -100,
			99.22, "%", "(A-128)*100/128 (B-128)*100/128"), Code0159("0159", 2,
			"Fuel rail pressure (absolute)", 0, 655350, "kPa", "((A*256)+B)*10"), Code015A(
			"015A", 1, "Relative accelerator pedal position", 0, 100, "%",
			"A*100/255"), Code015B("015B", 1,
			"Hybrid battery pack remaining life", 0, 100, "%", "A*100/255"), Code015C(
			"015C", 1, "Engine oil temperature", -40, 210, "°C", "A - 40"), Code015D(
			"015D", 2, "Fuel injection timing", -210.00, 301.992, "°",
			"(((A*256)+B)-26,880)/128"), Code015E("015E", 2,
			"Engine fuel rate", 0, 3212.75, "L/h", "((A*256)+B)*0.05"), Code015F(
			"015F", 1, "Emission requirements to which vehicle is designed"), Code0160(
			"0160", 4, "PIDs supported [61 - 80]"), Code0161("0161", 1,
			"Driver's demand engine - percent torque", -125, 125, "%", "A-125"), Code0162(
			"0162", 1, "Actual engine - percent torque", -125, 125, "%",
			"A-125"), Code0163("0163", 2, "Engine reference torque", 0, 65535,
			"Nm", "A*256+B"), Code0164(
			"0164",
			5,
			"Engine percent torque data",
			-125,
			125,
			"%",
			"A-125 Idle B-125 Engine point 1 C-125 Engine point 2 D-125 Engine point 3 E-125 Engine point 4"), Code0165(
			"0165", 2, "Auxiliary input / output supported"), Code0166("0166",
			5, "Mass air flow sensor"), Code0167("0167", 3,
			"Engine coolant temperature"), Code0168("0168", 7,
			"Intake air temperature sensor"), Code0169("0169", 7,
			"Commanded EGR and EGR Error"), Code016A(
			"016A",
			5,
			"Commanded Diesel intake air flow control and relative intake air flow position"), Code016B(
			"016B", 5, "Exhaust gas recirculation temperature"), Code016C(
			"016C", 5,
			"Commanded throttle actuator control and relative throttle position"), Code016D(
			"016D", 6, "Fuel pressure control system"), Code016E("016E", 5,
			"Injection pressure control system"), Code016F("016F", 3,
			"Turbocharger compressor inlet pressure"), Code0170("0170", 9,
			"Boost pressure control"), Code0171("0171", 5,
			"Variable Geometry turbo (VGT) control"), Code0172("0172", 5,
			"Wastegate control"), Code0173("0173", 5, "Exhaust pressure"), Code0174(
			"0174", 5, "Turbocharger RPM"), Code0175("0175", 7,
			"Turbocharger temperature"), Code0176("0176", 7,
			"Turbocharger temperature"), Code0177("0177", 5,
			"Charge air cooler temperature (CACT)"), Code0178("0178", 9,
			"Exhaust Gas temperature (EGT) Bank 1"), Code0179("0179", 9,
			"Exhaust Gas temperature (EGT) Bank 2"), Code017A("017A", 7,
			"Diesel particulate filter (DPF)"), Code017B("017B", 7,
			"Diesel particulate filter (DPF)"), Code017C("017C", 9,
			"Diesel Particulate filter (DPF) temperature"), Code017D("017D", 1,
			"NOx NTE control area status"), Code017E("017E", 1,
			"PM NTE control area status"), Code017F("017F", 13,
			"Engine run time"), Code0180("0180", 4, "PIDs supported [81 - A0]"), Code0181(
			"0181", 21,
			"Engine run time for Auxiliary Emissions Control Device(AECD)"), Code0182(
			"0182", 21,
			"Engine run time for Auxiliary Emissions Control Device(AECD)"), Code0183(
			"0183", 5, "NOx sensor"), Code01A0("01A0", 4,
			"PIDs supported [A1 - C0]"), Code01C0("01C0", 4,
			"PIDs supported [C1 - E0]"), Code0900("0900", 4,
			"Mode 9 supported PIDs (01 to 20)"), Code0901(
			"0901",
			1,
			"VIN Message Count in PID 02. Only for ISO 9141-2, ISO 14230-4 and SAE J1850.",
			"Usually value will be 5."), Code0902(
			"0902",
			17,
			"Vehicle Identification Number (VIN)",
			"17-char VIN, ASCII-encoded and left-padded with null chars (0x00) if needed to."), Code0903(
			"0903",
			1,
			"Calibration ID message count for PID 04. Only for ISO 9141-2, ISO 14230-4 and SAE J1850.",
			"It will be a multiple of 4 (4 messages are needed for each ID)."), Code0904(
			"0904",
			16,
			"Calibration ID",
			"Up to 16 ASCII chars. Data bytes not used will be reported as null bytes (0x00)."), Code0905(
			"0905",
			1,
			"Calibration verification numbers (CVN) message count for PID 06. Only for ISO 9141-2, ISO 14230-4 and SAE J1850."), Code0906(
			"0906",
			4,
			"Calibration Verification Numbers (CVN)",
			"Raw data left-padded with null characters (0x00). Usually displayed as hex string."), Code0907(
			"0907",
			1,
			"In-use performance tracking message count for PID 08 and 0B. Only for ISO 9141-2, ISO 14230-4 and SAE J1850.",
			8,
			10,
			"N/A",
			"8 if sixteen (16) values are required to be reported, 9 if eighteen (18) values are required to be reported, and 10 if twenty (20) values are required to be reported (one message reports two values, each one consisting in two bytes)."), Code0908(
			"0908", 4,
			"In-use performance tracking for spark ignition vehicles",
			"4 or 5 messages, each one containing 4 bytes (two values)."), Code0909(
			"0909", 1, "ECU name message count for PID 0A"), Code090A("090A",
			20, "ECU name", "ASCII-coded. Right-padded with null chars (0x00)."), Code090B(
			"090B", 4,
			"In-use performance tracking for compression ignition vehicles",
			"5 messages, each one containing 4 bytes (two values).");

	private Comando(String codigo, int dataBytes, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataBytes = dataBytes;
		this.min = 0;
		this.max = 0;
		this.unidade = "";
		this.formula = "";
	}

	private Comando(String codigo, int dataBytes, String descricao, double min,
			double max, String unidade, String formula) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataBytes = dataBytes;
		this.min = min;
		this.max = max;
		this.unidade = unidade;
		this.formula = formula;
	}

	private Comando(String codigo, int dataBytes, String descricao,
			String formula) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataBytes = dataBytes;
		this.min = 0;
		this.max = 0;
		this.unidade = "";
		this.formula = formula;
	}

	private String codigo;
	private String descricao;
	private boolean responde;
	private String result;
	private int dataBytes;
	private double min;
	private double max;
	private String unidade;
	private String formula;

	/**
	 * @return the responde
	 */
	public boolean isResponde() {
		return responde;
	}

	/**
	 * @param responde
	 *            the responde to set
	 */
	public void setResponde(boolean responde) {
		this.responde = responde;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the dataBytes
	 */
	public int getDataBytes() {
		return dataBytes;
	}

	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}

	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}

	/**
	 * @return the unidade
	 */
	public String getUnidade() {
		return unidade;
	}

	/**
	 * @return the formula
	 */
	public String getFormula() {
		return formula;
	}
}