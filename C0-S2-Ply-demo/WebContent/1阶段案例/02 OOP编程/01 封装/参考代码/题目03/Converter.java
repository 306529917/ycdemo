package 题目03;

public class Converter {
	private double aConversionFactor;

	/**
	 * @param aConversionFactor 换算为目标单位时所使用的乘法因子
	 */
	public Converter(double aConversionFactor) {
		this.aConversionFactor = aConversionFactor;
	}

	/**
	 * @param  fromMeasurement 度量值（单位：米）
	 * @return 换算为目标单位的值
	 */
	public double convertTo(double fromMeasurement) {
		return fromMeasurement / aConversionFactor;
	}
}