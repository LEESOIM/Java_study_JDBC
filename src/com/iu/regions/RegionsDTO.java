package com.iu.regions;

public class RegionsDTO {
	
	//멤버변수 접근지정자 : private
	//private -> Getter/Setter
	//기본생성자 필수(생략)
	//멤버변수명은 Table의 컬럼명과 동일하게 선언
	private Integer region_id; //데이터에 null이 있을수도 있기 때문에 레퍼런스타입인 Integer로 해주자!
	private String region_name;
	
	
	public Integer getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

}
