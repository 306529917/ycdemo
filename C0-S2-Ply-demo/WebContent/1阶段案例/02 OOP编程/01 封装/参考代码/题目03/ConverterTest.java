package 题目03;

/**
3、编写一个程序，提示用户输入一个以米为单位的度量值，
然后将其换算为英里数、英尺数和英寸数。使用下面的类:
public class Converter{
	 //@param aConversionFactor 换算为目标单位时所使用的乘法因子
		public Converter(double aConversionFactor){…}
	 //@param  fromMeasurement 度量值
	 //@return 换算为目标单位的输入值
	 public double convertTo(double fromMeasurement){…}
}
构造3个与下例类似的实例:
   final double MILE_TO_KM=1.609;  // Java常量定义
   Converter milesToMeters=new Converter(1000*MILE_TO_KM);
*/
public class ConverterTest {
	public static void main(String[] args) {
		// 英里换算公里的因子
		final double MILE_TO_KM = 1.609; // Java常量定义
		// 定义英里换算米的转换对象
		Converter milesToMeters = new Converter(1000 * MILE_TO_KM);
		System.out.println("1000 米换算为英里数：" + milesToMeters.convertTo(1000));
		System.out.println("5000 米换算为英里数：" + milesToMeters.convertTo(5000));
		System.out.println("8888 米换算为英里数：" + milesToMeters.convertTo(8888));

		System.out.println("=================================================");
		// 英尺换算米的因子
		final double FOOT_TO_METER = 0.3048;
		// 定义英尺换算米的转换对象
		Converter footToMeters = new Converter(FOOT_TO_METER);
		System.out.println("1000 米换算为英尺数：" + footToMeters.convertTo(1000));
		System.out.println("5000 米换算为英尺数：" + footToMeters.convertTo(5000));
		System.out.println("8888 米换算为英尺数：" + footToMeters.convertTo(8888));
		
		System.out.println("=================================================");
		// 英尺换算米的因子
		final double INCH_TO_METER = 0.0254;
		// 定义英寸换算米的转换对象
		Converter inchToMeters = new Converter(INCH_TO_METER);
		System.out.println("1000 米换算为英寸数：" + inchToMeters.convertTo(1000));
		System.out.println("5000 米换算为英寸数：" + inchToMeters.convertTo(5000));
		System.out.println("8888 米换算为英寸数：" + inchToMeters.convertTo(8888));
	}
}
