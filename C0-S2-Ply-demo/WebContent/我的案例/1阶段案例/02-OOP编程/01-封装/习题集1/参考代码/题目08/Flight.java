/**
 * 航班
 */
public class Flight {
	
	/**
	 * 航班号
	 */
	String flightNo;
	
	/**
	 * 航空公司名称
	 */
	String CompanyName;
	
	/**
	 * 航空公司代号
	 */
	String CompanyNo;
	
	/**
	 * 航班日期
	 */
	String flyDate;
	
	/**
	 * 出发地
	 */
	String srcPlace;
	
	/**
	 * 目的地
	 */
	String destPlace;
	/**
	 * 起飞时间
	 */
	String startTime;
	/**
	 * 到达时间
	 */
	String endTime;
	/**
	 * 里程
	 */
	String length;
	/**
	 * 剩余座位
	 */
	String placeNum;
	/**
	 * 全价
	 */
	String price;
	/**
	 * 折扣率
	 */
	String rate;
	
	/**
	 * 使用飞机
	 */
	private Plane plane;

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getCompanyNo() {
		return CompanyNo;
	}

	public void setCompanyNo(String companyNo) {
		CompanyNo = companyNo;
	}

	public String getFlyDate() {
		return flyDate;
	}

	public void setFlyDate(String flyDate) {
		this.flyDate = flyDate;
	}

	public String getSrcPlace() {
		return srcPlace;
	}

	public void setSrcPlace(String srcPlace) {
		this.srcPlace = srcPlace;
	}

	public String getDestPlace() {
		return destPlace;
	}

	public void setDestPlace(String destPlace) {
		this.destPlace = destPlace;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getPlaceNum() {
		return placeNum;
	}

	public void setPlaceNum(String placeNum) {
		this.placeNum = placeNum;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
}
